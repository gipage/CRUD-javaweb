<jsp:include page="../comunes/inicioHTML.jsp">
    <jsp:param name="elTitulo" value="${jugadorAVer.nombreCompleto}" />
</jsp:include>
<jsp:include page="../comunes/navbar.jsp" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<section class="container py-3">    
    <p class="lead">Estás viendo a ${jugadorAVer.nombreCompleto}.</p>
    <div class="row  mt-3">
        <div class="col-md-5 col-lg-4" >
            <div class="card h-100">
                <jsp:include page="partes/dataCardJugador.jsp">
                    <jsp:param name="fotoJugador" value="${jugadorAVer.foto}" />
                    <jsp:param name="nombreCompletoJugador" value="${jugadorAVer.nombreCompleto}" />
                </jsp:include>
            </div>    
        </div>   
        <div class="col-md-5 col-lg-8">
            <ul class="list-group">
                <li class="list-group-item">Nombre: ${jugadorAVer.nombre}</li>
                <li class="list-group-item">Apellido: ${jugadorAVer.apellido}</li>
                <li class="list-group-item">Estatura: ${jugadorAVer.estatura}</li>
                <li class="list-group-item">Posición: ${jugadorAVer.posicion}</li>
                <li class="list-group-item">Dorsal: ${jugadorAVer.dorsal}</li>
            </ul>  
        </div>
        <div class="row justify-content-end mt-2">
            <div class="col-12">
                <div class="float-end">
                    <a href="${pageContext.request.contextPath}/arma-tu-equipo" class="btn btn-secondary">Volver atrás</a>
                </div>
            </div>
        </div>

    </div>


</section>


<jsp:include page="../comunes/footer.jsp"/>
<jsp:include page="../comunes/finHTML.jsp"/>
