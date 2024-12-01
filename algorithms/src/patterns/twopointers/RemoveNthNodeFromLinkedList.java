package patterns.twopointers;

public class RemoveNthNodeFromLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// time complexity is O(n) - only once we loop through the linked list
	// space complexity is O(1) because we use constant space to store two pointers
	
	/*
public static LinkedListNode removeNthLastNode(LinkedListNode head, int n) {
        
        LinkedListNode left = new LinkedListNode(head.data);
        LinkedListNode right = new LinkedListNode(head.data);
        
        left = head;
        right = head;
        
        
        for(int i =0;i<n ;i++){
          right = right.next;
        }
        
        if (right == null) {
      return head.next;
    }
        
        while(right.next!=null){
          left = left.next;
          right = right.next;
        }
        
       left.next = left.next.next;

        return head;
    }
    */
	
	

}

    