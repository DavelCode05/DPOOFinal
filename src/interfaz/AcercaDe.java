package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AcercaDe extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblHola;
	private JButton btnSalir;
	private JLabel lblNewLabel;
	private JLabel lblEquipoDeTrabajo;
	private JLabel lblNd;

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
	}
	private JLabel getLblHola() {
		if (lblHola == null) {
			lblHola = new JLabel("Hola");
			lblHola.setBounds(382, 479, 394, 72);
			lblHola.setHorizontalAlignment(SwingConstants.CENTER);
			lblHola.setFont(new Font("Tahoma", Font.BOLD, 48));
		}
		return lblHola;
	}
	private JButton getBtnSalir() {
		if (btnSalir == null) {
			btnSalir = new JButton("X");
			btnSalir.setBounds(1098, 13, 50, 39);
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
			lblNewLabel.setBounds(520, 550, 107, 25);
			lblNewLabel.setForeground(Color.LIGHT_GRAY);
		}
		return lblNewLabel;
	}
	private JLabel getLblEquipoDeTrabajo() {
		if (lblEquipoDeTrabajo == null) {
			lblEquipoDeTrabajo = new JLabel("Equipo de Trabajo:");
			lblEquipoDeTrabajo.setBounds(488, 842, 172, 21);
			lblEquipoDeTrabajo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		}
		return lblEquipoDeTrabajo;
	}
	private JLabel getLblNd() {
		if (lblNd == null) {
			lblNd = new JLabel("N&D");
			lblNd.setBounds(512, 863, 118, 21);
			lblNd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lblNd;
	}
}
