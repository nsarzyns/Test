package controller;

import java.sql.SQLException;
//import java.util.ArrayList;
import java.util.List;

import database.DatabaseProvider;
import database.DerbyDatabase;
import database.IDatabase;
import model.Pair;
import model.Account;
import model.Group;
import model.GroupMember;
import model.Post;

public class GroupController {

	private IDatabase database = null;

	public GroupController() {

		// creating DB instance here
		DatabaseProvider.setInstance(new DerbyDatabase());
		database = DatabaseProvider.getInstance();		
	}

	public Account returnAccountForUsername(String username){
		return this.database.queryForUserAccountByUsername(username);
	}

	public List<Post> getpostsbyUserandGroups(String user){
		return null;
	}

	public List<Group> getUsersGroups(String user) throws SQLException {


		List<Group> groups = database.getGroupsByUser(user);


		if (groups.isEmpty()) {
			System.out.println("No groups in database for that user");
			return null;
		}
		else {
			return groups;
		}			
	}

	public List<Group> getGroupbyID(int ID) throws SQLException {
		List<Group> groups = database.getGroupbyGroupID(ID);
		if(groups.isEmpty()){
			System.out.println("No groups in database for that ID");
			return null;
		}
		else{
			return groups;
		}
	}
	
	public List<Pair<Account, Post>> getPostsbyGroupID(int ID) {
		List<Pair<Account, Post>> posts = database.getPostsbyGroupID(ID);
		if(posts.isEmpty()){
			System.out.println("No posts for group");
			return null;
		}
		else{
			return posts;
		}
	}
	
	public boolean addPost(String text, int group, String username){
		boolean worked = false;
		List<Group> thisgroup = database.getGroupbyGroupID(group);
		Account thisaccount = database.queryForUserAccountByUsername(username);
		Post post = new Post(text, thisaccount.getUserId(), thisgroup.get(0).getGroupId());
		worked = database.insertNewPostIntoDatabase(post);
		return worked;
	}
	
	public boolean addGroupMember(int group, String username){
		boolean worked = false;
		List<Group> thisgroup = database.getGroupbyGroupID(group);
		Account thisaccount = database.queryForUserAccountByUsername(username);
		GroupMember groupMember = new GroupMember(thisgroup.get(0).getGroupId(), thisaccount.getUserId());
		worked = database.insertNewGroupMemberIntoDatabase(groupMember);
		return worked;
	}
	
	
}
