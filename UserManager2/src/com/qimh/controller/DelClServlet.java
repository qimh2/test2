package com.qimh.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qimh.service.UsersService;
import com.qimh.utils.MyTools;

public class DelClServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html ;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String type = request.getParameter("type");
		if("delUser".equals(type)){//删除用户
			//接收用户ID
			String id = request.getParameter("id");
			System.out.println("id:"+id);
			//调用UsersService完成删除
			UsersService us = new UsersService();
			if(us.delUser(id)){//成功
				//ok  forward
				request.getRequestDispatcher("/Ok").forward(request, response);
			}else{//失败
				request.getRequestDispatcher("/Err").forward(request, response);
			}
		}
		
		if("modUser".equals(type)){//修改用户信息
			//请求转发到修改页面
			request.getRequestDispatcher("/modUser").forward(request, response);
		}
		
		if("modUserService".equals(type)){//修改用户信息
			
			//request.setCharacterEncoding("utf-8");
			//接收参数
			String id = request.getParameter("id");
			String username = MyTools.getNewString(request.getParameter("username"), "iso-8859-1", "utf-8");
			String pwd = request.getParameter("pwd");
			String email = request.getParameter("email");
			
			
			System.out.println("修改用户 form 表单提交数据【");
			System.out.println("username:"+username);
			System.out.println("pwd:"+pwd);
			System.out.println("email:"+email);
			System.out.println("】修改用户 form 表单提交数据");
			
			
			//调用UsersService完成修改
			UsersService us = new UsersService();
			if(us.modUser(id, username, pwd, email)){//成功
				//ok  forward
				request.getRequestDispatcher("/Ok").forward(request, response);
			}else{//失败
				request.getRequestDispatcher("/Err").forward(request, response);
			}
			
			
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);

	}

}
