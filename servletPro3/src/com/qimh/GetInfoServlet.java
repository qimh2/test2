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
		
		//得到url
		String url = request.getRequestURL().toString();
		out.println("url:"+url+"<br>");
		System.out.println("url:"+url);
		//得到uri
		String uri = request.getRequestURI().toString();
		out.println("uri:"+uri+"<br>");
		System.out.println("uri:"+uri);
		
		//queryString 准确的说，就是接收以get方式提交的参数
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
		
		//getRemoteAddr 函数可以获取请求方的ip
		String remoteAddr = request.getRemoteAddr();
		out.println("remoteAddr:"+remoteAddr+"<br>");
		System.out.println("remoteAddr："+remoteAddr);
//		if("192.168.1.54".equals(remoteAddr)){
//			response.sendRedirect("/servletPro3/Err");
//		}
		
		//getRemoteHost 函数可以获取请求方的主机名，如果客户没有在dns上注册，则返回ip地址，如果注册过，则返回机器名
		String remoteHost = request.getRemoteHost();
		out.println("remoteHost:"+remoteHost+"<br>");
		System.out.println("remoteHost："+remoteHost);
		
		
		//getRemotePort 获取客户机使用的端口
		int remotePort = request.getRemotePort();
		//getLocalPort 获取服务器使用的端口
		int serverPort = request.getLocalPort();
		out.println("客户机:"+remoteAddr+"   使用的端口:"+remotePort+"     服务器使用的端口:"+serverPort+"<br>");
		System.out.println("客户机使用的端口:"+remotePort+"     服务器使用的端口:"+serverPort+"<br>");
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
