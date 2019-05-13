/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade9.dao;

import atividade9.entidade.Estoque;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author 80119050
 */
public class EstoqueDao {

    public ArrayList<Estoque> listarEstoque() {
        
        String query = "select * from itens";

        Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, query);

        ArrayList<Estoque> listaDeItens = new ArrayList<Estoque>();

        try {
            ResultSet resultado = prepStmt.executeQuery(query);

            while (resultado.next()) {

                Estoque estoque = new Estoque();
                estoque.setCodigoDoEstoque(resultado.getInt(1));
                estoque.setNome(resultado.getString("nome"));
                estoque.setDescricao(resultado.getString("descricao"));
                estoque.setValor(resultado.getDouble("valor"));
                estoque.setDescricao(resultado.getString("email"));
                

                listaDeItens.add(estoque);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaDeItens;
        
        
    }
    
    
    
}
