package com.qimh.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qimh.domain.Users;
import com.qimh.service.UsersService;

public class ManagerUsers extends HttpServlet {

//	String url = "jdbc:mysql://localhost:3306/web";//连接数据的RUL地址
//	String user = "root";//数据库的用户名
//	String password = "123456";//数据库的密码
//	public static Connection connection ;//连接对象
//	public static Statement statement;//语句对象
//	public static ResultSet resultSet;//结果集对象
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html ;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<script type='text/javascript'>");
		out.println("function gotoPageNow(pageCount){" +
				"								var pageNow = document.getElementById('pageNow').value;" +
				"								alert(pageNow);" +
				"				if(pageNow <= pageCount){ "+
				" 							window.location.href = '/UserManager3/ManagerUsers?pageNow='+pageNow;" +
				"			    }else{" +
				"" +
				"					alert('跳转到的页，已超过总页数');" +
				"" +
				"				}" +
				"" +
				"}"+
				"function confirmoper(){ return window.confirm('真的要删除该用户吗？')};"
		      );
		out.println("</script>");
		
		out.println("欢迎XX登录");
		out.println("<a href = '/UserManager3/MainFrame'>返回主界面</a>");
		out.println("<a href = '/UserManager3/LoginServlet'>安全退出</a>");
		
		out.println("<h1> 管理用户</h1>");
		
		
		
		//从数据库中取出用户信息，并显示
		try {
			
//			
//			//定义分页需要的变量
			int pageNow = 1;//当前页
			int pageSize = 3;//指定每页显示3条记录
//			int pageCount = 1;//共有多少页        该值是计算出来的
//			int rowCount = 1;//表示共有多少条记录，从数据查出来
//			
//			
//			
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
//			
//			
//			
//			
//			//获取总的记录数
//			String total_sql = "select COUNT(*) total from users";
//		    statement = (Statement) connection.createStatement();
//			
//		    resultSet = statement.executeQuery(total_sql);
//			
//			if(resultSet.next()){
//				rowCount = resultSet.getInt("total");
//				
//				if(rowCount%pageSize == 0){
//					pageCount = rowCount/pageSize;
//				}else{
//					pageCount = rowCount/pageSize + 1;
//				}
//			}
//			
//			
//			
			int start = 0;
			if(request.getParameter("pageNow") != null){
				pageNow = Integer.parseInt(request.getParameter("pageNow"));//获得当前页是第几页
				if(pageNow == 1){//第一页
					start = 0;
				}else{//第二页，第三页,第四页....
					start = (pageNow-1) * pageSize;
				}
			}
//		
//						
//			int num = pageSize;
//			
//			
//			
//			String sql = "select * from users limit "+start+","+num;
//			statement =  (Statement) connection.createStatement();
//			//4.执行操作
//			resultSet = statement.executeQuery(sql);
//			
//			System.out.println("sql 执行成功.......");
			
			//5.根据结果做处理
			
			UsersService us = new UsersService();
			Map<String, Object> mapData = us.getUsersByPage(pageNow, pageSize, start);
			Integer pageCount = (Integer) mapData.get("pageCount");
			ArrayList<Users> users = (ArrayList<Users>) mapData.get("users");
			
			out.println("<table border='3' width = '500'>");
			out.println("<tr><th>id</th><th>用户名</th><th>级别</th><th>邮箱</th><th>删除用户</th><th>修改用户</th><tr>");
			for(Users u:users){
				int  id = u.getId();
				String username = u.getUsername();
				String password = u.getPwd();
				String emial = u.getEmail();
				int grade = u.getGrade();
				
				out.println("<tr><th>"+id+"</th><th>"+username+"</th><th>"+grade+"</th><th>"+emial+"</th><th><a  onClick = 'return confirmoper();' href = '/UserManager3/UserClServlet?id="+id+"&type=delUser'>删除用户</th><th><a href = '/UserManager3/UserClServlet?id="+id+"&type=modUser'>修改用户</th><tr>");//&username="+URLEncoder.encode(username, "utf-8")+"&pwd="+URLEncoder.encode(password, "utf-8")+"&email="+URLEncoder.encode(emial, "utf-8")+"
				
				//out.println("id号："+id+"   姓名："+username+"   密码"+password+"  邮箱："+emial+"   会员等级"+grade+"<br>");
			}
			out.println("</table>");
			
			//显示上一页
			if((pageNow - 1) > 0){
				out.println("<a href = '/UserManager3/ManagerUsers?pageNow="+(pageNow - 1)+"'>上一页</a>");
			}
			
			//显示分页
			for(int i = 0;i < pageCount;i++){
				out.println("<a href = '/UserManager3/ManagerUsers?pageNow="+(i+1)+"'>   <"+(i+1)+"> </a>&nbsp&nbsp");
			}
			if((pageNow+1) <= pageCount){
				out.println("<a href = '/UserManager3/ManagerUsers?pageNow="+(pageNow+1)+"'>下一页</a>");
			}
			
			//显示分页信息 
			out.println("&nbsp;&nbsp;&nbsp;当前页"+pageNow+"/总页数"+pageCount);
			
			
			out.println("<br>跳转到");
			out.println("<input type = 'text' id = 'pageNow' name = 'pageNow'> <input type = 'button' onclick = 'gotoPageNow("+pageCount+")' value = '跳'>");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			
			//关闭资源
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
		}
		
		

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);

	}

}
