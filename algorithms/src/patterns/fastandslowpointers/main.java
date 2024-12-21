package patterns.fastandslowpointers;

public class main {
	
	public static void main(String args[]) {
		
		System.out.println(getSumOfdigitSquares(35));
		
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
