package com.qimh.contrller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qimh.domain.User;
import com.qimh.util.*;
import com.test.MyData;
/**
 * Servlet implementation class LoginClServlet
 */
public class LoginClServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		request.setCharacterEncoding("UTF-8");//�����������
		
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		
		
		
		
		
		
		
		
		
		
		
		if(("qiminhui".equals(username) && "123456".equals(pwd)) || ("������".equals(username) && "123456".equals(pwd))){//��ת������ҳ��
			//����cookie(api)
			if(ToolKit.isChinese(username)){//������������ʽ
				username = java.net.URLEncoder.encode(username,"utf-8");
			}
			
			

			
			//session ���Դ��ݶ���
			User user = new User();
			user.setUsername(username);
			user.setPwd(pwd);
			HttpSession session = request.getSession();
			session.setAttribute("userobj", user);
			
			MyData.username = username;
			MyData.pwd = pwd;
			response.sendRedirect("/UserManager/SuccessServlet?username="+username+"&pwd="+pwd);
			
			
			out.println("��¼�ɹ�");
		    System.out.println("��¼�ɹ�����������");
		}else{
			response.sendRedirect("/UserManager/LoginServlet");
			System.out.println("��¼ʧ�ܡ���������");
		}
		
		
		
		
		
		
		
		
		//session ��ʹ�ô���ֵ����һ��ҳ��
//		if(username != null && pwd != null){
//			HttpSession session = request.getSession();
//			session.setAttribute("username", username);
//			session.setAttribute("pwd", pwd);
//			response.sendRedirect("/UserManager/SuccessServlet");
//		}else{
//			response.sendRedirect("/UserManager/LoginServlet");
//			System.out.println("��¼ʧ�ܡ���������");
//		}
		
		
		
		
		
		/*  
		 * cookie ��ʹ��
		//�ж��û��Ƿ��Ѿ���¼��
		//��ȡ����cookie��Ϣ
		Cookie cookies[] = request.getCookies();
		//����cookie
		if(cookies != null){
			if(cookies.length > 0){
				for(int i=0;i<cookies.length;i++){
					Cookie cookie = cookies[i];
					out.println(cookie.getName()+":"+cookie.getValue()+"</br>");//cookieֻ�ܷ��ַ���
					if("qiminhui".equals(cookie.getName()) && "123456".equals(cookie.getValue())){
						out.println("��¼�ɹ�");
						System.out.println("�û��Ѿ���¼����������");
						return;
					}
				}
			}
		}
	
		System.out.println("�û�����"+username);
		System.out.println("���룺"+pwd);
		if(("qiminhui".equals(username) && "123456".equals(pwd)) || ("������".equals(username) && "123456".equals(pwd))){//��ת������ҳ��
			//����cookie(api)
			if(ToolKit.isChinese(username)){//������������ʽ
				username = java.net.URLEncoder.encode(username,"utf-8");
			}
			Cookie cookie=new Cookie("username",username);
			//����cookie����������
			cookie.setMaxAge(10);//3600��=1Сʱ
			 //��cookie��Ϣд�ظ������
			response.addCookie(cookie);
			
			
			//����cookie(api)
			Cookie cookie2=new Cookie("pwd",pwd);
			//����cookie����������
			cookie2.setMaxAge(10);
			 //��cookie��Ϣд�ظ������
			response.addCookie(cookie2);
			
			
			
			out.println("��¼�ɹ�");
		    System.out.println("��¼�ɹ�����������");
		}else{
			response.sendRedirect("/UserManager/LoginServlet");
			System.out.println("��¼ʧ�ܡ���������");
		}
		
		*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}
	
	


}
