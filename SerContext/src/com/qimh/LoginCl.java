package com.qimh;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginCl
 */
public class LoginCl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String pwd = request.getParameter("pwd");
		
		String nums = (String) this.getServletContext().getAttribute("nums");
		
		
		System.out.println("pwd:"+pwd);
		if("123456".equals(pwd)){
			if(nums == null){//第一次访问网站的人
				this.getServletContext().setAttribute("nums","1");
			}else{
				this.getServletContext().setAttribute("nums", (Integer.parseInt(nums) + 1)+"");
			}
			
			System.out.println("==============in============");
			request.getRequestDispatcher("/Manager").forward(request, response);
			
		}else{
			request.getRequestDispatcher("/Login").forward(request, response);
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
