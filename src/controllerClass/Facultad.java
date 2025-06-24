package controllerClass;




import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;








import javax.swing.JComboBox;

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








		

		// ... puedes continuar desde el registro 16 hasta el 56 usando la misma estructura

		
		//Registros
//		registros.add(new Registro(personal.get(8), locales.get(7)));
//		registros.add(new Registro(personal.get(35), locales.get(2)));
//		registros.add(new Registro(personal.get(12), locales.get(9)));
//		registros.add(new Registro(personal.get(20), locales.get(0)));
//		registros.add(new Registro(personal.get(46), locales.get(4)));
//		registros.add(new Registro(personal.get(3), locales.get(3)));
//		registros.add(new Registro(personal.get(27), locales.get(8)));
//		registros.add(new Registro(personal.get(41), locales.get(5)));
//		registros.add(new Registro(personal.get(10), locales.get(6)));
//		registros.add(new Registro(personal.get(17), locales.get(1)));
//		registros.add(new Registro(personal.get(39), locales.get(0)));
//		registros.add(new Registro(personal.get(5), locales.get(9)));
//		registros.add(new Registro(personal.get(22), locales.get(3)));
//		registros.add(new Registro(personal.get(14), locales.get(7)));
//		registros.add(new Registro(personal.get(30), locales.get(5)));
//		registros.add(new Registro(personal.get(4), locales.get(6)));
//		registros.add(new Registro(personal.get(11), locales.get(0)));
//		registros.add(new Registro(personal.get(7), locales.get(2)));
//		registros.add(new Registro(personal.get(48), locales.get(8)));
//		registros.add(new Registro(personal.get(9), locales.get(1)));
//		registros.add(new Registro(personal.get(24), locales.get(4)));
//		registros.add(new Registro(personal.get(13), locales.get(7)));
//		registros.add(new Registro(personal.get(32), locales.get(3)));
//		registros.add(new Registro(personal.get(38), locales.get(0)));
//		registros.add(new Registro(personal.get(2), locales.get(9)));
//		registros.add(new Registro(personal.get(43), locales.get(1)));
//		registros.add(new Registro(personal.get(6), locales.get(6)));
//		registros.add(new Registro(personal.get(18), locales.get(2)));
//		registros.add(new Registro(personal.get(0), locales.get(5)));
//		registros.add(new Registro(personal.get(26), locales.get(6)));
//		registros.add(new Registro(personal.get(36), locales.get(8)));
//		registros.add(new Registro(personal.get(16), locales.get(3)));
//		registros.add(new Registro(personal.get(1), locales.get(0)));
//		registros.add(new Registro(personal.get(21), locales.get(4)));
//		registros.add(new Registro(personal.get(28), locales.get(5)));
//		registros.add(new Registro(personal.get(40), locales.get(1)));
//		registros.add(new Registro(personal.get(19), locales.get(7)));
//		registros.add(new Registro(personal.get(29), locales.get(2)));
//		registros.add(new Registro(personal.get(25), locales.get(9)));
//		registros.add(new Registro(personal.get(47), locales.get(0)));
//		registros.add(new Registro(personal.get(15), locales.get(6)));
//		registros.add(new Registro(personal.get(33), locales.get(3)));
//		registros.add(new Registro(personal.get(23), locales.get(8)));
//		registros.add(new Registro(personal.get(31), locales.get(2)));
//		registros.add(new Registro(personal.get(42), locales.get(9)));
//		registros.add(new Registro(personal.get(44), locales.get(0)));
//		registros.add(new Registro(personal.get(45), locales.get(5)));
//		registros.add(new Registro(personal.get(34), locales.get(1)));
//		registros.add(new Registro(personal.get(37), locales.get(3)));
//		registros.add(new Registro(personal.get(48), locales.get(2)));
//		registros.add(new Registro(personal.get(30), locales.get(6)));
//		registros.add(new Registro(personal.get(12), locales.get(5)));
//		registros.add(new Registro(personal.get(7), locales.get(4)));
//		registros.add(new Registro(personal.get(5), locales.get(8)));
//		registros.add(new Registro(personal.get(11), locales.get(9)));
//		registros.add(new Registro(personal.get(14), locales.get(0)));
//		registros.add(new Registro(personal.get(3), locales.get(7)));
//		registros.add(new Registro(personal.get(2), locales.get(2)));
//		registros.add(new Registro(personal.get(2), locales.get(3)));
//		registros.add(new Registro(personal.get(2), locales.get(1)));
		
		
		
