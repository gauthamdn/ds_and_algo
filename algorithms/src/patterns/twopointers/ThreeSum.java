package patterns.twopointers;

import java.util.Arrays;

/*
 * Concept:
 * 1. Sort the input array in ascending order.
 * 2. Iterate over the entire sorted array to find the triplet whose sum is equal to the target.
 * 3. In each iteration, make a triplet by storing the current array element and the other two elements using two pointers (low and high), and calculate their sum.
 * 4. Adjust the calculated sum value, until it becomes equal to the target value, by conditionally moving the pointers, low and high.
 * 5. Return TRUE if the required sum is found. Otherwise, return FALSE.
 * 
 * Timecomplexity -> 
 * 	sorting of array takes O(nlog(n))
 * nested loop takes O(n^2)
 * so time complexity is O(nlog(n) + n^2) = O(n^2)
 * 
 * Space complexity - >
 * Arrays.sort() space complexity is O(log(n))
 * and hence its the space complexity
 */


public class ThreeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = {1,-1,0};
		int target = -1;
		
		System.out.println(findSumOfThree(nums,target));
		
		int[] nums1 = {3,7,1,2,8,4,5};
		int target1 = 10;
		
		System.out.println(findSumOfThree(nums1,target1));
		
		int[] nums2 = {3,7,1,2,8,4,5};
		int target2 = 31;
		
		System.out.println(findSumOfThree(nums2,target2));
		
		
			int[][] numsList = {{3, 7, 1, 2, 8, 4, 5},
	                       {-1, 2, 1, -4, 5, -3},
	                       {2, 3, 4, 1, 7, 9},
	                       {1, -1, 0},
	                       {2, 4, 2, 7, 6, 3, 1}};
						   
			int[] testList = {10, 7, 20, -1, 8};

			
			for (int i=0; i<testList.length; i++) {
				System.out.print(i+1);
				System.out.println(".\tInput array: " + Arrays.toString(numsList[i]));
				
				if (findSumOfThree(numsList[i], testList[i])) {
				System.out.println("\tSum for " + testList[i] + " exists ");
				} else {
				System.out.println("\tSum for " + testList[i] + " does not exist ");
				}
				
				System.out.println(new String(new char[100]).replace('\0', '-'));
			}
		

	}

	
	public static boolean findSumOfThree(int[] nums, int target) {
	      
	      Arrays.sort(nums);
	      int left = 1;
	      int right = nums.length -1;
	      for(int i = 0;i<nums.length;i++){
	        left = i+1;
	        while(left<right){
	          if(nums[i]+nums[left]+nums[right] == target){
	            return true;
	          }
	          else if(nums[i]+nums[left]+nums[right] >target){
	            right--;
	          }
	          else if(nums[i]+nums[left]+nums[right] <target){
	            left++;
	          }
	        }
	      }
	      
	      return false;
	   }
}
