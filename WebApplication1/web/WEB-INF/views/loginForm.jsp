<%-- 
    Document   : form-login
    Created on : 01/10/2017, 23:00:54
    Author     : Alcides Lemos
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="resources/css" var="fdCSS"></spring:url>
    <!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html lang="br">
    <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Alcides Lemos">
        <%-- Folhas de estilo --%>
        <spring:url value="/resources/css/bootstrap.min.css" var="bootstrap_min" />
        <spring:url value="/resources/css/signin.css" var="signin" />
        <spring:url value="http://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css" var="font" />

        <%-- JS --%>
        <spring:url value="/resources/js/jquery.min.js" var="js_jquery" />
        <spring:url value="/resources/js/popper.min.js" var="js_popper" />
        <spring:url value="/resources/js/bootstrap.min.js" var="js_bootstrap" />

        <link href="${bootstrap_min}" rel="stylesheet" />
        <link href="${font}" rel="stylesheet" />
        <link rel="stylesheet" href="${signin}" />

    <title>Login</title>

    <!-- Bootstrap core CSS -->

    <!-- Custom styles for this template -->
    <link href="signin.css" rel="stylesheet">
  </head>
    
  <body>
      <div class="container">

      <form class="form-signin" action="efetuaLogin" method="post">
        <h2 class="form-signin-heading">Login</h2>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="email" name="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" name="senha" id="inputPassword" class="form-control" placeholder="Password" required>
        <div class="checkbox">
          <label>
            <%--<input type="checkbox" value="remember-me"> Remember me--%>
            <a href="#">Cadastrar-se</a>
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>
  </body>
</html>