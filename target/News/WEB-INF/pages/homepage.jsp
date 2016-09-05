<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <div align="center">
            <h1>News Of The World For Today</h1>
            <table border="1">
                <th>Id</th>
                <th>Name</th>
                <th>Content</th>
                <th>Date</th>
                <th>Category</th>
                 
                <c:forEach var="news" items="${newsList}" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${news.name}</td>
                    <td>${user.content}</td>
                    <td>${user.date}</td>
                    <td>${user.category}</td>
                             
                </tr>
                </c:forEach>             
            </table>
        </div>
    </body>
</html>