package interfaz;

import java.awt.BorderLayout;

import enums.Plaza;
import enums.TipoLocal;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controllerClass.Facultad;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import util.MostrarLocales;
import util.MostrarPersonal;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

import personas.Persona;
import locales.Local;

import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

public class VerLocales extends JDialog {

	private final JPanel contentPanel;
	private Facultad fac;
	private JComboBox<Persona> respons;
	private JScrollPane scrollPane;
	private JTable tableloc;
	private int row;
	private MostrarLocales tablemodel;
	private JButton btnNewButton;
	private JTextField codigo;
	private JComboBox<TipoLocal> tipoLoc;
	boolean editando;
	boolean agregar;
	private JLabel errores;
	private JButton btnCancelar;
	private JButton btnGuardar;
	private JButton btnEliminar;
	private JButton btneditar;
	private JLabel lblTipo ;
	private JLabel lblCodigo;
	private JLabel lblResponsable;
	private JButton btnAgregar;

	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		try {
//			VerLocales dialog = new VerLocales();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	/**
//	 * Create the dialog.
//	 */
//	
	
	public VerLocales(JFrame p) {
    	super(p, true);
		fac = Facultad.getFacultad();
		setBounds(100, 100, 1234, 760);
		editando = false;
		agregar = false;
		contentPanel = new JPanel(){
			public void paintComponent(Graphics g){
				Image img= Toolkit.getDefaultToolkit().getImage(Inicio.class.getResource("/images/fondoDesenfocado.png"));
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};
			
		setUndecorated(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getBtnNewButton());

		JPanel panel = new JPanel();
		panel.setBounds(646, 153, 531, 431);
		contentPanel.add(panel);
		panel.setLayout(null);


		scrollPane = new JScrollPane();
		contentPanel.add(scrollPane);

		scrollPane.setBackground(Colores.getAzulCielo());
		scrollPane.getViewport().setBackground(Colores.getLogin());
		scrollPane.setBorder(new EmptyBorder(3, 3, 3, 3));
		scrollPane.setBounds(33, 153, 591, 460);

		tableloc = new JTable();

		tablemodel = new MostrarLocales();

		scrollPane.setViewportView(tableloc);
		tableloc.setModel(tablemodel);
		tableloc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tableloc.setRowHeight(29);
		tableloc.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableloc.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 17));
		tableloc.setForeground(Color.WHITE);
		tableloc.setBackground(Colores.getAzulCielo());
		tableloc.setGridColor(Colores.getLogin());
		tableloc.getTableHeader().setBackground(Colores.getLogin());
		tableloc.setBorder(null);


		tableloc.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(java.awt.event.MouseEvent arg0) {
				if(!editando){
					row = tableloc.rowAtPoint(arg0.getPoint());

					if( row!=-1){
						tableloc.setRowSelectionInterval(row,row);
						tableloc.setAutoscrolls(true);
						mostrar(fac.getLocales().get(row));	

					}
					else {
						tableloc.clearSelection();
					}
				}
			}

			@Override
			public void mouseDragged(java.awt.event.MouseEvent arg0) {
				// TODO Auto-generated method stub

			}


		});

		tableloc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent arg0) {

				if(!editando){
					mostrar (fac.getLocales().get(row));

					tablemodel.setRowCount(0);
					tablemodel.cargarInfo(fac.getLocales());
				}
			}

		});

		tableloc.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				int indice = tableloc.getSelectedRow();
				if(indice>-1){
					tableloc.setRowSelectionInterval(indice,indice);
					tableloc.setAutoscrolls(true);
					mostrar(fac.getLocales().get(indice));
				}

			}
		});
		
/////////////////////////////// LABEL Y TEXT FIELDS ////////////////////////////////////////////////////////////
		
		lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(28, 80, 46, 14);
		panel.add(lblCodigo);

		lblTipo = new JLabel("tipo");
		lblTipo.setBounds(28, 135, 46, 14);
		panel.add(lblTipo);

		lblResponsable = new JLabel("Responsable");
		lblResponsable.setBounds(28, 191, 70, 14);
		panel.add(lblResponsable);

		codigo = new JTextField();
		codigo.setBounds(82, 77, 86, 20);
		panel.add(codigo);
		codigo.setColumns(10);

		tipoLoc = new JComboBox<TipoLocal>();
		tipoLoc.setBounds(96, 132, 125, 20);
		panel.add(tipoLoc);
		tipoLoc.setModel(new DefaultComboBoxModel<>(TipoLocal.values()));

		respons = new JComboBox<>();
		respons.setBounds(96, 188, 125, 20);
		panel.add(respons);
		respons.setModel(new DefaultComboBoxModel<>(fac.obtenerResponsables().toArray(new Persona[0])));
		
		
		errores = new JLabel("New label");
		errores.setBounds(10, 358, 179, 14);
		panel.add(errores);
		
		
		
		mostrar(fac.getLocales().get(0));
		tablemodel.cargarInfo(fac.getLocales());

		
