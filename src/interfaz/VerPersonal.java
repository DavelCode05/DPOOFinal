package interfaz;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import interfaz.Colores;
import interfaz.VerPersonal;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JScrollPane;
import javax.swing.JTable;







import com.sun.glass.events.MouseEvent;

import util.ButtonRendererEditor;
import util.MostrarPersonal;
import controllerClass.Facultad;

import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseAdapter;

public class VerPersonal extends JDialog {

	private final JPanel contentPanel;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JTable tablepers;
	private Facultad fac;
	private MostrarPersonal tablemodel;
	int row;

	/**
	 * Launch the application.
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
	public VerPersonal(JFrame p) {
		super(p,true);
		setBounds(430, 150, 800, 500);
		fac = Facultad.getFacultad();
		contentPanel = new JPanel();
//		
		setUndecorated(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getBtnNewButton_1());
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 97, 726, 330);
		contentPanel.add(scrollPane);
		
		tablepers = new JTable();
		
		tablemodel = new MostrarPersonal();
		
		
		scrollPane.setViewportView(tablepers);
		tablepers.setModel(tablemodel);
		tablepers.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tablepers.setRowHeight(29);
		tablepers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(140, 27, 89, 23);
		contentPanel.add(btnNewButton_2);
	
		
		

		
		tablepers.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(java.awt.event.MouseEvent arg0) {
				 row = tablepers.rowAtPoint(arg0.getPoint());
				if(row!=-1){
					tablepers.setRowSelectionInterval(row,row);
					tablepers.setAutoscrolls(true);
					
					tablepers.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(java.awt.event.MouseEvent arg0) {
							CRUDVerPersonal pp= new CRUDVerPersonal(VerPersonal.this, fac.getPersonal().get(row));
							pp.setVisible(true);
						}
							
					});
					
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
		tablemodel.cargarInfo(fac.getPersonal());
		
	

	}






	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("X");
			btnNewButton_1.setBounds(732, 11, 58, 48);
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		}
		return btnNewButton_1;
	}
}
