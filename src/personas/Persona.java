package personas;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.Objects;

import util.ValidarCarnet;

=======
>>>>>>> origin/dariel
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
			this.numeroIdentidad = numeroIdentidad;
		}else 
			throw new IllegalArgumentException("No pueden haber campos vacios");
		
	 char [] n = numeroIdentidad.toCharArray();
	 String annio = ((n[0]- '0')*10+ (n[1]-'0'))+"0";
	 String mes = ((n[2]- '0')*10+ (n[3]-'0'))+"0";
	 String dia = ((n[4]- '0')*10+ (n[5]-'0'))+"0";
	 String siglo = ((n[0]- '0')*10+ (n[1]-'0'))+"0";
	 
	 
	 
		
		
		
		
	}
	
	@Override
	public String toString(){
		return nombre;
	}
	
	
}
