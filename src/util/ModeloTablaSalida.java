package util;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import acceso.Registro;
import personas.Persona;

public class ModeloTablaSalida extends DefaultTableModel{
	 
	public ModeloTablaSalida(){
		String [] columnas =  {" ", "Nombre   "," Local de entrada  ","Hora de entrada", "Hora salida"};
		this.setColumnIdentifiers(columnas);

	}
	
	public void cargarInfoGeneral(ArrayList<Registro> r){
		this.setRowCount(0);
		Object [] newR = null;
		boolean ro = false;
		for(int i=0; i < r.size(); i++){
			String hora = r.get(i).getHoraEntrada().format(DateTimeFormatter.ofPattern("HH:mm"));
                
			 newR = new Object[]{ro,r.get(i).getPersona().getNombre(), r.get(i).getLocal().getCodigo(),
					hora , r.get(i).getHoraSalida()==null? "No ha salido": r.get(i).getHoraSalida().format(DateTimeFormatter.ofPattern("HH:mm"))
					
			};
                
			this.addRow(newR);
                
		}
	}


	
	public Class<?> getColumnClass(int column){
		return column == 0? Boolean.class : Registro.class;
		
	}
}
