package patterns.practice.Feb2025.fastandslow;

import java.util.ArrayList;

public class happyNumber {
	
		public static void main(String[] args) {
			
			int[] input = {2147483646,1,19,8,7};
			
			for(int i : input) {
				System.out.println("Is "+i+" a Happy number: "+ isHappyNumber(i));
			}
		}
	
	

	    public static boolean isHappyNumber(int n) {

	        int num = n;
	        ArrayList<Integer> digitsumList = new ArrayList<>();
	        
	        while(true){
	         // System.out.println("Entering while num : "+num);
	          num = getSumofDigits(num);
	         // System.out.println("After get sum num : "+num);
	          if(num == 1){
	            return true;
	          }
	          else if(!digitsumList.contains(num))
	          {
	            digitsumList.add(num);
	          }
	          else{
	            return false;
	          }

	          
	        }
	      //  return false;
	    }
	    
	    public static int getSumofDigits(int num){
	     //  System.out.println("Entering get sum num : "+num);
	      int sum = 0;
	      while(num!=0){
	        int remainder = num%10;
	      //  System.out.println("Sum= "+sum+" Remainder : "+remainder);
	        
	        sum = sum + (remainder*remainder);
	       // System.out.println("After calc: Sum= "+sum+" Remainder : "+remainder);
	        num = num/10;
	       // System.out.println("New num " +num);
	      }
	      return sum;
	      
	    }


}
