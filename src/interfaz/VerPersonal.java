package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
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

import util.ButtonRendererEditor;
import util.JTextFieldGrupo;
import util.MostrarPersonal;
import controllerClass.Facultad;
import enums.AreaDirectivo;
import enums.CargoDirectivo;
import enums.Plaza;
import enums.TipoContrato;

import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseAdapter;

import javax.swing.border.MatteBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.CardLayout;

import javax.swing.JLabel;
import javax.swing.JComboBox;

import personas.Administrativo;
import personas.Directivo;
import personas.Especialista;
import personas.Estudiante;
import personas.Persona;
import personas.Profesor;
import personas.Tecnico;
import util.JTextFieldString;
import util.JTextFieldCarnet;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VerPersonal extends JDialog {

	private final JPanel contentPanel;
	private JButton btnNewButton_1;
	private JTable tablepers;
	private Facultad fac;
	private MostrarPersonal tablemodel;
	int row;
	private JPanel panel;
	private JPanel panelGeneral;
	private JPanel panelAdmin;
	private JLabel lblPlazaAdmin;
	private JComboBox<Plaza> plazaAdmin;
//	private Persona per;
	private JLabel lblNombreYApellidos;
	private JTextFieldString nombre;
	private JLabel lblCarnet;
	private JTextFieldCarnet carnet;
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
	boolean editando ;


//	/**
//	 * Launch the application.
//	 */
	public static void main(String[] args) {
		try {
			VerPersonal dialog = new VerPersonal();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the dialog.
	 */
//	public VerPersonal(/*Inicio p*/) {
//		super(p,true);
//	 */
//	public static void main(String[] args) {
//		try {
//			VerPersonal dialog = new VerPersonal();
//			//dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//
////	/**
////	 * Create the dialog.
////	 */
	public VerPersonal(/*JFrame p*/) {
//		super(p,true);
		setBounds(100, 100, 1234, 609);
		fac = Facultad.getFacultad();
		contentPanel = new JPanel(){
			public void paintComponent(Graphics g){
				Image img= Toolkit.getDefaultToolkit().getImage(Inicio.class.getResource("/images/fondoDesenfocado.png"));
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};
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
		scrollPane.setBackground(Colores.getAzulCielo());
		scrollPane.getViewport().setBackground(Colores.getLogin());
		scrollPane.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
		scrollPane.setBounds(32, 103, 591, 631);
		contentPanel.add(scrollPane);
		
		tablepers = new JTable();
		
		
		
		tablemodel = new MostrarPersonal();
		
		
		scrollPane.setViewportView(tablepers);
		tablepers.setModel(tablemodel);
		tablepers.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tablepers.setRowHeight(29);
		tablepers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablepers.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 17));
		tablepers.setForeground(Color.WHITE);
		tablepers.setBackground(Colores.getAzulCielo());
		tablepers.setGridColor(Colores.getLogin());
		tablepers.getTableHeader().setBackground(Colores.getLogin());
		tablepers.setBorder(null);
		
		
				
		JButton btnagregar = new JButton("");
		btnagregar.setBackground(Color.LIGHT_GRAY);
		btnagregar.setIcon(new ImageIcon(VerPersonal.class.getResource("/images/icons8-add-user-male-50.png")));
		btnagregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				editando = true;
				btnGuardarCambios.setVisible(true);
				btnCancelar.setVisible(true);
				btnEliminar.setVisible(false);
				nombre.setEditable(true);
				nombre.setText("");
				AnnoEst.setEnabled(true);
				AnnoEst.setSelectedIndex(0);
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
		        
				panelVisible(null);
				eleccionCrear.setVisible(true);
				tablemodel.setRowCount(0);
				
				tablemodel.cargarInfo(fac.getPersonal());	
			}
		});
		btnagregar.setBounds(12, 13, 58, 59);
		contentPanel.add(btnagregar);
		contentPanel.add(getPanel());
	
		
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
				
					
									
				}
				else{
					tablepers.clearSelection();
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
		
		
		
		
	
		
//		btnNewButton_2 = new JButton("New button");
//		btnNewButton_2.setBounds(32, 36, 39, 23);
//		contentPanel.add(btnNewButton_2);
		
		tablepers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent arg0) {
//				CRUDVerPersonal pp= new CRUDVerPersonal(VerPersonal.this, fac.getPersonal().get(row), row);
//				pp.setVisible(true);
				if(!editando){
				panelVisible(fac.getPersonal().get(row));
				//llenarCrud(row);
				tablemodel.setRowCount(0);
				tablemodel.cargarInfo(fac.getPersonal());
				}
			}
				
		});
		

		tablemodel.cargarInfo(fac.getPersonal());
		
	}


	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("");
			btnNewButton_1.setContentAreaFilled(false);
			btnNewButton_1.setBounds(1164, 13, 58, 59);
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
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Colores.getAzulCielo());
			panel.setBounds(635, 103, 575, 631);
			panel.setLayout(null);
			
			panelGeneral = new JPanel();
			panelGeneral.setBackground(Colores.getAzulCielo());
			panelGeneral.setBounds(28, 187, 515, 330);
			panel.add(panelGeneral);
			panelGeneral.setLayout(card);
			
			panelAdmin = new JPanel();
			panelAdmin.setBackground(Colores.getAzulCielo());
			panelGeneral.add(panelAdmin, "Administrativo");
			panelAdmin.setLayout(null);
			panelAdmin.add(getLblPlazaAdmin());
			panelAdmin.add(getPlazaAdmin());
			panelAdmin.add(getErrores());

			
			panelDirectivo = new JPanel();
			panelDirectivo.setBackground(Colores.getAzulCielo());
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
			
			lblNombreYApellidos = new JLabel("Nombre:");
			lblNombreYApellidos.setForeground(Color.WHITE);
			lblNombreYApellidos.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNombreYApellidos.setBounds(49, 112, 77, 30);
			panel.add(lblNombreYApellidos);
			panel.add(getNombre());

			lblCarnet = new JLabel("Carnet de Identidad:");
			lblCarnet.setForeground(Color.WHITE);
			lblCarnet.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblCarnet.setBounds(299, 112, 195, 30);
			panel.add(lblCarnet);
			panel.add(getCarnet());
			panel.add(getEleccionCrear());
			panel.add(getBtnEliminar());
			panel.add(getBtnEditar());
			panel.add(getBtnGuardarCambios());
			panel.add(getBtnCancelar());
			
		}
		return panel;
	}
	private JLabel getLblPlazaAdmin() {
		if (lblPlazaAdmin == null) {
			lblPlazaAdmin = new JLabel("Plaza");
			lblPlazaAdmin.setForeground(Color.WHITE);
			lblPlazaAdmin.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblPlazaAdmin.setBounds(22, 30, 88, 22);
		}
		return lblPlazaAdmin;
	}
	private JComboBox<Plaza> getPlazaAdmin() {
		if (plazaAdmin == null) {
			plazaAdmin = new JComboBox<Plaza>();
			plazaAdmin.setFont(new Font("Tahoma", Font.PLAIN, 20));
			plazaAdmin.setBounds(22, 63, 180, 30);
			plazaAdmin.setModel(new DefaultComboBoxModel<>(Plaza.values()));
			

		}
		return plazaAdmin;
	}
	private JTextFieldString getNombre() {
		if (nombre == null) {
			nombre = new JTextFieldString();
			nombre.setFont(new Font("Tahoma", Font.PLAIN, 17));
			nombre.setBounds(49, 147, 180, 30);
			nombre.setColumns(10);
			
		}
		return nombre;
	}
	private JTextFieldCarnet getCarnet() {
		if (carnet == null) {
			carnet = new JTextFieldCarnet();
			carnet.setFont(new Font("Tahoma", Font.PLAIN, 17));
			carnet.setColumns(10);
			carnet.setBounds(299, 147, 195, 30);
			
		}
		return carnet;
	}
	
	private JLabel getLblDepartamento() {
		if (lblDepartamento == null) {
			lblDepartamento = new JLabel("Departamento");
			lblDepartamento.setForeground(Color.WHITE);
			lblDepartamento.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblDepartamento.setBounds(22, 30, 195, 30);
		}
		return lblDepartamento;
	}
	private JTextField getDepaDirect() {
		if (DepaDirect == null) {
			DepaDirect = new JTextFieldString();
			DepaDirect.setFont(new Font("Tahoma", Font.PLAIN, 17));
			DepaDirect.setBounds(22, 63, 180, 30);
			DepaDirect.setColumns(10);
			
		}
		return DepaDirect;
	}
	private JLabel getLblCategoriaDocente() {
		if (lblCategoriaDocente == null) {
			lblCategoriaDocente = new JLabel("Categoria Docente");
			lblCategoriaDocente.setForeground(Color.WHITE);
			lblCategoriaDocente.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblCategoriaDocente.setBounds(22, 128, 195, 30);
		}
		return lblCategoriaDocente;
	}
	private JLabel getLblCategoriaCientifica() {
		if (lblCategoriaCientifica == null) {
			lblCategoriaCientifica = new JLabel("Categoria Cientifica");
			lblCategoriaCientifica.setForeground(Color.WHITE);
			lblCategoriaCientifica.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblCategoriaCientifica.setBounds(22, 221, 195, 30);
		}
		return lblCategoriaCientifica;
	}
	private JLabel getLblTipoDeContrato() {
		if (lblTipoDeContrato == null) {
			lblTipoDeContrato = new JLabel("Tipo de contrato");
			lblTipoDeContrato.setForeground(Color.WHITE);
			lblTipoDeContrato.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblTipoDeContrato.setBounds(268, 30, 195, 30);
		}
		return lblTipoDeContrato;
	}
	private JComboBox<TipoContrato> getContratodirect() {
		if (contratodirect == null) {
			contratodirect = new JComboBox<TipoContrato>();
			contratodirect.setFont(new Font("Tahoma", Font.PLAIN, 20));
			contratodirect.setBounds(268, 63, 195, 30);
			contratodirect.setModel(new DefaultComboBoxModel<>(TipoContrato.values()));
			
			
		}
		return contratodirect;
	}
	
	private JLabel getLblCargoAdministrativo() {
		if (lblCargoAdministrativo == null) {
			lblCargoAdministrativo = new JLabel("Cargo de Direcci\u00F3n");
			lblCargoAdministrativo.setForeground(Color.WHITE);
			lblCargoAdministrativo.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblCargoAdministrativo.setBounds(268, 128, 195, 30);
		}
		return lblCargoAdministrativo;
	}
	private JComboBox<CargoDirectivo> getCargoDirect() {
		if (cargoDirect == null) {
			cargoDirect = new JComboBox<CargoDirectivo>();
			cargoDirect.setFont(new Font("Tahoma", Font.PLAIN, 20));
			cargoDirect.setBounds(268, 165, 195, 30);
			cargoDirect.setModel(new DefaultComboBoxModel<>(CargoDirectivo.values()));
			
			
		}
		return cargoDirect;
	}
	private JLabel getLblreaDeTrabajo() {
		if (lblreaDeTrabajo == null) {
			lblreaDeTrabajo = new JLabel("\u00C1rea de trabajo");
			lblreaDeTrabajo.setForeground(Color.WHITE);
			lblreaDeTrabajo.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblreaDeTrabajo.setBounds(268, 221, 195, 30);
		}
		return lblreaDeTrabajo;
	}
	private JComboBox<AreaDirectivo> getAreaDirect() {
		if (areaDirect == null) {
			areaDirect = new JComboBox<AreaDirectivo>();
			areaDirect.setFont(new Font("Tahoma", Font.PLAIN, 20));
			areaDirect.setModel(new DefaultComboBoxModel<>(AreaDirectivo.values()));
			areaDirect.setBounds(268, 258, 195, 30);
			
		}
		return areaDirect;
	}
	private JTextFieldString getCatDocDirec() {
		if (catDocDirec == null) {
			catDocDirec = new JTextFieldString();
			catDocDirec.setFont(new Font("Tahoma", Font.PLAIN, 17));
			catDocDirec.setBounds(22, 165, 180, 30);
			
		}
		return catDocDirec;
	}
	private JTextFieldString getCatCientdirec() {
		if (catCientdirec == null) {
			catCientdirec = new JTextFieldString();
			catCientdirec.setFont(new Font("Tahoma", Font.PLAIN, 17));
			catCientdirec.setBounds(22, 258, 180, 30);
			
		}
		return catCientdirec;
	}

	private JPanel getPanelProfesor() {
		if (panelProfesor == null) {
			panelProfesor = new JPanel();
			panelProfesor.setBackground(Colores.getAzulCielo());
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
	
	private JLabel getDepap() {
		if (depap == null) {
			depap = new JLabel("Departamento");
			depap.setForeground(Color.WHITE);
			depap.setFont(new Font("Tahoma", Font.PLAIN, 20));
			depap.setBounds(22, 30, 195, 30);
		}
		return depap;
	}
	private JTextFieldString getDepaProfesor() {
		if (DepaProfesor == null) {
			DepaProfesor = new JTextFieldString();
			DepaProfesor.setFont(new Font("Tahoma", Font.PLAIN, 17));
			DepaProfesor.setColumns(10);
			DepaProfesor.setBounds(22, 63, 180, 30);
			
		}
		return DepaProfesor;
	}
	private JLabel getCatDocP() {
		if (catDocP == null) {
			catDocP = new JLabel("Categoria Docente");
			catDocP.setForeground(Color.WHITE);
			catDocP.setFont(new Font("Tahoma", Font.PLAIN, 20));
			catDocP.setBounds(22, 128, 195, 30);
		}
		return catDocP;
	}
	private JTextFieldString getCatDocProfesor() {
		if (catDocProfesor == null) {
			catDocProfesor = new JTextFieldString();
			catDocProfesor.setFont(new Font("Tahoma", Font.PLAIN, 17));
			catDocProfesor.setBounds(22, 165, 180, 30);
			
		}
		return catDocProfesor;
	}
	private JLabel getCatCP() {
		if (catCP == null) {
			catCP = new JLabel("Categoria Cientifica");
			catCP.setForeground(Color.WHITE);
			catCP.setFont(new Font("Tahoma", Font.PLAIN, 20));
			catCP.setBounds(22, 221, 195, 30);
		}
		return catCP;
	}
	private JTextFieldString getCatCientProfesor() {
		if (catCientProfesor == null) {
			catCientProfesor = new JTextFieldString();
			catCientProfesor.setFont(new Font("Tahoma", Font.PLAIN, 17));
			catCientProfesor.setBounds(22, 258, 180, 30);
			
		}
		return catCientProfesor;
	}
	private JLabel getTipocontratop() {
		if (tipocontratop == null) {
			tipocontratop = new JLabel("Tipo de contrato");
			tipocontratop.setForeground(Color.WHITE);
			tipocontratop.setFont(new Font("Tahoma", Font.PLAIN, 20));
			tipocontratop.setBounds(270, 30, 195, 30);
		}
		return tipocontratop;
	}
	private JComboBox<TipoContrato> getContratoProfesor() {
		if (contratoProfesor == null) {
			contratoProfesor = new JComboBox<TipoContrato>();
			contratoProfesor.setFont(new Font("Tahoma", Font.PLAIN, 20));
			contratoProfesor.setModel(new DefaultComboBoxModel<>(TipoContrato.values()));
			contratoProfesor.setBounds(270, 63, 195, 30);
			
		}
		return contratoProfesor;
	}
	private JPanel getPanelEspecialista() {
		if (panelEspecialista == null) {
			panelEspecialista = new JPanel();
			panelEspecialista.setBackground(Colores.getAzulCielo());
			panelEspecialista.setLayout(null);
			panelEspecialista.add(getTFproyectoEsp());
			panelEspecialista.add(getLblProyecto());
		}
		return panelEspecialista;
	}
	
	private JTextFieldString getTFproyectoEsp() {
		if (TFproyectoEsp == null) {
			TFproyectoEsp = new JTextFieldString();
			TFproyectoEsp.setFont(new Font("Tahoma", Font.PLAIN, 17));
			TFproyectoEsp.setBounds(22, 63, 180, 30);
			
			
		}
		return TFproyectoEsp;
	}
	private JLabel getLblProyecto() {
		if (lblProyecto == null) {
			lblProyecto = new JLabel("Proyecto");
			lblProyecto.setForeground(Color.WHITE);
			lblProyecto.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblProyecto.setBounds(22, 30, 195, 30);
		}
		return lblProyecto;
	}
	private JPanel getPanelEstudiante() {
		if (panelEstudiante == null) {
			panelEstudiante = new JPanel();
			panelEstudiante.setBackground(Colores.getAzulCielo());
			panelEstudiante.setLayout(null);
			panelEstudiante.add(getAnnoEst());
			panelEstudiante.add(getLblAo());
			panelEstudiante.add(getLblGrupo());
			panelEstudiante.add(getGrupoEst());
		}
		return panelEstudiante;
	}
	
	private JComboBox<String> getAnnoEst() {
		if (AnnoEst == null) {
			AnnoEst = new JComboBox<String>();
			AnnoEst.setFont(new Font("Tahoma", Font.PLAIN, 20));
			AnnoEst.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4"}));
			AnnoEst.setBounds(22, 63, 62, 30);
			
		}
		return AnnoEst;
	}
	private JLabel getLblAo() {
		if (lblAo == null) {
			lblAo = new JLabel("A\u00F1o");
			lblAo.setForeground(Color.WHITE);
			lblAo.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblAo.setBounds(22, 30, 77, 30);
		}
		return lblAo;
	}
	private JLabel getLblGrupo() {
		if (lblGrupo == null) {
			lblGrupo = new JLabel("Grupo");
			lblGrupo.setForeground(Color.WHITE);
			lblGrupo.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblGrupo.setBounds(273, 30, 77, 30);
		}
		return lblGrupo;
	}
	private JTextField getGrupoEst() {
		if (grupoEst == null) {
			grupoEst = new JTextFieldGrupo();
			grupoEst.setFont(new Font("Tahoma", Font.PLAIN, 20));
			grupoEst.setBounds(273, 63, 62, 30);
			grupoEst.setColumns(10);
			
		}
		return grupoEst;
	}
	private JPanel getPanelTecnico() {
		if (panelTecnico == null) {
			panelTecnico = new JPanel();
			panelTecnico.setBackground(Colores.getAzulCielo());
			panelTecnico.setLayout(null);
			panelTecnico.add(getPalazatec());
			panelTecnico.add(getLblPlaza_1());
		}
		return panelTecnico;
	}
	
	private JTextFieldString getPalazatec() {
		if (palazatec == null) {
			palazatec = new JTextFieldString();
			palazatec.setBounds(22, 63, 180, 30);
			
			
		}
		return palazatec;
	}
	private JLabel getLblPlaza_1() {
		if (lblPlaza_1 == null) {
			lblPlaza_1 = new JLabel("Plaza");
			lblPlaza_1.setForeground(Color.WHITE);
			lblPlaza_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblPlaza_1.setBounds(22, 30, 56, 16);
		}
		return lblPlaza_1;
	}
	
	private JButton getBtnEditar() {
		if (btnEditar == null) {
			btnEditar = new JButton("Editar");
			btnEditar.setBounds(74, 81, 97, 25);
			btnEditar.setBackground(Color.LIGHT_GRAY);
			
			btnEditar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					editando = true;
					btnGuardarCambios.setVisible(true);
					btnCancelar.setVisible(true);
					btnEliminar.setVisible(false);
					nombre.setEditable(true);
					AnnoEst.setEnabled(true);
					carnet.setEditable(true);
					grupoEst.setEditable(true);
					
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
		}
		return btnEditar;
	}
	private JButton getBtnEliminar() {
		if (btnEliminar == null) {
			btnEliminar = new JButton("Eliminar");
			btnEliminar.setBounds(261, 81, 97, 25);
			btnEliminar.setBackground(Color.LIGHT_GRAY);
			btnEliminar.setIcon(null);
			
				btnEliminar.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						int confirm = JOptionPane.showConfirmDialog(null, "¿Eliminar esta persona?", "Confirmar", JOptionPane.YES_NO_OPTION);
						if (confirm == JOptionPane.YES_OPTION) {
							fac.getPersonal().remove(row);
							tablemodel.setRowCount(0);
							tablemodel.cargarInfo(fac.getPersonal());
							
						}
					}
				});
		}
		return btnEliminar;
	}
	
	private JButton getBtnGuardarCambios() {
		if (btnGuardarCambios == null) {
			btnGuardarCambios = new JButton("Guardar cambios");
			btnGuardarCambios.setBounds(367, 71, 97, 25);
			btnGuardarCambios.setBackground(Color.LIGHT_GRAY);
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
					nombre.setEditable(false);
					AnnoEst.setEnabled(false);
					carnet.setEditable(false);
					grupoEst.setEditable(false);
					
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
					}
					}
				
			});
		}
		return btnGuardarCambios;
	}
	
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setBounds(476, 71, 97, 25);
			btnCancelar.setBackground(Color.LIGHT_GRAY);
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
					}
				}
			});
		}
		return btnCancelar;
	}
	
	private JLabel getErrores() {
		if (errores == null) {
			errores = new JLabel("Errores");
			errores.setBounds(-1, 308, 211, 22);
			errores.setFont(new Font("Tahoma", Font.PLAIN, 15));
			errores.setForeground(Color.RED);
		}
		return errores;
	}
	
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
			

			try{
				est.setAnio(Integer.parseInt(anno));
			}
			catch (IllegalArgumentException e){
				errores.setText("Datos no validos");
				errores.setVisible(true);
				lblAo.setForeground(Color.RED);
				bien = false;	
			}
	
			try{
				est.setGrupo(Integer.parseInt(grup));
			}
			catch (IllegalArgumentException e){
				errores.setText("Datos no validos");
				errores.setVisible(true);
				lblGrupo.setForeground(Color.RED);
				bien = false;	
			}


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
			try{
				errores.setVisible(false);
				est.setProyecto(proyecto);
			}
			catch (IllegalArgumentException e){
				errores.setText("Datos no validos");
				errores.setVisible(true);
				lblProyecto.setForeground(Color.RED);
				bien = false;	
			}
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
			try{
				est.setPlaza(plaza);
			}
			catch (IllegalArgumentException e){
				errores.setText("Datos no validos");
				errores.setVisible(true);
				lblPlazaAdmin.setForeground(Color.RED);
				bien = false;	
				
			}
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
			try{
				est.setPlaza(plaza);
			}
			catch (IllegalArgumentException e){
				errores.setText("Datos no validos");
				errores.setVisible(true);
				lblPlaza_1.setForeground(Color.RED);
				bien = false;	
				
			}
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
			try {
				est.setCatCient(catcien);
				errores.setVisible(false);
				catCP.setForeground(Color.BLACK);
				
			}
			catch (IllegalArgumentException e){
				errores.setText("Datos no validos");
				errores.setVisible(true);
				catCP.setForeground(Color.RED);
				bien = false;	
			}
			
			try{
				est.setCatDoc(catD);
				catDocP.setForeground(Color.BLACK);
				
			}
			catch (IllegalArgumentException e){
				errores.setText("Datos no validos");
				errores.setVisible(true);
				catDocP.setForeground(Color.RED);
				bien = false;	
			}
			
			try{
				est.setTipoContrato(contr);
				tipocontratop.setForeground(Color.BLACK);
				
			}
			catch (IllegalArgumentException e){
				errores.setText("Datos no validos");
				errores.setVisible(true);
				tipocontratop.setForeground(Color.RED);
				bien = false;	
			}
			
			try{
			 est.setDepartamento(depa);
			
			depap.setForeground(Color.BLACK);
				
			}
			catch (IllegalArgumentException e){
				errores.setText("Datos no validos");
				errores.setVisible(true);
				depap.setForeground(Color.RED);
				bien = false;	
			}
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
			try {
				est.setCatCient(catcien);
				errores.setVisible(false);
				lblCategoriaCientifica.setForeground(Color.BLACK);
				
			}
			catch (IllegalArgumentException e){
				errores.setText("Datos no validos");
				errores.setVisible(true);
				lblCategoriaCientifica.setForeground(Color.RED);
				bien = false;	
			}
			
			try{
				est.setCatDoc(catD);
				lblCategoriaDocente.setForeground(Color.BLACK);
				
			}
			catch (IllegalArgumentException e){
				errores.setText("Datos no validos");
				errores.setVisible(true);
				lblCategoriaDocente.setForeground(Color.RED);
				bien = false;	
			}
			
			try{
				est.setTipoContrato(contr);
				lblTipoDeContrato.setForeground(Color.BLACK);
				
			}
			catch (IllegalArgumentException e){
				errores.setText("Datos no validos");
				errores.setVisible(true);
				lblTipoDeContrato.setForeground(Color.RED);
				bien = false;	
			}
			
			try{
			 est.setDepartamento(depa);
			
			lblDepartamento.setForeground(Color.BLACK);
				
			}
			catch (IllegalArgumentException e){
				errores.setText("Datos no validos");
				errores.setVisible(true);
				lblDepartamento.setForeground(Color.RED);
				bien = false;	
			}
			
			try{
				est.setArea(area);

				lblreaDeTrabajo.setForeground(Color.BLACK);
					
				}
				catch (IllegalArgumentException e){
					errores.setText("Datos no validos");
					errores.setVisible(true);
					lblreaDeTrabajo.setForeground(Color.RED);
					bien = false;	
				}
			
			try{
				est.setCargo(cargo);
				lblCargoAdministrativo.setForeground(Color.BLACK);
					
				}
				catch (IllegalArgumentException e){
					errores.setText("Datos no validos");
					errores.setVisible(true);
					lblCargoAdministrativo.setForeground(Color.RED);
					bien = false;	
				}
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
				errores.setText("Datos no validos");
				errores.setVisible(true);
				lblCarnet.setForeground(Color.RED);
				bien = false;	
			}

			try {
				est.setNombre(nom);
				lblNombreYApellidos.setForeground(Color.BLACK);
			}
			catch (IllegalArgumentException e){
				errores.setText("Datos no validos");
				errores.setVisible(true);
				lblNombreYApellidos.setForeground(Color.RED);
				bien = false;	
			}
		}

		return bien;
	}

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
			
			eleccionCrear.setBounds(166, 13, 176, 36);
			panel.add(eleccionCrear);
			eleccionCrear.setVisible(true);
			if(eleccionCrear.isVisible()){
				eleccionCrear.setVisible(false);
			}
			errores.setVisible(false);
			
			panelVisible(fac.getPersonal().get(row));
		}
		return eleccionCrear;
	}

	
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
	

