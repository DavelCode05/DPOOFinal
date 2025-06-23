package util;

import javax.swing.table.DefaultTableModel;

public class LocalesRep3TableModel extends DefaultTableModel{


	public LocalesRep3TableModel( ){
		String [] columnas =  {"Local   ", "Cantidad de entradas    ","Porcentaje    "};
		this.setColumnIdentifiers(columnas);


	}


	public void llenarTabla(int [] array, String [] locales){
		int total = 0;
		for(int i=0; i<array.length; i++){
			total= total+array[i];

		}

		for(int i=0; i<array.length; i++){
			 String local = locales[i];
		        int cantidad = array[i];
		        String porcentaje;

		        if (total != 0) {
		            double valor = (double) cantidad * 100 / total;
		            porcentaje = String.format("%.1f%%", valor); // 1 decimal
		        } else {
		            porcentaje = "0.0%";
		        }

		        Object[] newR = new Object[]{local, cantidad, porcentaje};
			this.addRow(newR);
		}
	}
}
