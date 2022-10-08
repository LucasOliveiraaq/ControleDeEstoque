package Tela;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import java.awt.Color;

public class jFrameMenuInicial extends JFrame {

	private JPanel contentPane;
	private JMenuBar barra = new JMenuBar();
	private JMenu menu1 = new JMenu("Cadastrar");
	private JMenu menu2 = new JMenu("Sair");
	
	private JMenuItem itemExit = new JMenuItem("Exit");
	private JMenuItem novoUsuario = new JMenuItem("Cadastrar novo usuario");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jFrameMenuInicial frame = new jFrameMenuInicial();
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
	public jFrameMenuInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(139, 0, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		barra.setBackground(new Color(128, 0, 128));
		setJMenuBar(barra);
//		menu1.setIcon(new ImageIcon(jFrameMenuInicial.class.getResource("/Imagem/local-na-rede-internet.png")));
		ImageIcon img = new ImageIcon(jFrameMenuInicial.class.getResource("/Imagem/local-na-rede-internet.png"));
		img.setImage(img.getImage().getScaledInstance(30, 30, 100));
		menu1.setForeground(new Color(255, 255, 255));
		menu1.setIcon(img);
		barra.add(menu1);
		menu2.setForeground(new Color(255, 255, 255));
		barra.add(menu2);
		menu2.add(itemExit);
		itemExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menu1.add(novoUsuario);
		novoUsuario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jFrameNovoUsuario novoUsuario = new jFrameNovoUsuario();
				novoUsuario.setVisible(true);
			}
		});
		

		setContentPane(contentPane);
	}

}
