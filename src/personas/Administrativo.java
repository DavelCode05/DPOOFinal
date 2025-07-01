package personas;

import java.time.LocalTime;

import locales.Local;
import enums.Plaza;

public class Administrativo extends Persona{
	private Plaza plaza;
	private static LocalTime horaEntradaAdmin = LocalTime.of(8,0);
	private static LocalTime horaSalidaAdmin = LocalTime.of(17,0);

	public static LocalTime getHoraEntradaAdmin() {
		return horaEntradaAdmin;
	}

	public static void setHoraEntradaAdmin(LocalTime horaEntradaAdmin) {
		Administrativo.horaEntradaAdmin = horaEntradaAdmin;
	}

	public static LocalTime getHoraSalidaAdmin() {
		return horaSalidaAdmin;
	}

	public static void setHoraSalidaAdmin(LocalTime horaSalidaAdmin) {
		Administrativo.horaSalidaAdmin = horaSalidaAdmin;
	}

	public Administrativo(String nombre, String numeroIdentidad, Plaza plaza) {
		super(nombre, numeroIdentidad);
		setPlaza(plaza);
	}

	public Administrativo() {
		// TODO Auto-generated constructor stub
	}

	public Plaza getPlaza() {
		return plaza;
	}

	public void setPlaza(Plaza plaza) { 
		this.plaza = plaza;
	}

	
	@Override
	public boolean verificarAccesoAlLocal(Local l){
				
		return true;
	}

}
