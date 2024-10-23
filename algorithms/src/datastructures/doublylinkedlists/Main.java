package datastructures.doublylinkedlists;


import datastructures.doublylinkedlists.EmployeeDoublyLinkedlist;

public class Main {

	public static void main(String[] args) {
		
		
		
		Employee emp1 = new Employee("Mary", "Smith", 22);
		Employee emp2 = new Employee("John","Tracker", 12);
		Employee emp3 = new Employee("Mathew","Hayden",10);
		Employee emp4 = new Employee("Raju","Pandey",8);
		Employee emp5 = new Employee("Sachin","Tendulkar",11);
		
		EmployeeDoublyLinkedlist empList = new EmployeeDoublyLinkedlist();
		System.out.println(empList.isEmpty());
		empList.addToFront(emp1);
		empList.addToFront(emp2);
		empList.addToFront(emp3);
		empList.addToFront(emp4);
		empList.addToFront(emp5);
		
		
		empList.printList();
		System.out.println(empList.getSize());
		System.out.println(empList.isEmpty());

	}

}
