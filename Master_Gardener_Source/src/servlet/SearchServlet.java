
package servlet;

import java.io.IOException;
import java.sql.SQLException;
//import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.DataController;
//import controller.UserController;
//import model.Account;
import model.Group;

public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DataController controller = null;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
				
		controller = new DataController();
		String keyword;
		keyword = (String) req.getSession().getAttribute("keyword");
		List<Group> groups = null;
		try {
			if(keyword == null){
				System.out.println("Keyword not found");
			}
			else{
			groups = controller.getGroupsLike(keyword);
			
			}
			
			
			
		} catch (SQLException e) {
			
		}
		req.setAttribute("groups", groups);
		
		req.getRequestDispatcher("/_view/search.jsp").forward(req, resp);	
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		
		int groupID = 0;
		String buttonPress = req.getParameter("Submit");
		
		if(buttonPress != null){
			DataController controller = new DataController();
			groupID = controller.getGroupIDbyGroupname(buttonPress);
			req.getSession().setAttribute("GroupID", groupID);
			resp.sendRedirect(req.getContextPath()+"/group");
			return;
			
		}
		

		req.getRequestDispatcher("/_view/search.jsp").forward(req, resp);	
	}

}

/*
 * String keyword=null;
		keyword = req.getParameter("keyword");
		//System.out.println("reached servlet with keyword "+keyword);
		List<Group> groups = null;
		controller = new SearchController();
		try {
			groups = controller.getGroupsLike(keyword);
		}
		catch (SQLException e) {
		}
		req.setAttribute("groups", groups);
		

		*/