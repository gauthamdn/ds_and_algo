package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairsProblem {
	 static Map<Integer, Integer> cache = new HashMap();

	public static void main(String[] args) {
		
		int n = 4;
		for(int i=0;i<n;i++)
		  System.out.print(climbStairs(i)+" ");
		  

	}
	

	public static int climbStairs(int n) {
	           if(n==0 || n==1 )
	                return 1;
	            if(cache.get(n)!=null) 
	                return cache.get(n);
	            
	            int numOfWays = climbStairs(n-1) + climbStairs(n-2);
	            cache.put(n,numOfWays);
	            return numOfWays;
	       // return climbStairs(n-1)+ climbStairs(n-2);
	}
	

}
