// Alex - This class was previously known as "SearchController" but was taken over by me. It is now data controller
// and will serve my purposes.

package controller;
import java.sql.SQLException;
//import java.util.ArrayList;
import java.util.List;

//import javax.servlet.http.HttpServletRequest;


import database.DatabaseProvider;
import database.DerbyDatabase;
import database.IDatabase;
import model.Group;
 
public class DataController {

	private IDatabase database = null;

	public DataController() {

		// creating DB instance here
		DatabaseProvider.setInstance(new DerbyDatabase());
		database = DatabaseProvider.getInstance();		
	}

	/* Alex - Here are some example queries we'll likely need. We'll need more.
	getPlantByID()
	getPlantByStrand()
	getPollinatorByID()
	getPollinatorByVisitCount()
	getWeekByWeekNumber()
	getWeeksByDate()
	getAllDataByCounty()
	*/
	
	public List<Group> getGroupsLike(String keyword) throws SQLException {
		System.out.println("reached controller with keyword "+keyword);
		// get the list of (Author, Book) pairs from DB
		List<Group> groups = database.getGroupsLikeKeyword(keyword);
		for(int x = 0; x < groups.size(); x++){
			System.out.println(groups.get(x).getName());
		}

		if (groups.isEmpty()) {
			System.out.println("No groups in database like that keyword");
			return null;
		}
		else {
			return groups;
		}			

	}


	public int getGroupIDbyGroupname(String name) {
		List<Group> group = database.getGroupbyGroupName(name);
		int groupID = 0;
		String groupName;
		groupID = group.get(0).getGroupId();
		groupName = group.get(0).getName();
		System.out.println("Redirecting to "+ groupName);
		return groupID;
	}
}