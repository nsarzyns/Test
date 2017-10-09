package database;

import static org.junit.Assert.*;

//import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import database.DatabaseProvider;
import database.DerbyDatabase;
import database.IDatabase;
import model.Account;
import model.Group;
import model.Pair;
import model.Post;

public class DerbyDatabaseTest {

	private IDatabase db = null;
	
	@Before
	public void setUp() throws Exception {
		
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();
		db.dropTables();
		db.createTables();
		db.loadInitialData();
	}
	
	
	@Test
	public void testqueryForLoginIdByUsername() {
		System.out.println("Testing: queryforloginidbyusername");
		int id = -1;
		int test = db.queryForLoginIdByUsername("admin1");
		assertEquals(id, test);
	}
	
	@Test //need to add data so that a group member has more than one group	//This test also calls loadGroup method
	public void testgetGroupsByUser() throws SQLException{
		System.out.println("Testing: getGroupsByUser");
		List<Group> groups = new ArrayList<Group>();
		groups = db.getGroupsByUser("admin2");
		assertEquals(groups.get(0).getName(), "Group2");
	}

	@Test //This test also calls loadaccount method
	public void testqeueryForUserAccountsByUsername(){
		System.out.println("Testing: queryForUserAccountByUsername");
		Account admin1 = new Account("admin1", "password1", -1, "a_name1", "admin1@ycp.edu", "HEY GUYS I’M ADMIN ONE LETS HAVE SOME FUN");
		Account test = db.queryForUserAccountByUsername("admin1");
		assertEquals(admin1.getName(), test.getName());
		assertEquals(admin1.getEmail(), test.getEmail());
		assertEquals(admin1.getLoginId(), test.getLoginId());
		assertEquals(admin1.getPassword(), test.getPassword());
		assertEquals(admin1.getDescription(), test.getDescription());
		assertEquals(admin1.getUsername(), test.getUsername());
	}
	
	@Test
	public void testqueryForPasswordByUsername(){
		System.out.println("Testing: queryForPasswordByUsername");
		String pass = "password2";
		String test = db.queryForPasswordByUsername("admin2");
		assertEquals(pass, test);
		
	}
	
	@Test	//if false - then verifyAccountExistsByUsername is covered
	public void testupdateAccountbyusername(){
		try{
		System.out.println("Testing: updateAccountbyusername");
		Account admin1s = new Account("admin1s", "password1s", -1,"a_name1", "admin1@ycp.edu", "717-123-4567");
		boolean passed = db.updateAccountByUsername("admin1", admin1s);
		boolean failed = db.updateAccountByUsername("asdf", admin1s);
		assertEquals(passed, true);
		assertEquals(failed, false);
		}
		finally{
			Account reset = new Account("admin1", "password1", -1, "a_name1", "admin1@ycp.edu", "717-123-4567");
			db.updateAccountByUsername("admin1s", reset);
		}
	}
	
	
	@Test
	public void testinsertNewAccountIntoDatabase(){
		System.out.println("Testing: insertNewAccountIntoDatabase");
		Random rand = new Random();
		int r = rand.nextInt(1000000);
		Account newb = new Account("ASDF", "ASDF", r, "Adolph", "derfurer@germany.gov", "666-666-6666");
		boolean passed = db.insertNewAccountIntoDatabase(newb);
		assertEquals(passed, true);
		
		
	}
	
	@Test
	public void testgetPostsbyGroupID(){
		System.out.println("Testing: getPostsbyGroupID");
		Post apost = new Post();
		apost.setAccountId(1);
		apost.setGroupId(1);
		apost.setPostId(1);
		apost.setText("Admin1_Comment1");
		List<Pair<Account, Post>> test = db.getPostsbyGroupID(1);
		assertEquals(test.get(1).getRight().getText(), apost.getText());
		assertEquals(test.get(1).getRight().getGroupId(), apost.getGroupId());
		assertEquals(test.get(1).getRight().getPostId(), apost.getPostId());
		assertEquals(test.get(1).getRight().getText(), apost.getText());
		
	}
	
	
	@Test
	public void testinsertGroupintoDatabase(){
		System.out.println("Testing: insertGroupintoDatabase");
		Group agroup = new Group("Group50", "Description50", 50);
		boolean passed = db.insertNewGroupIntoDatabase(agroup);
		assertEquals(passed, true);
		List<Group> test = db.getGroupbyGroupID(5);
		assertEquals(test.get(0).getName(), "Group50");
		
	}
	
	
	
	
	//Full code coverage on the private methods still need additional testing
	//Need to test inflate account and it needs to be called in the derbydatabase
	//Need to test loadGroupMember and it need to be called in the derbydatabase
	//Need to test getAccountFromUserId and it need to be called in the derbydatabase
	
	//Should probably have testing on 
	//createtables
	//droptables
	//load initial data
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}


