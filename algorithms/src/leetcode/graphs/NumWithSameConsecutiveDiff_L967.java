package leetcode.graphs;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/numbers-with-same-consecutive-differences/description/
 * 967. Numbers With Same Consecutive Differences
 * Difficulty - Medium

 * Given two integers n and k, return an array of all the integers of length n where the difference between every two consecutive digits is k. You may return the answer in any order.
  Note that the integers should not have leading zeros. Integers as 02 and 043 are not allowed.

Example 1:

Input: n = 3, k = 7
Output: [181,292,707,818,929]
Explanation: Note that 070 is not a valid number, because it has leading zeroes.

Example 2:

Input: n = 2, k = 1
Output: [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]

Constraints:

    2 <= n <= 9
    0 <= k <= 9

 *
 */

/*
 * Decipher the problem: At a highlevel it doesnt look like a graph problem.
 * However, if you look into the examples , you will see that [181, 292, 707, 818, 929]
 * in each number 
 * diff between 1 and 8 is 7 . Diff between 8 and 1 is 7
 * diff between 2 and 9 is 7 and between 9 and 2 is 7
 * diff between 7 and 0 is 7 and betweeen 0 and 7 is 7
 * 
 * this can easily charted as a graph 1->8 with a weight/edge of 7 
 * and 2 -> 9 with a edge/weight of 7
 * 
 * Next check if this is a bidirectional graph or directional? 
 *  1 -> 8 weight is 7 and 8-> 1 weight is 7
 *  so its bidirectional
 * 
 * next check if this is a graph or a tree
 * next check if this is cyclic 
 * 
 * Also notice that the first element of each number can be easily determined 
 * eg: first elemetns can be 
 * 1 _ _
 * 2 _ _
 * 3 _ _ ( cannot be 3 becaue 3+7 = 10 and we need the num length/size to be n=3 and not more than 3
 * so all nums starting with 4 , 5, 6 cannot be in the output
 * num with 7 can be there since 7 - 7 = 0; however 070 is not a valid num of length 3 and hence 0 cannot be the starting digit
 * 
 * This looks like a graph where 1 <-> 8 , 2 <-> 9 , 7<->0 are nodes and edges.
 * we can use either DFS or BFS to traverse and find the list of output integers
 * 
 */

public class NumWithSameConsecutiveDiff_L967 {

	public static void main(String[] args) {
		int n = 3 , k = 7;
		int[] output = numsSameConsecDiff(n,k);
        for (int j : output) System.out.println(j);
		
	}
	
	public static int[] numsSameConsecDiff(int n, int k) {
		/// you can see that the return should be a list of numbers. so return type is int[]
		// here n is the length/numofdigits in the output numbers, k
		//we will use a list for this implementation, the the end we will convert to an array and return it.
		List<Integer> result = new ArrayList<>();
		
		// you know that the first digit can be 1 to 9 so we will form a loop with 1 to 9
		// we will call a recurrsive dfs function within the loop
		for(int num = 1;num<=9;num++) {
			// create a dfs recurrive function 
			// the params for this are :
			//  'num' the number you are starting with
			//   length of the num should be n but you have already considerd first digit to be num and hence second param is n-1
			//   k is the edge weight
			//   result list
			dfs(num, n-1,k, result);
		}
		
				
		// return array to convert the resultlist into an array and return it
		int[] returnarray = new int[result.size()];
		for(int i = 0;i<result.size();i++)
			returnarray[i] = result.get(i);
		
		return returnarray;
	}

	
	
	private static void dfs(int num, int n, int k, List<Integer> result) {
		
		// base condition
		// with every recursive call , n is reducing , it should stop when n becomes 0
		if(n==0) {
			// when n is 0 , you have found your number, so add it to result list and return to the prev call
			result.add(num);
			return;
		}
		
		// now for the next recursive call
		// in first recursive call , num is having one digit 1 to 9
		// in second recursive call, num will have 2 digits like 81, or 92 etc
		// so to find the next number, you need to add k ( in this case 7 ) to the second digit of the num. 
		// so u need to get the second digit or last digit from num ie - you need 2 from 92 ,and add or subtract 7 to 2 to find out the next num.
		// so we will use % to get the last digit of num
		int lastdigit = num%10;
		
		// in my next iteration, i need to ensure i can add k or sub k to the last digit. 
		// i also need to ensure that digit formed after addign k is between 0 to 9 and it does become negative or double digit
		
		if(lastdigit +k <=9) {
			// multiple num by 10 to make it a 3 digit : eg if num was 81 then 81*10 = 810 , add last digit + k , 810 + 1 + 7 = 818
			dfs(num*10+lastdigit+k, n-1,k,result);
		}
		// same check if the num doesnt go negative and then call the dfs recursive
		// edge case handling k!=0
		if(k!=0 && lastdigit - k>=0) {
			dfs(num*10 +lastdigit -k, n-1,k,result);
		}
	
		// one of the edge cases to handle or ask the interviewr is what happens if k = 0
		// so we will get numbers like 111, 222, 333 etc where k=0 works.
		// but since we do two recursive call once for +k and once for -k, we will get these numbers duplicate.
		// so we should check if k!=0 in one of the if conditions above to ensure we dont get repeated numbers in edge case of k=0;
}
	

}
