package algo.search;

public class LinearSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] intArray = {10, 11, 1,-15,43,3,90};
		int searchKey = -15;
		
		System.out.println(linearSearch(intArray,searchKey));
		System.out.println(linearSearch(intArray,9));
		System.out.println(linearSearch(intArray,90));
		
		

	}

	private static boolean linearSearch(int[] input, int searchKey) {
		// TODO Auto-generated method stub
		
		for(int i=0;i<input.length;i++)
			if(input[i]== searchKey)
				return true;
		return false;
		
	}

}