package patterns.twopointers;

import java.util.Arrays;

public class MinMovesforPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String input = "arcacer";
		System.out.println(minMovesToMakePalindrome(input));
	}
	
	
	public static int minMovesToMakePalindrome(String s) {
        int moves = 0;
        
        int j = s.length() -1;
        char[] c = s.toCharArray();
       
         for(int i =0;i<=j;i++){
           int k = j;

           for(;i<k;k--){
             if(c[i] == c[k]){
               while(k<j){
                 //swap(c[k],c[k+1]);
            	   System.out.println("Moves:"+moves);
            	   System.out.println("Before swap: "+Arrays.toString(c));
            	   System.out.println("Swapping c["+k+"], c["+k+1+"]) swapping char: "+c[k]+","+ c[(k+1)] );
            	   
                 char temp = c[k];
                 c[k] = c[k+1];
                 c[k+1] = temp;
                  k++;
                  moves++;
                  System.out.println("After swap: "+Arrays.toString(c));
               }
               j--;
               break;
             }
             
           }
           
           if(i==k) {
        
        	   int mid = c.length/2;
        	   while(k<mid) {
        		   moves++;
        		   k++;
        	   }
        	   while(k>mid) {
        		   moves++;
        		   k--;
        	   }

           }
           
         }

       return moves;
    }

}
