package com.qimh.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

public class LoginAction implements RequestAware,SessionAware,ApplicationAware{
	
	private String username ;
	private String pwd ;
	private int age;
	
	public String login(){
		
		System.out.println("login.....");
		
		//1. 获取值栈
		//获取ActionContext
		ActionContext actionContext = ActionContext.getContext();
		ValueStack valueStack = actionContext.getValueStack();
		
		//2. 创建Test 对象，并为属性赋值
		Test test = new Test();
		test.setUsername("宋江");
		test.setPwd("654321");
		
		
		//3.把Test 对象压入到值栈的栈顶
		valueStack.push(test);
		
		
		sessionMap.put("loginaction", this);
		requestMap.put("test", test);
		
		return "success";
	}
	
	
	
	private List<Person> persons = new ArrayList<Person>();
	
	
	
	public List<Person> getPersons() {
		return persons;
	}

//	public void setPersons(List<Person> persons) {
//		this.persons = persons;
//	}

	public String testTag(){
		
		this.username = "武松";
		this.pwd = "654321";
		
		persons.add(new Person("DD", 11));
		persons.add(new Person("EE", 22));
		persons.add(new Person("CC", 33));
		persons.add(new Person("AA", 44));
		persons.add(new Person("BB", 55));
		
		System.out.println("--------------testTag-----------");
		return "success";
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	private Map<String, Object> applicationMap;
	public void setApplication(Map<String, Object> application) {
		// TODO Auto-generated method stub
		this.applicationMap = application;
	}

	private Map<String, Object> sessionMap;
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.sessionMap = session;
	}

	private Map<String, Object> requestMap;
	public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		this.requestMap = request;
	}

	
	
	
	
	
	
}
