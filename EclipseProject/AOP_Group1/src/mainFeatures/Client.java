package mainFeatures;
import java.sql.ResultSet;
import java.util.*;


public class Client {
		
	String ID;
	String name;
	String email;
	String address;
	String refPer;
	String password;
	List<Container> containers;
	
	
	// change to database stuff
	// map with multiple values per key
	public Map<Integer, ArrayList<String>> dict = new HashMap<Integer, ArrayList<String>>();
		
	// constructor for making client id and setting new client details
	public Client() {
		
		
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
	
	public void addContainer(Container newContainer) {
		containers.add(newContainer);
	}
	
	public void setName(String name) {
				this.name = name;	
	}
	public String getName() {
		return name;
	}
	public void setPassword(String password) {
		this.password = password;	
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setAddress(String address ) {
		this.address = address;
	}
	public void setRefPer(String refPer) {
		this.refPer = refPer;
	}
	public void replaceID(String ID) {
		this.ID = ID;
	}
	
	public String getID() {
		return ID;
	}
	
//	public void search() {
//		// should be changed according to databasing so one can search for id in database or name
//		Arrays.toString(dict.entrySet().toArray());
//	}
	public void registerClient() {
		String sql = String.format(
				"insert into client(Clientid,Name,"
						+ "Email,Address,Reference_Person) "
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
	
	
	
	
	
	public static ResultSet searchForClient(String id, String email, String name, String address, String refPer) {
		DBConnection db = new DBConnection();
		String sql=prepareStatement("select","client",id,email,name,address,refPer);
		ResultSet s = db.read(sql);
		return s;

	}
	@Override
	public boolean equals(Object o) {
		if(o instanceof Client) {
			Client m1=(Client) o;
			if(this.ID==m1.ID) {
				return true;
			}else {
				return false;
			}
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		Client client1 = new Client();
		client1.setName("Sony");
		client1.setAddress("Japan");
		client1.setEmail("Sony@Sony.com");
		client1.setRefPer("Hasuki sushi");
		client1.registerClient();
		
	}
	
	
}

