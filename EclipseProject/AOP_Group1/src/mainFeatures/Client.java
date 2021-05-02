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
	List<Container> containers = new ArrayList<Container>();
	
	

	// map with multiple values per key
	public Map<Integer, ArrayList<String>> dict = new HashMap<Integer, ArrayList<String>>();
		
	// constructor for making client id and setting new client details
	public Client() {		
		this.ID = UUID.randomUUID().toString();
	}
	

	
	List<Integer> test;
	
	
	public void addContainer(Container newContainer) {
		containers.add(newContainer);
	}
	
	public Container[] getContainers() {
		Container[] res = {null};
		if (containers == null) {
			return res;
		}
		
		return (Container[]) containers.toArray(res);
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
	
	public String getEmail() {
		return email;
	}
	
	public void setAddress(String address ) {
		this.address = address;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setRefPer(String refPer) {
		this.refPer = refPer;
	}
	
	public String getRefPer() {
		return refPer;
	}
	
	
	public void replaceID(String ID) {
		this.ID = ID;
	}
	
	public String getID() {
		return ID;
	}
	
	//methods for editing one part of a user's information in the dataBase
	public void editInfo(String newInfo, String category) {
		DBConnection db = new DBConnection();
		String sql = ("UPDATE client SET " + category + " = \"" + newInfo +"\" WHERE Clientid = \"" + ID + "\"");
		db.update(sql); //update the database
	}

	
	
	
	

	public void registerClient() {
		String sql = String.format(
				"insert into client(Clientid,Password,Name,"
						+ "Email,Address,Reference_Person) "
						+ "values(\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\");",
				this.ID,this.password, this.name, this.email, this.address, this.refPer);
		DBConnection db = new DBConnection();
		db.update(sql);
	}
	
	public static String prepareStatement(String operation,String tableName,String id, String email, String name, String address, String refPer
			) {
		
		StringBuilder condition = new StringBuilder();
		if (id != null)
			condition.append(String.format("Clientid = \"%s\" and ", id));
		if (name != null)
			condition.append(String.format("name = \"%s\" and ", name));
		if (email != null)
			condition.append(String.format("email = \"%s\" and ", email));
		if (address != null)
			condition.append(String.format("address = \"%s\" and ", address));
		if (refPer != null)
			condition.append(String.format("refPer = \"%s\" and ", refPer));
		if (!condition.isEmpty()) {
			condition.delete(condition.lastIndexOf("and"), condition.lastIndexOf("and") + 3 );
			String sql=operation+"* from "+tableName+" where "+condition.toString()+";";
			return sql;
		}
		String sql = operation + "* from " + tableName + ";";
		return sql;
	}
	
	
	
	public static ResultSet findAllClients() {
		DBConnection db = new DBConnection();
		String sql = "select * from client";
		ResultSet rs = db.read(sql);
		return rs;
		
		
	}
	
	public static ResultSet searchForClient(String id, String email, String name, String address, String refPer) {
		DBConnection db = new DBConnection();
		String sql=prepareStatement("select","client",id,email,name,address,refPer);
		ResultSet rs = db.read(sql);
		return rs;
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
		client1.setPassword("sonyIsBest");
		client1.setAddress("Japan");
		client1.setEmail("Sony@Sony.com");
		client1.setRefPer("Hasuki sushi");
		client1.registerClient();
		
	}
	
	
}

