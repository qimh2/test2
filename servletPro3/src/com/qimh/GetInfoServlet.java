package com.qimh;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.Iterator;

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
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//�õ�url
		String url = request.getRequestURL().toString();
		out.println("url:"+url+"<br>");
		System.out.println("url:"+url);
		//�õ�uri
		String uri = request.getRequestURI().toString();
		out.println("uri:"+uri+"<br>");
		System.out.println("uri:"+uri);
		
		//queryString ׼ȷ��˵�����ǽ�����get��ʽ�ύ�Ĳ���
		String queryString = request.getQueryString();
		
		String[] params = queryString.split("&");
		for(String s:params){
			String[] param = s.split("=");
			String key = param[0];
			System.out.println(key+"="+URLDecoder.decode(MyTools.getNewString(param[1], "iso-8859-1", "utf-8"), "utf-8"));
			out.println(key+"="+URLDecoder.decode(MyTools.getNewString(param[1], "iso-8859-1", "utf-8"), "utf-8")+"<br>");
		}
		
		out.println("queryString:"+URLDecoder.decode(queryString,"utf-8")+"<br>");
		System.out.println("queryString:"+URLDecoder.decode(queryString,"utf-8"));
		
		//getRemoteAddr �������Ի�ȡ���󷽵�ip
		String remoteAddr = request.getRemoteAddr();
		out.println("remoteAddr:"+remoteAddr+"<br>");
		System.out.println("remoteAddr��"+remoteAddr);
//		if("192.168.1.54".equals(remoteAddr)){
//			response.sendRedirect("/servletPro3/Err");
//		}
		
		//getRemoteHost �������Ի�ȡ���󷽵�������������ͻ�û����dns��ע�ᣬ�򷵻�ip��ַ�����ע������򷵻ػ�����
		String remoteHost = request.getRemoteHost();
		out.println("remoteHost:"+remoteHost+"<br>");
		System.out.println("remoteHost��"+remoteHost);
		
		
		//getRemotePort ��ȡ�ͻ���ʹ�õĶ˿�
		int remotePort = request.getRemotePort();
		//getLocalPort ��ȡ������ʹ�õĶ˿�
		int serverPort = request.getLocalPort();
		out.println("�ͻ���:"+remoteAddr+"   ʹ�õĶ˿�:"+remotePort+"     ������ʹ�õĶ˿�:"+serverPort+"<br>");
		System.out.println("�ͻ���ʹ�õĶ˿�:"+remotePort+"     ������ʹ�õĶ˿�:"+serverPort+"<br>");
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
