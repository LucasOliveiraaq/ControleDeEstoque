package Controller;

import java.sql.Connection;
import java.sql.SQLException;

import Dao.Conexao;
import Dao.LoginDao;
import Tela.jFrameNovoUsuario;

public class LoginController {

	public void CadastroUsuario(jFrameNovoUsuario telaView) throws SQLException {
		Connection conexao = new Conexao().getConnection();
		LoginDao cadastro = new LoginDao();
		cadastro.cadastrarUsuario(telaView.getTextFieldNome().getText(), telaView.getTextFieldEmail().getText(), telaView.getPasswordField().getText());
	}
	
}
