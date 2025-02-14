package timedPractice;

import java.util.HashMap;
import java.util.Map;

// 70. Climbing Stairs
// https://leetcode.com/problems/climbing-stairs/ 


public class ClimbingStairs {

	//STEP 3: Memoization cache
	static Map<Integer, Integer> cache = new HashMap<>();
	
	public static void main(String[] args) {
		System.out.println(climbStairs(4));

	}

	private static int climbStairs(int n) {
		
		//Step1: base condition
		if(n == 0 || n == 1 )
			return 1;
		
		// STEP4: Check if value exists in cache for recursive calls
		if(cache.get(n)!=null)
			return cache.get(n);
		
		
		//Step2: write the recursive function. 
		// num of ways of climbing stairs for n steps is = num of ways of climing n-1 + n-2 steps
		// this is because in case of step1 there is only 1 way, in case of 2steps ( we can climb 1step by 1step ) or ( we can climb 2 steps at a time ) 
		// so its f(n) = f(n-1) + f(n-2)
		int numOfWays = climbStairs(n-1) + climbStairs(n-2);
		
		//STEP5 : Store the value calculated numOfways in cache for later usage
		cache.put(n, numOfWays);
		
		return numOfWays;
		
	}
	
	
	
	
	// STEP3: To improve the timecomplexity , use Memoization.
	// implement a cache and store the value in the cache. And use it to check if value exists for every recursive call

}
