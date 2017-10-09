package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.GroupController;
import controller.GroupMemberController;
//import controller.SignupController;
import controller.UserController;
import model.Pair;
import model.Account;
import model.Group;
import model.GroupMember;
import model.Post;


public class GroupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GroupController controller = null;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String user = (String)req.getSession().getAttribute("username");
		if (user == null) {
			System.out.println("   User: <" + user + "> not logged in or session timed out");

			// user is not logged in, or the session expired
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}
		
		List<Group> groups = null;
		List<Group> groups2 = null;
		List<Pair<Account, Post>> posts = null;
		controller = new GroupController();
		int thisgroup = 0;
		thisgroup = (Integer)req.getSession().getAttribute("GroupID");
		try {
			if(thisgroup == 0){
				System.out.println("No group found");
			}
			else{
				groups = controller.getGroupbyID(thisgroup);
				posts = controller.getPostsbyGroupID(thisgroup);
				//System.out.println(posts.get(0).getText()+"\n"+posts.get(1).getText());

				
			}
		} catch (SQLException e) {

		}
		
		controller = new GroupController();
		try {
			groups2 = controller.getUsersGroups(user);
		} catch (SQLException e) {
			
		}
		
		Account account = new Account();
		controller = new GroupController();
		account = controller.returnAccountForUsername(user);
		
		req.setAttribute("groups", groups);
		req.setAttribute("groups2", groups2);
		req.setAttribute("posts", posts);
		req.setAttribute("account", account);

		req.getRequestDispatcher("/_view/group.jsp").forward(req, resp);		
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String button = null;
		String post = null;
		
		
		button = req.getParameter("postSubmit");
		
		if(button != null){
			GroupController controller = new GroupController();
			post = req.getParameter("newPost");
			String user = (String)req.getSession().getAttribute("username");
			int thisgroup = (int) req.getSession().getAttribute("GroupID");
			controller.addPost(post, thisgroup , user);
			List<Group> groups = new ArrayList<Group>();
			try {
				groups = controller.getGroupbyID(thisgroup);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			req.setAttribute("groups", groups);
			List<Pair<Account, Post>> posts = controller.getPostsbyGroupID(thisgroup);
			req.setAttribute("posts", posts);
			req.setAttribute("account", req.getAttribute("account"));
		}
		
		String button2 = null;
		
		button2 = req.getParameter("memberSubmit");
		
		if(button2 != null){
			int thisgroup = (int) req.getSession().getAttribute("GroupID");
			String user = (String)req.getSession().getAttribute("username");
		
			Account account = new Account();
			UserController controller = new UserController();
			account = controller.returnAccountForUsername(user);
		

			GroupMember groupMember = new GroupMember(thisgroup, account.getUserId());
			GroupMemberController controller2 = new GroupMemberController();
		
			if(controller2.createGroupMember(groupMember)){
				
				req.getRequestDispatcher("/_view/home.jsp").forward(req, resp);
			}
		}
	
		
		/*String button2 = null;
		
		button2 = req.getParameter("memberSubmit");
		
		if(button2 != null){
			GroupController controller = new GroupController();
			String user = (String)req.getSession().getAttribute("username");
			int thisgroup = (int) req.getSession().getAttribute("GroupID");
			controller.addGroupMember(thisgroup, user);
			List<Group> newGroup = new ArrayList<Group>();
			try {
				newGroup = controller.getGroupbyID(thisgroup);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			req.setAttribute("groups", newGroup);
		}*/
		
		int groupID = 0;
		//String user2 = (String)req.getSession().getAttribute("username");
		UserController controller3 = new UserController();
		String buttonPress = req.getParameter("Submit");
		
		if(buttonPress != null){
			try{
			groupID = controller3.getGroupIDbyGroupname(buttonPress);
			req.getSession().setAttribute("GroupID", groupID);
			resp.sendRedirect(req.getContextPath()+"/group");
			return;
			}catch (SQLException e){
				
			}
			
		}
		

		req.getRequestDispatcher("/_view/group.jsp").forward(req, resp);
	}
}
