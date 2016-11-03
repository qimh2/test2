package com.qimh.utils;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class MyTools {

	// Ĭ���޲εĹ��췽��
	public MyTools() {
		System.out.println("�޲ι��캯��....");
	}

	// ֻ��һ�������Ĺ��캯��
	public MyTools(String name) {
		System.out.println("�в� name���캯��....");
	}

	// ֻ��һ�������Ĺ��캯��
	public MyTools(int age) {
		System.out.println("�в� age���캯��....");
	}

	public static String getNewString(String str, String byte_charset,
			String charset) {
		String new_str = "";
		try {
			if (str != null && charset != null) {
				new_str = new String(str.getBytes(byte_charset), charset);
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new_str;
	}

	/**
	 * isNumeric �ж��ַ����Ƿ�Ϊ����
	 * 
	 * @author qimh
	 * @date 20160913
	 * @param string
	 *            str---��Ҫ�����ַ���
	 * @return true--����/false--��������
	 * 
	 */
	public static boolean isNumeric(String str) {
		for (int i = 0; i < str.length(); i++) {
			// System.out.println(str.charAt(i));
			if (!Character.isDigit(str.charAt(i))) {
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
			// ��Ķ�̬ʵ����
			MyTools MyTools = (MyTools) cs.newInstance();
			System.out.println(MyTools.isNumeric("123"));

			System.out.println("-----------------------------");
			Class cls[] = new Class[] { String.class };
			Constructor<MyTools> constructor = cs.getConstructor(cls);
			System.out.println(constructor.newInstance(new String()).isNumeric(
					"456"));

			System.out.println("-----------------------------");

			Class cls2[] = new Class[] { int.class };
			Constructor<MyTools> constructor2 = cs.getConstructor(cls2);
			System.out.println(constructor2.newInstance(new Integer(11))
					.isNumeric("456"));

			System.out.println("-----------------------------");

			String[] strArray = new String[10];
			System.out.println(strArray);
			String str = "111";
			System.out.println(str);

		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Method[] methods = cs.getMethods();
		for (int i = 0; i < methods.length; i++) {
			System.out.println(methods[i].getName());
		}

		// MyTools myTools = new MyTools("");
		System.out.println("-----------------------------");
		System.out.println(md5("qimh"));

		System.out.println("-----------------------------");

		String[] arrays = new String[] { "A","b", "a", "c", "��", "��" };
		System.out.println((Arrays.toString(OrderChineseAndEnglish(arrays))));
	}

	
	//�����Ļ������
	public static String[] OrderChineseAndEnglish(String[] arrays){
		String[] strings = new String[arrays.length];
		for (int i = 0; i < arrays.length; i++) {
			String str = arrays[i];
			if (str.length() == 0)
				return null;
			String alphabet = str.substring(0, 1);
			/* �ж����ַ��Ƿ�Ϊ���ģ���������ı㽫���ַ�ƴ��������ĸ��&���ż����ַ���ǰ�� */
			if (alphabet.matches("[\\u4e00-\\u9fa5]+")) {
				str = getAlphabet(str) + "&" + str;
				arrays[i] = str;
			}
		}
		/* �����������Ի��� */
		Comparator<Object> com = Collator.getInstance(java.util.Locale.CHINA);
		Arrays.sort(arrays, com);
		/* �������飬ȥ����ʶ��&������ĸ */
		for (int i = 0; i < arrays.length; i++) {
			String str = arrays[i];
			if (str.contains("&") && str.indexOf("&") == 1) {
				arrays[i] = str.split("&")[1];
			}
			strings[i] = arrays[i];
			//System.out.println(arrays[i]);
		}
		
		
		return strings;
	}
	
	
	//����תƴ��
	public static String getAlphabet(String str) {
		HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
		// ���ƴ��ȫ��Сд
		defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		// ��������
		defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		String pinyin = null;
		try {
			pinyin = (String) PinyinHelper.toHanyuPinyinStringArray(
					str.charAt(0), defaultFormat)[0];
		} catch (BadHanyuPinyinOutputFormatCombination e) {
			e.printStackTrace();
		}
		return pinyin.substring(0, 1);
	}

	//md5 ����---php  md5 �����㷨һ��
	public static String md5(String txt) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(txt.getBytes("utf-8")); // ������Ҫ�������Java���ַ�����unicode���룬����Դ���ļ��ı���Ӱ�죻��PHP�ı����Ǻ�Դ���ļ��ı���һ�£���Դ�����Ӱ�졣
			StringBuffer buf = new StringBuffer();
			for (byte b : md.digest()) {
				buf.append(String.format("%02x", b & 0xff));
			}
			return buf.toString();
		} catch (Exception e) {
			e.printStackTrace();

			return null;
		}
	}

}
