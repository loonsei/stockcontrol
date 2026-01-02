// 22504421 Amy Johnson 

public class customer {
	
	int custID;
	String name;
	String email;
	String phone; // string not int in case customers use spaces
	
	// generate random 6 digit number for ID, adds 100000 so id can never be less than 6 digits
	int num = (int)(Math.random() * 900000) + 100000;

	public customer(int custID, String name, String email, String phone)
	{
		this.custID = num;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}
	
	// getters and setters
	public int getCustID() {
		return custID;
	}

	public void setCustID(int custID) {
		this.custID = custID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}