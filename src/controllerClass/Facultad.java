package controllerClass;




import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import locales.Local;
import personas.Administrativo;
import personas.Directivo;
import personas.Especialista;
import personas.Estudiante;
import personas.Persona;
import personas.Profesor;
import personas.Tecnico;
import personas.Visitante;
import acceso.Registro;
import clasesAuxiliares.VisitantesAutorizadosPorX;
import enums.AreaDirectivo;
import enums.CargoDirectivo;
import enums.Plaza;
import enums.TipoContrato;
import enums.TipoLocal;

public class Facultad {
	private ArrayList<Local> locales;
	private ArrayList<Persona> personal;
	private ArrayList<Registro> registros;


//	public static final LocalTime HORA_INICIO_VISITANTES = LocalTime.of(8,0);
//	public static final LocalTime HORA_FIN_VISITANTES = LocalTime.of(12,0);
//	public static final LocalTime HORA_INICIO_RESTRINGIDO = LocalTime.of(8,0); 
//	public static final LocalTime HORA_FIN_RESTRINGIDO = LocalTime.of(17,0);
	private static Facultad instancia = null;


	private Facultad() {
		this.locales = new ArrayList <Local>(); 
		this.personal = new ArrayList <Persona>();
		this.registros = new ArrayList <Registro>();
	

	}

	public ArrayList<Local> getLocales() {
		return locales;
	}  



	public void addLocal(String ident, TipoLocal tipo, Persona responsable){
		locales.add(new Local(ident, tipo, responsable));
	}

	public Persona buscarEnPersonal(String carnet){

		boolean esDeFacultad = false;
		Persona found = null;
		int index = 0;

		if (carnet == null || carnet.replaceAll(" ", "").equals("")) {

			throw new IllegalArgumentException("Error: no pueden haber campos vacios");
		}
		else{
			while (index < personal.size() && !esDeFacultad) {
				if (personal.get(index).getNumeroIdentidad().equals(carnet)){
					esDeFacultad = true;
					found = personal.get(index);
				}
				index++;
			}
		}
		if (found == null){
			throw new IllegalArgumentException("No encontrado: Registrese como visitante");
		}
		
		return found;

	}

	public static Facultad getFacultad(){
		if(instancia== null){
			instancia = new Facultad();
		}
		return instancia;
	}

	public boolean agregarRegistro(Persona persona, Local local){

		return registros.add(new Registro(persona, local));
	}

	public ArrayList<Persona> getPersonal() {
		return personal;
	}

	public ArrayList<Registro> getVisitas() {
		return registros;
	}

	
//	public boolean accesoPermitidoAlLocal(String loc, Persona persona){
//		boolean permitido = false;
//
//		if (persona instanceof Directivo || persona instanceof Administrativo) {
//			permitido = true;
//		} else 
//			if(persona instanceof Profesor){
//				if(TipoLocal.Aula.name().equalsIgnoreCase(loc) || TipoLocal.Estudiantes.name().equalsIgnoreCase(loc) || TipoLocal.Profesores.name().equalsIgnoreCase(loc) 
//						|| TipoLocal.Laboratorio.name().equalsIgnoreCase(loc)){
//					permitido = true;
//				}
//				else if(TipoLocal.Decano.name().equalsIgnoreCase(loc) || TipoLocal.Vicedecano.name().equalsIgnoreCase(loc)|| TipoLocal.Especialistas.name().equalsIgnoreCase(loc)
//						|| TipoLocal.Area_Administrativa.name().equalsIgnoreCase(loc) || TipoLocal.Jefe_Departamento.name().equalsIgnoreCase(loc) ){
//					permitido = cumpleRangoHorario(HORA_INICIO_RESTRINGIDO, HORA_FIN_RESTRINGIDO);
//				}
//			}
//			else if ( persona instanceof Estudiante &&( TipoLocal.Estudiantes.name().equalsIgnoreCase(loc) || TipoLocal.Aula.name().equalsIgnoreCase(loc)
//					|| TipoLocal.Laboratorio.name().equalsIgnoreCase(loc) || TipoLocal.Profesores.name().equalsIgnoreCase(loc))){
//				permitido = cumpleRangoHorario(HORA_INICIO_RESTRINGIDO, HORA_FIN_RESTRINGIDO);
//			}
//			else if(persona instanceof Especialista || persona instanceof Tecnico){
//				if(TipoLocal.Servidores.name().equalsIgnoreCase(loc)|| TipoLocal.Laboratorio.name().equalsIgnoreCase(loc) || TipoLocal.Estudiantes.name().equalsIgnoreCase(loc)
//						|| TipoLocal.Especialistas.name().equalsIgnoreCase(loc)){
//					permitido = true;
//
//				}
//				else if(TipoLocal.Decano.name().equalsIgnoreCase(loc)|| TipoLocal.Vicedecano.name().equalsIgnoreCase(loc) || TipoLocal.Profesores.name().equalsIgnoreCase(loc)
//						|| TipoLocal.Area_Administrativa.name().equalsIgnoreCase(loc) || TipoLocal.Jefe_Departamento.name().equalsIgnoreCase(loc)){
//					permitido = cumpleRangoHorario(HORA_INICIO_RESTRINGIDO, HORA_FIN_RESTRINGIDO);
//				}
//			}
//			else if(persona instanceof Visitante)
//				permitido = cumpleRangoHorario(HORA_INICIO_VISITANTES, HORA_FIN_VISITANTES);
//
//		if(!permitido)
//		{
//			throw new IllegalArgumentException("Acceso al local no permitido");
//		}
//
//		return permitido;
//	}
//
//	public boolean cumpleRangoHorario(LocalTime inicio, LocalTime fin){
//		boolean cumple = false;
//		LocalTime hora= LocalTime.now();
//		
//
//		if(hora.isAfter(inicio)&& hora.isBefore(fin))
//		{
//			cumple = true;
//		}
//		else 
//			throw new IllegalArgumentException("Acceso Denegado: Fuera de horario");
//
//		return cumple;
//	}


