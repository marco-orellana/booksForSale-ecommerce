<%-- 
    Document   : index
    Created on : 22 sept. 2019, 20 h 08 min 54 s
    Author     : fgaudrea
--%>

<%@page import="com.manager.SessionM"%>
<%@page import="com.entity.User"%>
<%@page import="com.action.LivreA"%>
<%@page import="com.entity.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.entity.Livre"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ArrayList<Livre> livres = (ArrayList<Livre>) request.getAttribute(LivreA.listLivre);
    ArrayList<Category> category = (ArrayList<Category>) request.getAttribute(LivreA.listCategory);
    User user = (User) SessionM.get(request, "user");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="include/css.html" %>
        <title>JSP Page</title>
    </head>
    <body>

        <%@include file="include/nav.html" %>

        <h1>Catalogue</h1>
        <%if (user != null) {
                out.println("<h2>Bonjour " + user.getPrenom() + "!</h2>");
            }%>


        <table>
            <tr>
                <th>Name</th>
                <th>Pages</th>
            </tr>
            <% for (Livre l : livres) {%>
            <tr>
                <td><%=l.getNom()%></td>
                <td><%=l.getPage()%></td>
                <td><a href="livreC?idLivre=<%=l.getId()%>">Afficher</a></td>
            </tr>

            <%}%>
        </table>
    </body>
</html>
