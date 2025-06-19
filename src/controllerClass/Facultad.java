package controllerClass;




import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;







import clasesAuxiliares.VisitantesAutorizadosPorX;
import acceso.Registro;
import enums.TipoLocal;
import enums.Plaza;
import enums.TipoContrato;
import enums.CargoDirectivo;
import enums.AreaDirectivo;
import locales.Local;
import personas.Administrativo;
import personas.Directivo;
import personas.Especialista;
import personas.Estudiante;
import personas.Persona;
import personas.Profesor;
import personas.Tecnico;
import personas.Visitante;

public class Facultad {
	private ArrayList<Local> locales;
	private ArrayList<Persona> personal;
	private ArrayList<Registro> registros;


	public static final LocalTime HORA_INICIO_VISITANTES = LocalTime.of(8,0);
	public static final LocalTime HORA_FIN_VISITANTES = LocalTime.of(12,0);
	public static final LocalTime HORA_INICIO_RESTRINGIDO = LocalTime.of(8,0); 
	public static final LocalTime HORA_FIN_RESTRINGIDO = LocalTime.of(17,0);
private static Facultad instancia = null;

	//	private static Facultad f = Iniciadora.Inicio();
	//
	//
	//
	//	public static Facultad getF() {
	//		return f;
	//	}
	//
	//	public static void setF(Facultad f) {
	//		Facultad.f = f;
	//	}

