package personas;

public class Especialista extends Persona{
    private String proyecto;

    public Especialista(String nombre,  String numeroIdentidad, String proyecto) {
        super(nombre,  numeroIdentidad);
        setProyecto(proyecto);
    }

    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        if (proyecto != null && !proyecto.replaceAll(" ", "").equals("")) {
			this.proyecto = proyecto;
		}else
			throw new IllegalArgumentException("El proyecto no puede estar vacio.");
    }

}
