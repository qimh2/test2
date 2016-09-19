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
	
	public static Statement statement;//������
	
	
	
	
	
	
	
	/**
	 * addUser ����û�
	 * @author qimh	
	 * @date 20160918
	 * @param Users ����
	 * @return �ɹ�--true/ʧ��--false
	 */
	public boolean addUser(Users u){
		boolean flag = false;
		
		
		try {
			String sql = "insert into users (username,pwd,email) values (?,?,?)";
			ct = (Connection) DBHelper.getConnection();
			if(ct != null){
				System.out.println("��������������");
			}else{
				System.out.println("���ݿ�����ʧ�ܣ�");
			}
			
			ps = (PreparedStatement) ct.prepareStatement(sql);
			
			//������ֵ
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
	 * modUser ɾ���û�
	 * @author qimh	
	 * @date 20160918
	 * @param String id---�û�id
	 * @return �ɹ�--true/ʧ��--false
	 */
	public boolean modUser(Users u){
		boolean flag = false;
		
		
		try {
			String sql = "update users set username=?,pwd=?,email=? where id = ?";
			ct = (Connection) DBHelper.getConnection();
			if(ct != null){
				System.out.println("��������������");
			}else{
				System.out.println("���ݿ�����ʧ�ܣ�");
			}
			
			ps = (PreparedStatement) ct.prepareStatement(sql);
			
			//������ֵ
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
	 * delUser ɾ���û�
	 * @author qimh	
	 * @date 20160918
	 * @param String id---�û�id
	 * @return �ɹ�--true/ʧ��--false
	 */
	public boolean delUser(String id){
		boolean flag = false;
		
		
		try {
			String sql = "delete from users where id = ?";
			ct = (Connection) DBHelper.getConnection();
			if(ct != null){
				System.out.println("��������������");
			}else{
				System.out.println("���ݿ�����ʧ�ܣ�");
			}
			
			ps = (PreparedStatement) ct.prepareStatement(sql);
			
			//������ֵ
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
	
	
	
	
	//���շ�ҳ����ȡ�û�
	//��˾   ��ResultSet-> User����-->ArrayList(����)
	/**
	 * @author qimh
	 * @date 20160918
	 * @param pageNow---��ǰ�ǵڼ�ҳ
	 * @param pageSize---ÿҳ����������
	 * @param start---�Ӷ�������¼��ʼ
	 * @return �����û�����/�ܹ�����ҳ
	 */
	public Map<String, Object> getUsersByPage(int pageNow,int pageSize,int start){
		Map<String, Object> mapData = new HashMap<String, Object>();
		ArrayList<Users> al = new ArrayList<Users>();
		
		try {
			
			//��ѯ���
			//�����ҳ��Ҫ�ı���
			//int pageNow = 1;//��ǰҳ
			//int pageSize = 3;//ָ��ÿҳ��ʾ3����¼
			int pageCount = 1;//���ж���ҳ        ��ֵ�Ǽ��������
			int rowCount = 1;//��ʾ���ж�������¼�������ݲ����
			
			
			
			//1.��������
			//Class.forName("com.mysql.jdbc.Driver");
			//2.�õ�����
			ct = (Connection) DBHelper.getConnection();//(Connection) DriverManager.getConnection(url, user, password);
			if(ct != null){
				System.out.println("��������������");
			}else{
				System.out.println("���ݿ�����ʧ�ܣ�");
			}
			//3.����preparedStatement
			
			
			
			
			//��ȡ�ܵļ�¼��
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
//				pageNow = Integer.parseInt(request.getParameter("pageNow"));//��õ�ǰҳ�ǵڼ�ҳ
//				if(pageNow == 1){//��һҳ
//					start = 0;
//				}else{//�ڶ�ҳ������ҳ,����ҳ....
//					start = (pageNow-1) * pageSize;
//				}
//			}
		
						
			int num = pageSize;
			
			
			
			String sql = "select * from users limit "+start+","+num;
			statement =  (Statement) ct.createStatement();
			//4.ִ�в���
			rs = statement.executeQuery(sql);
			
			System.out.println("sql ִ�гɹ�.......");
			
			
			//���η�װ   ��ResultSet-> User����-->ArrayList(����)
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
				
				//ǧ��Ҫ����   users->ArrayList
				al.add(users);
			}
			
			mapData.put("users", al);
			mapData.put("pageCount", pageCount);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			
			//�ر���Դ
			DBHelper.destoryResource(rs, statement);
		}
		

		return mapData;
	}
	
	
	//��֤�û��Ƿ�Ϸ�
	public boolean checkUser(Users users){
		boolean flag = false ;
		
		//�������ݿ�
		try {
			ct = (Connection) DBHelper.getConnection();
			String sql = "select * from users where id = ? and pwd = ?";
			ps = (PreparedStatement) ct.prepareStatement(sql);
			//������ֵ
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
