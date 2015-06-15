<%-- 
    Document   : InventoryUpdate
    Created on : Dec 12, 2014, 1:55:14 AM
    Author     : Lou Cram
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Update Page</title>
    </head>
    <body>
        <h1>User:${user.userID} - ${user.userName},&nbsp ${user.adminLevel}</h1>
        
        <br>
        Branch #: <b>${user.storeID}</b><br>
        Branch Name: <b>${branch.storeName}</b><br>
        Branch Location: <b>${branch.storeAddr}</b><br>
        <br>
        Book Code: <b>${update.bookID}</b><br>
        Book Title: <b>${update.title}</b><br>
        Author: <b>${update.author}</b><br>
        <br>
        <form action="InventoryChanged" method="post">
        Actual Inventory On Hand at this Branch:
            <input type="text" name="amount" id="amount" value="${update.quantity}"/><br>
            <input type="submit" value="Update Inventory">
        </form>
            <br>
            <form action="Logon">
                <input type="submit" value="Cancel">
            </form>
        <br>
        <p>Messages:</p>        
        ${msg}
        <br>  
    </body>
</html>
