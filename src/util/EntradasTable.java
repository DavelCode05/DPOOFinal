package util;

import javax.swing.table.DefaultTableModel;

public class EntradasTable extends DefaultTableModel {
	
	public EntradasTable( int [] array){
		String [] columnas =  {"Horario   ", "Cantidad de entradas    "," Porcentaje    "};
		this.setColumnIdentifiers(columnas);
		
		int total = 0;
		for(int i=0; i<array.length; i++){
		total= total+array[i];
		
		}
		
		for(int i=0; i<array.length; i++){
			
			Object [] newR = new Object[]{i+8+":00-"+ (i+8+1)+":00", array[i], total!=0?array[i]*100/total:0+"%"
			};
			this.addRow(newR);
		}
	}
	
	
	

}
