/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import util.BancoDados;

/**
 *
 * @author sala305b
 */
public class Usuario {
    
    private long id;
    private String login;
    private String nome;
    private String senha;
    private Timestamp dtCadastro;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Timestamp getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Timestamp dtCadastro) {
        this.dtCadastro = dtCadastro;
    }
    
    
    public static long TemUsuario(String login, String senha) {

        try {
            Connection conn = BancoDados.getConexao();
            String sql = "SELECT * FROM tb_usuario ";
            sql += " WHERE login = ? AND senha = ? ";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, login);
            ps.setString(2, senha);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int cod = rs.getInt("id");

                if (cod > 0) {

                    return cod;
                }

            }
            return 0;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }

    }
    
    
}
