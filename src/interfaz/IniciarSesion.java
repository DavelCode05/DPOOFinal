package interfaz;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import enums.TipoLocal;
import locales.Local;
import personas.Persona;
import personas.Visitante;
import controllerClass.Facultad;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JTextPane;
import javax.swing.JFormattedTextField;
import javax.swing.JToggleButton;

import java.awt.ScrollPane;

import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;

import java.awt.TextArea;

import javax.swing.JRadioButton;
import javafx.scene.control.ComboBox;

public class IniciarSesion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField nombreUser;
	private JComboBox<TipoLocal> comboBoxLocal;
	private JTextField carnet;
	private JLabel lblDatosErroneos;
	private Facultad fac ;
	private JTextField responsable;
	private boolean usuario = true;
	JLabel lblContrasea;
	JLabel lblUsuario;
	JLabel lblResponsable;
	/**
	 * @wbp.nonvisual location=467,129
	 */


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			IniciarSesion dialog = new IniciarSesion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setLocationRelativeTo(null);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public IniciarSesion( ) {
		setTitle("Registro de Entrada");
		setForeground(Color.BLACK);
		setBounds(100, 100, 352, 489);
		fac = new Facultad();

		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 240, 245));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(255, 240, 245));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\nicol\\Pictures\\inicio2.png"));
		lblNewLabel.setBounds(106, 0, 97, 117);
		contentPanel.add(lblNewLabel);


		lblContrasea = new JLabel("Carnet");
		lblContrasea.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblContrasea.setBounds(28, 190, 87, 14);
		contentPanel.add(lblContrasea);

		lblDatosErroneos = new JLabel();
		lblDatosErroneos.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosErroneos.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblDatosErroneos.setForeground(Color.RED);
		lblDatosErroneos.setBounds(10, 382, 316, 23);
		lblDatosErroneos.setVisible(false);
		contentPanel.add(lblDatosErroneos);

		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.setBackground(new Color(255, 228, 225));
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				crearRegistro();
			}
		});
		btnIniciar.setBounds(67, 416, 89, 23);
		contentPanel.add(btnIniciar);

		JButton button = new JButton("Cancelar");
		button.setBackground(new Color(255, 228, 225));
		button.setBounds(187, 416, 89, 23);
		contentPanel.add(button);

		JLabel lblLocal = new JLabel("Local");
		lblLocal.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblLocal.setBounds(28, 151, 46, 14);
		contentPanel.add(lblLocal);

		comboBoxLocal = new JComboBox<>();
		comboBoxLocal.setBackground(new Color(255, 255, 255));
		comboBoxLocal.setFont(new Font("Verdana", Font.PLAIN, 12));
		comboBoxLocal.setModel(new DefaultComboBoxModel<>(TipoLocal.values()));

		comboBoxLocal.setBounds(125, 149, 201, 20);
		contentPanel.add(comboBoxLocal);

		carnet = new JTextField();
		carnet.setColumns(10);
		carnet.setBounds(125, 189, 201, 20);
		contentPanel.add(carnet);

		final JPanel panelVisitante = new JPanel();
		panelVisitante.setBackground(new Color(255, 240, 245));
		panelVisitante.setBounds(0, 215, 336, 168);
		contentPanel.add(panelVisitante);
		panelVisitante.setVisible(false);
		panelVisitante.setLayout(null);

		lblUsuario = new JLabel("Nombre");
		lblUsuario.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblUsuario.setBounds(24, 11, 59, 20);
		panelVisitante.add(lblUsuario);

		lblResponsable = new JLabel("Responsable");
		lblResponsable.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblResponsable.setBounds(24, 54, 89, 19);
		panelVisitante.add(lblResponsable);

		responsable = new JTextField();
		responsable.setBounds(123, 55, 201, 20);
		panelVisitante.add(responsable);
		responsable.setColumns(10);

		TextArea textAreaMot = new TextArea();
		textAreaMot.setBounds(123, 96, 201, 50);	
		panelVisitante.add(textAreaMot);

		JLabel lblMotivoVisita = new JLabel("Motivo Visita");
		lblMotivoVisita.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblMotivoVisita.setBounds(24, 96, 89, 14);
		panelVisitante.add(lblMotivoVisita);

		nombreUser = new JTextField();
		nombreUser.setBounds(123, 13, 201, 20);
		panelVisitante.add(nombreUser);
		nombreUser.setColumns(10);


		final JButton btnUsuarios = new JButton("Usuarios");


		btnUsuarios.setBorder(new MatteBorder(1, 1, 0, 1, (Color) new Color(255, 182, 193)));
		btnUsuarios.setBackground(new Color(255, 240, 245));
		btnUsuarios.setBounds(0, 103, 89, 23);
		contentPanel.add(btnUsuarios);

		final JButton btnVisitante = new JButton("Visitante");
		btnVisitante.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				btnVisitante.setBorder(BorderFactory.createMatteBorder(1, 1, 0, 1, Color.PINK));
				btnUsuarios.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.PINK));
				panelVisitante.setVisible(true);
				usuario = false;

			}
		});

		btnVisitante.setBackground(new Color(255, 240, 245));
		btnVisitante.setForeground(new Color(0, 0, 0));
		btnVisitante.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.PINK));
		btnVisitante.setBounds(89, 103, 89, 23);
		contentPanel.add(btnVisitante);


		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelVisitante.setVisible(false);
				btnUsuarios.setBorder(BorderFactory.createMatteBorder(1, 1, 0, 1, Color.PINK));
				btnVisitante.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.PINK));
				usuario = true;

			}
		});

	}



	public void crearRegistro(){
		String nom = nombreUser.getText();
		String CI = carnet.getText();
		String local = comboBoxLocal.getSelectedItem().toString();
		String respon = responsable.getText();
		Persona aAcceder= null;
		Persona res;
		boolean permiso = true;

		if(!usuario){
			aAcceder = new Visitante();
			try{
				aAcceder.setNombre(nom);
				permiso = true;
				lblUsuario.setForeground(Color.BLACK);
				lblDatosErroneos.setVisible(false);
				permiso = true;
			}
			catch(IllegalArgumentException e){
				lblUsuario.setForeground(Color.RED);
				permiso = false;
				lblDatosErroneos.setVisible(true);
				lblDatosErroneos.setText("Datos Erroneos");
			}

			try{
				aAcceder.setNumeroIdentidad(CI);
				lblContrasea.setForeground(Color.BLACK);
			}
			catch(IllegalArgumentException e){
				lblContrasea.setForeground(Color.RED);
				permiso = false;
				lblDatosErroneos.setVisible(true);
				lblDatosErroneos.setText("Datos Erroneos");
			}

			try{
				res = fac.buscarEnPersonal(respon);
				((Visitante)aAcceder).setAutorizadoPor(res);
				lblResponsable.setForeground(Color.BLACK);
			}
			catch(IllegalArgumentException e){
				lblResponsable.setForeground(Color.RED);
				lblDatosErroneos.setVisible(true);
				if(permiso){
					lblDatosErroneos.setText("Ingrese un responsable válido");
					permiso = false;

				}
			}

		}
		else{
			try{
				aAcceder = fac.buscarEnPersonal(CI);
				permiso = true;
				lblDatosErroneos.setVisible(false);
				lblContrasea.setForeground(Color.BLACK);
			}
			catch(IllegalArgumentException e){
				lblDatosErroneos.setText(e.getMessage());
				permiso = false;
				lblDatosErroneos.setVisible(true);
				lblContrasea.setForeground(Color.red);
			}
		}
		if(permiso){
			Local l= fac.buscarLocal(local);
			fac.agregarRegistro(aAcceder, l);
			JOptionPane.showMessageDialog(null, "Usuario Registrado");

		}

	}


	public boolean verificarStrings(String verif){
		boolean ok = true;

		return ok;
	}
}
