package recursion;

import java.util.Arrays;

public class Palindrome {
	
	public static void main(String[] args) {
		
		System.out.println(checkPalindromeIteratively("ABABA"));
		
		String str = "GAGAGAG";
		int i = 0;
		int j = str.length()-1;
		
		System.out.println(checkPalindromeRecurssion(str,i,j));
		
	}
	
	public static boolean checkPalindromeIteratively(String str) {
		
		int i = 0;
		int j = str.length()-1;
		char[] strArray = str.toCharArray();
		
		while(i<=j) {
			if(strArray[i]!=strArray[j])
				return false;
			else {
				i++;
				j--;
			}
		}
		
		return true;
	}
	
	
	public static boolean checkPalindromeRecurssion(String str,int i, int j) {
	
		
		char[] strArray = str.toCharArray();
		
		if(i>j) {
			return true;
		}
		
		if(strArray[i]==strArray[j]&& checkPalindromeRecurssion(str,++i,--j)) {
			return true;
		}else {
			return false;
		}
		
}

}
