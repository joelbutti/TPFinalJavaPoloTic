<%-- 
    Document   : nuevoJuego
    Created on : 15-dic-2020, 14:52:38
    Author     : Joel
--%>

<%@page import="Logica.Juego"%>
<%@page import="java.util.List"%>
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
    
    <meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="assets/images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="assets/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="assets/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="assets/fonts/iconic/css/material-design-iconic-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="assets/vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="assets/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="assets/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="assets/vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="assets/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="assets/css/util.css">
	<link rel="stylesheet" type="text/css" href="assets/css/main.css">
<!--===============================================================================================-->
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
    </header>
        <div class="limiter">
		<div class="container-login100" style="background-image: url('images/bg-01.jpg');">
			<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
                            <form class="login100-form validate-form" action="ServletEntradasDia" method="POST">
					<span class="login100-form-title p-b-49">
						Venta de Entradas Segun Dia
					</span>

					<div class="wrap-input100">
						<span class="label-input100">Fecha de la que desea buscar Entradas vendidas</span>
						<input class="input100" type="date"  name="fecha" min="2020-12-23">
						<span class="focus-input100" data-symbol="&#xf206;"></span>
					</div>
                                    
                                        
                                    <br>
					<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<button class="login100-form-btn">
								Buscar
							</button>
						</div>
					</div>

					

					<div class="flex-col-c p-t-155">

						
					</div>
				</form>
			</div>
		</div>
	</div>
                            
        <div class="limiter">
		<div class="container-login100" style="background-image: url('images/bg-01.jpg');">
			<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
                            <form class="login100-form validate-form" action="ServletEntradasJuego" method="POST">
					<span class="login100-form-title p-b-49">
						Venta de Entradas Segun Juego
					</span>

					<div class="wrap-input100" >
						<span class="label-input100">Seleccione ID del juego</span>
						<select class="input100" name="juego">
                                                    <%          Controladora control = (Controladora) sesionActiva.getAttribute("control");
                                                                int id = (Integer) sesionActiva.getAttribute("idActivo");
                                                                List<Juego>listaJuegos = control.getListaJuegos(); 
                                                                    for(Juego jue : listaJuegos){
                                                                %>
                                                                <option><%=jue.getIdJuego()%></option>
                                                    <% }%>
                                                </select>
						<span class="focus-input100" data-symbol="&#xf206;"></span>
					</div>
                                    
                                        
                                    <br>
					<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<button class="login100-form-btn">
								Buscar
							</button>
						</div>
					</div>

					

					<div class="flex-col-c p-t-155">

						
					</div>
				</form>
			</div>
		</div>
	</div>
	

	<div id="dropDownSelect1"></div>
	<script src="assets/js/popper.min.js"></script>
    <script src="assets/js/jquery-1.12.0.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/owl.carousel.min.js"></script>
    <script src="assets/js/jquery.yu2fvl.js"></script>
    <script src="assets/js/main.js"></script>
<!--===============================================================================================-->
	<script src="assets/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="assets/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="assets/vendor/bootstrap/js/popper.js"></script>
	<script src="assets/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="assets/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="assets/vendor/daterangepicker/moment.min.js"></script>
	<script src="assets/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="assets/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="assets/js/main.js"></script>
    <footer class="container-fluid pt-5">
        <div class="container">
            <h2 class="logo text-center">DreamLand</h2>
        </div>
        <div class="copyright mt-4">
            <p class="text-center">&copy; 2020 <a href="#" class="text-white">DreamLand</a>. All Rights Reserved. Design
                by <a href="https://freehtml5.co/shahala" target="_blank" class="text-white">Joel Butti</a>.</p>
        </div>
    </footer>

    

</body>

</html>
