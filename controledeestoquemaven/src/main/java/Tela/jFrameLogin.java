package Tela;

import java.awt.EventQueue;
import java.awt.Font;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.postgresql.translation.messages_bg;
import org.postgresql.util.ServerErrorMessage;

import Controller.LoginController;
import LimitaCaracter.LimitaCaracteres;

public class jFrameLogin extends JFrame {

	private JPanel contentPane;
	private JLabel lblTelaDeLogin;
	private JLabel lblLogin;
	private JFormattedTextField textFieldLogin;
	private JLabel lblSenha;
	private JFormattedTextField textFieldSenha;
	private JButton buttonLogin;
	private JButton buttonNovoUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jFrameLogin frame = new jFrameLogin();
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
	public jFrameLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getlblTelaDeLogin());
		contentPane.add(getLblLogin());
		contentPane.add(getTextFieldLogin());
		contentPane.add(getLblSenha());
		contentPane.add(getTextFieldSenha());
		contentPane.add(getButtonLogin());
		contentPane.add(getButtonNovoUsuario());
	}
	
	public JLabel getlblTelaDeLogin() {
		if(lblTelaDeLogin == null) {
			lblTelaDeLogin = new JLabel();
			lblTelaDeLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblTelaDeLogin.setHorizontalAlignment(SwingConstants.CENTER);
			lblTelaDeLogin.setLocation(84, 0);
			lblTelaDeLogin.setSize(262, 30);
			lblTelaDeLogin.setText("Tela de Login");
		}
		return lblTelaDeLogin;
	}
	
	public JLabel getLblLogin() {
		if(lblLogin == null) {
			lblLogin = new JLabel();			
			lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblLogin.setLocation(94, 41);
			lblLogin.setSize(100, 20);
			lblLogin.setText("Login: ");
		}
		return lblLogin;
	}
	
	public JFormattedTextField getTextFieldLogin() {
		if(textFieldLogin == null) {
			textFieldLogin = new JFormattedTextField();
			textFieldLogin.setLocation(94, 63);
			textFieldLogin.setSize(214, 22);
			textFieldLogin.setDocument(new LimitaCaracteres(50, LimitaCaracteres.TipoEntrada.email));
		}
		return textFieldLogin;
	}
	
	public JLabel getLblSenha() {
		if(lblSenha == null) {
			lblSenha = new JLabel();			
			lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblSenha.setLocation(94, 100);
			lblSenha.setSize(100, 20);
			lblSenha.setText("Senha: ");
		}
		return lblSenha;
	}
	
	public JFormattedTextField getTextFieldSenha() {
		if(textFieldSenha == null) {
			textFieldSenha = new JFormattedTextField();
			textFieldSenha.setLocation(94, 125);
			textFieldSenha.setSize(214, 22);
			textFieldSenha.setDocument(new LimitaCaracteres(50, LimitaCaracteres.TipoEntrada.senha));
		}
		return textFieldSenha;
	}
	
	public JButton getButtonLogin() {
		if(buttonLogin == null) {
			buttonLogin = new JButton();
			buttonLogin.addActionListener(e -> validacao());
			buttonLogin.setText("Login");
			buttonLogin.setBounds(94, 160, 100, 22);
		}
		return buttonLogin;
	}
	
	public JButton getButtonNovoUsuario() {
		if(buttonNovoUsuario == null) {
			buttonNovoUsuario = new JButton();
			buttonNovoUsuario.addActionListener(e -> novoUsuario());
			buttonNovoUsuario.setText("Novo Usuario");
			buttonNovoUsuario.setBounds(208, 160, 100, 22);
		}
		return buttonNovoUsuario;
	}

	public void novoUsuario() {
		jFrameNovoUsuario novoUsuario = new jFrameNovoUsuario();
		novoUsuario.setVisible(true);
	}
	
	public void validacao() {
		if(textFieldLogin.getText().isEmpty()) {
			 JOptionPane.showMessageDialog(null, "Por favor, informe o seu email.");
		} else if(textFieldSenha.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Por favor, informe uma senha.");
		}else {
			loginBanco();
		}
	}
	
	public void loginBanco() {
		try {
			LoginController login = new LoginController();
			login.LoginUsuario(this);		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
