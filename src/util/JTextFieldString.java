package util;

import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class JTextFieldString extends JTextField{
	public JTextFieldString() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				JTextField text = (JTextField)e.getSource();
				char c = e.getKeyChar();
				if (!Character.isAlphabetic(c) && !Character.isSpace(c)) {
					e.consume();
				}
			}
		});
	}
	
	
}
