package model;

public class Admin {

	private int admin_id;
	private String username;
	private String password;
	
	public Admin() {
		
	}
	public Admin(String username,String password) {
		this.username = username;
		this.password = password;
	}
	public void setAdminId(int admin_id) {
		this.admin_id=admin_id;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public void setPassword(String password) {
		this.password=password;
	}
	public int getAdminId() {
		return admin_id;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
}
