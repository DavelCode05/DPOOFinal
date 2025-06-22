package interfaz;

import java.awt.BorderLayout;

import enums.AreaDirectivo;
import enums.CargoDirectivo;

import java.awt.Color;


import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.CardLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import util.JTextFieldCarnet;
import util.JTextFieldGrupo;
import util.JTextFieldString;
import enums.Plaza;
import enums.TipoContrato;
import enums.TipoLocal;

import javax.swing.ImageIcon;

import controllerClass.Facultad;
import personas.Administrativo;
import personas.Directivo;
import personas.Especialista;
import personas.Estudiante;
import personas.Persona;
import personas.Profesor;
import personas.Tecnico;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class CRUDVerPersonal extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblNombreYApellidos;
	private JTextFieldString nombre;
	private JLabel lblcarnet;
	private JTextFieldCarnet carnet;
	private JComboBox<Plaza> plazaAdmin;
	private JLabel lblPlazaAdmin;
	private JButton btnEditar;
	private JButton btnEliminar;
	private JButton btnGuardarCambios;
	private JButton btnCancelar;
	private CardLayout card;
	JComboBox<String> eleccionCrear;
	private JPanel panelGeneral;
	private JPanel panelAdmin;
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
	private JPanel panelProfesor;
	private JLabel depap;
	private JTextFieldString DepaProfesor;
	private JLabel catDocP;
	private JTextFieldString catDocProfesor;
	private JLabel catCP;
	private JTextFieldString catCientProfesor;
	private JLabel tipocontratop;
	private JComboBox<TipoContrato> contratoProfesor;
	private JPanel panelEspecialista;
	private JTextFieldString TFproyectoEsp;
	private JLabel lblProyecto;
	private JPanel panelEstudiante;
	private JComboBox<String> AnnoEst;
	private JLabel lblAo;
	private JLabel lblGrupo;
	private JTextFieldGrupo grupoEst;
	private JPanel panelTecnico;
	private JTextFieldString palazatec;
	private JLabel lblPlaza_1;
	private JButton btnNewButton;
	private Persona per;
	Facultad fac;
	int row;
	JLabel errores;
	JDialog pp;

		/**
		 * Launch the application.
		 */
