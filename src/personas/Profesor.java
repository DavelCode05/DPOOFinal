package personas;

import enums.TipoContrato;

public class Profesor extends Persona{
    private String departamento;
    private String catDoc; 
    private String catCient;
    private TipoContrato tipoContrato;

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
    
}
