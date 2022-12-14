package Controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.SQLException;

import Dao.Conexao;
import Dao.LoginDao;
import Tela.jFrameLogin;
import Tela.jFrameNovoUsuario;

public class LoginController {

	public void CadastroUsuario(jFrameNovoUsuario telaView) throws SQLException {
		Connection conexao = new Conexao().getConnection();
		LoginDao cadastro = new LoginDao();
		cadastro.cadastrarUsuario(telaView.getTextFieldNome().getText(), telaView.getTextFieldEmail().getText(), telaView.getPasswordField().getText());
	}
	
	public void LoginUsuario(jFrameLogin telaView) throws SQLException {
		Connection conexao = new Conexao().getConnection();
		LoginDao login = new LoginDao();
		login.login(telaView.getTextFieldLogin().getText(), telaView.getTextFieldSenha().getText());
	}
	
	public static String criptografar(String Senha) {
		String retorn = "";
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			BigInteger hash = new BigInteger(1,md.digest(Senha.getBytes()));
			retorn = hash.toString();
		}catch (Exception e) {
		}
		return retorn;
	}
	
}
