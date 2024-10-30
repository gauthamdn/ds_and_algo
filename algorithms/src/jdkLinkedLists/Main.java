package jdkLinkedLists;

import java.util.Iterator;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		Employee emp1 = new Employee("Mary", "Smith", 22);
		Employee emp2 = new Employee("John","Tracker", 12);
		Employee emp3 = new Employee("Mathew","Hayden",10);
		Employee emp4 = new Employee("Raju","Pandey",8);
		Employee emp5 = new Employee("Sachin","Tendulkar",11);
		
		LinkedList<Employee> list = new LinkedList<>();
		
		list.addFirst(emp1);
		list.addFirst(emp2);
		list.addFirst(emp3);
		list.addFirst(emp4);
		list.addFirst(emp5);
		list.add(emp3);
		
		Iterator iter = list.iterator();
		System.out.print("HEAD ->");
		while(iter.hasNext()) {
			System.out.print(iter.next());
			System.out.print("<=>");
		}
		System.out.println();
		System.out.println("-".repeat(25));
		
		for(Employee emp : list) {
			System.out.println(emp);
		}
		
		
		
		
		
		
	}
	
}
