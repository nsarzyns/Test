package controller;

import database.DatabaseProvider;
import database.DerbyDatabase;
import database.IDatabase;
import model.Group;

public class CreateGroupController {
	
	private IDatabase database = null;

	public CreateGroupController(){
		DatabaseProvider.setInstance(new DerbyDatabase());
		database = DatabaseProvider.getInstance();
	}
	
	public boolean createGroup(Group group){
		return this.database.insertNewGroupIntoDatabase(group);
	}
}
