package patterns.practice.Feb2025.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threesum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = {-1,0,1,2,-1,-4};
		
		//int[] nums = {-3,-2,-1,0,1,2,3};
		// int[] nums = {-4,-2,-2,-2,0,2,2,2,4};
		
		
		List<List<Integer>> result1 = threeSum(nums);
		
		for(List list : result1) {
			
				System.out.println(list);
			
			
		}
		

	}
	
	
	
	public static List<List<Integer>> threeSum(int[] nums) {
	     // initialize 3 variables i = first element, j = second element , k = last element in the array 
	      int size = nums.length;
	      //[-1,0,1,2,-1,-4]
	      //[-4,-1,-1,0,1,2]
	      Arrays.sort(nums);
	      //int k = nums.length-1;
	      
	      System.out.println(Arrays.toString(nums));
	      ArrayList<List<Integer>> result = new ArrayList<>();
	      
	      for(int i = 0; i<size;i++){
	    	  int j = i+1;
	    	  int k = size-1;
	       
	       while(j<k) {
	    	   int sum = nums[i]+ nums[j]+nums[k];
	    	   
	    	   if(sum==0) {
	    		   ArrayList<Integer> list = new ArrayList<Integer>();
		            list.add(nums[i]);
		            list.add(nums[j]);
		            list.add(nums[k]);
		            // add only if this doesnt exist in results ( unique triplets )
		           if (!result.contains(list)) {
                           result.add(list);
                }
		           // System.out.println(" i="+nums[i]+" j="+nums[j]+" k="+nums[k]);
		            j++;
	    
	    	   }
	    	   else if(sum<0) {
	    		   j++;
	    	   }else {
	    		   k--;
	    	   }
	       }
	       
	      }
	      
	     // HashSet<List<Integer>> uniqueValues = new HashSet<>(result);
	      
	   //   ArrayList<List<Integer>> result2 = new ArrayList<>();
	      
	    //  for(List<Integer> list : uniqueValues){
	    //    result2.add(list);
	    //  }
	      
	      
	      return result;
	   }
	
	
	

}




