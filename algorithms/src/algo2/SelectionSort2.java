package algo2;

import java.util.Arrays;
import java.util.Random;

public class SelectionSort2 {
	
public static void main(String[] args) {
		
		int[] intArr = randomArray(15);
		
		System.out.println("-".repeat(20)+" INITIAL ARRAY "+"-".repeat(20));
		System.out.println(Arrays.toString(intArr));
		
		int largest;
		
		for(int unsortedIndex = intArr.length-1; unsortedIndex>0;unsortedIndex--) {
			largest = 0;
			int i;
			for(i =1;i<=unsortedIndex;i++) {
				if(intArr[i]>intArr[largest])
					largest = i;
				
			}
			swap(intArr,unsortedIndex,largest);
	
		
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
		//System.out.println("-swap i="+ i +" j="+j);
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
 	}


}
