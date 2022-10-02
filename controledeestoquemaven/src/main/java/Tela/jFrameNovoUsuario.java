package Tela;

import java.awt.EventQueue;
import java.awt.Font;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Controller.LoginController;
import LimitaCaracter.LimitaCaracteres;
import Model.Login;

public class jFrameNovoUsuario extends JFrame {
	private JPanel contentPane;
	private JLabel lblCadastroNovoUsuario;
	private JLabel lblNome;
	private JFormattedTextField textFieldNome;
	private JLabel lblEmail;
	private JFormattedTextField textFieldEmail;
	private JLabel lblSenha;
	private JPasswordField passwordField;
	private JButton buttonCadastrar;
	private Login login;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jFrameNovoUsuario frame = new jFrameNovoUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public jFrameNovoUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getlblCadastroNovoUsuario());
		contentPane.add(getLblNome());
		contentPane.add(getTextFieldNome());
		contentPane.add(getLblEmail());
		contentPane.add(getTextFieldEmail());
		contentPane.add(getLblSenha());
		contentPane.add(getPasswordField());
		contentPane.add(getButtonCadastrar());
	}

	public JLabel getlblCadastroNovoUsuario() {
		if(lblCadastroNovoUsuario == null) {
			 lblCadastroNovoUsuario = new JLabel();
			 lblCadastroNovoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
			 lblCadastroNovoUsuario.setHorizontalAlignment(SwingConstants.CENTER);
			 lblCadastroNovoUsuario.setLocation(84, 0);
			 lblCadastroNovoUsuario.setSize(262, 30);
			lblCadastroNovoUsuario.setText("Cadastro novo Usuario");
		}
		return lblCadastroNovoUsuario;
	}
	
	public JLabel getLblNome() {
		if(lblNome == null) {
			lblNome = new JLabel();			
			lblNome.setLocation(94, 41);
			lblNome.setSize(100, 20);
			lblNome.setText("Nome: ");
		}
		return lblNome;
	}
	
	public JFormattedTextField getTextFieldNome() {
		if(textFieldNome == null) {
			textFieldNome = new JFormattedTextField();
			textFieldNome.setLocation(94, 63);
			textFieldNome.setSize(214, 22);
			textFieldNome.setDocument(new LimitaCaracteres(50, LimitaCaracteres.TipoEntrada.nome));
		}
		return textFieldNome;
	}
	
	public JLabel getLblEmail() {
		if(lblEmail == null) {
			lblEmail = new JLabel();			
			lblEmail.setLocation(94, 90);
			lblEmail.setSize(100, 20);
			lblEmail.setText("Email: ");
		}
		return lblEmail;
	}
	
	public JFormattedTextField getTextFieldEmail() {
		if(textFieldEmail == null) {
			textFieldEmail = new JFormattedTextField();
			textFieldEmail.setLocation(94, 110);
			textFieldEmail.setSize(214, 22);
			textFieldEmail.setDocument(new LimitaCaracteres(50, LimitaCaracteres.TipoEntrada.email));
		}
		return textFieldEmail;
	}
	
	public JLabel getLblSenha() {
		if(lblSenha == null) {
			lblSenha = new JLabel();			
			lblSenha.setLocation(94, 135);
			lblSenha.setSize(100, 20);
			lblSenha.setText("Senha: ");
		}
		return lblSenha;
	}
	
	public JPasswordField getPasswordField() {
		if(passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBounds(94, 159, 214, 22);
			passwordField.setDocument(new LimitaCaracteres(50, LimitaCaracteres.TipoEntrada.senha));
		}
		return passwordField;
	}
	
	public JButton getButtonCadastrar() {
		if(buttonCadastrar == null) {
			buttonCadastrar = new JButton();
			buttonCadastrar.addActionListener(e -> cadastroBanco());
			buttonCadastrar.setText("Cadastrar");
			buttonCadastrar.setBounds(94, 190, 214, 22);
		}
		return buttonCadastrar;

	}
	
	public void cadastroBanco() {
		try {
			LoginController cadastro = new LoginController();
			cadastro.CadastroUsuario(this);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
