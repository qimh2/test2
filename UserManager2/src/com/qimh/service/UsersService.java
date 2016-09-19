package com.qimh.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.qimh.domain.Users;
import com.qimh.utils.DBHelper;

public class UsersService {
	Connection ct;
	PreparedStatement ps;
	ResultSet rs;
	
	public static Statement statement;//语句对象
	
	
	
	
	
	
	
	/**
	 * addUser 添加用户
	 * @author qimh	
	 * @date 20160918
	 * @param Users 对象
	 * @return 成功--true/失败--false
	 */
	public boolean addUser(Users u){
		boolean flag = false;
		
		
		try {
			String sql = "insert into users (username,pwd,email) values (?,?,?)";
			ct = (Connection) DBHelper.getConnection();
			if(ct != null){
				System.out.println("数据连接正常！");
			}else{
				System.out.println("数据库连接失败！");
			}
			
			ps = (PreparedStatement) ct.prepareStatement(sql);
			
			//给？赋值
			ps.setObject(1, u.getUsername());
			ps.setObject(2, u.getPwd());
			ps.setObject(3, u.getEmail());
			
			int affectNum = ps.executeUpdate();
			if(affectNum > 0){
				flag = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBHelper.destoryResource(ps);
		}
		
		
		return flag;
	}
	
	
	
	
	/**
	 * modUser 删除用户
	 * @author qimh	
	 * @date 20160918
	 * @param String id---用户id
	 * @return 成功--true/失败--false
	 */
	public boolean modUser(Users u){
		boolean flag = false;
		
		
		try {
			String sql = "update users set username=?,pwd=?,email=? where id = ?";
			ct = (Connection) DBHelper.getConnection();
			if(ct != null){
				System.out.println("数据连接正常！");
			}else{
				System.out.println("数据库连接失败！");
			}
			
			ps = (PreparedStatement) ct.prepareStatement(sql);
			
			//给？赋值
			ps.setObject(1, u.getUsername());
			ps.setObject(2, u.getPwd());
			ps.setObject(3, u.getEmail());
			ps.setObject(4, u.getId());
			
			int affectNum = ps.executeUpdate();
			if(affectNum > 0){
				flag = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBHelper.destoryResource(ps);
		}
		
		
		return flag;
	}
	
	/**
	 * delUser 删除用户
	 * @author qimh	
	 * @date 20160918
	 * @param String id---用户id
	 * @return 成功--true/失败--false
	 */
	public boolean delUser(String id){
		boolean flag = false;
		
		
		try {
			String sql = "delete from users where id = ?";
			ct = (Connection) DBHelper.getConnection();
			if(ct != null){
				System.out.println("数据连接正常！");
			}else{
				System.out.println("数据库连接失败！");
			}
			
			ps = (PreparedStatement) ct.prepareStatement(sql);
			
			//给？赋值
			ps.setObject(1, id);
			
			int affectNum = ps.executeUpdate();
			if(affectNum > 0){
				flag = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBHelper.destoryResource(ps);
		}
		
		
		return flag;
	}
	
	
	
	
	//按照分页来获取用户
	//公司   把ResultSet-> User对象-->ArrayList(集合)
	/**
	 * @author qimh
	 * @date 20160918
	 * @param pageNow---当前是第几页
	 * @param pageSize---每页多少条数据
	 * @param start---从多少条记录开始
	 * @return 返回用户数据/总共多少页
	 */
	public Map<String, Object> getUsersByPage(int pageNow,int pageSize,int start){
		Map<String, Object> mapData = new HashMap<String, Object>();
		ArrayList<Users> al = new ArrayList<Users>();
		
		try {
			
			//查询语句
			//定义分页需要的变量
			//int pageNow = 1;//当前页
			//int pageSize = 3;//指定每页显示3条记录
			int pageCount = 1;//共有多少页        该值是计算出来的
			int rowCount = 1;//表示共有多少条记录，从数据查出来
			
			
			
			//1.加载驱动
			//Class.forName("com.mysql.jdbc.Driver");
			//2.得到连接
			ct = (Connection) DBHelper.getConnection();//(Connection) DriverManager.getConnection(url, user, password);
			if(ct != null){
				System.out.println("数据连接正常！");
			}else{
				System.out.println("数据库连接失败！");
			}
			//3.创建preparedStatement
			
			
			
			
			//获取总的记录数
			String total_sql = "select COUNT(*) total from users";
		    statement = (Statement) ct.createStatement();
			
		    rs = statement.executeQuery(total_sql);
			
			if(rs.next()){
				rowCount = rs.getInt("total");
				
				if(rowCount%pageSize == 0){
					pageCount = rowCount/pageSize;
				}else{
					pageCount = rowCount/pageSize + 1;
				}
			}
			
			
			
//			int start = 0;
//			if(request.getParameter("pageNow") != null){
//				pageNow = Integer.parseInt(request.getParameter("pageNow"));//获得当前页是第几页
//				if(pageNow == 1){//第一页
//					start = 0;
//				}else{//第二页，第三页,第四页....
//					start = (pageNow-1) * pageSize;
//				}
//			}
		
						
			int num = pageSize;
			
			
			
			String sql = "select * from users limit "+start+","+num;
			statement =  (Statement) ct.createStatement();
			//4.执行操作
			rs = statement.executeQuery(sql);
			
			System.out.println("sql 执行成功.......");
			
			
			//二次分装   把ResultSet-> User对象-->ArrayList(集合)
			while(rs.next()){
				int  id = rs.getInt("id");
				String username = rs.getString("username");
				String password = rs.getString("pwd");
				String emial = rs.getString("email");
				int grade = rs.getInt("grade");
				Users users = new Users();
				users.setId(id);
				users.setUsername(username);
				users.setPwd(password);
				users.setEmail(emial);
				users.setGrade(grade);
				
				//千万不要忘记   users->ArrayList
				al.add(users);
			}
			
			mapData.put("users", al);
			mapData.put("pageCount", pageCount);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			
			//关闭资源
			DBHelper.destoryResource(rs, statement);
		}
		

		return mapData;
	}
	
	
	//验证用户是否合法
	public boolean checkUser(Users users){
		boolean flag = false ;
		
		//连接数据库
		try {
			ct = (Connection) DBHelper.getConnection();
			String sql = "select * from users where id = ? and pwd = ?";
			ps = (PreparedStatement) ct.prepareStatement(sql);
			//给？赋值
			ps.setObject(1, users.getId());
			ps.setObject(2, users.getPwd());
			
			rs = ps.executeQuery();
			if(rs.next()){
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBHelper.destoryResource(rs, ps);
		}
		
		return flag;
	}

}
