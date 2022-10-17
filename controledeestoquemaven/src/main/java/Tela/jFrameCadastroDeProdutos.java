package Tela;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.math.RoundingMode;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFormattedTextField.AbstractFormatterFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;

import Controller.ProdutoController;
import Dao.ProdutoDao;
import LimitaCaracteres.LimitaCaracteres;


public class jFrameCadastroDeProdutos extends JFrame {

	private JPanel contentPane;
	private JLabel lblCadastroDeProdutos;
	private JLabel lblCodigoProduto;
	private JFormattedTextField textFieldCodigoProduto;
	private JLabel lblNome;
	private JFormattedTextField textFieldNome;
	private JLabel lblDescricao;
	private JTextArea textAreaDescricao;
	private JLabel lblQuantidade;
	private JFormattedTextField textFieldQuantidade;
	private JLabel lblPreco;
	private JFormattedTextField textFieldPreco;
	private JScrollPane scrollTextArea = new JScrollPane(textAreaDescricao, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	private JButton buttonIncluir;
	private JButton buttonDeletar;
	private JButton buttonAlterar;
	private JComboBox categoria;
	
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
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);contentPane.setLayout(null);
		contentPane.setBackground(new Color(139, 0, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		contentPane.add(getlblCadastroDeProdutos());
		contentPane.add(getLblCodigoProduto());
		contentPane.add(getTextFieldCodigoProduto());
		contentPane.add(getLblNome());
		contentPane.add(getTextFieldNome());
		contentPane.add(getLblDescricao());
		contentPane.add(getTextAreaDescricao());
		contentPane.add(getLblQuantidade());
		contentPane.add(getTextFieldQuantidade());
		contentPane.add(getLblPreco());
		contentPane.add(getTextFieldPreco());
//		contentPane.add(scrollTextArea);
		contentPane.add(getButtonIncluir());
		contentPane.add(getButtonDeletar());
		contentPane.add(getButtonAlterar());
		contentPane.add(getButtonCategoria());
	}
	
	public JLabel getlblCadastroDeProdutos() {
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
	
	public JLabel getLblCodigoProduto() {
		if(lblCodigoProduto == null) {
			lblCodigoProduto = new JLabel();			
			lblCodigoProduto.setHorizontalAlignment(SwingConstants.RIGHT);
			lblCodigoProduto.setForeground(new Color(255, 255, 255));
			lblCodigoProduto.setLocation(39, 41);
			lblCodigoProduto.setSize(100, 20);
			lblCodigoProduto.setText("Codigo Produto: ");
		}
		return lblCodigoProduto;
	}
	
	public JFormattedTextField getTextFieldCodigoProduto() {
		if(textFieldCodigoProduto == null) {
			textFieldCodigoProduto = new JFormattedTextField();
			textFieldCodigoProduto.setLocation(140, 41);
			textFieldCodigoProduto.setSize(109, 22);
			textFieldCodigoProduto.setDocument(new LimitaCaracteres(20, LimitaCaracteres.TipoEntrada.codigo));
		}
		return textFieldCodigoProduto;
	}
	
	public JLabel getLblNome() {
		if(lblNome == null) {
			lblNome = new JLabel();			
			lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNome.setForeground(new Color(255, 255, 255));
			lblNome.setLocation(39, 80);
			lblNome.setSize(100, 20);
			lblNome.setText("Nome: ");
		}
		return lblNome;
	}
	
	public JFormattedTextField getTextFieldNome() {
		if(textFieldNome == null) {
			textFieldNome = new JFormattedTextField();
			textFieldNome.setLocation(140, 80);
			textFieldNome.setSize(214, 22);
			textFieldNome.setDocument(new LimitaCaracteres(20, LimitaCaracteres.TipoEntrada.nome));
		}
		return textFieldNome;
	}
	
	public JLabel getLblDescricao() {
		if(lblDescricao == null) {
			lblDescricao = new JLabel();			
			lblDescricao.setHorizontalAlignment(SwingConstants.RIGHT);
			lblDescricao.setForeground(new Color(255, 255, 255));
			lblDescricao.setLocation(39, 115);
			lblDescricao.setSize(100, 20);
			lblDescricao.setText("Descrição: ");
		}
		return lblDescricao;
	}
	
	public JTextArea getTextAreaDescricao() {
		if(textAreaDescricao == null) {
			textAreaDescricao = new JTextArea();
			textAreaDescricao.setLocation(140, 115);
			textAreaDescricao.setSize(214, 49);
			textAreaDescricao.setLineWrap(true);
			textAreaDescricao.setDocument(new LimitaCaracteres(100, LimitaCaracteres.TipoEntrada.descricao));
		}
		return textAreaDescricao;
	}
	
	public JLabel getLblQuantidade() {
		if(lblQuantidade == null) {
			lblQuantidade = new JLabel();			
			lblQuantidade.setHorizontalAlignment(SwingConstants.RIGHT);
			lblQuantidade.setForeground(new Color(255, 255, 255));
			lblQuantidade.setLocation(39, 175);
			lblQuantidade.setSize(100, 20);
			lblQuantidade.setText("Quantidade: ");
		}
		return lblQuantidade;
	}
	
	public JFormattedTextField getTextFieldQuantidade() {
		if(textFieldQuantidade == null) {
			textFieldQuantidade = new JFormattedTextField();
			textFieldQuantidade.setLocation(140, 175);
			textFieldQuantidade.setSize(109, 22);
			textFieldQuantidade.setFormatterFactory(new AbstractFormatterFactory() {

	            @Override
	            public AbstractFormatter getFormatter(JFormattedTextField tf) {
	                DecimalFormat format = new DecimalFormat();
	                format.setMinimumFractionDigits(2);
	                format.setMaximumFractionDigits(2);
	                format.setRoundingMode(RoundingMode.HALF_UP);

	                DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(getLocale());
	                otherSymbols.setDecimalSeparator('.');

	                format.setDecimalFormatSymbols(otherSymbols);
	                NumberFormatter formatter = new NumberFormatter(format);
	                formatter.setAllowsInvalid(false);
	                formatter.setMinimum(0.00);
	                formatter.setMaximum(9.99);
	                return formatter;
	            }

	        });			
			textFieldQuantidade.setDocument(new LimitaCaracteres(20, LimitaCaracteres.TipoEntrada.codigo)); //codigo é só numero tbm
			textFieldQuantidade.add(scrollTextArea);
		}
		return textFieldQuantidade;
	}
	
	public JLabel getLblPreco() {
		if(lblPreco == null) {
			lblPreco = new JLabel();			
			lblPreco.setHorizontalAlignment(SwingConstants.RIGHT);
			lblPreco.setForeground(new Color(255, 255, 255));
			lblPreco.setLocation(39, 210);
			lblPreco.setSize(100, 20);
			lblPreco.setText("Preço: ");
		}
		return lblPreco;
	}
	
	public JFormattedTextField getTextFieldPreco() {
		if(textFieldPreco == null) {
			textFieldPreco = new JFormattedTextField();
			textFieldPreco.setLocation(140, 210);
			textFieldPreco.setFormatterFactory(new AbstractFormatterFactory() {

	            @Override
	            public AbstractFormatter getFormatter(JFormattedTextField tf) {
	                DecimalFormat format = new DecimalFormat();
	                format.setMinimumFractionDigits(2);
	                format.setMaximumFractionDigits(2);
	                format.setRoundingMode(RoundingMode.HALF_UP);

	                DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(getLocale());
	                otherSymbols.setDecimalSeparator('.');

	                format.setDecimalFormatSymbols(otherSymbols);
	                NumberFormatter formatter = new NumberFormatter(format);
	                formatter.setAllowsInvalid(false);
	                formatter.setMinimum(0.00);
	                formatter.setMaximum(9.99);
	                return formatter;
	            }

	        });		
			textFieldPreco.setSize(109, 22);
			textFieldPreco.setDocument(new LimitaCaracteres(20, LimitaCaracteres.TipoEntrada.codigo));
		}
		return textFieldPreco;
	}
	
	public JButton getButtonIncluir() {
		if(buttonIncluir == null) {
			buttonIncluir = new JButton();
			buttonIncluir.setBounds(79, 243, 82, 22);
			buttonIncluir.addActionListener(e -> incluirBanco());
			buttonIncluir.setText("Incluir");
		}
		return buttonIncluir;
	}
	
	public JButton getButtonDeletar() {
		if(buttonDeletar == null) {
			buttonDeletar = new JButton();
			buttonDeletar.setBounds(170, 243, 90, 22);
			buttonDeletar.setText("Deletar");
		}
		return buttonDeletar;
	}
	
	public JButton getButtonAlterar() {
		if(buttonAlterar == null) {
			buttonAlterar = new JButton();
			buttonAlterar.setBounds(270, 243, 90, 22);
			buttonAlterar.setText("Alterar");
		}
		return buttonAlterar;
	}
	
	public JComboBox getButtonCategoria() {
		if(categoria == null) {
			categoria = new JComboBox();
			categoria.setModel(new DefaultComboBoxModel(new String[] {"selecione"}));
			categoria.setBounds(259, 40, 95, 22);
			Vector<Integer> categoriaBd = new Vector<>();
		    try {
		    	ProdutoDao produtoDao = new ProdutoDao();
		    	ResultSet rs = produtoDao.buscarCategoria();
				while(rs.next()) {
					categoriaBd.addElement(rs.getInt(1));
					categoria.addItem(rs.getString(2));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return categoria;
	}
	
	public void incluirBanco() {
		try {
			ProdutoController produto = new ProdutoController();
			produto.cadastrarProduto(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
