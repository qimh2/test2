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
	
//	String url = "jdbc:mysql://localhost:3306/web";//�������ݵ�RUL��ַ
//	String user = "root";//���ݿ���û���
//	String password = "123456";//���ݿ������
	public static Connection connection ;//���Ӷ���
	public static PreparedStatement statement;//������
	public static int resultSet;//���������

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//request.setCharacterEncoding("utf-8");
		response.setContentType("text/html ;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String username = MyTools.getNewString(request.getParameter("username"), "iso-8859-1", "utf-8");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		
		
		System.out.println("����û�form �����ݡ�");
		System.out.println("username:"+username);
		System.out.println("pwd:"+pwd);
		System.out.println("email:"+email);
		System.out.println("������û�form ������");
		
		//��ΪServlet �������һ��java�࣬�������servlet�������ݿ����ͨ��java��û������
		try {
//			//1.��������
//			Class.forName("com.mysql.jdbc.Driver");
//			//2.�õ�����
//			connection = (Connection) DriverManager.getConnection(url, user, password);
			
			connection = (Connection) DBHelper.getConnection();
			
			if(connection != null){
				System.out.println("��������������");
			}else{
				System.out.println("���ݿ�����ʧ�ܣ�");
			}
			//3.����preparedStatement
			String sql = "insert into  users (username,pwd,email) values (?,?,?) ";
			statement =  (PreparedStatement) connection.prepareStatement(sql);
			//������ֵ
			statement.setObject(1, username);
			statement.setObject(2, pwd);
			statement.setObject(3, email);
			//4.ִ�в���
			resultSet = statement.executeUpdate();
			
			System.out.println("���sqlִ�гɹ�......");
			
			//5.���ݽ��������
			if(resultSet > 0){
				//���û��Ϸ�
				//action Ӧ������д /webӦ����/servlet��url
				response.sendRedirect("/UserManager2/success.html");//�����ض���
				System.out.println("��ӳɹ�����������");
				//request.getRequestDispatcher("/MainFrame").forward(request, response);//����ת��
			}else{
				//�û��Ƿ������ص�¼ҳ��
				response.sendRedirect("/UserManager2/fail.html");
				System.out.println("���ʧ�ܡ���������");
				//request.getRequestDispatcher("/LoginServlet").forward(request, response);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("err", "�û�id������������");
			request.getRequestDispatcher("/LoginServlet").forward(request, response);
			e.printStackTrace();
		}finally{
			//�ر���Դ
			
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
