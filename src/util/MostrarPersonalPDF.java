package util;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import personas.Persona;

public class MostrarPersonalPDF extends DefaultTableModel {
	public MostrarPersonalPDF(){
		String [] columnas =  {"Nombre","Rol", "Carnet de Identidad"};
		this.setColumnIdentifiers(columnas);



	}
	public void cargarInfo(ArrayList<Persona> personas)
	{
		this.setRowCount(0);
		for(int i=0; i < personas.size(); i++){
			

			Object [] newR = new Object[]{personas.get(i).getNombre(), personas.get(i).getClass().getSimpleName(), personas.get(i).getNumeroIdentidad()
					
			};
			this.addRow(newR);
		}
	}
	
	@Override
	public boolean isCellEditable(int row, int column){
		return false;
	}

}
