package util;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;

public class JTextFieldCarnet extends JTextField{
	
private int limite = 11;
	
	public JTextFieldCarnet() {
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


	public int getLimite() {
		return limite;
	}

	public void setLimite(int limite) {
		if(limite <= 11)
			this.limite = limite;
	}
	

}
