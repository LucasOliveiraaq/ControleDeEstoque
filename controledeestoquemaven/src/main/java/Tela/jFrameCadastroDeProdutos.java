package Tela;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class jFrameCadastroDeProdutos extends JFrame {

	private JPanel contentPane;
	private JLabel lblCadastroDeProdutos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jFrameCadastroDeProdutos frame = new jFrameCadastroDeProdutos();
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
	public jFrameCadastroDeProdutos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.add(getlblCadastroDeFuncionarios());
	}
	
	public JLabel getlblCadastroDeFuncionarios() {
		if(lblCadastroDeProdutos == null) {
			lblCadastroDeProdutos = new JLabel();
			lblCadastroDeProdutos.setBounds(79, 0, 262, 30);
			lblCadastroDeProdutos.setForeground(new Color(255, 255, 255));
			lblCadastroDeProdutos.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblCadastroDeProdutos.setHorizontalAlignment(SwingConstants.CENTER);
			lblCadastroDeProdutos.setText("Cadastro de produtos");
		}
		return lblCadastroDeProdutos;
	}

}
