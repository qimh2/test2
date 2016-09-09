package com.qimh.utils;

import java.io.UnsupportedEncodingException;

public class MyTools {
	
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
	
	

}
