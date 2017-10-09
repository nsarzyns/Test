package model;

import java.util.Random;

// Alex - I was going to create my own user page but this was already here, so for now we'll use this while keeping
// in mind that it's subject to change.

public class Account {
	private int userId;
	private String username = null;
	private String password = null;
	private int loginId = -1;
	private String name = null;
	private String email = null;
	private String description = null;

	
	public Account(String username, String password, int id, String name, String email, String description){
		/*if(username.equals("") || password.length() < 8 || id <= 0 || name.equals("") || email.equals("") || description.equals(""))
		{
			throw new IllegalArgumentException("There is an error with one or more argument(s).\n" +
					"Username is a required field.\n" +
					"Password requires AT LEAST 8 characters.\n" +
					"ID must be a non-zero positive integer.\n" +
					"Name/Email/Description are all required fields.");
		} */

		this.username = username;
		this.password = password;
		this.loginId = id;
		this.name = name;
		this.email = email;
		this.description = description;
	}
	
	public Account(){
		this.username = "";
		this.password = "";
		this.loginId = 0;
		this.name = "";
		this.email = "";
		this.description = "";
	}
	
	
	/*
	 * ------------------------GETTERS AND SETTERS---------------------------------
	 */
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public String getUsername(){
		return this.username;
	}
	
	public String getPassword(){
		return this.password;
	}
	
	public int getLoginId(){
		return this.loginId;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getEmail(){
		return this.email;
	}
	
	public String getDescription(){
		return this.description;
	}
	
	public void setUsername(String user){
		this.username = user;
	}
	
	public void setPassword(String pass){
		this.password = pass;
	}
	
	public void setLoginId(int id){
		this.loginId = id;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
	
	/*
	 * -------------------------HELPER METHODS----------------------------
	 */
		
	public int createLoginId() {
		Random r = new Random();
		this.loginId = r.nextInt(99999999);
		return this.loginId;
	}
	
	public int resetLoginId(){
		this.loginId = -1;
		return this.loginId;
	}
	
	/*
	 * -----------------------VALIDATION METHODS----------------------------
	 */
	
	//TODO
	
}