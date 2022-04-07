<%-- 
    Document   : cadastro
    Created on : 30/03/2022, 08:44:50
    Author     : sala305b
--%>

<%@page import="java.sql.Date"%>
<%@page import="modelo.Usuario"%>
<%@page import="modelo.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Usuario user = (Usuario) request.getAttribute("idusuario");
    String acao = "cadastrar", idusuario = "", nome = "", responsavel = "", dtnascimento = "",
            documento = "", ddd = "", email = "", dtcadastro = "", telefone = "", dddtelefone = "";

    Cliente clie = new Cliente();
    if (request.getParameter("acao") != null) {
        if (request.getParameter("acao").equals("editar")) {
            idusuario = request.getParameter("idusuario");
            boolean achou = clie.BuscarPorId(idusuario);
            if (!achou) {
                out.print("<script>"
                        + "window.alert('Cliente não Encontrado');"
                        + "</script>");
            } else {
                acao = "editar";
                idusuario = String.valueOf(clie.getId());
                nome = clie.getNome();
                responsavel = String.valueOf(clie.getUser().getResponsavel());
                dtnascimento = String.valueOf(clie.getDataNascimento());
                documento = clie.getDocumento();
                telefone = clie.getTelefone();
                ddd = clie.getDdd();
                email = clie.getEmail();
                dtcadastro = String.valueOf(clie.getDataCadastro());
            }
        }
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema de Cadastro</title>

        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="css/bootstrap.css" />

    </head>
    <body>
        <form action="ClienteServlet" method="POST">
            <input type="hidden" name="idusuario" value="<%=user.getId()%>">
            <input type="hidden" name="acao" value="<%=acao%>" />
            <table border="0" cellspacing="0" cellpadding="5">
                <tr>
                    <td>
                        <label for="">ID:</label><br/>
                        <input size="5" value=""
                               type="text" name="idcliente" />
                    </td>
                    <td>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="">Nome Completo:</label><br/>
                        <input size="30" 
                               value="<%=nome%>"
                               type="text" name="nome" />
                    </td>
                    <td>
                        <label for="">Data de Nascimento:</label><br/>
                        <input size="30"  value="<%=dtnascimento%>"
                               type="date" name="datanascimento" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="">Documento:</label><br/>
                        <input size="30" id="txtDocumento"  value="<%=documento%>"
                               type="text" name="documento" />
                    </td>
                    <td>
                        <table border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td colspan="3">
                                    <label for="">Tipo Documento:</label>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <input id="rdbCPF"
                                           type="radio" 
                                           name="tipodocumento"
                                           value="CPF"/>
                                    <label for="rdbCPF">CPF</label>
                                </td>
                                <td>
                                    <input id="rdbCNH"
                                           type="radio" 
                                           name="tipodocumento"
                                           value="CNH"/>
                                    <label for="rdbCNH">CNH</label> 
                                </td>
                                <td>
                                    <input id="rdbRG"
                                           type="radio" 
                                           name="tipodocumento"
                                           value="RG"/>
                                    <label for="rdbRG">RG</label>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="sltEscolaridade">Escolaridade:</label>
                        <select id="sltEscolaridade" name="escolaridade">
                            <option 
                                value="EM">Ensino Médio</option>
                            <option 
                                value="ET">Ensino Técnico</option>
                            <option 
                                value="ES">Ensino Superior</option>
                            <option 
                                value="PG">Pós Graduação</option>
                        </select>
                    </td>
                    <td>
                        <table border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td colspan="3">
                                    <label for="">Sexo:</label>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <input id="rdbM"
                                           type="radio" 
                                           name="sexo"
                                           value="M"/>
                                    <label for="rdbM">Masculino</label>
                                </td>
                                <td>
                                    <input id="rdbF"
                                           type="radio" 
                                           name="sexo"
                                           value="F"/>
                                    <label for="rdbF">Feminino</label> 
                                </td>
                                <td>
                                    <input id="rdbO"
                                           type="radio" 
                                           name="sexo"
                                           value="O"/>
                                    <label for="rdbO">Outro</label>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="txtDddTelefone">DDD/Telefone:</label><br/>
                        <input size="30"
                               id="txtDddTelefone"
                               type="text" name="dddtelefone" value="<%=dddtelefone%>" />
                    </td>
                    <td>
                        <label for="">Email:</label><br/>
                        <input size="30"  value="<%=email%>"
                               type="email" name="email" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="txtCEP">CEP:</label><br/>
                        <input id="txtCEP" size="30" type="text" name="cep" value="" />
                    </td>
                    <td>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <table border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td width="90%">
                                    <label for="">Logradouro:</label><br/>
                                    <input size="55"type="text" name="logradouro" value="" />
                                </td>
                                <td width="10%">
                                    <label for="">Numero:</label><br/>
                                    <input size="5" type="text" name="numero" value="" />
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="">Bairro:</label><br/>
                        <input size="30" type="text" name="bairro" value="" />
                    </td>
                    <td>
                        <label for="">Cidade:</label><br/>
                        <input size="30" type="text" name="cidade" value="" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="">UF:</label><br/>
                        <select id="sltEstado" name="uf" value="uf">
                            <option value="">Selecione</option>
                            <option 
                                value="AC">Acre</option>
                            <option 
                                value="AL">Alagoas</option>
                            <option 
                                value="AP">Amapá</option>
                            <option 
                                value="AM">Amazonas</option>
                            <option 
                                value="BA">Bahia</option>
                            <option 
                                value="CE">Ceará</option>
                            <option 
                                value="DF">Distrito Federal</option>
                            <option 
                                value="ES">Espirito Santo</option>
                            <option 
                                value="GO">Goiás</option>
                            <option 
                                value="MA">Maranhão</option>
                            <option 
                                value="MS">Mato Grosso do Sul</option>
                            <option 
                                value="MT">Mato Grosso</option>
                            <option 
                                value="MG">Minas Gerais</option>
                            <option 
                                value="PA">Pará</option>
                            <option 
                                value="PB">Paraíba</option>
                            <option 
                                value="PR">Paraná</option>
                            <option 
                                value="PE">Pernambuco</option>
                            <option 
                                value="PI">Piauí</option>
                            <option 
                                value="RJ">Rio de Janeiro</option>
                            <option 
                                value="RN">Rio Grande do Norte</option>
                            <option 
                                value="RS">Rio Grande do Sul</option>
                            <option 
                                value="RO">Rondônia</option>
                            <option 
                                value="RR">Roraima</option>
                            <option 
                                value="SC">Santa Catarina</option>
                            <option 
                                value="SP">São Paulo</option>
                            <option 
                                value="SE">Sergipe</option>
                            <option 
                                value="TO">Tocantins</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input class="btn btn-primary" type="submit" value="Salvar" />
                    </td>
                </tr>
            </table>
        </form>
        <script type="text/javascript" src="js/bootstrap.js"></script>
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/jquery.mask.js"></script>
        <script type="text/javascript">
            jQuery(document).ready(function ($) {

                $("#txtDocumento").mask("000.000.000-00");
                $("#rdbCNH").on("click", function (e) {
                    $("#txtDocumento").mask("00000000000");
                });
                $("#rdbRG").on("click", function (e) {
                    $("#txtDocumento").mask("0.000.000");
                });
                $("#rdbCPF").on("click", function (e) {
                    $("#txtDocumento").mask("000.000.000-00");
                });
                $("#txtDddTelefone").on("click", function (e) {
                    $("#txtDddTelefone").mask("(00) 0000-0000");
                });
                $("#txtCEP").on("click", function (e) {
                    $("#txtCEP").mask("00000-000");
                });
            });
        </script>
    </body>
</html>
