package api.payload;

public class User {
	int id;
	String username;
	String firstName;
	String lastName;
	String email ;
	String passward;
	String phone;
	int userStates;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasswaord() {
		return passward;
	}
	public void setPasswaord(String passwaord) {
		this.passward = passwaord;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getUserStates() {
		return userStates;
	}
	public void setUserStates(int i) {
		this.userStates = i;
	}
	
}

// POJO class =  plain old java objects

// payload 
/*  {
		  "id": 0,
		  "username": "string",
		  "firstName": "string",
		  "lastName": "string",
		  "email": "string",
		  "password": "string",
		  "phone": "string",
		  "userStatus": 0
		}*/