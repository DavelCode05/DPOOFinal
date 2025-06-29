package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import personas.Persona;
import util.VisitantesAutorizadosTable;
import controllerClass.Facultad;

public class TablaAutorizadoReporte4 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private VisitantesAutorizadosTable tablemodel;
	Facultad fac;
	JComboBox<Persona> respons;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			TablaAutorizadoReporte4 dialog = new TablaAutorizadoReporte4();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public TablaAutorizadoReporte4(JFrame p) {
        super(p,"", true);

		fac= Facultad.getFacultad();
	
		
		try{
			boolean found = false;
			for(UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()){
				if("Nimbus".equals(info.getName()) && !found){
					UIManager.setLookAndFeel(info.getClassName());
					found = true;
				}
			}
			if(!found){
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			}
		} catch(Exception e){
			try{
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		

		setBounds(100, 100, 636, 437);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		
		
		UIManager.put("ComboBox.disabledForeground", Color.GRAY);
		UIManager.put("ComboBox.border", BorderFactory.createLineBorder(new Color(180, 180, 180), 1, true));
		UIManager.put("ComboBox.foreground", Color.BLACK);
		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setBackground(Color.WHITE);
//		scrollPane.getViewport().setBackground(Colores.getBlancuzo());
		scrollPane.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
//		scrollPane.getVerticalScrollBar().setUI(new ScrollMinimalista());
		scrollPane.setBounds(10, 78, 596, 299);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		tablemodel= new VisitantesAutorizadosTable();
		table.setModel(tablemodel);
//		table.setShowHorizontalLines(false);
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setRowHeight(29);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getTableHeader().setFont(new Font("Modern No. 20", Font.BOLD, 17));
//		table.setForeground(Color.BLACK);
//		table.setBackground(Colores.getBlancuzo());
//		table.setGridColor(Color.LIGHT_GRAY);
//		table.getTableHeader().setBackground(Color.white);
//		table.setBorder(null);
		
		JLabel lblResponsable = new JLabel("Responsable:");
		lblResponsable.setFont(new Font("Modern No. 20", Font.PLAIN, 25));
		lblResponsable.setBounds(10, 23, 170, 41);
		contentPanel.add(lblResponsable);
		
	    respons = new JComboBox<Persona>();
	    respons.setFont(new Font("Modern No. 20", Font.PLAIN, 22));
		respons.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tablemodel.llenarTabla(fac.personasAutorizada((Persona) respons.getSelectedItem()));
			}
		});
		respons.setBounds(156, 28, 249, 31);
		contentPanel.add(respons);
		respons.setModel(new DefaultComboBoxModel<>(fac.obtenerResponsables().toArray(new Persona[0])));
		
	}
}
