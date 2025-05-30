package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

public class BarraDeCarga extends JDialog {

	private final JPanel contentPanel = new JPanel(){
		public void paintComponent(Graphics g){
			Image img= Toolkit.getDefaultToolkit().getImage(BarraDeCarga.class.getResource("/images/loginDesenfocado.jpg"));
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		}

	};
	private JProgressBar progressBar;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
			BarraDeCarga dialog = new BarraDeCarga();
			dialog.setVisible(true);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			
			IniciarSesion inicio = new IniciarSesion();
			
			try {
				for(int i = 0; i < 100; i++){
					Thread.sleep(20);
					dialog.progressBar.setValue(i);;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			dialog.setVisible(false);
			inicio.setVisible(true);
			dialog.dispose();
		
	}

	/**
	 * Create the dialog.
	 */
	public BarraDeCarga() {
		setBounds(100, 100, 739, 489);
		getContentPane().setLayout(new BorderLayout());
		setUndecorated(true);
		setLocationRelativeTo(null);
		contentPanel.setBackground(Colores.getLogin());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getProgressBar());
		contentPanel.add(getPanel());
		contentPanel.add(getLblNewLabel());
		contentPanel.add(getLblNewLabel_1());
	}
	private JProgressBar getProgressBar() {
		if (progressBar == null) {
			progressBar = new JProgressBar();
			progressBar.setBounds(12, 434, 715, 29);
			progressBar.setBorderPainted(false);
			progressBar.setBorder(null);
			progressBar.setForeground(new Color(0, 204, 51));
		}
		return progressBar;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel(){
				public void paintComponent(Graphics g){
					Image img= Toolkit.getDefaultToolkit().getImage(BarraDeCarga.class.getResource("/images/universidad.png"));
					g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
				}
			};
			panel.setBounds(316, 68, 100, 100);
		}
		return panel;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Facultad de Ingenier\u00EDa Inform\u00E1tica");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
			lblNewLabel.setBounds(59, 178, 620, 100);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Cujae");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 57));
			lblNewLabel_1.setBounds(278, 269, 190, 78);
		}
		return lblNewLabel_1;
	}
}
