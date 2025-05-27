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

public class TablaAutorizadoReporte4 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private VisitantesAutorizadosTable tablemodel;
	Facultad fac;

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
		fac= new Facultad();
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
		tablemodel= new VisitantesAutorizadosTable(fac.personasAutorizada("06040468470"));
		table.setModel(tablemodel);
	}
}
