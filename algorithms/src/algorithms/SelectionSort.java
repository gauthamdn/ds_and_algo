package algorithms;

import java.util.Arrays;

public class SelectionSort {
	
	// Step 1: swap method
	// concept is - with every iteration you select the last value in the unsorted array and swap it with the last element
	// again we break the array logically into sorted and unsorted here where after first iteration the last element is in its sorted position
	// start with initializing largest as the first index ie largest = 0; ( we are assuming first value is the largest )
	// in the innerloop keep incrementing i and keep checking if any a[i] > a[largest] , if yes then largest is i;
	// after the first iteration , swap the largest value index with the last index in the unsortedindex array.
	// this is O(n^2) complexity
	// this is unstable sort ie the ordering is not maintained
	
	
	
	
	
	public static void main(String[] args) {
		
		int[] myIntArray = {20,35,100,3,-3,83,-15,7,55,1,-22};
		
		
		System.out.println("-".repeat(10)+"INITIAL ARRAY"+"-".repeat(10));
		System.out.println(Arrays.toString(myIntArray));
		
		for(int lastUnsortedIndex = myIntArray.length - 1; lastUnsortedIndex>0;lastUnsortedIndex--) {
			int largest = 0;
			
			
			// one difference between this and bubble sort you will see is in the innerloop we have i<=lastunsortedIndex 
			// in bubblesort it was i<lastUnsortedindex
			// this is because in bubble sort we compared i and i+1 
			// here we need to compare the last index value also and get the largest in all the unsortedarray
			for(int i = 1;i<=lastUnsortedIndex;i++) {
				if(myIntArray[i]>myIntArray[largest]) {
					largest = i;
				}
				
			swap(myIntArray, largest, lastUnsortedIndex);
			
			}
			
			
		}
		
		
		System.out.println("-".repeat(10)+"SORTED ARRAY"+"-".repeat(10));
		System.out.println(Arrays.toString(myIntArray));
		
	}
	
	
	public static void swap(int[] arr , int i , int j) {
		if(i==j )
			return;
		
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		

 	}

}

