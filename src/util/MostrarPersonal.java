package util;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import personas.Persona;
import acceso.Registro;

public class MostrarPersonal extends DefaultTableModel{
	
	public MostrarPersonal(){
		String [] columnas =  {"Nombre  ", "Carnet de Identidad    "," Rol  ", "Acciones"};
		this.setColumnIdentifiers(columnas);



	}
	public void cargarInfo(ArrayList<Persona> personas)
	{
		for(int i=0; i < personas.size(); i++){
			

			Object [] newR = new Object[]{personas.get(i).getNombre() , personas.get(i).getNumeroIdentidad(), personas.get(i).getClass().getSimpleName()
					
			};
			this.addRow(newR);
		}
	}

}
