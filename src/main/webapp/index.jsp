<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en_US"/>

<!DOCTYPE html>
<html>

<head>
  <title>B.A - Backend Final App</title>
  <meta charset='utf-8'>
  <meta name="author" content="Augusto Occhiuzzi" />
  <meta name='viewport' content='width=device-width, initial-scale=1' />


  <!--Fonts and utilities-->
  <link rel="preconnect" href="https://fonts.googleapis.com" />
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
  <link rel='stylesheet' href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" />
  <link href="https://fonts.googleapis.com/css2?family=Lobster&family=Lobster+Two&family=Nunito:wght@200&family=Smooch+Sans:wght@100&display=swap" rel="stylesheet">
  <link rel='stylesheet' type='text/css' media='screen' href="${pageContext.request.contextPath}/css/styles.css" />

  <!--Bootstrap-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
    </head>
        
        <body>
            <header>
              <nav class="navbar navbar-expand-lg bg-dark">
                    <div class="container-fluid">
                        <img id="logoNav" src="images/logo_BA.png"/>
                        <a class="navbar-brand text-bg-dark" href="index.jsp">Buenos Aires Ciudad</a>
                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navbarNav">
                            <ul class="navbar-nav ms-auto">
                                <li class="nav-item">
                                    <a class="nav-link active text-bg-dark" aria-current="page" href="index.jsp">Inicio</a>
                                </li>
                                <div class="dropdown ">
                                    <a class="btn btn-warning dropdown-toggle text-bg-dark" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                      Acciones
                                    </a>

                                    <ul class="dropdown-menu">
                                      <li><a class="dropdown-item" href="htmls/login.jsp">Login</a></li>
                                      <li><a class="dropdown-item" href="htmls/register.jsp">Registro</a></li>
                                    </ul>
                                </div>
                            </ul>
                        </div>
                    </div>
                </nav>
            </header>

  <main>
    <div class="containerImage">
      <div class="cajaInferior"></div>
      <div class="backImage">
        <img class="backgroundImage" src="${pageContext.request.contextPath}/images/597925.jpg">
      </div>
      <div class="cajaInferior"></div>
    </div>
      <br>
    <h1>Nuestra Historia</h1>

    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. 
        Officiis et atque dolore dolores, error sint. Repellendus,
        porro? Ipsam nesciunt non molestias unde repudiandae, nemo, 
        nam quos eos in, vitae minus!
    </p>    
  </main>
</body>
</html>
