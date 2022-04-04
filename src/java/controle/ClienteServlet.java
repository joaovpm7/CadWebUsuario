/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Cliente;

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

        if (request.getParameter("acao").equals("cadastrar")) {
            String nome = request.getParameter("nome");
            String tipoDocumento = request.getParameter("tipodocumento");
            String documento = request.getParameter("documento");
            String sexo = request.getParameter("sexo");
            Date dataNascimento = Date.valueOf(request.getParameter("datanascimento"));
            String email = request.getParameter("email");
            String ddd = request.getParameter("ddd");
            String telefone = request.getParameter("telefone");
            String escolaridade = request.getParameter("escolaridade");
            String cep = request.getParameter("cep");
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
            cli.setSexo(sexo);
            cli.setDataNascimento(dataNascimento);
            cli.setEmail(email);
            cli.setDdd(ddd);
            cli.setTelefone(telefone);
            cli.setEscolaridade(escolaridade);
            cli.setEmail(email);
            cli.setCep(cep);
            cli.setLogradouro(logradouro);
            cli.setNumero(numero);
            cli.setComplemento(complemento);
            cli.setBairro(bairro);
            cli.setCidade(cidade);
            cli.setUf(uf);
            long novoid = cli.Cadastrar();
            if (novoid > 0) {
                response.sendRedirect("listar.jsp");
            } else {
                String mensagem = "<h1>Cadastro não Efetuado com Sucesso</h1>";
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
