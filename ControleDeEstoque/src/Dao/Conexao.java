package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	public Connection getConnection() throws SQLException {
		/*
		 * Driver Manager responsavel para se comunicar com os drivers
		 * do banco de dados .
		 * 
		 * Driver Manager responsible for communicating with drivers
		 * database.
		 */
		Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/produto", "postgres", "postgre");
		return conexao;
	}
}
