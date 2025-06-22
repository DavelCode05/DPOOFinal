package personas;

import enums.Plaza;

public class Administrativo extends Persona{
    private Plaza plaza;

    public Administrativo(String nombre, String numeroIdentidad, Plaza plaza) {
        super(nombre, numeroIdentidad);
        setPlaza(plaza);
    }

    public Administrativo() {
		// TODO Auto-generated constructor stub
	}

	public Plaza getPlaza() {
        return plaza;
    }

    public void setPlaza(Plaza plaza) { 
        this.plaza = plaza;
    }
    
  

}
