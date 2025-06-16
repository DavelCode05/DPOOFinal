package personas;

public class Estudiante extends Persona{
    private int anio;
    private int grupo;
    
    public Estudiante(){
    	
    }
    
    public Estudiante(String nombre,  String numeroIdentidad, int anio, int grupo) {
        super(nombre,  numeroIdentidad);
        setAnio(anio);
        setGrupo(grupo);
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        if(anio < 1 && anio > 5)//Validar comas y todo lo demas
            throw new IllegalArgumentException("El anio debe ser entre 1 y 5.");
        else
            this.anio = anio;
    }

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) { // se deberia , en cuba los grupos son por numero 
        //Validar
        this.grupo = grupo;
    }

    
}
