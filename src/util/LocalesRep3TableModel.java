package util;

import javax.swing.table.DefaultTableModel;

public class LocalesRep3TableModel extends DefaultTableModel{


	public LocalesRep3TableModel( ){
		String [] columnas =  {"Fecha   ", "Cantidad de entradas    "," Porcentaje    "};
		this.setColumnIdentifiers(columnas);


	}


	public void llenarTabla(int [] array, String [] locales){
		int total = 0;
		for(int i=0; i<array.length; i++){
			total= total+array[i];

		}

		for(int i=0; i<array.length; i++){

			Object [] newR = new Object[]{locales[i], array[i], total!=0?array[i]*100/total:0+"%"
			};
			this.addRow(newR);
		}
	}
}
