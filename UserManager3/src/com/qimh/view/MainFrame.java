package com.qimh.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qimh.domain.Users;

public class MainFrame extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//��ȡsession ,����ֻ�ǻ�ȡsession��û�У��ͷ���null
		HttpSession session = request.getSession(false);
		if(session != null){
			Users users = (Users) session.getAttribute("userInfo");
			System.out.println("users:"+users);
			if(users == null){
				request.setAttribute("info", "�Ƿ���¼");
				request.getRequestDispatcher("/Ok").forward(request, response);
			}else{
				out.println("<h1> ������</h1>");
				out.println("��ӭXX��¼");
				out.println("<a href = '/UserManager3/LoginServlet'>�������µ�¼</a>");
				
				out.println("<h3> ��ѡ����Ҫ���еĲ���</h3>");
				out.println("<a href = '/UserManager3/ManagerUsers'>�����û�</a><br>");
				out.println("<a href = '/UserManager3/UserClServlet?type=addUser'>����û�</a><br>");
				out.println("<a href = '/UserManager3/FindUserForm'>�����û�</a><br>");
				out.println("<a href = '/UserManager3/LoginServlet'>�˳�ϵͳ</a>");
			}
		}else{
			request.setAttribute("info", "�Ƿ���¼");
			request.getRequestDispatcher("/Ok").forward(request, response);
		}
		

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);

	}

}
