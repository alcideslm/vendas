<%-- 
    Document   : index
    Created on : 06/10/2017, 00:50:35
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
        <meta name="author" content="">

        <title>Shop Homepage</title>

        <%-- Folhas de estilo --%>
        <spring:url value="/resources/css/bootstrap.min.css" var="bootstrap_min" />
        <spring:url value="/resources/css/shop-homepage.css" var="shop" />
        <spring:url value="http://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css" var="font" />

        <%-- JS --%>
        <spring:url value="/resources/js/jquery.min.js" var="js_jquery" />
        <spring:url value="/resources/js/popper.min.js" var="js_popper" />
        <spring:url value="/resources/js/bootstrap.min.js" var="js_bootstrap" />

        <link href="${bootstrap_min}" rel="stylesheet" />
        <link href="${font}" rel="stylesheet" />
        <link rel="stylesheet" href="${shop}" />
        <style>
            .mostrar {
                color: blue !important;
                letter-spacing: 1px;
            }
        </style>
    </head>

    <body>
        <!-- Navigation -->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
            <div class="container">
                <a class="navbar-brand" href="">Shop</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="">Home
                                <span class="sr-only">(current)</span>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" id="cart" href="cart">Carrinho</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="account">Minha Conta</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="logout">Sair do sistema</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <!-- Page Content -->
        <div class="container">

            <div class="row">

                <div class="col-lg-3">

                    <h1 class="my-4">Shop</h1>
                    <div class="list-group">
                        <a href="#" class="list-group-item">Category 1</a>
                        <a href="#" class="list-group-item">Category 2</a>
                        <a href="#" class="list-group-item">Category 3</a>
                    </div>

                </div>
                <!-- /.col-lg-3 -->

                <div class="col-lg-9">

                    <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
                        <ol class="carousel-indicators">
                            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                        </ol>
                        <div class="carousel-inner" role="listbox">
                            <div class="carousel-item active">
                                <img class="d-block img-fluid" src="http://www.netsupportmanager.com/imgs/mobile-devices.jpg" alt="First slide">
                            </div>
                            <div class="carousel-item">
                                <img class="d-block img-fluid" src="http://www.csru.ca/uploads/banner1.jpg" alt="Second slide">
                            </div>
                            <div class="carousel-item">
                                <img class="d-block img-fluid" src="http://myuniyoung.com/upload/files/small-4.jpg" alt="Third slide">
                            </div>
                        </div>
                        <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>

                    <div class="row">

                        <c:forEach items="${produtos}" var="prod">
                            <div  id="prod_${prod.cod}" class="col-lg-4 col-md-6 mb-4">
                                <div class="card h-100">
                                    <img class="card-img-top" src="http://placehold.it/700x400" alt="">
                                    <div class="card-body">
                                        <h4 class="card-title">
                                            <a href="#prod_${prod.cod}">${prod.nome} <i style="visibility: hidden" id="bag_${prod.cod}" class="icon ion-bag"></i></a>
                                        </h4>
                                        <h5>R$ ${prod.valor}</h5>
                                        <p class="card-text">${prod.descricao}</p>
                                        <button type="button" class="btn btn-primary" onClick="addCart(${prod.cod})">Adicionar ao carrinho</button>
                                    </div>
                                    <div class="card-footer">
                                        <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>

                    </div>
                    <!-- /.row -->

                </div>
                <!-- /.col-lg-9 -->

            </div>
            <!-- /.row -->

        </div>
        <!-- /.container -->

        <!-- Footer -->
        <footer class="py-5 bg-dark">
            <div class="container">
                <p class="m-0 text-center text-white">Copyright &copy; Alcides Lemos 2017</p>
            </div>
            <!-- /.container -->
        </footer>

        <!-- Bootstrap core JavaScript -->
        <script src="${js_jquery}"></script>
        <script src="${js_popper}"></script>
        <script src="${js_bootstrap}"></script>
        <script type="text/javascript">
            function addCart(id) {
                $.post(
                    "addCart", {'produto': id, 'quantidade':1},
                    function(){
                        var $fade = $('#cart');
                        $('#bag_'+id).css('visibility','visible');
                        $fade.addClass('mostrar');
                        setTimeout(function () {
                            $fade.removeClass('mostrar');
                        }, 750);
                        
                    }
                );
            }
        </script>
    </body>

</html>

