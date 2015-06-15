<%-- 
    Document   : StoreSelection
    Created on : Dec 4, 2014, 9:23:19 AM
    Author     : Lou Cram
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Store Selection</title>
    </head>
     <c:if test="${!user.authenticated}">
        <script type="text/javascript">
           window.location = "/HenryBooks";
        </script>
    </c:if>
    <body>
        <h1>Inventory View/Update:</h1>
        <h3>User: ${user.userID} - ${user.userName}</h3>
        <form action="InventoryDisplay" method="post">
            Store:<br>
            <select id="storeid" name="storeid">
                <c:forEach var="st" items="${stores}">
                    <option ${st.storeID == user.storeID ? 'Selected ': ''}
                        value="${st.storeID}">${st.storeName}</option>                    
                </c:forEach>                
            </select>
            <input type="submit" value="View/Edit Inventory">
        </form>
        <br>
        <a href="/HenryBooks">Back to the Login Screen</a>
        <br>
        <p>Messages:</p>        
        ${msg}
    </body>
</html>