	private Facultad() {
		this.locales = new ArrayList <Local>(); 
		this.personal = new ArrayList <Persona>();
		this.registros = new ArrayList <Registro>();


		personal.add(new Administrativo("Aniel Vazquez", "06040468472", Plaza.Secretaria));
		personal.add(new Directivo("Lorena Perez", "06040468471", "Recursos Humanos", "Profesor","Doctor", TipoContrato.Determinado, CargoDirectivo.Decano, AreaDirectivo.Decanato));
		personal.add(new Estudiante("Nicole Rios", "06040468470",1, 13 ));
		personal.add(new Especialista("Josefina Rodriguez", "06040468473","GGGGG" ));
		personal.add(new Profesor("ALberto Fernandez", "06040468474", " DPOO", "mmm", "Máster", TipoContrato.Determinado));
		personal.add(new Tecnico("Erick Valdez", "06040468475","jjj"));
		personal.add(new Directivo("Patricia Toro", "06040468476", "Recursos Humanos", "mmm","Doctor", TipoContrato.Determinado, CargoDirectivo.Vicedecano, AreaDirectivo.Vicedecanato));
		personal.add(new Tecnico("Antonio Falcon", "06040468477","ddd"));
		personal.add(new Estudiante("Alvaro Tamayo Portela", "05040766544",1, 12 ));
		personal.add(new Profesor("Jacinto Reina", "06040468479", " Matematica", "mmm", "Doctor", TipoContrato.Determinado));
		//Estudiantes
		personal.add(new Estudiante("Aleksander Castañeda Morales", "03110367040",1, 12 )); //10
		personal.add(new Estudiante("Dariel Velazco Falcón", "05060167362",1, 12 )); //11
		personal.add(new Estudiante("Brian Monteagudo Pérez", "05072967281",1, 12 )); //12
		personal.add(new Estudiante("Alexandro Valdés Piñeda", "05091568088",1, 12 )); //13
		personal.add(new Estudiante("Gloria Santos Rosado", "06030867876",1, 12 )); //14
		personal.add(new Estudiante("Javier David Coroas Cintra", "01061267208",1, 12 )); //15
		personal.add(new Estudiante("Aylin Vázquez Álvarez", "06061368091",1, 12 ));//16
		personal.add(new Estudiante("Daniel Prats Parra", "05120467309",1, 12 ));//17
		personal.add(new Estudiante("Frank Ballmajo Dueñas", "05083168646",1, 12 ));//18
		personal.add(new Estudiante("Lemuel Sagarra Pérez", "05111066748",1, 12 ));//19
		personal.add(new Estudiante("Nicole Rios", "06040468470",1, 13 ));//20
		personal.add(new Estudiante("Nicole Rios", "06040468470",1, 13 ));//21
		personal.add(new Estudiante("Nicole Rios", "06040468470",1, 13 ));//22
		personal.add(new Estudiante("Nicole Rios", "06040468470",1, 13 ));//23
		personal.add(new Estudiante("Nicole Rios", "06040468470",1, 13 ));//24
		personal.add(new Estudiante("Nicole Rios", "06040468470",1, 13 ));//25
		personal.add(new Estudiante("Nicole Rios", "06040468470",1, 13 ));//26
		personal.add(new Estudiante("Nicole Rios", "06040468470",1, 13 ));//27
		personal.add(new Estudiante("Nicole Rios", "06040468470",1, 13 ));//28
		personal.add(new Estudiante("Nicole Rios", "06040468470",1, 13 ));//29
		//Profesores
		personal.add(new Profesor("Adrian", "06040468479", " DPOO", "Auxiliar", "Ninguna", TipoContrato.Indeterminado)); //30
		personal.add(new Profesor("Rodolfo ", "06040468479", " Matematica", "Titular", "Máster", TipoContrato.Determinado)); //31
		personal.add(new Profesor("Sonia Perez Lovell", "06040468479", "DPOO", "Titular", "Doctor", TipoContrato.Determinado)); //32
		personal.add(new Profesor("Raisa ", "06040468479", "Matemática Computacional", "Titular", "Doctor", TipoContrato.Determinado)); //33
		personal.add(new Profesor("Javier Garro Cuervo", "06040468479", "Historia de Cuba", "Titular", "Máster", TipoContrato.Determinado)); //34
		personal.add(new Profesor("Omar David", "06040468479", "DPOO", "Auxiliar", "Ninguna", TipoContrato.Indeterminado)); //35
		personal.add(new Profesor("Alejandro", "06040468479", "DIP", "Titular", "Doctor", TipoContrato.Determinado)); //36
		//Directivo
		personal.add(new Directivo("Raisa Socorro", "06040468476", "CEIS", "Titular","Doctor", TipoContrato.Determinado, CargoDirectivo.Decano, AreaDirectivo.Decanato)); //37
		personal.add(new Directivo("Mariana Suárez Pérez", "85071245678", "Matemática", "Auxiliar","Máster", TipoContrato.Indeterminado, CargoDirectivo.Jefe_Departamento, AreaDirectivo.Departamento)); //38
		personal.add(new Directivo("Ernesto Valdés Romero", "74091812345", "Informática", "Titular","Doctor", TipoContrato.Determinado, CargoDirectivo.Vicedecano, AreaDirectivo.Vicedecanato)); //39
		personal.add(new Directivo("Laura Méndez Rodríguez", "92010498765", "Filosofía", "Instructor","Aspirante", TipoContrato.Determinado, CargoDirectivo.Secretaria_Docente, AreaDirectivo.Secretaria)); //40
		
		
		
		locales.add(new Local("1234", TipoLocal.Estudiantes, personal.get(1)));
		locales.add(new Local("1233", TipoLocal.Decano, personal.get(1) ));
		locales.add(new Local("1333", TipoLocal.Laboratorio, personal.get(4) ));
		locales.add(new Local("3333", TipoLocal.Especialistas, personal.get(3) ));
		locales.add(new Local("1234", TipoLocal.Area_Administrativa, personal.get(0) ));
		locales.add(new Local("1234", TipoLocal.Jefe_Departamento, personal.get(4) ));
		locales.add(new Local("1233", TipoLocal.Vicedecano, personal.get(6) ));
		locales.add(new Local("1233", TipoLocal.Servidores, personal.get(4) ));
		locales.add(new Local("1233", TipoLocal.Aula, personal.get(9) ));
		locales.add(new Local("1233", TipoLocal.Profesores, personal.get(9) ));

		registros.add(new Registro(personal.get(0), locales.get(0)));
		registros.add(new Registro(personal.get(1), locales.get(0)));
		registros.add(new Registro(personal.get(2), locales.get(0)));
		registros.add(new Registro(personal.get(3), locales.get(0)));
		registros.add(new Registro(personal.get(4), locales.get(0)));
		registros.add(new Registro(personal.get(5), locales.get(0)));
		registros.add(new Registro(personal.get(6), locales.get(0)));
		registros.add(new Registro(personal.get(7), locales.get(0)));
		registros.add(new Registro(personal.get(8), locales.get(0)));
		registros.add(new Registro(personal.get(9), locales.get(0)));
		registros.add(new Registro(personal.get(0), locales.get(0)));
		registros.add(new Registro(personal.get(9), locales.get(0)));
		registros.add(new Registro(personal.get(5), locales.get(0)));
		registros.add(new Registro(personal.get(5), locales.get(0)));
		registros.add(new Registro(personal.get(5), locales.get(0)));

	//	registros.add(new Registro(new Visitante("Juan", "00000","mmmm","mmmm", personal.get(2)), locales.get(0)));
	//	registros.add(new Registro(new Visitante("Juanita", "00000","mmmm","mmmm", personal.get(2)), locales.get(0)));

		registros.add(new Registro(personal.get(2), locales.get(2)));
		registros.add(new Registro(personal.get(2), locales.get(3)));
		registros.add(new Registro(personal.get(2), locales.get(1)));



		registros.get(0).setHoraEntrada(LocalTime.of(8,0));
		registros.get(0).setHoraSalida(LocalTime.of(12, 0));
		registros.get(15).setHoraEntrada(LocalTime.of(13, 0));
		registros.get(15).setHoraSalida(LocalTime.of(14, 0));
		registros.get(16).setHoraEntrada(LocalTime.of(15, 0));
		registros.get(16).setHoraSalida(LocalTime.of(16, 0));
		registros.get(17).setHoraEntrada(LocalTime.of(16, 0));
		registros.get(17).setHoraSalida(LocalTime.of(17, 0));
		registros.get(1).setHoraEntrada(LocalTime.of(8,0));
		registros.get(1).setHoraSalida(LocalTime.of(13, 0));
		registros.get(2).setHoraEntrada(LocalTime.of(8,0));
		registros.get(2).setHoraSalida(LocalTime.of(12, 0));
		registros.get(3).setHoraEntrada(LocalTime.of(12,0));
		registros.get(3).setHoraSalida(LocalTime.of(14, 0));
		registros.get(4).setHoraEntrada(LocalTime.of(12,0));
		registros.get(4).setHoraSalida(LocalTime.of(13, 0));
		registros.get(5).setHoraEntrada(LocalTime.of(16,0));
		registros.get(5).setHoraSalida(LocalTime.of(16, 0));
		registros.get(6).setHoraEntrada(LocalTime.of(9,0));
		registros.get(6).setHoraSalida(LocalTime.of(12, 0));
		registros.get(7).setHoraEntrada(LocalTime.of(10,0));
		registros.get(7).setHoraSalida(LocalTime.of(14, 0));
		registros.get(8).setHoraEntrada(LocalTime.of(10,0));
		registros.get(8).setHoraSalida(LocalTime.of(15, 0));
		registros.get(9).setHoraEntrada(LocalTime.of(10,0));
		registros.get(9).setHoraSalida(LocalTime.of(11, 0));
		registros.get(10).setHoraEntrada(LocalTime.of(13,0));
		registros.get(10).setHoraSalida(LocalTime.of(15, 0));
		registros.get(11).setHoraEntrada(LocalTime.of(14,0));
		registros.get(11).setHoraSalida(LocalTime.of(15, 0));
		registros.get(12).setHoraEntrada(LocalTime.of(15,0));
		registros.get(12).setHoraSalida(LocalTime.of(16, 0));
		registros.get(13).setHoraEntrada(LocalTime.of(8,0));
		registros.get(13).setHoraSalida(LocalTime.of(12, 0));
		registros.get(14).setHoraEntrada(LocalTime.of(11,0));
		registros.get(14).setHoraSalida(LocalTime.of(14, 0));

	}

