package com.qimh.servlet;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownLoadFile
 */
public class DownLoadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");//������utf-8���ַ������ܲ���
		
		response.setContentType("text/html");//�����������������ҳ
		String dir = "/files/";
		String fileName = request.getParameter("fileName");
		
		//getBytes:ʹ�ø����� charset ���� String ���뵽 byte ���У���������洢���µ� byte ����
		//String(byte[] bytes, Charset charset) ͨ��ʹ��ָ���� charset ����ָ���� byte ���飬����һ���µ� String��
		fileName = new String(fileName.getBytes("ISO-8859-1"), "UTF-8");
		
		System.out.println("fileName:"+fileName);
		//��ʾ�����ļ�
		response.setHeader("Content-Disposition", "attachment;filename="+new String(fileName.getBytes("UTF-8"),"ISO-8859-1"));
		
		//���ļ���˵��һ��webվ�㣬�����ļ���ԭ��
		//1����ȡ��Ҫ�����ļ���ȫ·��
		String absolutePath = this.getServletContext().getRealPath(dir+fileName);
		System.out.println("�ļ�����·����"+absolutePath);
		
		//2�������ļ�������
		FileInputStream in = new FileInputStream(absolutePath);//������
		OutputStream os = response.getOutputStream();//д����
		//��һ�������ֽ�����
		byte[] buff = new byte[1024];
		int len = 0;
		while((len = in.read(buff)) > 0){
			os.write(buff, 0, len);
		}
		
		//�ر�
		os.close();
		in.close();
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
