package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import acceso.Registro;
import controllerClass.Facultad;
import util.ModeloTablaSalida;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class KKK extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JButton btnRegistrarSalida;
	ModeloTablaSalida modelo;
	Facultad fac;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			KKK dialog = new KKK();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public KKK() {
		fac= Facultad.getFacultad();
		setBounds(100, 100, 563, 403);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 54, 527, 284);
		contentPanel.add(scrollPane);
		table = new JTable();
		scrollPane.setColumnHeaderView(table);

		modelo = new ModeloTablaSalida();
		table.setModel(modelo);
		scrollPane.setViewportView(table);

		btnRegistrarSalida = new JButton("Registrar Salida");
		btnRegistrarSalida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(Registro r : llll()){
					r.setHoraSalida(LocalTime.now());
				}
				modelo.setRowCount(0);
				modelo.cargarInfo(fac.getVisitas());
			}
		});
		btnRegistrarSalida.setBounds(382, 11, 133, 23);
		contentPanel.add(btnRegistrarSalida);
		modelo.cargarInfo(Facultad.getFacultad().getVisitas());
	}

	
	public ArrayList<Registro> llll(){

		ArrayList<Registro> r = new ArrayList<>();
		for(int i =0; i<modelo.getRowCount();i++){
			boolean m = (Boolean) modelo.getValueAt(i,0);
			if(Boolean.TRUE.equals(m)){
				r.add(fac.getVisitas().get(i));
			}
		}
		return r;	
	}

}

