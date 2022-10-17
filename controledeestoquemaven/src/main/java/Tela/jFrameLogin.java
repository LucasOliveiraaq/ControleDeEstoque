package Tela;

import java.awt.Color;
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

import Controller.LoginController;
import LimitaCaracteres.LimitaCaracteres;

public class jFrameLogin extends JFrame {

	private JPanel contentPane;
	private JLabel lblTelaDeLogin;
	private JLabel lblLogin;
	private JFormattedTextField textFieldLogin;
	private JLabel lblSenha;
	private JFormattedTextField textFieldSenha;
	private JButton buttonLogin;
	private JPanel panel;
	private JPanel panel_1;

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
		contentPane.setBackground(new Color(139, 0, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getlblTelaDeLogin());
		contentPane.add(getLblLogin());
		contentPane.add(getTextFieldLogin());
		contentPane.add(getLblSenha());
		contentPane.add(getTextFieldSenha());
		contentPane.add(getButtonLogin());
		contentPane.add(getPanel());
		contentPane.add(getPanel_1());
	}
	
	public JLabel getlblTelaDeLogin() {
		if(lblTelaDeLogin == null) {
			lblTelaDeLogin = new JLabel();
			lblTelaDeLogin.setBounds(79, 0, 262, 30);
			lblTelaDeLogin.setForeground(new Color(255, 255, 255));
			lblTelaDeLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblTelaDeLogin.setHorizontalAlignment(SwingConstants.CENTER);
			lblTelaDeLogin.setText("Tela de Login");
		}
		return lblTelaDeLogin;
	}
	
	public JLabel getLblLogin() {
		if(lblLogin == null) {
			lblLogin = new JLabel();			
			lblLogin.setBounds(94, 41, 100, 20);
			lblLogin.setForeground(new Color(255, 255, 255));
			lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblLogin.setText("Login: ");
		}
		return lblLogin;
	}
	
	public JFormattedTextField getTextFieldLogin() {
		if(textFieldLogin == null) {
			textFieldLogin = new JFormattedTextField();
			textFieldLogin.setBounds(94, 63, 214, 22);
			textFieldLogin.setDocument(new LimitaCaracteres(50, LimitaCaracteres.TipoEntrada.email));
		}
		return textFieldLogin;
	}
	
	public JLabel getLblSenha() {
		if(lblSenha == null) {
			lblSenha = new JLabel();			
			lblSenha.setBounds(94, 100, 100, 20);
			lblSenha.setForeground(new Color(255, 255, 255));
			lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblSenha.setText("Senha: ");
		}
		return lblSenha;
	}
	
	public JFormattedTextField getTextFieldSenha() {
		if(textFieldSenha == null) {
			textFieldSenha = new JFormattedTextField();
			textFieldSenha.setBounds(94, 125, 214, 22);
			textFieldSenha.setDocument(new LimitaCaracteres(50, LimitaCaracteres.TipoEntrada.senha));
		}
		return textFieldSenha;
	}
	
	public JButton getButtonLogin() {
		if(buttonLogin == null) {
			buttonLogin = new JButton();
			buttonLogin.setBounds(94, 160, 214, 22);
			buttonLogin.addActionListener(e -> validacao());
			buttonLogin.setText("Login");
		}
		return buttonLogin;
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
	
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(new Color(128, 0, 128));
			panel.setBounds(0, 0, 10, 261);
		}
		return panel;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBackground(new Color(128, 0, 128));
			panel_1.setBounds(0, 251, 434, 10);
		}
		return panel_1;
	}
	public void loginBanco() {
		try {
			LoginController login = new LoginController();
			login.LoginUsuario(this);
			jFrameMenuInicial menuInicial = new jFrameMenuInicial();
			menuInicial.setVisible(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
