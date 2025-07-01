package interfaz;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import controllerClass.Facultad;

public class Inicio extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnSesion;
	private JMenu mnAccesos;
	private JMenu mnReportes;
	private JMenu mnInformacionAdicional;
	private JMenuItem mntmCerrar;
	private JMenuItem mntmSalir;
	private JMenuItem mntmNewMenuItem;
	private JMenu mnVer;
	private JMenuItem mntmPersonal;
	private JMenuItem mntmReporte;

	private Facultad fac;
	private JMenuItem mntmVerLocales;
	private JMenuItem mntmChequeoDeRegistros;


	/**
	 * Launch the application.
	 */
//		public static void main(String[] args) {
//			EventQueue.invokeLater(new Runnable() {
//				public void run() {
//					try {
//	//					Inicializadora.iniciar();
//						System.out.println(1111);
//						Inicio frame = new Inicio();
//						frame.setVisible(true);
//						frame.setLocationRelativeTo(null);
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//				}
//			});
//		}

	/**
	 * Create the frame.
	 */
	public Inicio() {
		
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
		
		setBackground(Colores.getAzulCielo());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel(){
			public void paintComponent(Graphics g){
				Image img = java.awt.Toolkit.getDefaultToolkit().getImage(Inicio.class.getResource("/images/NuevoFondo.png"));
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};
		setBackground(Colores.getAzulCielo());
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
			menuBar.setBorderPainted(false);
			menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 20));
			menuBar.setForeground(Colores.getAzulCielo());
			menuBar.setBounds(0, 0, 1923, 80);
			menuBar.setBackground(Colores.getAzulCielo());
			menuBar.add(getMnSesion());
			menuBar.add(getMnVer());
			menuBar.add(getMnAccesos());
			menuBar.add(getMnReportes());
			menuBar.add(getMnInformacionAdicional());
		}
		return menuBar;
	}
	private JMenu getMnSesion() {
		if (mnSesion == null) {
			mnSesion = new JMenu("Sesi\u00F3n");
			mnSesion.setIcon(new ImageIcon(Inicio.class.getResource("/images/user.png")));
			mnSesion.setFont(new Font("Modern No. 20", Font.PLAIN, 33));
			mnSesion.setForeground(Colores.getNegro());
			mnSesion.add(getMntmCerrar());
			mnSesion.add(getMntmSalir());
		}
		return mnSesion;
	}
	private JMenu getMnAccesos() {
		if (mnAccesos == null) {
			mnAccesos = new JMenu("Accesos");
			mnAccesos.setIcon(new ImageIcon(Inicio.class.getResource("/images/acceso.png")));
			mnAccesos.setForeground(Colores.getNegro());
			mnAccesos.setFont(new Font("Modern No. 20", Font.PLAIN, 33));
			
			JMenuItem mntmInformeDeRegistros = new JMenuItem("Informe de registros");
			mntmInformeDeRegistros.setBackground(Color.WHITE);
			mntmInformeDeRegistros.setFont(new Font("Modern No. 20", Font.BOLD, 25));
			mntmInformeDeRegistros.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					VerRegistros p = new VerRegistros(Inicio.this);
					p.setVisible(true);
				}
			});
			mnAccesos.add(mntmInformeDeRegistros);
		}
		return mnAccesos;
	}
	private JMenu getMnReportes() {
		if (mnReportes == null) {
			mnReportes = new JMenu("Reportes");
			mnReportes.setIcon(new ImageIcon(Inicio.class.getResource("/images/menu.png")));
			mnReportes.setForeground(Colores.getNegro());
			mnReportes.setFont(new Font("Modern No. 20", Font.PLAIN, 33));
			mnReportes.add(getMntmReporte());


			JMenuItem mntmNewMenuItem_1 = new JMenuItem("Informe de Acceso a la Facultad");
			mntmNewMenuItem_1.setBackground(Color.WHITE);
			
			mntmNewMenuItem_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					EleccionReporte3 rep3 = new EleccionReporte3(Inicio.this);
					rep3.setVisible(true);
				}
			});
			mntmNewMenuItem_1.setFont(new Font("Modern No. 20", Font.BOLD, 25));
