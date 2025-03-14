package hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import hashtables.Employee;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee emp1 = new Employee("Mark","Boucher",20);
		Employee emp2 = new Employee("Sachin","Tendulkar",20);
		Employee emp3 = new Employee("saurav","Ganguly",20);
		Employee emp4 = new Employee("Rahul","dravid",20);
		Employee emp5 = new Employee("Laxman","VVS",20);
		
		
		
		Map<String, Employee> hashMap = new HashMap<String, Employee>();
		hashMap.put(emp1.getLastName(), emp1);
		hashMap.put(emp2.getLastName(), emp2);
		hashMap.put(emp3.getLastName(), emp3);
		hashMap.put(emp4.getLastName(), emp4);
		
		/*
		Iterator<Employee> itr = hashMap.values().iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}*/
		
		hashMap.forEach((k,v) -> System.out.println("key =  "+ k + ", Employee = "+v));
		
		System.out.println(hashMap.containsKey("dravid"));
		
		System.out.println(hashMap.containsValue(emp3));
		
		// putifAbsent()
		//getOrDefault()
	
		
		
	}

}
