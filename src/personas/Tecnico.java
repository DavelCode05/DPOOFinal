package personas;

import enums.Plaza;

public class Tecnico extends Persona{
    private String plaza; // la plaza debe ser String 

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
        if(plaza == null){
            throw new IllegalArgumentException("Plaza no puede estar vacia");
        }
////        if (plaza != Plaza.TECNICO) { 
////            throw new IllegalArgumentException("La plaza debe ser Tecnico para Tecnico");
////        }
       this.plaza = plaza;
   }

    
}
