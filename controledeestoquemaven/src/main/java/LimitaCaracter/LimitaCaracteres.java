package LimitaCaracter;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import LimitaCaracter.LimitaCaracteres.TipoEntrada;

public class LimitaCaracteres extends PlainDocument {
	
	public enum TipoEntrada{
		nome, 
		email, 
		senha;
	};
	
	private int quantidadeDeCaracteres;
	private TipoEntrada tipoEntrada;
	
	public LimitaCaracteres(int qtdCaracteres, TipoEntrada tpEntrada) {
		this.quantidadeDeCaracteres = qtdCaracteres;
		this.tipoEntrada = tpEntrada;
	}

	@Override
	public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
		if(str == null || getLength() == quantidadeDeCaracteres) {
			return;
		}
		int totalCarac = getLength() + str.length();
		
		String regex = "";
		switch (tipoEntrada) {
		case nome: regex = "[^\\p{IsLatin}]"; break;
		case email: regex = "[^\\p{IsLatin}@.\\-_] [^0-9]"; break;
		case senha: regex = "[^0-9]"; break;
		}
		str = str.replaceAll(regex, "");
		if(totalCarac <= quantidadeDeCaracteres) {
			super.insertString(offs, str, a);
		}else {
			String nova = str.substring(0, quantidadeDeCaracteres);
			super.insertString(offs, nova, a);
		}
	}
	

}
