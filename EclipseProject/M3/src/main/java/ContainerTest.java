
public class ContainerTest {

	int temp;
	boolean isLoaded;
	boolean tempAdded;
	boolean successStatus;


	public void setLoadedStatus(boolean isLoaded) {
		this.isLoaded = isLoaded;
	}

	public ContainerTest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean setTemp(int temp) {
		this.temp = temp;
		if(temp < 50) {
			successStatus = true;
		}
		else {
			successStatus = false;
		}
		return successStatus;
	}

	public void setTempAdded(boolean tempAdded) {
		this.tempAdded = tempAdded;
	}
	
	
	
	
	
}
