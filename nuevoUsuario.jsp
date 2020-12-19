<%-- 
    Document   : nuevoUsuario
    Created on : 15-dic-2020, 8:17:30
    Author     : Joel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Registro</title>
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
	
	<div class="limiter">
		<div class="container-login100" style="background-image: url('images/bg-01.jpg');">
			<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
                            <form class="login100-form validate-form" action="ServletNuevoUsuario" method="POST">
					<span class="login100-form-title p-b-49">
						DreamLand
					</span>

					<div class="wrap-input100 validate-input m-b-23" data-validate = "Nombre es requerido">
						<span class="label-input100">Nombre</span>
						<input class="input100" type="text" name="nombre" placeholder="Ingrese su Nombre">
						<span class="focus-input100" data-symbol="&#xf206;"></span>
					</div>

					<div class="wrap-input100 validate-input m-b-23" data-validate="Apellido es requerido">
						<span class="label-input100">Apellido</span>
						<input class="input100" type="text" name="apellido" placeholder="Ingrese su Apellido">
						<span class="focus-input100" data-symbol="&#xf206;"></span>
					</div>
                                        
                                        <div class="wrap-input100 validate-input m-b-23" data-validate="Dni es requerido">
						<span class="label-input100">Dni</span>
						<input class="input100" type="text" name="dni" placeholder="Ingrese su Dni">
						<span class="focus-input100" data-symbol="&#xf206;"></span>
					</div>
                                    
                                        <div class="wrap-input100 validate-input m-b-23" data-validate="Usuario es requerido">
						<span class="label-input100">Usuario</span>
						<input class="input100" type="text" name="usuario" placeholder="Ingrese su nuevo usuario">
						<span class="focus-input100" data-symbol="&#xf206;"></span>
					</div>
                                    
                                        <div class="wrap-input100 validate-input" data-validate="Contraseña es requerida">
						<span class="label-input100">Contraseña</span>
						<input class="input100" type="password" name="pass" placeholder="Ingrese su nueva contraseña">
						<span class="focus-input100" data-symbol="&#xf190;"></span>
					</div>
                                    <br>
					<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<button class="login100-form-btn">
								Registrar
							</button>
						</div>
					</div>

					

					<div class="flex-col-c p-t-155">

						<a href="login.jsp" class="txt2">
							Iniciar Sesion
						</a>
					</div>
				</form>
			</div>
		</div>
	</div>
	

	<div id="dropDownSelect1"></div>
	
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

</body>
</html>
