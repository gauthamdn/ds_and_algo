package patterns.twopointers;

import java.util.HashMap;
import java.util.Map;

public class Strobogrammatic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  
		System.out.println(isStrobogrammatic("808"));
		
		
		String[] nums = {
		            "609",
		            "88",
		            "962",
		            "101",
		            "123"
		        };

		        int i = 0;
		        for (String num : nums) {
		            System.out.println((i + 1) + ".\tnum: " + num);
		            System.out.println("\n\tIs strobogrammatic: " + (isStrobogrammatic(num) ? "true" : "false"));
		            System.out.println(new String(new char[100]).replace("\0", "-"));
		            i++;
		        }
		    }
		
		

	
	
	 public static boolean isStrobogrammatic (String num) 
	    {
	      
	        Map<Integer,Integer> map = new HashMap<>();
	        
	        map.put(0,0);
	        map.put(1,1);
	        map.put(6,9);
	        map.put(8,8);
	        map.put(9,6);
	        
	        int start = 0;
	        int end = num.length()-1;
	        
	        
	        
	        
	        while(start<=end){
	          int num1 = Integer.parseInt(String.valueOf(num.charAt(start)));
	          int num2 = Integer.parseInt(String.valueOf(num.charAt(end)));
	          
	          if(map.get(num1) == num2){
	            start++;
	            end --;
	          } else{
	            return false;
	          }
	          
	        }
	        
	        return true;
	        
	        
	      
	        //return false;
	    }

}
