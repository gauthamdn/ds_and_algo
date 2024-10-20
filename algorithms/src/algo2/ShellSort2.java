package algo2;

import java.util.Arrays;
import java.util.Random;

public class ShellSort2 {
	
public static void main(String[] args) {
		
		int[] intArr = randomArray(10);
		
		System.out.println("-".repeat(20)+" INITIAL ARRAY "+"-".repeat(20));
		System.out.println(Arrays.toString(intArr));
		
		// WRITE YOUR LOGIC HERE
		
		for(int gap = intArr.length/2;gap>0;gap=gap/2) {
			System.out.println("gap = "+gap);
			for(int i=gap;i<intArr.length;i++) {
				int tempElem = intArr[i];
				int j =i;
				System.out.println("tempElem = "+tempElem+" i="+i+" j="+j);
				System.out.println("Comparing intArr["+j+"-"+gap+"] and tempelem="+tempElem);
				while (j>=gap && intArr[j-gap]>tempElem) {
					intArr[j] = intArr[j-gap];
					j= j-gap;
					System.out.println("inside while");
				}
				
				intArr[j] = tempElem;
				System.out.println("assign arr[j] to tempElem/ swap");
				System.out.println(Arrays.toString(intArr));
			}

			
		}
		
		
		System.out.println("-".repeat(20)+" SORTED ARRAY "+"-".repeat(20));
		System.out.println(Arrays.toString(intArr));
		
		

	}
	
	public static int[] randomArray(int len) {
		Random random = new Random();
		int[] randomArray = new int[len];
		for(int i = 0; i<len;i++) {
			randomArray[i] = random.nextInt(1000);
		}
		
		return randomArray;
	}

}
