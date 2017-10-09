package controller;

//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;

import database.DatabaseProvider;
import database.DerbyDatabase;
import database.IDatabase;
import model.Account;
//import model.Group;
//import model.Post;

public class EditUserController {

	private IDatabase database = null;

	public EditUserController() {

		// creating DB instance here
		DatabaseProvider.setInstance(new DerbyDatabase());
		database = DatabaseProvider.getInstance();		
	}

	public boolean updateAccountbyUsername(String username, String newusername, String description){
		Account hold = new Account();
		hold = database.queryForUserAccountByUsername(username);
		
		hold.setUsername(newusername);
		hold.setDescription(description);
		
		boolean worked = database.updateAccountByUsername(username, hold);
		
		return worked;
	}
	
	
	
	
}