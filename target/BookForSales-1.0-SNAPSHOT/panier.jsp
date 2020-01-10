<%-- 
    Document   : panier
    Created on : Sep. 22, 2019, 9:23:28 p.m.
    Author     : morellan
--%>

<%@page import="com.manager.SessionM"%>
<%@page import="com.entity.User"%>
<%@page import="com.action.LivreA"%>
<%@page import="com.entity.Category"%>
<%@page import="com.entity.LivrePanierWrapper"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% ArrayList<LivrePanierWrapper> lpwList = (ArrayList<LivrePanierWrapper>) request.getAttribute("listLivrePanier");
    ArrayList<Category> category = (ArrayList<Category>) request.getAttribute(LivreA.listCategory);
   User user = (User) SessionM.get(request,"user");%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>panier.jsp</title>
        <%@include file="include/css.html" %>
    </head>
    <body>
        <%@include file="include/nav.html" %>
        <h1>Panier</h1>

        <table>
            <tr>
                <th>Name</th>
                <th>Ajouter</th>
                <th>Qty</th>
                <th>Retirer</th>
            </tr>
            <%
                for (LivrePanierWrapper l : lpwList) {%>
            <tr>
                <td><%=l.getLivre().getNom()%></td>
                <td><a href="panierC?idLivre=<%=l.getLivre().getId()%>&ajouterArticle=1">Ajouter</a></td>
                <td><%=l.getQty()%></td>
                <td><a href="panierC?idLivre=<%=l.getLivre().getId()%>&retirerArticle=1">Retirer</a></td>
            </tr>

            <%}%>
        </table>

        <a href="panierC?viderPanier=1">Vider Panier</a>
        <br>
        

    </body>
</html>
