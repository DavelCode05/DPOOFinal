package util;

import java.util.Date;

public class ValidarCarnet {
	public static boolean validarAnnioYSiglo(String year, String siglo)
	{
		boolean x=false;
		
		if(year.matches("^([0-9][0-9])$") && siglo.matches("^[0-8]$"))
		{
			if(siglo.matches("^[0-5]$"))
			{
				Date fecha = new Date();
				int annioA = (fecha.getYear()+1900);
				String cadenaAnnioR = "19"+year;
				int annioR = Integer.parseInt(cadenaAnnioR);
				
						
				int dif = annioA-annioR;
				
			
				if(dif>=18 && dif<=95)
					x=true;
				else
					x=false;	
			}
			else
				if(siglo.matches("^[6-8]$"))
				{
					Date fecha = new Date();
					int annioA = (fecha.getYear()+1900);
					String cadenaAnnioR = "20"+year;
					int annioR = Integer.parseInt(cadenaAnnioR);
					
					int dif = annioA-annioR;
					
					
					if(dif>=18 && dif<=95)
						x=true;
					else
						x=false;	
				}
			}
		
		return x;
	}
	
	public static boolean validarDiaYMes(String dia, String mes)
	{
		boolean x=false;
		
		if(mes.equals("01")||mes.equals("03")||mes.equals("05")||mes.equals("07")||mes.equals("08")||mes.equals("10")||mes.equals("12"))
			{
				if(dia.matches("^(0[1-9]|[1-2][0-9]|3[0-1])$"))
				x=true;
			
				else
				x=false;
			}
			else
				if(mes.equals("04")||mes.equals("06")||mes.equals("09")||mes.equals("11"))
				{
					if(dia.matches("^(0[1-9]|[1-2][0-9]|30)$"))
					x=true;
				
					else
					x=false;
				}
				else
					if(mes.equals("02"))
					{
						if(dia.matches("^(0[1-9]|[1-2][0-9])$"))
						x=true;
					
						else
						x=false;
					}
		
		return x;
	}
	
	public static boolean validarSexo(char sex, String sexonum)
	{
		boolean x= false;
		
		if(sex=='F')
			{
				int num= Integer.parseInt(sexonum);
				if(num%2!=0)
				{
					x=true;
				}
				else
					x=false;
			}
			else
				if(sex=='M')
				{
					int num= Integer.parseInt(sexonum);
					if(num%2==0)
					{
						x=true;
					}
					else
						x=false;
				}
		
		return x;
	}

}
