package personas;

import java.time.LocalTime;

import locales.Local;
import enums.TipoLocal;

public class Estudiante extends Persona{
	private int anio;
	private int grupo;
	private static LocalTime horaEntradaEst = LocalTime.of(8,0);
	private static LocalTime horaSalidaEst = LocalTime.of(17,0);

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
	
	@Override
    public boolean verificarAccesoAlLocal(Local l){
    	boolean permitido = false;
    	LocalTime hora = LocalTime.now();
    	 if(TipoLocal.Estudiantes.name().equalsIgnoreCase(l.getTipo().name()) || TipoLocal.Aula.name().equalsIgnoreCase(l.getTipo().name())
				|| TipoLocal.Laboratorio.name().equalsIgnoreCase(l.getTipo().name()) || TipoLocal.Profesores.name().equalsIgnoreCase(l.getTipo().name())){
			if(hora.isAfter(horaEntradaEst)&& hora.isBefore(horaSalidaEst)){
				permitido = true;
			}
			else 
				throw new IllegalArgumentException("Acceso Denegado: Fuera de horario");
		}
    	 else
    		 throw new IllegalArgumentException("Acceso al local no permitido");
    	return permitido;
    	
    }


}
