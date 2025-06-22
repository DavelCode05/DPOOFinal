package util;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import acceso.Registro;

public class TablaRegistrosReporte2 extends DefaultTableModel{

	public TablaRegistrosReporte2(){
		String [] columnas =  {"Nombre   ", "Carnet de Identidad    "," Hora de Entrada    ", "Hora de salida    ", "  Fecha   "};
		this.setColumnIdentifiers(columnas);



	}
	public void cargarInfo(ArrayList<Registro> registros)
	{
		for(int i=0; i < registros.size(); i++){
			String hora= registros.get(i).getHoraEntrada().format(DateTimeFormatter.ofPattern("HH:mm"));

			Object [] newR = new Object[]{registros.get(i).getPersona().getNombre(), registros.get(i).getPersona().getNumeroIdentidad(), hora,
					registros.get(i).getHoraSalida(), registros.get(i).getFecha().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
			};
			this.addRow(newR);
		}
	}
}
