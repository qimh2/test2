package com.qimh.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.qimh.utils.DBHelper;
import com.qimh.utils.MyTools;

public class AddUser extends HttpServlet {
	
//	String url = "jdbc:mysql://localhost:3306/web";//连接数据的RUL地址
//	String user = "root";//数据库的用户名
//	String password = "123456";//数据库的密码
	public static Connection connection ;//连接对象
	public static PreparedStatement statement;//语句对象
	public static int resultSet;//结果集对象

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//request.setCharacterEncoding("utf-8");
		response.setContentType("text/html ;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String username = MyTools.getNewString(request.getParameter("username"), "iso-8859-1", "utf-8");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		
		
		System.out.println("添加用户form 表单数据【");
		System.out.println("username:"+username);
		System.out.println("pwd:"+pwd);
		System.out.println("email:"+email);
		System.out.println("】添加用户form 表单数据");
		
		//因为Servlet 本身就是一个java类，因此我们servlet操作数据库和普通的java类没有区别
		try {
//			//1.加载驱动
//			Class.forName("com.mysql.jdbc.Driver");
//			//2.得到连接
//			connection = (Connection) DriverManager.getConnection(url, user, password);
			
			connection = (Connection) DBHelper.getConnection();
			
			if(connection != null){
				System.out.println("数据连接正常！");
			}else{
				System.out.println("数据库连接失败！");
			}
			//3.创建preparedStatement
			String sql = "insert into  users (username,pwd,email) values (?,?,?) ";
			statement =  (PreparedStatement) connection.prepareStatement(sql);
			//给？赋值
			statement.setObject(1, username);
			statement.setObject(2, pwd);
			statement.setObject(3, email);
			//4.执行操作
			resultSet = statement.executeUpdate();
			
			System.out.println("添加sql执行成功......");
			
			//5.根据结果做处理
			if(resultSet > 0){
				//该用户合法
				//action 应该这样写 /web应用名/servlet的url
				response.sendRedirect("/UserManager2/success.html");//请求重定向
				System.out.println("添加成功。。。。。");
				//request.getRequestDispatcher("/MainFrame").forward(request, response);//请求转发
			}else{
				//用户非法，调回登录页面
				response.sendRedirect("/UserManager2/fail.html");
				System.out.println("添加失败。。。。。");
				//request.getRequestDispatcher("/LoginServlet").forward(request, response);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("err", "用户id或者密码有误");
			request.getRequestDispatcher("/LoginServlet").forward(request, response);
			e.printStackTrace();
		}finally{
			//关闭资源
			
//			try {
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
//			statement = null;
//			connection = null;
			
			DBHelper.destoryResource(statement);
			
			
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);

	}

}
