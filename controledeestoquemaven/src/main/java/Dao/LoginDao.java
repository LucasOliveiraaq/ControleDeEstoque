package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import Tela.jFrameMenuInicial;

public class LoginDao {

	public void cadastrarUsuario(String nome, String email, String senha) throws SQLException {
		Connection conexao = new Conexao().getConnection();
		/*
		 * PreparedStatement assume a responsabilidade de montar a query.
		 * 
		 * PreparedStatement takes responsibility for assembling a query.
		 */
//		String sql = "insert into login(nome, email, senha) values ('"+nome+"', '"+email+"', md5('"+senha+"'))";
		String sql = "insert into login(nome, email, senha) values ('"+nome+"', '"+email+"', '"+senha+"')";
		PreparedStatement statment = conexao.prepareStatement(sql);
		statment.execute();
		conexao.close();
	}
	
	public void login(String email, String senha) throws SQLException {
		Connection conexao = new Conexao().getConnection();
		String sql = "Select email, senha from login where email = '"+ email + "' and senha = '"+ senha +"'";
		System.out.println(sql);
		PreparedStatement statment = conexao.prepareStatement(sql);
		ResultSet rs =  statment.executeQuery();
		if(rs.next()) {
				String msg = "Seja Bem vindo!";
				JOptionPane optionPane = new JOptionPane();
				optionPane.setMessage(msg);
				optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
				JDialog dialog = optionPane.createDialog(null, "Login");
				dialog.setVisible(true);
		} else {
			String msg = "Usuario não possui cadastro";
			 JOptionPane optionPane = new JOptionPane();
		      optionPane.setMessage(msg);
		      optionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
		      JDialog dialog = optionPane.createDialog(null, "Login");
		      dialog.setVisible(true);
		}
		conexao.close();
	}
}
