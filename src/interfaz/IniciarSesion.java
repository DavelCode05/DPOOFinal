package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
//import java.time.LocalDate;
//import java.time.LocalTime;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
//import javax.swing.JTextArea;
//import javax.swing.JScrollBar;
//import javax.swing.JTextPane;
//import javax.swing.JFormattedTextField;
import javax.swing.JToggleButton;
import javax.swing.UIManager;

import locales.Local;
import personas.Persona;
import personas.Visitante;
import util.JTextFieldCarnet;
import util.JTextFieldString;
import controllerClass.Facultad;

//import javax.swing.JRadioButton;
//
//import javafx.scene.control.ComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.BorderFactory;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
//import java.awt.ScrollPane;
//
//import javax.swing.JScrollPane;
//import javax.swing.border.TitledBorder;
//import javax.swing.UIManager;
//import javax.swing.border.MatteBorder;
//import javax.swing.event.DocumentEvent;
//import javax.swing.event.DocumentListener;
//import com.sun.xml.internal.ws.org.objectweb.asm.Label;

public class IniciarSesion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextFieldString nombreUser;
	private JComboBox<Local> comboBoxLocal;
	private JTextFieldCarnet carnet;
	private JLabel lblDatosErroneos;
	private Facultad fac ;
	private JTextFieldCarnet responsable;
	private boolean usuario ;
	JToggleButton tglbtnNewToggleButton;
	JToggleButton tglbtnUsuario;
	JButton btnNewButton;
	TextArea textAreaMot;

	
	private ButtonGroup buttonGroup ;
	private JButton btnNewButton_1;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblDeTuMano;
	private JButton btnIniciar;


	/**
	 * Launch the application.
	 */
