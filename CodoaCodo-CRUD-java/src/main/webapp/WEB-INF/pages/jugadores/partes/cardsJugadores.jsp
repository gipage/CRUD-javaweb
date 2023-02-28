<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach items="${listaJugadores}" var="jugador">  
    <div class="col">
        <div class="card h-100 ">
            <jsp:include page="dataCardJugador.jsp">
                <jsp:param name="fotoJugador" value="${jugador.foto}" />
                <jsp:param name="nombreCompletoJugador" value="${jugador.nombreCompleto}" />
            </jsp:include>
            <div class="card-footer">
                <div class="row justify-content-center">
                    <div class="col-4">
                        <a href="${pageContext.request.contextPath}/arma-tu-equipo?accion=view&id=${jugador.id}" class="btn bg-info w-100"><i class="bi bi-eye"></i></a>
                    </div>
                    <div class="col-4">
                        <a href="${pageContext.request.contextPath}/arma-tu-equipo?accion=edit&id=${jugador.id}" class="btn bg-warning w-100"><i class="bi bi-pencil"></i></a>
                    </div>
                    <div class="col-4">
                        <a href="${pageContext.request.contextPath}/arma-tu-equipo?accion=remove&id=${jugador.id}" class="btn bg-danger text-light w-100"><i class="bi bi-trash3"></i></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</c:forEach>