///////////////////////////////BOTON EDITAR ////////////////////////////////////////////////////////////
		btneditar = new JButton("Editar");
		btneditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				editando = true;
				btnGuardar.setVisible(true);
				btnCancelar.setVisible(true);
				btnEliminar.setVisible(false);
				btneditar.setVisible(false);
				respons.setEnabled(true);
				tipoLoc.setEnabled(true);
				codigo.setEditable(true);
			}
		});
		btneditar.setBounds(217, 28, 89, 23);
		panel.add(btneditar);
		
/////////////////////////////// BOTON ELIMINAR  ////////////////////////////////////////////////////////////
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setVisible(true);
		btnEliminar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(null, "¿Eliminar esta persona?", "Confirmar", JOptionPane.YES_NO_OPTION);
				if (confirm == JOptionPane.YES_OPTION) {

					fac.getLocales().remove(row);
					tablemodel.setRowCount(0);
					tablemodel.cargarInfo(fac.getLocales());
					btnCancelar.setVisible(false);
					btnEliminar.setVisible(true);
					btnEliminar.setEnabled(true);
					btnGuardar.setVisible(false);
					btneditar.setVisible(true);
					codigo.setEditable(false);
					respons.setEnabled(false);
					tipoLoc.setEnabled(false);


				}
			}

		});
		btnEliminar.setBounds(352, 312, 89, 23);
		panel.add(btnEliminar);

		

/////////////////////////////// BOTON GUARDAR ////////////////////////////////////////////////////////////
		
		btnGuardar = new JButton("Guardar");

		btnGuardar.setBounds(237, 312, 89, 23);
		panel.add(btnGuardar);
		btnGuardar.setVisible(false);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if(crearLoc(fac.getLocales().get(row))){
					editando = false;
					agregar = false;
					codigo.setEditable(false);
					btneditar.setVisible(true);
					btnEliminar.setVisible(true);
					btnCancelar.setVisible(false);
					btnGuardar.setVisible(false);
					respons.setEnabled(false);
					tipoLoc.setEnabled(false);
					tablemodel.setRowCount(0);
					tablemodel.cargarInfo(fac.getLocales());
				}



			}
		});
		
///////////////////////////////BOTON CANCELAR ////////////////////////////////////////////////////////////

		btnCancelar = new JButton("Cancelar");

		btnCancelar.setBounds(352, 28, 89, 23);
		panel.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {


				int confirm = JOptionPane.showConfirmDialog(null, "¿Desea cancelar sin guardar los cambios?", "Confirmar", JOptionPane.YES_NO_OPTION);
				if (confirm == JOptionPane.YES_OPTION) {
					editando = false;
					mostrar(fac.getLocales().get(row));

					btnCancelar.setVisible(false);
					btnEliminar.setVisible(true);
					btnEliminar.setEnabled(true);
					btnGuardar.setVisible(false);
					btneditar.setVisible(true);
					codigo.setEditable(false);
					respons.setEnabled(false);
					tipoLoc.setEnabled(false);
				}
			}
		});

		
