package leetcode.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumWithSameConsecDiff_bfs_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int n = 3  ,k =7;
		
		int[] result = numWithSameConsecDiff( n,  k);
		for(int i = 0;i<result.length;i++)
			System.out.println(result[i]);
		

	}

	private static int[] numWithSameConsecDiff(int n, int k) {
		
		List<Integer> res = new ArrayList<>();
		
		// step1  : create a queue
		Queue<Integer> q = new LinkedList<>();
		
		// Step2: fill the queue with the digits that can be first digit. which is 1 to 0. because num can be 1 <num<9
		
		for(int num=1;num<=9;num++)
			q.add(num);
		
		// Step3: how do we start bfs? using while there is a elem in queue.. keep looping
		
		// step10: introduce a len var
		int len = 1;
		
		while(!q.isEmpty() && len<n) {
			//step 11: increment len
			len++;
			int size = q.size();
			//step 8: put the below steps in a for loop of i =0 and queue size. This is needed to loop through each level in the graph as we do in bfs.
			// step9: also in the below code, we have not kept a check on lenght of 3, so  we need to introduce a var len to keep a check of legnth n . this needs to be added to while condition above itself.
			for(int i =0; i<size;i++) {
			
				// step4 q.remove to get the first num
				int currnum = q.remove(); // remove the first num from queue
				
				// step5 : get the last digit 
				int lastdigit = currnum %10;
				
				// step6 : conditions remain same - check if last digit + k <=0 and lastdigit -k >=0 and add those nums to the queue. handle edge case of k==0
				if(lastdigit + k <=9) {
					q.add(currnum*10+lastdigit+k);
				// step7: add k!= 0 to handle the edge case of k == 0, so we dont get duplicate nums in output	
				if(k!=0 && lastdigit -k >=0) {
					q.add(currnum*10+lastdigit-k);
				}
			
			}
			
			
				
			}
		}
		
		
		// step 12: loop through the values left in the queue and add it to result list
		while(!q.isEmpty()) {
			res.add(q.remove());
		}
		
		
		
		int[] retres = new int[res.size()];
		for(int i =0;i<retres.length;i++) {
			retres[i]= res.get(i);
		}
		return retres;
	}

	private static void dfs(int num, int n, int k, List<Integer> res) {
		
		
		
		
		
		
	}

}
