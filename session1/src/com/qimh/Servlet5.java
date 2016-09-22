package com.qimh;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet5
 */
public class Servlet5 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		//获取session
		HttpSession session = request.getSession();
		String uname = (String) session.getAttribute("uname");
		PrintWriter out = response.getWriter();
		
		//获取一个对象
		User user = (User) session.getAttribute("user");
		if(uname == null){
			out.println("session  失效");
		}else{
			out.println("uname:"+uname+"<br>");
			
			if(user != null){
				out.println("name:"+user.getName()+"<br>");
				out.println("age:"+user.getAge()+"<br>");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
