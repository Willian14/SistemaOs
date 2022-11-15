/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.wbs.DAO;

import br.com.wbs.connection.ConnectionFactory;
import br.com.wbs.entity.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Willian
 */
public class UsuarioDAO {

    private PreparedStatement p = null;
    private ResultSet rs = null;
    private Connection con = null;
    private List<Usuario> lista = null;

    public UsuarioDAO() {
        con = ConnectionFactory.getConnection();
    }

    public void cadastrar(Usuario usu) {
        String sql = "insert into tbusuarios(nome,telefone,login,senha,tipo) values(?,?,?,?,?);";

        try {
            p = con.prepareStatement(sql);
            p.setString(1, usu.getNome());
            p.setString(2, usu.getTelefone());
            p.setString(3, usu.getLogin());
            p.setString(4, usu.getSenha());
            p.setString(5, usu.getTipo());

            p.execute();
            p.close();
            JOptionPane.showMessageDialog(null, "Usuário Cadastrado com sucesso!", "Sucesso!", 1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuário! \n" + ex, "Atenção!!!", 0);
        }
    }

    public Boolean verificaSeExisteNoBanco(String login, String senha) {
        String sql = "select * from tbusuarios where login=? and senha = ?;";
        try {
            p = con.prepareStatement(sql);
            p.setString(1, login);
            p.setString(2, senha);
            rs = p.executeQuery();

            if (rs.next()) {
                {
                    Usuario usu = new Usuario();
                    usu.setLogin(rs.getString("login"));
                    usu.setSenha(rs.getString("senha"));
                   
                    if (usu.getLogin().equals(login) && usu.getSenha().equals(senha)) {
                        System.out.println("Ok!!!!!!!!!!!!!!!");
                        return true;
                    }
                }

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Atenção!", 1);
        }
        return false;
    }
}
