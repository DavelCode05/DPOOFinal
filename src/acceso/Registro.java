package acceso;

import java.time.LocalDate;
import java.time.LocalTime;

import locales.Local;
import personas.Persona;

public class Registro { 
    private Persona persona;
    private Local local;
    private LocalTime horaEntrada;
    private LocalTime horaSalida; 
    private LocalDate fecha;

    public Registro(Persona persona, Local local) { 
        setPersona(persona);
        setLocal(local); 
        this.horaEntrada = LocalTime.now();
        this.fecha = LocalDate.now();

    }
    

    
    public void setHoraSalida(LocalTime horaSalida) {
		this.horaSalida = horaSalida;
	}



	public LocalTime getHoraSalida(){
    	return horaSalida;
    }


	public LocalTime getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(LocalTime horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public Persona getPersona() {
        return persona;
    }

    public Local getLocal() {
        return local;
    }



    public LocalDate getFecha() {
        return fecha;
    }

    public void setPersona(Persona persona) {
        if(persona != null)
            this.persona = persona;
        else
            throw new IllegalArgumentException("Persona no puede ser nula");
    }

    public void setLocal(Local local) {
        if(local != null)
            this.local = local;
        else
            throw new IllegalArgumentException("Local no puede ser nulo");
    }
}

//    public void setHoraEntrada(String horaEntrada) {
//        if(horaEntrada == null || !horaEntrada.matches("\\d{2}:\\d{2}"))
//            throw new IllegalArgumentException("Hora de entrada invalida. Use HH:mm");
//        else
//            this.horaEntrada = horaEntrada;
//    }


//    public void setFecha(LocalDate fecha) { // la fecha se obtiene actual , por la de la computadora
//        if(fecha == null)
//            throw new IllegalArgumentException("La fecha no puede ser null"); //Hacer mas validaciones
//        else
//            this.fecha = fecha;
//    }
//
//    
//}
