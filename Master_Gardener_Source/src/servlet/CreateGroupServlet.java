package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CreateGroupController;
//import controller.LoginController;
import model.Group;

public class CreateGroupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
			req.getRequestDispatcher("/_view/createGroup.jsp").forward(req, resp);	
		}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String name = null;
		String description = null;
		String errorMessage = null;
		int rating = 0;

		name = req.getParameter("groupname");
		description = req.getParameter("description");
		rating = getIntFromParameter(req.getParameter("rating"));

		if("".equals(name) || name == null){
			errorMessage = "Invalid Group name, please re-enter";
			System.out.printf("%s", errorMessage);
			name = null;
		}
		else if("".equals(description) || description == null){
			errorMessage = "Invalid Description, please re-enter";
			System.out.printf("%s", errorMessage);
			description = null;
		}

		else if("".equals(rating) || rating == 0){
			errorMessage = "Invalid Rating, please re-enter";
			System.out.printf("%s", errorMessage);
			rating = 0;
		}

		else{
			Group group = new Group(name, description, rating);
			CreateGroupController controller = new CreateGroupController();

			if(controller.createGroup(group)){
				req.setAttribute("group", group);
				req.getRequestDispatcher("/_view/home.jsp").forward(req, resp);
			}
			else{
				errorMessage = "Unexpected Error.";
			}
		}

		req.setAttribute("groupname", name);
		req.setAttribute("description", description);
		req.setAttribute("rating", rating);
		req.setAttribute("errorMessage", errorMessage);

		req.getRequestDispatcher("/_view/createGroup.jsp").forward(req, resp);
	}
	
	private int getIntFromParameter(String s){
		if(s == null || s.equals("")) {
			return 0;
		} else {
			return Integer.parseInt(s);
		}
	}
}