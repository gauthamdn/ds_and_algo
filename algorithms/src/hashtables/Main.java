package hashtables;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Employee emp1 = new Employee("Mark","Boucher",20);
		Employee emp2 = new Employee("Sachin","Tendulkar",20);
		Employee emp3 = new Employee("saurav","Ganguly",20);
		Employee emp4 = new Employee("Rahul","dravid",20);
		Employee emp5 = new Employee("Laxman","VVS",20);
		Employee emp6 = new Employee("Ravi","VVS",20);
		Employee emp7 = new Employee("Ravi2","dravid",20);
		
		SimpleHashTable ht = new SimpleHashTable();
		ht.put(emp1.getLastName(), emp1);
		ht.put(emp2.getLastName(), emp2);
		ht.put(emp3.getLastName(), emp3);
		ht.put(emp4.getLastName(), emp4);
		ht.put(emp5.getLastName(), emp5);
		//ht.printHashTable();
		
		ht.put(emp6.getLastName(), emp6);
		
		System.out.println("Retrive key wilson "+ht.get("dravid"));
		
		ht.put(emp7.getLastName(), emp7);
		//ht.printHashTable();
		
		System.out.println("Retrive key wilson "+ht.get("Boucher"));
		
		ht.remove("Boucher");
		
		System.out.println("Retrive key wilson "+ht.get("Boucher"));
		ht.printHashTable();
		
		

	}

}