package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
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

import controllerClass.Facultad;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;

import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class IniciarAdim extends JDialog {

	private final JPanel contentPanel = new JPanel(){
		public void paintComponent(Graphics g){
			Image img= Toolkit.getDefaultToolkit().getImage(IniciarAdim.class.getResource("/images/loginDesenfocado.jpg"));
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		}
	};
	private final JTextField usuarioo = new JTextField();
	JLabel lblNewLabel;
	JLabel lblAdmin;
	JLabel lblNewLabel_1;

	private Facultad fac;
	private JButton button;
	private JButton btnAtras;
	private JPasswordField passwordField;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JPanel panel;
	private JPanel panel_1;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			IniciarAdim dialog = new IniciarAdim();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public IniciarAdim(/*JDialog padre*/) {
		
//		super(padre, "Iniciar Sesion Administrador", true);
		setBounds(100, 100, 406, 489);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setUndecorated(true);
		setLocationRelativeTo(null);
		usuarioo.setBorder(null);
		usuarioo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		usuarioo.setBounds(76, 257, 245, 33);
		contentPanel.add(usuarioo);
		usuarioo.setColumns(10);
		
		lblAdmin = new JLabel("Nombre de usuario:");
		lblAdmin.setForeground(Color.DARK_GRAY);
		lblAdmin.setFont(new Font("Modern No. 20", Font.PLAIN, 24));
		lblAdmin.setBounds(76, 222, 196, 22);
		contentPanel.add(lblAdmin);

		lblNewLabel = new JLabel("Contrase\u00F1a:");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Modern No. 20", Font.PLAIN, 24));
		lblNewLabel.setBounds(76, 303, 128, 22);
		contentPanel.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("Datos de inicio incorrectos");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(76, 393, 260, 14);
		contentPanel.add(lblNewLabel_1);
		lblNewLabel_1.setVisible(false);

		button = new JButton("Iniciar");
		button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
              
                button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
            }

            @Override
            public void mouseExited(MouseEvent e) {
               
            	button.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
            }
        });
	
		button.setFont(new Font("Modern No. 20", Font.PLAIN, 22));
		button.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
		button.setBackground(Color.WHITE);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(iniciar()){
					dispose();
					Inicio ini = new Inicio();
					ini.setVisible(true);
					
				}
			}
		});

		

		button.setBounds(76, 420, 107, 33);

		contentPanel.add(button);

		btnAtras = new JButton("Atr\u00E1s");
		btnAtras.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
              
                btnAtras.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
            }

            @Override
            public void mouseExited(MouseEvent e) {
               
            	btnAtras.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
            }
        });
		btnAtras.setFont(new Font("Modern No. 20", Font.PLAIN, 22));
		btnAtras.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
		btnAtras.setBackground(Color.WHITE);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();

				IniciarSesion inicio = new IniciarSesion();
				inicio.setVisible(true);	

				IniciarSesion ini = new IniciarSesion();
				ini.setVisible(true);

			}
		});
		btnAtras.setBounds(214, 420, 107, 33);
		contentPanel.add(btnAtras);
		contentPanel.add(getPasswordField());
		contentPanel.add(getLblNewLabel_2());
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(IniciarAdim.class.getResource("/images/password.png")));
		lblNewLabel_3.setBounds(153, 86, 96, 96);
		contentPanel.add(lblNewLabel_3);
		contentPanel.add(getPanel());
		
		panel_1 = new JPanel() {
			public void paintComponent(Graphics g) {
				Image img= Toolkit.getDefaultToolkit().getImage(IniciarAdim.class.getResource("/images/passwordEye.gif"));
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};
		panel_1.setBounds(291, 258, 30, 30);
		contentPanel.add(panel_1);
	}

	public boolean iniciar(){
		String usuario=usuarioo.getText();		
		String contrasena=passwordField.getText();
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
	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setFont(new Font("Tahoma", Font.PLAIN, 16));
			passwordField.setBorder(null);
			passwordField.setBounds(76, 334, 245, 33);
		}
		return passwordField;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("Inicio de Sesi\u00F3n");
			lblNewLabel_2.setForeground(Color.DARK_GRAY);
			lblNewLabel_2.setBackground(Color.WHITE);
			lblNewLabel_2.setFont(new Font("Modern No. 20", Font.BOLD, 40));
			lblNewLabel_2.setBounds(64, 13, 294, 75);
		}
		return lblNewLabel_2;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel(){
				public void paintComponent(Graphics g){
					Image img= Toolkit.getDefaultToolkit().getImage(IniciarAdim.class.getResource("/images/passwordMove.gif"));
					g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
				}
			};
			panel.setBounds(291, 335, 30, 30);
		}
		return panel;
	}
}
