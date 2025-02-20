package patterns.practice.Feb2025.twopointers;

import java.util.Arrays;

public class softColors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] colors = {0,1,0};
		//[2,2]
		//[1,1,0,2]
		//[2,1,1,0,0]
		
		System.out.println(Arrays.toString(sortColors(colors)));

	}
	

	    public static int[] sortColors (int[] colors) {

	        int size = colors.length;
	        int start = 0;
	        int curr = 0;
	        int end = colors.length-1;
	        
	        
	        while(curr<=end){
	          //System.out.println("curr = "+curr+" ,colors[curr] =  "+colors[curr]+" ,colors[start] =  "+colors[start]+" ,colors[end] =  "+colors[end]);
	          if(colors[curr] == 0){
	            int temp = colors[start];
	            colors[start] = colors[curr];
	            colors[curr] = temp;
	            //System.out.println("Running start++, curr++");
	            start++;
	            curr++;
	          } 
	          else if(colors[curr] == 1){
	           // System.out.println("Inside 1 Running curr++");
	            curr++;
	          }
	          else{
	            int temp = colors[end];
	            colors[end] = colors[curr];
	            colors[curr] = temp;
	           // System.out.println("Inside 2 Running end--");
	            end--;
	          }
	          
	          
	        }
	        
	        

	        return colors;
	    }
	

}
