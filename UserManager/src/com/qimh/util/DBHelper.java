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
	//��ȡ�����ļ�
	private static Properties pp = null;
	//private static FileInputStream fis = null;
	private static InputStream fis = null;
	
	//�������ݿ�������ֻ��Ҫһ��
	static{
		
		System.out.println("��̬�������ء�����������");
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
