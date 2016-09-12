package com.qimh.util;

public class Test{
	static int myArg = 1;
	public static void main(String[] args) {
//		int myArg = 2 ;
//		System.out.println(myArg);
		
		Changer c = new Changer();
		c.method(args);
		
		System.out.println(args[0]+"    "+args[1]);
		
	}
	
	
	static class Changer{
		void method(String[] s){
			String temp = s[0];
			s[0] = s[1];
			s[1] = temp;
		}
	}
	
}