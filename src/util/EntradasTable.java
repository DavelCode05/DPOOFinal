package util;

import javax.swing.table.DefaultTableModel;

public class EntradasTable extends DefaultTableModel {
	
	public EntradasTable( ){
		String [] columnas =  {"Horario   ", "Cantidad de entradas    "," Porcentaje    "};
		this.setColumnIdentifiers(columnas);
		
		
	}
	
	
	public void llenarTabla(int [] array){
		int total = 0;
		for(int i=0; i<array.length; i++){
		total= total+array[i];
		
		}
		
		for(int i=0; i<array.length; i++){
			String rango = (i + 8) + ":00-" + (i + 9) + ":00";
	        int cantidad = array[i];
	        String porcentaje;

	        if (total != 0) {
	            double valor = (double) array[i] * 100 / total;
	            porcentaje = String.format("%.1f%%", valor); // 1 decimal, ejemplo: 12.5%
	        } else {
	            porcentaje = "0.0%";
	        }
			Object [] newR = new Object[]{rango, cantidad, porcentaje};
			this.addRow(newR);
		}
	}
	
	
	

}
