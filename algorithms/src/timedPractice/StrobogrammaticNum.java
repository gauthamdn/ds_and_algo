package timedPractice;


/*
 * For the given length n, find all n-length Strobogrammatic numbers.

Strobogrammatic Number is a number whose numeral is rotationally symmetric so that it appears the same when rotated 180 degrees. In other words, Strobogrammatic Number appears the same right-side up and upside down.

0 after 180° rotation : (0 → 0)
1 after 180° rotation : (1 → 1)
8 after 180° rotation : (8 → 8)
6 after 180° rotation : (6 → 9)
9 after 180° rotation : (9 → 6)


Examples :

Input : n = 2
Output : 88  11  96  69


Input : n = 4
Output : 8008 1001 9006 6009 8888 1881 9886 6889 8118 1111
        9116 6119 8968 1961 9966 6969 8698 1691 9696 6699
 */



/*
 * Approach - Easier way to visualize Strobogrammatic numbers are using PPT tool.
 * write a number in a text box and rotate by 180 degree. If you get the same number after rotating, then its a strobogrammatic number
 * In the current approach - we will do stringreversal of the input number and then pass through a strobogrammtic function to reverse the single digits.
 * 
 */
public class StrobogrammaticNum {

	public static void main(String[] args) {
		int num = 609;
		
		//System.out.println(reverse(num));
		System.out.println(getStrobogrammaticNum(num));
		if(num == getStrobogrammaticNum(num))
			System.out.println("num = "+num + " is Strobogrammatic");
		else
			System.out.println("num = "+num + " is NOT Strobogrammatic");

	}

	private static int getStrobogrammaticNum(int num) {
		int output = 0;
		
		while(num!=0) {
			int digit = num%10;
			switch(digit) {
				case 0 -> {output = output *10 + 0;}
				case 1 -> {output = output *10 + 1;}
				case 6 -> {output = output *10 + 9;}
				case 8 -> {output = output *10 + 8;}
				case 9 -> {output = output *10 + 6;}
				default -> { output = -1;}
			};
			
			num/=10;
			
		}
		return output;
	}
	
	/*private static int reverse(int num) {
		int output = 0;
		
		while(num!=0) {
			int digit = num%10;
			output = output *10+ digit;
			num/=10;
			
		}
		return output;
	}*/

}