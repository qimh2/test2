package com.qimh.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;



public class DBHelper {
	private static String url = null;
	private static String username = null;
	private static String password = null;
	private static String driver = null;
	//读取配置文件
	private static Properties pp = null;
	//private static FileInputStream fis = null;
	private static InputStream fis = null;
	
	//加载数据库驱动，只需要一次
	static{
		
		System.out.println("静态代码块加载。。。。。。");
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
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
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
	
	
	
//	public static void main(String[] args) {
//		System.out.println(".......");
//	}
	
}
