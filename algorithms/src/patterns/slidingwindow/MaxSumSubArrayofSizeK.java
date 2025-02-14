package patterns.slidingwindow;


//https://www.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1

public class MaxSumSubArrayofSizeK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*// input sample 1
		int arr[] = { 2,5,1,8,2,9,1};
		int window_size = 3;
		//expected output 19
		*/
		// input sample 2
		int arr[] = {100, 200, -300, -400};
		int window_size = 4;
		//expected output 700
		
		
		int arrSize = arr.length;
		
		// starting and ending pointers
		int i = 0;
		int j = 0;
		int sum = 0;
		int max = sum;
		
		// loop until j reaches the end of the array( or window reaches the end of the array )
		while(j<arrSize) {
			
			// sum up the elements of j and keep doing j++ until the window size is recached( j-i+1 == window )
			sum = sum+arr[j];
			
			if(j-i+1 <window_size) 
				j++;
			else if(j-i+1 == window_size)
			{
				max = Integer.max(max, sum);
				// slide the window after getting the max . add arr[j++] and minus arr[i] 
				sum = sum - arr[i];
				i++;
				j++;
				
			}
			
			
		}
		
		System.out.println("Max sum of SubArray size "+window_size+" is "+max);
		

	}

}
