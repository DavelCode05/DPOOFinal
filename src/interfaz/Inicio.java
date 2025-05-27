package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.Canvas;
import java.security.Principal;

import javax.swing.JList;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;

import interfaz.Colores;
import interfaz.VerPersonal;

import com.sun.javafx.tk.Toolkit;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

public class Inicio extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnSesion;
	private JMenu mnAccesos;
	private JMenu mnReportes;
	private JMenu mnGestion;
	private JMenu mnInformacionAdicional;
	private JMenuItem mntmCerrar;
	private JMenuItem mntmSalir;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmInformacinDeLos;
	private JMenu mnVer;
	private JMenuItem mntmPersonal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					Inicializadora.iniciar();
					Inicio frame = new Inicio();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Inicio() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel(){
			public void paintComponent(Graphics g){
				Image img = java.awt.Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/images/Orqui2.png"));
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};
		setBackground(Colores.getAzulMarino());
		setBounds(100, 100, 1930, 1000);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setUndecorated(true);
		setLocationRelativeTo(null);
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getMenuBar_1());
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 20));
			menuBar.setForeground(Colores.getAzulMarino());
			menuBar.setBounds(0, 0, 1923, 80);
			menuBar.setBackground(Colores.getAzulMarino());
			menuBar.add(getMnSesion());
			menuBar.add(getMnVer());
			menuBar.add(getMnAccesos());
			menuBar.add(getMnReportes());
			menuBar.add(getMnGestion());
			menuBar.add(getMnInformacionAdicional());
		}
		return menuBar;
	}
	private JMenu getMnSesion() {
		if (mnSesion == null) {
			mnSesion = new JMenu("Sesi\u00F3n");
			mnSesion.setIcon(new ImageIcon(Inicio.class.getResource("/images/User.png")));
			mnSesion.setFont(new Font("Tahoma", Font.PLAIN, 24));
			mnSesion.setForeground(Color.GREEN);
			mnSesion.add(getMntmCerrar());
			mnSesion.add(getMntmSalir());
		}
		return mnSesion;
	}
	private JMenu getMnAccesos() {
		if (mnAccesos == null) {
			mnAccesos = new JMenu("Accesos");
			mnAccesos.setForeground(Color.GREEN);
			mnAccesos.setFont(new Font("Tahoma", Font.PLAIN, 24));
		}
		return mnAccesos;
	}
	private JMenu getMnReportes() {
		if (mnReportes == null) {
			mnReportes = new JMenu("Reportes");
			mnReportes.setForeground(Color.GREEN);
			mnReportes.setFont(new Font("Tahoma", Font.PLAIN, 24));
		}
		return mnReportes;
	}
	private JMenu getMnGestion() {
		if (mnGestion == null) {
			mnGestion = new JMenu("Gestion");
			mnGestion.setForeground(Color.GREEN);
			mnGestion.setFont(new Font("Tahoma", Font.PLAIN, 24));
		}
		return mnGestion;
	}
	private JMenu getMnInformacionAdicional() {
		if (mnInformacionAdicional == null) {
			mnInformacionAdicional = new JMenu("Acerca de");
			mnInformacionAdicional.setIcon(new ImageIcon(Inicio.class.getResource("/images/Info.png")));
			mnInformacionAdicional.setForeground(Color.GREEN);
			mnInformacionAdicional.setFont(new Font("Tahoma", Font.PLAIN, 24));
			mnInformacionAdicional.add(getMntmInformacinDeLos());
			mnInformacionAdicional.add(getMntmNewMenuItem());
		}
		return mnInformacionAdicional;
	}
	private JMenuItem getMntmCerrar() {
		if (mntmCerrar == null) {
			mntmCerrar = new JMenuItem("Cerrar sesi\u00F3n");
			mntmCerrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		}
		return mntmCerrar;
	}
	private JMenuItem getMntmSalir() {
		if (mntmSalir == null) {
			mntmSalir = new JMenuItem("Salir");
			mntmSalir.setFont(new Font("Tahoma", Font.PLAIN, 20));
			mntmSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
		}
		return mntmSalir;
	}
	private JMenuItem getMntmNewMenuItem() {
		if (mntmNewMenuItem == null) {
			mntmNewMenuItem = new JMenuItem("Acerca de");
			mntmNewMenuItem.setFont(new Font("Tahoma", Font.PLAIN, 20));
			mntmNewMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						AcercaDe dialog = new AcercaDe(Inicio.this);
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setVisible(true);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			});
		}
		return mntmNewMenuItem;
	}
	private JMenuItem getMntmInformacinDeLos() {
		if (mntmInformacinDeLos == null) {
			mntmInformacinDeLos = new JMenuItem("Informaci\u00F3n de los desarrolladores");
			mntmInformacinDeLos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		}
		return mntmInformacinDeLos;
	}
	private JMenu getMnVer() {
		if (mnVer == null) {
			mnVer = new JMenu("Ver");
			mnVer.setForeground(Color.GREEN);
			mnVer.setBackground(Color.WHITE);
			mnVer.setFont(new Font("Tahoma", Font.PLAIN, 24));
			mnVer.add(getMntmPersonal());
		}
		return mnVer;
	}
	private JMenuItem getMntmPersonal() {
		if (mntmPersonal == null) {
			mntmPersonal = new JMenuItem("Ver personal");
			mntmPersonal.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						VerPersonal dialog = new VerPersonal(Inicio.this);
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setVisible(true);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			});
			mntmPersonal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		}
		return mntmPersonal;
	}
}