//		public static void main(String[] args) {
//			try {
//				CRUDVerPersonal dialog = new CRUDVerPersonal();
//				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//				dialog.setVisible(true);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
	
		/**
		 * Create the dialog.
		 */
	
	public CRUDVerPersonal(JDialog p, Persona persona, int row) {
		super(p,"",true);
<<<<<<< HEAD

		pp = p;
		setBounds(100, 100, 575, 576);

		setBounds(100, 100, 575, 631);

=======
		pp = p;
		setBounds(100, 100, 575, 576);
		setBounds(100, 100, 575, 631);
>>>>>>> origin/dariel
		per = persona;
		this.row= row;
		fac = Facultad.getFacultad();
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setBackground(Colores.getAzulCielo());
		this.setUndecorated(true);
		card = new CardLayout(0,0);
		contentPanel.setLayout(null);
		{
			contentPanel.add(getLblNombreYApellidos());
			contentPanel.add(getNombre());
			contentPanel.add(getLblcarnet());
			contentPanel.add(getCarnet());
			contentPanel.add(getBtnEditar());
			contentPanel.add(getBtnEliminar());
			contentPanel.add(getBtnGuardarCambios());
			contentPanel.add(getBtnCancelar());

		}
		contentPanel.add(getPanelGeneral());
		contentPanel.add(getBtnNewButton());

		errores = new JLabel("New label");
		errores.setFont(new Font("Tahoma", Font.PLAIN, 15));
		errores.setForeground(Color.RED);
		errores.setBounds(28, 530, 211, 22);
		contentPanel.add(errores);
		
		 eleccionCrear = new JComboBox<String>();
		 eleccionCrear.setFont(new Font("Tahoma", Font.PLAIN, 20));
		 eleccionCrear.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 	 panelVisible(per);	
		 	}
		 });
		eleccionCrear.setModel(new DefaultComboBoxModel<String>(new String[] {"Administrativo", "Directivo", "Profesor", "Especialista", "Estudiante", "Tecnico"}));
		
		eleccionCrear.setBounds(136, 20, 195, 41);
		contentPanel.add(eleccionCrear);
		eleccionCrear.setVisible(false);
		if(per==null){
			eleccionCrear.setVisible(true);
		}
		errores.setVisible(false);
	
		panelVisible(per);
	}
	
	private JLabel getLblNombreYApellidos() {
		if (lblNombreYApellidos == null) {
			lblNombreYApellidos = new JLabel("Nombre");
			lblNombreYApellidos.setForeground(Color.WHITE);
			lblNombreYApellidos.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNombreYApellidos.setBounds(49, 112, 77, 30);
		}
		return lblNombreYApellidos;
	}

	private JTextField getNombre() {
		if (nombre == null) {
			nombre = new JTextFieldString();
			nombre.setFont(new Font("Tahoma", Font.PLAIN, 17));
			nombre.setBounds(49, 147, 180, 30);
			nombre.setColumns(10);
			if(per!=null){
				nombre.setText(per.getNombre());
				nombre.setEditable(false);
			}
		}
		return nombre;
	}

	private JLabel getLblcarnet() {
		if (lblcarnet == null) {
			lblcarnet = new JLabel("Carnet de Identidad");
			lblcarnet.setForeground(Color.WHITE);
			lblcarnet.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblcarnet.setBounds(299, 112, 195, 30);
		}
		return lblcarnet;
	}

	private JTextField getCarnet() {
		if (carnet == null) {
			carnet = new JTextFieldCarnet();
			carnet.setFont(new Font("Tahoma", Font.PLAIN, 17));
			carnet.setColumns(10);
			carnet.setBounds(299, 147, 195, 30);
			if(per != null){
				carnet.setText(per.getNumeroIdentidad());
				carnet.setEditable(false);
			}
		}
		return carnet;
	}

	private JComboBox<Plaza> getPlazaAdmin() {
		if (plazaAdmin == null) {
			plazaAdmin = new JComboBox<Plaza>();
			plazaAdmin.setFont(new Font("Tahoma", Font.PLAIN, 20));
			plazaAdmin.setBounds(22, 63, 180, 30);
			plazaAdmin.setModel(new DefaultComboBoxModel<>(Plaza.values()));
			if(per!=null && per instanceof Administrativo){
				plazaAdmin.setSelectedItem(((Administrativo)per).getPlaza().toString());
				plazaAdmin.setEnabled(false);
			}

		}
		return plazaAdmin;
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
	private JButton getBtnEditar() {
		if (btnEditar == null) {
			btnEditar = new JButton("");
			btnEditar.setBackground(Color.LIGHT_GRAY);
			if(per== null)
				btnEditar.setEnabled(false);
			btnEditar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					btnGuardarCambios.setVisible(true);
					btnCancelar.setVisible(true);
					btnEliminar.setEnabled(false);
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
			        btnEditar.setEnabled(false);
			        
			        
			 	
				}
			});
			btnEditar.setIcon(new ImageIcon(CRUDVerPersonal.class.getResource("/images/icons8-edit-user-48.png")));
			btnEditar.setBounds(12, 20, 50, 50);
		}
		return btnEditar;
	}
	private JButton getBtnEliminar() {
		if (btnEliminar == null) {
			btnEliminar = new JButton("");
			btnEliminar.setBackground(Color.LIGHT_GRAY);
			btnEliminar.setIcon(new ImageIcon(CRUDVerPersonal.class.getResource("/images/icons8-delete-50.png")));
			if(per==null)
				btnEliminar.setEnabled(false);
				btnEliminar.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						int confirm = JOptionPane.showConfirmDialog(null, "¿Eliminar esta persona?", "Confirmar", JOptionPane.YES_NO_OPTION);
						if (confirm == JOptionPane.YES_OPTION) {
							fac.getPersonal().remove(row);
							
						}
					}
				});
			btnEliminar.setBounds(74, 20, 50, 50);
		}
		return btnEliminar;
	}
	private JButton getBtnGuardarCambios() {
		if (btnGuardarCambios == null) {
			btnGuardarCambios = new JButton("Guardar cambios");
			btnGuardarCambios.setBackground(Color.LIGHT_GRAY);
			btnGuardarCambios.setFont(new Font("Tahoma", Font.PLAIN, 20));
			if(per!=null)
			btnGuardarCambios.setVisible(false);
			
			btnGuardarCambios.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					crearPersona();
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
			        btnEliminar.setEnabled(true);
			        btnEditar.setEnabled(true);
				}
			});
			btnGuardarCambios.setBounds(221, 565, 184, 33);
		}
		return btnGuardarCambios;
	}
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setBackground(Color.LIGHT_GRAY);
			btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 20));
			if (per != null)
				btnCancelar.setVisible(false);
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
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
			        btnEliminar.setEnabled(true);
			        btnEditar.setEnabled(true);
				}
			});
			btnCancelar.setBounds(403, 565, 160, 33);
		}
		return btnCancelar;
	}
	private JPanel getPanelGeneral() {
		if (panelGeneral == null) {
			panelGeneral = new JPanel();
			panelGeneral.setBackground(Colores.getAzulCielo());
			panelGeneral.setBounds(28, 187, 507, 330);
			panelGeneral.setLayout(card);
			panelGeneral.add(getPanelAdmin(), "Administrativo");
			panelGeneral.add(getPanelDirectivo(), "Directivo");
			panelGeneral.add(getPanelProfesor(), "Profesor");
			panelGeneral.add(getPanelEspecialista(), "Especialista");
			panelGeneral.add(getPanelEstudiante(), "Estudiante");
			panelGeneral.add(getPanelTecnico(), "Tecnico");
		}
		return panelGeneral;
	}
	private JPanel getPanelAdmin() {
		if (panelAdmin == null) {
			panelAdmin = new JPanel();
			panelAdmin.setLayout(null);
			panelAdmin.setBackground(Colores.getAzulCielo());
			panelAdmin.add(getLblPlazaAdmin());
			panelAdmin.add(getPlazaAdmin());
		}
		return panelAdmin;
	}
	private JPanel getPanelDirectivo() {
		if (panelDirectivo == null) {

			
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
		}
		return panelDirectivo;
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
			if(per!=null && per instanceof Directivo){
				DepaDirect.setText(((Directivo)per).getDepartamento());
				DepaDirect.setEditable(false);
			}
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
			
			if(per!=null && per instanceof Directivo){
				contratodirect.setSelectedItem(((Directivo)per).getTipoContrato().toString());
				contratodirect.setEnabled(false);
			}
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
			
			if(per!=null && per instanceof Directivo){
				cargoDirect.setSelectedItem(((Directivo)per).getCargo().toString());
			    cargoDirect.setEnabled(false);
			}
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
			if(per!=null && per instanceof Directivo){
				areaDirect.setSelectedItem(((Directivo)per).getArea().toString());
				areaDirect.setEnabled(false);
			}
		}
		return areaDirect;
	}
	private JTextFieldString getCatDocDirec() {
		if (catDocDirec == null) {
			catDocDirec = new JTextFieldString();
			catDocDirec.setFont(new Font("Tahoma", Font.PLAIN, 17));
			catDocDirec.setBounds(22, 165, 180, 30);
			if(per!=null && per instanceof Directivo){
				catDocDirec.setText(((Directivo)per).getCatDoc());
				catDocDirec.setEditable(false);
			}
		}
		return catDocDirec;
	}
	private JTextFieldString getCatCientdirec() {
		if (catCientdirec == null) {
			catCientdirec = new JTextFieldString();
			catCientdirec.setFont(new Font("Tahoma", Font.PLAIN, 17));
			catCientdirec.setBounds(22, 258, 180, 30);
			if(per!=null && per instanceof Directivo){
				catCientdirec.setText(((Directivo)per).getCatCient());
				catCientdirec.setEditable(false);
			}
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
			if(per!=null && per instanceof Profesor){
				DepaProfesor.setText(((Profesor)per).getDepartamento());
				DepaProfesor.setEditable(false);
			}
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
			if(per!=null && per instanceof Profesor){
				catDocProfesor.setText(((Profesor)per).getCatDoc());
				catDocProfesor.setEditable(false);
			}
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
			if(per!=null && per instanceof Profesor){
				catCientProfesor.setText(((Profesor)per).getCatCient());
				catCientProfesor.setEditable(false);
			}
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
			if(per!=null && per instanceof Profesor){
				contratoProfesor.setSelectedItem(((Profesor)per).getTipoContrato().toString());
				contratoProfesor.setEnabled(false);
			}
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
			
			if(per!=null && per instanceof Especialista){
				TFproyectoEsp.setText(((Especialista)per).getProyecto());
				TFproyectoEsp.setEditable(false);
			}
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
			if(per!=null && per instanceof Estudiante){
				AnnoEst.setSelectedItem(((Estudiante)per).getAnio());
				AnnoEst.setEnabled(false);
				AnnoEst.setForeground(Color.LIGHT_GRAY);;
			}
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
			if(per!= null && per instanceof Estudiante){
				grupoEst.setText(String.valueOf(((Estudiante)per).getGrupo()));
				grupoEst.setEditable(false);
			}
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
			
			if(per!=null &&per instanceof Tecnico){
				palazatec.setText(((Tecnico)per).getPlaza());
				palazatec.setEditable(false);
			}
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
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("");
			btnNewButton.setBackground(Color.LIGHT_GRAY);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			btnNewButton.setIcon(new ImageIcon(CRUDVerPersonal.class.getResource("/images/close.png")));
			btnNewButton.setBounds(501, 20, 50, 50);
		}
		return btnNewButton;
	}


	public void panelVisible (Persona per){

		if(per instanceof Administrativo || per == null && eleccionCrear.getSelectedItem().equals("Administrativo") ){
			card.show(panelGeneral, "Administrativo");
		}
		else if(per instanceof Directivo || per == null && eleccionCrear.getSelectedItem().equals("Directivo")){
			card.show(panelGeneral, "Directivo");
		}
		else if(per instanceof Estudiante || per == null && eleccionCrear.getSelectedItem().equals("Estudiante")){
			card.show(panelGeneral, "Estudiante");
		}
		else if(per instanceof Especialista || per == null && eleccionCrear.getSelectedItem().equals("Especialista")){
			card.show(panelGeneral, "Especialista");
		}
		else if(per instanceof Tecnico || per == null && eleccionCrear.getSelectedItem().equals("Tecnico")){
			card.show(panelGeneral, "Tecnico");
		}
		else if(per instanceof Profesor || per == null && eleccionCrear.getSelectedItem().equals("Profesor")){
			card.show(panelGeneral,"Profesor");
		}

	}
	
	public void crearPersona(){
		if(per instanceof Administrativo || per == null && eleccionCrear.getSelectedItem().equals("Administrativo")){
			crearAdministrativo();
		}
		else if(per instanceof Directivo || per == null && eleccionCrear.getSelectedItem().equals("Directivo")){
			crearDirectivo();
		}
		else if(per instanceof Estudiante || per == null && eleccionCrear.getSelectedItem().equals("Estudiante")){
			crearEstudiante();
		}
		else if(per instanceof Especialista || per == null && eleccionCrear.getSelectedItem().equals("Especialista")){
			crearEspecialista();
		}
		else if(per instanceof Tecnico || per == null && eleccionCrear.getSelectedItem().equals("Tecnico")){
			crearTecnico();
		}
		else if(per instanceof Profesor || per == null && eleccionCrear.getSelectedItem().equals("Profesor")){
			crearProfesor();}
		
		
	}

	public void crearEstudiante(){
		String nom = nombre.getText();
		String carn = carnet.getText();
		String anno = AnnoEst.getSelectedItem().toString();
		String grup= grupoEst.getText();
		Estudiante est = new Estudiante();
		boolean bien = false;;
		Persona existente =  fac.buscarPersonaCi(carn);

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
	

		if(bien && per ==null){
			fac.addEstudiante(est.getNombre(), est.getNumeroIdentidad(), est.getAnio(), est.getGrupo());
		}

		else if (bien && per!=null){
			existente.setNombre(est.getNombre());
			existente.setNumeroIdentidad(est.getNumeroIdentidad());
			((Estudiante)existente).setAnio(est.getAnio());
			((Estudiante)existente).setGrupo(est.getGrupo());
		}	

	}
	public void crearEspecialista(){
		String nom = nombre.getText();
		String carn = carnet.getText();
		String proyecto = TFproyectoEsp.getText();
		Especialista est = new Especialista();
		
		boolean bien = false;;
		Persona existente =  fac.buscarPersonaCi(carn);

		
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
		
		if(bien && per ==null){
			fac.addEspecialista(est.getNombre(), est.getNumeroIdentidad(), est.getProyecto());
		}

		else if (bien && per!=null){
			existente.setNombre(est.getNombre());
			existente.setNumeroIdentidad(est.getNumeroIdentidad());
			((Especialista)existente).setProyecto(est.getProyecto());
			
		}

	}
	
	
	public void crearAdministrativo(){
		String nom = nombre.getText();
		String carn = carnet.getText();
		Administrativo est = new Administrativo();
		
		boolean bien = false;;
		Persona existente =  fac.buscarPersonaCi(carn);
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
		
		
		if(bien && per ==null){
			fac.addAdministrativo(est.getNombre(), est.getNumeroIdentidad(), est.getPlaza());;// cambiar estoooo
		}

		else if (bien && per!=null){
			existente.setNombre(est.getNombre());
			existente.setNumeroIdentidad(est.getNumeroIdentidad());
			((Administrativo)existente).setPlaza(est.getPlaza());
			
		}
		
	}
	
	public void crearTecnico(){
		String nom = nombre.getText();
		String carn = carnet.getText();
		Tecnico est = new Tecnico();
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
		
		if(bien && per ==null){
			fac.addTecnico(est.getNombre(), est.getNumeroIdentidad(), est.getPlaza());
		}

		else if (bien && per!=null){
			existente.setNombre(est.getNombre());
			existente.setNumeroIdentidad(est.getNumeroIdentidad());
			((Tecnico)existente).setPlaza(est.getPlaza());
			
		}
		
	}
	
	public void crearProfesor(){
		String nom = nombre.getText();
		String carn = carnet.getText();
		Profesor est = new Profesor();
		boolean bien = false;;
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
		
		if(bien && per ==null){
			fac.addProfesor(est.getNombre(), est.getNumeroIdentidad(),  est.getDepartamento(), est.getCatDoc(), est.getCatCient(), est.getTipoContrato());
		}

		else if (bien && per!=null){
			existente.setNombre(est.getNombre());
			existente.setNumeroIdentidad(est.getNumeroIdentidad());
			((Profesor)existente).setCatCient(est.getCatCient());
			((Profesor)existente).setCatDoc(est.getCatDoc());
			((Profesor)existente).setDepartamento(est.getDepartamento());
			((Profesor)existente).setTipoContrato(est.getTipoContrato());
			
		}
		
	}
	
	public void crearDirectivo(){
		String nom = nombre.getText();
		String carn = carnet.getText();
		Directivo est = new Directivo();
		boolean bien = false;;
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
		
		if(bien && per ==null){
			fac.addDirectivo(est.getNombre(), est.getNumeroIdentidad(),  est.getDepartamento(), est.getCatDoc(), est.getCatCient(), est.getTipoContrato(), est.getCargo(), est.getArea());
		}

		else if (bien && per!=null){
			existente.setNombre(est.getNombre());
			existente.setNumeroIdentidad(est.getNumeroIdentidad());
			((Directivo)existente).setCatCient(est.getCatCient());
			((Directivo)existente).setCatDoc(est.getCatDoc());
			((Directivo)existente).setDepartamento(est.getDepartamento());
			((Directivo)existente).setTipoContrato(est.getTipoContrato());
			((Directivo)existente).setArea(est.getArea());
			((Directivo)existente).setCargo(est.getCargo());
		}
	}
	

	
	


	public boolean verificarExistenciNombreyCarnet(String carn, Persona existente, Persona est, String nom){

		boolean bien = true;

		if(per==null && existente!= null){
			bien = false;
			errores.setText("La persona ya existe");
			lblcarnet.setForeground(Color.RED);
			errores.setVisible(true);

		}
		else if(per != null &&existente!= null && !per.getNumeroIdentidad().equals(carn)){
			bien = false;
			errores.setText("Existe un usuario registrado con ese carnet");
			errores.setVisible(true);
			lblcarnet.setForeground(Color.RED);

		}
		else
		{
			lblcarnet.setForeground(Color.BLACK);
			try{
				est.setNumeroIdentidad(carn);
				errores.setVisible(false);
				lblcarnet.setForeground(Color.BLACK);
			}
			catch (IllegalArgumentException e){
				errores.setText("Datos no validos");
				errores.setVisible(true);
				lblcarnet.setForeground(Color.RED);
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
}
