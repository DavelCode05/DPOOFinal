package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.TableModel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controllerClass.Facultad;
import util.TablaRegistrosReporte1;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class TablaReporte1 extends JDialog {

	private final JPanel contentPanel = new JPanel(){
		public void paintComponent(Graphics g){
			Image img= Toolkit.getDefaultToolkit().getImage(Inicio.class.getResource("/images/fondoDesenfocado.png"));
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		}
	};
	private JTextField textField;
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	private JTable table;
	private TablaRegistrosReporte1 tablaModel;
	private Facultad fac;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	/**
	 * Launch the application.
	 */
	//	public static void main(String[] args) {
	//		try {
	//			TablaReporte1 dialog = new TablaReporte1();
	//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	//			dialog.setVisible(true);
	//		} catch (Exception e) {
	//			e.printStackTrace();
	//		}
	//	}

	/**
	 * Create the dialog.
	 */
	public TablaReporte1(JFrame padre) {
		super(padre, "Reporte 1", true);
		setTitle("Chequeo de registros");
		fac = new Facultad();
		setBounds(100, 100, 842, 628);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setBorder(new LineBorder(Colores.getAzulOScuro()));
		this.setUndecorated(true);
		setLocationRelativeTo(null);
		contentPanel.setLayout(null);
		contentPanel.add(getTextField());
		contentPanel.add(getLblNewLabel());
		contentPanel.add(getScrollPane());
		contentPanel.add(getLblNewLabel_1());
		contentPanel.add(getBtnNewButton());
		contentPanel.add(getBtnNewButton_1());



	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setFont(new Font("Tahoma", Font.BOLD, 18));
			textField.setBounds(33, 75, 194, 32);
			textField.setBackground(Colores.getAzulCielo());
			textField.setForeground(Color.WHITE);
			textField.setBorder(new LineBorder(Colores.getBlancuzo()));
			textField.setColumns(10);
		}
		return textField;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Identidad de la Persona");
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
			lblNewLabel.setBounds(33, 46, 246, 16);
		}
		return lblNewLabel;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane(){
				public void paintComponent(Graphics g){
					Image img = Toolkit.getDefaultToolkit().getImage(TablaReporte1.class.getResource("/images/fondosTablas.png"));
					g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
				}
			};
			scrollPane.setBackground(Colores.getAzulCielo());
			scrollPane.setBorder(null);
			scrollPane.setBounds(33, 174, 775, 406);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setFont(new Font("Tahoma", Font.PLAIN, 16));
			table.setRowHeight(29);

		}
		tablaModel = new TablaRegistrosReporte1();
		table.setModel(tablaModel);
		table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 17));
		table.setForeground(Color.WHITE);
		table.setBackground(Colores.getAzulCielo());
		table.setBorder(null);
		return table;
	}

	public void entradaCarnet(){
		String carnet = textField.getText();
		boolean correcto = true;

		try{
			fac.buscarEnPersonal(carnet);
		}
		catch(IllegalArgumentException e){
			lblNewLabel_1.setText(e.getMessage());
			lblNewLabel_1.setVisible(true);
			correcto = false;
		}

		if(correcto){
			tablaModel.cargarInfo(fac.obtenerReporteVisitasPersonas(carnet, LocalDate.now(), LocalDate.now()));
		}

	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setBackground(Color.WHITE);
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
			lblNewLabel_1.setForeground(new Color(255, 0, 51));
			lblNewLabel_1.setBounds(33, 108, 352, 48);
			lblNewLabel_1.setVisible(false);;
		}
		return lblNewLabel_1;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("");
			btnNewButton.setBorder(null);
			btnNewButton.setIcon(new ImageIcon(TablaReporte1.class.getResource("/images/aceptar.png")));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					entradaCarnet();
				}
			});
			btnNewButton.setBounds(238, 75, 33, 32);
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("");
			btnNewButton_1.setBounds(772, 22, 58, 48);
			Border bordeRedondo = BorderFactory.createLineBorder(Color.WHITE, 2, true);
			btnNewButton_1.setBorder(bordeRedondo);
			btnNewButton_1.setContentAreaFilled(false);
			btnNewButton_1.setOpaque(true);
			btnNewButton_1.setBackground(Color.LIGHT_GRAY);
			btnNewButton_1.setForeground(new Color(6, 43, 63));
			btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 29));
			btnNewButton_1.setIcon(new ImageIcon(TablaReporte1.class.getResource("/images/close.png")));
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
		}
		return btnNewButton_1;
	}
}
