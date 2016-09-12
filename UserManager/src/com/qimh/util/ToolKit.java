package com.qimh.util;

public class ToolKit {
	
	
	public static String str;
	
	
	
	
	public ToolKit(){
		System.out.println("构造函数初始化。。。。。");
	}
	
	//静态代码块
	static{
		
		str = "我是静态变量，我被初始化";
		System.out.println("静态代码初始化。。。。。");
		
	}
	
	
	// 判断一个字符是否是中文
	public static boolean isChinese(char c) {
	      return c >= 0x4E00 &&  c <= 0x9FA5;// 根据字节码判断
	}
	// 判断一个字符串是否含有中文
	public static boolean isChinese(String str) {
	    if (str == null) return false;
	    for (char c : str.toCharArray()) {
	        if (isChinese(c)) return true;// 有一个中文字符就返回
	    }
	    return false;
	}

	
	//问题1
//	static int a = 0x11;
//	static int b = 0011;
//	static int c = '\u0011';
//	static int d = 011;
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ToolKit toolKit = new ToolKit();
		
		System.out.println(ToolKit.str);
		
		
		
		
//		System.out.println(a);
//		System.out.println(b);
//		System.out.println(c);
//		System.out.println(d);
		
		
		//问题2
//		char a = 'a';
//		char b = 1;
//		char c = (char) 01;
		
//		int a = 'a';
//		
//		long l = '\u00FF';
		
		
//		short myshort = 99S;//错误
//		char c = 17c ;//错误
		
//		String name = 'ssss';//错误
//		int z = 015;//正确
		
		char ch = 65;
		char ch2 = 'A';
		char ch3 = '\65';
//		char ch4 = "A";//错误
		char ch5 = '\u0041';
		
		System.out.println(ch3);
		System.out.println(ch5);

	}
	
	

}




