<%-- 
    Document   : Log-on
    Created on : Dec. 1, 2014, 8:41:00 AM
    Author     : Lou Cram
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Henry Books Inventory System</title>
    </head>
    <body>
        <h1>Welcome to the Henry Books Inventory System</h1>
        <p>Please Enter ID Number and Password:</p>
        <br>
        <form action="Logon" method="post">
            <table>
                <tr>
                    <td>User ID:</td>
                    <td><input type="text" name="empid" id="empid"
                               value=""/>
                    </td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" name="password" id="password">
                    </td>
                </tr>
            </table>
            <br>
            <input type="submit" value="Logon">
        </form>
        <p>Messages:</p>        
        ${msg}
        <br>       
    </body>
</html>
