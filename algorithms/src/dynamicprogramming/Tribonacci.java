package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class Tribonacci {
	
	static Map<Integer, Integer> cache = new HashMap();

	public static void main(String[] args) {
	
	int n = 100;
	for(int i=0;i<n;i++)
	  System.out.print(tribonacci(i)+" ");
	  

	}
	

	    public static int tribonacci(int n) {
	        
	        if(n==0)
	            return 0;
	        if(n==1 || n == 2)
	            return 1;
	        if(cache.get(n)!=null)
	            return cache.get(n);
	        int tribValue = tribonacci(n-1)+ tribonacci(n-2)+ tribonacci(n-3);
	        cache.put(n,tribValue);
	        return tribValue;
	       // return tribonacci(n-1)+ tribonacci(n-2)+ tribonacci(n-3);
	    }

}
