package com.qimh.utils;

//工具层

import java.io.IOException;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

//DBHelper类，体现单例模式的思想
public class DBHelper {

	private static Connection connection;
//	private static final String DRIVER = "com.mysql.jdbc.Driver";
//	private static final String URL = "jdbc:mysql://localhost:3306/web?useUnicode=true&characterEncoding=UTF-8";
//	private static final String USERNAME = "root";
//	private static final String PASSWORD = "123456";
	
	
	private static String url = null;
	private static String username = null;
	private static String password = null;
	private static String driver = null;
	
	//读取配置文件
	private static Properties pp = null;
	//private static FileInputStream fis = null;
	private static InputStream fis = null;
	
	//静态代码块，负责加载驱动
	static{
		try {
			
			//从dbinfo.properties文件中，读取配置信息
			pp = new Properties();
			//以下是java项目，获取配置文件信息的写法
			//fis = new FileInputStream("dbinfo.properties");//=>tomcat 默认主目录？
			
			//当我们使用javaweb项目，读取文件使用类加载去【因为类加载器去读取资源文件时，默认的目录是src目录】，如果在包路径下，则把包路径补全 如：/com/qimh/util/dbinfo2.properties
			fis = DBHelper.class.getClassLoader().getResourceAsStream("dbinfo.properties");
			pp.load(fis);//从输入流中读取属性列表
			url = pp.getProperty("url");
			driver = pp.getProperty("driver");
			username = pp.getProperty("username");
			password = pp.getProperty("password");
			
			
			System.out.println("url:"+url);
			System.out.println("driver:"+driver);
			System.out.println("username:"+username);
			System.out.println("password:"+password);
			
			Class.forName(driver);
			
			
//			Class.forName(DRIVER);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			fis = null;
		}
	}
	
	
	//既然是单例模式，应该让构造方法私有化
	private DBHelper(){
		
	}
	
	//外部统一调用的方法
	public static Connection getConnection() throws SQLException{
		if(connection == null){
			connection = DriverManager.getConnection(url, username, password);
		}
		return connection;
	}
	
	
	//释放数据资源
	public static void destoryResource(ResultSet rs,PreparedStatement ps){
		try {
			if(rs != null){
				rs.close();
				rs = null;
			}
			if(ps != null){
				ps.close();
				ps = null;
			}
			/* 暂时不释放connection资源
			if(connection != null){
				connection.close();
				connection = null;
			}
			*/
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	//释放数据资源
	public static void destoryResource(ResultSet rs,Statement ps){
		try {
			if(rs != null){
				rs.close();
				rs = null;
			}
			if(ps != null){
				ps.close();
				ps = null;
			}
			/* 暂时不释放connection资源
			if(connection != null){
				connection.close();
				connection = null;
			}
			*/
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	//释放数据资源
	public static void destoryResource(Statement ps){
		try {
			if(ps != null){
				ps.close();
				ps = null;
			}
			/* 暂时不释放connection资源
			if(connection != null){
				connection.close();
				connection = null;
			}
			*/
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
