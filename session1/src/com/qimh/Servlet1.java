package com.qimh;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet1
 */
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//test222333444555666
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//访问session[当发现没有session时候，就会自动创建一个session]
		HttpSession session = request.getSession();
		//给该session放入属性
		session.setAttribute("uname", "宋江");
		session.setAttribute("age", "100");
		//session 的生命周期（默认30，你也可以修改）
		session.setMaxInactiveInterval(20);//20s指的是 发呆时间
		
		
		//创建一个对象
		User user = new User();
		user.setName("小明");
		user.setAge(20);
		
		session.setAttribute("user", user);
		
		out.println("创建一个session");
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
