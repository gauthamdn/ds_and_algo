package algorithms;

import java.util.Arrays;

public class BubbleSort {

	// step 1: write a swap method , because bubble sort uses swap method
	// concept is - the largest number in the array will bubble to the end of the array
	// eg: in the sample array {20,35,-15,7,55,1,-22} , in the first iteration 55 will go to the last postion
	// start with comparing values at first two indexes , if a[i] > a[j] then swap , else increment.
	// This is also called a in-place sorting algorithm, because we will logically divide the array into sorted and unsorted arrays. 
    // we will use a lastUnsortedIndex variable to indicate the last index of the unsorted array and slowly decrement
	// in the below case we start with lastUnsortedIndex = arraylength - 1 and once the first iteration 55 moves to last position, we decrement the lastUnsortedIndex
	// and we go on until we hit lastUnsortedIndex == 0 , once we reach 0 the array is sorted
	// the innerloop will compare i=0 and i+1th element and swap if 0th element> 1st element and increment until the lastUnsortedIndex. 
	// complexity of the bubble sort is O(n^2)
	// bubble sort is a stable sorting algo
	// stable & unstable sort - what happens when there are two elements in an array which are same. 
	// ex: if the unsorted array contains two 9's { 20, 9, -15, 7, 9, 1, 55 } , now will the order of the 9's maintained? or not?
	// This is not much important when we have integer arrays , but its important when we have object arrays
	// Stable sort maintains the order of elements ie the first 9 will be before the last 9 in the sorted array
	// unstable sort does not maintain the order of elements

	
	public static void main(String[] args) {
		
		int[] myIntArray = {20,35,-15,7,55,1,-22};
		
		System.out.println("-".repeat(10)+"Initial Array"+"-".repeat(10));
		System.out.println(Arrays.toString(myIntArray));
		
		for(int lastUnsortedIndex = myIntArray.length - 1; lastUnsortedIndex >0; lastUnsortedIndex--) {
			
			for(int i = 0; i< lastUnsortedIndex ; i++) {
				if(myIntArray[i]>myIntArray[i+1]) {
					swap(myIntArray, i, i+1);
				}
			}
			
		}
		
		System.out.println("-".repeat(10)+"Sorted Array"+"-".repeat(10));
		System.out.println(Arrays.toString(myIntArray));

	}

	// pass the array we are swapping and the two indices that we want to swap
	public static void swap(int[] array, int i, int j) {
		
		// if i and j indices are same, nothing to swap
		if(i == j)
			return;
		
		// swap using a temp variable
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
 		
	}
	
}
