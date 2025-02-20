package algorithms;

import java.util.Arrays;
import java.util.Random;

public class SortTemplate {

	public static void main(String[] args) {
		
		int[] intArr = randomArray(10);
		
		System.out.println("-".repeat(20)+" INITIAL ARRAY "+"-".repeat(20));
		System.out.println(Arrays.toString(intArr));
		
		// WRITE YOUR LOGIC HERE
		
		
		
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
