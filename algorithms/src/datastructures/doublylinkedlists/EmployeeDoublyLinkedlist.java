package datastructures.doublylinkedlists;

public class EmployeeDoublyLinkedlist {
	
	private EmployeeNode head;
	private EmployeeNode tail;
	private int size;
	
	
	public void addToFront(Employee employee) {
		EmployeeNode node = new EmployeeNode(employee);
		
		if(isEmpty()) {
			tail = node;
		}else {
			head.setPrev(node);
		}
		
		node.setNext(head);
		head = node;
		size++;
		
		
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
