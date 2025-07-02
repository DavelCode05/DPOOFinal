package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import util.ModeloTablaSalida;
import acceso.Registro;
import controllerClass.Facultad;

import javax.swing.JTextField;

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
	//private int row;
	//int row2;
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
	private JTextField filtrado;
	private TableRowSorter<ModeloTablaSalida> rowSorter;




	/**
	 * Launch the application.
	 */
	//		public static void main(String[] args) {
	//			try {
	//				VerRegistros dialog = new VerRegistros();
	//				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	//				dialog.setVisible(true);
	//			} catch (Exception e) {
	//				e.printStackTrace();
	//			}
	//		}

	/**
	 * Create the dialog.
	 */


	public VerRegistros(JFrame p) {
		super(p, "", true);
		setTitle("Registros");
		fac = Facultad.getFacultad();
		setBounds(100, 100, 1193, 645);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);

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


		JPanel panel = new JPanel();
		panel.setBounds(748, 50, 415, 535);
		contentPanel.add(panel);
		panel.setLayout(null);


		//////////////////////////////// LABELS ////////////////////////////////////////////////		

		JLabel nomb = new JLabel("Nombre :");
		nomb.setFont(new Font("Tahoma", Font.PLAIN, 22));
		nomb.setBounds(12, 60, 96, 38);
		panel.add(nomb);

		setNomb = new JLabel("New label");
		setNomb.setFont(new Font("Tahoma", Font.PLAIN, 20));
		setNomb.setBounds(120, 60, 260, 38);
		panel.add(setNomb);

		JLabel carnet = new JLabel("Carnet:");
		carnet.setFont(new Font("Tahoma", Font.PLAIN, 22));
		carnet.setBounds(12, 121, 96, 38);
		panel.add(carnet);

		setcarn = new JLabel("New label");
		setcarn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		setcarn.setBounds(120, 121, 260, 38);
		panel.add(setcarn);

		JLabel local = new JLabel("Local:");
		local.setFont(new Font("Tahoma", Font.PLAIN, 22));
		local.setBounds(12, 184, 96, 38);
		panel.add(local);

		setloc = new JLabel("New label");
		setloc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		setloc.setBounds(120, 184, 283, 38);
		panel.add(setloc);

		JLabel entrada = new JLabel("Hora de Entrada:");
		entrada.setFont(new Font("Tahoma", Font.PLAIN, 22));
		entrada.setBounds(12, 321, 183, 38);
		panel.add(entrada);

		salida = new JLabel("Hora de Salida: ");
		salida.setFont(new Font("Tahoma", Font.PLAIN, 22));
		salida.setBounds(12, 361, 183, 38);
		panel.add(salida);

		fecha = new JLabel("Fecha:");
		fecha.setFont(new Font("Tahoma", Font.PLAIN, 20));
		fecha.setBounds(207, 13, 92, 21);
		panel.add(fecha);


		setentrada = new JLabel("New label");
		setentrada.setFont(new Font("Tahoma", Font.PLAIN, 20));
		setentrada.setBounds(207, 321, 168, 38);
		panel.add(setentrada);

		setsalida = new JLabel("New label");
		setsalida.setFont(new Font("Tahoma", Font.PLAIN, 20));
		setsalida.setBounds(207, 361, 196, 38);
		panel.add(setsalida);

		setfecha = new JLabel("New label");
		setfecha.setFont(new Font("Tahoma", Font.PLAIN, 20));
		setfecha.setBounds(275, 13, 111, 21);
		panel.add(setfecha);



		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 13, 735, 572);
		contentPanel.add(tabbedPane);

		panel_1 = new JPanel();
		tabbedPane.addTab("Todos", null, panel_1, null);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.setLayout(null);

		/////////////////////////// PANEL Y TABLA DE TODOS//////////////////////

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 30, 708, 493);
		panel_1.add(scrollPane);

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 17));
		table.setRowHeight(29);

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
				int row = table.rowAtPoint(arg0.getPoint());
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
					llenarDatos(fac.getVisitas().get(table.convertRowIndexToModel(indice)));

				}

			}
		});


		panel_2 = new JPanel();
		tabbedPane.addTab("Sin salidas registradas", null, panel_2, null);
		panel_2.setLayout(null);

		////////////////PANEL Y TABLA SIN SALIDAS REGISTRADAS //////////////////////		
		sinsal = new JScrollPane();
		sinsal.setBounds(10, 36, 708, 458);
		panel_2.add(sinsal);

		table_1 = new JTable();
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table_1.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 17));
		table_1.setRowHeight(29);
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
				int row2 = table_1.rowAtPoint(arg0.getPoint());
				if(row2!=-1 ){
					table_1.setRowSelectionInterval(row2,row2);
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
					llenarDatos(fac.sinSalidas().get(table_1.convertRowIndexToModel(table_1.getSelectedRow())));

				}

			}
		});

		/////////////// BOTON GUARDAR////////////////////////////

		guardar = new JButton("Guardar registro");
		guardar.setFont(new Font("Tahoma", Font.PLAIN, 21));
		guardar.setBounds(10, 496, 193, 36);
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
						btnRegistarSalida.setVisible(true);
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

		cancelar = new JButton("Cancelar");
		cancelar.setFont(new Font("Tahoma", Font.PLAIN, 21));
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnRegistarSalida.setVisible(true);  
				table_1.removeColumn(mi0);
				guardar.setVisible(false);
				cancelar.setVisible(false);
				btnSeleccionarVarios.setVisible(true);

			}
		});
		cancelar.setBounds(203, 496, 113, 36);
		panel_2.add(cancelar);
		cancelar.setVisible(false);

		///////////////////////////// BOTON SELECCION MULTIPLE /////////////////////

		btnSeleccionarVarios = new JButton("Seleccionar varios");
		btnSeleccionarVarios.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnSeleccionarVarios.setBounds(500, 0, 218, 36);
		panel_2.add(btnSeleccionarVarios);
		btnSeleccionarVarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				table_1.addColumn(mi0);
				table_1.moveColumn(table_1.getColumnCount()-1, 0);
				btnRegistarSalida.setVisible(false);
				guardar.setVisible(true);
				cancelar.setVisible(true);
				btnSeleccionarVarios.setVisible(false);
			}
		});

		btnSeleccionarVarios.setVisible(true);

		///////////////////// BOTON REGISTRAR SALIDA///////////////////////

		btnRegistarSalida = new JButton("Registrar Salida");
		//        btnRegistarSalida.setBorder(null);

		//		btnRegistarSalida.addMouseListener(new MouseAdapter() {
		//			@Override
		//            public void mouseEntered(MouseEvent e) {
		//              
		//                btnRegistarSalida.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		//            }
		//
		//            @Override
		//            public void mouseExited(MouseEvent e) {
		//                btnRegistarSalida.setBorder(null);
		////            	btnRegistarSalida.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		//            }
		//		});
		btnRegistarSalida.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnRegistarSalida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tabbedPane.getSelectedIndex()==0)
					fac.getVisitas().get(table.convertRowIndexToModel(table.getSelectedRow())).setHoraSalida(LocalTime.now());
				else
					fac.sinSalidas().get(table_1.convertRowIndexToModel(table_1.getSelectedRow())).setHoraSalida(LocalTime.now());

				modelo.setRowCount(0);
				modelo.cargarInfoGeneral(fac.getVisitas());

				modelo2.setRowCount(0);
				modelo2.cargarInfoGeneral(fac.sinSalidas());

				btnRegistarSalida.setVisible(false);
				setsalida.setText(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));
				JOptionPane.showMessageDialog(VerRegistros.this, "Salida Registrada con éxito", "Registro de salida", JOptionPane.INFORMATION_MESSAGE);


			}
		});
		btnRegistarSalida.setBounds(205, 486, 198, 44);
		panel.add(btnRegistarSalida);

		filtrado = new JTextField();
		filtrado.setBounds(773, 25, 86, 20);
		contentPanel.add(filtrado);
		filtrado.setColumns(10);
		btnRegistarSalida.setVisible(false);
		rowSorter = new TableRowSorter<>(modelo);
		table.setRowSorter(rowSorter);

		final TableRowSorter<TableModel> rowSorter2 = new TableRowSorter<>(table_1.getModel());
		table_1.setRowSorter(rowSorter2);

		filtrado.getDocument().addDocumentListener(new DocumentListener() {
			public void filtrar() {
				String texto = filtrado.getText();

				System.out.println(table.getRowSorter().getViewRowCount());
				System.out.println(table_1.getRowSorter().getViewRowCount());


				rowSorter.setRowFilter(texto.trim().isEmpty() ? null :
					RowFilter.regexFilter("(?i)" + texto));

				rowSorter2.setRowFilter(texto.trim().isEmpty() ? null :
					RowFilter.regexFilter("(?i)" + texto));
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				filtrar();

			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				filtrar();

			}

			@Override
			public void changedUpdate(DocumentEvent arg0) {
				filtrar();

			}
		});

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
		setentrada.setText(r.getHoraEntrada().format(DateTimeFormatter.ofPattern("HH:mm")));
		setsalida.setText(r.getHoraSalida()==null? "No ha salido ": r.getHoraSalida().format(DateTimeFormatter.ofPattern("HH:mm")));

		if(r.getHoraSalida()==null && btnSeleccionarVarios.isVisible()){
			btnRegistarSalida.setVisible(true);
		}
		else
			btnRegistarSalida.setVisible(false);

	}


}
