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
		out.println("�û�����<input type = 'text' name = 'username'> <br>");
		out.println("��    �룺<input type = 'password' name = 'pwd'> <br>");
		out.println("�Ա� ��<input type = 'radio' name = 'sex' value = '��'>  <input type = 'radio' name = 'sex' value = 'Ů'><br>");
		out.println("��İ��� ��<input type = 'checkbox' name = 'hobby' value = '����'>����  <input type = 'checkbox' name = 'hobby' value = '����'>����<input type = 'checkbox' name = 'hobby' value = '����'>����<br>");
		out.println("�û�����<input type = 'submit' value = '�ύ��Ϣ'>");
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
