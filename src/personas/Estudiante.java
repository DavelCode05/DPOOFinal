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
		if(anio < 1 && anio > 5)
			throw new IllegalArgumentException("El anio debe ser entre 1 y 5.");
		else
			this.anio = anio;
	}

	public int getGrupo() {
		return grupo;
	}

	public void setGrupo(int grupo) {
		if(grupo > 0 && grupo < 55)
			this.grupo = grupo;
		else
			throw new IllegalArgumentException("Error");
	}


}
