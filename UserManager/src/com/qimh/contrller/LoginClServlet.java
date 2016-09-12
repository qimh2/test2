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
		
		request.setCharacterEncoding("UTF-8");//解决中文乱码
		
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		
		
		
		
		
		
		
		
		
		
		
		if(("qiminhui".equals(username) && "123456".equals(pwd)) || ("祁敏会".equals(username) && "123456".equals(pwd))){//跳转到其他页面
			//创建cookie(api)
			if(ToolKit.isChinese(username)){//名字是中文形式
				username = java.net.URLEncoder.encode(username,"utf-8");
			}
			
			

			
			//session 可以传递对象
			User user = new User();
			user.setUsername(username);
			user.setPwd(pwd);
			HttpSession session = request.getSession();
			session.setAttribute("userobj", user);
			
			MyData.username = username;
			MyData.pwd = pwd;
			response.sendRedirect("/UserManager/SuccessServlet?username="+username+"&pwd="+pwd);
			
			
			out.println("登录成功");
		    System.out.println("登录成功。。。。。");
		}else{
			response.sendRedirect("/UserManager/LoginServlet");
			System.out.println("登录失败。。。。。");
		}
		
		
		
		
		
		
		
		
		//session 的使用传递值给下一个页面
//		if(username != null && pwd != null){
//			HttpSession session = request.getSession();
//			session.setAttribute("username", username);
//			session.setAttribute("pwd", pwd);
//			response.sendRedirect("/UserManager/SuccessServlet");
//		}else{
//			response.sendRedirect("/UserManager/LoginServlet");
//			System.out.println("登录失败。。。。。");
//		}
		
		
		
		
		
		/*  
		 * cookie 的使用
		//判断用户是否已经登录过
		//读取所有cookie信息
		Cookie cookies[] = request.getCookies();
		//遍历cookie
		if(cookies != null){
			if(cookies.length > 0){
				for(int i=0;i<cookies.length;i++){
					Cookie cookie = cookies[i];
					out.println(cookie.getName()+":"+cookie.getValue()+"</br>");//cookie只能放字符串
					if("qiminhui".equals(cookie.getName()) && "123456".equals(cookie.getValue())){
						out.println("登录成功");
						System.out.println("用户已经登录过。。。。");
						return;
					}
				}
			}
		}
	
		System.out.println("用户名："+username);
		System.out.println("密码："+pwd);
		if(("qiminhui".equals(username) && "123456".equals(pwd)) || ("祁敏会".equals(username) && "123456".equals(pwd))){//跳转到其他页面
			//创建cookie(api)
			if(ToolKit.isChinese(username)){//名字是中文形式
				username = java.net.URLEncoder.encode(username,"utf-8");
			}
			Cookie cookie=new Cookie("username",username);
			//设置cookie的生命周期
			cookie.setMaxAge(10);//3600秒=1小时
			 //把cookie信息写回给浏览器
			response.addCookie(cookie);
			
			
			//创建cookie(api)
			Cookie cookie2=new Cookie("pwd",pwd);
			//设置cookie的生命周期
			cookie2.setMaxAge(10);
			 //把cookie信息写回给浏览器
			response.addCookie(cookie2);
			
			
			
			out.println("登录成功");
		    System.out.println("登录成功。。。。。");
		}else{
			response.sendRedirect("/UserManager/LoginServlet");
			System.out.println("登录失败。。。。。");
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
