<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix = "s" uri = "/struts-tags"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

<s:form action = "testConnection">
<s:textfield name = "managers[0].name" label = "名字"></s:textfield>
<s:textfield name = "managers[0].brith" label = "生日"></s:textfield>
<s:textfield name = "managers[1].name" label = "名字"></s:textfield>
<s:textfield name = "managers[1].brith" label = "生日"></s:textfield>
<s:submit></s:submit>
</s:form>

</body>
</html>