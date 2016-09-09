package com.qimh;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterCl
 */
public class RegisterCl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		request.setCharacterEncoding("utf-8");
		
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		String sex = request.getParameter("sex");
		
		//如果接收复选框的内容，则使用getParameterValues
		String[] hobby = request.getParameterValues("hobby");
		
		System.out.println("username:"+username);
		System.out.println("pwd:"+pwd);
		System.out.println("sex:"+sex);
		if(hobby != null){
			for(int i = 0;i < hobby.length;i++){
				System.out.println("hobby:"+hobby[i]+"<br>");
			}
		}else{
			System.out.println("你没有爱好。。。。");
		}
		
		
		
		
		
		out.println("username:"+username+"<br>");
		out.println("pwd:"+pwd+"<br>");
		out.println("sex:"+sex+"<br>");
		if(hobby != null){
			for(int i = 0;i < hobby.length;i++){
				out.println("hobby:"+hobby[i]+"<br>");
			}
		}else{
			out.println("你没有爱好。。。。");
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
