package Controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Dao.Conexao;
import Dao.FuncionarioDao;
import Tela.jFrameCadastrarFuncionario;

public class FuncionarioController {
	public void CadastroFuncionario(jFrameCadastrarFuncionario telaView) throws SQLException {
		Connection conexao = new Conexao().getConnection();	
		FuncionarioDao cadastro = new FuncionarioDao();
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			date = sdf.parse(telaView.getTextFieldDataCadastro().getText());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		cadastro.cadastrarFuncionario(telaView.getTextFieldNome().getText(), telaView.getTextFieldIdade().getText(), date);
	}
}
