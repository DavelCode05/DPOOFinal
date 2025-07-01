package personas;

import java.time.LocalTime;

import locales.Local;
import enums.TipoLocal;

public class Especialista extends Persona{
    private String proyecto;
    private static LocalTime horaEntradaEsp = LocalTime.of(8,0);
	private static LocalTime horaSalidaEsp = LocalTime.of(17,0);

    public Especialista(String nombre,  String numeroIdentidad, String proyecto) {
        super(nombre,  numeroIdentidad);
        setProyecto(proyecto);
        
    }

    public static LocalTime getHoraEntradaEsp() {
		return horaEntradaEsp;
	}

	public static void setHoraEntradaEsp(LocalTime horaEntradaEsp) {
		Especialista.horaEntradaEsp = horaEntradaEsp;
	}


	public static void setHoraSalidaEsp(LocalTime horaSalidaEsp) {
		Especialista.horaSalidaEsp = horaSalidaEsp;
	}

	public Especialista() {
		// TODO Auto-generated constructor stub
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
			if(hora.isAfter(horaEntradaEsp)&& hora.isBefore(horaSalidaEsp)){
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
		return horaSalidaEsp;
	}

}
