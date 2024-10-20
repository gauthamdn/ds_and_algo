package datastructures.arraylists;

import java.util.ArrayList;
import java.util.List;

public class ArrayLists {

	public static void main(String[] args) {
		
		
		List<Employee> empList = new ArrayList<>();
		// add to list
		empList.add(new Employee("Mary", "Smith", 22));
		empList.add(new Employee("John","Tracker", 12));
		empList.add(new Employee("Mathew","Hayden",10));
		empList.add(new Employee("Raju","Pandey",8));
		
		// print using foreach
		empList.forEach(emp -> System.out.println(emp));
		
		// get data at index 1. we can use index because Arraylist internally uses Array to implement the list functionality
		System.out.println(empList.get(1));
		
		// check if empty
		System.out.println(empList.isEmpty());
		
		// check size of the Array list. Size is different than capacity ( size is num of elements in the list. While capacity is the size
		// of the whole arraylist . by default arraylist size is 10.
		
		System.out.println(empList.size());
		
		
		// use set to update an existing entry
		empList.set(1, new Employee("Sachin","tendulkar", 10));
		
		
		// you can add at a index by passing the index to the add method
		empList.add(3, new Employee("Rahul","Dravid", 14));
		
		
		empList.forEach(emp -> System.out.println(emp));
		
		// convert the Arraylist to an array
		
		Employee[] empArray = empList.toArray(new Employee[empList.size()]);
		for(Employee emp : empArray) {
			System.out.println("-->"+emp);
		}
		
		
		//contains method. This needs to implement equals method, because the default equals method need the object instances to be same and not just values.
		// so if you dont override the equals method to check just the values , it will always return false. We have overridden the equals and hashcode methods for now in Employee class
		// even indexOf method needs the equals method overridden
		System.out.println("Contains.."+empList.contains(new Employee("Mathew","Hayden",10)));
		System.out.println("Indexof implementation.."+empList.indexOf(new Employee("Mathew","Hayden",10)));
		
		// remove function using index. you can also pass a new employee obj also.
		empList.remove(1);
		
		empList.forEach(emp -> System.out.println(emp));

	}

}
