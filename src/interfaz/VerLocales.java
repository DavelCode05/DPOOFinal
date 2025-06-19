package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import controllerClass.Facultad;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import util.MostrarLocales;
import util.MostrarPersonal;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
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
	private JButton btnNewButton;

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
			scrollPane.setBackground(Colores.getAzulCielo());
			scrollPane.getViewport().setBackground(Colores.getLogin());
			scrollPane.setBorder(new EmptyBorder(3, 3, 3, 3));
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
		if (btnNewButton == null) {
			btnNewButton = new JButton("New button");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			btnNewButton.setBounds(60, 13, 97, 25);
		}
		return btnNewButton;
	}
}
