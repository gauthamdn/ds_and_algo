package leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String[] input = {"III","LVIII","MCMXCIV"};
		
		for(int i = 0;i<input.length;i++) {
			
			int result = romanToInt(input[i]);
			System.out.println("Roman : "+input[i]+" -> "+result);
			
		}
		
	}
	

	    public static int romanToInt(String s) {
	        

	        Map<Character,Integer> roman_int_map = new HashMap<Character,Integer>();

	        roman_int_map.put('I',1);
	        roman_int_map.put('V',5);
	        roman_int_map.put('X',10);
	        roman_int_map.put('L',50);
	        roman_int_map.put('C',100);
	        roman_int_map.put('D',500);
	        roman_int_map.put('M',1000);


	    

	        char[] charArray = s.toCharArray();
	        int sum = 0;
	     
	        for(int i = 0;i<s.length();i++){
	            int value =0;
	            
	            if(i+1<s.length()){
	                if(roman_int_map.get(charArray[i])<roman_int_map.get(charArray[i+1]))
	                {
	                    //roman_num = concat(charArray[i],charArray[i+1]);
	                    value = roman_int_map.get(charArray[i+1]) - roman_int_map.get(charArray[i]);
	                    i++;
	                 }else{
	                    value = roman_int_map.get(charArray[i]);
	                 }
	                 sum = sum + value;
	            }
	            else{
	                value = roman_int_map.get(charArray[i]);
	                sum = sum + value;
	            }

	        }
	        
	      
	      return sum;

	    }
	

}
