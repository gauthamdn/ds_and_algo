package dynamicprogramming;

public class Subsequence {

	public static void main(String[] args) {
		
		System.out.println(isSubSequence("act","astbc"));
		System.out.println(isSubSequence("atc","astbc"));
		System.out.println(isSubSequence("aaaaaa","bbaaaa"));
		
		
		System.out.println(isSubSequenceLinearComplexity("act","astbc"));
		System.out.println(isSubSequenceLinearComplexity("atc","astbc"));
		System.out.println(isSubSequenceLinearComplexity("aaaaaa","bbaaaa"));

	}
	
	
	
	//this is O(n^2) time complexity
	public static Boolean isSubSequence(String s, String t) {
		
		int matchCount = 0;
		int n = 0;
		int i = 0;
		int j = 0;
		
		for(i = 0;i<s.length();i++)
		{
			
			for(j = n;j<t.length();j++)
			{
				if(s.charAt(i) == t.charAt(j)) {
					matchCount++;
					n = j+1;
					break;
				}
					
			}
		}
		
		if(matchCount == s.length())
			return true;
		else 
			return false;
	}
	
	
	//this is O(n) time complexity
public static Boolean isSubSequenceLinearComplexity(String s, String t) {
		
		int i = 0;
		int j = 0;
		
		
		while(i<s.length() && j<t.length()) {
			if(s.charAt(i) == t.charAt(j))
			{
				i++;
				j++;
				
			}else {
				j++;
			}
		}
		
		if(i== s.length()) 
			return true;
		else
			return false;
		
	}
	
	
	
	

}
