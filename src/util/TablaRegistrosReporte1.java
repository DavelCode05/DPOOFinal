package util;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import acceso.Registro;

public class TablaRegistrosReporte1 extends DefaultTableModel{

	public TablaRegistrosReporte1(){
		String [] columnas =  {"Nombre   ", "Local    "," Hora de Entrada    ", "Hora de salida    "};
		this.setColumnIdentifiers(columnas);



	}
	public void cargarInfo(ArrayList<Registro> registros)
	{
		for(int i=0; i < registros.size(); i++){

			Object [] newR = new Object[]{registros.get(i).getPersona().getNombre(), registros.get(i).getLocal().getTipo(), registros.get(i).getHoraEntrada(),
					registros.get(i).getHoraSalida()
			};
			this.addRow(newR);
		}
	}
}