//	/**
//	 * Launch the application.
//	 */
//		public static void main(String[] args) {
//			
//			try {
//				IniciarSesion dialog = new IniciarSesion();
//				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//				dialog.setLocationRelativeTo(null);
//				dialog.setVisible(true);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			
//
//		}
	/**
	 * Create the dialog.
	 */

	public IniciarSesion( ) {
		setTitle("Registro de Entrada");
		setForeground(Color.BLACK);
		setBounds(100, 100, 909, 583);
		fac = Facultad.getFacultad();
		setUndecorated(true);
		usuario = true;
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Colores.getBlancuzo());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
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

		btnIniciar = new JButton("Registrarse");
		btnIniciar.setFont(new Font("Modern No. 20", Font.PLAIN, 27));
		btnIniciar.setBorder(null);
		btnIniciar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
              
                btnIniciar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            }

            @Override
            public void mouseExited(MouseEvent e) {
               btnIniciar.setBorder(null);
//            	btnIniciar.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
            }
        });
		
		btnIniciar.setBorder(null);
		btnIniciar.setBackground(Color.WHITE);
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				crearRegistro();
			}
		});
		btnIniciar.setBounds(632, 536, 178, 34);
		contentPanel.add(btnIniciar);

		JLabel lblLocal = new JLabel("Local:");
		lblLocal.setFont(new Font("Modern No. 20", Font.PLAIN, 24));
		lblLocal.setBounds(548, 141, 65, 34);
		contentPanel.add(lblLocal);

		comboBoxLocal = new JComboBox<>();
		comboBoxLocal.setBackground(Color.WHITE);

		comboBoxLocal.setFont(new Font("Modern No. 20", Font.PLAIN, 22));
		comboBoxLocal.setModel(new DefaultComboBoxModel<>(fac.getLocales().toArray(new Local[0])));


		comboBoxLocal.setBorder(null);

		comboBoxLocal.setBounds(613, 141, 260, 34);
		contentPanel.add(comboBoxLocal);


		carnet = new JTextFieldCarnet();
		carnet.setHorizontalAlignment(SwingConstants.CENTER);
		carnet.setText("Carnet de Identidad");
		carnet.setForeground(Color.GRAY);

		carnet.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent arg0) {
				if(carnet.getText().isEmpty()){
					carnet.setText("Carnet de Identidad");
					carnet.setForeground(Color.GRAY);
				}

			}

			@Override
			public void focusGained(FocusEvent arg0) {
				if(carnet.getText().equals("Carnet de Identidad")){
					carnet.setText("");
					carnet.setForeground(Color.BLACK);
				}

			}
		});

		carnet.setForeground(Color.GRAY);
		carnet.setFont(new Font("Modern No. 20", Font.PLAIN, 22));
		carnet.setBorder(null);
		carnet.setBackground(Color.WHITE);
		carnet.setColumns(10);
		carnet.setBounds(548, 202, 325, 40);
		contentPanel.add(carnet);

		final JPanel panelVisitante = new JPanel();
		panelVisitante.setBackground(Colores.getBlancuzo());
		panelVisitante.setBounds(548, 255, 325, 192);
		contentPanel.add(panelVisitante);
		panelVisitante.setVisible(false);
		panelVisitante.setLayout(null);

		responsable = new JTextFieldCarnet();
		responsable.setHorizontalAlignment(SwingConstants.CENTER);
		responsable.setText("Responsable");
		responsable.setForeground(Color.GRAY);

		responsable.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent arg0) {
				if(responsable.getText().isEmpty()){
					responsable.setText("Responsable");
					responsable.setForeground(Color.GRAY);
				}

			}

			@Override
			public void focusGained(FocusEvent arg0) {
				if(responsable.getText().equals("Responsable")){
					responsable.setText("");
					responsable.setForeground(Color.BLACK);
				}

			}
		});
		responsable.setFont(new Font("Modern No. 20", Font.PLAIN, 22));
		responsable.setBorder(null);
		responsable.setBackground(Color.WHITE);
		responsable.setBounds(0, 53, 325, 40);
		panelVisitante.add(responsable);
		responsable.setColumns(10);

	    textAreaMot = new TextArea();
		textAreaMot.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textAreaMot.setBackground(Color.WHITE);
		textAreaMot.setBounds(139, 105, 186, 77);	
		panelVisitante.add(textAreaMot);

		JLabel lblMotivoVisita = new JLabel("Motivo visita:");
		lblMotivoVisita.setFont(new Font("Modern No. 20", Font.PLAIN, 24));
		lblMotivoVisita.setBounds(0, 113, 133, 25);
		panelVisitante.add(lblMotivoVisita);

		nombreUser = new JTextFieldString();
		nombreUser.setHorizontalAlignment(SwingConstants.CENTER);
		nombreUser.setText("Nombre");
		nombreUser.setForeground(Color.GRAY);

		nombreUser.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent arg0) {
				if(nombreUser.getText().isEmpty()){
					nombreUser.setText("Nombre");
					nombreUser.setForeground(Color.GRAY);
				}
			}

			@Override
			public void focusGained(FocusEvent arg0) {
				if(nombreUser.getText().equals("Nombre")){
					nombreUser.setText("");
					nombreUser.setForeground(Color.BLACK);
				}

			}
		});

		
		//nombreUser.setFont(new Font("Tahoma", Font.PLAIN, 20));

		nombreUser.setFont(new Font("Modern No. 20", Font.PLAIN, 22));

		nombreUser.setBorder(null);
		nombreUser.setBackground(Color.WHITE);
		nombreUser.setBounds(0, 0, 325, 40);
		panelVisitante.add(nombreUser);
		nombreUser.setColumns(10);

		tglbtnUsuario = new JToggleButton("Personal");
		tglbtnUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelVisitante.setVisible(false);
				tglbtnUsuario.setBorder(BorderFactory.createMatteBorder(1,1,0,1,Colores.getLogin()));
				tglbtnNewToggleButton.setBorder(BorderFactory.createMatteBorder(0,1,1,1,Colores.getLogin()));
				usuario = true;
				if(carnet.getForeground().equals(Color.RED) && carnet.equals("Carnet de Identidad")){
					carnet.setForeground(Color.GRAY);
				}
				else if(carnet.getForeground().equals(Color.RED) && !carnet.equals("Carnet de Identidad")){
					carnet.setForeground(Color.BLACK);
				}
//				nombreUser.setText("");
//				responsable.setText("");
//				textAreaMot.setText("");
				lblDatosErroneos.setVisible(false);
				
				
			}
		});
		tglbtnUsuario.setSelected(true);
                                                                                                     		
