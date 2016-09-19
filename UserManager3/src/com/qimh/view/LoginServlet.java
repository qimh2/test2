package com.qimh.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>用户登录</h1>");
		//action 应该这样写 /web应用名/servlet的url
		out.println("<form action = '/UserManager3/LoginClServlet' method = 'post'>");
		out.println("用户id:<input type = 'text' name = 'id'/>"+"</br>");
		out.println("密&nbsp&nbsp 码:<input type = 'passpord' name = 'pwd'/></br>");
		out.println("<input type = 'submit' value = '登录'/>");
		out.println("</form>");
		String errInfo = (String) request.getAttribute("err");
		if(errInfo != null){
			out.println("<font style = 'color:red;'>"+errInfo+"</font>");
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);

	}

}
