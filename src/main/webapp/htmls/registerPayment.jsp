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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
    </head>
        
        <body>
            <header>
              <nav class="navbar navbar-expand-lg bg-dark">
                    <div class="container-fluid">
                        <img id="logoNav" src="../images/logo_BA.png"/>
                        <a class="navbar-brand text-bg-dark" href="../index.jsp">Buenos Aires Ciudad</a>
                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navbarNav">
                            <ul class="navbar-nav ms-auto">
                                <li class="nav-item">
                                    <a class="nav-link active text-bg-dark" aria-current="page" href="../index.jsp">Inicio</a>
                                </li>
                                <div class="dropdown ">
                                    <a class="btn btn-warning dropdown-toggle text-bg-dark" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                      Acciones
                                    </a>

                                    <ul class="dropdown-menu">
                                      <li><a class="dropdown-item" href="login.jsp">Login</a></li>
                                      <li><a class="dropdown-item" href="register.jsp">Registro</a></li>
                                    </ul>
                                </div>
                            </ul>
                        </div>
                    </div>
                </nav>
            </header>

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
                            <div class="row">
                                <div class="col">
                                    <input type="text" class="form-control" placeholder="First name" aria-label="First name">
                                </div>
                                <div class="col">
                                    <input type="text" class="form-control" placeholder="Last name" aria-label="Last name">
                                </div>
                            </div>
                        </div>

                        <br>
                        <div class="identifyer">
                            <label>Nombre de usuario</label>
                        </div>

                        <div class="input-group mb-3">
                            <span class="input-group-text" id="basic-addon1">@</span>
                            <input type="text" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1">
                        </div>

                        <div class="identifyer">
                            <label>Email</label><label id="optional"> (Optional)</label>
                        </div>

                        <div class="mb-3">
                            <input type="email" class="form-control" id="emailPay" placeholder="nombre@example.com">
                        </div>

                        <div class="identifyer">
                            <label>Lugar de entrega</label>
                        </div>

                        <div class="mb-3">
                            <input type="email" id="email" class="form-control" placeholder="Ingrese lugar" required />
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label for="inputCity" class="form-label">Ciudad</label>
                                <input type="text" class="form-control" id="inputCity">
                            </div>
                            <div class="col-md-4">
                                <label for="inputState" class="form-label">Provincia</label>
                                <select id="inputState" class="form-select">
                                    <option selected>Seleccionar...</option>
                                    <option>...</option>
                                </select>
                            </div>
                            <div class="col-md-2">
                                <label for="inputZip" class="form-label">C.P.</label>
                                <input type="text" class="form-control" id="inputZip">
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
                        <div class="flexbox-container">
                                <div class="contenedorDescripcion">
                                    <label id="descripcion">Nombre Titular Tarjeta</label>
                                    <label id="descripcion">Numero Tarjeta</label>
                                </div>
                        </div>
                        <div class="row">
                                <div class="col">
                                    <input type="text" class="form-control" placeholder="Nombre titular" aria-label="First name">
                                </div>
                                <div class="col">
                                    <input type="text" class="form-control" placeholder="Numero tarjeta" aria-label="Last name">
                                </div>
                        </div>

                        <div class="flexbox-container">
                            <div class="contenedorDescripcion">
                                <label id="descripcion">Fecha de Vto.</label>
                                <label id="descripcion">Codigo</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col">
                                <input type="text" class="form-control" placeholder="Nombre titular" aria-label="First name">
                            </div>
                            <div class="col">
                                <input type="number" class="form-control" placeholder="Numero tarjeta" aria-label="Last name">
                            </div>
                        </div>
                    </form>
                </div>  
            </section>          
        </main>
    </body>

</html>