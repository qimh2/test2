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
		
		request.setCharacterEncoding("UTF-8");//设置以utf-8的字符集接受参数
		
		response.setContentType("text/html");//告诉浏览器，我是网页
		String dir = "/files/";
		String fileName = request.getParameter("fileName");
		
		//getBytes:使用给定的 charset 将此 String 编码到 byte 序列，并将结果存储到新的 byte 数组
		//String(byte[] bytes, Charset charset) 通过使用指定的 charset 解码指定的 byte 数组，构造一个新的 String。
		fileName = new String(fileName.getBytes("ISO-8859-1"), "UTF-8");
		
		System.out.println("fileName:"+fileName);
		//演示下载文件
		response.setHeader("Content-Disposition", "attachment;filename="+new String(fileName.getBytes("UTF-8"),"ISO-8859-1"));
		
		//打开文件，说明一下web站点，下载文件的原理
		//1、获取需要下载文件的全路径
		String absolutePath = this.getServletContext().getRealPath(dir+fileName);
		System.out.println("文件绝对路径："+absolutePath);
		
		//2、创建文件输入流
		FileInputStream in = new FileInputStream(absolutePath);//读入流
		OutputStream os = response.getOutputStream();//写入流
		//做一个缓冲字节数组
		byte[] buff = new byte[1024];
		int len = 0;
		while((len = in.read(buff)) > 0){
			os.write(buff, 0, len);
		}
		
		//关闭
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
