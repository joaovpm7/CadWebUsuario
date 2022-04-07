/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Cliente;
import modelo.Usuario;

/**
 *
 * @author sala305b
 */
@WebServlet(name = "ClienteServlet", urlPatterns = {"/ClienteServlet"})
public class ClienteServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("acao") != null) {
            if (request.getParameter("acao").equals("cadastrar")) {
                String idusuario = request.getParameter("idusuario");
                String nome = request.getParameter("nome");
                String tipoDocumento = request.getParameter("tipodocumento");
                String documento = request.getParameter("documento");
                Date dataNascimento = Date.valueOf(request.getParameter("datanascimento"));
                String email = request.getParameter("email");
                String dddtelefone = request.getParameter("dddtelefone");
                String escolaridade = request.getParameter("escolaridade");
                String cep = request.getParameter("cep");
                String sexo = request.getParameter("sexo");
                String logradouro = request.getParameter("logradouro");
                String numero = request.getParameter("numero");
                String complemento = request.getParameter("complemento");
                String bairro = request.getParameter("bairro");
                String cidade = request.getParameter("cidade");
                String uf = request.getParameter("uf");
                Cliente cli = new Cliente();
                cli.setNome(nome);
                cli.setTipoDocumento(tipoDocumento);
                cli.setDocumento(documento);
                cli.setDataNascimento(dataNascimento);
                cli.setEmail(email);
                cli.setEscolaridade(escolaridade);
                cli.setCep(cep);
                cli.setSexo(sexo);
                cli.setLogradouro(logradouro);
                cli.setNumero(numero);
                cli.setComplemento(complemento);
                cli.setBairro(bairro);
                cli.setCidade(cidade);
                cli.setUf(uf);
                Usuario us = new Usuario();
                us.setId(Long.parseLong(idusuario));
                cli.setUser(us);
                String dddTelLimpo = dddtelefone.replace(" ", " ")
                        .replace("-", "")
                        .replace("(", "")
                        .replace(")", "");
                String ddd = dddTelLimpo.substring(0, 2);
                String telefone = dddTelLimpo.length() == 10
                        ? dddTelLimpo.substring(2, 6)
                        + "-" + dddTelLimpo.substring(6)
                        : dddTelLimpo.substring(2, 7)
                        + "-" + dddTelLimpo.substring(7);
                cli.setDdd(ddd);
                cli.setTelefone(telefone);
                boolean cadastrou = cli.Cadastrar();
                //cadastrou == true
                if (cadastrou) {
                    request.setAttribute("idusuario",
                            cli.getUser().getId());
                    request.getRequestDispatcher("tela/listar.jsp")
                            .forward(request, response);
                } else {
                    request.setAttribute("idusuario", cli.getUser());
                    request.getRequestDispatcher("tela/cadastrar.jsp")
                            .forward(request, response);
                }
            } else if (request.getParameter("acao").equals("editar")) {
                //String idusuario = request.getParameter("idusuario");
                String nome = request.getParameter("nome");
                String documento = request.getParameter("documento");
                Date dtNascimento = Date.valueOf(request.getParameter("dtnascimento"));
                String email = request.getParameter("email");
                String ddd = request.getParameter("ddd");
                String telefone = request.getParameter("telefone");
                Cliente cli = new Cliente();
                //cli.setId(Long.parseLong(idusuario));
                cli.setNome(nome);
                cli.getUser().getResponsavel();
                cli.setDataNascimento(dtNascimento);
                cli.setDocumento(documento);
                cli.setDdd(ddd);
                cli.setTelefone(telefone);
                cli.setEmail(email);
                boolean atualizou = cli.Atualizar();
                if (atualizou) {
                    //Somente redireciona a página escolhida
                    response.sendRedirect("tela/listar.jsp");
                } else {
                    String mensagem
                            = "<h1>Edição não Efetuado com Sucesso</h1>";
                    response.getWriter().print(mensagem);
                }
            } else if (request.getParameter("acao").equals("deletar")) {
                int client = Integer.parseInt(request.getParameter("icliente"));
                Cliente.Excluir(client);
                String mensagem
                        = "<h1>Produto Apagado com Sucesso</h1>";
                response.getWriter().print(mensagem);
            }
        }
    }
// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
