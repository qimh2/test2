package com.qimh.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qimh.domain.Users;
import com.qimh.service.UsersService;
import com.qimh.utils.MyTools;

public class UserClServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html ;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		String type = request.getParameter("type");
		
		
		UsersService us = new UsersService();
		
		if("delUser".equals(type)){//删除用户---model
			//接收用户ID
			String id = request.getParameter("id");
			System.out.println("id:"+id);
			//调用UsersService完成删除
			
			if(us.delUser(id)){//成功
				//ok  forward
				request.setAttribute("info", "恭喜你，删除成功");
				request.getRequestDispatcher("/Ok").forward(request, response);
			}else{//失败
				request.setAttribute("info", "对不起，删除失败");
				request.getRequestDispatcher("/Err").forward(request, response);
			}
		}
		
		if("modUser".equals(type)){//修改用户信息---view
			
			String id = request.getParameter("id");
			//根据用户id 获取一个UsersBean
			//UsersService us = new UsersService();
			Users u =  us.getUesrById(id);
			
			
			//请求转发到修改页面
			request.setAttribute("users", u);//为了让下一个servlet（界面）使用我们的u对象，我们可以把该u对象放到request对象中
			request.getRequestDispatcher("/modUser").forward(request, response);
			
		}
		
		if("modUserService".equals(type)){//修改用户信息---model
			
			modUserService(request, response, us);
			
		}
		
		
		if("addUser".equals(type)){//添加用户--view
			//请求转发到修改页面
			request.getRequestDispatcher("/AddUserForm").forward(request, response);
		}
		
		if("addUserService".equals(type)){//添加用户---model
			addUserService(request, response, us);
			
		}
		

	}

	//修改用户信息
	private void modUserService(HttpServletRequest request,
			HttpServletResponse response, UsersService us)
			throws ServletException, IOException {
		//request.setCharacterEncoding("utf-8");
		//接收用户信息【思考，如果用户提交的数据格式不对，有一个验证】
		String id = request.getParameter("id");
		String username = MyTools.getNewString(request.getParameter("username"), "iso-8859-1", "utf-8");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String grade = request.getParameter("grade");
		
		
		System.out.println("修改用户 form 表单提交数据【");
		System.out.println("username:"+username);
		System.out.println("pwd:"+pwd);
		System.out.println("email:"+email);
		System.out.println("grade:"+grade);
		System.out.println("】修改用户 form 表单提交数据");
		
		
		Users u = new Users();
		u.setUsername(username);
		u.setPwd(pwd);
		u.setEmail(email);
		u.setId(Integer.parseInt(id));
		u.setGrade(Integer.parseInt(grade));
		//调用UsersService完成修改
		//UsersService us = new UsersService();
		if(us.modUser(u)){//成功
			//ok  forward
			request.setAttribute("info", "恭喜你，修改成功");
			request.getRequestDispatcher("/Ok").forward(request, response);
		}else{//失败
			request.setAttribute("info", "对不起，修改失败");
			request.getRequestDispatcher("/Err").forward(request, response);
		}
	}
	
	//添加用户
	private void addUserService(HttpServletRequest request,
			HttpServletResponse response, UsersService us)
			throws ServletException, IOException {
		//接收用户信息
		String username = MyTools.getNewString(request.getParameter("username"), "iso-8859-1", "utf-8");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String grade = request.getParameter("grade");
		
		System.out.println("添加用户 form 表单提交数据【");
		System.out.println("username:"+username);
		System.out.println("pwd:"+pwd);
		System.out.println("email:"+email);
		System.out.println("】添加用户 form 表单提交数据");
		
		
		//构建一个Users对象
		//把接收到的信息，封装成一个Users对象
		Users u = new Users();
		u.setUsername(username);
		u.setPwd(pwd);
		u.setEmail(email);
		u.setGrade(Integer.parseInt(grade));
		
		//UsersService us = new UsersService();
		if(us.addUser(u)){//成功
			//ok  forward
			request.setAttribute("info", "恭喜你，添加成功");
			request.getRequestDispatcher("/Ok").forward(request, response);
		}else{//失败
			request.setAttribute("info", "对不起，添加失败");
			request.getRequestDispatcher("/Err").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);

	}

}
