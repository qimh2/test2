package com.qimh.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qimh.domain.Users;
import com.qimh.service.UsersService;
import com.qimh.utils.MyTools;

/**
 * Servlet implementation class modUser
 */
public class modUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//接收参数
//		String id = URLDecoder.decode(request.getParameter("id"), "utf-8");
//		String username = MyTools.getNewString(URLDecoder.decode(request.getParameter("username"), "utf-8"), "iso-8859-1", "utf-8");
//		String pwd = URLDecoder.decode(request.getParameter("pwd"), "utf-8");
//		String email = URLDecoder.decode(request.getParameter("email"), "utf-8");
		
		
//		String id = request.getParameter("id");
//		//根据用户id 获取一个UsersBean
//		UsersService us = new UsersService();
//		Users u =  us.getUesrById(id);
		
		//获取从控制器传递的users对象
		Users u = (Users) request.getAttribute("users");
		String username =  u.getUsername();
		String pwd = u.getPwd();
		String email = u.getEmail();
		String id = String.valueOf(u.getId());
		String grade = String.valueOf(u.getGrade());
		
		System.out.println("username"+username);
		System.out.println("pwd"+pwd);
		System.out.println("email"+email);
		System.out.println("grade"+grade);
		
		//显示
		out.println("<h1>修改用户信息</h1>");
		//action 应该这样写 /web应用名/servlet的url
		out.println("<form action = '/UserManager3/UserClServlet' method = 'post'>");
		out.println("用户名:<input type = 'text' name = 'username'/ value = '"+username+"'>"+"</br>");
		out.println("密  码:<input type = 'passpord' name = 'pwd' value = '"+pwd+"'/></br>");
		out.println("邮箱:<input type = 'text' name = 'email' value = '"+email+"'/></br>");
		out.println("用户等级:<input type = 'text' name = 'grade' value = '"+grade+"'/></br>");
		out.println("<input type = 'hidden' name = 'id' value = '"+id+"'/>");
		out.println("<input type = 'hidden' name = 'type' value = 'modUserService'/>");
		out.println("<input type = 'submit' value = '修改用户'/>");
		out.println(" <input type='reset' value='重置用户' />");
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
