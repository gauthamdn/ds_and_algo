package patterns.twopointers;

public class ReverseWordsinSentence2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseWords("Hello  World  "));

	}

	
	
public static String reverseWords(String sentence) {

	sentence = sentence.trim();
        String s  = reverseStr(sentence);

        //word reversal
        int start = 0;
        int end = 0;
        
        String sortedSendtence = "";
        
        char[] c = s.toCharArray();
        int strLen = c.length-1;
        
        for(start = 0, end =0;end<=strLen; ++end) {
        	if(end ==strLen || c[end]==' ') {
        		int endIdx = (end == strLen ) ? end : end - 1;
        		reverseStr(c,start,endIdx);
        		start = end+1;
        		
        	}
        }
        
        /*
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
        	
        }*/
        
        return new String(c).trim();
    }
    
    private static void reverseStr(char[] c, int start, int end) {
	
    	while(start<end) {
    		char temp = c[start];
    		c[start] = c[end];
    		c[end] = temp;
    		start++;
    		end--;
     	}
	
    }



	public static String reverseStr(String str) {
    
       StringBuilder s = new StringBuilder();
       s.append(str);
       String revStr  = s.reverse().toString();
       return revStr;
      
    }
}
