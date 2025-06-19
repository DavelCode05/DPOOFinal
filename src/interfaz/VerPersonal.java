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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
import util.JTextFieldString;
import util.JTextFieldCarnet;

public class VerPersonal extends JDialog {

	private final JPanel contentPanel;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JTable tablepers;
	private Facultad fac;
	private MostrarPersonal tablemodel;
	int row;
	private JPanel panel;
	private JPanel panelGeneral;
	private JPanel panelAdmin;
	private JLabel lblPlazaAdmin;
	private JComboBox plazaAdmin;
	private Persona per;
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
	private JComboBox eleccionCrear;
	private JLabel errores;
	private CardLayout card;
	private JComboBox filtro;
	private JComboBox comboBox;
	private JLabel lblFiltrarPor;


	/**
	 * Launch the application.
	 */
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
		setBounds(100, 100, 1234, 760);
		fac = Facultad.getFacultad();
		contentPanel = new JPanel(){
			public void paintComponent(Graphics g){
				Image img= Toolkit.getDefaultToolkit().getImage(Inicio.class.getResource("/images/fondoDesenfocado.png"));
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};
		//		
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
				CRUDVerPersonal pp= new CRUDVerPersonal(VerPersonal.this, null, row);
				pp.setVisible(true);
				tablemodel.setRowCount(0);
				tablemodel.cargarInfo(fac.getPersonal());

			}
		});
		btnagregar.setBounds(12, 13, 58, 59);
		contentPanel.add(btnagregar);

		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 19));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Todos", "Estudiante", "Directivo", "Administrativo", "Especialista", "T\u00E9cnico", "Profesor"}));
		comboBox.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
			        if (e.getStateChange() == ItemEvent.SELECTED) {
			            String rolSeleccionado = (String) e.getItem();
			            ArrayList<Persona> todas = fac.getPersonal();
			            ArrayList<Persona> filtradas = new ArrayList<>();

			            if (rolSeleccionado.equals("Todos")) {
			                filtradas = todas;
			            } else {
			                for (Persona p : todas) {
			                    if (p.getClass().getSimpleName().equals(rolSeleccionado)) {
			                        filtradas.add(p);
			                    }
			                }
			            }

			            tablemodel.cargarInfo(filtradas);
			        }
			    }
		});
		comboBox.setBounds(199, 36, 197, 36);
		contentPanel.add(comboBox);
		
		lblFiltrarPor = new JLabel("Mostrar:");
		lblFiltrarPor.setForeground(Color.WHITE);
		lblFiltrarPor.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblFiltrarPor.setBounds(100, 34, 87, 41);
		contentPanel.add(lblFiltrarPor);
		//		contentPanel.add(getPanel());





		tablepers.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(java.awt.event.MouseEvent arg0) {
				row = tablepers.rowAtPoint(arg0.getPoint());
				if(row!=-1){
					tablepers.setRowSelectionInterval(row,row);
					tablepers.setAutoscrolls(true);



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

		//		btnNewButton_2 = new JButton("New button");
		//		btnNewButton_2.setBounds(32, 36, 39, 23);
		//		contentPanel.add(btnNewButton_2);

		tablepers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent arg0) {
				CRUDVerPersonal pp= new CRUDVerPersonal(VerPersonal.this, fac.getPersonal().get(row), row);
				pp.setVisible(true);
				//				panelVisible(fac.getPersonal().get(row));
				tablemodel.setRowCount(0);
				tablemodel.cargarInfo(fac.getPersonal());
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


}


