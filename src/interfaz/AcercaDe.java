package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.Border;
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
			Image img= Toolkit.getDefaultToolkit().getImage(Inicio.class.getResource("/images/fondoDesenfocado.png"));
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		}
	};
	private JLabel lblHola;
	private JButton btnSalir;
	private JLabel lblNewLabel;
	private JLabel lblEquipoDeTrabajo;
	private JLabel lblNd;
	private JLabel lblNewLabel_1;
	private JLabel lblcontrolDeAccesos;
	private JLabel lblLaSeguridadEn;
	private JLabel lblEficienteYConfiable;

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
		setLocationRelativeTo(null);

		contentPanel.add(getLblHola());
		contentPanel.add(getBtnSalir());
		contentPanel.add(getLblNewLabel());
		contentPanel.add(getLblEquipoDeTrabajo());
		contentPanel.add(getLblNd());
		contentPanel.add(getLblNewLabel_1());
		contentPanel.add(getLblcontrolDeAccesos());
		contentPanel.add(getLblLaSeguridadEn());
		contentPanel.add(getLblEficienteYConfiable());
	}
	private JLabel getLblHola() {
		if (lblHola == null) {
			lblHola = new JLabel("Control de Accesos");
			lblHola.setForeground(Colores.getBlancuzo());
			lblHola.setBounds(341, 288, 506, 123);
			lblHola.setHorizontalAlignment(SwingConstants.CENTER);
			lblHola.setFont(new Font("Tahoma", Font.BOLD, 50));
		}
		return lblHola;
	}
	private JButton getBtnSalir() {
		if (btnSalir == null) {
			btnSalir = new JButton("");
			btnSalir.setBounds(1057, 13, 50, 50);
			Border bordeRedondo = BorderFactory.createLineBorder(Color.WHITE, 2, true);
			btnSalir.setBorder(bordeRedondo);
			btnSalir.setContentAreaFilled(false);
			btnSalir.setOpaque(true);
			btnSalir.setBackground(Color.LIGHT_GRAY);
			btnSalir.setForeground(new Color(6, 43, 63));
			btnSalir.setFont(new Font("Tahoma", Font.BOLD, 29));
			btnSalir.setIcon(new ImageIcon(AcercaDe.class.getResource("/images/close.png")));
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
			lblNewLabel = new JLabel("Version 1.0 - Junio 2025");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel.setBounds(490, 513, 197, 50);
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
			lblNd.setBounds(484, 850, 241, 34);
			lblNd.setFont(new Font("Modern No. 20", Font.BOLD, 26));
		}
		return lblNd;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Facultad de Ingenier\u00EDa Inform\u00E1tica");
			lblNewLabel_1.setForeground(Color.WHITE);
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 48));
			lblNewLabel_1.setBounds(172, 444, 870, 85);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblcontrolDeAccesos() {
		if (lblcontrolDeAccesos == null) {
			lblcontrolDeAccesos = new JLabel("\"Control de Accesos es un sistema dise\u00F1ado para gestionar y optimizar");
			lblcontrolDeAccesos.setForeground(Color.WHITE);
			lblcontrolDeAccesos.setFont(new Font("Modern No. 20", Font.PLAIN, 22));
			lblcontrolDeAccesos.setBounds(486, 654, 634, 25);
		}
		return lblcontrolDeAccesos;
	}
	private JLabel getLblLaSeguridadEn() {
		if (lblLaSeguridadEn == null) {
			lblLaSeguridadEn = new JLabel("la seguridad en la Facultad de Inform\u00E1tica, garantizando un registro");
			lblLaSeguridadEn.setForeground(Color.WHITE);
			lblLaSeguridadEn.setFont(new Font("Modern No. 20", Font.PLAIN, 22));
			lblLaSeguridadEn.setBounds(486, 692, 624, 25);
		}
		return lblLaSeguridadEn;
	}
	private JLabel getLblEficienteYConfiable() {
		if (lblEficienteYConfiable == null) {
			lblEficienteYConfiable = new JLabel("eficiente y confiable de entradas y salidas mediante tecnolog\u00EDa innovadora\"");
			lblEficienteYConfiable.setForeground(Color.WHITE);
			lblEficienteYConfiable.setFont(new Font("Modern No. 20", Font.PLAIN, 22));
			lblEficienteYConfiable.setBounds(486, 730, 662, 25);
		}
		return lblEficienteYConfiable;
	}
}
