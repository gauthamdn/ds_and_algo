package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BucketSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] intArray = {34,46,35,83,66,95,92,43};
		
		for(int i : intArray) {
			System.out.print(i+" ");
		}
		System.out.println();
		bucketSort(intArray);
		
		for(int i : intArray) {
			System.out.print(i+" ");
		}

	}


	private static void bucketSort(int[] input) {
		// TODO Auto-generated method stub
		
		// each bucket will be a arraylist
		// we will need 10 buckets for integers 1 to 100
		List<Integer>[] buckets = new List[10];
		for(int i = 0;i<buckets.length;i++) {
			// using linkedlists for the buckets
			//buckets[i] = new LinkedList<Integer>();
			
			// or using Arraylist for buckets
			buckets[i] = new ArrayList<Integer>();
		}
		
		
		//now we will traverse the input array and put the values into the bucket
		//bucketing logic
		for(int i=0;i<input.length;i++) {
			buckets[hash(input[i])].add(input[i]);
		}
		
		//sorting method. we will use the collection.sort which internally uses merge sort. ideally insertion sort is suited, but for now we will use default sort available
		for(List bucket: buckets) {
			Collections.sort(bucket);
		}
		
		// assigning the sorted values back to input array
		int j=0;
		for(int i = 0;i<buckets.length;i++) {
			for(int value : buckets[i]) {
				input[j++] = value;
			}
		}
		
		
		
	}
	
	// hashing function
	private static int hash(int value) {
		return value/(int) 10;
	}

}
