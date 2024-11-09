package leetcode.graphs;

import java.util.ArrayList;
import java.util.List;

public class NumWithSameConsecDiff_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int n = 4  ,k =3;
		
		int[] result = numWithSameConsecDiff( n,  k);
		for(int i = 0;i<result.length;i++)
			System.out.println(result[i]);
		




	}

	private static int[] numWithSameConsecDiff(int n, int k) {
		
		List<Integer> res = new ArrayList<>();
		
		// Step1: fill the first digit in the num. You know num can be 1 <num<9
		// we will call the recursive function inside
		for(int num=1;num<9;num++)
			dfs(num,n-1,k,res);
		
		
		
		int[] retres = new int[res.size()];
		for(int i =0;i<retres.length;i++) {
			retres[i]= res.get(i);
		}
		return retres;
	}

	private static void dfs(int num, int n, int k, List<Integer> res) {
		
		// Step2 : base condition - recurssion will continue with n-1 .. so when n ==0 the recurrsion should stop
		// so in base condition, you will have the num - add it to the list and return
		
		if(n==0) {
			res.add(num);
			return;
		}
		
		// Step 3 : creating subproblem for recurrsion . when second digit is added the num can be 81, 29 .. so we need to take out the last digit and add or sub k to it
		
		int lastdigit = num%10;
		
		// step 4: write for num *10 to make it a 3 digit num, add the last digit and k
		if(lastdigit+k <=9) {
			dfs(num*10+lastdigit+k,n-1,k,res);
		}
		
		// step 5: write for num *10 to make it a 3 digit num, add the last digit and subtract k
		// edge case scenario to ask , if k is 0 , both the recursive calls return same nums eg: 111, 222, 333 etc. so we will have duplicates.
		// hence we add a check for k !=0 in second recursive call to handle this edge case of k-0;
		if(k!=0 && lastdigit-k >=0) {
			dfs(num*10+lastdigit-k,n-1,k,res);
		}
		
		
		
		
	}

}
