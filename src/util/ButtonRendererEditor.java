package util;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.*;

import personas.Persona;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ButtonRendererEditor extends DefaultCellEditor implements TableCellRenderer {
	private JPanel panel;
	private JButton btnEditar, btnEliminar;
	private JButton ver;
	private JTable table;
	private ArrayList<Persona> listaPersonas;
	private int row;

	public ButtonRendererEditor(final JTable tablen  ,final ArrayList<Persona> listaPersonas) {
		super(new JCheckBox());
		
		
		this.table = table;
		this.listaPersonas = listaPersonas;

		panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnEditar = new JButton("Editar");
		btnEditar.setPreferredSize(new Dimension( 39, 23));
		

		// Acción para editar
		btnEditar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Persona personaSeleccionada = listaPersonas.get(row);
				String nuevoNombre = JOptionPane.showInputDialog("Nuevo nombre:", personaSeleccionada.getNombre());
				if (nuevoNombre != null && !nuevoNombre.isEmpty()) {
					personaSeleccionada.setNombre(nuevoNombre);
					actualizarTabla();
				}
			}
		});

		// Acción para eliminar
//		btnEliminar.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				int confirm = JOptionPane.showConfirmDialog(null, "¿Eliminar esta persona?", "Confirmar", JOptionPane.YES_NO_OPTION);
//				if (confirm == JOptionPane.YES_OPTION) {
//					listaPersonas.remove(row);
//					actualizarTabla();
//				}
//			}
//		});
		
		
		btnEditar.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseEntered(MouseEvent e) {
              
                btnEditar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
            }

            @Override
            public void mouseExited(MouseEvent e) {
               
            	btnEditar.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
            }
       
			
		});
		
//      btnEditar.addMouseMotionListener(new MouseMotionListener() {
//			
//			@Override
//			public void mouseMoved(java.awt.event.MouseEvent arg0) {
//				int row=tablen.rowAtPoint(arg0.getPoint());
//				if(row!=-1){
//					btnEditar.setEnabled(true);
//			
//					
//				}
////				else{
////					tablepers.clearSelection();
////				}				
//			}
//
//			@Override
//			public void mouseDragged(java.awt.event.MouseEvent arg0) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			
//		});
		
		panel.add(btnEditar);
		
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		return panel;
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		this.row = row;
		return panel;
	}

	@Override
	public Object getCellEditorValue() {
		return "Acciones";
	}

	private void actualizarTabla() {
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setRowCount(0);
		for (Persona persona : listaPersonas) {
			modelo.addRow(new Object[]{persona.getNombre() , persona.getNumeroIdentidad(), persona.getClass().getSimpleName()});
		}
	}
}


