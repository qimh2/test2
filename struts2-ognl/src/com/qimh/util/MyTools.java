package com.qimh.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class MyTools {

	
 public static void main(String[] args) {
	 
	 Map<String, String> map = new HashMap<String, String>();
	 map.put("11", "22");
	 map.put("33", "44");
	
	 
	 
	 ArrayList<String> list = new ArrayList<String>();
	 list.add("111");
	 list.add("222");
	 list.add("aaa");
	 list.add("bbb");
	 System.out.println(list);
	 for (int i = 0; i < list.size(); i++) {
		System.out.println(list.get(i));
	}
}
}