//		tglbtnUsuario.addItemListener(new ItemListener() {
//			public void itemStateChanged(ItemEvent arg0) {
//				if(arg0.getStateChange()==ItemEvent.SELECTED){
//					panelVisitante.setVisible(false);
//					tglbtnUsuario.setBorder(BorderFactory.createMatteBorder(1,1,0,1,Colores.getLogin()));
//				}
//				else{
//					tglbtnUsuario.setBorder(BorderFactory.createMatteBorder(0,1,1,1,Colores.getLogin()));
//				
//				}
//			}
//		});
		
		tglbtnUsuario.setBorder(BorderFactory.createMatteBorder(1,1,0,1,Colores.getLogin()));
		tglbtnUsuario.setBackground(Color.WHITE);
		tglbtnUsuario.setFont(new Font("Modern No. 20", Font.PLAIN, 27));
		tglbtnUsuario.setBounds(516, 75, 190, 43);
		contentPanel.add(tglbtnUsuario);

		tglbtnNewToggleButton = new JToggleButton("Visitante");
		tglbtnNewToggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(carnet.getForeground().equals(Color.RED) && carnet.equals("Carnet de Identidad")){
					carnet.setForeground(Color.GRAY);
				}
				else if(carnet.getForeground().equals(Color.RED) && !carnet.equals("Carnet de Identidad")){
					carnet.setForeground(Color.GRAY);
				}
					
				panelVisitante.setVisible(true);
				usuario = false;
				tglbtnNewToggleButton.setBorder(BorderFactory.createMatteBorder(1,1,0,1,Colores.getLogin()));
				tglbtnUsuario.setBorder(BorderFactory.createMatteBorder(0,1,1,1,Colores.getLogin()));
				lblDatosErroneos.setVisible(false);
				
			}
		});
		
		tglbtnNewToggleButton.setBackground(Color.WHITE);
		tglbtnNewToggleButton.setForeground(new Color(0,0,0));
		tglbtnNewToggleButton.setBorder(null);


		
//		tglbtnNewToggleButton.addItemListener(new ItemListener() {
//			public void itemStateChanged(ItemEvent arg0) {
//				if(arg0.getStateChange()== ItemEvent.SELECTED){
//					panelVisitante.setVisible(true);
//					usuario = false;
//					tglbtnNewToggleButton.setBorder(BorderFactory.createMatteBorder(1,1,0,1,Colores.getLogin()));usuario = true;
//				}
//				else{
//					tglbtnNewToggleButton.setBorder(BorderFactory.createMatteBorder(0,1,1,1,Colores.getLogin()));
//					
//				}
//
//			}
//		});
		
		//tglbtnNewToggleButton.setFont(new Font("Tahoma", Font.PLAIN, 22));

