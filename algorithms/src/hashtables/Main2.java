package hashtables;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Employee emp1 = new Employee("Mark","Boucher",20);
		Employee emp2 = new Employee("Sachin","Tendulkar",20);
		Employee emp3 = new Employee("saurav","Ganguly",20);
		Employee emp4 = new Employee("Rahul","dravid",20);
		Employee emp5 = new Employee("Laxman","VVS",20);

		
		ChainedHashtable ht = new ChainedHashtable();
		ht.put(emp1.getLastName(), emp1);
		ht.put(emp2.getLastName(), emp2);
		ht.put(emp3.getLastName(), emp3);
		ht.put(emp4.getLastName(), emp4);
		ht.put(emp5.getLastName(), emp5);
		//ht.printHashTable();
	
		ht.printHashTable();
		
		System.out.println("Retrive key wilson "+ht.get("Boucher"));
		
		ht.remove("Boucher");
		
		System.out.println("Retrive key wilson "+ht.get("Boucher"));
		ht.printHashTable();
		
		

	}

}