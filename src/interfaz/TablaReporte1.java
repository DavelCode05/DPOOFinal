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
import com.toedter.calendar.JDateChooser;

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
	private JDateChooser dateChooser;
	private JDateChooser dateChooser_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
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
		fac = Facultad.getFacultad();
		setBounds(100, 100, 1086, 760);
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
		contentPanel.add(getDateChooser());
		contentPanel.add(getDateChooser_1());
		contentPanel.add(getLblNewLabel_2());
		contentPanel.add(getLblNewLabel_3());



	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setFont(new Font("Tahoma", Font.BOLD, 21));
			textField.setBounds(33, 75, 249, 53);
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
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
			lblNewLabel.setBounds(33, 46, 260, 26);
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
			scrollPane.setBounds(33, 202, 1018, 525);
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
			lblNewLabel_1.setBounds(33, 136, 352, 48);
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
			btnNewButton.setBounds(294, 85, 33, 32);
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("");
			btnNewButton_1.setBounds(1016, 13, 58, 48);
			btnNewButton_1.setContentAreaFilled(false);
			btnNewButton_1.setOpaque(true);
			btnNewButton_1.setBorder(null);
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
	private JDateChooser getDateChooser() {
		if (dateChooser == null) {
			dateChooser = new JDateChooser("dd/MM/yyyy", "##/##/####",'_');
			dateChooser.setForeground(Color.BLACK);
//			JTextField dateField = (JTextField)dateChooser.getDateEditor().getUiComponent();
//			dateField.setForeground(Color.WHITE);
			dateChooser.setBounds(413, 75, 131, 53);
//			dateField.setBackground(Colores.getAzulCielo());
		}
		return dateChooser;
	}
	private JDateChooser getDateChooser_1() {
		if (dateChooser_1 == null) {
			dateChooser_1 = new JDateChooser("dd/MM/yyyy", "##/##/####",'_');
//			JTextField dateField1 = (JTextField)dateChooser_1.getDateEditor().getUiComponent();
//			dateField1.setForeground(Color.WHITE);
			dateChooser_1.setForeground(Color.BLACK);
			dateChooser_1.setBounds(578, 75, 131, 53);
//			dateField1.setBackground(Colores.getAzulCielo());
		}
		return dateChooser_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("Desde");
			lblNewLabel_2.setForeground(Color.WHITE);
			lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 21));
			lblNewLabel_2.setBounds(413, 51, 74, 16);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("Hasta");
			lblNewLabel_3.setForeground(Color.WHITE);
			lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 21));
			lblNewLabel_3.setBounds(578, 51, 74, 16);
		}
		return lblNewLabel_3;
	}
}
