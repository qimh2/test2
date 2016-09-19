package com.qimh.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainFrame extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h1> 主界面</h1>");
		out.println("欢迎XX登录");
		out.println("<a href = '/UserManager2/LoginServlet'>返回重新登录</a>");
		
		out.println("<h3> 请选择您要进行的操作</h3>");
		out.println("<a href = '/UserManager2/ManagerUsers'>管理用户</a><br>");
		out.println("<a href = '/UserManager2/AddUserForm'>添加用户</a><br>");
		out.println("<a href = '/UserManager2/FindUserForm'>查找用户</a><br>");
		out.println("<a href = '/UserManager2/LoginServlet'>退出系统</a>");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);

	}

}
