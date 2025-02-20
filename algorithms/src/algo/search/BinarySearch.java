package algo.search;

public class BinarySearch {

	public static void main(String[] args) {
		// Needs sorted array as input
		int[] intArray = {-15, -3, 10, 11, 12,43,90};
		System.out.println(iterativeBinarySearch(intArray,-3));
		System.out.println(iterativeBinarySearch(intArray,-43));
		System.out.println(iterativeBinarySearch(intArray,90));
		
		System.out.println(recursiveBinarySearch(intArray,0,intArray.length,-3));
		System.out.println(recursiveBinarySearch(intArray,0,intArray.length,-43));
		System.out.println(recursiveBinarySearch(intArray,0,intArray.length,90));
	}
	
	public static int iterativeBinarySearch(int[] input, int value) {
		
		int start = 0;
		int end = input.length;
		
		while(start<end) {
			int midpoint = (start+end)/2;
			if(input[midpoint] == value) {
				return midpoint;
			}
			else if(input[midpoint]<value) {
				start = midpoint+1;
			}
			else
				end = midpoint;
		}
		 
		return -1;
		
	}
	
	public static int recursiveBinarySearch(int[]input, int start, int end, int value) {
		
		if(start>=end) {
			return -1;
		}
		int midpoint = (start+end)/2;
		if(input[midpoint] == value)
			return midpoint;
		else if(input[midpoint]<value)
			return recursiveBinarySearch(input, midpoint+1,end, value);
		else 
			return recursiveBinarySearch(input, start, midpoint-1,value);
			
			
	}

}
