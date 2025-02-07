package patterns.practice.Feb2025.fastandslow;

public class circularArray {
	
	////NOT WORKING CODE

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//int[] nums = {1,3,-2,-4,1};
		//int[] nums1 = {5,4,-2,-1,3};
		//int[] nums2 = {1,2,-3,3,4,7,1};
		int[] nums3 = {3,3,1,-1,2};
		//int[] nums4 = {2,1,-1,-2};
	//	System.out.println(circularArrayLoop(nums));
	//	System.out.println("1"+circularArrayLoop(nums1));
	//	System.out.println("2"+circularArrayLoop(nums2));
		System.out.println("3"+circularArrayLoop(nums3));
	//	System.out.println("4"+circularArrayLoop(nums4));

	}
	
	
	public static boolean circularArrayLoop(int[] nums) {
	      
	      int size = nums.length;  
	      int start = 0;
	      int curr = 0;
	      
	      for(int i = 0;i<size;i++){
	        start = i;
	        curr = i;
	        Boolean cycleExists = false;
	        int count = 0;
	       
 
	        while(!cycleExists) {
	        	curr = (curr + nums[curr])%size;
	        	if(curr == start)
	        		cycleExists = true;
	        }
	        
	        if(cycleExists)
	        	return true;
	        
	       /* 
	        while(!cycleExists){
	          System.out.println("Start= "+start+" curr= "+curr+ " nums[curr]="+nums[curr]+" >curr + nums[curr]<= "+(curr + nums[curr]));
	          if(curr + nums[curr]>size-1)
	            curr = curr+nums[curr] - size;
	          else if(curr + nums[curr]< 0)
	            curr = curr+nums[curr] + size;
	          else
	            curr = curr+nums[curr];
	          count++;
	          
	          if(start == curr && count>1)
	            cycleExists = true;
	          
	        } */
	        
	      }
	    
	      return false;
	   }

}
