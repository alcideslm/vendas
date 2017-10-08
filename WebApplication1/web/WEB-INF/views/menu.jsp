<%-- 
    Document   : menu
    Created on : 01/10/2017, 23:06:33
    Author     : Alcides Lemos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <body>
    <h2>Página inicial da Lista de Tarefas</h2>
    <p>Bem vindo, ${usuarioLogado.login}</p> 
    <a href="listaTarefas">Clique aqui</a> para acessar a 
    lista de tarefas
  </body>
</html>
