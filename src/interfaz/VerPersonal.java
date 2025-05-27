package interfaz;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import interfaz.Colores;
import interfaz.VerPersonal;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VerPersonal extends JDialog {

	private final JPanel contentPanel;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the dialog.
	 */
	public VerPersonal(Inicio p) {
		super(p,true);
		setBounds(430, 150, 1087, 873);
		contentPanel = new JPanel(){
//			public void paintComponent(Graphics g){
//				Image img = Toolkit.getDefaultToolkit().getImage(VerPersonal.class.getResource("/images/"));
//				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
//			}
		};
		setUndecorated(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getBtnNewButton_1());
		

	}



	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("X");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 17));
			btnNewButton_1.setBounds(952, 16, 58, 48);
		}
		return btnNewButton_1;
	}
}
