<%-- 
    Document   : listar
    Created on : 28/03/2022, 09:04:12
    Author     : sala305b
--%>

<%@page import="java.util.List"%>
<%@page import="modelo.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String idusuario = String.valueOf(
                    request.getAttribute("idusuario"));
            List<Cliente> clientes = new Cliente().ListarTodos();
        %>
        <table border="1" cellspacing="0" cellpadding="5">
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Responsavel</th>
                <th>Data Nascimento</th>
                <th>Documento</th>
                <th>DDD/Telefone</th>
                <th>Email</th>
                <th>Data Cadastro</th>
                <th>Opções</th>

            </tr>
            <%
                for (Cliente c : clientes) {%>
            <tr>
                <td><%= c.getId()%></td>
                <td><%= c.getNome()%></td>
                <td><%= c.getUser().getResponsavel()%></td>
                <td><%= c.getDataNascimento()%></td>
                <td><%= c.getDocumento()%></td>
                <td><%= c.getDdd() + c.getTelefone()%></td>
                <td><%= c.getEmail()%></td>
                <td><%= c.getDataCadastro()%></td>
                <td width="15%">
                    <div style='display:inline-block'>
                            <form action="tela/cadastro.jsp" method="POST">
                                <input type="hidden" name="acao" value="editar">
                                <input type="hidden" name="idcliente" value="<%= c.getId()%>">
                                <button type="submit">Editar</button>
                            </form> 
                        </div>
                        <div style='display:inline-block'>
                            <form action="ClienteServlet" method="POST">
                                <input type="hidden" name="acao" value="deletar">
                                <input type="hidden" name="idcliente" value="<%= c.getId()%>">
                                <button type="submit">Deletar</button>
                            </form> 
                        </div>
                    </div>
                </td> 
            </tr>
            <% }
            %>
        </table>>
    </body>
</html>
