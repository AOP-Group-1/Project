import java.util.*;


public class M1 {
		
	int ID;
	String name;
	String email;
	String address;
	String refPer;
	
	// change to database stuff
	// map with multiple values per key
	public Map<Integer, ArrayList<String>> dict = new HashMap<Integer, ArrayList<String>>();
		
	// constructor for making client id and setting new client details
	public M1() {
		
		// change to the thing rachel and lee did
		Random rand = new Random();
		int upperbound = 10000000;
		ID = rand.nextInt(upperbound);
		
		while (dict.containsKey(ID));
			ID = rand.nextInt(upperbound);
		
		dict.put(ID, new ArrayList<String>());	
		
		
		for(int i = 0; i < 4; i++)
			dict.get(ID).add("");			
			
		this.setName();
		this.setEmail();
		this.setAddress();
		this.setRefPer();		
		
	}
	
	// setting details (name, email, address and reference person) and saving in map
	
	// for example like this, when doing the data base but idk
//	public void setRefPer(String refPer) {
//		databasename.put(refPer)

	
	public void setName() {
				
		dict.get(ID).set(0, name);
		
	}
	
	public void setEmail() {
				
		dict.get(ID).set(1, email);
		
	}
	
	public void setAddress() {
	
		
		dict.get(ID).set(2, address);
		
	}
	
	
	public void setRefPer() {
	
		
		dict.get(ID).set(3, refPer);
		
	}
	
	public void search() {
		// should be changed according to databasing so one can search for id in database or name
		Arrays.toString(dict.entrySet().toArray());
	}
}

