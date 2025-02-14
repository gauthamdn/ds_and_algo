package patterns.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://www.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1


public class FirstNegativeNumInEveryWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// input sample 1
				int arr[] = {12,-1,-7,8,-15,30,16,-28};
				int window_size = 3;
				
				
				//initialize start and end pointers
				int i = 0;
				int j = 0;
				
				// create a temp list to maintain the list of -ve numbers as you loop through using j
				ArrayList<Integer> tempList = new ArrayList<>();
				// create a output list to print the final result
				ArrayList<Integer> outputList = new ArrayList<>();
				
				
				
				while(j<arr.length) {
					
					// calculation
					// find if arr[i] is negative or not , add to templist if negative
					if(arr[j]<0) 
						tempList.addLast(arr[j]);
				
					// until you reach the window size, keep doing j++
					if(j-i+1 <window_size) {
						j++;
					}
					else if(j-i+1 == window_size) {
						// we have reached the window size
						// derive the answer, add it to the output list
						// get the first negative from the templist
						if(!tempList.isEmpty()) {
							outputList.add(tempList.getFirst());
						
						// remove the arr[i] from the templist if exists in templist. remove first element in templist and slide the window
						if(arr[i]==tempList.getFirst());
							tempList.removeFirst();
						}
						//slide the window 
						i++;
						j++;
					}
					
				}
				
				
				System.out.println(Arrays.toString(outputList.toArray()));
				
				

	}

}