	public ArrayList<Local> getLocales() {
		return locales;
	}  
	

	
	public void addLocal(String ident, TipoLocal tipo, Persona responsable){
		locales.add(new Local(ident, tipo, responsable));
	}



	//
	//	public Visitante crearVisitante(String nombre, String carnet, String area, String motivo, String autorizador){
	//		Visitante v;
	//		Persona p ;
	//		if(buscarEnPersonal(carnet)!=null)
	//			throw new IllegalArgumentException (" Al pertenecer a la facultad debe registrarse como usuario");
	//		else{
	//			p = buscarEnPersonal(autorizador);
	//			if(p==null){
	//				throw new IllegalArgumentException("La persona que lo autoriza debe pertenecer a la facultad");
	//
	//			}
	//			else
	//				v = new Visitante(nombre,carnet,area,motivo,p);	
	//		}
	//		return v;
	//	}

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

	//	public Persona esDeFacultad(String carnet) {
	//		Persona p = buscarEnPersonal(carnet);
	//		if(p==null)
	//			throw new IllegalArgumentException("No encontrado");
	//
	//		return p;
	//	}

	public Local accesoPermitidoAlLocal(String loc, Persona persona){
		boolean permitido = false;

		if (persona instanceof Directivo || persona instanceof Administrativo) {
			permitido = true;
		} else 
			if(persona instanceof Profesor){
				if(TipoLocal.Aula.name().equalsIgnoreCase(loc) || TipoLocal.Estudiantes.name().equalsIgnoreCase(loc) || TipoLocal.Profesores.name().equalsIgnoreCase(loc) 
						|| TipoLocal.Laboratorio.name().equalsIgnoreCase(loc)){
					permitido = true;
				}
				else if(TipoLocal.Decano.name().equalsIgnoreCase(loc) || TipoLocal.Vicedecano.name().equalsIgnoreCase(loc)|| TipoLocal.Especialistas.name().equalsIgnoreCase(loc)
						|| TipoLocal.Area_Administrativa.name().equalsIgnoreCase(loc) || TipoLocal.Jefe_Departamento.name().equalsIgnoreCase(loc) ){
					permitido = cumpleRangoHorario(HORA_INICIO_RESTRINGIDO, HORA_FIN_RESTRINGIDO);
				}
			}
			else if (persona instanceof Estudiante &&( TipoLocal.Estudiantes.name().equalsIgnoreCase(loc) || TipoLocal.Aula.name().equalsIgnoreCase(loc)
					|| TipoLocal.Laboratorio.name().equalsIgnoreCase(loc) || TipoLocal.Profesores.name().equalsIgnoreCase(loc))){
				permitido = cumpleRangoHorario(HORA_INICIO_RESTRINGIDO, HORA_FIN_RESTRINGIDO);
			}
			else if(persona instanceof Especialista || persona instanceof Tecnico){
				if(TipoLocal.Servidores.name().equalsIgnoreCase(loc)|| TipoLocal.Laboratorio.name().equalsIgnoreCase(loc) || TipoLocal.Estudiantes.name().equalsIgnoreCase(loc)
						|| TipoLocal.Especialistas.name().equalsIgnoreCase(loc)){
					permitido = true;

				}
				else if(TipoLocal.Decano.name().equalsIgnoreCase(loc)|| TipoLocal.Vicedecano.name().equalsIgnoreCase(loc) || TipoLocal.Profesores.name().equalsIgnoreCase(loc)
						|| TipoLocal.Area_Administrativa.name().equalsIgnoreCase(loc) || TipoLocal.Jefe_Departamento.name().equalsIgnoreCase(loc)){
					permitido = cumpleRangoHorario(HORA_INICIO_RESTRINGIDO, HORA_FIN_RESTRINGIDO);
				}
			}
			else if(persona instanceof Visitante)
				permitido = cumpleRangoHorario(HORA_INICIO_VISITANTES, HORA_FIN_VISITANTES);

		if(!permitido)
		{
			throw new IllegalArgumentException("Acceso al local no permitido");
		}

		return buscarLocal(loc);
	}

