package util;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import acceso.Registro;

public class TablaRegistrosReporte1 extends DefaultTableModel{

	public TablaRegistrosReporte1(){
		String [] columnas =  {"Fecha   ", "Local    "," Hora de Entrada    ", "Hora de salida    "};
		this.setColumnIdentifiers(columnas);



	}
	public void cargarInfo(ArrayList<Registro> registros)
	{
		for(int i=0; i < registros.size(); i++){
			String hora= registros.get(i).getHoraEntrada().format(DateTimeFormatter.ofPattern("HH:mm"));

			Object [] newR = new Object[]{registros.get(i).getFecha().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) , registros.get(i).getLocal().getTipo(), hora,
					registros.get(i).getHoraSalida()
			};
			this.addRow(newR);
		}
	}
}
