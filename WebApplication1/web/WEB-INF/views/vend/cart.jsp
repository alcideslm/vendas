<%-- 
    Document   : cart
    Created on : 08/10/2017, 10:37:15
    Author     : Alcides Lemos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="br">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Shop Cart</title>

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
    </head>
    <body>
        <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
            <a class="navbar-brand" href="#">Shop</a>
            <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarsExampleDefault">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item ">
                        <a class="nav-link" href="./">Home </a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="#">Carrinho<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="account">Minha Conta</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="logout">Sair</a>
                    </li>
                </ul>
            </div>
        </nav



        <div class="container-fluid">
            <div class="row">
                <nav class="col-sm-3 col-md-2 d-none d-sm-block bg-light sidebar">
                    <ul class="nav nav-pills flex-column">
                        <li class="nav-item">
                            <a class="nav-link active" href="#">Carrinho <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="pedidos">Meus Pedidos</a>
                        </li>
                    </ul>
                </nav>
                <main class="col-sm-9 ml-sm-auto col-md-10 pt-3" role="main">
                    <h1>Carrinho</h1>

                    <div class="table-responsive">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Produto</th>
                                    <th>Descricão</th>
                                    <th>Valor Unit.</th>
                                    <th>Quantidade</th>
                                    <th>Remover</th>
                                    <th>Valor Total.</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${carrinho}" var="produto">
                                    <tr>
                                        <td>${produto.cod}</td>
                                        <td>${produto.nome}</td>
                                        <td>${produto.descricao}</td>
                                        <td>R$ ${produto.valor}</td>
                                        <td>
                                            <a href='#' onClick="removeCart(${produto.cod})"><i id="rem_${produto.cod}" style="font-size: 20px" class="icon ion-ios-minus-outline" ></i></a>
                                            &VeryThinSpace;&VeryThinSpace;&VeryThinSpace;&VeryThinSpace;
                                            <span id="qtd_${produto.cod}">${produto.quantidade}</span>
                                            &VeryThinSpace;&VeryThinSpace;&VeryThinSpace;&VeryThinSpace;
                                            <a href='#'><i id="add_${produto.cod}" style="font-size: 20px" class="icon ion-ios-plus-outline" onClick="addCart(${produto.cod})"></i></a>
                                        </td>
                                        <td><a href="#">Remover</a></td>
                                        <td>R$ ${produto.valor * produto.quantidade}</td>
                                    </tr>                
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    
             <section class="row text-center placeholders">
            <div class="col-6 col-sm-3 placeholder">
                <a href="limparCarrinho"><button type="button" class="btn btn-warning">Limpar Carrinho</button></a>
            </div>
            <div class="col-6 col-sm-3 placeholder">
              <a href="finalizarCompra"><button type="button" class="btn btn-success">Finalizar Compra</button></a>
            </div>
            <div class="col-6 col-sm-3 placeholder">
              <a href="./"><button type="button" class="btn btn-info">Voltar a loja</button></a>
            </div>
          </section>
                </main>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script type="text/javascript">
    function addCart(id) {
        $.post(
            "addCart", {'produto': id, 'quantidade': 1},
            function () {
                $('#qtd_' + id).text(
                    (+($('#qtd_' + id).text()) + 1)
                );
            }
        );
    }
    function removeCart(id) {
        $.post(
            "addCart", {'produto': id, 'quantidade': -1},
            function () {
                if (+($('#qtd_' + id).text()) != 0){
                    $('#qtd_' + id).text(
                        (+($('#qtd_' + id).text()) - 1)
                    );
                } else {
                    alert("Quantidade minima atingida!");
                }
                
            }
        );
    }
</script>
    <!--<script>window.jQuery || document.write('<script src="${js_jquery}"><\/script>')</script>-->

        <script src="${js_jquery}"></script>
        <script src="${js_popper}"></script>
        <script src="${js_bootstrap}"></script>
        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <script src="../../../../assets/js/ie10-viewport-bug-workaround.js"></script>
    </body>
</html>
