package personas;

import enums.AreaDirectivo;
import enums.CargoDirectivo;
import enums.TipoContrato;

public class Directivo extends Profesor{
	private CargoDirectivo cargo;
	private AreaDirectivo area;

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
	

}
