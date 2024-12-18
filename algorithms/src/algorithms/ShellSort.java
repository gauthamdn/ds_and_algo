package algorithms;

import java.util.Arrays;

// Shell sort is a variation of insertion sort
// what we found out is if we insertion sort does shifting the elements , if we can reduce the number of shifting of elements then the efficiency will be good 
// it uses a gap element based on the length of the array. basically gap here means instead of comparing it with the next element, it will compare with an element of the gap.
// eg: gap = 3 means it will compare to the 3rd element and then to the next 3rd element from right to left. this way num of shifts will reduce.
// the last iteration of shell sort where gap becomes 1 and is the same implementation of insertion sort. 
// the idea is by the time we come to gap =1 we will have a kind of sorted array which will reduce the num of shifts improving the efficiency
// finding the complexity of shell sort is difficult, because it depends on the gap key that we will calculate and there are multiple ways to calculate the gap key
// worst case O(n^2)
// shell sort is a unstable sort where as insertion sort is stable
//we will use a simple gap of length/2 here. 
// you can also use shell algo or gap way of doing sort to bubble sort also, where you reduce the num of swaps that you have to do.


// implementation wise shell sort is very similar to insertion sort except that it uses the gap instead of comparing values next to each other




public class ShellSort {

	public static void main(String[] args) {

		int[] myIntArray = {20,35,-15,7,55,1,-22};
		
		System.out.println("-".repeat(10)+"Initial Array"+"-".repeat(10));
		System.out.println(Arrays.toString(myIntArray));
		
		
		// gap value we are taking is length/2. So in the sample array we have gap = 7/2 = 3
		// gap>0 condition is needed otherwise that will mean we have hit the end of array
		// instead of decrementing i-- we will gap = gap/2 so in second iteration gap = 3/2 =1 which is same as insertion sort for this example
		
		for(int gap = myIntArray.length/2; gap>0;gap = gap/2) {
		
			for(int i = gap;i<myIntArray.length;i++) {
				// assign a temp var for the value that we will be comparing
				int tempElem = myIntArray[i];
				
				// j is used to do traversing
				int j = i;
				
				// if j is less than gap that means we have hit the front of the array
				// a[j-gap] ie a[3-3] ie a[0] is > tempElem basically value 20 > 7. then we shift 20 to position 3 and we want to subtract the gap from j ( j = j-gap); 
				
				while(j>=gap && myIntArray[j-gap]>tempElem) {
					myIntArray[j] = myIntArray[j-gap];
					j = j-gap;
					
				}
				// finally assign the temp value to a[j]
				myIntArray[j] = tempElem;
				
			}
			
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		System.out.println("-".repeat(10)+"Sorted Array"+"-".repeat(10));
		System.out.println(Arrays.toString(myIntArray));

	}

}
