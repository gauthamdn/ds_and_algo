package algo.search;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] intArray = {-15, -3, 10, 11, 12,43,90};
		System.out.println(iterativeBinarySearch(intArray,-3));
		System.out.println(iterativeBinarySearch(intArray,-43));
		System.out.println(iterativeBinarySearch(intArray,90));
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

}