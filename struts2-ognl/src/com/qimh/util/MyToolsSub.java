package com.qimh.util;

import java.util.HashMap;
import java.util.Map;

public class MyToolsSub extends MyTools {

	
 public static void main(String[] args) {
	 
	 Map<String, String> map = new HashMap<String, String>();
	 map.put("11", "22");
	 map.put("33", "44");
	 
	
	 MyToolsSub myToolsSub = new MyToolsSub();
	 
	 System.out.println(myToolsSub.hashCode());
	 
	 System.out.println(String.valueOf(myToolsSub));
	
}
}
