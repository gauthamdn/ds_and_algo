package datastructures.doublylinkedlists;

public class EmployeeDoublyLinkedlist {
	
	private EmployeeNode head;
	private EmployeeNode tail;
	private int size;
	
	
	public void addToFront(Employee employee) {
		EmployeeNode node = new EmployeeNode(employee);
		
		if(isEmpty()) {
			this.head  = node;
		}else {
			this.head.setPrev(node);
		}
		
		node.setNext(head);
		this.head = node;
		this.size++;
		
	}
	
	
	public EmployeeNode removeFromFront() {
		
		return null;
	}
	
	
	public int getSize() {
		return this.size;
	}
	
	public boolean isEmpty() {
		return this.head==null;
	}
	
	public void printList() {
		EmployeeNode current = head;
		System.out.println("HEAD ->");
		while(current != null) {
			System.out.println(current);
			System.out.println(" <=> ");
			current = current.getNext();
		}
		System.out.println("null");
		
		
	}
	

	

}
