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
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;

import interfaz.Inicio;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AcercaDe extends JDialog {

	private final JPanel contentPanel = new JPanel(){
		public void paintComponent(Graphics g){
			Image img= Toolkit.getDefaultToolkit().getImage(Inicio.class.getResource("/images/acercaDeFondo.png"));
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		}
	};
	private JLabel lblHola;
	private JButton btnSalir;
	private JLabel lblNewLabel;
	private JLabel lblEquipoDeTrabajo;
	private JLabel lblNd;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public AcercaDe(Inicio inicio) {
		super(inicio, true);
		setUndecorated(true);
		setBounds(380, 100, 1160, 897);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		contentPanel.add(getLblHola());
		contentPanel.add(getBtnSalir());
		contentPanel.add(getLblNewLabel());
		contentPanel.add(getLblEquipoDeTrabajo());
		contentPanel.add(getLblNd());
		contentPanel.add(getLblNewLabel_1());
	}
	private JLabel getLblHola() {
		if (lblHola == null) {
			lblHola = new JLabel("Control de Accesos");
			lblHola.setForeground(Colores.getBlancuzo());
			lblHola.setBounds(342, 326, 506, 123);
			lblHola.setHorizontalAlignment(SwingConstants.CENTER);
			lblHola.setFont(new Font("Tahoma", Font.BOLD, 50));
		}
		return lblHola;
	}
	private JButton getBtnSalir() {
		if (btnSalir == null) {
			btnSalir = new JButton("X");
			btnSalir.setBounds(1057, 13, 58, 48);
			btnSalir.setBackground(Colores.getBlancuzo());
			btnSalir.setForeground(new Color(6, 43, 63));
			btnSalir.setFont(new Font("Tahoma", Font.BOLD, 17));
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
		}
		return btnSalir;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Version 1.0");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel.setBounds(546, 566, 171, 65);
			lblNewLabel.setForeground(Color.WHITE);
		}
		return lblNewLabel;
	}
	private JLabel getLblEquipoDeTrabajo() {
		if (lblEquipoDeTrabajo == null) {
			lblEquipoDeTrabajo = new JLabel("Equipo de Trabajo:");
			lblEquipoDeTrabajo.setForeground(Color.WHITE);
			lblEquipoDeTrabajo.setBounds(484, 828, 248, 21);
			lblEquipoDeTrabajo.setFont(new Font("Tahoma", Font.BOLD, 23));
		}
		return lblEquipoDeTrabajo;
	}
	private JLabel getLblNd() {
		if (lblNd == null) {
			lblNd = new JLabel("VelRios Tech Team");
			lblNd.setForeground(Color.WHITE);
			lblNd.setBounds(505, 863, 198, 21);
			lblNd.setFont(new Font("Tahoma", Font.BOLD, 18));
		}
		return lblNd;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Facultad de Ingenieria Informatica");
			lblNewLabel_1.setForeground(Color.WHITE);
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 48));
			lblNewLabel_1.setBounds(173, 482, 870, 85);
		}
		return lblNewLabel_1;
	}
}
