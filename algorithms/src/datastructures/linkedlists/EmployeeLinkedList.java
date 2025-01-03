package datastructures.linkedlists;

public class EmployeeLinkedList {
	
	private EmployeeNode head;
	
	private int size=0;
	
	
	public void addToFront(Employee emp1) {
		EmployeeNode node = new EmployeeNode(emp1);
		node.setNext(head);	
		head = node;
		size++;
	}
	
	public int getSize() {
		return size;
	}
	
	public boolean isEmpty() {
		return this.head == null;
	}
	
	public void printList() {
		
		EmployeeNode current = head;
		
		System.out.print("HEAD -->");
		
		while(current!=null) {
			System.out.print(current);
			System.out.print("-->");
			current = current.getNext();
		}
		
		System.out.println("null");
		
	}
	
	
	public EmployeeNode removeFromFront() {
		if(isEmpty()) {
			return null;
		}
		return head;
	}

}
