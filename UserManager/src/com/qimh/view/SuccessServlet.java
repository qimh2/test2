package com.qimh.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qimh.domain.User;
import com.test.MyData;

/**
 * Servlet implementation class SuccessServlet
 */
public class SuccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");//�����������
		
		//�˴����½�session��ֻ��ȥȡ�Ѿ�������session 
//		HttpSession session = request.getSession(false);
//		if(session != null){
//			String username = (String) session.getAttribute("username");
//			String pwd = (String) session.getAttribute("pwd");
//			
//			out.println("��¼�ɹ�</br>");
//			out.println("�û�����"+username);
//			out.println("���룺"+pwd);
//			
//			System.out.println(username+"----" + pwd);
//		}else{
//			response.sendRedirect("/UserManager/LoginServlet");
//			System.out.println("��¼ʧ�ܡ���������");
//		}
		
		
		
		String username = request.getParameter("username");
		username = new String(username.getBytes("ISO-8859-1"), "UTF-8");
		String pwd = request.getParameter("pwd");
		if(username != null && pwd != null){
	
			
			out.println("��¼�ɹ�</br>");
			out.println("�û�����"+username);
			out.println("���룺"+pwd);
			
			out.println("</br>��¼�ɹ�2</br>");
			out.println("�û���2��"+java.net.URLDecoder.decode(MyData.username,"utf-8"));
			out.println("����2��"+MyData.pwd);
			
			
			//��ȡsession �еĶ���
			User userObj = (User) request.getSession().getAttribute("userobj");
			
			out.println("</br>��¼�ɹ�3</br>");
			out.println("�û���3��"+java.net.URLDecoder.decode(userObj.getUsername(), "utf-8"));
			out.println("����3��"+userObj.getPwd());
			
			
			System.out.println(username+"----@@@@----" + pwd);
		}else{
			response.sendRedirect("/UserManager/LoginServlet");
			System.out.println("��¼ʧ�ܡ���������");
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
