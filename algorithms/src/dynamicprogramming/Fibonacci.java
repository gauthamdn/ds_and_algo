package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

	static Map<Integer, Integer> cache = new HashMap();

	public static void main(String[] args) {
	
	int n = 10;
	for(int i=0;i<n;i++)
	  System.out.print(fib(i)+" ");
	  

	}
	
	public static int fib(int n) {
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        
        if(cache.get(n)!=null)
            return cache.get(n);
        
        int fibNvalue = fib(n-1)+fib(n-2);
        cache.put(n,fibNvalue);
        return fibNvalue;
    }

}
