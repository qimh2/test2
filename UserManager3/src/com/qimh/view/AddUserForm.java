package com.qimh.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddUserForm extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>添加用户信息</h1>");
		//action 应该这样写 /web应用名/servlet的url
		out.println("<form action = '/UserManager2/UserClServlet' method = 'post'>");
		out.println("用户名:<input type = 'text' name = 'username'/>"+"</br>");
		out.println("密  码:<input type = 'passpord' name = 'pwd'/></br>");
		out.println("邮箱:<input type = 'text' name = 'email'/></br>");
		out.println("<input type = 'hidden' name = 'type' value = 'addUserService'/></br>");
		out.println("<input type = 'submit' value = '提交信息'/>");
		out.println("</form>");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);

	}

}
