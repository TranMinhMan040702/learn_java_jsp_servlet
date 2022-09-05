package com.laptrinhjavaweb.model;


public class UserModel extends AbstractModel<UserModel> {

	private String userName;
	private String fullName;
	private String passwork;
	private int status;
	private Long roleId;
	
	public String getPasswork() {
		return passwork;
	}
	public void setPasswork(String passwork) {
		this.passwork = passwork;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
}