	public Local buscarLocal(String loc){
		Local  l  = null;
		int index =0;
		while(index < locales.size()&& l == null){
			if(locales.get(index).getCodigo().equals(loc))
				l= locales.get(index);
			index++;
		}
		return l;
	}
	
	public Local buscarLocalporTipo(String loc){
		Local  l  = null;
		int index =0;
		while(index < locales.size()&& l == null){
			if(locales.get(index).getTipo().equals(loc))
				l= locales.get(index);
			index++;
		}
		return l;
	}
	
	public void addLocal(String codigo, Persona resp, TipoLocal tip){
		locales.add(new Local(codigo, tip, resp));
	}


	//Reporte 3 
	public int[] entradaALaFAcuPorHoras(LocalDate dia, Local l ){
		int[] entrada= new int[16]; 

		for(Registro r: registros){
			int hora = r.getHoraEntrada().getHour();
			int indice = hora - 8;

			if(l.getTipo().name().equals(r.getLocal().getTipo().name())){
				if(dia.compareTo(r.getFecha())==0){
					hora = r.getHoraEntrada().getHour();
					entrada[hora-8]=entrada[hora-8]+1;
				}
			}
		}
		return entrada;
	}

	public int[] entradaALAFacuPorDia(LocalDate dia){
		int [] datos = new int [locales.size()];
		int []temp;

		for(int i = 0; i<locales.size();i++){
			temp = entradaALaFAcuPorHoras(dia, locales.get(i));
			for(int j =0;j<temp.length; j++){
				datos[i] = datos[i] + temp[j];

			}
		}

		return datos;
	}
	

	//	public int [] entradaPorSemana(LocalDate inicio, LocalDate fin, Local l){
	//		int []entrada = new int[];
	//		int hora;
	//		
	//		for(Registro r: registros){
	//			if(l.getTipo().name().equals(r.getLocal().getTipo().name())){
	//				if(r.getFecha().isAfter(inicio)&& r.getFecha().isAfter(fin)){
	//				   
	//				   
	//				   
	//				}
	//			}
	//			
	//		}
	//		return entrada;
	//	}




	public VisitantesAutorizadosPorX personasAutorizada(Persona pp ){
		VisitantesAutorizadosPorX aux = new VisitantesAutorizadosPorX(pp);

		for(Registro r : registros){
			if(r.getPersona() instanceof Visitante ){
				Persona p = r .getPersona();

				if(((Visitante) p).getAutorizadoPor().getNumeroIdentidad().equals(pp.getNumeroIdentidad()))
				aux.agregar(r);


			}
		}
		return aux;
	}
	
	public ArrayList<Persona> filtrar(String tipo){
		ArrayList<Persona> per = new ArrayList<Persona>();
		for(Persona p : personal){
			if(p.getClass().getSimpleName().equals(tipo))
				per.add(p);		
		}
		return per;
	}





	public String[] nombresLocales(){
		String [] loc = new String [locales.size()];

		for(int i=0; i<locales.size();i++){
			loc[i]= locales.get(i).getTipo().name();
		}

		return loc;
	}

//	public ArrayList<Registro> obtenerReporteVisitasPersonas(String cI, LocalDate fechaInicio, LocalDate fechaFin){
//		ArrayList<Registro> reporte = new ArrayList<>();
//
//		for(int i=0;i<registros.size();i++)
//		{
//			if(registros.get(i).getPersona().getNumeroIdentidad().equals(cI))
//			{
//				if(registros.get(i).getFecha().compareTo(fechaInicio)>=0 && registros.get(i).getFecha().compareTo(fechaFin)<=0)
//				{
//					reporte.add(registros.get(i));
//				}
//			}
//		}
//
//		return reporte;
//	}
	

