<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AddSomeNews</title>
</head>
<body>
<div align = center>
	<h1>Add some hot news!</h1>
	<c:url var="addUrl" value="/add" />
	<form:form modelAttribute="newNews"  method="POST" action="${addUrl}" >
 		<table>
  		 <tr>
  		 	<td><form:label path="name">Name:</form:label></td>
   		 	<td><form:input path="name"/></td>
  		 </tr>
 
  		 <tr>
   			<td><form:label path="content">Content:</form:label></td>
   			<td><form:input path="content"/></td>
 		 </tr>
 		 
 		 <tr>
   			<td><form:label path="date">Date:</form:label></td>
   			<td><form:input path="date"/></td>
 		 </tr>
   
  		 <tr>
   			 <td><form:label path="category">Category:</form:label></td>
  			 <td><form:input path="category"/></td>
  		</tr>
 	</table>
  
	<input type="submit" value="Add your News to the List!" />
	</form:form>
</div>
</body>
</html>