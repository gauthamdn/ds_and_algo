package patterns.twopointers;


// time complexity - O(n), however algo will run only for n/2 times
// space complexity is O(1) since we use constant space to store two indexes

public class isPalindrome {

	 public static void main(String[] args) {
	        String s = "RACECAR";
	        //String s = "hello"
	       // "RaCEACAR"
	       // "RACECAR"
	       // "A"

	        System.out.println(isPalindrome(s));

	    }

	    public static boolean isPalindrome(String s) {
	        char[] c = s.toCharArray();
	        int i = 0;
	        int j = c.length-1;

	        while(i<c.length && i<j){
	            if(c[i]==c[j]){
	                i++;
	                j--;
	            }
	            else {
	                return false;
	            }
	        }

	        return true;
	    }

}
