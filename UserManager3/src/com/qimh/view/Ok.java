package com.qimh.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ok extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html ;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(request.getAttribute("info")+"<br>");
		String servlet = "MainFrame";
		String message = "����������";
		if(request.getAttribute("info") != null){
			if("�Ƿ���¼".equals(request.getAttribute("info"))){
				servlet = "LoginServlet";
				message = "���ص�¼ҳ��";
			}
		}
		out.println("<a href='/UserManager3/"+servlet+"'>"+message+"</a>");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);

	}

}
