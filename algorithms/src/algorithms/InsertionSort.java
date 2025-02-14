package algorithms;

import java.util.Arrays;


// in insertion sort, we don't swap but we shift elements . So we dont need swap method
// Concept - here we start assuming first element is in the sorted array and then from index 1 to length(firstUnsortedIndex) is the unsorted array
// we slowly pick 1 by 1 from unsorted array and insert it in the right position in the sorted array
// here we work in the sorted array 

//start the loop with index 1 
// save the index 1 value into a temp variable tempElem here
// declare i outside the inner loop because we want to use it after the innerloop
// innerloop i = firstunsortedIndex , 
//condition i>0 means that we have not hit the first element in the sorted array 
// condition array[i-1]> tempElem means we will shift or traverse until the value in sorted array is greater than the tempElem that we want to insert
//// we are travesing the sorted partition so i--
// myIntArray[i] = myIntArray[i-1]; 	// this is how we shift the array[i] with array[i-1] value  eg: -15 is less than 35 so 35 shifts right to index 2, and then -15 is less than 20 so 20 shifts right to index 1
//and finally once you are out of loop, assign array[i] with the tempElem;

// complexity o(n^2)
// stable sort , because we are inserting into the sorted array, we will pick the first 9 and then only we pick the last occuring 9 



public class InsertionSort {

	public static void main(String[] args) {
		
		
		int[] myIntArray =  {20,35,-15,7,55,1,-22};
		
		System.out.println("-".repeat(10)+"INITIAL ARRAY"+"-".repeat(10));
		System.out.println(Arrays.toString(myIntArray));
		
		
		for(int firstUnsortedIndex =1; firstUnsortedIndex<myIntArray.length; firstUnsortedIndex++) {
			
			// save the first element of unsorted array into a temp variable tempElem
			int tempElem = myIntArray[firstUnsortedIndex];
			
			int i;
			
			// remember we are travesing the sorted partition so i-- 
			for(i = firstUnsortedIndex ; i>0 && myIntArray[i-1]>tempElem;i--) {
				System.out.println("tempElem: "+tempElem);

				// this is how we shift the array[i] with array[i-1] value  eg: -15 is less than 35 so 35 shifts right to index 2, and then -15 is less than 20 so 20 shifts right to index 1
				myIntArray[i] = myIntArray[i-1]; // i-1 will take care of the 0 index in the first loop
			
			}
			 // and finally once you are out of loop, assign array[i] with the tempElem;
			
			myIntArray[i] = tempElem;
		
			
			
		}
		
		
		
		
		
		
		
		System.out.println("-".repeat(10)+"Sorted Array"+"-".repeat(10));
		System.out.println(Arrays.toString(myIntArray));


	}

}
