package algo2;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort2 {

	public static void main(String[] args) {
		
		int[] intArr = randomArray(10);
		
		System.out.println("-".repeat(20)+" INITIAL ARRAY "+"-".repeat(20));
		System.out.println(Arrays.toString(intArr));
		
		
		// check first two values and swap them if a[i]>a[j] else keep incrementing . idea is the largest value will bubble to the last of the array
		// last element becomes the sorted array and array in index 0 to last -1 is the unsorted array
		
		
		for(int unSortedindex = intArr.length-1 ; unSortedindex>0;unSortedindex--) {
			for(int i = 0;i<unSortedindex;i++)
				if(intArr[i]>intArr[i+1])
					swap(intArr,i,i+1);
		}
		

		System.out.println("-".repeat(20)+" SORTED ARRAY "+"-".repeat(20));
		System.out.println(Arrays.toString(intArr));
		
		

	}
	
	public static int[] randomArray(int len) {
		Random random = new Random();
		int[] randomArray = new int[len];
		for(int i = 0; i<len;i++) {
			randomArray[i] = random.nextInt(100);
		}
		
		return randomArray;
	}
	
	
	public static void swap(int[] arr, int i , int j) {
		if(i==j)
			return; // do nothing
		
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
 	}

}
