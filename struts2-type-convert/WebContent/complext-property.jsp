<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix = "s" uri = "/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

<s:form action = "testComplexProperty.action">
	<s:textfield name = "depName" label = "部门"></s:textfield>
	<!-- 映射属性的属性 -->
	<s:textfield name = "manager.name" label = "人名"></s:textfield>
	<s:textfield name = "manager.brith" label = "生日"></s:textfield>
	<s:submit></s:submit>
</s:form>

</body>
</html>