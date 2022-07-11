<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en_US"/>

<!DOCTYPE html>
<html>
    <head>
        <title>B.A - Solicitud Tickets</title>
        <meta name="author" content="Augusto Occhiuzzi" />
        <meta name='viewport' content='width=device-width, initial-scale=1' />

        <!--Fonts and utilities-->
        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
        <link rel='stylesheet' href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" />
        <link href="https://fonts.googleapis.com/css2?family=Lobster&family=Lobster+Two&family=Nunito:wght@200&family=Smooch+Sans:wght@100&display=swap" rel="stylesheet">
        <link rel='stylesheet' type='text/css' media='screen' href='../css/styles.css'>

        <!--Bootstrap-->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

    </head>

    <body>
        <header>
            <nav class="navbar fixed-top navbar-expand-lg" style="background-color: black;">
                <img id="logoNav" src="../images/logo_BA.png"/>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                  <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNavDropdown">
                      <ul class="navbar-nav">
                        <li class="nav-item active">
                            <a class="nav-link" href="../index.jsp" style="color: rgb(255, 255, 255);">Inicio</a>
                        </li>
                        <li class="nav-item dropdown">
                          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown"
                            aria-haspopup="true" aria-expanded="false" style="color: rgb(255, 255, 255);">
                            Servicios
                          </a>
                          <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink" style="background-color: black;">
                            <a class="dropdown-item" href="#" style="color: white;">Venta</a>
                            <a class="dropdown-item" href="#" style="color: white;">Colocacion</a>
                            <a class="dropdown-item" href="#" style="color: white;">Reparacion</a>
                            <a class="nav-link dropright dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown"
                            aria-haspopup="true" aria-expanded="false">
                              Pedidos
                            </a>
                              <div class="dropdown-menu" style="background-color: black;">
                                <a class="dropdown-item" href="login.jsp" style="color: white;">Ingresar</a>
                                <a class="dropdown-item" href="#" style="color: white;">Consultar</a>
                              </div>
                          </div>
                        </li>
                        <li class="nav-item dropdown">
                          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="color: rgb(255, 255, 255);">
                            Acerca de
                          </a>
                          <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink" style="background-color: black;">
                            <a class="dropdown-item" href="#" style="color: white;">Nosotros</a>
                            <a class="dropdown-item" href="#" style="color: white;">Nuestra Mision</a>
                            <a class="dropdown-item" href="#" style="color: white;">Historia</a>
                          </div>
                        <li class="nav-item">
                            <a class="nav-link mr-4" href="#form" style="color: rgb(255, 255, 255);">Contacto</a>
                        </li>
                      </ul>
                    </div>
                  </nav>
        </header>

    <body>
        <main>
            <section id="masterSectionRegister">
                <div class="centerRequest">
                    <img class="centerLogoReq" src="../images/BAlogo.png" />
                    <h1>Formulario de Pedido</h1>
                    <p>La fecha de entrega sera coordinada telefonicamente</p>
                </div>
                <div  id="pedidoSubt">
                    <p><b>Tu pedido</b></p>
                </div>
                <div class="container_form inicial">
                    <br>
                    <form>
                        <div class="flexbox-container">
                            <div class="flexbox-container">
                                <div class="contenedorDescripcion">
                                    <label id="descripcion">Nombre</label>
                                    <label id="descripcion">Apellido</label>
                                </div>
                            </div>
                            <div class="flexbox-container">
                                <div class="contenedor">
                                    <input type="text" class="form-control" id="datosCant" placeholder="Nombre" required>
                                    <input type="text" class="form-control" id="tipoDesc" placeholder="Apellido" required>
                                </div>
                            </div>
                        </div>

                        <br>
                        <div class="identifyer">
                            <label>Nombre de usuario</label>
                        </div>

                        <div class="input-group mb-2">
                            <div class="input-group-prepend">
                                <div class="input-group-text">@</div>
                            </div>
                            <input type="text" class="form-control" id="inlineFormInputGroup" placeholder="Username">
                        </div>

                        <div class="identifyer">
                            <label>Email</label><label id="optional"> (Optional)</label>
                        </div>

                        <div class="form-group">
                            <input type="email" id="email" class="form-control" placeholder="Ingrese email" required />
                        </div>

                        <div class="identifyer">
                            <label>Lugar de entrega</label>
                        </div>

                        <div class="form-group">
                            <input type="email" id="email" class="form-control" placeholder="Ingrese lugar" required />
                        </div>

                        <div class="form-row">
                            <div class="col-4">
                                <label class="identifyer">Localidad</label>
                            </div>
                            <div class="col-4">
                                <label class="identifyer">Provincia</label>
                            </div>
                            <div class="col-4">
                                <label class="identifyer">Cod. Postal</label>
                            </div>
                        </div>


                        <div class="form-row">
                            <div class="col-4">
                                <input type="text" class="form-control" placeholder="Localidad">
                            </div>
                            <div class="col-4">
                                <input type="text" class="form-control" placeholder="Provincia">
                            </div>
                            <div class="col-4">
                                <input type="text" class="form-control" placeholder="C.P.">
                            </div>
                        </div>
                    </form>

                    <div id="medioPago">
                        <p><b>Forma de pago</b></p>
                        <input type="radio" value="tarjeta" checked><label>Tarjeta de Credito</label>
                        <br>
                        <input class="tipoPago" type="radio" value="mpago"><label>Mercado Pago</label>
                    </div>

                    <form>
                        <div class="form-row">
                            <div class="col-6">
                                <label class="identifyer">Nombre del titular de la tarjeta</label>
                            </div>
                            <div class="col-6">
                                <label class="identifyer">Numero de tarjeta</label>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="col-6">
                                <input type="text" class="form-control" placeholder="Localidad">
                            </div>
                            <div class="col-6">
                                <input type="number" class="form-control" placeholder="Provincia">
                            </div>
                        </div>

                        <div class="datosTarjeta">
                            <div class="form-row datosTarjRow">
                                <div class="col-6">
                                    <label class="identifyer">Fecha de Vto.</label>
                                </div>
                                <div class="col-6">
                                    <label class="identifyer">Codigo</label>
                                </div>
                            </div>
                            <div class="form-row datosTarjRow">
                                <div class="col-6">
                                    <input type="date" class="form-control">
                                </div>
                                <div class="col-6">
                                    <input type="number" class="form-control">
                                </div>
                            </div>
                        </div>    
                    </form>
                </div>  
            </section>          
        </main>
    </body>

</html>