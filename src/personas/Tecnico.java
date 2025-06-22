package personas;


public class Tecnico extends Persona{
	private String plaza; 

	public Tecnico(String nombre, String numeroIdentidad, String plaza) {
		super(nombre,  numeroIdentidad);
		setPlaza(plaza);
	}

	public Tecnico() {
		// TODO Auto-generated constructor stub
	}

	public String getPlaza() {
		return plaza;
	}

	public void setPlaza(String plaza) {
		String plaza2 = plaza;
		if(plaza2 != null && !plaza2.replaceAll(" ", "").equals("")){
			this.plaza = plaza2;
		}else
			throw new IllegalArgumentException("Plaza no puede estar vacia");
	}


}
