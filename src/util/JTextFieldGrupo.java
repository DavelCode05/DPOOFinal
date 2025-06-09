package util;

import javax.swing.JTextField;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class JTextFieldGrupo extends JTextField{
	public JTextFieldGrupo() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				JTextField text = (JTextField)e.getSource();
				char c = e.getKeyChar();
				if (text.getText().length() == limite || !Character.isDigit(c)) {
					e.consume();
				}
			}
		});
	}
	
	private int limite = 2;

	public int getLimite() {
		return limite;
	}

	public void setLimite(int limite) {
		if(limite <= 2)
			this.limite = limite;
	}
}
