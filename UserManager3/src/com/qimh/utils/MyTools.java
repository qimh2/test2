package com.qimh.utils;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;

public class MyTools {
	
	
//	public MyTools(String name){
//		
//	}
	
	public static String getNewString(String str,String byte_charset,String charset){
		String new_str = "";
		try {
			if(str != null && charset != null){
				new_str = new String(str.getBytes(byte_charset),charset);
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new_str;
	}
	
	
	/**
	 * isNumeric �ж��ַ����Ƿ�Ϊ����
	 * @author qimh
	 * @date 20160913
	 * @param string str---��Ҫ�����ַ���
	 * @return true--����/false--��������
	 * 
	 */
	public static boolean isNumeric(String str){
		  for (int i = 0; i < str.length(); i++){
		   //System.out.println(str.charAt(i));
		   if (!Character.isDigit(str.charAt(i))){
		    return false;
		   }
		  }
		  return true;
		 }

	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Class cs = MyTools.class;
		try {
			//��Ķ�̬ʵ����
			MyTools MyTools = (MyTools) cs.newInstance();
			System.out.println(MyTools.isNumeric("123"));
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Method[] methods = cs.getMethods();
		for(int i = 0;i<methods.length;i++){
			System.out.println(methods[i].getName());
		}
		
		
		
		
//		MyTools myTools = new MyTools("");
		

	}

}
