package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import controllerClass.Facultad;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import util.MostrarLocales;
import util.MostrarPersonal;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;

public class VerLocales extends JDialog {

	private final JPanel contentPanel;
	private Facultad fac;
	private JScrollPane scrollPane;
	private JTable tableloc;
	int row;
	private MostrarLocales tablemodel;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VerLocales dialog = new VerLocales();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VerLocales(/*JFrame p*/) {
//		super(p, true);
		fac = Facultad.getFacultad();
		setBounds(100, 100, 1234, 760);
		contentPanel = new JPanel(){
			public void paintComponent(Graphics g){
				Image img= Toolkit.getDefaultToolkit().getImage(Inicio.class.getResource("/images/fondoDesenfocado.png"));
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};
		setUndecorated(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getScrollPane());
		contentPanel.add(getBtnNewButton());
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBackground(Color.WHITE);
			scrollPane.getViewport().setBackground(Colores.getLogin());
			scrollPane.setBorder(new EmptyBorder(2, 2, 2, 2));
			scrollPane.setBounds(33, 153, 591, 460);
			
			tableloc = new JTable();
			
			tablemodel = new MostrarLocales();
			
			scrollPane.setViewportView(tableloc);
			tableloc.setModel(tablemodel);
			tableloc.setFont(new Font("Tahoma", Font.PLAIN, 16));
			tableloc.setRowHeight(29);
			tableloc.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tableloc.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 17));
			tableloc.setForeground(Color.WHITE);
			tableloc.setBackground(Colores.getAzulCielo());
			tableloc.setGridColor(Colores.getLogin());
			tableloc.getTableHeader().setBackground(Colores.getLogin());
			tableloc.setBorder(null);
			
			tableloc.addMouseMotionListener(new MouseMotionListener() {
				
				@Override
				public void mouseMoved(java.awt.event.MouseEvent arg0) {
					 row = tableloc.rowAtPoint(arg0.getPoint());
					if(row!=-1){
						tableloc.setRowSelectionInterval(row,row);
						tableloc.setAutoscrolls(true);
						
						
						
					}
					else{
						tableloc.clearSelection();
					}				
				}

				@Override
				public void mouseDragged(java.awt.event.MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				
			});
			tablemodel.cargarInfo(fac.getLocales());
		}
		return scrollPane;
	}
	
	
	private JButton getBtnNewButton() {
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
}
