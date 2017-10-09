package controller;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controller.GroupController;
import database.DatabaseProvider;
import database.DerbyDatabase;
import database.IDatabase;
import model.Account;
import model.Group;

public class GroupControllerTest {

	private IDatabase db = null;
	GroupController thiscontroller = new GroupController();
	
	@Before
	public void setUp() throws Exception {
		
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();	
		db.dropTables();
		db.createTables();
		db.loadInitialData();
	}
	
	@Test
	public void testreturnAccountForUsername(){
		Account admin = new Account("admin1", "password1", -1, "a_name1", "admin1@ycp.edu", "HEY GUYS I’M ADMIN ONE LETS HAVE SOME FUN");
		Account test = thiscontroller.returnAccountForUsername("admin1");
		assertEquals(admin.getName(), test.getName());
		assertEquals(admin.getLoginId(), test.getLoginId());
		assertEquals(admin.getEmail(), test.getEmail());
		assertEquals(admin.getPassword(), test.getPassword());
		assertEquals(admin.getDescription(), test.getDescription());
		assertEquals(admin.getUsername(), test.getUsername());
	}
	
	@Test
	public void testgetUsersGroups() throws SQLException{
		List<Group> groups = new ArrayList<Group>();
		groups = thiscontroller.getUsersGroups("admin2");
		assertEquals(groups.get(0).getName(), "Group2");
	}
	
	@Test
	public void testgetGroupbyID() throws SQLException{
		List<Group> groups = new ArrayList<Group>();
		groups = thiscontroller.getGroupbyID(1);
		assertEquals(groups.get(0).getName(), "Group1");
		assertEquals(groups.get(0).getDescription(), "Description1");
	}
}


