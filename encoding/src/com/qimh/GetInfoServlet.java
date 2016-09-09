package com.qimh;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qimh.utils.MyTools;

/**
 * Servlet implementation class GetInfoServlet
 */
public class GetInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		//request.setCharacterEncoding("utf-8");
		//如果是get提交，则
		
		String username = request.getParameter("username");
		
		username = MyTools.getNewString(username, "iso-8859-1","utf-8");//new String(username.getBytes("iso-8859-1"),"utf-8");
		
		System.out.println("username:"+username);
		
		
		//把它接收到的数据传递给下一个页面
		response.sendRedirect("/encoding/Wel?username="+request.getParameter("username"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
