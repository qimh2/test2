package com.qimh.util;

public class ToolKit {
	
	
	public static String str;
	
	
	
	
	public ToolKit(){
		System.out.println("���캯����ʼ������������");
	}
	
	//��̬�����
	static{
		
		str = "���Ǿ�̬�������ұ���ʼ��";
		System.out.println("��̬�����ʼ������������");
		
	}
	
	
	// �ж�һ���ַ��Ƿ�������
	public static boolean isChinese(char c) {
	      return c >= 0x4E00 &&  c <= 0x9FA5;// �����ֽ����ж�
	}
	// �ж�һ���ַ����Ƿ�������
	public static boolean isChinese(String str) {
	    if (str == null) return false;
	    for (char c : str.toCharArray()) {
	        if (isChinese(c)) return true;// ��һ�������ַ��ͷ���
	    }
	    return false;
	}

	
	//����1
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
		
		
		//����2
//		char a = 'a';
//		char b = 1;
//		char c = (char) 01;
		
//		int a = 'a';
//		
//		long l = '\u00FF';
		
		
//		short myshort = 99S;//����
//		char c = 17c ;//����
		
//		String name = 'ssss';//����
//		int z = 015;//��ȷ
		
		char ch = 65;
		char ch2 = 'A';
		char ch3 = '\65';
//		char ch4 = "A";//����
		char ch5 = '\u0041';
		
		System.out.println(ch3);
		System.out.println(ch5);

	}
	
	

}




