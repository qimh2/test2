package com.qimh.controller;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.qimh.domain.Users;
import com.qimh.service.UsersService;
import com.qimh.utils.MyTools;

public class LoginClServlet extends HttpServlet {
	
	String url = "jdbc:mysql://localhost:3306/web";//连接数据的RUL地址
	String user = "root";//数据库的用户名
	String password = "123456";//数据库的密码
	public static Connection connection ;//连接对象
	public static PreparedStatement statement;//语句对象
	public static ResultSet resultSet;//结果集对象

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		//接受用用户提交的用户名和面
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		
		//检查id是否为数字
		if(!MyTools.isNumeric(id)){
			request.setAttribute("err", "用户id必须为数字");
			request.getRequestDispatcher("/LoginServlet").forward(request, response);
			return;
		}
		
		
		//创建UserService对象，完成到数据库的验证
		UsersService us = new UsersService();
		Users users = new Users();
		users.setId(Integer.parseInt(id));
		users.setPwd(pwd);
		
		if(us.checkUser(users)){
			//该用户合法
			//action 应该这样写 /web应用名/servlet的url
			//response.sendRedirect("/UserManager/MainFrame");//请求重定向
			System.out.println("登录成功。。。。。");
			request.getRequestDispatcher("/MainFrame").forward(request, response);//请求转发
		}else{
			//用户非法，调回登录页面
			//response.sendRedirect("/UserManager/LoginServlet");
			System.out.println("登录失败。。。。。");
			request.setAttribute("err", "用户id或者密码有误");
			request.getRequestDispatcher("/LoginServlet").forward(request, response);
		}
		
//		//到数据库中取验证
//		
//		//因为Servlet 本身就是一个java类，因此我们servlet操作数据库和普通的java类没有区别
//		try {
//			//1.加载驱动
//			Class.forName("com.mysql.jdbc.Driver");
//			//2.得到连接
//			connection = (Connection) DriverManager.getConnection(url, user, password);
//			if(connection != null){
//				System.out.println("数据连接正常！");
//			}else{
//				System.out.println("数据库连接失败！");
//			}
//			//3.创建preparedStatement
//			String sql = "select * from users where id=? and password=?";
//			statement =  (PreparedStatement) connection.prepareStatement(sql);
//			//给？赋值
//			statement.setObject(1, id);
//			statement.setObject(2, pwd);
//			//4.执行操作
//			resultSet = statement.executeQuery();
//			
//			System.out.println("1111");
//			
//			//5.根据结果做处理
//			if(resultSet.next()){
//				//该用户合法
//				//action 应该这样写 /web应用名/servlet的url
//				//response.sendRedirect("/UserManager/MainFrame");//请求重定向
//				System.out.println("登录成功。。。。。");
//				request.getRequestDispatcher("/MainFrame").forward(request, response);//请求转发
//			}else{
//				//用户非法，调回登录页面
//				//response.sendRedirect("/UserManager/LoginServlet");
//				System.out.println("登录失败。。。。。");
//				request.setAttribute("err", "用户id或者密码有误");
//				request.getRequestDispatcher("/LoginServlet").forward(request, response);
//			}
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//			request.setAttribute("err", "用户id或者密码有误");
//			request.getRequestDispatcher("/LoginServlet").forward(request, response);
//			e.printStackTrace();
//		}finally{
//			//关闭资源
//			
//			try {
//				if(resultSet != null){
//					resultSet.close();
//				}
//				
//				if(statement != null){
//					statement.close();
//				}
//				
//				if(connection != null){
//					connection.close();
//				}
//				
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			resultSet = null;
//			statement = null;
//			connection = null;
//			
//			
//		}
		

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);

	}

}
