<%-- 
    Document   : login
    Created on : Sep. 24, 2019, 8:37:10 p.m.
    Author     : morellan
--%>

<%@page import="com.manager.SessionM"%>
<%@page import="com.entity.User"%>
<%@page import="com.action.LivreA"%>
<%@page import="com.entity.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ArrayList<Category> category = (ArrayList<Category>) request.getAttribute(LivreA.listCategory);
    User user = (User) SessionM.get(request, "user");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="include/css.html" %>
        <title>Login</title>
    </head>
    <body>
        <%@include file="include/nav.html" %>
        <h1>Login</h1

        <form action="usersC" method="post" >
            <label>
                email <input type="text" name="lEmail">
            </label>
            <br>
            <label>
                password <input type="password" name="lPassword">
            </label>
            <br>
             <input type="submit" value="Submit">
        </form>
    </body>
</html>