//		registros.get(0).setHoraEntrada(LocalTime.of(8, 0));   registros.get(0).setHoraSalida(LocalTime.of(12, 0));
//		registros.get(1).setHoraEntrada(LocalTime.of(9, 0));   registros.get(1).setHoraSalida(LocalTime.of(13, 0));
//		registros.get(2).setHoraEntrada(LocalTime.of(14, 0));  registros.get(2).setHoraSalida(LocalTime.of(15, 0));
//		registros.get(3).setHoraEntrada(LocalTime.of(10, 0));  registros.get(3).setHoraSalida(LocalTime.of(14, 0));
//		registros.get(4).setHoraEntrada(LocalTime.of(13, 0));  registros.get(4).setHoraSalida(LocalTime.of(15, 0));
//		registros.get(5).setHoraEntrada(LocalTime.of(8, 0));   registros.get(5).setHoraSalida(LocalTime.of(10, 0));
//		registros.get(6).setHoraEntrada(LocalTime.of(11, 0));  registros.get(6).setHoraSalida(LocalTime.of(14, 0));
//		registros.get(7).setHoraEntrada(LocalTime.of(15, 0));  registros.get(7).setHoraSalida(LocalTime.of(16, 0));
//		registros.get(8).setHoraEntrada(LocalTime.of(8, 0));   registros.get(8).setHoraSalida(LocalTime.of(11, 0));
//		registros.get(9).setHoraEntrada(LocalTime.of(10, 0));  registros.get(9).setHoraSalida(LocalTime.of(13, 0));
//		registros.get(10).setHoraEntrada(LocalTime.of(12, 0)); registros.get(10).setHoraSalida(LocalTime.of(14, 0));
//		registros.get(11).setHoraEntrada(LocalTime.of(13, 0)); registros.get(11).setHoraSalida(LocalTime.of(16, 0));
//		registros.get(12).setHoraEntrada(LocalTime.of(9, 0));  registros.get(12).setHoraSalida(LocalTime.of(11, 0));
//		registros.get(13).setHoraEntrada(LocalTime.of(14, 0)); registros.get(13).setHoraSalida(LocalTime.of(15, 0));
//		registros.get(14).setHoraEntrada(LocalTime.of(8, 0));  registros.get(14).setHoraSalida(LocalTime.of(12, 0));
//		registros.get(15).setHoraEntrada(LocalTime.of(12, 0)); registros.get(15).setHoraSalida(LocalTime.of(15, 0));
//		registros.get(16).setHoraEntrada(LocalTime.of(13, 0)); registros.get(16).setHoraSalida(LocalTime.of(16, 0));
//		registros.get(17).setHoraEntrada(LocalTime.of(10, 0)); registros.get(17).setHoraSalida(LocalTime.of(14, 0));
//		registros.get(18).setHoraEntrada(LocalTime.of(9, 0));  registros.get(18).setHoraSalida(LocalTime.of(11, 0));
//		registros.get(19).setHoraEntrada(LocalTime.of(8, 0));  registros.get(19).setHoraSalida(LocalTime.of(10, 0));
//		registros.get(20).setHoraEntrada(LocalTime.of(11, 0)); registros.get(20).setHoraSalida(LocalTime.of(15, 0));
//		registros.get(21).setHoraEntrada(LocalTime.of(12, 0)); registros.get(21).setHoraSalida(LocalTime.of(14, 0));
//		registros.get(22).setHoraEntrada(LocalTime.of(13, 0)); registros.get(22).setHoraSalida(LocalTime.of(15, 0));
//		registros.get(23).setHoraEntrada(LocalTime.of(14, 0)); registros.get(23).setHoraSalida(LocalTime.of(16, 0));
//		registros.get(24).setHoraEntrada(LocalTime.of(10, 0)); registros.get(24).setHoraSalida(LocalTime.of(12, 0));
//		registros.get(25).setHoraEntrada(LocalTime.of(9, 0));  registros.get(25).setHoraSalida(LocalTime.of(12, 0));
//		registros.get(26).setHoraEntrada(LocalTime.of(13, 0)); registros.get(26).setHoraSalida(LocalTime.of(14, 0));
//		registros.get(27).setHoraEntrada(LocalTime.of(15, 0)); registros.get(27).setHoraSalida(LocalTime.of(16, 0));
//		registros.get(28).setHoraEntrada(LocalTime.of(8, 0));  registros.get(28).setHoraSalida(LocalTime.of(11, 0));
//		registros.get(29).setHoraEntrada(LocalTime.of(10, 0)); registros.get(29).setHoraSalida(LocalTime.of(13, 0));
//		registros.get(30).setHoraEntrada(LocalTime.of(9, 0));  registros.get(30).setHoraSalida(LocalTime.of(12, 0));
//		registros.get(31).setHoraEntrada(LocalTime.of(14, 0)); registros.get(31).setHoraSalida(LocalTime.of(16, 0));
//		registros.get(32).setHoraEntrada(LocalTime.of(12, 0)); registros.get(32).setHoraSalida(LocalTime.of(14, 0));
//		registros.get(33).setHoraEntrada(LocalTime.of(8, 0));  registros.get(33).setHoraSalida(LocalTime.of(10, 0));
//		registros.get(34).setHoraEntrada(LocalTime.of(11, 0)); registros.get(34).setHoraSalida(LocalTime.of(15, 0));
//		registros.get(35).setHoraEntrada(LocalTime.of(10, 0)); registros.get(35).setHoraSalida(LocalTime.of(12, 0));
//		registros.get(36).setHoraEntrada(LocalTime.of(9, 0));  registros.get(36).setHoraSalida(LocalTime.of(13, 0));
//		registros.get(37).setHoraEntrada(LocalTime.of(13, 0)); registros.get(37).setHoraSalida(LocalTime.of(15, 0));
//		registros.get(38).setHoraEntrada(LocalTime.of(14, 0)); registros.get(38).setHoraSalida(LocalTime.of(16, 0));
//		registros.get(39).setHoraEntrada(LocalTime.of(8, 0));  registros.get(39).setHoraSalida(LocalTime.of(11, 0));
//		registros.get(40).setHoraEntrada(LocalTime.of(10, 0)); registros.get(40).setHoraSalida(LocalTime.of(12, 0));
//		registros.get(41).setHoraEntrada(LocalTime.of(9, 0));  registros.get(41).setHoraSalida(LocalTime.of(14, 0));
//		registros.get(42).setHoraEntrada(LocalTime.of(11, 0)); registros.get(42).setHoraSalida(LocalTime.of(13, 0));
//		registros.get(43).setHoraEntrada(LocalTime.of(8, 0));  registros.get(43).setHoraSalida(LocalTime.of(10, 0));
//		registros.get(44).setHoraEntrada(LocalTime.of(12, 0)); registros.get(44).setHoraSalida(LocalTime.of(15, 0));
//		registros.get(45).setHoraEntrada(LocalTime.of(13, 0)); registros.get(45).setHoraSalida(LocalTime.of(14, 0));
//		registros.get(46).setHoraEntrada(LocalTime.of(14, 0)); registros.get(46).setHoraSalida(LocalTime.of(16, 0));
//		registros.get(47).setHoraEntrada(LocalTime.of(9, 0));  registros.get(47).setHoraSalida(LocalTime.of(11, 0));
//		registros.get(48).setHoraEntrada(LocalTime.of(10, 0)); registros.get(48).setHoraSalida(LocalTime.of(13, 0));
//		registros.get(49).setHoraEntrada(LocalTime.of(15, 0)); registros.get(49).setHoraSalida(LocalTime.of(16, 0));
//		registros.get(50).setHoraEntrada(LocalTime.of(12, 0)); registros.get(50).setHoraSalida(LocalTime.of(14, 0));
//		registros.get(51).setHoraEntrada(LocalTime.of(8, 0));  registros.get(51).setHoraSalida(LocalTime.of(11, 0));
//		registros.get(52).setHoraEntrada(LocalTime.of(10, 0)); registros.get(52).setHoraSalida(LocalTime.of(12, 0));
//		registros.get(53).setHoraEntrada(LocalTime.of(11, 0)); registros.get(53).setHoraSalida(LocalTime.of(13, 0));
//		registros.get(54).setHoraEntrada(LocalTime.of(9, 0));  registros.get(54).setHoraSalida(LocalTime.of(12, 0));
//		registros.get(55).setHoraEntrada(LocalTime.of(14, 0)); registros.get(55).setHoraSalida(LocalTime.of(15, 0));
//		
//		registros.add(registros.get(12));
//		registros.get(56).setHoraEntrada(LocalTime.of(8, 0));  registros.get(56).setHoraSalida(LocalTime.of(10, 0));
//
//		registros.add(registros.get(30));
//		registros.get(57).setHoraEntrada(LocalTime.of(9, 0));  registros.get(57).setHoraSalida(LocalTime.of(12, 0));
//
//		registros.add(registros.get(21));
//		registros.get(58).setHoraEntrada(LocalTime.of(13, 0)); registros.get(58).setHoraSalida(LocalTime.of(14, 0));
//
//		registros.add(registros.get(7));
//		registros.get(59).setHoraEntrada(LocalTime.of(10, 0)); registros.get(59).setHoraSalida(LocalTime.of(13, 0));
//
//		registros.add(registros.get(2));
//		registros.get(60).setHoraEntrada(LocalTime.of(8, 0));  registros.get(60).setHoraSalida(LocalTime.of(11, 0));
//
//		registros.add(registros.get(15));
//		registros.get(61).setHoraEntrada(LocalTime.of(14, 0)); registros.get(61).setHoraSalida(LocalTime.of(15, 0));
//
//		registros.add(registros.get(33));
//		registros.get(62).setHoraEntrada(LocalTime.of(12, 0)); registros.get(62).setHoraSalida(LocalTime.of(14, 0));
//
//		registros.add(registros.get(11));
//		registros.get(63).setHoraEntrada(LocalTime.of(13, 0)); registros.get(63).setHoraSalida(LocalTime.of(16, 0));
//
//		registros.add(registros.get(24));
//		registros.get(64).setHoraEntrada(LocalTime.of(10, 0)); registros.get(64).setHoraSalida(LocalTime.of(12, 0));
//
//		registros.add(registros.get(26));
//		registros.get(65).setHoraEntrada(LocalTime.of(11, 0)); registros.get(65).setHoraSalida(LocalTime.of(13, 0));
//
//		registros.add(registros.get(8));
//		registros.get(66).setHoraEntrada(LocalTime.of(9, 0));  registros.get(66).setHoraSalida(LocalTime.of(11, 0));
//
//		registros.add(registros.get(22));
//		registros.get(67).setHoraEntrada(LocalTime.of(14, 0)); registros.get(67).setHoraSalida(LocalTime.of(16, 0));
//
//		registros.add(registros.get(46));
//		registros.get(68).setHoraEntrada(LocalTime.of(12, 0)); registros.get(68).setHoraSalida(LocalTime.of(14, 0));
//
//		registros.add(registros.get(44));
//		registros.get(69).setHoraEntrada(LocalTime.of(8, 0));  registros.get(69).setHoraSalida(LocalTime.of(10, 0));
//
//		registros.add(registros.get(9));
//		registros.get(70).setHoraEntrada(LocalTime.of(10, 0)); registros.get(70).setHoraSalida(LocalTime.of(13, 0));
//
//		registros.add(registros.get(16));
//		registros.get(71).setHoraEntrada(LocalTime.of(13, 0)); registros.get(71).setHoraSalida(LocalTime.of(15, 0));
//
//		registros.add(registros.get(38));
//		registros.get(72).setHoraEntrada(LocalTime.of(9, 0));  registros.get(72).setHoraSalida(LocalTime.of(11, 0));
//
//		registros.add(registros.get(6));
//		registros.get(73).setHoraEntrada(LocalTime.of(11, 0)); registros.get(73).setHoraSalida(LocalTime.of(13, 0));
//
//		registros.add(registros.get(0));
//		registros.get(74).setHoraEntrada(LocalTime.of(14, 0)); registros.get(74).setHoraSalida(LocalTime.of(16, 0));
//
//		registros.add(registros.get(10));
//		registros.get(75).setHoraEntrada(LocalTime.of(12, 0)); registros.get(75).setHoraSalida(LocalTime.of(14, 0));
//
//		registros.get(56).setFecha(LocalDate.of(2025, 5, 3));
//		registros.get(57).setFecha(LocalDate.of(2025, 5, 8));
//		registros.get(58).setFecha(LocalDate.of(2025, 5, 12));
//		registros.get(59).setFecha(LocalDate.of(2025, 5, 15));
//		registros.get(60).setFecha(LocalDate.of(2025, 5, 17));
//		registros.get(61).setFecha(LocalDate.of(2025, 5, 20));
//		registros.get(62).setFecha(LocalDate.of(2025, 5, 22));
//		registros.get(63).setFecha(LocalDate.of(2025, 5, 24));
//		registros.get(64).setFecha(LocalDate.of(2025, 5, 28));
//		registros.get(65).setFecha(LocalDate.of(2025, 6, 1));
//		registros.get(66).setFecha(LocalDate.of(2025, 6, 4));
//		registros.get(67).setFecha(LocalDate.of(2025, 6, 6));
//		registros.get(68).setFecha(LocalDate.of(2025, 6, 10));
//		registros.get(69).setFecha(LocalDate.of(2025, 6, 12));
//		registros.get(70).setFecha(LocalDate.of(2025, 6, 14));
//		registros.get(71).setFecha(LocalDate.of(2025, 6, 17));
//		registros.get(72).setFecha(LocalDate.of(2025, 6, 19));
//		registros.get(73).setFecha(LocalDate.of(2025, 6, 20));
//		registros.get(74).setFecha(LocalDate.of(2025, 6, 21));
//		registros.get(75).setFecha(LocalDate.of(2025, 6, 22));
//		
//		registros.add(registros.get(17));
//		registros.get(76).setHoraEntrada(LocalTime.of(9, 0));  registros.get(76).setHoraSalida(LocalTime.of(12, 0));
//		registros.get(76).setFecha(LocalDate.of(2025, 6, 14));
//
//		registros.add(registros.get(29));
//		registros.get(77).setHoraEntrada(LocalTime.of(14, 0)); registros.get(77).setHoraSalida(LocalTime.of(15, 0));
//		registros.get(77).setFecha(LocalDate.of(2025, 6, 15));
//
//		registros.add(registros.get(13));
//		registros.get(78).setHoraEntrada(LocalTime.of(10, 0)); registros.get(78).setHoraSalida(LocalTime.of(13, 0));
//		registros.get(78).setFecha(LocalDate.of(2025, 6, 16));
//
//		registros.add(registros.get(5));
//		registros.get(79).setHoraEntrada(LocalTime.of(12, 0)); registros.get(79).setHoraSalida(LocalTime.of(14, 0));
//		registros.get(79).setFecha(LocalDate.of(2025, 6, 17));
//
//		registros.add(registros.get(35));
//		registros.get(80).setHoraEntrada(LocalTime.of(8, 0));  registros.get(80).setHoraSalida(LocalTime.of(10, 0));
//		registros.get(80).setFecha(LocalDate.of(2025, 6, 18));
//
//		registros.add(registros.get(47));
//		registros.get(81).setHoraEntrada(LocalTime.of(9, 0));  registros.get(81).setHoraSalida(LocalTime.of(11, 0));
//		registros.get(81).setFecha(LocalDate.of(2025, 6, 18));
//
//		registros.add(registros.get(42));
//		registros.get(82).setHoraEntrada(LocalTime.of(13, 0)); registros.get(82).setHoraSalida(LocalTime.of(15, 0));
//		registros.get(82).setFecha(LocalDate.of(2025, 6, 19));
//
//		registros.add(registros.get(40));
//		registros.get(83).setHoraEntrada(LocalTime.of(10, 0)); registros.get(83).setHoraSalida(LocalTime.of(13, 0));
//		registros.get(83).setFecha(LocalDate.of(2025, 6, 20));
//
//		registros.add(registros.get(25));
//		registros.get(84).setHoraEntrada(LocalTime.of(8, 0));  registros.get(84).setHoraSalida(LocalTime.of(12, 0));
//		registros.get(84).setFecha(LocalDate.of(2025, 6, 21));
//
//		registros.add(registros.get(1));
//		registros.get(85).setHoraEntrada(LocalTime.of(14, 0)); registros.get(85).setHoraSalida(LocalTime.of(16, 0));
//		registros.get(85).setFecha(LocalDate.of(2025, 6, 22));

		
//		personal.add(new Administrativo(" Aniel Vazquez", " 05061368789", Plaza.Secretaria));
//		personal.add(new Directivo(" Lorena Perez", " 95040468971", " Recursos Humanos", " Profesor"," Doctor", TipoContrato.Determinado, CargoDirectivo.Decano, AreaDirectivo.Decanato));
//		personal.add(new Estudiante(" Nicole Rios", " 06040468470",1, 13 ));
//		personal.add(new Especialista(" Josefina Rodriguez", " 00042067847"," GGGGG" ));
//		personal.add(new Profesor(" ALberto Fernandez", "87061669042", " DPOO", "mmm", " Máster", TipoContrato.Determinado));
//		personal.add(new Tecnico(" Erick Valdez", "06040468475","jjj"));
//		personal.add(new Directivo(" Patricia Toro", "06040468476", " Recursos Humanos", " mmm"," Doctor", TipoContrato.Determinado, CargoDirectivo.Vicedecano, AreaDirectivo.Vicedecanato));
//		personal.add(new Tecnico(" Antonio Falcon", "06040468477"," ddd"));
//		personal.add(new Estudiante(" Alvaro Tamayo Portela", " 05040766544",1, 12 ));
//		personal.add(new Profesor(" Jacinto Reina", "06040468479", " Matematica", " mmm", " Doctor", TipoContrato.Determinado));
//		//Estudiantes
//		personal.add(new Estudiante("Aleksander Castañeda", "03110367040",1, 12 )); //10
//		personal.add(new Estudiante("Dariel Velazco Falcón", "05060167362",1, 12 )); //11
//		personal.add(new Estudiante("Brian Monteagudo Pérez", "05072967281",1, 12 )); //12
//		personal.add(new Estudiante("Alexandro Valdés Piñeda", "05091568088",1, 12 )); //13
//		personal.add(new Estudiante("Gloria Santos Rosado", "06030867876",1, 12 )); //14
//		personal.add(new Estudiante("Javier David Coroas", "01061267208",1, 12 )); //15
//		personal.add(new Estudiante("Aylin Vázquez Álvarez", "06061368091",1, 12 ));//16
//		personal.add(new Estudiante("Daniel Prats Parra", "05120467309",1, 12 ));//17
//		personal.add(new Estudiante("Frank Ballmajo Dueñas", "05083168646",1, 12 ));//18
//		personal.add(new Estudiante("Lemuel Sagarra Pérez", "05111066748",1, 12 ));//19
//		personal.add(new Estudiante("Nicole Rios", "06040468470",1, 13 ));//20
//		personal.add(new Estudiante("Nicole Rios", "06040468470",1, 13 ));//21
//		personal.add(new Estudiante("Nicole Rios", "06040468470",1, 13 ));//22
//		personal.add(new Estudiante("Nicole Rios", "06040468470",1, 13 ));//23
//		personal.add(new Estudiante("Nicole Rios", "06040468470",1, 13 ));//24
//		personal.add(new Estudiante("Nicole Rios", "06040468470",1, 13 ));//25
//		personal.add(new Estudiante("Nicole Rios", "06040468470",1, 13 ));//26
//		personal.add(new Estudiante("Nicole Rios", "06040468470",1, 13 ));//27
//		personal.add(new Estudiante("Nicole Rios", "06040468470",1, 13 ));//28
//		personal.add(new Estudiante("Nicole Rios", "06040468470",1, 13 ));//29
//		//Profesores
//		personal.add(new Profesor("Adrian", "06040468479", " DPOO", "Auxiliar", "Ninguna", TipoContrato.Indeterminado)); //30
//		personal.add(new Profesor("Rodolfo ", "06040468479", " Matematica", "Titular", "Máster", TipoContrato.Determinado)); //31
//		personal.add(new Profesor("Sonia Perez Lovell", "06040468479", "DPOO", "Titular", "Doctor", TipoContrato.Determinado)); //32
//		personal.add(new Profesor("Raisa ", "06040468479", "Matemática Computacional", "Titular", "Doctor", TipoContrato.Determinado)); //33
//		personal.add(new Profesor("Javier Garro Cuervo", "06040468479", "Historia de Cuba", "Titular", "Máster", TipoContrato.Determinado)); //34
//		personal.add(new Profesor("Omar David", "06040468479", "DPOO", "Auxiliar", "Ninguna", TipoContrato.Indeterminado)); //35
//		personal.add(new Profesor("Alejandro", "06040468479", "DIP", "Titular", "Doctor", TipoContrato.Determinado)); //36
//		//Directivo
//		personal.add(new Directivo("Raisa Socorro", "06040468476", "CEIS", "Titular","Doctor", TipoContrato.Determinado, CargoDirectivo.Decano, AreaDirectivo.Decanato)); //37
//		personal.add(new Directivo("Mariana Suárez Pérez", "85071245678", "Matemática", "Auxiliar","Máster", TipoContrato.Indeterminado, CargoDirectivo.Jefe_Departamento, AreaDirectivo.Departamento)); //38
//		personal.add(new Directivo("Ernesto Valdés Romero", "74091812345", "Informática", "Titular","Doctor", TipoContrato.Determinado, CargoDirectivo.Vicedecano, AreaDirectivo.Vicedecanato)); //39
//		personal.add(new Directivo("Laura Méndez Rodríguez", "92010498765", "Filosofía", "Instructor","Aspirante", TipoContrato.Determinado, CargoDirectivo.Secretaria_Docente, AreaDirectivo.Secretaria)); //40





		//	registros.add(new Registro(new Visitante("Juan", "00000","mmmm","mmmm", personal.get(2)), locales.get(0)));
		//	registros.add(new Registro(new Visitante("Juanita", "00000","mmmm","mmmm", personal.get(2)), locales.get(0)));





