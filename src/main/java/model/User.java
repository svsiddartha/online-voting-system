package model;

public class User {
	
	private int userId;
	private String name;
	private String email;
	private String password;
	private boolean hasVoted;
	
	public User() {
		
	}
	
	public User(String name,String email,String password) {
		this.name=name;
		this.email=email;
		this.password=password;
		this.hasVoted=false;
		
	}
	
	public void setUserId(int userId) {
		this.userId=userId;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setEmail(String email) {
		this.email=email;
	}
	public void setPassword(String password) {
		this.password=password;
	}
	public void sethasVoted(boolean hasVoted) {
		this.hasVoted=hasVoted;
	}
	public int getUserId() {
		return userId;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public boolean gethasVoted() {
		return hasVoted;
	}
	

}
