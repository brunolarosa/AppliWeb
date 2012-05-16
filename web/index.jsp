<%-- 
    Document   : index
    Created on : 10 mai 2012, 11:13:41
    Author     : brunolarosa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Ne pas oublier cette ligne sinon tous les tags de la JSTL seront ignorés ! -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/default.css" />
        <title>BR Shop</title>
    </head>
    <body>
        <header>
            <div id="header_wrapper">
                <div class="header_top">
                    Welcome visitor you can login or create an account
                </div>
                <div class="header_main">
                    dfgg
                </div>
            </div>

            <nav id="main_menu">
                <div id="menu">
                    <ul>
                        <li><a href="Movie?action=moviesList">Home</a></li>
                        <li><a href="">Catégorie</a></li>
                    </ul>
                </div>
            </nav>
        </header>
        <section class="wrapper">
            <c:choose>
                <c:when test="${param.action == 'listMovies'}">
                    <%@include file="listMovies.jsp" %>
                </c:when>
                <c:otherwise>
                    <%@include file="home.jsp" %>
                </c:otherwise>
            </c:choose>
        </section>
    </body>
</html>
