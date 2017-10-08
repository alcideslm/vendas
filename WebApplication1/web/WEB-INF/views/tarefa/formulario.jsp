<%-- 
    Document   : formulario
    Created on : 01/10/2017, 21:51:54
    Author     : Alcides Lemos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<body>
  <h3>Adicionar tarefas</h3>
  <form action="adicionaTarefa" method="post">
    Descrição:
            <br/>
    <textarea rows="5" cols="100" name="descricao"></textarea> 
            <br/>     
    <form:errors path="tarefa.descricao" cssStyle="color:red"/>
            <br/>
    <input type="submit" value="Adicionar"/>
  </form>
</body>
</html>
