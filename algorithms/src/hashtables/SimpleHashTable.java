package hashtables;

public class SimpleHashTable {
	
	private StoredEmployee[] hashtable;

	public SimpleHashTable() {
		this.hashtable = new StoredEmployee[10];
	}
	
	
	private int hashKey(String key) {
		
		return key.length() % hashtable.length;
	}
	
	
	public void put(String key, Employee employee) {
		int hashedKey = hashKey(key);
		
		if(occupied(hashedKey)){
			// set a stop index - we need to know when to stop , ie if array ends then we need to stop
			// we will keep adding 1, if we reach end of array we loop around and until we reached the hashed key
			int stopIndex = hashedKey;
			
			// if first position we check is the last slot in the array, then set position to zero else increment by 1
			if(hashedKey == hashtable.length-1) {
				// this is the looping back to start of array when we hit the length of the array
				hashedKey = 0;
				
			}
			else
				hashedKey++;
			
			// keep probing until occupied and hashedkey is not stopindex
			while(occupied(hashedKey) && hashedKey!=stopIndex) {
				// the % below takes care of wrappign back to zero when we hit the length of the array
				hashedKey = (hashedKey+1 ) % hashtable.length;
			}
			
		}
		
		
		if(occupied(hashedKey))
			System.out.println("Sorry, there is already an employee at this position"+ hashedKey);
		else
			hashtable[hashedKey] = new StoredEmployee(key, employee);
	}
	
	public Employee get(String key) {
		int hashedKey = findKey(key);	
		
		if(hashedKey == -1)
			return null;
		
		return hashtable[hashedKey].employee;
	}
	
	
	public void printHashTable() {
		for(int i = 0; i<hashtable.length;i++) {
			if(hashtable[i]==null)
				System.out.println("Empty");
			else
				System.out.println("Position "+i+": "+hashtable[i].employee);
		}
	}
	
	private int findKey(String key) {
		int hashedKey = hashKey(key);
		
		if(hashtable[hashedKey]!=null && hashtable[hashedKey].key.equals(key)) {
			return hashedKey;
		}
		
		int stopIndex = hashedKey;

		if (hashedKey == hashtable.length - 1) {
			hashedKey = 0;

		} else
			hashedKey++;

		// keep probing until occupied and hashedkey is not stopindex
		while ( hashedKey != stopIndex && hashtable[hashedKey]!=null &&  !hashtable[hashedKey].key.equals(key)) {
			hashedKey = (hashedKey + 1) % hashtable.length;
		}
		
		if(hashtable[hashedKey]!=null && hashtable[hashedKey].key.equals(key)) {
			return hashedKey;
		}
		else {
			return -1;
		}
			
		
		
	}
	
	
	// linear probing - add 1 if already occupied - keep probing until you find empty spot
	// create  method to check if the specific  position is already occupied
	// update put method to use linear probing
	// update the get method to use linear probing
	private boolean occupied(int index) {
		return hashtable[index]!=null;
	}
	
	
	public Employee remove(String key) {
		int hashedKey = findKey(key);
		if(hashedKey == -1)
			return null;
		
		Employee employee = hashtable[hashedKey].employee;
	
		
		hashtable[hashedKey] = null;
		//rehashing
		StoredEmployee[] oldHashtable = hashtable;
		hashtable = new StoredEmployee[oldHashtable.length];
		
		for(int i =0;i< oldHashtable.length;i++) {
			if(oldHashtable[i]!=null)
				put(oldHashtable[i].key,oldHashtable[i].employee);
		}
		
		return employee;
		
		
	}
	
	
	

}
