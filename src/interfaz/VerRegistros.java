package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javafx.scene.control.SelectionModel;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableColumn;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import acceso.Registro;
import controllerClass.Facultad;
import util.ModeloTablaSalida;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JLabel;

import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTabbedPane;

import java.awt.event.MouseAdapter;

public class VerRegistros extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private ModeloTablaSalida modelo;
	private Facultad fac;
	private TableColumn mi0;
	private JButton btnSeleccionarVarios;
	private JButton guardar;
	private JButton cancelar;
	private JLabel setfecha;
	private JLabel setsalida;
	private JLabel setentrada;
	private JLabel fecha;
	private JLabel salida;
	private int row;
	private JLabel setloc;
	private JLabel setcarn;
	private JLabel setNomb;
	private JButton btnRegistarSalida;
	private JTabbedPane tabbedPane;
	private JPanel panel_1;
	private JPanel panel_2;
	private JScrollPane sinsal;
	private JTable table_1;
	private TableColumn mi20;
	private ModeloTablaSalida modelo2;




	/**
	 * Launch the application.
	 */
	//	public static void main(String[] args) {
	//		try {
	//			VerRegistros dialog = new VerRegistros();
	//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	//			dialog.setVisible(true);
	//		} catch (Exception e) {
	//			e.printStackTrace();
	//		}
	//	}

	/**
	 * Create the dialog.
	 */


	public VerRegistros(JFrame p) {
		super(p, "", true);
		fac = Facultad.getFacultad();
		setBounds(100, 100, 893, 481);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);



		JPanel panel = new JPanel();
		panel.setBounds(547, 53, 297, 234);
		contentPanel.add(panel);
		panel.setLayout(null);


		//////////////////////////////// LABELS ////////////////////////////////////////////////		

		JLabel nomb = new JLabel("Nombre :");
		nomb.setBounds(10, 11, 46, 14);
		panel.add(nomb);

		setNomb = new JLabel("New label");
		setNomb.setBounds(66, 11, 76, 14);
		panel.add(setNomb);

		JLabel carnet = new JLabel("Carnet:");
		carnet.setBounds(10, 57, 46, 14);
		panel.add(carnet);

		setcarn = new JLabel("New label");
		setcarn.setBounds(66, 57, 102, 14);
		panel.add(setcarn);

		JLabel local = new JLabel("Local:");
		local.setBounds(10, 105, 46, 14);
		panel.add(local);

		setloc = new JLabel("New label");
		setloc.setBounds(66, 105, 76, 14);
		panel.add(setloc);

		JLabel entrada = new JLabel("Hora de Entrada ");
		entrada.setBounds(10, 143, 108, 14);
		panel.add(entrada);

		salida = new JLabel("Hora de Salida: ");
		salida.setBounds(10, 169, 108, 14);
		panel.add(salida);

		fecha = new JLabel("Fecha:");
		fecha.setBounds(158, 11, 46, 14);
		panel.add(fecha);


		setentrada = new JLabel("New label");
		setentrada.setBounds(139, 143, 82, 14);
		panel.add(setentrada);

		setsalida = new JLabel("New label");
		setsalida.setBounds(149, 169, 82, 14);
		panel.add(setsalida);

		setfecha = new JLabel("New label");
		setfecha.setBounds(207, 11, 80, 14);
		panel.add(setfecha);





		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(24, 53, 491, 353);
		contentPanel.add(tabbedPane);

		panel_1 = new JPanel();
		tabbedPane.addTab("Todos", null, panel_1, null);
		panel_1.setLayout(null);

		/////////////////////////// PANEL Y TABLA DE TODOS//////////////////////

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 30, 466, 261);
		panel_1.add(scrollPane);

		table = new JTable();
		scrollPane.setColumnHeaderView(table);

		modelo = new ModeloTablaSalida();
		table.setModel(modelo);
		scrollPane.setViewportView(table);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		mi0 = table.getColumnModel().getColumn(0); // columna de seleccion eliminada
		table.removeColumn(mi0);


		table.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				row = table.rowAtPoint(arg0.getPoint());
				if(row!=-1 ){
					table.setRowSelectionInterval(row,row);
					table.setAutoscrolls(true);
					//panelVisible(fac.getPersonal().get(row));
				}

				else{
					table.clearSelection();
				}


			}
		});

		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				int indice = table.getSelectedRow();
				if(indice>-1){
					table.setRowSelectionInterval(indice,indice);
					table.setAutoscrolls(true);
					llenarDatos(fac.getVisitas().get(indice));

				}

			}
		});


		panel_2 = new JPanel();
		tabbedPane.addTab("Sin Salidas Registradas", null, panel_2, null);
		panel_2.setLayout(null);

		////////////////PANEL Y TABLA SIN SALIDAS REGISTRADAS //////////////////////		
		sinsal = new JScrollPane();
		sinsal.setBounds(10, 32, 466, 261);
		panel_2.add(sinsal);

		table_1 = new JTable();
		modelo2 = new ModeloTablaSalida();

		sinsal.setColumnHeaderView(table_1);
		table_1.setModel(modelo2);
		sinsal.setViewportView(table_1);
		mi20 = table_1.getColumnModel().getColumn(0);
		table_1.removeColumn(mi20);

		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


		table_1.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				row = table.rowAtPoint(arg0.getPoint());
				if(row!=-1 ){
					table_1.setRowSelectionInterval(row,row);
					table_1.setAutoscrolls(true);
					//panelVisible(fac.getPersonal().get(row));
				}

				else{
					table_1.clearSelection();
				}


			}
		});

		table_1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				int indice = table_1.getSelectedRow();
				if(indice>-1){
					table_1.setRowSelectionInterval(indice,indice);
					table_1.setAutoscrolls(true);
					llenarDatos(fac.sinSalidas().get(indice));

				}

			}
		});

		/////////////// BOTON GUARDAR////////////////////////////

		guardar = new JButton("GuardarRegistro");
		guardar.setBounds(30, 291, 122, 23);
		panel_2.add(guardar);
		guardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int tam = llll().size();
				if(tam>0){
				int confirm = JOptionPane.showConfirmDialog(null, "¿Registrar la salida de estas " + tam+" personas ?", "Confirmar", JOptionPane.YES_NO_OPTION);
				if (confirm == JOptionPane.YES_OPTION) {
				for(Registro r : llll()){
					r.setHoraSalida(LocalTime.now());

				}
				modelo2.setRowCount(0);
				modelo2.cargarInfoGeneral(fac.sinSalidas());
				modelo.setRowCount(0);
				modelo.cargarInfoGeneral(fac.getVisitas());
				table_1.removeColumn(mi0);
				guardar.setVisible(false);
				cancelar.setVisible(false);
				btnSeleccionarVarios.setVisible(true);
				setsalida.setText(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));
				btnRegistarSalida.setVisible(false);
				}

			}
			
			else
				JOptionPane.showMessageDialog(VerRegistros.this, "No se seleccionaron registros", "Registro de salida", JOptionPane.INFORMATION_MESSAGE);
			}
			});
		guardar.setVisible(false);

		////////////////////////// BOTON CANCELAR ////////////////////////

		cancelar = new JButton("cancelar");
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				table_1.removeColumn(mi0);
				guardar.setVisible(false);
				cancelar.setVisible(false);
				btnSeleccionarVarios.setVisible(true);

			}
		});
		cancelar.setBounds(196, 291, 89, 23);
		panel_2.add(cancelar);
		cancelar.setVisible(false);

		///////////////////////////// BOTON SELECCION MULTIPLE /////////////////////

		btnSeleccionarVarios = new JButton("Seleccionar Varios");
		btnSeleccionarVarios.setBounds(352, 11, 124, 23);
		panel_2.add(btnSeleccionarVarios);
		btnSeleccionarVarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				table_1.addColumn(mi0);
				table_1.moveColumn(table_1.getColumnCount()-1, 0);

				guardar.setVisible(true);
				cancelar.setVisible(true);
				btnSeleccionarVarios.setVisible(false);
			}
		});

		btnSeleccionarVarios.setVisible(true);

		///////////////////// BOTON REGISTRAR SALIDA///////////////////////

		btnRegistarSalida = new JButton("Registar Salida");
		btnRegistarSalida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tabbedPane.getSelectedIndex()==0)
					fac.getVisitas().get(row).setHoraSalida(LocalTime.now());
				else
					fac.sinSalidas().get(row).setHoraSalida(LocalTime.now());

				modelo.setRowCount(0);
				modelo.cargarInfoGeneral(fac.getVisitas());

				modelo2.setRowCount(0);
				modelo2.cargarInfoGeneral(fac.sinSalidas());

				btnRegistarSalida.setVisible(false);
				setsalida.setText(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));
				JOptionPane.showMessageDialog(VerRegistros.this, "Salida Registrada con éxito", "Registro de salida", JOptionPane.INFORMATION_MESSAGE);


			}
		});
		btnRegistarSalida.setBounds(171, 200, 116, 23);
		panel.add(btnRegistarSalida);
		btnRegistarSalida.setVisible(false);






		modelo.cargarInfoGeneral(fac.getVisitas());
		modelo2.cargarInfoGeneral(fac.sinSalidas());
		llenarDatos(fac.getVisitas().get(0));
	}

	////////////////////////////// BUSCAR SELECCIONADOS ///////////////////////////////

	public ArrayList<Registro> llll(){

		ArrayList<Registro> r = new ArrayList<>();
		for(int i =0; i<modelo2.getRowCount();i++){
			boolean m = (Boolean) modelo2.getValueAt(i,0);
			if(Boolean.TRUE.equals(m)){
				r.add(fac.sinSalidas().get(i));
			}
		}
		return r;	
	}


	/////////////////////////////// LLENAR DATOS ///////////////////////////////////////
	public void llenarDatos(Registro r){
		setNomb.setText(r.getPersona().getNombre());
		setcarn.setText(r.getPersona().getNumeroIdentidad());
		setfecha.setText(r.getFecha().toString());
		setloc.setText(r.getLocal().toString());
		setentrada.setText(r.getHoraEntrada().toString());
		setsalida.setText(r.getHoraSalida()==null? "No ha salido ": r.getHoraSalida().format(DateTimeFormatter.ofPattern("HH:mm")));

		if(r.getHoraSalida()==null){
			btnRegistarSalida.setVisible(true);
		}
		else
			btnRegistarSalida.setVisible(false);

	}



}
