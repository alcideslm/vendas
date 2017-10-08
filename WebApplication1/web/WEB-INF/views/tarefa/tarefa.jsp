<%-- 
    Document   : show
    Created on : 01/10/2017, 22:48:45
    Author     : Alcides Lemos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<body>
  <h3>Alterar tarefa - ${tarefa.idTarefa}</h3>
  <form action="alteraTarefa" method="post">

    <input type="hidden" name="idTarefa" value="${tarefa.idTarefa}" />
  
    Descrição:<br />
    <textarea name="descricao" cols="100" rows="5"> ${tarefa.descricao} </textarea>
    <br />      

    Finalizado? <input type="checkbox" name="finalizado" 
      value="true" ${tarefa.finalizado? 'checked' : '' }/> <br />      

    Data de finalização: <br />
    <input type="text" name="dataFinalizacao" value="${tarefa.dataFinalizacao}">
    <br />
  
    <input type="submit" value="Alterar"/>
  </form>
</body>
</html>
