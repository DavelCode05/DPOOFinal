package util;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import personas.Persona;
import acceso.Registro;
import clasesAuxiliares.VisitantesAutorizadosPorX;

public class VisitantesAutorizadosTable extends DefaultTableModel{

	public VisitantesAutorizadosTable( VisitantesAutorizadosPorX v){
		String [] columnas =  {" Nombre ", " Carnet   "," Local De Acceso    "};
		this.setColumnIdentifiers(columnas);

		ArrayList<Registro> vv = v.getPerAutorizadas();     


		for(int i=0; i<vv.size();i++){
			Persona p = vv.get(i).getPersona();

			Object [] newR = new Object[]{ p.getNombre(),p.getNumeroIdentidad(),vv.get(i).getLocal().getTipo().name()}; 
			this.addRow(newR);
		}

	}


}
