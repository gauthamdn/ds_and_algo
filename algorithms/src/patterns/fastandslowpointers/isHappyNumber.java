package patterns.fastandslowpointers;

public class isHappyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(isHappyNumber(2147483646));

	}
	
	 public static boolean isHappyNumber(int n) {

	       int slow = n;
	       int fast = getSumOfdigitSquares(n);
	       System.out.println("Slow : "+slow+ " fast: "+fast);
	    
	        while(fast != 1 && fast != slow){
	          
	          slow = getSumOfdigitSquares(slow);
	          fast = getSumOfdigitSquares( getSumOfdigitSquares(fast) );
	          System.out.println("While: Slow : "+slow+ " fast: "+fast);
	        }
	    
	        if(fast == 1 )
	          return true;
	        
	        else
	          return false;
	          
	    }
	    
	    public static int getSumOfdigitSquares(int num){
		      int sum = 0;
		      while(num != 0 ){
		        int i = num%10;
		        sum = sum + (i*i);
		        num = num/10;
		      }
			return sum;

	}

}
