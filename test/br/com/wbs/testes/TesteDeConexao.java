/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.wbs.testes;

import br.com.wbs.connection.ConnectionFactory;
import java.sql.Connection;



/**
 *
 * @author Willian
 */
public class TesteDeConexao {
    public static void main(String[] args) {
         Connection con = ConnectionFactory.getConnection();
       if(con != null){
           System.out.println("Conexão Realizada com sucesso!");  
       }else{
           System.out.println("Erro na conexão com o banco de dados");
       }
    }
}
