package stacks;

import java.util.LinkedList;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		System.out.println(checkForPalindrome("abccba"));
		
		System.out.println(checkForPalindrome("Don't nod"));
		
		System.out.println(checkForPalindrome("I did, ip did I?"));

	}

	private static boolean checkForPalindrome(String string) {
		// TODO Auto-generated method stub
		
		LinkedList<Character> stack = new LinkedList<Character>();
		StringBuilder strNoPunctuation = new StringBuilder(string.length());
		String lowercasestr = string.toLowerCase();
		
		for(int i=0;i<lowercasestr.length();i++) {
			
			char c = lowercasestr.charAt(i);
			if(c>='a' && c<='z') {
				strNoPunctuation.append(c);
				stack.push(c);
			}
		}
		
		StringBuilder revStr = new StringBuilder(stack.size());
		while(!stack.isEmpty()) {
			revStr.append(stack.pop());
		}
		
		
		return revStr.toString().equals(strNoPunctuation.toString());
	}

}
