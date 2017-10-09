package controller;

import javax.servlet.http.HttpServletRequest;
  
import database.DatabaseProvider;
import database.DerbyDatabase;
import database.IDatabase;
import model.Account;
import model.ObjectHandler;

public class LoginController {
	
	private IDatabase database = null;

	public LoginController(){
		DatabaseProvider.setInstance(new DerbyDatabase());
		database = DatabaseProvider.getInstance();
	}
	
	
	public boolean handleLoginCheck(HttpServletRequest req){
		String user = ObjectHandler.castObject(req.getSession().getAttribute("username"));
		if(user != null){
			Integer loginId = ObjectHandler.castObject(req.getSession().getAttribute("login_id"));
			loginId = this.validateLogin(user, loginId);
			if(loginId >= 0){
				req.getSession().setAttribute("login_id", loginId);
				req.setAttribute("account", this.returnAccountForUsername(user));
				req.setAttribute("loggedin", true);
				return true;
			}
		}
		req.setAttribute("loggedin", false);
		return false;
	}
	
	
	//returns new login id
	public int validateLogin(String username, int loginId){
		int persistantLoginId = this.database.queryForLoginIdByUsername(username);
		Account account = this.database.queryForUserAccountByUsername(username);
		if(persistantLoginId == loginId && loginId != -1){
			account.createLoginId();
		}
		else{
			account.resetLoginId();
		}
		this.database.updateAccountByUsername(username, account);
		return account.getLoginId();
	}

	//return new login id
	public int loginUser(String username, String password){
		int loginId = -1;
		String pass = this.database.queryForPasswordByUsername(username);
		//System.out.println(pass);
		if(pass!= null && password!=null){
			if(pass.equals(password)){
				Account account = this.database.queryForUserAccountByUsername(username);
				System.out.println("User:\n" + account.getUsername());
				//System.out.println(account.getUsername() + account.getPassword());
				loginId = account.createLoginId();
				this.database.updateAccountByUsername(username, account);
			}
		}
		return loginId;
	}
	
	public Account returnAccountForUsername(String username){
		return this.database.queryForUserAccountByUsername(username);
	}
}

