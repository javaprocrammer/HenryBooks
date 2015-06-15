<%-- 
    Document   : ViewInventory
    Created on : Dec 8, 2014, 9:10:28 PM
    Author     : Lou Cram
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HB Inventory</title>        
    </head>
    <body>
        <h1>User:${user.userID} - ${user.userName},&nbsp ${user.adminLevel}</h1>
        <br>
        Branch #: <b>${user.storeID}</b><br>
        Branch Name: <b>${branch.storeName}</b><br>
        Branch Location: <b>${branch.storeAddr}</b><br>
        <br>
        <form action="UpdateRecord" method="post">
        <c:if test="${user.adminLevel == 'Admn'}">
            Book Code:<input type="text" name="cdinput" id="cdinput" value=""/>
            <input type="submit" value="Edit Record">
        </c:if>
            <br>
        <a href="/HenryBooks">Back to the Login Screen</a>
            <br>
        <table border ="1">
            <tr>
                <th>Store</th>
                <th>Book Code</th>
                <th>Book Title</th>
                <th>Retail Price</th>
                <th>Quantity</th>                
            </tr>            
            <c:forEach var="i" items="${inv}">
                <tr>
                    <td>${i.storeID}</td>
                    <td>${i.bookID}</td>
                    <td>${i.title}</td>
                    <td>${i.price}</td>
                    <td>${i.quantity}</td>
                </tr>
            </c:forEach>
        </table> 
        </form>
        <p>Messages:</p>        
        ${msg}
        <br>  
    </body>
</html>
