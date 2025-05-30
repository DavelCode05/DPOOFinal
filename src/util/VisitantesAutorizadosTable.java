package util;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import personas.Persona;
import acceso.Registro;
import clasesAuxiliares.VisitantesAutorizadosPorX;

public class VisitantesAutorizadosTable extends DefaultTableModel{

	public VisitantesAutorizadosTable( ){
		String [] columnas =  {" Nombre ", " Carnet   "," Local De Acceso    "};
		this.setColumnIdentifiers(columnas);


	}

	public void llenarTabla(VisitantesAutorizadosPorX v){
		ArrayList<Registro> vv = v.getPerAutorizadas();     
		Persona p;
		for(int i=0; i < vv.size();i++){
			p = vv.get(i).getPersona();

			Object [] newR = new Object[]{ p.getNombre(),p.getNumeroIdentidad(),vv.get(i).getLocal().getTipo().name()}; 
			this.addRow(newR);
		}


	}
}
