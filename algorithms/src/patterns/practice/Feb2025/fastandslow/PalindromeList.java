package patterns.practice.Feb2025.fastandslow;

public class PalindromeList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//int[] list = {4,7,9,5,4};
		//int[] list = {1,2,3,2,1};
		//int[] list = {2,3,5,5,3,2};
		int[] list = {6,1,0,5,1,6};
		
		LinkedList linkedList = new LinkedList();
		linkedList.createLinkedList(list);
		
		LinkedListNode temp = linkedList.head;
		while(temp!=null) {
			
			System.out.print(temp.data+"->");
			temp = temp.next;
			
		}
		
		
		System.out.println(palindrome(linkedList.head));
		
		
		
		
		

	}
	
	
	
		public static boolean palindrome(LinkedListNode head) {

		      // Replace this placeholder return statement with your code
			
			  int size = 0;
			  LinkedListNode ptr = head;
			  while(ptr!=null) {
				  ptr = ptr.next;
				  size++;
			  }
		      
		      LinkedListNode slow = head;
		      LinkedListNode fast = head;
		      LinkedListNode midHead = head;
		      
		      
		      if(size%2 == 0){
		          while(fast!=null){
		         slow = slow.next;
		         fast = fast.next.next;
		         }
		          midHead = slow;
		       }
		       else{
		         while(fast.next!=null){
		         slow = slow.next;
		         fast = fast.next.next;
		         }
		         midHead = slow.next;
		       }
		      
		      
		      slow = head;
		      LinkedListNode revLinkedlistHead = LinkedListReversal.reverseLinkedList(midHead);
		      LinkedListNode temp = revLinkedlistHead;
		      
		      while(temp !=null){
		        if(slow.data != temp.data )
		          return false;
		        else{
		          slow = slow.next;
		          temp = temp.next;
		        }
		      }
		      
		      LinkedListNode midListNode  = LinkedListReversal.reverseLinkedList(revLinkedlistHead);
		      slow.next = midListNode;
		        return true;
		    }
		    

}
