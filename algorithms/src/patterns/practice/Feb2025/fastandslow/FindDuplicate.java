package patterns.practice.Feb2025.fastandslow;

import java.util.Arrays;
import java.util.HashSet;

public class FindDuplicate{
   public static int findDuplicate(int[] nums) {
      
      int size = nums.length;
      HashSet<Integer> exists = new HashSet<>();
      for(int i = 0; i<size;i++){
        if(exists.contains(nums[i]))
          return nums[i];
        else 
          exists.add(nums[i]);
      }
      
      return 0;
   }
   
   
   public static void main(String[] args) {
	  int[] nums =  {1,3,6,2,7,3,5,4};
	  
	  System.out.println(findDuplicate(nums));
   }
}
