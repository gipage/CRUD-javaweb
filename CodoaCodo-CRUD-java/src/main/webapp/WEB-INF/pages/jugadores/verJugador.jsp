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
            <labelp class="fs-5">Nombre:</label> 
            <label class="fs-6">${jugadorAVer.nombre}</label><br>
            <label class="fs-5">Apellido:</label>
            <label class="fs-6">${jugadorAVer.apellido}</label><br>
            <label class="fs-5">Estatura:</label>
            <label class="fs-6">${jugadorAVer.estatura}</label><br>
            <label class="fs-5">Posición:</label>
            <label class="fs-6">${jugadorAVer.posicion}</label><br>   
            <label class="fs-5">Dorsal:</label>
            <label class="fs-6">${jugadorAVer.dorsal}</label>     
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
