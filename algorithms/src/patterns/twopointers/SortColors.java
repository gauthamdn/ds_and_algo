package patterns.twopointers;

import java.util.Arrays;

public class SortColors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// colors are represented with 0 - red, 1 - white, 2 - blue
		// concept declare 3 points start = 0, current = 0, end = length-1
		// if current color = 0, swap current with start and increment both start and current
		// else if current color = 1 , just increment current
		// else if current color = 2 , swap current and end and increment current and decrement end pointer
		
		// iterate until current <=end
		
		int[] colors = {1,1,0,2};
		int[] SortedColors = sortColors(colors);
		
		System.out.println(Arrays.toString(SortedColors));

	}
	
	public static int[] sortColors (int[] colors) {

        int start = 0;
        int current = 0;
        int end = colors.length - 1;
        
        while(current<=end){
          if(colors[current] == 0){
            int temp = colors[current];
            colors[current] = colors[start];
            colors[start] = temp;
            current++;
            start++;
          }
          else if(colors[current] == 1){
            current++;
          }
          else{
            int temp = colors[current];
            colors[current] = colors[end];
            colors[end] = temp;
            end --;
          }
          
        }
        

        return colors;
    }

}
