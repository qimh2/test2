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
		out.println("<h1>����û���Ϣ</h1>");
		//action Ӧ������д /webӦ����/servlet��url
		out.println("<form action = '/UserManager2/UserClServlet' method = 'post'>");
		out.println("�û���:<input type = 'text' name = 'username'/>"+"</br>");
		out.println("��  ��:<input type = 'passpord' name = 'pwd'/></br>");
		out.println("����:<input type = 'text' name = 'email'/></br>");
		out.println("<input type = 'hidden' name = 'type' value = 'addUserService'/></br>");
		out.println("<input type = 'submit' value = '�ύ��Ϣ'/>");
		out.println("</form>");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);

	}

}
