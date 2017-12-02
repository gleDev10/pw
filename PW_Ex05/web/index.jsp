<%-- 
    Document   : index
    Created on : 23/09/2017, 20:28:18
    Author     : Máquina
--%>

<%@page import="bo.BOCliente"%>
<%@page import="to.TOCliente"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    String filtro = request.getParameter("filtro");
    
    filtro = filtro == null ? "" : filtro;
    
    List<TOCliente> l = BOCliente.getLista("nome");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>lista de clientes</h1>
        
        <br/>
        
        <form action="index.jsp" method="POST">
            Busca: <input name="filtro" type="text" value="<%=filtro%>"/> <input text="Buscar" type="submit"/>
        </form>
              
        
        <table border="1">
            <tr>
                <td>Id</td>
                <td>Nome</td>
                <td>Sobrenome</td>
                <td>Sexo</td>
                <td>E-mail</td> 
            </tr>
            <%for(TOCliente c : l) { %>
            <tr>
                <td><%=c.getId()%></td>
                <td><%=c.getNome()%></td>
                <td><%=c.getSobrenome()%></td>
                <td><%=c.getSexo()%></td>
                <td><%=c.getEmail()%></td> 
            </tr>
            <% } %>
        </table>
    </body>
</html>
