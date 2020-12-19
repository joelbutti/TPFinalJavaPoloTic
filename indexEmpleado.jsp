<%-- 
    Document   : indexEmpleado
    Created on : 15-dic-2020, 11:05:00
    Author     : Joel
--%>

<%@page import="Logica.Controladora"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
        integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/style.css">

    <title>DreamLand</title>
</head>

<body>
    <%
        HttpSession sesionActiva = request.getSession();
        
        String usu= (String) request.getSession().getAttribute("admin");
            if(usu==null){
                response.sendRedirect("sinLogin.jsp");
            }
            else{
                Controladora control = new Controladora();
                sesionActiva.setAttribute("control", control);
            }
    %>
    <header class="mt-0 pt-0">
        <div class="bg-cover clearfix pt-3">
            <h2 class="logo">DreamLand</h2>
            


            <input type="text" id="nav-search" class="nav-search mx-auto" name="" class="form-control">
            <div class="ml-0 mr-0 pb-1">
                <nav class="navbar navbar-expand-md">

                    <button class="navbar-toggler ml-auto" data-target="#my-nav" data-toggle="collapse"
                        aria-controls="my-nav" aria-expanded="false" onclick="myFunction(this)"
                        aria-label="Toggle navigation">
                        <span class="bar1"></span> <span class="bar2"></span> <span class="bar3"></span>
                    </button>
                    <div id="my-nav" class="collapse navbar-collapse">
                        <ul class="navbar-nav mx-auto">
                            <li class="nav-item">
                                <a class="nav-link" href="indexEmpleado.jsp">Inicio</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="verJuegos.jsp">Panel de Juegos</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="panelEntradas.jsp">Panel de Entradas</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="nuevoEmpleado.jsp">Crear cuenta Empleado</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="nuevoJuego.jsp">Crear Nuevo Juego</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" >Bienvenido <%= request.getSession().getAttribute("usuario") %>! </a>
                            </li>
                            
                        </ul>
                    </div>
                </nav>
            </div>
        </div>

        <div class="row ml-0 mr-0">
            <div class="col-md-6 pr-0">
                <div class="card">
                    <img class="card-img" src="assets/images/montañarusa.jpeg" alt="" width="500" height="500">
                    <div class="card-img-overlay d-flex align-items-center justify-content-center flex-column">
                        <hr />
                        <h2>Montañas rusas Extremas</h2>
                    </div>
                </div>
            </div>
            <div class="col-md-6 pl-0">
                <div class="card">
                    <img class="card-img" src="assets/images/montanarusaAcuatica.jpg" alt="" width="500" height="500">
                    <div class="card-img-overlay d-flex align-items-center justify-content-center flex-column">
                        <hr />
                        <h2>Montañas rusas Acuaticas</h2>
                    </div>
                </div>
            </div>

            <div class="col-md-3 pr-0 first">
                <div class="card">
                    <img class="card-img" src="assets/images/atraccioninfantil.jpg" alt="">
                    <div class="card-img-overlay">
                        <h5>Atracciones infantiles</h5>
                    </div>
                </div>
            </div>

            <div class="col-md-3 pl-0 pr-0">
                <div class="card">
                    <img class="card-img" src="assets/images/buffet.jpg" alt="">
                    <div class="card-img-overlay">
                        <h5>Buffets</h5>
                    </div>
                </div>
            </div>

            <div class="col-md-3 pl-0 pr-0">
                <div class="card">
                    <img class="card-img" src="assets/images/atraccionacuatica.jpg" alt="">
                    <div class="card-img-overlay">
                        <h5>Atracciones acuaticas</h5>
                    </div>
                </div>
            </div>

            <div class="col-md-3 pl-0 last">
                <div class="card">
                    <img class="card-img" src="assets/images/recuerdos.jpg" alt="">
                    <div class="card-img-overlay">
                        <h5>Tienda de recuerdos</h5>
                    </div>
                </div>
            </div>
        </div>

    </header>

    <div class="container-fluid video-player">
        <div class="container">
            <div class="screen embed-responsive embed-responsive-16by9">
                <iframe id="screen" src="https://www.youtube.com/embed/8HDMexqDn5U" frameborder="0"
                    allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
                    allowfullscreen ></iframe>
            </div>

            <div class="play-list">
                <div class="owl-carousel owl-carousel4 owl-theme">
                    <div>
                        <div class="card"> <img class="card-img link-img"
                                data-link="https://www.youtube.com/embed/B6C9QZFpw-U" src="assets/images/imgvideosplash.jpg"
                                alt="" widht="80" height="120">
                        </div>
                    </div>
                    <div>
                        <div class="card"> <img class="card-img link-img"
                                data-link="https://www.youtube.com/embed/DEj4_0pgJc0" src="assets/images/imgmontañaverde.jpg"
                                alt="" widht="80" height="120">

                        </div>
                    </div>
                    <div>
                        <div class="card"> <img class="card-img link-img"
                                data-link="https://www.facebook.com/plugins/video.php?height=314&href=https%3A%2F%2Fwww.facebook.com%2FParquedelacostaoficial%2Fvideos%2F319664472005284%2F&show_text=false&width=560" 
                                src="assets/images/imgcasadelhorror.jpg"
                                alt="" widht="80" height="120">

                        </div>
                    </div>
                    <div>
                        <div class="card"> <img class="card-img link-img"
                                data-link="https://www.youtube.com/embed/laXtco_jIZ8" src="assets/images/imgpendulo.jpg"
                                alt="" widht="80" height="120">

                        </div>
                    </div>
                    <div>
                        <div class="card"> <img class="card-img link-img"
                                data-link="https://www.youtube.com/embed/LEbWiC4h6ZA" src="assets/images/imgsamba.jpg"
                                alt="" widht="80" height="120">

                        </div>
                    </div>
                </div>
            </div>
            <hr>



            <div class="row vr-gallery">
                <div class="col-md-8 mb-4">
                    <div class="row">
                        <div class="col-md-12 col-lg-7 pr-0 pd-md">
                            <img src="assets/images/imgacuatica.jpg" alt="">
                        </div>
                        <div class="col-md-12 col-lg-5 light-bg cus-pd cus-arrow-left">
                            <p><small>Diciembre 12, 2020</small></p>
                            <h3>Atracciones acuaticas</h3>
                            <p>Para los amantes del agua tenemos las mejores atracciones para disfrutar los dias de calor!</p>
                        </div>
                    </div>
                </div>

               

                <div class="col-md-8 mb-4 pr-0 pd-md" >
                    <div class="card" >
                        <img class="card-img h-100" src="assets/images/imgnaturaleza (1).jpg" alt="">
                        <div class="card-img-overlay">
                            <div class="contact-box">
                                <p><small>Diciembre 12, 2020</small></p>
                                <h3>Atracciones Naturales</h3>
                                <p>Descubre la naturaleza que rodea nuestro maravilloso parque mientras te diviertes en nuestras atracciones!</p>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-md-4 pl-4 mb-4">
                    <div class="card">
                        <img class="card-img-top" src="assets/images/imgparquenoche.jpg" alt="">
                        <div class="card-body bg-gray cus-pd2 cus-arrow-up">
                            <p><small>Diciembre 12, 2020</small></p>
                            <h3>Abierto todo el año</h3>
                            <p>Veni a disfrutar nuestro parque desde las 08 am hasta las 24pm los 365 dias del año!</p>
                        </div>
                    </div>
                </div>

                <div class="col-md-8 mb-4">
                    <div class="row">
                        <div class="col-md-12 col-lg-7 pr-0 pd-md">
                            <img src="assets/images/imgreflejoagua.jpg" alt="">
                        </div>
                        <div class="col-md-12 col-lg-5 light-bg cus-pd cus-arrow-left">
                            <p><small>Diciembre 12, 2020</small></p>
                            <h3>Momentos innolvidables</h3>
                            <p>Pasa uno de los mejores dias de tu vida entre amigos y familia junto a nosotros!
                            </p>
                        </div>
                    </div>
                </div>

                

               
            </div>

        </div>
    </div>
    <footer class="container-fluid pt-5">
        <div class="container">
            <h2 class="logo text-center">DreamLand</h2>
        </div>
        <div class="copyright mt-4">
            <p class="text-center">&copy; 2020 <a href="#" class="text-white">DreamLand</a>. All Rights Reserved. Design
                by <a href="https://freehtml5.co/shahala" target="_blank" class="text-white">Joel Butti</a>.</p>
        </div>
    </footer>

    <script src="assets/js/popper.min.js"></script>
    <script src="assets/js/jquery-1.12.0.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/owl.carousel.min.js"></script>
    <script src="assets/js/jquery.yu2fvl.js"></script>
    <script src="assets/js/main.js"></script>

</body>

</html>
