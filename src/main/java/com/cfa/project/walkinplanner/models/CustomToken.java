/**
 * 
 */
package com.cfa.project.walkinplanner.models;

import java.io.Serializable;

/**
 * @author RAKESH
 *
 */
public class CustomToken implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	private String userName;
	private String  password;
	private String  roleCode;
	private String  currentPlan;
	private String  token;
	
	public CustomToken() {
		// TODO Auto-generated constructor stub
	}
	
	public CustomToken(String userName, String password, String roleCode, String currentPlan, String token) {
		super();
		this.userName = userName;
		this.password = password;
		this.roleCode = roleCode;
		this.currentPlan = currentPlan;
		this.token = token;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	public String getCurrentPlan() {
		return currentPlan;
	}
	public void setCurrentPlan(String currentPlan) {
		this.currentPlan = currentPlan;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}

}
