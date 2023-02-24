<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../comunes/inicioHTML.jsp">
    <jsp:param name="elTitulo" value="Listando Jugadores" />
</jsp:include>

<jsp:include page="../comunes/navbar.jsp" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<section class="container">
    <div class="row pt-3">
        <h1 class="h3">Listado de jugadores</h1>
        <p class="lead">Se listan todos los jugadores existentes en la base de datos</p>
        
        <div>
            <a href="#" class="btn btn-success"
               data-bs-toggle="modal" data-bs-target="#modalAgregarJugador"><i class="bi bi-person-add"></i>
                Agregar jugador</a>
        </div>
    </div>
    <hr/>
    <c:choose>
        <c:when test = "${listaJugadores != null && !listaJugadores.isEmpty()}">
            <div class="row g-4 mb-3 row-cols-1 row-cols-sm-2 row-cols-lg-3 row-cols-xl-4 row-cols-xxl-5" data-masonry='{"percentPosition": true }' >
                <jsp:include page="partes/cardsJugadores.jsp"/>
            </div>
        </c:when>
        <c:otherwise>
            <div class="row my-4">
                <div class="col-12">
                    <p class="display-5 text-danger">No hay jugadores :(</p>
                </div>
            </div>
        </c:otherwise>
    </c:choose>
</section>

<jsp:include page="partes/modalAgregarJugador.jsp"/>     
<script src="scripts/fotobase64new.js"></script>
<script src="https://cdn.jsdelivr.net/npm/masonry-layout@4.2.2/dist/masonry.pkgd.min.js" integrity="sha384-GNFwBvfVxBkLMJpYMOABq3c+d3KnQxudP/mGPkzpZSTYykLBNsZEnG2D9G/X/+7D" crossorigin="anonymous" async></script>

<jsp:include page="../comunes/footer.jsp"/>
<jsp:include page="../comunes/finHTML.jsp"/>
