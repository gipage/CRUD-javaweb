<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../comunes/inicioHTML.jsp">
    <jsp:param name="elTitulo" value="Editar a ${jugadorAEditar.nombreCompleto}" />
</jsp:include>

<jsp:include page="../comunes/navbar.jsp" />

<section class="container py-3">
    <div class="row">
        <h1 class="h3">Editando Jugador</h1>
        <p class="lead">Estás a punto de editar a ${jugadorAEditar.nombreCompleto}. Asegurate de hacer click en "Confirmar cambios".</p>
    </div>

    <div class="row align-items-center px-4 mt-3">
        <div class="col-md-5 col-lg-4" >
            <div class="card h-100">
                <jsp:include page="partes/dataCardJugador.jsp">
                    <jsp:param name="fotoJugador" value="${jugadorAEditar.foto}" />
                    <jsp:param name="nombreCompletoJugador" value="${jugadorAEditar.nombreCompleto}" />
                </jsp:include>
            </div>
        </div>
        <div class="col-md-7 col-lg-8" >
            <form id="formAgregarJugador" action="${pageContext.request.contextPath}/arma-tu-equipo?accion=update&id=${jugadorAEditar.id}"
                  method="post" class="was-validated border p-4 rounded-3 bg-light">
                <div class="row">
                    <div class="col-sm-6 mb-3">
                        <label for="nombre" class="form-label">Nombre</label>
                        <input type="text" class="form-control" id="nombre" name="nombre" value="${jugadorAEditar.nombre}" required>
                    </div>
                    <div class="col-sm-6 mb-3">
                        <label for="apellido" class="form-label">Apellido</label>
                        <input type="text" class="form-control" id="apellido" name="apellido" value="${jugadorAEditar.apellido}" required>
                    </div>
                    <div class="col-sm-6 mb-3">
                        <label for="estatura" class="form-label">Estatura</label>
                        <input type="text" class="form-control" id="estatura" name="estatura" value="${jugadorAEditar.estatura}" required>
                    </div>
                    <div class="col-sm-6 mb-3">
                        <label for="posicion" class="form-label">Posición</label>
                        <input type="text" class="form-control" id="posicion" name="posicion" value="${jugadorAEditar.posicion}" required>
                    </div>
                    <div class="col-sm-6 mb-3">
                            <label for="dorsal" class="form-label">Dorsal</label>
                            <input type="text" class="form-control" id="dorsal" name="dorsal" value="${jugadorAEditar.dorsal}" required>
                        </div>

                    <div class="col-12 mb-3">
                        <label for="foto" class="form-label">
                            <c:choose>
                                <c:when test="${yaTieneFoto}">Modificar</c:when>
                                <c:otherwise>Agregar</c:otherwise>
                            </c:choose>
                            foto
                        </label>
                        <input type="file" class="form-control" id="inputFoto" name="foto">
                        <input type="hidden" id="fotoBase64" name="fotoBase64" value="${jugadorAEditar.foto}">
                    </div>
                </div>
                <div class="row justify-content-end mt-2">
                    <div class="col-12">
                        <div class="float-end">
                            <a href="${pageContext.request.contextPath}/arma-tu-equipo" class="btn btn-secondary">Volver atrás</a>
                            <button type="submit" class="btn btn-warning">Confirmar cambios</button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>

</section>

<script src="scripts/fotobase64.js"></script>
<jsp:include page="../comunes/footer.jsp"/>
<jsp:include page="../comunes/finHTML.jsp"/>


