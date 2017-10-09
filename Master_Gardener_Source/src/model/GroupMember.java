// Alex - I believe this is all old stuff from Logan's CS320 project, and as such I'm only keeping this here as
// source material for anyone else who believes they need it

package model;

public class GroupMember {
	private int memberId;
	private int accountId;
	private int groupId;
	
	public GroupMember(int groupID, int accountID){
		this.groupId = groupID;
		this.accountId = accountID;
	}
	
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	
	public void setGroupId(int groupId){
		this.groupId = groupId;
	}
	
	public void setAccountId(int accountId){
		this.accountId = accountId;
	}
	
	public int getMemberId() {
		return memberId;
	}
	
	public int getGroupId(){
		return this.groupId;
	}

	public int getAccountId(){
		return this.accountId;
	}
}