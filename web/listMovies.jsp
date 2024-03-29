<%-- 
    Document   : listMovies
    Created on : 14 mai 2012, 16:59:45
    Author     : brunolarosa
--%>

<%-- Start CAS LIST Non vide --%>
<c:if test="${!empty moviesList}">
    <ul id="productsList">
        <c:forEach var="movie" items="${moviesList}">
            <li class="movie">
                <div class="img"></div>
                <div class="desc">
                    <div class="title">
                        <h1>${movie.title}</h1>
                    </div>
                    <div class="details"></div>
                    <div class="resume">
                        <p>${movie.description}</p>
                    </div>
                </div>
                <div class="price">
                    ${movie.price}
                </div>
            </li>
        </c:forEach>
    </ul>
</c:if>
<%-- End CAS LIST Non vide --%>

<%-- Start CAS LIST vide --%>
<c:if test="${empty moviesList}">
    Erreur : Empty List
</c:if>
<%-- End CAS LIST vide --%>
