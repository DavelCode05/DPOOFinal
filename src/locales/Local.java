package locales;

import enums.TipoLocal;
import personas.Administrativo;
import personas.Directivo;
import personas.Especialista;
import personas.Persona;
import personas.Profesor;

public class Local {
	private String codigo;
	private TipoLocal tipo;
	private Persona responsable;

	public Local(String codigo, TipoLocal tipo, Persona responsable) {
		setCodigo(codigo);
		setTipo(tipo);
		setResponsable(responsable);
//		this.responsable = responsable;
	}

	public String getCodigo() {
		return codigo;
	}

	public TipoLocal getTipo() {
		return tipo;
	}

	public Persona getResponsable() {
		return responsable;
	}

	public void setCodigo(String codigo) {
		if (codigo != null && !codigo.replaceAll(" ", "").equals("")) {
			this.codigo = codigo ;
		}else
			throw new IllegalArgumentException("El codigo del local no puede estar vacio.");
	}

	public void setTipo(TipoLocal tipo) {
		if (tipo != null) {
			this.tipo = tipo;
		}else
			throw new IllegalArgumentException("El nombre del tipo de local no puede ser nulo.");
	}

	public void setResponsable(Persona responsable) {
		if(responsable == null)
			throw new IllegalArgumentException("Responsable no puede ser nulo");
		boolean esResponsable = responsable instanceof Directivo || responsable instanceof Profesor || responsable instanceof Administrativo ||
				responsable instanceof Especialista;
		if(!esResponsable)
			throw new IllegalArgumentException("El responsable no puede ser un estudiante o un tecnico");
		else 
			this.responsable = responsable;
	}


}