//		tglbtnNewToggleButton.addItemListener(new ItemListener() {
//			public void itemStateChanged(ItemEvent arg0) {
//				if(arg0.getStateChange()== ItemEvent.SELECTED){
//					panelVisitante.setVisible(true);
//					tglbtnNewToggleButton.setBorder(BorderFactory.createMatteBorder(1,1,0,1,Colores.getLogin()));usuario = true;
//				}
//				else{
//					tglbtnNewToggleButton.setBorder(BorderFactory.createMatteBorder(0,1,1,1,Colores.getLogin()));
//					usuario  = false;
//				}
//
//			}
//		});
		
		tglbtnNewToggleButton.setFont(new Font("Modern No. 20", Font.PLAIN, 27));

		tglbtnNewToggleButton.setBounds(704, 76, 190, 43);
		contentPanel.add(tglbtnNewToggleButton);
		tglbtnNewToggleButton.setBorder(BorderFactory.createMatteBorder(0,1,1,1,Colores.getLogin()));

		buttonGroup = new ButtonGroup();
		buttonGroup.add(tglbtnUsuario);
		buttonGroup.add(tglbtnNewToggleButton);

		btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton.setIcon(new ImageIcon(AcercaDe.class.getResource("/images/close.png")));
		btnNewButton.setBounds(847, 13, 50, 50);
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(Colores.getBlancuzo());
		contentPanel.add(btnNewButton);
		contentPanel.add(getPanel());

		lblDatosErroneos = new JLabel();
		lblDatosErroneos.setBounds(548, 484, 325, 23);
		contentPanel.add(lblDatosErroneos);
		lblDatosErroneos.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosErroneos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDatosErroneos.setForeground(Color.RED);
		lblDatosErroneos.setVisible(false);


	}
	public void crearRegistro(){
		String nom = nombreUser.getText();
		String CI = carnet.getText();
	    Local local = (Local) comboBoxLocal.getSelectedItem();
		String respon = responsable.getText();
		Persona aAcceder= null;
		Persona res;
		boolean permiso = true;

		if(!usuario){
			aAcceder = new Visitante();
			try{ 
				if(!nom.equals("Nombre")){
				aAcceder.setNombre(nom);
				permiso = true;
				nombreUser.setForeground(Color.BLACK);
				lblDatosErroneos.setVisible(false);
				}
				else{
					nombreUser.setForeground(Color.RED);
					permiso = false;
					lblDatosErroneos.setVisible(true);
					lblDatosErroneos.setText("Datos Erroneos");
				}
			
			}
			catch(IllegalArgumentException e){
				nombreUser.setForeground(Color.RED);
				permiso = false;
				lblDatosErroneos.setVisible(true);
				lblDatosErroneos.setText("Datos Erroneos");
			}

			try{
				if(!CI.equals("Carnet de Identidad")){
				aAcceder.setNumeroIdentidad(CI);
				carnet.setForeground(Color.BLACK);
				}
				else{
					carnet.setForeground(Color.RED);
					permiso = false;
					lblDatosErroneos.setVisible(true);
					lblDatosErroneos.setText("Datos Erroneos");
				}
			}
			catch(IllegalArgumentException e){
				carnet.setForeground(Color.RED);
				permiso = false;
				lblDatosErroneos.setVisible(true);
				lblDatosErroneos.setText("Datos Erroneos");
			}

			try{
				res = fac.buscarEnPersonal(respon);
				((Visitante)aAcceder).setAutorizadoPor(res);
				responsable.setForeground(Color.BLACK);
			}
			catch(IllegalArgumentException e){
				responsable.setForeground(Color.RED);
				lblDatosErroneos.setVisible(true);
				if(permiso){
					lblDatosErroneos.setText("Ingrese un responsable valido");
					permiso = false;

				}
			}

		}
		else{
			try{
				aAcceder = fac.buscarEnPersonal(CI);
				permiso = true;
				lblDatosErroneos.setVisible(false);
				carnet.setForeground(Color.BLACK);
			}
			catch(IllegalArgumentException e){
				lblDatosErroneos.setText(e.getMessage());
				permiso = false;
				lblDatosErroneos.setVisible(true);
				carnet.setForeground(Color.red);
			}
		}
		 if(permiso){
		try{
			fac.accesoPermitidoAlLocal(local.getTipo().toString(),aAcceder);
			
		}
		catch(IllegalArgumentException e){
			lblDatosErroneos.setText(e.getMessage());
			permiso = false;
			lblDatosErroneos.setVisible(true);
		}
		 }
		if(permiso){
			
			fac.agregarRegistro(aAcceder, local);
			JOptionPane.showMessageDialog(null, "Usuario Registrado");
			
				
			}
		}

	
	public boolean verificarStrings(String verif){
		boolean ok = true;

		return ok;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel(){
				public void paintComponent(Graphics g){
					Image img= Toolkit.getDefaultToolkit().getImage(Inicio.class.getResource("/images/fondoLogin.jpg"));
					g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
				}
			};
			panel.setBounds(0, 0, 504, 583);
			panel.setLayout(null);

			btnNewButton_1 = new JButton("");
			btnNewButton_1.setBackground(Colores.getLogin());
			btnNewButton_1.setBorder(null);
			btnNewButton_1.setBounds(12, 13, 50, 50);
			panel.add(btnNewButton_1);

			lblNewLabel = new JLabel("Bienvenido");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Modern No. 20", Font.BOLD, 56));
			lblNewLabel.setBounds(45, 123, 395, 75);
			panel.add(lblNewLabel);

			lblNewLabel_1 = new JLabel("Registra, controla y gestiona las entradas a los ");
			lblNewLabel_1.setFont(new Font("Modern No. 20", Font.PLAIN, 22));
			lblNewLabel_1.setBounds(22, 220, 470, 26);
			panel.add(lblNewLabel_1);

			lblNewLabel_2 = new JLabel("locales de la Facultad con facilidad. !Seguridad y ");
			lblNewLabel_2.setFont(new Font("Modern No. 20", Font.PLAIN, 22));
			lblNewLabel_2.setBounds(12, 248, 480, 26);
			panel.add(lblNewLabel_2);

			lblDeTuMano = new JLabel("organización al alcance de tu mano!");
			lblDeTuMano.setFont(new Font("Modern No. 20", Font.PLAIN, 22));
			lblDeTuMano.setBounds(12, 275, 460, 26);
			panel.add(lblDeTuMano);
			btnNewButton_1.setIcon(new ImageIcon(AcercaDe.class.getResource("/images/adminMove.gif")));
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
					IniciarAdim inicio = new IniciarAdim(IniciarSesion.this);
					inicio.setVisible(true);
				}
			});
		}
		return panel;
	}
}
