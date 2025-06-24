package interfaz;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;


import interfaz.Colores;
import interfaz.VerPersonal;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JScrollPane;
import javax.swing.JTable;































import com.sun.glass.events.MouseEvent;


import util.JTextFieldGrupo;
import util.MostrarPersonal;
//import util.ScrollMinimalista;
import controllerClass.Facultad;
import enums.AreaDirectivo;
import enums.CargoDirectivo;
import enums.Plaza;
import enums.TipoContrato;

import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseAdapter;

import javax.swing.border.MatteBorder;

import javax.swing.border.TitledBorder;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


import java.awt.CardLayout;

import java.awt.CardLayout;
import java.util.ArrayList;


import javax.swing.JLabel;
import javax.swing.JComboBox;


import locales.Local;

import personas.Administrativo;
import personas.Directivo;
import personas.Especialista;
import personas.Estudiante;
import personas.Persona;
import personas.Profesor;
import personas.Tecnico;
import util.JTextFieldCarnet;
import util.JTextFieldGrupo;
import util.JTextFieldString;
import util.MostrarPersonal;
import util.ScrollMinimalista;

import com.sun.glass.events.MouseEvent;

import controllerClass.Facultad;
import enums.AreaDirectivo;
import enums.CargoDirectivo;
import enums.Plaza;
import enums.TipoContrato;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;



public class VerPersonal extends JDialog {

	private final JPanel contentPanel;
	private JButton btnNewButton_1;
	private JTable tablepers;
	private Facultad fac;
	private MostrarPersonal tablemodel;
	private int row;
	private JPanel panel;
	private JPanel panelGeneral;
	private JPanel panelAdmin;
	private JLabel lblPlazaAdmin;

	private JLabel lblNombreYApellidos;
	private JTextFieldString nombre;
	private JLabel lblCarnet;
	private JTextFieldCarnet carnet;


	private JComboBox<Plaza> plazaAdmin;
	private Persona per;

	private JPanel panelDirectivo;
	private JLabel lblDepartamento;
	private JTextFieldString DepaDirect;
	private JLabel lblCategoriaDocente;
	private JLabel lblCategoriaCientifica;
	private JLabel lblTipoDeContrato;
	private JComboBox<TipoContrato> contratodirect;
	private JLabel lblCargoAdministrativo;
	private JComboBox<CargoDirectivo> cargoDirect;
	private JLabel lblreaDeTrabajo;
	private JComboBox<AreaDirectivo> areaDirect;
	private JTextFieldString catDocDirec;
	private JTextFieldString catCientdirec;
	private JLabel depap;
	private JTextFieldString DepaProfesor;
	private JLabel catDocP;
	private JTextFieldString catDocProfesor;
	private JLabel catCP;
	private JTextFieldString catCientProfesor;
	private JLabel tipocontratop;
	private JComboBox<TipoContrato> contratoProfesor;
	private JTextFieldString TFproyectoEsp;
	private JLabel lblProyecto;
	private JComboBox<String> AnnoEst;
	private JLabel lblAo;
	private JLabel lblGrupo;
	private JTextFieldGrupo grupoEst;
	private JTextFieldString palazatec;
	private JLabel lblPlaza_1;
	private JPanel panelProfesor;
	private JPanel panelEspecialista;
	private JPanel panelEstudiante;
	private JPanel panelTecnico;
	private JButton btnEditar;
	private JButton btnEliminar;
	private JButton btnGuardarCambios;
	private JButton btnCancelar;
	private JComboBox<String> eleccionCrear;
	private JLabel errores;
	private CardLayout card;
	private boolean editando ;

	private JComboBox filtro;
	private JComboBox comboBox;
	private JLabel lblFiltrarPor;
	private JPopupMenu menuContextual;
	//private JLabel lblNombreYApellidos;
	//	private JTextFieldString nombre;
	//	private JLabel lblCarnet;
	//	private JTextFieldCarnet carnet;
	private JScrollBar verticalBar;
	Color verdePrincipal = new Color(46, 204, 113);
	Color verdeHover = new Color(39, 174, 96);
	Color verdePressed = new Color(33, 150, 83);
	private JLabel lblCargo;


	//
	//	public static void main(String[] args) {
	//		try {
	//			VerPersonal dialog = new VerPersonal();
	//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	//			dialog.setVisible(true);
	//		} catch (Exception e) {
	//			e.printStackTrace();
	//		}
	//	}






	public VerPersonal(JFrame p) {
		super(p,true);
		setBounds(100, 100, 1234, 760);

		fac = Facultad.getFacultad();
		contentPanel = new JPanel(){
			public void paintComponent(Graphics g){
				Image img= Toolkit.getDefaultToolkit().getImage(Inicio.class.getResource("/images/fondoDesenfocado.png"));
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};


		//		UIManager.put("Table.showGrid", false);
		//        UIManager.put("Table.intercellSpacing", new Dimension(0, 0));



		editando = false;
		setUndecorated(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getBtnNewButton_1());
		this.setUndecorated(true);
		card = new CardLayout(0,0);


		//		setLocationRelativeTo(null);


		JScrollPane scrollPane = new JScrollPane();


		UIManager.put("ComboBox.disabledForeground", Color.GRAY);
		UIManager.put("ComboBox.border", BorderFactory.createLineBorder(new Color(180, 180, 180), 1, true));
		UIManager.put("ComboBox.foreground", Color.BLACK);




		scrollPane.setBackground(Color.WHITE);
		scrollPane.getViewport().setBackground(Colores.getBlancuzo());
		scrollPane.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
		scrollPane.setBounds(22, 103, 603, 631);
		//	scrollPane.getVerticalScrollBar().setUI(new ScrollMinimalista());

		contentPanel.add(scrollPane);

		tablepers = new JTable();

		tablemodel = new MostrarPersonal();

		scrollPane.setViewportView(tablepers);

		tablepers.setModel(tablemodel);
		tablepers.setShowHorizontalLines(false);
		tablepers.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tablepers.setRowHeight(29);
		tablepers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablepers.getTableHeader().setFont(new Font("Modern No. 20", Font.BOLD, 17));
		tablepers.setForeground(Color.BLACK);
		tablepers.setBackground(Colores.getBlancuzo());
		tablepers.setGridColor(Color.LIGHT_GRAY);
		tablepers.getTableHeader().setBackground(Color.white);
		tablepers.setBorder(null);

		tablepers.addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseMoved(java.awt.event.MouseEvent arg0) {
				if(!editando){

					row = tablepers.rowAtPoint(arg0.getPoint());
					if(row!=-1 ){
						tablepers.setRowSelectionInterval(row,row);
						tablepers.setAutoscrolls(true);
						panelVisible(fac.getPersonal().get(row));
					}

					else{
						tablepers.clearSelection();
					}
				}
			}
			@Override
			public void mouseDragged(java.awt.event.MouseEvent arg0) {
				// TODO Auto-generated method stub


			}

		});

