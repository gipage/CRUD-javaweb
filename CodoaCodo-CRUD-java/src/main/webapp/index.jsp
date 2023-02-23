<jsp:include page="WEB-INF/pages/comunes/inicioHTML.jsp">
    <jsp:param name="elTitulo" value="JavaWebApp" />
</jsp:include>

<jsp:include page="WEB-INF/pages/comunes/navbar.jsp" />

<div class="container">
    <div class="p-5 mb-2">
        <h1 class="display-5 fw-bold">Bienvenido a la JavaWebApp: Registrá tu jugador NBA favorito! </h1>
        <p class="fs-5">Este es un proyecto CRUD (Create, Read, Update, Delete) WebApp Java MVC realizado por <a target="_blank" href="https://www.linkedin.com/in/paolettigino/"> Gino Paoletti Geuna</a>.</p>
        <div id="carouselExample" class="carousel slide">
            <div class="carousel-inner " style=" width:100%; height: 500px">
                <div class="carousel-item active ">
                    <img src="assets/carrousel3.jpg" class="d-block w-100" alt="slide1">
                </div>
                <div class="carousel-item ">
                    <img src="assets/carrousel2.jpg" class="d-block w-100" alt="slide2">
                </div>
                <div class="carousel-item ">
                    <img src="assets/carrousel1.jpg" class="d-block w-100" alt="slide3">
                </div>
            </div>
            
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExample" data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Anterior</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExample" data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Siguiente</span>
            </button>
        </div>


        <a class="btn btn-dark btn-lg mt-4" href="${pageContext.request.contextPath}/arma-tu-equipo">Registrá tu jugador/es!</a>
    </div>
</div>

<jsp:include page="WEB-INF/pages/comunes/footer.jsp"/>        
<jsp:include page="WEB-INF/pages/comunes/finHTML.jsp"/>



