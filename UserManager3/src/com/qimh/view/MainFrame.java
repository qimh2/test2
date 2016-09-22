package com.qimh.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qimh.domain.Users;

public class MainFrame extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//获取session ,这里只是获取session，没有，就返回null
		HttpSession session = request.getSession(false);
		if(session != null){
			Users users = (Users) session.getAttribute("userInfo");
			System.out.println("users:"+users);
			if(users == null){
				request.setAttribute("info", "非法登录");
				request.getRequestDispatcher("/Ok").forward(request, response);
			}else{
				out.println("<h1> 主界面</h1>");
				out.println("欢迎XX登录");
				out.println("<a href = '/UserManager3/LoginServlet'>返回重新登录</a>");
				
				out.println("<h3> 请选择您要进行的操作</h3>");
				out.println("<a href = '/UserManager3/ManagerUsers'>管理用户</a><br>");
				out.println("<a href = '/UserManager3/UserClServlet?type=addUser'>添加用户</a><br>");
				out.println("<a href = '/UserManager3/FindUserForm'>查找用户</a><br>");
				out.println("<a href = '/UserManager3/LoginServlet'>退出系统</a>");
			}
		}else{
			request.setAttribute("info", "非法登录");
			request.getRequestDispatcher("/Ok").forward(request, response);
		}
		

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);

	}

}
