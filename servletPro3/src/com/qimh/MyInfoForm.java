package com.qimh;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyInfoForm
 */
public class MyInfoForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<form action='/servletPro3/RegisterCl' method = 'post'>");
		out.println("用户名：<input type = 'text' name = 'username'> <br>");
		out.println("密    码：<input type = 'password' name = 'pwd'> <br>");
		out.println("性别 ：<input type = 'radio' name = 'sex' value = '男'>  <input type = 'radio' name = 'sex' value = '女'><br>");
		out.println("你的爱好 ：<input type = 'checkbox' name = 'hobby' value = '音乐'>音乐  <input type = 'checkbox' name = 'hobby' value = '体育'>体育<input type = 'checkbox' name = 'hobby' value = '旅游'>旅游<br>");
		out.println("用户名：<input type = 'submit' value = '提交信息'>");
		out.println("</form>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
