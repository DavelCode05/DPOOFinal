package personas;

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
		
	}
	
	@Override
	public String toString(){
		return nombre;
	}
	
	
}
