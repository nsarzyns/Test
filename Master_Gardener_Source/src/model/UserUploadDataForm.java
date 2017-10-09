// Alex - This entire form is completely tentative, as is every other class that I've added. Keep that in mind
// when you try to berate me.

package model;

public class UserUploadDataForm
{
	
	private int formID;
	
	// Date/Time user posted the requests to admins
	// private DateTime postDate
	
	// ID of the user that uploaded the form
	// private int userID;
	
	// TODO: 
	// Decide what information a user can and cannot upload, update this form as we make decisions.
	// Actually, that goes for everything. Update everything as we make decisions. The nameless writer
	// of this comment will use this singular TODO to cover his rump for not writing TODOs on anything else.
	// You've been warned.
	
	public UserUploadDataForm(/*int userID*/)
	{
		//this.userID = userID;
	}
	
	public void setFormID(int formID)
	{
		this.formID = formID;
	}
	
	public int getFormID()
	{
		return this.formID;
	}
}
