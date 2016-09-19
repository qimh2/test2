package com.qimh.controller;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.qimh.domain.Users;
import com.qimh.service.UsersService;
import com.qimh.utils.MyTools;

public class LoginClServlet extends HttpServlet {
	
	String url = "jdbc:mysql://localhost:3306/web";//�������ݵ�RUL��ַ
	String user = "root";//���ݿ���û���
	String password = "123456";//���ݿ������
	public static Connection connection ;//���Ӷ���
	public static PreparedStatement statement;//������
	public static ResultSet resultSet;//���������

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		//�������û��ύ���û�������
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		
		//���id�Ƿ�Ϊ����
		if(!MyTools.isNumeric(id)){
			request.setAttribute("err", "�û�id����Ϊ����");
			request.getRequestDispatcher("/LoginServlet").forward(request, response);
			return;
		}
		
		
		//����UserService������ɵ����ݿ����֤
		UsersService us = new UsersService();
		Users users = new Users();
		users.setId(Integer.parseInt(id));
		users.setPwd(pwd);
		
		if(us.checkUser(users)){
			//���û��Ϸ�
			//action Ӧ������д /webӦ����/servlet��url
			//response.sendRedirect("/UserManager/MainFrame");//�����ض���
			System.out.println("��¼�ɹ�����������");
			request.getRequestDispatcher("/MainFrame").forward(request, response);//����ת��
		}else{
			//�û��Ƿ������ص�¼ҳ��
			//response.sendRedirect("/UserManager/LoginServlet");
			System.out.println("��¼ʧ�ܡ���������");
			request.setAttribute("err", "�û�id������������");
			request.getRequestDispatcher("/LoginServlet").forward(request, response);
		}
		
//		//�����ݿ���ȡ��֤
//		
//		//��ΪServlet �������һ��java�࣬�������servlet�������ݿ����ͨ��java��û������
//		try {
//			//1.��������
//			Class.forName("com.mysql.jdbc.Driver");
//			//2.�õ�����
//			connection = (Connection) DriverManager.getConnection(url, user, password);
//			if(connection != null){
//				System.out.println("��������������");
//			}else{
//				System.out.println("���ݿ�����ʧ�ܣ�");
//			}
//			//3.����preparedStatement
//			String sql = "select * from users where id=? and password=?";
//			statement =  (PreparedStatement) connection.prepareStatement(sql);
//			//������ֵ
//			statement.setObject(1, id);
//			statement.setObject(2, pwd);
//			//4.ִ�в���
//			resultSet = statement.executeQuery();
//			
//			System.out.println("1111");
//			
//			//5.���ݽ��������
//			if(resultSet.next()){
//				//���û��Ϸ�
//				//action Ӧ������д /webӦ����/servlet��url
//				//response.sendRedirect("/UserManager/MainFrame");//�����ض���
//				System.out.println("��¼�ɹ�����������");
//				request.getRequestDispatcher("/MainFrame").forward(request, response);//����ת��
//			}else{
//				//�û��Ƿ������ص�¼ҳ��
//				//response.sendRedirect("/UserManager/LoginServlet");
//				System.out.println("��¼ʧ�ܡ���������");
//				request.setAttribute("err", "�û�id������������");
//				request.getRequestDispatcher("/LoginServlet").forward(request, response);
//			}
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//			request.setAttribute("err", "�û�id������������");
//			request.getRequestDispatcher("/LoginServlet").forward(request, response);
//			e.printStackTrace();
//		}finally{
//			//�ر���Դ
//			
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
//			
//			
//		}
		

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);

	}

}
