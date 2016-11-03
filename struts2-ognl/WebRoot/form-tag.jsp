<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ taglib prefix = "s" uri="/struts-tags"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>


<s:debug></s:debug>
<!-- 
	struts form 表单：
	1、使用和html的from表单感觉差不错
	2、struts2的form标签会自动生成一个table标签，以自动的进行排版
	3、可以对表单提交的值进行回显：从栈顶对象开始匹配属性，并把匹配的属性值赋到对应的标签的value中，若栈顶对象没有对应的属性
	则一次向下一个对象中找对应的属性值

 -->
<s:form action = "save">
	<s:hidden name ="userId"></s:hidden>
	
	<s:textfield name = "username" label = "用户名"></s:textfield>
	<s:password name = "pwd" label = "密码" showpassword = "false"></s:password>
	<s:textarea name = "des" lable = "描述信息"></s:textarea>
	<s:checkbox name = "married" label = "Married"></s:checkbox>
	<s:submit></s:submit>
</s:form>


</body>
</html>