package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controllerClass.Facultad;
import util.VisitantesAutorizadosTable;
import clasesAuxiliares.VisitantesAutorizadosPorX;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TablaAutorizadoReporte4 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private VisitantesAutorizadosTable tablemodel;
	Facultad fac;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TablaAutorizadoReporte4 dialog = new TablaAutorizadoReporte4();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TablaAutorizadoReporte4() {


		fac= Facultad.getFacultad();

		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 65, 414, 164);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		tablemodel= new VisitantesAutorizadosTable();
		table.setModel(tablemodel);
		
		JLabel lblResponsable = new JLabel("Responsable:");
		lblResponsable.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblResponsable.setBounds(10, 24, 87, 14);
		contentPanel.add(lblResponsable);
		
		textField = new JTextField();
		textField.setBounds(100, 22, 86, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				tablemodel.llenarTabla(fac.personasAutorizada(textField.getText()));
			}
		});
		btnBuscar.setBounds(219, 21, 89, 23);
		contentPanel.add(btnBuscar);
	}
}