    public ArrayList<Registro> obtenerReporteVisitasPersonas(String cI, LocalDate fechaInicio, LocalDate fechaFin){
    	ArrayList<Registro> reporte = new ArrayList<>();
    	
    	for(int i=0;i<registros.size();i++)
    	{
    		if(registros.get(i).getPersona().getNumeroIdentidad().equals(cI))
    		{
    			if(registros.get(i).getFecha().compareTo(fechaInicio)>=0 && registros.get(i).getFecha().compareTo(fechaFin)<=0)
    			{
    				reporte.add(registros.get(i));
    			}
    		}
    	}
    	
    	return reporte;
    }
    
//    public Persona buscarPersonaCi(String cI){
//    	Persona p = null;
//    	boolean found = false;
//    	
//    	for(int i=0;i<personal.size() && !found ;i++)
//    	{
//    		if(personal.get(i).getNumeroIdentidad().equals(cI)){
//    			found = true;
//    			p = personal.get(i);
//    		}
//    	}
//    	
//    	return p;
//    	
//    }
    
    public ArrayList<Persona> obtenerResponsables(){
    	ArrayList<Persona> res = new ArrayList<>();
    	for(Persona responsable: personal){
    		if(!res.contains(responsable) &&  responsable instanceof Directivo || responsable instanceof Profesor || responsable instanceof Administrativo ||
    				responsable instanceof Especialista){
    			res.add(responsable);
    		}
    		
    	}
    	
    	return res;
    }
    
    
    
//    public void addAdministrativo(String nombre, String carnet, Plaza plaza){
//    	personal.add(new Administrativo(nombre, carnet, plaza));
//    }
//    
//    public void addEstudiante(String nombre , String carnet, int anno, int grupo){
//    	personal.add(new Estudiante(nombre, carnet, anno, grupo));
//    }
//    
//    public void addProfesor(String nombre, String carnet, String depa, String catDoc, String catCient, TipoContrato contrato){
//    	personal.add(new Profesor(nombre, carnet, depa, catDoc, catCient, contrato));
//    }
//    
//    public void addDirectivo(String nombre, String carnet, String depa, String catDoc, String catCient, TipoContrato contrato, CargoDirectivo cargo, AreaDirectivo area){
//    	personal.add(new Directivo(nombre, carnet, depa, catDoc, catCient, contrato, cargo, area));
//    }
//    
//    public void addTecnico(String nombre, String carnet, String plaza){
//    	personal.add(new Tecnico(nombre, carnet, plaza));
//    }
//    
//   public void addEspecialista(String nombre, String carnet, String proyecto){
//	   personal.add(new Especialista(nombre, carnet, proyecto));
//   }
   
   
    

	public ArrayList<Registro> obtenerInfoLocales(Local local, LocalDate fechaInicio, LocalDate fechaFin){
		ArrayList<Registro> reporteLocal = new ArrayList<>();

		for(int i=0;i<registros.size();i++)
		{
			if(registros.get(i).getLocal().getCodigo().equals(local.getCodigo()))
			{
				if(registros.get(i).getFecha().compareTo(fechaInicio)>=0 && registros.get(i).getFecha().compareTo(fechaFin)<=0)
				{
					reporteLocal.add(registros.get(i));
				}
			}
		}

		return reporteLocal;
	}

	public Persona buscarPersonaCi(String cI){
		Persona p = null;
		boolean found = false;

		for(int i=0;i<personal.size() && !found ;i++)
		{
			if(personal.get(i).getNumeroIdentidad().equals(cI)){
				found = true;
				p = personal.get(i);
			}
		}

		return p;

	}



	public void addAdministrativo(String nombre, String carnet, Plaza plaza){
		personal.add(new Administrativo(nombre, carnet, plaza));
	}

	public void addEstudiante(String nombre , String carnet, int anno, int grupo){
		personal.add(new Estudiante(nombre, carnet, anno, grupo));
	}

	public void addProfesor(String nombre, String carnet, String depa, String catDoc, String catCient, TipoContrato contrato){
		personal.add(new Profesor(nombre, carnet, depa, catDoc, catCient, contrato));
	}

	public void addDirectivo(String nombre, String carnet, String depa, String catDoc, String catCient, TipoContrato contrato, CargoDirectivo cargo, AreaDirectivo area){
		personal.add(new Directivo(nombre, carnet, depa, catDoc, catCient, contrato, cargo, area));
	}

	public void addTecnico(String nombre, String carnet, String plaza){
		personal.add(new Tecnico(nombre, carnet, plaza));
	}

	public void addEspecialista(String nombre, String carnet, String proyecto){
		personal.add(new Especialista(nombre, carnet, proyecto));
	}
public ArrayList<Registro >sinSalidas(){
	ArrayList<Registro> r = new ArrayList<Registro>();
	
	for(Registro rr :registros){
		if(rr.getHoraSalida()==null){
			r.add(rr);
		}
	}
	return r;
}

public boolean verificarRegistrosActivos(Local l , Persona p){
	boolean si = false;
	
	if(l== null){
		for(int i = 0 ; i<registros.size() && !si ;i++ ){
			Registro temp = registros.get(i);
			if( temp.getHoraSalida()==null &&  temp.getPersona().getNumeroIdentidad().equals(p.getNumeroIdentidad()) ){
				si = true;
			}
		}
	}
	else{
		for(int i = 0 ; i<registros.size() && !si ;i++ ){
			Registro temp = registros.get(i);
			if( temp.getHoraSalida()==null &&  temp.getLocal().getCodigo().equals(l.getCodigo()) ){
				si = true;
			}
		}

	}
	return si;
	
}
}



