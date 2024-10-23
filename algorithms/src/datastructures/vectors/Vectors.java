package datastructures.vectors;

import java.util.List;
import java.util.Vector;

public class Vectors {

	public static void main(String[] args) {
		// vectors were there before the ArrayList got added to jdk
		// vectors are used for synchronization or for a threadsafe implementation and uses Array in the background to store the list
		// while ArrayList is a non-threadsafe implementation. So if multiple threads trying to write/modify the arraylist elemnent conflict might arise
		// use vectors when you need synchronization and arraylist when you dont need synchronization
		// threadsafety adds overhead and is slow - so use them based on your need.
		
		// to use vectors - just change the new object type to Vector. 
		//It always better to use List<> so its easy to change Arraylist or Vector or List
		List<Employee> empList = new Vector<>();
		// add to list
		empList.add(new Employee("Mary", "Smith", 22));
		empList.add(new Employee("John","Tracker", 12));
		empList.add(new Employee("Mathew","Hayden",10));
		empList.add(new Employee("Raju","Pandey",8));
		
		

	}

}
