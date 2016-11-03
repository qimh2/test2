<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  
  		<s:debug></s:debug>
  	<br>---------------------EL 表达式  ----------------------<br>
    	名字：${username }<br>
    	名字2：<%= request.getAttribute("username") %><br>
    	密码：${pwd }<br>
    	requst类：<%=request
    	
    	 %>
    	<br>---------------------ONGL表达式和s:property 获取属性-----------------------<br>
    	
    	名字：<s:property value = "[0].username"/>
    	密码：<s:property value = "pwd"/>
    	年龄：<s:property value = "age"/>
    	<br>---------------------ONGL表达式和s:property 获取属性-----------------------<br>
    	
    	名字：<s:property value = "[1].username"/>
    	密码：<s:property value = "[1].pwd"/>
    	年龄：<s:property value = "[1].age"/>
    	
    	
    	<br>---------------------EL 表达式  ----------------------<br>
    	
    	名字：${sessionScope.loginaction.username }
    	密码：${sessionScope.loginaction.pwd }
    	test名字：${requestScope.test.username }
    	test密码：${requestScope.test.pwd }
    	
    	
    	<br>--------------------OGNL 表达式  获取Map栈里面的属性----------------------<br>
    	
    	
    	名字：<s:property value = "#session.loginaction.username"/>
    	密码：<s:property value = "#session.loginaction.pwd"/>
    	test名字：<s:property value = "#request.test.username"/>
    	test密码：<s:property value= "#request.test.pwd"/>
    	
    	
    	
    	<br>---------------------使用OGNL调用public类的public类型的属性字段和静态方法 ----------------------<br>
    	
    	<s:property value = "@java.lang.Math@PI"/><br>
    	<s:property value = "@java.lang.Math@abs(-9)"/>
    	
    	
    	<br>---------------------调用对象栈的方法为一个属性赋值 ----------------------<br>
    	<s:property value = "setUsername('武松')"/><br>
    	名字：<s:property value = "username"/>
    	
    	<br>---------------------调用数组对象的属性 ----------------------<br>
    	
    	<%
    		String[] strs = new String[]{"aaa","bbb"};
    		request.setAttribute("strs", strs);
    	 %>
    	 
    	 length:<s:property value = "#attr.strs.length"/><br>
    	 strs[0]:<s:property value = "#attr.strs[0]"/>
    	 
    	 
    	 <br>---------------------调用list对象的属性 ----------------------<br>
    	
    	<%
    		List list = new ArrayList();
    		list.add("111");
    		list.add("222");
    		list.add("333");
    		request.setAttribute("list", list);//放入到request中
    	 %>
    	 
    	 length:<s:property value = "#attr.list.size"/><br>
    	 list[0]:<s:property value = "#attr.list[0]"/>
    	 
    	 
    	<br>---------------------使用OGNL访问Map ----------------------<br>
    	
    	<%
    		Map<String,String> map = new HashMap<String,String>();
    		map.put("aa", "AA");
    		map.put("bb", "BB");
    		request.setAttribute("map", map);
    	
    	 %>
    	 
    	 map长度：<s:property value = "#attr.map.size"/><br>
    	 map['aa']：<s:property value = "#attr.map['aa']"/>
  </body>
</html>
