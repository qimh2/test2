package com.qimh.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.stream.events.StartDocument;

import org.apache.catalina.tribes.membership.StaticMember;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class ManagerUsers
 */
public class ManagerUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String driver = "com.mysql.jdbc.Driver";
	//localhost指本机，也可以用本地ip地址代替，3306为MySQL数据库的默认端口号，“web”为要连接的数据库名
	static String url = "jdbc:mysql://localhost:3306/web";
	//填入数据库的用户名跟密码
	static String username = "root";
	static String password = "123456";
	static Connection ct = null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		try {
			
			//定义分页需要的变量
			int pageNow = 1;//当前页
			int pageSize = 3;//指定每页显示3条记录
			int pageCount = 1;//共有多少页        该值是计算出来的
			int rowCount = 1;//表示共有多少条记录，从数据查出来
			
			
			
			
			//1.加载驱动程序
			Class.forName(driver);
			
			
			//2.创建连接
			ct = (Connection) DriverManager.getConnection(url, username, password);
			if(ct == null){
				System.out.println("数据连接失败.....");
			}else{
				System.out.println("数据连接成功.....");
			}
			
			//3.创建sql执行对象
			
			
			
			//获取总的记录数
			String total_sql = "select COUNT(*) total from users";
		    ps = (PreparedStatement) ct.prepareStatement(total_sql);
			
			rs = ps.executeQuery();
			
			if(rs.next()){
				rowCount = rs.getInt("total");
				
				if(rowCount%pageSize == 0){
					pageCount = rowCount/pageSize;
				}else{
					pageCount = rowCount/pageSize + 1;
				}
			}
			
			
			
			
			
			int start = 0;
			if(request.getParameter("pageNow") != null){
				pageNow = Integer.parseInt(request.getParameter("pageNow"));
				if(pageNow == 1){//第一页
					start = 0;
				}else{//第二页，第三页,第四页....
					start = (pageNow-1) * pageSize;
				}
			}
		
			
			int num = pageSize;
			
			String sql = "select * from users limit "+start+","+num;
			ps = (PreparedStatement) ct.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			
			
			out.println("<table border = '3' width='800px;'>");
			out.println("<tr><th>id号：</th><th>用户名：</th><th>邮箱：</th><th>等级：</th></tr>");
			while(rs.next()){
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String email = rs.getString("email");
				int grade = rs.getInt("grade");
				
				//System.out.println("username:"+username);
				//System.out.println("grade:"+grade);
				
				out.println("<tr><th>"+id+"</th><th>"+username+"</th><th>"+email+"</th> <th>"+grade+"</th></tr>");
				//out.println("id号："+id+" 用户名："+username+" 邮箱："+email+"  等级："+grade+"<br>");
			}
			out.println("</table>");
			
			for(int i = 0;i < pageCount;i++){
				out.println("<a href = '/UserManager/ManagerUsers?pageNow="+(i+1)+"'>"+(i+1)+" </a>&nbsp&nbsp");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
