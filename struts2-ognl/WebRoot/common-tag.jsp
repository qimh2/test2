<%@page import="java.util.Date"%>
<%@page import="com.qimh.action.PersonComparator"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>


<s:debug></s:debug>


<br><br>
s:sort 可以对集合中的元素进行排序


<br><br>

<%

	PersonComparator pc = new PersonComparator();
	request.setAttribute("comparator", pc);
	session.setAttribute("date", new Date());

%>
<s:sort comparator = "#request.comparator" source = "persons" var = "persons2"></s:sort>

	<s:iterator value = "#attr.persons2">
		${name } - ${age } <br>
	</s:iterator>
	
<br><br>

s:data 可以对date 对象进行排版
<br><br>
<s:date name = "#session.date" format="yyyy-MM-dd hh:mm:ss" var = "date2"></s:date>
	date:${date2 }
	
	
<br><br>
<s:iterator value = "persons">
<!-- 可以为使用%{} 把属性包装起来，使其强制的OGNL的解析 -->
<s:a href = "/struts2-ognl/getPerson.action?name=%{name}">${name }</s:a>

</s:iterator>




</body>
</html>