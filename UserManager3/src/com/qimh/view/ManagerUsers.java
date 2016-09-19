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

//	String url = "jdbc:mysql://localhost:3306/web";//�������ݵ�RUL��ַ
//	String user = "root";//���ݿ���û���
//	String password = "123456";//���ݿ������
//	public static Connection connection ;//���Ӷ���
//	public static Statement statement;//������
//	public static ResultSet resultSet;//���������
	
	
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
				"					alert('��ת����ҳ���ѳ�����ҳ��');" +
				"" +
				"				}" +
				"" +
				"}"+
				"function confirmoper(){ return window.confirm('���Ҫɾ�����û���')};"
		      );
		out.println("</script>");
		
		out.println("��ӭXX��¼");
		out.println("<a href = '/UserManager3/MainFrame'>����������</a>");
		out.println("<a href = '/UserManager3/LoginServlet'>��ȫ�˳�</a>");
		
		out.println("<h1> �����û�</h1>");
		
		
		
		//�����ݿ���ȡ���û���Ϣ������ʾ
		try {
			
//			
//			//�����ҳ��Ҫ�ı���
			int pageNow = 1;//��ǰҳ
			int pageSize = 3;//ָ��ÿҳ��ʾ3����¼
//			int pageCount = 1;//���ж���ҳ        ��ֵ�Ǽ��������
//			int rowCount = 1;//��ʾ���ж�������¼�������ݲ����
//			
//			
//			
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
//			
//			
//			
//			
//			//��ȡ�ܵļ�¼��
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
				pageNow = Integer.parseInt(request.getParameter("pageNow"));//��õ�ǰҳ�ǵڼ�ҳ
				if(pageNow == 1){//��һҳ
					start = 0;
				}else{//�ڶ�ҳ������ҳ,����ҳ....
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
//			//4.ִ�в���
//			resultSet = statement.executeQuery(sql);
//			
//			System.out.println("sql ִ�гɹ�.......");
			
			//5.���ݽ��������
			
			UsersService us = new UsersService();
			Map<String, Object> mapData = us.getUsersByPage(pageNow, pageSize, start);
			Integer pageCount = (Integer) mapData.get("pageCount");
			ArrayList<Users> users = (ArrayList<Users>) mapData.get("users");
			
			out.println("<table border='3' width = '500'>");
			out.println("<tr><th>id</th><th>�û���</th><th>����</th><th>����</th><th>ɾ���û�</th><th>�޸��û�</th><tr>");
			for(Users u:users){
				int  id = u.getId();
				String username = u.getUsername();
				String password = u.getPwd();
				String emial = u.getEmail();
				int grade = u.getGrade();
				
				out.println("<tr><th>"+id+"</th><th>"+username+"</th><th>"+grade+"</th><th>"+emial+"</th><th><a  onClick = 'return confirmoper();' href = '/UserManager3/UserClServlet?id="+id+"&type=delUser'>ɾ���û�</th><th><a href = '/UserManager3/UserClServlet?id="+id+"&type=modUser'>�޸��û�</th><tr>");//&username="+URLEncoder.encode(username, "utf-8")+"&pwd="+URLEncoder.encode(password, "utf-8")+"&email="+URLEncoder.encode(emial, "utf-8")+"
				
				//out.println("id�ţ�"+id+"   ������"+username+"   ����"+password+"  ���䣺"+emial+"   ��Ա�ȼ�"+grade+"<br>");
			}
			out.println("</table>");
			
			//��ʾ��һҳ
			if((pageNow - 1) > 0){
				out.println("<a href = '/UserManager3/ManagerUsers?pageNow="+(pageNow - 1)+"'>��һҳ</a>");
			}
			
			//��ʾ��ҳ
			for(int i = 0;i < pageCount;i++){
				out.println("<a href = '/UserManager3/ManagerUsers?pageNow="+(i+1)+"'>   <"+(i+1)+"> </a>&nbsp&nbsp");
			}
			if((pageNow+1) <= pageCount){
				out.println("<a href = '/UserManager3/ManagerUsers?pageNow="+(pageNow+1)+"'>��һҳ</a>");
			}
			
			//��ʾ��ҳ��Ϣ 
			out.println("&nbsp;&nbsp;&nbsp;��ǰҳ"+pageNow+"/��ҳ��"+pageCount);
			
			
			out.println("<br>��ת��");
			out.println("<input type = 'text' id = 'pageNow' name = 'pageNow'> <input type = 'button' onclick = 'gotoPageNow("+pageCount+")' value = '��'>");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			
			//�ر���Դ
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
