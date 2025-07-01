package util;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import locales.Local;

public class MostrarLocales extends DefaultTableModel{
	public MostrarLocales(){
		String [] columnas =  {"Tipo de local  ", "Código    "};
		this.setColumnIdentifiers(columnas);



	}
	public void cargarInfo(ArrayList<Local> locales)
	{
		for(int i=0; i < locales.size(); i++){
			

			Object [] newR = new Object[]{locales.get(i).getTipo() , locales.get(i).getCodigo()
					
			};
			this.addRow(newR);
		}
	}
	
	@Override
	public boolean isCellEditable(int row, int column){
		return false;
	}
}
