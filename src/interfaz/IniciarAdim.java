package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IniciarAdim extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private final JTextField usuarioo = new JTextField();
	private JTextField contra;
	JLabel lblNewLabel;
	JLabel lblAdmin;
	JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			IniciarAdim dialog = new IniciarAdim();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public IniciarAdim(JDialog padre) {
		super(padre, "Iniciar Sesion Administrador", true);
		setBounds(100, 100, 308, 368);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 239, 213));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setUndecorated(true);
		setLocationRelativeTo(null);
		

		contra = new JTextField();
		contra.setBounds(129, 165, 140, 28);
		contentPanel.add(contra);
		contra.setColumns(10);
		usuarioo.setBounds(129, 126, 140, 28);
		contentPanel.add(usuarioo);
		usuarioo.setColumns(10);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(255, 240, 245));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\nicol\\Pictures\\inicio2.png"));
		lblNewLabel.setBounds(95, 0, 97, 117);
		contentPanel.add(lblNewLabel);
		
		lblAdmin = new JLabel("Usuario");
		lblAdmin.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblAdmin.setBounds(22, 126, 55, 14);
		contentPanel.add(lblAdmin);

		lblNewLabel = new JLabel("Contrase\u00F1a");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel.setBounds(22, 171, 97, 14);
		contentPanel.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("Datos de inicio incorrectos");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(22, 241, 260, 14);
		contentPanel.add(lblNewLabel_1);
		lblNewLabel_1.setVisible(false);

		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(iniciar()){
					dispose();
					Inicio ini = new Inicio();
					ini.setVisible(true);
					
				}
			}
		});
		btnIniciar.setBounds(30, 280, 89, 23);
		contentPanel.add(btnIniciar);

		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnAtras.setBounds(152, 280, 89, 23);
		contentPanel.add(btnAtras);
	}

	public boolean iniciar(){
		String usuario=usuarioo.getText();		
		String contrasena=contra.getText();
		boolean corr = true;

		if(usuario =="" || contrasena == "" || !usuario.equals("Admin") || !contrasena.equals("1234")){
			lblNewLabel_1.setVisible(true);
			corr = false;

		}
		else{
			lblNewLabel_1.setVisible(false);
			corr = true;
		}

		return corr;
	}
}
