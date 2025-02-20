package hashtables;

import java.util.LinkedList;
import java.util.ListIterator;

// each array element in the hashtable will contain a linkedlist.

public class ChainedHashtable {

	// create a object array
	private LinkedList<StoredEmployee>[] hashtable;
	
	
	public ChainedHashtable() {
		hashtable = new LinkedList[10];
		
		for(int i = 0;i<hashtable.length;i++) {
			hashtable[i] = new LinkedList<StoredEmployee>();
		}
		
	}
	
	private int hashKey(String key) {
		
		//return key.length() % hashtable.length;
		// another way is to use string hashcode function to hashing
		
		return Math.abs(key.hashCode()%hashtable.length);
	}

	public void put(String key, Employee employee) {
		// TODO Auto-generated method stub
		
		int hashedKey = hashKey(key);
		hashtable[hashedKey].add(new StoredEmployee(key,employee));
		
	}
	
	public StoredEmployee get(String key) {
		int hashedKey = hashKey(key);
		ListIterator<StoredEmployee> itr = hashtable[hashedKey].listIterator();
		StoredEmployee employee = null;
		while(itr.hasNext()) {
			employee = itr.next();
			if(employee.key.equals(key)) {
				return employee;
			}
			
		}
		
		return null;
		
	}
	
	public StoredEmployee remove(String key) {
		int hashedKey = hashKey(key);
		ListIterator<StoredEmployee> itr = hashtable[hashedKey].listIterator();
		StoredEmployee employee = null;
		int index = -1;
		while(itr.hasNext()) {
			employee = itr.next();
			index++;
			if(employee.key.equals(key)) {
				break;
			}
			
		}
		
		if(employee == null) {
			return null;
		}else {
			hashtable[hashedKey].remove(index);
			return employee;
		}
		
		
	}

	public void printHashTable() {
		// TODO Auto-generated method stub
		
		for(int i = 0;i<hashtable.length;i++)
		{
			if(hashtable[i].isEmpty()) {
				System.out.println("Position "+i+" : empty");
			}
			else {
				System.out.println("Position "+i+" : ");

				ListIterator<StoredEmployee> itr = hashtable[i].listIterator();
				while(itr.hasNext()) {
					System.out.print(itr.next().employee);
					System.out.print("->");
				}
				System.out.println("null");
			}
		}
		
	}
	
	
	

}
