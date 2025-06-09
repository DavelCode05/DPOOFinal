package personas;

import enums.Plaza;

public class Administrativo extends Persona{
    private Plaza plaza;

    public Administrativo(String nombre, String numeroIdentidad, Plaza plaza) {
        super(nombre, numeroIdentidad);
        setPlaza(plaza);
    }

    public Plaza getPlaza() {
        return plaza;
    }

    public void setPlaza(Plaza plaza) { // esto se le va a dar a elegir , no va a haber que validarlo 
        if(plaza == null){
            throw new IllegalArgumentException("Plaza no puede estar vacia");
        }
        if (plaza != Plaza.Asesor && plaza != Plaza.Secretaria) {
            throw new IllegalArgumentException("La plaza debe ser Asesor o Secretaria para Administrativo");
        }
        this.plaza = plaza;
    }

}
