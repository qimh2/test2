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
		out.println("<h1> ������</h1>");
		out.println("��ӭXX��¼");
		out.println("<a href = '/UserManager2/LoginServlet'>�������µ�¼</a>");
		
		out.println("<h3> ��ѡ����Ҫ���еĲ���</h3>");
		out.println("<a href = '/UserManager2/ManagerUsers'>�����û�</a><br>");
		out.println("<a href = '/UserManager2/AddUserForm'>����û�</a><br>");
		out.println("<a href = '/UserManager2/FindUserForm'>�����û�</a><br>");
		out.println("<a href = '/UserManager2/LoginServlet'>�˳�ϵͳ</a>");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);

	}

}
