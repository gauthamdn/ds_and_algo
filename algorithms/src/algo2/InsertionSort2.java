package algo2;

import java.util.Arrays;
import java.util.Random;

public class InsertionSort2 {
	
	public static void main(String[] args) {
		
		int[] intArr = randomArray(10);
		//int[] intArr =  {20,35,-15,7,55,1,-22};
		
		System.out.println("-".repeat(20)+" INITIAL ARRAY "+"-".repeat(20));
		System.out.println(Arrays.toString(intArr));
		
		
		for(int unSortedIndex = 1 ; unSortedIndex <intArr.length;unSortedIndex++) {
			
			System.out.println("unSortedIndex->"+unSortedIndex);
			System.out.println("Array now is >"+Arrays.toString(intArr));
			int tempElem = intArr[unSortedIndex];
			int i;
			System.out.println("TempElem now is >"+tempElem);
			//System.out.println("intArr[i-1] now is >"+intArr[i-1]);
			
			for(i = unSortedIndex; i>0 && intArr[i-1]>tempElem ; i--) {
					System.out.println("intArr["+i+"] = "+intArr[i]+" and intArr["+i+"-1] = "+intArr[i-1]);
					System.out.println("Comparing tempElem="+tempElem+ " with intArr["+i+"-1] = "+intArr[i-1]);
					intArr[i] = intArr[i-1];	
					System.out.println("-Array after shift----->"+Arrays.toString(intArr));
				
			}
			intArr[i] = tempElem;
			System.out.println("-Array after swap-->"+Arrays.toString(intArr));
			
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

}