//		registros.get(0).setHoraEntrada(LocalTime.of(8,0));
//		registros.get(0).setHoraSalida(LocalTime.of(12, 0));
//		registros.get(15).setHoraEntrada(LocalTime.of(13, 0));
//		registros.get(15).setHoraSalida(LocalTime.of(14, 0));
//		registros.get(16).setHoraEntrada(LocalTime.of(15, 0));
//		registros.get(16).setHoraSalida(LocalTime.of(16, 0));
//		registros.get(17).setHoraEntrada(LocalTime.of(16, 0));
//		registros.get(17).setHoraSalida(LocalTime.of(17, 0));
//		registros.get(1).setHoraEntrada(LocalTime.of(8,0));
//		registros.get(1).setHoraSalida(LocalTime.of(13, 0));
//		registros.get(2).setHoraEntrada(LocalTime.of(8,0));
//		registros.get(2).setHoraSalida(LocalTime.of(12, 0));
//		registros.get(3).setHoraEntrada(LocalTime.of(12,0));
//		registros.get(3).setHoraSalida(LocalTime.of(14, 0));
//		registros.get(4).setHoraEntrada(LocalTime.of(12,0));
//		registros.get(4).setHoraSalida(LocalTime.of(13, 0));
//		registros.get(5).setHoraEntrada(LocalTime.of(16,0));
//		registros.get(5).setHoraSalida(LocalTime.of(16, 0));
//		registros.get(6).setHoraEntrada(LocalTime.of(9,0));
//		registros.get(6).setHoraSalida(LocalTime.of(12, 0));
//		registros.get(7).setHoraEntrada(LocalTime.of(10,0));
//		registros.get(7).setHoraSalida(LocalTime.of(14, 0));
//		registros.get(8).setHoraEntrada(LocalTime.of(10,0));
//		registros.get(8).setHoraSalida(LocalTime.of(15, 0));
//		registros.get(9).setHoraEntrada(LocalTime.of(10,0));
//		registros.get(9).setHoraSalida(LocalTime.of(11, 0));
//		registros.get(10).setHoraEntrada(LocalTime.of(13,0));
//		registros.get(10).setHoraSalida(LocalTime.of(15, 0));
//		registros.get(11).setHoraEntrada(LocalTime.of(14,0));
//		registros.get(11).setHoraSalida(LocalTime.of(15, 0));
//		registros.get(12).setHoraEntrada(LocalTime.of(15,0));
//		registros.get(12).setHoraSalida(LocalTime.of(16, 0));
//		registros.get(13).setHoraEntrada(LocalTime.of(8,0));
//		registros.get(13).setHoraSalida(LocalTime.of(12, 0));
//		registros.get(14).setHoraEntrada(LocalTime.of(11,0));
//		registros.get(14).setHoraSalida(LocalTime.of(14, 0));


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

	public boolean accesoPermitidoAlLocal(String loc, Persona persona){
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
			else if ( persona instanceof Estudiante &&( TipoLocal.Estudiantes.name().equalsIgnoreCase(loc) || TipoLocal.Aula.name().equalsIgnoreCase(loc)
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

		return permitido;
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
		int[] entrada= new int[12]; //ahora son las 19 y no entra

		for(Registro r: registros){
			int hora = r.getHoraEntrada().getHour();
			int indice = hora - 8;
			if (indice >= 0 && indice < entrada.length) {
			    entrada[indice]++;
			} else {
			    System.out.println("Hora fuera del rango esperado: " + hora);
			}
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
    		if(!res.contains(responsable) ||  responsable instanceof Directivo || responsable instanceof Profesor || responsable instanceof Administrativo ||
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
   
   
    

	public ArrayList<Registro> obtenerInfoLocales(TipoLocal local, LocalDate fechaInicio, LocalDate fechaFin){
		ArrayList<Registro> reporteLocal = new ArrayList<>();

		for(int i=0;i<registros.size();i++)
		{
			if(registros.get(i).getLocal().getTipo().equals(local))
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



