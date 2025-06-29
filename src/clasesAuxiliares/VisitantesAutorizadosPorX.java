package clasesAuxiliares;

import java.util.ArrayList;

import personas.Persona;
import acceso.Registro;

public class VisitantesAutorizadosPorX {
   private Persona autirizador;
   private ArrayList<Registro> perAutorizadas;
   
   public VisitantesAutorizadosPorX(Persona auto){
	   setAutirizador(auto);
	   perAutorizadas = new ArrayList<>();
	   
   }
   
   
public Persona getAutirizador() {
	return autirizador;
}
public void setAutirizador(Persona autirizador) {
	this.autirizador = autirizador;
}
public ArrayList<Registro> getPerAutorizadas() {
	return perAutorizadas;
}
public void setPerAutorizadas(ArrayList<Registro> perAutorizadas) {
	this.perAutorizadas = perAutorizadas;
}

public void agregar(Registro r){
	perAutorizadas.add(r);
}
   
   
   
   
}
