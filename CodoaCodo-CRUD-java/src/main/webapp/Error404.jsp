<jsp:include page="WEB-INF/pages/comunes/inicioHTML.jsp">
    <jsp:param name="elTitulo" value="No encontrado" />
</jsp:include>

<jsp:include page="WEB-INF/pages/comunes/navbar.jsp" />

<section class="container">
    <div class="py-3 row align-items-center justify-content-center">
        <div class="col-6" >
            <img class="card-img-top img-fluid" src="assets/poole.gif" alt="Imagen de error" />
        </div>
        <div class="col-6" >
            <h1 class="h3 text-danger">Error 404: Where are you?</h1>
            <p class="lead">¡Esta dirección URL no existe!</p>
        </div>
    </div>
</section>


<jsp:include page="WEB-INF/pages/comunes/footer.jsp"/>
<jsp:include page="WEB-INF/pages/comunes/finHTML.jsp"/>
