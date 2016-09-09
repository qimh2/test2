package com.qimh;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetRequestHeader
 */
public class GetRequestHeader extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String host = request.getHeader("Host");
		System.out.println("host:"+host);
		
		//getHeaderNames �������������Ұ�����http�������Ϣȫ����ȡ
		Enumeration headerNames = request.getHeaderNames();
		while(headerNames.hasMoreElements()){
			//ȡ����Ϣͷ������
			String headerName = (String) headerNames.nextElement();
			System.out.println(headerName+":"+request.getHeader(headerName));
			
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
