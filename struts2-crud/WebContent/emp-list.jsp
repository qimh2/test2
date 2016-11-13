<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix= "s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

<s:debug></s:debug>

<s:form action = "emp-add.action">
	<s:textfield name = "firstName" label = "名字"></s:textfield>
	<s:textfield name = "lastName" label = "姓"></s:textfield>
	<s:textfield name = "email" label = "邮箱"></s:textfield>
	<s:submit></s:submit>
</s:form>



<table cellpadding = "10" cellspacing = "0" border = "1">
	<tr>
		<td>employee id</td>
		<td>first name</td>
		<td>last name</td>
		<td>email</td>
		<td>edit</td>
		<td>delete</td>
	</tr>
	<s:iterator value = "#request.emps">
		<tr>
			<td>${employeeId }</td>
			<td>${firstName }</td>
			<td>${lastName }</td>
			<td>${email }</td>
			<td><a href = "/struts2-crud/emp-edit?employeeId=${employeeId }">编辑</a></td>
			<td><a href = "/struts2-crud/emp-del?employeeId=${employeeId }">删除</a></td>
		</tr>
	</s:iterator>

</table>

</body>
</html>