<%-- 
    Document   : autenticar
    Created on : 23/09/2017, 11:50:36
    Author     : Máquina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%
    String usuario = request.getParameter("usuario");
    String senha = request.getParameter("senha");

        if (usuario.equals("admin") && senha.equals("123")) {
            response.sendRedirect("adminstrador.jsp");
        } else if (usuario.equals("aluno") && senha.equals("456")) {
            response.sendRedirect("aluno.jsp");
        } else if (usuario.equals("professor") && senha.equals("789")) {
            response.sendRedirect("professor.jsp");
        } else response.sendRedirect("index.jsp");

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1></h1>
    </body>
</html>
