package hashtables.challenge;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import hashtables.Employee;

public class Main {

    public static void main(String[] args) {

        LinkedList<Employee> employees = new LinkedList<>();
        employees.add(new Employee("Jane", "Jones", 123));
        employees.add(new Employee("John", "Doe", 5678));
        employees.add(new Employee("Mike", "Wilson", 45));
        employees.add(new Employee("Mary", "Smith", 5555));
        employees.add(new Employee("John", "Doe", 5678));
        employees.add(new Employee("Bill", "End", 3948));
        employees.add(new Employee("Jane", "Jones", 123));

        employees.forEach(e -> System.out.println(e));
        
        int key;
        
      //  Map<String, Employee> hashMap = new HashMap<String, Employee>();
        HashMap<Integer,Employee> hashMap1 = new HashMap<Integer,Employee>();
       
        
        Iterator<Employee> itr = employees.iterator();
        
        while(itr.hasNext()) {
        	Employee emp = itr.next();
        	hashMap1.put(emp.getId(), emp);
        }
        
        System.out.println("-".repeat(40));
     //   employees.forEach(e -> System.out.println(e));
        employees.removeAll(employees);
       // System.out.println("After removall method call");
       // employees.forEach(e -> System.out.println(e));
       // System.out.println("printing hashmap");
      //  hashMap1.forEach((k,v) -> System.out.println("key: "+ k+ ", employee: "+v));
        
        
        Iterator<Employee> itr1 = hashMap1.values().iterator();
        while(itr1.hasNext()) {
        	employees.add(itr1.next());
        }
        
        System.out.println("SortedList");
        employees.forEach(e -> System.out.println(e));

    }

}
