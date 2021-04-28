import java.sql.ResultSet;
import java.util.*;


public class M1 {
		
	String ID;
	String name;
	String email;
	String address;
	String refPer;
	
	// change to database stuff
	// map with multiple values per key
	public Map<Integer, ArrayList<String>> dict = new HashMap<Integer, ArrayList<String>>();
		
	// constructor for making client id and setting new client details
	public M1() {
		
		
//		Random rand = new Random();
//		int upperbound = 10000000;
//		ID = rand.nextInt(upperbound);
//		
//		while (dict.containsKey(ID));
//			ID = rand.nextInt(upperbound);
//		
//		dict.put(ID, new ArrayList<String>());	
//		
//		
//		for(int i = 0; i < 4; i++)
//			dict.get(ID).add("");			
//			
//		this.setName();
//		this.setEmail();
//		this.setAddress();
//		this.setRefPer();		
		this.ID = UUID.randomUUID().toString();
		this.name = name;
		this.email = email;
		this.address = address;
		this.refPer = refPer;
		
	}
	
	// setting details (name, email, address and reference person) and saving in map
	
	// for example like this, when doing the data base but idk
//	public void setRefPer(String refPer) {
//		databasename.put(refPer)

	
//	public void setName() {
//				
//		dict.get(ID).set(0, name);
//		
//	}
//	
//	public void setEmail() {
//				
//		dict.get(ID).set(1, email);
//		
//	}
//	
//	public void setAddress() {
//	
//		
//		dict.get(ID).set(2, address);
//		
//	}
//	
//	
//	public void setRefPer() {
//	
//		
//		dict.get(ID).set(3, refPer);
//		
//	}
	public String getID() {
		return ID;
	}
	
//	public void search() {
//		// should be changed according to databasing so one can search for id in database or name
//		Arrays.toString(dict.entrySet().toArray());
//	}
	public void registerCustomer() {
		String sql = String.format(
				"insert into Customer(Customerid,Name,"
						+ "Email,Address,Reference Person) "
						+ "values(\"%s\",\"%s\",\"%s\",\"%s\",\"%s\");",
				this.ID, this.name, this.email, this.address, this.refPer);
		DBConnection db = new DBConnection();
		db.update(sql);
		
	

	}
	
	public static String prepareStatement(String operation,String tableName,String id, String email, String name, String address, String refPer
			) {
		
		StringBuilder condition = new StringBuilder();
		if (id != null)
			condition.append(String.format("M1.ID = \"%s\" and", id));
		if (name != null)
			condition.append(String.format("M1.name = \"%s\" and", name));
		if (email != null)
			condition.append(String.format("M1.email = \"%s\" and ", email));
		if (address != null)
			condition.append(String.format("M1.address = \"%s\" and ", address));
		if (refPer != null)
			condition.append(String.format("M1.refPer = \"%s\" and ", refPer));
		if (condition.toString() != null) {
			condition.delete(condition.lastIndexOf("and"), condition.lastIndexOf("and") + 3);
		}
		String sql=operation+"* from "+tableName+" where "+condition.toString()+";";
		return sql;
	}
	
	
	
	
	
	public static ResultSet searchForCustomer(String id, String email, String name, String address, String refPer) {
		DBConnection db = new DBConnection();
		String sql=prepareStatement("select","customer",id,email,name,address,refPer);
		ResultSet s = db.read(sql);
		return s;

	}
	@Override
	public boolean equals(Object o) {
		if(o instanceof M1) {
			M1 m1=(M1) o;
			if(this.ID==m1.ID) {
				return true;
			}else {
				return false;
			}
		}
		return false;
	}
	
}

