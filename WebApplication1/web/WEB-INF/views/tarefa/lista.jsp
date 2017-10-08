<%-- 
    Document   : lista
    Created on : 01/10/2017, 22:35:13
    Author     : Alcides Lemos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<body>
  
  <a href="novaTarefa">Criar nova tarefa</a> 

  <br /> <br />        

  <table>
  <tr>
    <th>Id</th>
    <th>Descrição</th>
    <th>Finalizado?</th>
    <th>Data de finalização</th>
    <th>Alterar</th>
    <th>Remover</th>
  </tr>
  <c:forEach items="${tarefas}" var="tarefa">
    <tr>
      <td>${tarefa.idTarefa}</td>
      <td>${tarefa.descricao}</td>
      <c:if test="${tarefa.finalizado eq false}">
        <td>Não finalizado</td>
      </c:if>
      <c:if test="${tarefa.finalizado eq true}">
        <td>Finalizado</td>
      </c:if>
      <td>${tarefa.dataFinalizacao}</td>
      <td><a href="mostraTarefa?id=${tarefa.idTarefa}">Alterar</a></td>
      <td><a href="removeTarefa?id=${tarefa.idTarefa}">Remover</a></td>
    </tr>
  </c:forEach>
  </table>
</body>
</html>