	public boolean cumpleRangoHorario(LocalTime inicio, LocalTime fin){
		boolean cumple = false;
		LocalTime hora= LocalTime.now();

		if(hora.isBefore(inicio)&& hora.isAfter(fin))
		{
			cumple = true;
		}
		else 
			throw new IllegalArgumentException("Acceso Denegado: Fuera de horario");

		return cumple;
	}


	public Local buscarLocal(String loc){
		Local  l  = null;
		int index =0;
		while(index < locales.size()&& l == null){
			if(locales.get(index).getTipo().name().equals(loc))
				l= locales.get(index);
			index++;
		}
		return l;
	}


	//Reporte 3 
	public int[] entradaALaFAcuPorHoras(LocalDate dia, Local l ){
		int[] entrada= new int[9];
		int hora;

		for(Registro r: registros){
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




	public VisitantesAutorizadosPorX personasAutorizada(String carnet){
		VisitantesAutorizadosPorX aux = new VisitantesAutorizadosPorX(buscarEnPersonal(carnet));

	
		for(Registro r : registros){
			if(r.getPersona() instanceof Visitante ){
				Persona p = r .getPersona();
				if(((Visitante) p).getAutorizadoPor().getNumeroIdentidad().equals(carnet))
				aux.agregar(r);
			}
		}
		return aux;
	}





	public String[] nombresLocales(){
		String [] loc = new String [locales.size()];

		for(int i=0; i<locales.size();i++){
			loc[i]= locales.get(i).getTipo().name();
		}

		return loc;
	}
	
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
   
   
    
}



