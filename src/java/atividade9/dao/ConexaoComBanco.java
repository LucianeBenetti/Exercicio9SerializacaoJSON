/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade9.dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author 80119050
 */
public class ConexaoComBanco {
    
    private static final String DRIVER_MYSQL = "com.mysql.jdbc.Driver";
    private static final String NOME_ESQUEMA = "estoque";
    private static final String URL_CONEXAO = "jdbc:mysql://localhost:3306/" + NOME_ESQUEMA;
    private static final String USUARIO = "root";
    private static final String SENHA = "";
    
	public static Connection getConnection() {   
            
        	try {
			Connection conn = null;
			Class.forName(DRIVER_MYSQL);
			conn = DriverManager.getConnection(URL_CONEXAO, USUARIO, SENHA);

			return conn;

		} catch (ClassNotFoundException e) {

			System.out.println("Classe do Driver não foi encontrada. \n" + e.getMessage());

			return null;

                }catch (SQLException e) {

			System.out.println("Erro ao obter a Connection.\n" + e.getMessage());

			return null;

		}
	}

	/**
	 * Fecha uma conexão informada pelo chamador.
	 * 
	 * @param conn o objeto do tipo Connection que deve ser fechado
	 */

	public static void closeConnection(Connection conn) {

		try {

			if (conn != null) {

				conn.close();

			}

		} catch (SQLException e) {

			System.out.println("Problema no fechamento da conexão.");

		}
	}

	/**
	 * 
	 * Solicita um objeto Statement para uma conexão. Este objeto serve para
	 * executar as operações SQL.
	 * 
	 * Este método deve ser sempre chamado nos DAOs após a criação da expressão
	 * SQL, geralmente com os métodos execute(sql), executeUpdate(sql) ou
	 * executeQuery(sql), onde "sql" é do tipo String.
	 * 
	 * @param conn uma conexão anteriormente criada.
	 * @return stmt um objeto do tipo Statement
	 * 
	 * @throws SQLException
	 * 
	 */

	public static Statement getStatement(Connection conn) {

		try {

			Statement stmt = (Statement) conn.createStatement();

			return stmt;

		} catch (SQLException e) {

			System.out.println("Erro ao obter o Statement.");

			return null;

		}
	}

	/**
	 * 
	 * Fecha um objeto Statement anteriormente criado.
	 * 
	 * Este método deve ser sempre chamado nos DAOs após a execução da expressão
	 * SQL.
	 * 
	 * @param stmt um objeto do tipo Statement
	 * 
	 * @throws SQLException
	 * 
	 */

	public static void closeStatement(Connection conn) {

		try {

			if (conn != null) {

				conn.close();

			}

		} catch (SQLException e) {

			System.out.println("Problema no fechamento do Statement.");

		}

	}

	/**
	 * 
	 * Solicita um objeto PreparedStatement para uma conexão. Este objeto serve
	 * para executar as operações SQL.
	 * 
	 * @param conn uma conexão anteriormente criada.
	 * @return stmt um objeto do tipo PreparedStatement
	 * 
	 * @throws SQLException
	 * 
	 */

	public static PreparedStatement getPreparedStatement(Connection conn, String sql) {

		try {

			PreparedStatement stmt = conn.prepareStatement(sql);

			return stmt;

		} catch (Exception e) {

			System.out.println("Erro ao obter o PreparedStatement.");

			return null;

		}
	}

	public static PreparedStatement getPreparedStatement(Connection conn, String sql, int tipoRetorno) {

		try {

			PreparedStatement stmt = conn.prepareStatement(sql, tipoRetorno);

			return stmt;

		} catch (Exception e) {

			System.out.println("Erro ao obter o PreparedStatement.");

			return null;

		}
	}

	/**
	 * 
	 * Fecha um objeto PreparedStatement anteriormente criado.
	 * 
	 * Este método deve ser sempre chamado nos DAOs após a execução da expressão
	 * SQL.
	 * 
	 * @param stmt um objeto do tipo PreparedStatement
	 * 
	 * @throws SQLException
	 * 
	 */

	public static void closePreparedStatement(PreparedStatement stmt) {

		try {

			if (stmt != null) {

				stmt.close();

			}

		} catch (SQLException e) {

			System.out.println("Problema no fechamento do PreparedStatement.");

		}
	}

	/**
	 * 
	 * Fecha um objeto ResultSet anteriormente criado.
	 * 
	 * Este método deve ser sempre chamado nos DAOs após a consulta de todos os
	 * resultados e conversão para objetos.
	 * 
	 * @param result um objeto do tipo ResultSet
	 * 
	 * @throws SQLException
	 * 
	 */

	public static void closeResultSet(ResultSet result) {

		try {

			if (result != null) {

				result.close();

			}

		} catch (SQLException e) {

			System.out.println("Problema no fechamento do ResultSet");

		}
	}
    
}
