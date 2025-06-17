package personas;

import enums.AreaDirectivo;
import enums.CargoDirectivo;
import enums.CategoriaCientifica;
import enums.CategoriaDocente;
import enums.TipoContrato;

public class Directivo extends Profesor{
	private CargoDirectivo cargo;
	private AreaDirectivo area; // el area es un enum

	public Directivo(String nombre, String numeroIdentidad, String departamento,
			String catDoc, String catCient, TipoContrato tipoContrato, CargoDirectivo cargo,
			AreaDirectivo area) {
		super(nombre, numeroIdentidad, departamento, catDoc, catCient, tipoContrato);
	this.area = area;
	this.cargo=cargo;
	}
	public void setCargo(CargoDirectivo cargo) {
		this.cargo = cargo;
	}
	public void setArea(AreaDirectivo area) {
		this.area = area;
	}
	public Directivo() {
		// TODO Auto-generated constructor stub
	}
	public CargoDirectivo getCargo() {
		return cargo;
	}
	public AreaDirectivo getArea() {
		return area;
	}
	
	
	
//	public void setCargo(CargoDirectivo cargo) { // se le da a elegir en lista desplegable
//		//Se valida??
//		this.cargo = cargo;
//	}
//	public AreaDirectivo getArea() {
//		return area;
//	}
//	public void setArea(String area) {  // no se valida , se da a elegir 
//		if (area != null && !area.replaceAll(" ", "").equals("")) {
//			this.area = area;
//		}else
//			throw new IllegalArgumentException("El nombre del area no puede estar vacio.");
//	}


}
