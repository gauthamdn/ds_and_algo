package patterns.twopointers;

public class ReverseWordsinSentence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseWords("Hello  World taken one "));

	}

	/*
	public static String reverseWords(String sentence) {

        // Replace this placeholder return statement with your code
        int start = 0;
        int end = sentence.length() -1;
        
        StringBuilder str = new StringBuilder();
        str.append(sentence);
        
        String revStr  = str.reverse().toString();
        
        System.out.println(revStr);
        
        return "";
    }
	
	*/
	
public static String reverseWords(String sentence) {

        
        String s  = reverseStr(sentence);
        

        
        //word reversal
        int start = 0;
        int end = 0;
        String sortedSendtence = "";
        
        
        while(end<s.length()) {
        	
        	String word = "";
        	if(end == s.length()-1) {
        		word = word + s.charAt(end);
        		break;
        	}
        		
        	
        	while(end < s.length() && s.charAt(end)!=' ' ) {
        		word = word + s.charAt(end);
        		end++;
        	}
        	
        	if(word!="")
        		sortedSendtence = sortedSendtence + reverseStr(word)+" ";
        	
        	while(end < s.length() && s.charAt(end)==' ' )
        	{
        	start = end+1;
        	end = end+1;	
        	}
        	
        }
        
        return sortedSendtence.trim();
    }
    
    public static String reverseStr(String str) {
    
       StringBuilder s = new StringBuilder();
       s.append(str);
       String revStr  = s.reverse().toString();
       return revStr;
      
    }
}
