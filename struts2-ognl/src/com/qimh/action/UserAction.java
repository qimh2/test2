package com.qimh.action;

import com.opensymphony.xwork2.ActionContext;

public class UserAction {
	
	private String userId ;
	private String username;
	private String pwd;
	private String des;
	
	private boolean married;
	public boolean isMarried() {
		return married;
	}
	public void setMarried(boolean married) {
		this.married = married;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public String save(){
		
		ActionContext actionContext = ActionContext.getContext();
		
		UserAction userAction = new UserAction();
		userAction.setUsername("宋江");
		userAction.setPwd("11111");
		userAction.setUserId("10001");
		userAction.setDes("水浒传英雄好汉");
		userAction.setMarried(true);
		
		//放入栈顶
		actionContext.getValueStack().push(userAction);
		
		System.out.println(this);
		
		return "input";
	}
	@Override
	public String toString() {
		return "UserAction [userId=" + userId + ", username=" + username
				+ ", pwd=" + pwd + ", des=" + des + ", married=" + married
				+ "]";
	}
	
	
	

}
