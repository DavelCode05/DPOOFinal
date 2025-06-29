package personas;

import java.time.LocalTime;

import enums.TipoLocal;
import locales.Local;

public class Visitante extends Persona{
    private String areaUniversidad;
    private String motivoVisita;
    private Persona autorizadoPor;
    private static LocalTime horaEntradaVis = LocalTime.of(8,0);
	private static LocalTime horaSalidaVis = LocalTime.of(12,0);
    
    public Visitante(){
   
    }
    
    public Visitante(String nombre, String numeroIdentidad, String areaUniversidad,
            String motivoVisita, Persona autorizadoPor) {
        super(nombre, numeroIdentidad);
        setAreaUniversidad(areaUniversidad);
        setMotivoVisita(motivoVisita);
        setAutorizadoPor(autorizadoPor);
    }

    public String getAreaUniversidad() {
        return areaUniversidad;
    }

    public String getMotivoVisita() {
        return motivoVisita;
    }

    public Persona getAutorizadoPor() {
        return autorizadoPor;
    }

    public void setAreaUniversidad(String areaUniversidad) {
        if (areaUniversidad != null && !areaUniversidad.replaceAll(" ", "").equals("")) {
			this.areaUniversidad = areaUniversidad;
		}else
			throw new IllegalArgumentException("No pueden haber campos vacios");
    }

    public void setMotivoVisita(String motivoVisita) {
        if (motivoVisita != null && !motivoVisita.replaceAll(" ", "").equals("")) {
			this.motivoVisita = motivoVisita;
		}else
			throw new IllegalArgumentException("No pueden haber campos vacios");
    }

    public void setAutorizadoPor(Persona autorizadoPor) {// validar los tipos de persona que no pueden autorizar 
        if (autorizadoPor != null) {
			this.autorizadoPor = autorizadoPor;
		}else
			throw new IllegalArgumentException("No pueden haber campos vacios");
    }

	@Override
	public boolean verificarAccesoAlLocal(Local l) {
		boolean permitido = false;
    	LocalTime hora = LocalTime.now();
			if(hora.isAfter(horaEntradaVis)&& hora.isBefore(horaSalidaVis)){
				permitido = true;
			}
			else 
				throw new IllegalArgumentException("Acceso Denegado: Fuera de horario");
		
    	return permitido;
	}
    
    
}
