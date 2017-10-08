<%-- 
    Document   : form-login
    Created on : 01/10/2017, 23:00:54
    Author     : Alcides Lemos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <body>
    <h2>Página de Login das Tarefas</h2>
    <form action="efetuaLogin" method="post">
      Login: <input type="text" name="login" /> <br /> 
      Senha: <input type="password" name="senha" /> <br />
      <input type="submit" value="Entrar nas tarefas" /> 
    </form>
  </body>
</html>