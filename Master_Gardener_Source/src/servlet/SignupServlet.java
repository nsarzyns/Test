package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.LoginController;
import controller.SignupController;
import model.Account;

public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String username = req.getParameter("Username");
		String password = req.getParameter("Password");
		String button = req.getParameter("buttonPress");
		
		if(button != null){
			if(button.toLowerCase().equals("sign up")){
				req.setAttribute("username", username);
				req.setAttribute("password", password);
				req.getRequestDispatcher("/_view/signup.jsp").forward(req, resp);
			}
			else if(button.toLowerCase().equals("login")){
				boolean loggedin = false;
				String errorMessage = null;
				LoginController login = new LoginController();
				int loginId = login.loginUser(username, password);
				
				if(loginId>=0){
					req.getSession().setAttribute("username", username);
					req.getSession().setAttribute("login_id", loginId);
					loggedin = true;
					req.setAttribute("loggedin", loggedin);
				}
				else{
					errorMessage = "Invalid username or password, please try again.";
				}
				
				if(loggedin){
					
					req.setAttribute("account", login.returnAccountForUsername(username));
					req.getRequestDispatcher("/_view/signup.jsp").forward(req, resp);
				}
				else{
					req.setAttribute("username",username);
					req.setAttribute("errorMessage", errorMessage);
					req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
				}
			}
			else{
				req.getRequestDispatcher("/_view/home.jsp").forward(req, resp);
			}
		}	
		else{
			req.getRequestDispatcher("/_view/home.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String user = null;
		String pass1 = null;
		String pass2 = null;
		String name = null;
		String email = null;
		String bio = null;
		String errorMessage = null;
		//boolean loggedin = false;

		user = req.getParameter("username");
		pass1 = req.getParameter("pass1");
		pass2 = req.getParameter("pass2");
		name = req.getParameter("name");
		email = req.getParameter("email");
		bio = req.getParameter("bio");

		if("".equals(user) || user == null){
			errorMessage = "Invalid Username, please re-enter";
			System.out.printf("%s", errorMessage);
			user = null;
		}
		else if("".equals(pass1) || pass1 == null){
			errorMessage = "Invalid Password, please re-enter";
			System.out.printf("%s", errorMessage);
			pass1 = null;
		}

		else if("".equals(pass2) || pass2 == null){
			errorMessage = "Passwords don't match, please re-enter";
			System.out.printf("%s", errorMessage);
			pass2 = null;
		}

		else if(!pass2.equals(pass1)){
			errorMessage = "Passwords don't match, please re-enter";
			System.out.printf("%s", errorMessage);
			pass2 = null;
		}

		else if("".equals(name) || name == null){
			errorMessage = "Please re-enter Name";
			System.out.printf("%s", errorMessage);
			name = null;
		}

		else if("".equals(email) || email == null){
			errorMessage = "Please re-enter Email";
			System.out.printf("%s", errorMessage);
			email = null;
		}

		else if("".equals(bio) || bio == null){
			errorMessage = "Please re-enter Phone Number";
			System.out.printf("%s", errorMessage);
			bio = null;
		}
		else{
			Account account = new Account(user,pass1,-1,name, email, bio);
			SignupController controller = new SignupController();
		
			if(controller.createAccount(account)){
				
				req.getRequestDispatcher("/_view/home.jsp").forward(req, resp);
				
			}
			

			req.getRequestDispatcher("/_view/signup.jsp").forward(req, resp);
		}
	}
}