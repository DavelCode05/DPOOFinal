package personas;

import java.time.LocalTime;

import locales.Local;
import enums.TipoLocal;


public class Tecnico extends Persona{
	private String plaza; 
	 private static LocalTime horaEntradaTec = LocalTime.of(8,0);
		private static LocalTime horaSalidaTec = LocalTime.of(17,0);

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

	   @Override
	    public boolean verificarAccesoAlLocal(Local l){
	    	boolean permitido = false;
	    	LocalTime hora = LocalTime.now();
	    	if(TipoLocal.Servidores.name().equalsIgnoreCase(l.getTipo().name())|| TipoLocal.Laboratorio.name().equalsIgnoreCase(l.getTipo().name()) || TipoLocal.Estudiantes.name().equalsIgnoreCase(l.getTipo().name())
					|| TipoLocal.Especialistas.name().equalsIgnoreCase(l.getTipo().name())){
				permitido = true;
			}
			else if(TipoLocal.Decano.name().equalsIgnoreCase(l.getTipo().name())|| TipoLocal.Vicedecano.name().equalsIgnoreCase(l.getTipo().name()) || TipoLocal.Profesores.name().equalsIgnoreCase(l.getTipo().name())
					|| TipoLocal.Area_Administrativa.name().equalsIgnoreCase(l.getTipo().name()) || TipoLocal.Jefe_Departamento.name().equalsIgnoreCase(l.getTipo().name())){
				if(hora.isAfter(horaEntradaTec)&& hora.isBefore(horaSalidaTec)){
					permitido = true;
				}
				else 
					throw new IllegalArgumentException("Acceso Denegado: Fuera de horario");
			}
			else
	    		 throw new IllegalArgumentException("Acceso al local no permitido");
	    	return permitido;
	    	
	    }

	@Override
	public LocalTime getHoraSalida() {
		// TODO Auto-generated method stub
		return horaSalidaTec;
	}



}
