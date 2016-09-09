package com.qimh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestTest
 */
public class RequestTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//ָ��ҳ�治����
		//response.setDateHeader("Expires", -1);//ie ��ֹ����
		//response.setDateHeader("Expires", System.currentTimeMillis()+3600*1000);//����һ��Сʱ
		//Ϊ�˱�֤������
		//response.setHeader("Pragma", "no-cache");
		//response.setHeader("Cache-Control", "no-cache");
		
		out.println("hello world2222"+new Date().toString());
		System.err.println(" Exception .....");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
