package com.qimh;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet1
 */
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//����session[������û��sessionʱ�򣬾ͻ��Զ�����һ��session]
		HttpSession session = request.getSession();
		//����session��������
		session.setAttribute("uname", "�ν�");
		session.setAttribute("age", "100");
		//session ���������ڣ�Ĭ��30����Ҳ�����޸ģ�
		session.setMaxInactiveInterval(20);//20sָ���� ����ʱ��
		
		
		//����һ������
		User user = new User();
		user.setName("С��");
		user.setAge(20);
		
		session.setAttribute("user", user);
		
		out.println("����һ��session");
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