//			mntmNewMenuItem_1.setForeground(new Color(0, 0, 0));
			mnReportes.add(mntmNewMenuItem_1);

			
			JMenuItem mntmDatosDeVisitantes = new JMenuItem("Datos de Visitantes Autorizados");
			mntmDatosDeVisitantes.setBackground(Color.WHITE);
			mntmDatosDeVisitantes.setFont(new Font("Modern No. 20", Font.BOLD, 25));
			mntmDatosDeVisitantes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					 TablaAutorizadoReporte4 tab = new TablaAutorizadoReporte4(Inicio.this);
					 tab.setVisible(true);
					
					
				}
			});
			mnReportes.add(mntmDatosDeVisitantes);

			mnReportes.add(getMntmChequeoDeRegistros());


			

		}
		return mnReportes;
	}
	private JMenu getMnInformacionAdicional() {
		if (mnInformacionAdicional == null) {
			mnInformacionAdicional = new JMenu("Acerca de");
			mnInformacionAdicional.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						AcercaDe dialog = new AcercaDe(Inicio.this);
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setVisible(true);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			});
			mnInformacionAdicional.setIcon(new ImageIcon(Inicio.class.getResource("/images/about.png")));
			mnInformacionAdicional.setForeground(Colores.getNegro());
			mnInformacionAdicional.setFont(new Font("Modern No. 20", Font.PLAIN, 33));
			mnInformacionAdicional.add(getMntmNewMenuItem());
		}
		return mnInformacionAdicional;
	}
	private JMenuItem getMntmCerrar() {
		if (mntmCerrar == null) {
			mntmCerrar = new JMenuItem("Cerrar Sesi\u00F3n");
			mntmCerrar.setBackground(Color.WHITE);
//			mntmCerrar.setForeground(Color.BLACK);
			mntmCerrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
					IniciarSesion ini = new IniciarSesion();
					ini.setVisible(true);
				}
			});
			mntmCerrar.setFont(new Font("Modern No. 20", Font.BOLD, 25));
		}
		return mntmCerrar;
	}
	private JMenuItem getMntmSalir() {
		if (mntmSalir == null) {
			mntmSalir = new JMenuItem("Salir");
			mntmSalir.setBackground(Color.WHITE);
//			mntmSalir.setForeground(Color.BLACK);
			mntmSalir.setFont(new Font("Modern No. 20", Font.BOLD, 25));
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
			mntmNewMenuItem.setBackground(Color.WHITE);
			mntmNewMenuItem.setForeground(Color.BLACK);
			mntmNewMenuItem.setFont(new Font("Modern No. 20", Font.BOLD, 25));
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
	private JMenu getMnVer() {
		if (mnVer == null) {
			mnVer = new JMenu("Gesti\u00F3n");
			mnVer.setIcon(new ImageIcon(Inicio.class.getResource("/images/gestion.png")));
			mnVer.setForeground(Colores.getNegro());
			mnVer.setBackground(Color.WHITE);
			mnVer.setFont(new Font("Modern No. 20", Font.PLAIN, 33));
			mnVer.add(getMntmPersonal());
			mnVer.add(getMntmVerLocales());
		}
		return mnVer;
	}
	private JMenuItem getMntmPersonal() {
		if (mntmPersonal == null) {
			mntmPersonal = new JMenuItem("Ver personal");
			mntmPersonal.setBackground(Color.WHITE);
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
			mntmPersonal.setFont(new Font("Modern No. 20", Font.BOLD, 25));
		}
		return mntmPersonal;
	}
	private JMenuItem getMntmReporte() {
		if (mntmReporte == null) {
			mntmReporte = new JMenuItem("Chequeo de Registros Personal");
			mntmReporte.setBackground(Color.WHITE);
//			mntmReporte.setForeground(Color.BLACK);
			mntmReporte.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					TablaReporte1 tabla = new TablaReporte1(Inicio.this);
					tabla.setVisible(true);
				}
			});
			mntmReporte.setFont(new Font("Modern No. 20", Font.BOLD, 25));
		}
		return mntmReporte;
	}
	private JMenuItem getMntmVerLocales() {
		if (mntmVerLocales == null) {
			mntmVerLocales = new JMenuItem("Ver Locales");
			mntmVerLocales.setBackground(Color.WHITE);
			mntmVerLocales.addActionListener(new ActionListener() {

//				public void actionPerformed(ActionEvent arg0) {
//					VerLocales l = new VerLocales(Inicio.this);
//					l.setVisible(true);
//					

				public void actionPerformed(ActionEvent e) {
					try {
						VerLocales dialog = new VerLocales(Inicio.this);
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setVisible(true);
					} catch (Exception e1) {
						e1.printStackTrace();
					}

				}
			});
			mntmVerLocales.setFont(new Font("Modern No. 20", Font.BOLD, 25));
		}
		return mntmVerLocales;
	}
	
	private JMenuItem getMntmChequeoDeRegistros() {
		if (mntmChequeoDeRegistros == null) {
			mntmChequeoDeRegistros = new JMenuItem("Chequeo de Registros Locales");
			mntmChequeoDeRegistros.setBackground(Color.WHITE);
			mntmChequeoDeRegistros.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
						TablaReporte2 tabla2 = new TablaReporte2(Inicio.this);
						tabla2.setVisible(true);
				}
			});
			mntmChequeoDeRegistros.setFont(new Font("Modern No. 20", Font.BOLD, 25));
		}
		return mntmChequeoDeRegistros;
	}
}
