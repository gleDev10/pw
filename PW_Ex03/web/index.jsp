<%-- 
    Document   : index
    Created on : 23/09/2017, 11:09:32
    Author     : Máquina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="autenticar.jsp" method="post">
            Usuário:
            <input name="usuario" type="text"/><br/>
            Senha: 
            <input name="senha" type="password"/>
            <input name="btnEntrar" value="Entrar" type="submit"/>
            
        </form>
    </body>
</html>