		tablepers.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				int indice = tablepers.getSelectedRow();
				if(indice>-1){
					tablepers.setRowSelectionInterval(indice,indice);
					tablepers.setAutoscrolls(true);
					panelVisible(fac.getPersonal().get(indice));

				}

			}
		});

		tablepers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent arg0) {

				if(!editando){
					panelVisible(fac.getPersonal().get(row));

					tablemodel.setRowCount(0);
					tablemodel.cargarInfo(fac.getPersonal());
				}
			}

		});

		//////////////////////////////// BOTON AGREGAR ////////////////////////////////////////////////////////////

		JButton btnagregar = new JButton("");
		btnagregar.setBackground(Color.LIGHT_GRAY);
		btnagregar.setIcon(new ImageIcon(VerPersonal.class.getResource("/images/icons8-add-user-male-50.png")));
		btnagregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				editando = true;

				btnGuardarCambios.setVisible(true);
				btnCancelar.setVisible(true);
				btnEliminar.setVisible(false);

				AnnoEst.setEnabled(true);
				AnnoEst.setSelectedIndex(0);
				nombre.setEditable(true);
				nombre.setText("");
				carnet.setEditable(true);
				carnet.setText("");
				grupoEst.setEditable(true);

				cargoDirect.setEnabled(true);
				cargoDirect.setSelectedIndex(0);
				catDocDirec.setEditable(true);
				catDocDirec.setText("");
				catCientdirec.setEditable(true);
				catCientdirec.setText("");
				areaDirect.setEnabled(true);
				areaDirect.setSelectedIndex(0);
				DepaDirect.setEditable(true);
				DepaDirect.setText("");
				contratodirect.setEnabled(true);
				cargoDirect.setSelectedIndex(0);

				catDocProfesor.setEditable(true);
				catDocProfesor.setText("");
				catCientProfesor.setEditable(true);
				catCientProfesor.setText("");
				contratoProfesor.setEnabled(true);
				contratoProfesor.setSelectedIndex(0);
				DepaProfesor.setEditable(true);
				DepaProfesor.setText("");

				plazaAdmin.setEnabled(true);
				plazaAdmin.setSelectedIndex(0);

				palazatec.setEditable(true);
				palazatec.setText("");

				TFproyectoEsp.setEditable(true);
				TFproyectoEsp.setText("");
				btnEliminar.setEnabled(false);
				btnEditar.setVisible(false);

				//panelVisible(null);
				eleccionCrear.setVisible(true);
				tablemodel.setRowCount(0);

				tablemodel.cargarInfo(fac.getPersonal());	



			}
		});
		btnagregar.setBounds(12, 13, 58, 59);
		contentPanel.add(btnagregar);

		contentPanel.add(getPanel());



		//		contentPanel.add();



		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 19));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Todos", "Estudiante", "Directivo", "Administrativo", "Especialista", "T\u00E9cnico", "Profesor"}));
		//		comboBox.addItemListener(new ItemListener() {
		//			public void itemStateChanged(ItemEvent e) {
		//				if (e.getStateChange() == ItemEvent.SELECTED) {
		//					String rolSeleccionado = (String) e.getItem();
		//					ArrayList<Persona> todas = fac.getPersonal();
		//					ArrayList<Persona> filtradas = new ArrayList<>();
		//
		//					if (rolSeleccionado.equals("Todos")) {
		//						filtradas = todas;
		//					} else {
		//						for (Persona p : todas) {
		//							if (p.getClass().getSimpleName().equals(rolSeleccionado)) {
		//								filtradas.add(p);
		//							}
		//						}
		//					}
		//
		//					tablemodel.cargarInfo(filtradas);
		//				}
		//			}
		//		});
		tablemodel.cargarInfo(fac.getPersonal());
		comboBox.setBounds(199, 36, 197, 36);
		comboBox.setOpaque(true);
		contentPanel.add(comboBox);

		lblFiltrarPor = new JLabel("Mostrar:");
		lblFiltrarPor.setForeground(Color.WHITE);
		lblFiltrarPor.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblFiltrarPor.setBounds(100, 34, 87, 41);
		contentPanel.add(lblFiltrarPor);


		contentPanel.add(getPanel());

		menuContextual = new JPopupMenu();
		JMenuItem itemEditar = new JMenuItem("Editar");
		JMenuItem itemEliminar = new JMenuItem("Eliminar");
		itemEditar.setFont(new Font(itemEditar.getFont().getName(), Font.BOLD, 15));
		itemEliminar.setFont(new Font(itemEliminar.getFont().getName(), Font.BOLD, 15));

		itemEditar.setPreferredSize(new java.awt.Dimension(90,30));
		itemEliminar.setPreferredSize(new java.awt.Dimension(90,30));


		menuContextual.add(itemEditar);
		menuContextual.add(itemEliminar);





		tablepers.addMouseListener(new MouseAdapter() {// opciones para doblo click


			@Override
			public void mouseMoved(java.awt.event.MouseEvent arg0) {
				if(!editando){
					row = tablepers.rowAtPoint(arg0.getPoint());
					if(row!=-1 ){
						tablepers.setRowSelectionInterval(row,row);
						tablepers.setAutoscrolls(true);
						//	panelVisible(fac.getPersonal().get(row));
					}

					row = tablepers.rowAtPoint(arg0.getPoint());
					if(row!=-1){
						tablepers.setRowSelectionInterval(row,row);
						tablepers.setAutoscrolls(true);
					}
					else{
						tablepers.clearSelection();
					}				
				}
			}
			@Override
			public void mouseDragged(java.awt.event.MouseEvent arg0) {
				// TODO Auto-generated method stub
			}
		});


		tablepers.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				int indice = tablepers.getSelectedRow();
				if(indice>-1){
					panelVisible(fac.getPersonal().get(indice));

				}

			}
		});

		tablepers.addMouseListener(new MouseAdapter() {
			//			@Override
			//			public void mouseClicked(java.awt.event.MouseEvent arg0) {
			//				if (!editando) {
			//					panelVisible(fac.getPersonal().get(row));
			//
			//					tablepers.addMouseListener(new MouseAdapter() {
			//						@Override
			//						public void mouseClicked(java.awt.event.MouseEvent arg0) {
			//							CRUDVerPersonal pp = new CRUDVerPersonal(VerPersonal.this, fac.getPersonal().get(row), row);
			//							pp.setVisible(true);
			//							tablemodel.setRowCount(0);
			//							tablemodel.cargarInfo(fac.getPersonal());
			//						}
			//					});
			//
			//					tablemodel.cargarInfo(fac.getPersonal());
			//				}
			//
			//				tablemodel.cargarInfo(fac.getPersonal());
			//			}

			@Override
			public void mousePressed(java.awt.event.MouseEvent e) {
				if(e.isPopupTrigger()){
					int fila = tablepers.rowAtPoint(e.getPoint());
					if(fila >=0 ){
						tablepers.setRowSelectionInterval(fila, fila);
						menuContextual.show(e.getComponent(), e.getX(), e.getY());
					}
				}
			}

			@Override
			public void mouseReleased(java.awt.event.MouseEvent e){
				if(e.isPopupTrigger()){
					mousePressed(e);
				}
			}
		});

		itemEditar.addActionListener(new ActionListener() { // opcion editar con doble click



			public void actionPerformed(ActionEvent arg0) {
				editando = true;
				tablepers.setEnabled(false);
				btnGuardarCambios.setVisible(true);
				btnCancelar.setVisible(true);
				btnEliminar.setVisible(false);
				AnnoEst.setEnabled(true);
				grupoEst.setEditable(true);

				nombre.setEditable(true);
				carnet.setEditable(true);


				cargoDirect.setEnabled(true);
				catDocDirec.setEditable(true);
				catCientdirec.setEditable(true);
				areaDirect.setEnabled(true);
				DepaDirect.setEditable(true);
				contratodirect.setEnabled(true);

				catDocProfesor.setEditable(true);
				catCientProfesor.setEditable(true);
				contratoProfesor.setEnabled(true);
				DepaProfesor.setEditable(true);

				plazaAdmin.setEnabled(true);

				palazatec.setEditable(true);

				TFproyectoEsp.setEditable(true);
				btnEliminar.setEnabled(false);
				btnEditar.setVisible(false);
				JOptionPane.showMessageDialog(VerPersonal.this, "Información editada con éxito", "Edición exitosa", JOptionPane.INFORMATION_MESSAGE);


			}
		});


		itemEliminar.addActionListener(new ActionListener() { // accion eliminar doble click


			@Override
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(null, "¿Eliminar esta persona?", "Confirmar", JOptionPane.YES_NO_OPTION);
				if (confirm == JOptionPane.YES_OPTION) {
					if(!fac.verificarRegistrosActivos(null, fac.getPersonal().get(row))){
					fac.getPersonal().remove(row);
					tablemodel.setRowCount(0);
					tablemodel.cargarInfo(fac.getPersonal());
					JOptionPane.showMessageDialog(VerPersonal.this, "Usuario eliminado con éxito", "Eliminacion exitosa", JOptionPane.INFORMATION_MESSAGE);
					}
					else
						JOptionPane.showMessageDialog(VerPersonal.this, "Hay registros de entrada sobre esta persona sin salida registrada", "Error al eliminar", JOptionPane.ERROR_MESSAGE);

				}
			}
		});


		tablemodel.cargarInfo(fac.getPersonal());
		panelVisible(fac.getPersonal().get(0));

	}

	//////////////////////////////// termina contructor  ////////////////////////////////////////////////////////////





	//////////////////////////////// ELEGIR PARA AGREGAR COMO BOX ////////////////////////////////////////////////////////////


	private JComboBox<String> getEleccionCrear() {
		if (eleccionCrear == null) {
			eleccionCrear = new JComboBox<String>();
			eleccionCrear.setFont(new Font("Tahoma", Font.PLAIN, 20));
			eleccionCrear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					panelVisible(null);	
				}
			});
			eleccionCrear.setModel(new DefaultComboBoxModel<String>(new String[] {"Administrativo", "Directivo", "Profesor", "Especialista", "Estudiante", "Tecnico"}));

			eleccionCrear.setBounds(12, 26, 176, 36);
			panel.add(eleccionCrear);
			eleccionCrear.setVisible(false);

		}
		return eleccionCrear;
	}









	////////////////////////////////PANELES  ////////////////////////////////////////////////////////////



	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();

			panel.setBounds(626, 103, 585, 631);
			panel.setLayout(null);
			panel.setOpaque(true);

			TitledBorder bordeConTitulo = BorderFactory.createTitledBorder(
					BorderFactory.createLineBorder(Colores.getBlancuzo(), 2, false),
					"Detalles de la persona",
					TitledBorder.CENTER,
					TitledBorder.TOP,
					new Font("Modern No. 20", Font.BOLD, 26),
					Color.BLACK);
			panel.setBorder(bordeConTitulo);
			panel.setBackground(Colores.getBlancuzo());

			panelGeneral = new JPanel();
			panelGeneral.setBackground(Colores.getAzulCielo());
			panelGeneral.setBounds(39, 195, 503, 333);

			panel.add(panelGeneral);
			panelGeneral.setLayout(card);

			panelAdmin = new JPanel();

			panelAdmin.setBackground(Colores.getAzulCielo());

			panelAdmin.setBackground(Colores.getBlancuzo());

			panelGeneral.add(panelAdmin, "Administrativo");
			panelAdmin.setLayout(null);
			panelAdmin.add(getLblPlazaAdmin());
			panelAdmin.add(getPlazaAdmin());

			//panelAdmin.add(getErrores());

			//////////////PANEL DIRECTIVO  ///////////////////////

			panelDirectivo = new JPanel();
			panelDirectivo.setBackground(Colores.getBlancuzo());
			panelDirectivo.setLayout(null);
			panelDirectivo.add(getLblDepartamento());
			panelDirectivo.add(getDepaDirect());
			panelDirectivo.add(getLblCategoriaDocente());
			panelDirectivo.add(getLblCategoriaCientifica());
			panelDirectivo.add(getLblTipoDeContrato());
			panelDirectivo.add(getContratodirect());
			panelDirectivo.add(getLblCargoAdministrativo());
			panelDirectivo.add(getCargoDirect());
			panelDirectivo.add(getLblreaDeTrabajo());
			panelDirectivo.add(getAreaDirect());
			panelDirectivo.add(getCatDocDirec());
			panelDirectivo.add(getCatCientdirec());

			panelGeneral.add(panelDirectivo, "Directivo");
			panelGeneral.add(getPanelProfesor(), "Profesor");
			panelGeneral.add(getPanelEspecialista(), "Especialista");
			panelGeneral.add(getPanelEstudiante(), "Estudiante");
			panelGeneral.add(getPanelTecnico(), "Tecnico");
			panel.add(getEleccionCrear());
			panel.add(getBtnEliminar());
			panel.add(getBtnEditar());
			panel.add(getBtnGuardarCambios());
			panel.add(getBtnCancelar());
			panel.add(getLblNombreYApellidos());
			panel.add(getNombre());
			panel.add(getLblCarnet());
			panel.add(getCarnet());
			panel.add(getErrores());

			panel.add(getLblCargo());

			errores.setVisible(false);

		}
		return panel;
	}


	private JPanel getPanelProfesor() {
		if (panelProfesor == null) {
			panelProfesor = new JPanel();
			panelProfesor.setBackground(Colores.getBlancuzo());
			panelProfesor.setLayout(null);
			panelProfesor.add(getDepap());
			panelProfesor.add(getDepaProfesor());
			panelProfesor.add(getCatDocP());
			panelProfesor.add(getCatDocProfesor());
			panelProfesor.add(getCatCP());
			panelProfesor.add(getCatCientProfesor());
			panelProfesor.add(getTipocontratop());
			panelProfesor.add(getContratoProfesor());
		}
		return panelProfesor;
	}


	private JPanel getPanelEspecialista() {
		if (panelEspecialista == null) {
			panelEspecialista = new JPanel();
			panelEspecialista.setBackground(Colores.getBlancuzo());
			panelEspecialista.setLayout(null);
			panelEspecialista.add(getTFproyectoEsp());
			panelEspecialista.add(getLblProyecto());
		}
		return panelEspecialista;
	}



	private JPanel getPanelEstudiante() {
		if (panelEstudiante == null) {
			panelEstudiante = new JPanel();
			panelEstudiante.setBackground(Colores.getBlancuzo());
			panelEstudiante.setLayout(null);
			panelEstudiante.add(getAnnoEst());
			panelEstudiante.add(getLblAo());
			panelEstudiante.add(getLblGrupo());
			panelEstudiante.add(getGrupoEst());
		}
		return panelEstudiante;
	}




	private JPanel getPanelTecnico() {
		if (panelTecnico == null) {
			panelTecnico = new JPanel();
			panelTecnico.setBackground(Colores.getBlancuzo());
			panelTecnico.setLayout(null);
			panelTecnico.add(getPalazatec());
			panelTecnico.add(getLblPlaza_1());
		}
		return panelTecnico;
	}


	////////////////////////////////LABELS Y TEXT FIELD  ////////////////////////////////////////////////////////////





















	private JLabel getLblNombreYApellidos() {
		if (lblNombreYApellidos == null) {
			lblNombreYApellidos = new JLabel("Nombre:");
			lblNombreYApellidos.setBounds(39, 102, 77, 30);
			lblNombreYApellidos.setForeground(Color.BLACK);
			lblNombreYApellidos.setFont(new Font("Modern No. 20", Font.PLAIN, 20));
			lblNombreYApellidos.setBackground(Color.WHITE);
		}
		return lblNombreYApellidos;
	}
	private JTextFieldString getNombre() {
		if (nombre == null) {
			nombre = new JTextFieldString();
			nombre.setBounds(297, 99, 245, 36);
			nombre.setFont(new Font("Tahoma", Font.PLAIN, 19));
			nombre.setColumns(10);
			nombre.setBackground(Color.WHITE);
		}
		return nombre;
	}
	private JLabel getLblCarnet() {
		if (lblCarnet == null) {
			lblCarnet = new JLabel("Carnet de Identidad:");
			lblCarnet.setBounds(39, 159, 195, 30);
			lblCarnet.setForeground(Color.BLACK);
			lblCarnet.setFont(new Font("Modern No. 20", Font.PLAIN, 20));
		}
		return lblCarnet;
	}
	private JTextFieldCarnet getCarnet() {
		if (carnet == null) {
			carnet = new JTextFieldCarnet();
			carnet.setBounds(297, 156, 245, 36);
			carnet.setFont(new Font("Tahoma", Font.PLAIN, 19));
			carnet.setColumns(10);
			carnet.setBackground(Color.WHITE);
		}
		return carnet;
	}



	//////////////////////////////// ADMINISTRATIVO ////////////////////////////////////////////////////////////
	private JLabel getLblPlazaAdmin() {
		if (lblPlazaAdmin == null) {
			lblPlazaAdmin = new JLabel("Plaza:");
			lblPlazaAdmin.setForeground(Color.BLACK);
			lblPlazaAdmin.setFont(new Font("Modern No. 20", Font.PLAIN, 20));
			lblPlazaAdmin.setBounds(0, 30, 88, 22);
		}
		return lblPlazaAdmin;
	}
	private JComboBox<Plaza> getPlazaAdmin() {
		if (plazaAdmin == null) {
			plazaAdmin = new JComboBox<Plaza>();
			plazaAdmin.setBackground(Color.WHITE);
			plazaAdmin.setFont(new Font("Tahoma", Font.PLAIN, 19));
			plazaAdmin.setBounds(258, 23, 245, 36);
			plazaAdmin.setModel(new DefaultComboBoxModel<>(Plaza.values()));


		}
		return plazaAdmin;
	}

	//////////////////////////////// DIRECTIVO ////////////////////////////////////////////////////////////

	private JLabel getLblDepartamento() {
		if (lblDepartamento == null) {
			lblDepartamento = new JLabel("Departamento:");
			lblDepartamento.setForeground(Color.BLACK);
			lblDepartamento.setFont(new Font("Modern No. 20", Font.PLAIN, 20));
			lblDepartamento.setBounds(0, 30, 190, 22);
		}
		return lblDepartamento;
	}
	private JTextField getDepaDirect() {
		if (DepaDirect == null) {
			DepaDirect = new JTextFieldString();
			DepaDirect.setBackground(Color.WHITE);
			DepaDirect.setFont(new Font("Tahoma", Font.PLAIN, 19));
			DepaDirect.setBounds(258, 23, 245, 36);
			DepaDirect.setColumns(10);

		}
		return DepaDirect;
	}
	private JLabel getLblCategoriaDocente() {
		if (lblCategoriaDocente == null) {
			lblCategoriaDocente = new JLabel("Categoria Docente:");
			lblCategoriaDocente.setForeground(Color.BLACK);
			lblCategoriaDocente.setFont(new Font("Modern No. 20", Font.PLAIN, 20));
			lblCategoriaDocente.setBounds(0, 144, 195, 30);
		}
		return lblCategoriaDocente;
	}
	private JLabel getLblCategoriaCientifica() {
		if (lblCategoriaCientifica == null) {
			lblCategoriaCientifica = new JLabel("Categoria Cient\u00EDfica:");
			lblCategoriaCientifica.setForeground(Color.BLACK);
			lblCategoriaCientifica.setFont(new Font("Modern No. 20", Font.PLAIN, 20));
			lblCategoriaCientifica.setBounds(0, 87, 195, 30);
		}
		return lblCategoriaCientifica;
	}
	private JLabel getLblTipoDeContrato() {
		if (lblTipoDeContrato == null) {
			lblTipoDeContrato = new JLabel("Tipo de contrato:");
			lblTipoDeContrato.setForeground(Color.BLACK);
			lblTipoDeContrato.setFont(new Font("Modern No. 20", Font.PLAIN, 20));
			lblTipoDeContrato.setBounds(0, 201, 195, 30);
		}
		return lblTipoDeContrato;
	}
	private JComboBox<TipoContrato> getContratodirect() {
		if (contratodirect == null) {
			contratodirect = new JComboBox<TipoContrato>();
			contratodirect.setBackground(Color.WHITE);
			contratodirect.setFont(new Font("Tahoma", Font.PLAIN, 19));
			contratodirect.setBounds(258, 196, 245, 36);
			contratodirect.setModel(new DefaultComboBoxModel<>(TipoContrato.values()));


		}
		return contratodirect;
	}

	private JLabel getLblCargoAdministrativo() {
		if (lblCargoAdministrativo == null) {
			lblCargoAdministrativo = new JLabel("Cargo de Direcci\u00F3n:");
			lblCargoAdministrativo.setForeground(Color.BLACK);
			lblCargoAdministrativo.setFont(new Font("Modern No. 20", Font.PLAIN, 20));
			lblCargoAdministrativo.setBounds(0, 360, 195, 30);
		}
		return lblCargoAdministrativo;
	}
	private JComboBox<CargoDirectivo> getCargoDirect() {
		if (cargoDirect == null) {
			cargoDirect = new JComboBox<CargoDirectivo>();
			cargoDirect.setBackground(Color.WHITE);
			cargoDirect.setFont(new Font("Tahoma", Font.PLAIN, 19));
			cargoDirect.setBounds(258, 357, 245, 36);
			cargoDirect.setModel(new DefaultComboBoxModel<>(CargoDirectivo.values()));


		}
		return cargoDirect;
	}
	private JLabel getLblreaDeTrabajo() {
		if (lblreaDeTrabajo == null) {
			lblreaDeTrabajo = new JLabel("\u00C1rea de trabajo:");
			lblreaDeTrabajo.setForeground(Color.BLACK);
			lblreaDeTrabajo.setFont(new Font("Modern No. 20", Font.PLAIN, 20));
			lblreaDeTrabajo.setBounds(0, 417, 195, 30);
		}
		return lblreaDeTrabajo;
	}
	private JComboBox<AreaDirectivo> getAreaDirect() {
		if (areaDirect == null) {
			areaDirect = new JComboBox<AreaDirectivo>();
			areaDirect.setBackground(Color.WHITE);
			areaDirect.setFont(new Font("Tahoma", Font.PLAIN, 19));
			areaDirect.setModel(new DefaultComboBoxModel<>(AreaDirectivo.values()));
			areaDirect.setBounds(258, 414, 245, 36);

		}
		return areaDirect;
	}
	private JTextFieldString getCatDocDirec() {
		if (catDocDirec == null) {
			catDocDirec = new JTextFieldString();
			catDocDirec.setBackground(Color.WHITE);
			catDocDirec.setFont(new Font("Tahoma", Font.PLAIN, 19));
			catDocDirec.setBounds(258, 141, 245, 36);

		}
		return catDocDirec;
	}
	private JTextFieldString getCatCientdirec() {
		if (catCientdirec == null) {
			catCientdirec = new JTextFieldString();
			catCientdirec.setBackground(Color.WHITE);
			catCientdirec.setFont(new Font("Tahoma", Font.PLAIN, 19));
			catCientdirec.setBounds(258, 83, 245, 36);

		}
		return catCientdirec;
	}


	////////////////////////////////TECNICO  ////////////////////////////////////////////////////////////
	private JTextFieldString getPalazatec() {
		if (palazatec == null) {
			palazatec = new JTextFieldString();
			palazatec.setBackground(Color.WHITE);
			palazatec.setFont(new Font("Tahoma", Font.PLAIN, 19));
			palazatec.setBounds(258, 20, 245, 36);


		}
		return palazatec;
	}
	private JLabel getLblPlaza_1() {
		if (lblPlaza_1 == null) {
			lblPlaza_1 = new JLabel("Plaza:");
			lblPlaza_1.setForeground(Color.BLACK);
			lblPlaza_1.setFont(new Font("Modern No. 20", Font.PLAIN, 20));
			lblPlaza_1.setBounds(0, 30, 56, 16);
		}
		return lblPlaza_1;
	}

	//////////////////////////////// ESTUDIANTE ////////////////////////////////////////////////////////////
	private JComboBox<String> getAnnoEst() {
		if (AnnoEst == null) {
			AnnoEst = new JComboBox<String>();
			AnnoEst.setForeground(Color.BLACK);
			AnnoEst.setBackground(Color.WHITE);
			AnnoEst.setFont(new Font("Tahoma", Font.PLAIN, 19));
			AnnoEst.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4"}));
			AnnoEst.setBounds(258, 27, 62, 36);

		}
		return AnnoEst;
	}
	private JLabel getLblAo() {
		if (lblAo == null) {
			lblAo = new JLabel("A\u00F1o:");
			lblAo.setForeground(Color.BLACK);
			lblAo.setFont(new Font("Modern No. 20", Font.PLAIN, 20));
			lblAo.setBounds(0, 30, 77, 30);
		}
		return lblAo;
	}
	private JLabel getLblGrupo() {
		if (lblGrupo == null) {
			lblGrupo = new JLabel("Grupo:");
			lblGrupo.setForeground(Color.BLACK);
			lblGrupo.setFont(new Font("Modern No. 20", Font.PLAIN, 20));
			lblGrupo.setBounds(0, 87, 77, 30);
		}
		return lblGrupo;
	}
	private JTextField getGrupoEst() {
		if (grupoEst == null) {
			grupoEst = new JTextFieldGrupo();
			grupoEst.setBackground(Color.WHITE);
			grupoEst.setFont(new Font("Tahoma", Font.PLAIN, 19));
			grupoEst.setBounds(258, 84, 62, 36);
			grupoEst.setColumns(10);

		}
		return grupoEst;
	}

	//////////////////////////////// ESPECIALISTA  ////////////////////////////////////////////////////////////

	private JTextFieldString getTFproyectoEsp() {
		if (TFproyectoEsp == null) {
			TFproyectoEsp = new JTextFieldString();
			TFproyectoEsp.setBackground(Color.WHITE);
			TFproyectoEsp.setFont(new Font("Tahoma", Font.PLAIN, 19));
			TFproyectoEsp.setBounds(258, 27, 245, 36);


		}
		return TFproyectoEsp;
	}
	private JLabel getLblProyecto() {
		if (lblProyecto == null) {
			lblProyecto = new JLabel("Proyecto:");
			lblProyecto.setForeground(Color.BLACK);
			lblProyecto.setFont(new Font("Modern No. 20", Font.PLAIN, 20));
			lblProyecto.setBounds(0, 30, 195, 30);
		}
		return lblProyecto;
	}


	//////////////////////////////// PROFESOR  ////////////////////////////////////////////////////////////
	private JLabel getDepap() {
		if (depap == null) {
			depap = new JLabel("Departamento:");
			depap.setForeground(Color.BLACK);
			depap.setFont(new Font("Modern No. 20", Font.PLAIN, 20));
			depap.setBounds(0, 30, 195, 30);
		}
		return depap;
	}
	private JTextFieldString getDepaProfesor() {
		if (DepaProfesor == null) {
			DepaProfesor = new JTextFieldString();
			DepaProfesor.setBackground(Color.WHITE);
			DepaProfesor.setFont(new Font("Dialog", Font.PLAIN, 19));
			DepaProfesor.setColumns(10);
			DepaProfesor.setBounds(258, 27, 245, 36);

		}
		return DepaProfesor;
	}
	private JLabel getCatDocP() {
		if (catDocP == null) {
			catDocP = new JLabel("Categor\u00EDa Docente:");
			catDocP.setForeground(Color.BLACK);
			catDocP.setFont(new Font("Modern No. 20", Font.PLAIN, 20));
			catDocP.setBounds(0, 144, 195, 30);
		}
		return catDocP;
	}
	private JTextFieldString getCatDocProfesor() {
		if (catDocProfesor == null) {
			catDocProfesor = new JTextFieldString();
			catDocProfesor.setBackground(Color.WHITE);
			catDocProfesor.setFont(new Font("Dialog", Font.PLAIN, 19));
			catDocProfesor.setBounds(258, 140, 245, 36);

		}
		return catDocProfesor;
	}
	private JLabel getCatCP() {
		if (catCP == null) {
			catCP = new JLabel("Categor\u00EDa Cient\u00EDfica:");
			catCP.setForeground(Color.BLACK);
			catCP.setFont(new Font("Modern No. 20", Font.PLAIN, 20));
			catCP.setBounds(0, 87, 195, 30);
		}
		return catCP;
	}
	private JTextFieldString getCatCientProfesor() {
		if (catCientProfesor == null) {
			catCientProfesor = new JTextFieldString();
			catCientProfesor.setBackground(Color.WHITE);
			catCientProfesor.setFont(new Font("Dialog", Font.PLAIN, 19));
			catCientProfesor.setBounds(258, 84, 245, 36);

		}
		return catCientProfesor;
	}
	private JLabel getTipocontratop() {
		if (tipocontratop == null) {
			tipocontratop = new JLabel("Tipo de contrato:");
			tipocontratop.setForeground(Color.BLACK);
			tipocontratop.setFont(new Font("Modern No. 20", Font.PLAIN, 20));
			tipocontratop.setBounds(0, 201, 195, 30);
		}
		return tipocontratop;
	}
	private JComboBox<TipoContrato> getContratoProfesor() {
		if (contratoProfesor == null) {
			contratoProfesor = new JComboBox<TipoContrato>();
			contratoProfesor.setBackground(Color.WHITE);
			contratoProfesor.setFont(new Font("Dialog", Font.PLAIN, 19));
			contratoProfesor.setModel(new DefaultComboBoxModel<>(TipoContrato.values()));
			contratoProfesor.setBounds(258, 198, 245, 36);

		}
		return contratoProfesor;
	}

	////////////////////////////////BOTON CERRAR  ////////////////////////////////////////////////////////////


	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("");
			UIManager.put("ToolTip.background", Color.WHITE);
			UIManager.put("ToolTip.foreground", Color.BLACK);
			UIManager.put("ToolTip.font", new Font("Segoe UI", Font.PLAIN, 16));

			btnNewButton_1.setToolTipText("Cerrar");

			btnNewButton_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(java.awt.event.MouseEvent arg0) {
					btnNewButton_1.setBackground(new Color(220, 53, 69));
					btnNewButton_1.setForeground(Color.WHITE);
					btnNewButton_1.setText("");
				}
				@Override
				public void mouseExited(java.awt.event.MouseEvent arg0) {
					btnNewButton_1.setBackground(new Color(240, 240, 240));
					btnNewButton_1.setForeground(Color.BLACK);
					btnNewButton_1.setText("");
				}
			});
			btnNewButton_1.setContentAreaFilled(false);
			btnNewButton_1.setBounds(1187, 0, 47, 46);
			btnNewButton_1.setOpaque(true);
			btnNewButton_1.setBorder(null);
			btnNewButton_1.setBackground(new Color(240, 240, 240));
			btnNewButton_1.setForeground(Color.BLACK);
			btnNewButton_1.setFocusPainted(false);
			btnNewButton_1.setFont(new Font("Segoe UI", Font.PLAIN, 28));
			btnNewButton_1.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));

			btnNewButton_1.setIcon(new ImageIcon(TablaReporte1.class.getResource("/images/close.png")));
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
		}
		return btnNewButton_1;
	}

	////////////////////////////////BOTON EDITAR  ////////////////////////////////////////////////////////////

	private JButton getBtnEditar() {
		if (btnEditar == null) {
			btnEditar = new JButton("Editar");
			btnEditar.setForeground(Color.BLACK);
			btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 17));
			btnEditar.setBounds(155, 577, 113, 30);
			btnEditar.setBackground(Color.WHITE);

			btnEditar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					editando = true;
					tablepers.setEnabled(false);
					btnGuardarCambios.setVisible(true);
					btnCancelar.setVisible(true);
					btnEliminar.setVisible(false);
					AnnoEst.setEnabled(true);
					AnnoEst.setForeground(Color.BLACK);
					grupoEst.setEditable(true);

					nombre.setEditable(true);
					carnet.setEditable(true);


					cargoDirect.setEnabled(true);
					catDocDirec.setEditable(true);
					catCientdirec.setEditable(true);
					areaDirect.setEnabled(true);
					DepaDirect.setEditable(true);
					contratodirect.setEnabled(true);

					catDocProfesor.setEditable(true);
					catCientProfesor.setEditable(true);
					contratoProfesor.setEnabled(true);
					DepaProfesor.setEditable(true);

					plazaAdmin.setEnabled(true);

					palazatec.setEditable(true);

					TFproyectoEsp.setEditable(true);
					btnEliminar.setEnabled(false);
					btnEditar.setVisible(false);



				}
			});

			btnEditar.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {

					btnEditar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
				}
				public void mouseExited(MouseEvent e) {

					btnEditar.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
				}
			});
		}
		return btnEditar;
	}
	//////////////////////////////// BOTON ELIMINAR ////////////////////////////////////////////////////////////			
	private JButton getBtnEliminar() {
		if (btnEliminar == null) {
			btnEliminar = new JButton("Eliminar");
			btnEliminar.setForeground(Color.BLACK);
			btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 17));
			btnEliminar.setBounds(320, 577, 113, 30);
			btnEliminar.setBackground(Color.WHITE);
			btnEliminar.setIcon(null);

			btnEliminar.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int confirm = JOptionPane.showConfirmDialog(null, "¿Eliminar esta persona?", "Confirmar", JOptionPane.YES_NO_OPTION);
					if (confirm == JOptionPane.YES_OPTION) {
						if(!fac.verificarRegistrosActivos(null, fac.getPersonal().get(row))){
							fac.getPersonal().remove(row);
							tablemodel.setRowCount(0);
							tablemodel.cargarInfo(fac.getPersonal());
							JOptionPane.showMessageDialog(VerPersonal.this, "Usuario eliminado con éxito", "Eliminacion exitosa", JOptionPane.INFORMATION_MESSAGE);

						}
						else
							JOptionPane.showMessageDialog(VerPersonal.this, "Hay registros de entrada sobre esta persona sin salida registrada", "Error al eliminar", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			btnEliminar.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {

					btnEliminar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
				}
				public void mouseExited(MouseEvent e) {

					btnEliminar.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
				}
			});
		}
		return btnEliminar;
	}

	private JLabel getLblCargo() {
		if (lblCargo == null) {
			lblCargo = new JLabel("Cargo:");
			lblCargo.setForeground(Color.BLACK);
			lblCargo.setFont(new Font("Modern No. 20", Font.PLAIN, 20));
			lblCargo.setBackground(Color.WHITE);
			lblCargo.setBounds(39, 37, 77, 30);
		}
		return lblCargo;

	}


	//////////////////////////////// BOTON GUARDAR  ////////////////////////////////////////////////////////////
	private JButton getBtnGuardarCambios() {
		if (btnGuardarCambios == null) {


			btnGuardarCambios = new JButton("Aceptar");
			btnGuardarCambios.setForeground(Color.BLACK);
			btnGuardarCambios.setBounds(152, 576, 119, 30);
			btnGuardarCambios.setBackground(Color.WHITE);
			btnGuardarCambios.setFocusPainted(false);
			btnGuardarCambios.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnGuardarCambios.setVisible(false);



			btnGuardarCambios.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					boolean listo = false;

					if(!eleccionCrear.isVisible())
						listo = crearPersona(fac.getPersonal().get(row));
					else
						listo = crearPersona(null);

					if(listo){
						editando = false;

						AnnoEst.setEnabled(false);
						grupoEst.setEditable(false);
						nombre.setEditable(false);
						carnet.setEditable(false);


						cargoDirect.setEnabled(false);
						catDocDirec.setEditable(false);
						catCientdirec.setEditable(false);
						areaDirect.setEnabled(false);
						DepaDirect.setEditable(false);
						contratodirect.setEnabled(false);

						catDocProfesor.setEditable(false);
						catCientProfesor.setEditable(false);
						contratoProfesor.setEnabled(false);
						DepaProfesor.setEditable(false);

						plazaAdmin.setEnabled(false);

						palazatec.setEditable(false);

						TFproyectoEsp.setEditable(false);
						btnGuardarCambios.setVisible(false);
						btnCancelar.setVisible(false);
						btnEliminar.setVisible(true);
						btnEliminar.setEnabled(true);
						btnEditar.setVisible(true);

						tablemodel.setRowCount(0);
						tablemodel.cargarInfo(fac.getPersonal());
						JOptionPane.showMessageDialog(VerPersonal.this, "Informacion añadida con éxito", "Edición exitosa", JOptionPane.INFORMATION_MESSAGE);

					}
				}

			});

			btnGuardarCambios.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(java.awt.event.MouseEvent arg0) {
					btnGuardarCambios.setBackground(verdeHover);
					btnGuardarCambios.setForeground(Color.WHITE);
					btnGuardarCambios.setText("Aceptar");
				}
				@Override
				public void mouseExited(java.awt.event.MouseEvent arg0) {
					btnGuardarCambios.setBackground(Color.WHITE);
					btnGuardarCambios.setForeground(Color.BLACK);
					btnGuardarCambios.setText("Aceptar");
				}
			});
		}
		return btnGuardarCambios;
	}

	//////////////////////////////// BOTON CANCELAR  ////////////////////////////////////////////////////////////
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setForeground(Color.BLACK);
			btnCancelar.setBounds(317, 576, 119, 30);
			btnCancelar.setBackground(Color.WHITE);
			btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnCancelar.setVisible(false);

			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {


					int confirm = JOptionPane.showConfirmDialog(null, "¿Desea cancelar sin guardar los cambios?", "Confirmar", JOptionPane.YES_NO_OPTION);
					if (confirm == JOptionPane.YES_OPTION) {
						editando = false;
						panelVisible(fac.getPersonal().get(row));
						btnGuardarCambios.setVisible(false);
						btnCancelar.setVisible(false);
						btnEliminar.setVisible(true);
						btnEliminar.setEnabled(true);
						btnEditar.setVisible(true);
						errores.setVisible(false);
						lblAo.setForeground(Color.BLACK);
						lblGrupo.setForeground(Color.BLACK);
						lblProyecto.setForeground(Color.BLACK);
						lblPlazaAdmin.setForeground(Color.BLACK);
						lblCargoAdministrativo.setForeground(Color.BLACK);
						lblCarnet.setForeground(Color.BLACK);
						lblCategoriaCientifica.setForeground(Color.BLACK);
						lblCategoriaDocente.setForeground(Color.BLACK);
						catDocP.setForeground(Color.BLACK);
						depap.setForeground(Color.BLACK);
						catCP.setForeground(Color.BLACK);
						lblDepartamento.setForeground(Color.BLACK);
						lblNombreYApellidos.setForeground(Color.BLACK);
						lblPlaza_1.setForeground(Color.BLACK);
						lblreaDeTrabajo.setForeground(Color.BLACK);
						lblTipoDeContrato.setForeground(Color.BLACK);

					}
				}
			});
			btnCancelar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(java.awt.event.MouseEvent arg0) {
					btnCancelar.setBackground(new Color(220, 53, 69));
					btnCancelar.setForeground(Color.WHITE);
					btnCancelar.setText("Cancelar");
				}
				@Override
				public void mouseExited(java.awt.event.MouseEvent arg0) {
					btnCancelar.setBackground(Color.WHITE);
					btnCancelar.setForeground(Color.BLACK);
					btnCancelar.setText("Cancelar");
				}
			});
		}
		return btnCancelar;
	}

	private JLabel getErrores() {
		if (errores == null) {
			errores = new JLabel("Faltan campos por llenar o est\u00E1n incorrectos");
			errores.setForeground(Color.RED);
			errores.setVisible(true);
			errores.setFont(new Font("Tahoma", Font.PLAIN, 20));
			errores.setForeground(Color.RED);
			errores.setBounds(99, 541, 443, 22);
		}
		return errores;
	}

	//////////////////////////////// ELECCION PARA CREAR O EDITAR ////////////////////////////////////////////////////////////
	public boolean crearPersona(Persona per){
		boolean hecho= false;
		if(per instanceof Administrativo || per == null && eleccionCrear.getSelectedItem().equals("Administrativo")){
			hecho = crearAdministrativo();
		}
		else if(per instanceof Directivo || per == null && eleccionCrear.getSelectedItem().equals("Directivo")){
			hecho = crearDirectivo();
		}
		else if(per instanceof Estudiante || per == null && eleccionCrear.getSelectedItem().equals("Estudiante")){
			hecho = crearEstudiante();
		}
		else if(per instanceof Especialista || per == null && eleccionCrear.getSelectedItem().equals("Especialista")){
			hecho = crearEspecialista();
		}
		else if(per instanceof Tecnico || per == null && eleccionCrear.getSelectedItem().equals("Tecnico")){
			hecho = crearTecnico();
		}
		else if(per instanceof Profesor || per == null && eleccionCrear.getSelectedItem().equals("Profesor")){
			hecho = crearProfesor();}

		return hecho;
	}


	//////////////////////////////// CREAR ESTUDIANTE  ////////////////////////////////////////////////////////////
	public boolean crearEstudiante(){
		String nom = nombre.getText();
		String carn = carnet.getText();
		String anno = AnnoEst.getSelectedItem().toString();
		String grup= grupoEst.getText();
		Estudiante est = new Estudiante();
		boolean bien = false;;
		Persona existente =  fac.buscarPersonaCi(carn);
		Persona editar = fac.getPersonal().get(row);

		if(verificarExistenciNombreyCarnet(carn, existente,est, nom)){
			bien= true;
		}else{
			errores.setText("Faltan campos por llenar o están incorrectos");
			errores.setVisible(true);
		}
		try{
			errores.setVisible(false);
			est.setAnio(Integer.parseInt(anno));
			lblAo.setForeground(Color.BLACK);
		}
		catch (IllegalArgumentException e){
			errores.setText("Faltan campos por llenar o están incorrectos");
			errores.setVisible(true);
			lblAo.setForeground(Color.RED);
			bien = false;	
		}

		try{
			errores.setVisible(false);
			lblGrupo.setForeground(Color.BLACK);
			est.setGrupo(Integer.parseInt(grup));
		}
		catch (IllegalArgumentException e){
			errores.setText("Faltan campos por llenar o están incorrectos");
			errores.setVisible(true);
			lblGrupo.setForeground(Color.RED);
			bien = false;	
		}




		if(bien && eleccionCrear.isVisible()){
			fac.addEstudiante(est.getNombre(), est.getNumeroIdentidad(), est.getAnio(), est.getGrupo());
		}

		else if (bien && !eleccionCrear.isVisible()){
			editar.setNombre(est.getNombre());
			editar.setNumeroIdentidad(est.getNumeroIdentidad());
			((Estudiante)editar).setAnio(est.getAnio());
			((Estudiante)editar).setGrupo(est.getGrupo());
		}
		return bien;

	}

	//////////////////////////////// CREAR ESPECIALISTA  ////////////////////////////////////////////////////////////
	public boolean crearEspecialista(){
		String nom = nombre.getText();
		String carn = carnet.getText();
		String proyecto = TFproyectoEsp.getText();
		Especialista est = new Especialista();

		boolean bien = false;;
		Persona existente =  fac.buscarPersonaCi(carn);
		Persona editar = fac.getPersonal().get(row);


		if(verificarExistenciNombreyCarnet(carn, existente,est, nom)){
			bien= true;		

		}else{
			errores.setText("Faltan campos por llenar o están incorrectos");
			errores.setVisible(true);
		}
		try{
			errores.setVisible(false);
			lblProyecto.setForeground(Color.BLACK);
			est.setProyecto(proyecto);
		}
		catch (IllegalArgumentException e){
			errores.setText("Faltan campos por llenar o están incorrectos");
			errores.setVisible(true);
			lblProyecto.setForeground(Color.RED);
			bien = false;	
		}

		if(bien && eleccionCrear.isVisible()){
			fac.addEspecialista(est.getNombre(), est.getNumeroIdentidad(), est.getProyecto());
		}

		else if (bien && !eleccionCrear.isVisible()){
			editar.setNombre(est.getNombre());
			editar.setNumeroIdentidad(est.getNumeroIdentidad());
			((Especialista)editar).setProyecto(est.getProyecto());

		}
		return bien;

	}


	//////////////////////////////// CREAR ADMINISTRATIVO ////////////////////////////////////////////////////////////

	public boolean crearAdministrativo(){
		String nom = nombre.getText();
		String carn = carnet.getText();
		Administrativo est = new Administrativo();

		boolean bien = false;;
		Persona existente =  fac.buscarPersonaCi(carn);
		Persona editar = fac.getPersonal().get(row);
		Plaza plaza = (Plaza) plazaAdmin.getSelectedItem();


		if(verificarExistenciNombreyCarnet(carn, existente,est,nom)){
			bien= true;

		}else{
			errores.setText("Faltan campos por llenar o están incorrectos");
			errores.setVisible(true);
		}
		try{
			lblPlazaAdmin.setForeground(Color.BLACK);
			errores.setVisible(false);
			est.setPlaza(plaza);
		}
		catch (IllegalArgumentException e){
			errores.setText("Faltan campos por llenar o están incorrectos");
			errores.setVisible(true);
			lblPlazaAdmin.setForeground(Color.RED);
			bien = false;	
		}

		if(bien && eleccionCrear.isVisible()){
			fac.addAdministrativo(est.getNombre(), est.getNumeroIdentidad(), est.getPlaza());;// cambiar estoooo
		}

		else if (bien && !eleccionCrear.isVisible()){
			editar.setNombre(est.getNombre());
			editar.setNumeroIdentidad(est.getNumeroIdentidad());
			((Administrativo)editar).setPlaza(est.getPlaza());

		}
		return bien;

	}
	//////////////////////////////// CREAR TECNICO  ////////////////////////////////////////////////////////////
	public boolean crearTecnico(){
		String nom = nombre.getText();
		String carn = carnet.getText();
		Tecnico est = new Tecnico();
		Persona editar = fac.getPersonal().get(row);
		boolean bien = false;;
		Persona existente =  fac.buscarPersonaCi(carn);
		String plaza = palazatec.getText();

		if(verificarExistenciNombreyCarnet(carn, existente,est,nom)){
			bien= true;

		}else{
			errores.setText("Faltan campos por llenar o están incorrectos");
			errores.setVisible(true);
		}

		try{
			est.setPlaza(plaza);
			errores.setVisible(false);
			lblPlaza_1.setForeground(Color.BLACK);
		}
		catch (IllegalArgumentException e){
			errores.setText("Faltan campos por llenar o están incorrectos");
			errores.setVisible(true);
			lblPlaza_1.setForeground(Color.RED);
			bien = false;	

		}
		if(bien && eleccionCrear.isVisible()){
			fac.addTecnico(est.getNombre(), est.getNumeroIdentidad(), est.getPlaza());
		}

		else if (bien && !eleccionCrear.isVisible()){
			editar.setNombre(est.getNombre());
			editar.setNumeroIdentidad(est.getNumeroIdentidad());
			((Tecnico)editar).setPlaza(est.getPlaza());

		}
		return bien;

	}
	//////////////////////////////// CREAR PROFESOR  ////////////////////////////////////////////////////////////
	public boolean crearProfesor(){
		String nom = nombre.getText();
		String carn = carnet.getText();
		Profesor est = new Profesor();
		boolean bien = false;;
		Persona editar = fac.getPersonal().get(row);
		Persona existente =  fac.buscarPersonaCi(carn);
		String depa = DepaProfesor.getText();
		String catD = catDocProfesor.getText();
		String catcien = catCientProfesor.getText();
		TipoContrato contr = (TipoContrato) contratoProfesor.getSelectedItem();




		if(verificarExistenciNombreyCarnet(carn, existente,est,nom)){
			bien= true;

		}else{
			errores.setText("Faltan campos por llenar o están incorrectos");
			errores.setVisible(true);
		}
		try {
			errores.setVisible(false);
			est.setCatCient(catcien);
			catCP.setForeground(Color.BLACK);

		}
		catch (IllegalArgumentException e){
			errores.setText("Faltan campos por llenar o están incorrectos");
			errores.setVisible(true);
			catCP.setForeground(Color.RED);
			bien = false;	
		}

		try{
			errores.setVisible(false);
			est.setCatDoc(catD);
			catDocP.setForeground(Color.BLACK);

		}
		catch (IllegalArgumentException e){
			errores.setText("Faltan campos por llenar o están incorrectos");
			errores.setVisible(true);
			catDocP.setForeground(Color.RED);
			bien = false;	
		}

		try{
			errores.setVisible(false);
			est.setTipoContrato(contr);
			tipocontratop.setForeground(Color.BLACK);

		}
		catch (IllegalArgumentException e){
			errores.setText("Faltan campos por llenar o están incorrectos");
			errores.setVisible(true);
			tipocontratop.setForeground(Color.RED);
			bien = false;	
		}

		try{
			errores.setVisible(false);
			est.setDepartamento(depa);
			depap.setForeground(Color.BLACK);

		}
		catch (IllegalArgumentException e){
			errores.setText("Faltan campos por llenar o están incorrectos");
			errores.setVisible(true);
			depap.setForeground(Color.RED);
			bien = false;	
		}

		if(bien && eleccionCrear.isVisible()){
			fac.addProfesor(est.getNombre(), est.getNumeroIdentidad(),  est.getDepartamento(), est.getCatDoc(), est.getCatCient(), est.getTipoContrato());
		}

		else if (bien && !eleccionCrear.isVisible()){
			editar.setNombre(est.getNombre());
			editar.setNumeroIdentidad(est.getNumeroIdentidad());
			((Profesor)editar).setCatCient(est.getCatCient());
			((Profesor)editar).setCatDoc(est.getCatDoc());
			((Profesor)editar).setDepartamento(est.getDepartamento());
			((Profesor)editar).setTipoContrato(est.getTipoContrato());

		}
		return bien;

	}







	//////////////////////////////// CREAR DIRECTIVO  ////////////////////////////////////////////////////////////
	public boolean crearDirectivo(){
		String nom = nombre.getText();
		String carn = carnet.getText();
		Directivo est = new Directivo();
		boolean bien = false;
		Persona editar = fac.getPersonal().get(row);
		Persona existente =  fac.buscarPersonaCi(carn);
		String depa = DepaDirect.getText();
		String catD = catCientdirec.getText();
		String catcien = catCientdirec.getText();
		TipoContrato contr = (TipoContrato) contratodirect.getSelectedItem();
		AreaDirectivo area = (AreaDirectivo) areaDirect.getSelectedItem();
		CargoDirectivo cargo = (CargoDirectivo) cargoDirect.getSelectedItem();


		if(verificarExistenciNombreyCarnet(carn, existente,est,nom)){
			bien= true;

		}else{
			errores.setText("Faltan campos por llenar o están incorrectos");
			errores.setVisible(true);
		}
		try {
			errores.setVisible(false);
			est.setCatCient(catcien);
			lblCategoriaCientifica.setForeground(Color.BLACK);

		}
		catch (IllegalArgumentException e){
			errores.setText("Faltan campos por llenar o están incorrectos");
			errores.setVisible(true);
			lblCategoriaCientifica.setForeground(Color.RED);
			bien = false;	
		}

		try{
			errores.setVisible(false);
			est.setCatDoc(catD);
			lblCategoriaDocente.setForeground(Color.BLACK);

		}
		catch (IllegalArgumentException e){
			errores.setText("Faltan campos por llenar o están incorrectos");
			errores.setVisible(true);
			lblCategoriaDocente.setForeground(Color.RED);
			bien = false;	
		}

		try{
			errores.setVisible(false);
			est.setTipoContrato(contr);
			lblTipoDeContrato.setForeground(Color.BLACK);

		}
		catch (IllegalArgumentException e){
			errores.setText("Faltan campos por llenar o están incorrectos");
			errores.setVisible(true);
			lblTipoDeContrato.setForeground(Color.RED);
			bien = false;	
		}

		try{
			errores.setVisible(false);
			est.setDepartamento(depa);
			lblDepartamento.setForeground(Color.BLACK);

		}
		catch (IllegalArgumentException e){
			errores.setText("Faltan campos por llenar o están incorrectos");
			errores.setVisible(true);
			lblDepartamento.setForeground(Color.RED);
			bien = false;	
		}

		try{
			errores.setVisible(false);
			est.setArea(area);
			lblreaDeTrabajo.setForeground(Color.BLACK);

		}
		catch (IllegalArgumentException e){
			errores.setText("Faltan campos por llenar o están incorrectos");
			errores.setVisible(true);
			lblreaDeTrabajo.setForeground(Color.RED);
			bien = false;	
		}

		try{
			errores.setVisible(false);
			est.setCargo(cargo);
			lblCargoAdministrativo.setForeground(Color.BLACK);

		}
		catch (IllegalArgumentException e){
			errores.setText("Faltan campos por llenar o están incorrectos");
			errores.setVisible(true);
			lblCargoAdministrativo.setForeground(Color.RED);
			bien = false;	
		}

		if(bien && eleccionCrear.isVisible()){
			fac.addDirectivo(est.getNombre(), est.getNumeroIdentidad(),  est.getDepartamento(), est.getCatDoc(), est.getCatCient(), est.getTipoContrato(), est.getCargo(), est.getArea());
		}

		else if (bien && !eleccionCrear.isVisible()){
			editar.setNombre(est.getNombre());
			editar.setNumeroIdentidad(est.getNumeroIdentidad());
			((Directivo)editar).setCatCient(est.getCatCient());
			((Directivo)editar).setCatDoc(est.getCatDoc());
			((Directivo)editar).setDepartamento(est.getDepartamento());
			((Directivo)editar).setTipoContrato(est.getTipoContrato());
			((Directivo)editar).setArea(est.getArea());
			((Directivo)editar).setCargo(est.getCargo());
		}

		return bien;
	}

	public boolean verificarExistenciNombreyCarnet(String carn, Persona existente, Persona est, String nom){

		boolean bien = true;

		if(eleccionCrear.isVisible() && existente!= null){
			bien = false;
			errores.setText("La persona ya existe");
			lblCarnet.setForeground(Color.RED);
			errores.setVisible(true);
		}
		else if(!eleccionCrear.isVisible() && existente!= null && !fac.getPersonal().get(row).getNumeroIdentidad().equals(carn)){
			bien = false;
			errores.setText("Existe un usuario registrado con ese carnet");
			errores.setVisible(true);
			lblCarnet.setForeground(Color.RED);
		}
		else
		{
			lblCarnet.setForeground(Color.BLACK);
			try{
				est.setNumeroIdentidad(carn);
				errores.setVisible(false);
				lblCarnet.setForeground(Color.BLACK);
			}
			catch (IllegalArgumentException e){
				errores.setText("Faltan campos por llenar o están incorrectos");
				errores.setVisible(true);
				lblCarnet.setForeground(Color.RED);
				bien = false;	
			}
			try {
				est.setNombre(nom);
				lblNombreYApellidos.setForeground(Color.BLACK);
				errores.setVisible(false);
			}
			catch (IllegalArgumentException e){
				errores.setText("Faltan campos por llenar o están incorrectos");
				errores.setVisible(true);
				lblNombreYApellidos.setForeground(Color.RED);
				bien = false;	
			}
		}

		return bien;
	}




	//////////////////////////////// LLENAR   ////////////////////////////////////////////////////////////
	public void panelVisible (Persona per){
		if(per!=null){
			nombre.setText(per.getNombre());
			nombre.setEditable(false);
			carnet.setText(per.getNumeroIdentidad());
			carnet.setEditable(false);
		}

		if(per instanceof Administrativo || per == null && eleccionCrear.getSelectedItem().equals("Administrativo") ){
			card.show(panelGeneral, "Administrativo");

			if(per!=null){
				plazaAdmin.setSelectedItem(((Administrativo)per).getPlaza().toString());
				plazaAdmin.setEnabled(false);
			}
		}
		else if(per instanceof Directivo || per == null && eleccionCrear.getSelectedItem().equals("Directivo")){
			card.show(panelGeneral, "Directivo");
			if(per!=null){
				DepaDirect.setText(((Directivo)per).getDepartamento());
				DepaDirect.setEditable(false);
				contratodirect.setSelectedItem(((Directivo)per).getTipoContrato().toString());
				contratodirect.setEnabled(false);
				cargoDirect.setSelectedItem(((Directivo)per).getCargo().toString());
				cargoDirect.setEnabled(false);
				areaDirect.setSelectedItem(((Directivo)per).getArea().toString());
				areaDirect.setEnabled(false);
				catDocDirec.setText(((Directivo)per).getCatDoc());
				catDocDirec.setEditable(false);
				catCientdirec.setText(((Directivo)per).getCatCient());
				catCientdirec.setEditable(false);
			}
		}
		else if(per instanceof Estudiante ||  eleccionCrear.getSelectedItem().equals("Estudiante")){
			card.show(panelGeneral, "Estudiante");
			if(per!=null){
				nombre.setText(per.getNombre());
				nombre.setEditable(false);
				AnnoEst.setSelectedItem(((Estudiante)per).getAnio());
				AnnoEst.setEnabled(false);
				AnnoEst.setForeground(Color.LIGHT_GRAY);;
				grupoEst.setText(String.valueOf(((Estudiante)per).getGrupo()));
				grupoEst.setEditable(false);
			}
		}
		else if(per instanceof Especialista || per == null && eleccionCrear.getSelectedItem().equals("Especialista")){
			card.show(panelGeneral, "Especialista");
			if(per!=null){
				TFproyectoEsp.setText(((Especialista)per).getProyecto());
				TFproyectoEsp.setEditable(false);
			}
		}
		else if(per instanceof Tecnico || per == null && eleccionCrear.getSelectedItem().equals("Tecnico")){
			card.show(panelGeneral, "Tecnico");
			if(per!=null){
				palazatec.setText(((Tecnico)per).getPlaza());
				palazatec.setEditable(false);
			}
		}
		else if(per instanceof Profesor || per == null && eleccionCrear.getSelectedItem().equals("Profesor")){
			card.show(panelGeneral,"Profesor");
			if(per!=null){
				DepaProfesor.setText(((Profesor)per).getDepartamento());
				DepaProfesor.setEditable(false);
				catDocProfesor.setText(((Profesor)per).getCatDoc());
				catDocProfesor.setEditable(false);
				catCientProfesor.setText(((Profesor)per).getCatCient());
				catCientProfesor.setEditable(false);
				contratoProfesor.setSelectedItem(((Profesor)per).getTipoContrato().toString());
				contratoProfesor.setEnabled(false);
			}
		}
	}
}







