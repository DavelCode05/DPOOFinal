package personas;

import enums.CategoriaCientifica;
import enums.CategoriaDocente;
import enums.TipoContrato;

public class Profesor extends Persona{
    private String departamento;
    private String catDoc; // no es enum es string 
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
    public void setCatDoc(String catDoc) { // es un string 
        //Duda de si se valida o no
        this.catDoc = catDoc;
    }

    public String getCatCient() {
        return catCient;
    }
    public void setCatCient(String catCient) {
        this.catCient = catCient;
    }

    public TipoContrato getTipoContrato() {
        return tipoContrato;
    }
    public void setTipoContrato(TipoContrato tipoContrato) {
        this.tipoContrato = tipoContrato;
    }
    
}
