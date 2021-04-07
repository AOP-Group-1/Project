import java.util.*;

// make search function to search for clients using id or name
// make interface so info can be edited or one can  make a new client



class Client {
	Scanner s = new Scanner(System.in);
	
	int ID;
	String name;
	String email;
	String address;
	String refPer;
	
	// map with multiple values per key
	public Map<Integer, ArrayList<String>> dict = new HashMap<Integer, ArrayList<String>>();
		
	// constructor for making client id and setting new client details
	public Client() {
		
		Random rand = new Random();
		//Why is the following integer needed? And isn't it risky generating random numbers?
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
	public void setName() {
		System.out.print("Name: ");
		name = s.nextLine();
		
		dict.get(ID).set(0, name);
		
	}
	
	public void setEmail() {
		System.out.print("Email: ");
		email = s.nextLine();
		
		dict.get(ID).set(1, email);
		
	}
	
	public void setAddress() {
		System.out.print("Address: ");
		address = s.nextLine();
		
		dict.get(ID).set(2, address);
		
	}
	
	public void setRefPer() {
		System.out.print("Reference person: ");
		refPer = s.nextLine();
		
		dict.get(ID).set(3, refPer);
		
	}
	
	public void search() {
		Arrays.toString(dict.entrySet().toArray());
	}
}


public class M1 {
	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		while (true) {
			System.out.print("1 Add client \n2 edit client");
			
			System.out.println("your input");
			
			int input = s.nextInt();
			
			if (input == 1) {
				new Client();
			}
			
			
			else if (input == 2) {
				//dict.keySet();
				System.out.println("1 edit name \n 2 edit email \n3 edit address \n4 edit refper");
				System.out.println("your input");
				
				//int input = s.nextInt();
				
				if (input == 1) {
					//new setName();
				}
				
			}
			
			else if (input == 3);
				
		}
		
		
		
				

	}
}

