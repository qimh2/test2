package com.qimh.utils;

//���߲�

import java.io.IOException;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

//DBHelper�࣬���ֵ���ģʽ��˼��
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
	
	//��ȡ�����ļ�
	private static Properties pp = null;
	//private static FileInputStream fis = null;
	private static InputStream fis = null;
	
	//��̬����飬�����������
	static{
		try {
			
			//��dbinfo.properties�ļ��У���ȡ������Ϣ
			pp = new Properties();
			//������java��Ŀ����ȡ�����ļ���Ϣ��д��
			//fis = new FileInputStream("dbinfo.properties");//=>tomcat Ĭ����Ŀ¼��
			
			//������ʹ��javaweb��Ŀ����ȡ�ļ�ʹ�������ȥ����Ϊ�������ȥ��ȡ��Դ�ļ�ʱ��Ĭ�ϵ�Ŀ¼��srcĿ¼��������ڰ�·���£���Ѱ�·����ȫ �磺/com/qimh/util/dbinfo2.properties
			fis = DBHelper.class.getClassLoader().getResourceAsStream("dbinfo.properties");
			pp.load(fis);//���������ж�ȡ�����б�
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
	
	
	//��Ȼ�ǵ���ģʽ��Ӧ���ù��췽��˽�л�
	private DBHelper(){
		
	}
	
	//�ⲿͳһ���õķ���
	public static Connection getConnection() throws SQLException{
		if(connection == null){
			connection = DriverManager.getConnection(url, username, password);
		}
		return connection;
	}
	
	
	//�ͷ�������Դ
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
			/* ��ʱ���ͷ�connection��Դ
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
	
	
	//�ͷ�������Դ
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
			/* ��ʱ���ͷ�connection��Դ
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
	
	
	//�ͷ�������Դ
	public static void destoryResource(Statement ps){
		try {
			if(ps != null){
				ps.close();
				ps = null;
			}
			/* ��ʱ���ͷ�connection��Դ
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