/////////////////////////////// BOTON AGREGAR////////////////////////////////////////////////////////////

		btnAgregar = new JButton("agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				editando = true;
				agregar = true;
				btnCancelar.setVisible(true);
				btnEliminar.setVisible(false);
				btnGuardar.setVisible(true);
				btneditar.setVisible(false);
				codigo.setText("");
				codigo.setEditable(true);
				respons.setSelectedIndex(0);
				respons.setEnabled(true);
				tipoLoc.setEnabled(true);
				tipoLoc.setSelectedIndex(0);

			}
		});
		btnAgregar.setBounds(233, 70, 89, 23);
		contentPanel.add(btnAgregar);
		btnCancelar.setVisible(false);


		

	}
	//private JScrollPane getScrollPane() {
	//	if (scrollPane == null) {
	//			scrollPane = new JScrollPane();
	//
	//
	//
	//			scrollPane.setBackground(Colores.getAzulCielo());
	//			scrollPane.getViewport().setBackground(Colores.getLogin());
	//			scrollPane.setBorder(new EmptyBorder(3, 3, 3, 3));
	//			scrollPane.setBounds(33, 153, 591, 460);
	//
	//			tableloc = new JTable();
	//
	//			tablemodel = new MostrarLocales();
	//
	//			scrollPane.setViewportView(tableloc);
	//			tableloc.setModel(tablemodel);
	//			tableloc.setFont(new Font("Tahoma", Font.PLAIN, 16));
	//			tableloc.setRowHeight(29);
	//			tableloc.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	//			tableloc.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 17));
	//			tableloc.setForeground(Color.WHITE);
	//			tableloc.setBackground(Colores.getAzulCielo());
	//			tableloc.setGridColor(Colores.getLogin());
	//			tableloc.getTableHeader().setBackground(Colores.getLogin());
	//			tableloc.setBorder(null);
	//			
	//
	//			tableloc.addMouseMotionListener(new MouseMotionListener() {
	//
	//				@Override
	//				public void mouseMoved(java.awt.event.MouseEvent arg0) {
	//					if(!editando){
	//					row = tableloc.rowAtPoint(arg0.getPoint());
	//					
	//					if( row!=-1){
	//						tableloc.setRowSelectionInterval(row,row);
	//						tableloc.setAutoscrolls(true);
	//						mostrar(fac.getLocales().get(row));	
	//
	//					}
	//					else {
	//						tableloc.clearSelection();
	//					}
	//					}
	//				}
	//
	//				@Override
	//				public void mouseDragged(java.awt.event.MouseEvent arg0) {
	//					// TODO Auto-generated method stub
	//
	//				}
	//
	//
	//			});
	//			
	//			tableloc.addMouseListener(new MouseAdapter() {
	//				@Override
	//				public void mouseClicked(java.awt.event.MouseEvent arg0) {
	//
	//					if(!editando){
	//				    mostrar (fac.getLocales().get(row));
	//					
	//					tablemodel.setRowCount(0);
	//					tablemodel.cargarInfo(fac.getLocales());
	//					}
	//				}
	//					
	//			});
	//			tablemodel.cargarInfo(fac.getLocales());
	//		}
	//		return scrollPane;
	//	}



/////////////////////////////// BOTON SALIR  ////////////////////////////////////////////////////////////
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("salir");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			btnNewButton.setBounds(60, 13, 97, 25);
		}
		return btnNewButton;
	}
	
/////////////////////////////// MOSTRAR INFORMACION  ////////////////////////////////////////////////////////////

	public void mostrar(Local l){

		codigo.setText(l.getCodigo());
		codigo.setEditable(false);
		tipoLoc.setSelectedItem(l.getTipo());
		tipoLoc.setEnabled(false);
		respons.setSelectedItem(l.getResponsable());
		respons.setEnabled(false);

	}
	
/////////////////////////////// CREAR Y EDITAR LOCALES  ////////////////////////////////////////////////////////////

	public boolean crearLoc(Local lo){
		String cod = codigo.getText();
		TipoLocal loc = (TipoLocal) tipoLoc.getSelectedItem();
		Persona res = (Persona) respons.getSelectedItem();
		boolean bien = true;

		Local l = new Local();
		Local existente = fac.buscarLocal(cod);

		if(agregar && existente != null){
			errores.setText("El local ya existe ");
			bien = false;

		}
		else if(!agregar && existente != null && !fac.getLocales().get(row).getCodigo().equals(cod)){
			errores.setText("Ya existe un local con ese codigo");
			bien = false;
		}
		else{
			if(bien){
				try{
					l.setCodigo(cod);
				}
				catch(IllegalArgumentException e){
					errores.setText("Datos invalidos");
					lblCodigo.setForeground(Color.RED);
					bien = false;
				}
				try{
					l.setResponsable(res);;
				}
				catch(IllegalArgumentException e){
					errores.setText("Datos invalidos");
					lblResponsable.setForeground(Color.RED);
					bien = false;
				}
				try{
					l.setTipo(loc);
				}
				catch(IllegalArgumentException e){
					errores.setText("Datos invalidos");
					lblTipo.setForeground(Color.RED);
					bien = false;
				}

			}
		}

		if(agregar && bien){
			fac.addLocal(cod, res, loc);
		}
		else if(!agregar && bien){
			lo.setCodigo(l.getCodigo());
			lo.setResponsable(l.getResponsable());
			lo.setTipo(l.getTipo());
		}


		return bien;
	}
}
