package Tela;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import Controller.FuncionarioController;
import Controller.LoginController;
import LimitaCaracter.LimitaCaracteres;
import javax.swing.DropMode;
import javax.swing.JButton;

public class jFrameCadastrarFuncionario extends JFrame {

	private JPanel contentPane;
	private JLabel lblCadastrarFuncionario;
	private JLabel lblNome;
	private JFormattedTextField textFieldNome;
	private JLabel lblIdade;
	private JFormattedTextField textFieldIdade;
	private JLabel lblDataCadastro;
	private JFormattedTextField textFieldDataCadastro;
	private JButton buttonCadastro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jFrameCadastrarFuncionario frame = new jFrameCadastrarFuncionario();
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
	public jFrameCadastrarFuncionario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(139, 0, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		contentPane.add(getlblCadastrarFuncionario());
		contentPane.add(getLblNome());
		contentPane.add(getTextFieldNome());
		contentPane.add(getLblIdade());
		contentPane.add(getTextFieldIdade());
		contentPane.add(getTextFieldDataCadastro());
		contentPane.add(getLblDataCadastro());
		contentPane.add(getButtonCadastro());
	}
	
	public JLabel getlblCadastrarFuncionario() {
		if(lblCadastrarFuncionario == null) {
			lblCadastrarFuncionario = new JLabel();
			lblCadastrarFuncionario.setBounds(79, 0, 262, 30);
			lblCadastrarFuncionario.setForeground(new Color(255, 255, 255));
			lblCadastrarFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblCadastrarFuncionario.setHorizontalAlignment(SwingConstants.CENTER);
			lblCadastrarFuncionario.setText("Cadastrar funcionario");
		}
		return lblCadastrarFuncionario;
	}
	
	public JLabel getLblNome() {
		if(lblNome == null) {
			lblNome = new JLabel();			
			lblNome.setForeground(new Color(255, 255, 255));
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
	
	public JLabel getLblIdade() {
		if(lblIdade == null) {
			lblIdade = new JLabel();			
			lblIdade.setForeground(new Color(255, 255, 255));
			lblIdade.setLocation(94, 100);
			lblIdade.setSize(100, 20);
			lblIdade.setText("Idade: ");
		}
		return lblIdade;
	}
	
	public JFormattedTextField getTextFieldIdade() {
		if(textFieldIdade == null) {
			textFieldIdade = new JFormattedTextField();
			textFieldIdade.setLocation(94, 123);
			textFieldIdade.setSize(214, 22);
			textFieldIdade.setDocument(new LimitaCaracteres(3, LimitaCaracteres.TipoEntrada.idade));
		}
		return textFieldIdade;
	}
	
	public JLabel getLblDataCadastro() {
		if(lblDataCadastro == null) {
			lblDataCadastro = new JLabel();			
			lblDataCadastro.setForeground(new Color(255, 255, 255));
			lblDataCadastro.setLocation(94, 155);
			lblDataCadastro.setSize(100, 20);
			lblDataCadastro.setText("Data Cadastro: ");
		}
		return lblDataCadastro;
	}
	
	public JFormattedTextField getTextFieldDataCadastro() {
		if(textFieldDataCadastro == null) {
			textFieldDataCadastro = new JFormattedTextField();
			textFieldDataCadastro.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date(System.currentTimeMillis())));
			textFieldDataCadastro.setLocation(94, 175);
			textFieldDataCadastro.setSize(68, 22);
		}
		return textFieldDataCadastro;
	}
	
	public JButton getButtonCadastro() {
		if(buttonCadastro == null) {
			buttonCadastro = new JButton();
			buttonCadastro.setBounds(94, 205, 214, 22);
			buttonCadastro.addActionListener(e -> validacao());
			buttonCadastro.setText("Cadastro");
		}
		return buttonCadastro;
	}
	
	public void validacao() {
		if(textFieldNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Por favor, informe o nome.");
		} else if(textFieldIdade.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Por favor, informe a idade.");
		} else {
			cadastroBanco();
		}
	}
	
	public void cadastroBanco() {
		try {
			FuncionarioController cadastro = new FuncionarioController();
			cadastro.CadastroFuncionario(this);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
