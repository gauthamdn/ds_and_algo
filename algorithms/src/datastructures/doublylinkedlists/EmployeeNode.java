package datastructures.doublylinkedlists;

public class EmployeeNode {
	
	
	private Employee employee;
	private EmployeeNode next;
	private EmployeeNode prev;
	
	
	public EmployeeNode(Employee employee, EmployeeNode next, EmployeeNode prev) {
		super();
		this.employee = employee;
		this.next = next;
		this.prev = prev;
	}


	public EmployeeNode(Employee employee) {
		super();
		this.employee = employee;
	}


	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	public EmployeeNode getNext() {
		return next;
	}


	public void setNext(EmployeeNode next) {
		this.next = next;
	}


	public EmployeeNode getPrev() {
		return prev;
	}


	public void setPrev(EmployeeNode prev) {
		this.prev = prev;
	}


	@Override
	public String toString() {
		return "EmployeeNode [employee=" + employee + ", next=" + next + ", prev=" + prev + "]";
	}
	
	
	
	
	

}
