package com.qimh.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MyTools {

	
 public static void main(String[] args) {
	 
	 Map<String, String> map = new HashMap<String, String>();
	 map.put("11", "22");
	 map.put("33", "44");
	 System.out.println(map);
	 
	 System.out.println("-------------------");
	 
	 //map ×ª»»³Élist
	 ArrayList<String> list2 = (ArrayList<String>) new ArrayList<String>(map.values());
	
	 System.out.println(list2);
	 
	 
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
