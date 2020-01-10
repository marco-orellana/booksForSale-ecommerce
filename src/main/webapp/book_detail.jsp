<%-- 
    Document   : livre
    Created on : 22 sept. 2019, 20 h 44 min 10 s
    Author     : fgaudrea
--%>

<%@page import="com.manager.SessionM"%>
<%@page import="com.entity.User"%>
<%@page import="com.entity.Category"%>
<%@page import="com.entity.Category"%>
<%@page import="com.action.LivreA"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.entity.Livre"%>
<%@page import="com.entity.Livre"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%

    ArrayList<Category> category = (ArrayList<Category>) request.getAttribute(LivreA.listCategory);
    Livre livre = (Livre) request.getAttribute(LivreA.livreById);
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="include/css.html" %>
    </head>
    <body>
        <%@include file="include/nav.html" %>


        <h1><%=livre.getNom()%></h1>
        <img src="<%=request.getContextPath()%>/img/<%=livre.getImageUrl()%>" />
        <h4>Nombre de pages : <%=livre.getPage()%></h4>
        <%
            for (Category c : category) {
                if (livre.getIdCategory() == c.getId()) {%>
        <h4>Catégorie : <%=c.getDescription()%></h4>
        <%}
            }
        %>
        <h4>Prix : <%=livre.getPrix()%>$</h4>


        <% 
                out.println("<a href='livreC?idLivreForCart=" + livre.getId() + "'>Ajouter au panier</a>");

            %>

    </body>
</html>
