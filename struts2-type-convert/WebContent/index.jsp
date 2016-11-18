<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix = "s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
	问题0：如果Action没有实现ValidationAware接口时，这是出现类型转化错误，struts2 是不会给出任何提示的，要想给出提示，需要实现ValidationAware接口参可以。

	问题1：如何覆盖默认的错误信息？
		1).在对应的Action类所在包新建
		   ActionClassName.properties文件，ActionClassName 即为包含着输入字段的Action类的类名
		2).在属性文件中添加如下键值对：invalid.fieldvalue.fieldName=xxx   
		
	问题2：如果是simple主题，还会自动显示错误信息吗？如果不会显示，怎么办？
		1).通过debug标签，可知若转换出错，则在值栈的Action（实现了ValidationAware接口）对象有一个fieldErrors属性值，
		       该属性的类型为Map<String,List<Stirng>> 键：字段（属性名），值：错误消息组成的list，所以可以使用EL或OGNL的方式
		        来显示错误消息${filedErrors.age[0]}
		2).还可以使用s:fielderror标签来显示，可以通过filedName属性显示指定字段的错误

	问题3.若是simple主题，且使用<s:fielderror name = "age"></s:fielderror>来显示错误信息，则该消息在一个ul,li,span 中，如何去掉ul,li,span 呢？
		  在template.simple 下面的filederror.ftl定义了simple主题下，s:fielderror 标签显示的错误信息样式，所以修改该配置文件即可。在src下新建一个template.simple包
		 新建fielderror.ftl文件，把原生的fielderror.ftl中的内容，复制到新建的fielderror.ftl中，然后删除ul，li,span 部分即可
	
	 -->
 <s:debug></s:debug>
<s:form action = "testyConversion.action" theme="simple">
	<s:textfield name = "age" label = "年龄"></s:textfield>
	<!-- ${fieldErrors.age[0] } -->
	<s:fielderror name = "age"></s:fielderror>
	<s:submit></s:submit>
</s:form>

</body>
</html>