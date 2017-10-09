package controller;

import database.DatabaseProvider;
import database.DerbyDatabase;
import database.IDatabase;
//import model.Account;
import model.GroupMember;

public class GroupMemberController {
	
	private IDatabase database = null;

	public GroupMemberController(){
		DatabaseProvider.setInstance(new DerbyDatabase());
		database = DatabaseProvider.getInstance();
	}
	
	public boolean createGroupMember(GroupMember groupMember){
		return this.database.insertNewGroupMemberIntoDatabase(groupMember);
	}
}