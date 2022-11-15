/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.wbs.testes;

import br.com.wbs.DAO.UsuarioDAO;
import br.com.wbs.entity.Usuario;

/**
 *
 * @author Willian
 */
public class TestesUsuDao {
    public static void main(String[] args){
        testeCad();
    }
    
    public static void testeCad(){
        Usuario usu = new Usuario();
        usu.setNome("Elaine");
        usu.setTelefone("(67)99612-5604");
        usu.setLogin("elaine");
        usu.setSenha("admin");
        usu.setTipo("Administrador");
        UsuarioDAO usuDao = new UsuarioDAO();
        usuDao.cadastrar(usu);
    }
}
