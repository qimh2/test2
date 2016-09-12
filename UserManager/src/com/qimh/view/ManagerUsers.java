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
	//localhostָ������Ҳ�����ñ���ip��ַ���棬3306ΪMySQL���ݿ��Ĭ�϶˿ںţ���web��ΪҪ���ӵ����ݿ���
	static String url = "jdbc:mysql://localhost:3306/web";
	//�������ݿ���û���������
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
			
			//�����ҳ��Ҫ�ı���
			int pageNow = 1;//��ǰҳ
			int pageSize = 3;//ָ��ÿҳ��ʾ3����¼
			int pageCount = 1;//���ж���ҳ        ��ֵ�Ǽ��������
			int rowCount = 1;//��ʾ���ж�������¼�������ݲ����
			
			
			
			
			//1.������������
			Class.forName(driver);
			
			
			//2.��������
			ct = (Connection) DriverManager.getConnection(url, username, password);
			if(ct == null){
				System.out.println("��������ʧ��.....");
			}else{
				System.out.println("�������ӳɹ�.....");
			}
			
			//3.����sqlִ�ж���
			
			
			
			//��ȡ�ܵļ�¼��
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
				if(pageNow == 1){//��һҳ
					start = 0;
				}else{//�ڶ�ҳ������ҳ,����ҳ....
					start = (pageNow-1) * pageSize;
				}
			}
		
			
			int num = pageSize;
			
			String sql = "select * from users limit "+start+","+num;
			ps = (PreparedStatement) ct.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			
			
			out.println("<table border = '3' width='800px;'>");
			out.println("<tr><th>id�ţ�</th><th>�û�����</th><th>���䣺</th><th>�ȼ���</th></tr>");
			while(rs.next()){
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String email = rs.getString("email");
				int grade = rs.getInt("grade");
				
				//System.out.println("username:"+username);
				//System.out.println("grade:"+grade);
				
				out.println("<tr><th>"+id+"</th><th>"+username+"</th><th>"+email+"</th> <th>"+grade+"</th></tr>");
				//out.println("id�ţ�"+id+" �û�����"+username+" ���䣺"+email+"  �ȼ���"+grade+"<br>");
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