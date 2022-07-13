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
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>

<body>
  <header>

    <ul class="nav">
      <li><a href="index.jsp">Inicio</a></li>
      <li><a href="">Servicios</a>
        <ul>
          <li><a href="">venta</a></li>
          <li><a href="">Colocacion</a></li>
          <li><a href="">Reparacion</a></li>
          <li><a href="">Pedidos</a>
            <ul>
              <li><a href="htmls/login.jsp">Ingresar</a></li>
              <li><a href="">Consultar</a></li>
            </ul>
          </li>
        </ul>
      </li>

      <li><a href="">Acerca de</a>
        <ul>
          <li><a href="">Nosotros</a></li>
          <li><a href="">Nuestra Mision</a></li>
          <li><a href="http://www.facebook.com">Historia</a></li>
        </ul>
      </li>  
      <li><a href="">Contacto</a></li>
    </ul>

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
