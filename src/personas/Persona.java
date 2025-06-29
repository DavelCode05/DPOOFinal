package personas;


import util.ValidarCarnet;


public abstract class Persona {
	protected String nombre;
	protected String numeroIdentidad;

	public Persona(String nombre, String numeroIdentidad) {
		setNombre(nombre);
		setNumeroIdentidad(numeroIdentidad);
	}
	
	public Persona(){
	
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		if (nombre != null && !nombre.replaceAll(" ", "").equals("")) {
			this.nombre = nombre;
		}else 
			throw new IllegalArgumentException("No pueden haber campos vacios");	
	}


	public String getNumeroIdentidad() {
		
		
		return numeroIdentidad;
	}
	public void setNumeroIdentidad(String numeroIdentidad) {
		
		if (numeroIdentidad != null && !numeroIdentidad.replaceAll(" ", "").equals("")) {
			char [] n = numeroIdentidad.toCharArray();
			 String annio = String.valueOf(n[0])+String.valueOf(n[1]);
			
			 String mes = String.valueOf(n[2])+String.valueOf(n[3]);
		
			 String dia = String.valueOf(n[4])+String.valueOf(n[5]);
			
			 String siglo = String.valueOf(n[6]);
			
			 if( ValidarCarnet.validarAnnioYSiglo(annio, siglo) && ValidarCarnet.validarDiaYMes(dia, mes)) {
			    this.numeroIdentidad = numeroIdentidad;
			 }
			 else 
				 throw new IllegalArgumentException("No pueden haber campos vacios");
				
		}else 
			throw new IllegalArgumentException("No pueden haber campos vacios");
	 
	 
	 
	 
	 
			
	}
	
	@Override
	public String toString(){
		return nombre;
	}
	
	
}
