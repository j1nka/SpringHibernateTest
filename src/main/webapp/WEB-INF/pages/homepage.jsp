<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AllNews</title>
    </head>
    <body>
        <div align="center">
            <h1>News Of The World For Today!!!</h1>
            <h2><c:url var = "addUrl" value = "/add" /> If you want to add some 
            hot news, please click <a href="${addUrl}">here</a></h2>
            <c:url var="filterUrl" value="/show" />
			<form:form modelAttribute="filterNews"  method="POST" action="${filterUrl}" >
 				Select category: <form:input path="category"/>
 				<input type="submit" value="Apply filter" />
  		 	</form:form>
  		 	<br>
            <table border="1">
                <th>Id</th>
                <th>Name</th>
                <th>Content</th>
                <th>Date</th>
                <th>Category</th>
                <th>Edit</th>
                <th>Delete</th>
                <c:forEach var="news" items="${newsList}" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${news.name}</td>
                    <td>${news.content}</td>
                    <td>${news.date}</td>
                    <td>${news.category}</td>
                    <td><c:url var="editUrl" value="/edit?id=${news.id}" /><a href="${editUrl}">Edit</a></td>
                    <td><c:url var="deleteUrl" value="/delete?id=${news.id}" /><a href="${deleteUrl}">Delete</a></td>      
                </tr>
                </c:forEach>             
            </table>
        </div>
    </body>
</html>