package personas;

import java.time.LocalTime;

import locales.Local;
import enums.TipoContrato;
import enums.TipoLocal;

public class Profesor extends Persona{
	private String departamento;
	private String catDoc; 
	private String catCient;
	private TipoContrato tipoContrato;
	private static LocalTime horaEntradaProf = LocalTime.of(8,0);
	private static LocalTime horaSalidaProf = LocalTime.of(17,0);

	public Profesor(String nombre, String numeroIdentidad, String departamento,
			String catDoc, String catCient, TipoContrato tipoContrato) {
		super(nombre,numeroIdentidad);
		setDepartamento(departamento);
		setCatCient(catCient);
		setCatDoc(catDoc);
		setTipoContrato(tipoContrato);
	}

	public Profesor() {
		// TODO Auto-generated constructor stub
	}

	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		if (departamento != null && !departamento.replaceAll(" ", "").equals("")) {
			this.departamento = departamento;
		}else
			throw new IllegalArgumentException("El nombre del departamento no puede estar vacio.");

	}

	public String getCatDoc() {
		return catDoc;
	}
	public void setCatDoc(String catDoc) { 
		if (catDoc != null && !catDoc.replaceAll(" ", "").equals("")) {
			this.catDoc = catDoc;
		}else
			throw new IllegalArgumentException("El nombre no puede estar vacio.");

	}

	public String getCatCient() {
		return catCient;
	}
	public void setCatCient(String catCient) {
		if (catCient != null && !catCient.replaceAll(" ", "").equals("")) {
			this.catCient = catCient;
		}else
			throw new IllegalArgumentException("El nombre no puede estar vacio.");

	}

	public TipoContrato getTipoContrato() {
		return tipoContrato;
	}
	public void setTipoContrato(TipoContrato tipoContrato) {
		if (tipoContrato != null) {
			this.tipoContrato = tipoContrato;
		}else
			throw new IllegalArgumentException("El campo no puede estar vacio.");

	}

	@Override
	public boolean verificarAccesoAlLocal(Local l){
		boolean permitido = false;
		LocalTime hora = LocalTime.now();
		if(TipoLocal.Aula.name().equalsIgnoreCase(l.getTipo().name()) || TipoLocal.Estudiantes.name().equalsIgnoreCase(l.getTipo().name()) || TipoLocal.Profesores.name().equalsIgnoreCase(l.getTipo().name()) 
				|| TipoLocal.Laboratorio.name().equalsIgnoreCase(l.getTipo().name())){
			permitido = true;
		}
		else if(TipoLocal.Decano.name().equalsIgnoreCase(l.getTipo().name()) || TipoLocal.Vicedecano.name().equalsIgnoreCase(l.getTipo().name())|| TipoLocal.Especialistas.name().equalsIgnoreCase(l.getTipo().name())
				|| TipoLocal.Area_Administrativa.name().equalsIgnoreCase(l.getTipo().name()) || TipoLocal.Jefe_Departamento.name().equalsIgnoreCase(l.getTipo().name()) ){
			if(hora.isAfter(horaEntradaProf)&& hora.isBefore(horaSalidaProf)){
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
		return horaSalidaProf;
	}



}
