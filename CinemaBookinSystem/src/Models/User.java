package Models;

public class User {
private int id;
private String email;
private String phoneNumber;
private String password;
private String userRole;



public User(int id, String email, String phoneNumber, String password, String userRole) {
	super();
	this.id = id;
	this.email = email;
	this.phoneNumber = phoneNumber;
	this.password = password;
	this.userRole = userRole;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getUserRole() {
	return userRole;
}
public void setUserRole(String userRole) {
	this.userRole = userRole;
}


}
