package com.qimh.util;

import java.util.HashMap;
import java.util.Map;

import sun.management.counter.Variability;

public class Test{
	static int myArg = 1;
	public static void main(String[] args) {
//		int myArg = 2 ;
//		System.out.println(myArg);
		
//		Changer c = new Changer();
//		c.method(args);
//		
//		System.out.println(args[0]+"    "+args[1]);
		
		
		int pageCount = 7;
		StringBuffer sb = new StringBuffer();
		for(int i = 0;i < pageCount;i++){
			String str = String.valueOf(i+1);
			int i_new = i+1;
			if(i_new%3 == 0){
				str = str+"@";
			}
			sb.append(str);
			
		}
		System.out.println("sb:"+sb);
		
		String str = sb.toString();
		String[] str_arr = str.split("@");
		Map<String, String> map = new HashMap<String, String>();
		for(int i = 0;i < str_arr.length;i++){
			map.put(str_arr[i], str_arr[i]);
		}
		
		System.out.println("map:"+map.toString());
		
		
	   //±éÀúmap	
	   for (String key : map.keySet()) {
		   //System.out.println("key= "+ key + " and value= " + map.get(key));
		   if(key.contains("7")){
				System.out.println();
			}else{
				System.out.println("key length:"+key.length());
				System.out.println(Integer.parseInt(String.valueOf(key.charAt(0))));
				System.out.println(Integer.parseInt(String.valueOf(key.charAt(1))));
				System.out.println(Integer.parseInt(String.valueOf(key.charAt(2))));
			}
		  
	   }
		
	}
	
	
	static class Changer{
		void method(String[] s){
			String temp = s[0];
			s[0] = s[1];
			s[1] = temp;
		}
	}
	
}