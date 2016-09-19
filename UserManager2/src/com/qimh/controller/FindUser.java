package com.qimh.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.qimh.utils.DBHelper;


public class FindUser extends HttpServlet {
	private static Connection connection;
	//private static Statement ps;
	private static PreparedStatement ps;
	private static ResultSet rs;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html ;charset=utf-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
		
		String username = request.getParameter("username");
		
		System.out.println("输入的用户名："+username);
		
		out.println("<h1> 查找到的用户信息:</h1>");
		//从数据库中取出用户信息，并显示
		try {
			//获取操作数据库的连接
			connection = DBHelper.getConnection();
			if(connection != null){
				System.out.println("数据连接正常！");
			}else{
				System.out.println("数据库连接失败！");
			}
			
			//创建statement
			//String sql = "select * from users where username like '%"+username+"%'";
			String sql = "select * from users where username = ?";
			//ps = (Statement) connection.createStatement();
			ps = (PreparedStatement) connection.prepareStatement(sql);
			ps.setObject(1, username);
			
			//rs = ps.executeQuery(sql);
			rs = ps.executeQuery();
			
			while(rs.next()){
				int  id = rs.getInt("id");
				//String username = rs.getString("username");
				String password = rs.getString("pwd");
				String emial = rs.getString("email");
				int grade = rs.getInt("grade");
				
				out.println("id号："+id+"   姓名："+username+"   密码"+password+"  邮箱："+emial+"   会员等级"+grade+"<br>");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
//			if(rs != null){
//				try {
//					rs.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			if(ps != null){
//				try {
//					ps.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			
//			if(connection != null){
//				try {
//					connection.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			
//			rs = null;
//			ps = null;
//			connection = null;
			
			DBHelper.destoryResource(rs, ps);
		}
		

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);

	}

}
