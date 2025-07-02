package inicio;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import controllerClass.Facultad;
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
import enums.AreaDirectivo;
import enums.CargoDirectivo;
import enums.Plaza;
import enums.TipoLocal;
import enums.TipoContrato;
import enums.TipoLocal;


public class Iniciadora {
	
	
	public static void iniciar(){
		ArrayList<Persona> personal = Facultad.getFacultad().getPersonal();
		ArrayList<Local> locales = Facultad.getFacultad().getLocales();
		ArrayList<Registro> registros = Facultad.getFacultad().getVisitas();
		
		
		personal.add(new Tecnico("Sandra Díaz Quesada", "86021234891", "Redes")); //0
		personal.add(new Estudiante("Nicole Rios", "06040468470",1, 13 )); //1
		personal.add(new Directivo("Mariana Suárez Pérez", "85071245678", "Matemática", "Auxiliar","Máster", TipoContrato.Indeterminado, CargoDirectivo.Jefe_Departamento, AreaDirectivo.Departamento)); //2
		personal.add(new Especialista("Leonardo Díaz Cordero", "76050234984", "Interfaz Hombre-Máquina")); //3
		personal.add(new Profesor("Carlos Alberto Ruiz", "77090234919", "Informática", "Auxiliar", "Doctor en Ciencias", TipoContrato.Indeterminado)); //4
		personal.add(new Estudiante("Fernando Ortega Vives", "03032167050", 3, 32 )); //5
		personal.add(new Administrativo("Raúl Martínez Castro", "69011234567", Plaza.Asesor)); //6
		personal.add(new Estudiante("Gloria Santos Rosado", "06030867876",1, 12 )); //7
		personal.add(new Administrativo("Vivian González Díaz", "72021234568", Plaza.Secretaria)); //8
		personal.add(new Especialista("Rosa Amelia Valiente", "79060234985", "Proyectos Tecnológicos")); //9
		personal.add(new Estudiante("Lucía Romero Pérez", "04032267043", 2, 22 )); //10
		personal.add(new Estudiante("Alvaro Tamayo Portela", "05040766544",1, 12 )); //11
		personal.add(new Profesor("Yanelis Rodríguez Pérez", "80122134715", "MC", "Titular", "Doctor en Ciencias", TipoContrato.Determinado)); //12
		personal.add(new Estudiante("Mariana Torres Díaz", "05032267041", 1, 13 )); //13
		personal.add(new Administrativo("Claudia Reyes Valdés", "81041234570", Plaza.Secretaria)); //14
		personal.add(new Estudiante("Brian Monteagudo Pérez", "05072967281",1, 12 )); //15
		personal.add(new Directivo("Laura Méndez Rodríguez", "92010428765", "Filosofía", "Instructor","Aspirante", TipoContrato.Determinado, CargoDirectivo.Secretaria_Docente, AreaDirectivo.Secretaria)); //16
		personal.add(new Tecnico("Liset Pérez Ferrer", "81041234893", "Soporte Técnico")); //17
		personal.add(new Estudiante("Aleksander Castañeda", "03110367040",1, 12 )); //18
		personal.add(new Estudiante("Andrea Gómez Fuentes", "03032267045", 3, 31 )); //19
		personal.add(new Profesor("Martha Velázquez León", "76070234926", "Informática", "Auxiliar", "Ninguna", TipoContrato.Determinado)); //20
		personal.add(new Estudiante("Carlos Pérez Sánchez", "04032167042", 2, 22 )); //21
		personal.add(new Especialista("Reynaldo Pacheco Morales", "80110234980", "Desarrollo de Software")); //22
		personal.add(new Estudiante("Camila Núñez Torres", "02032267051", 4, 41 )); //23
		personal.add(new Estudiante("Daniel Prats Parra", "05120467309",1, 12 )); //24
		personal.add(new Directivo("Raisa Socorro", "06040468476", "CEIS", "Titular","Doctor", TipoContrato.Determinado, CargoDirectivo.Decano, AreaDirectivo.Decanato)); //25
		personal.add(new Estudiante("Luis Alberto Benítez", "02032167046", 4, 42 )); //26
		personal.add(new Profesor("Lorenzo Castillo Álvarez", "75100234912", "Matemática", "Titular", "Máster", TipoContrato.Indeterminado)); //27
		personal.add(new Especialista("Yusleidis Ávila Sánchez", "85020234981", "Inteligencia Artificial")); //28
		personal.add(new Estudiante("Javier David Coroas Cintra", "01061267208",1, 12 )); //29
		personal.add(new Estudiante("Aylin Vázquez Álvarez", "06061368091",1, 12 )); //30
		personal.add(new Administrativo("Tomás Herrera Curbelo", "70051234571", Plaza.Asesor)); //31
		personal.add(new Estudiante("José Ángel Ramírez", "03032267044", 3, 31 )); //32
		personal.add(new Estudiante("Matías Herrera Peña", "05032167048", 1, 13 )); //33
		personal.add(new Estudiante("Diana Cabrera León", "02032267047", 4, 41 )); //34
		personal.add(new Estudiante("Alexandro Valdés Piñeda", "05091568088",1, 12 )); //35
		personal.add(new Tecnico("Eliécer Gómez Hernández", "82011234890", "Electricidad")); //36
		personal.add(new Estudiante("Isabela Suárez Correa", "04032267049", 2, 21 )); //37
		personal.add(new Administrativo("Yamila Cabrera", "79061234572", Plaza.Secretaria)); //38
		personal.add(new Especialista("Orlando Domínguez", "78030234982", "Automatización de Red")); //39
		personal.add(new Profesor("Luis Enrique Fernández", "79080234924", "Informática", "Titular", "Máster", TipoContrato.Indeterminado)); //40
		personal.add(new Estudiante("Frank Ballmajo Dueñas", "05083168646",1, 12 )); //41
		personal.add(new Profesor("Dailyn Suárez Gómez", "81110234923", "Base de datos", "Instructor", "Máster", TipoContrato.Determinado)); //42
		personal.add(new Estudiante("Dariel Velazco Falcón", "05060167362",1, 12 )); //43
		personal.add(new Estudiante("Lemuel Sagarra Pérez", "05111066748",1, 12 )); //44
		personal.add(new Estudiante("Marta Caridad", "04032287044", 2, 22 )); //45 
		personal.add(new Tecnico("Marcos Álvarez Suárez", "79031234892", "Mantenimiento")); //46
		personal.add(new Administrativo("Ernesto López Pérez", "75031234569", Plaza.Asesor)); //47
		personal.add(new Directivo("Ernesto Valdés Romero", "74091812345", "Informática", "Titular","Doctor", TipoContrato.Determinado, CargoDirectivo.Vicedecano, AreaDirectivo.Vicedecanato)); //48

	

		locales.add(new Local("404", TipoLocal.Estudiantes, personal.get(27))); //0
		locales.add(new Local("D201", TipoLocal.Decano, personal.get(47) ));  //1
		locales.add(new Local("245L", TipoLocal.Laboratorio, personal.get(31) )); //2
		locales.add(new Local("E301", TipoLocal.Especialistas, personal.get(38) )); //3
		locales.add(new Local("Ad99", TipoLocal.Area_Administrativa, personal.get(22) ));//4
		locales.add(new Local("102", TipoLocal.Jefe_Departamento, personal.get(27) ));//5
		locales.add(new Local("V202", TipoLocal.Vicedecano, personal.get(25) ));//6
		locales.add(new Local("505", TipoLocal.Servidores, personal.get(42)));//7
		locales.add(new Local("203", TipoLocal.Aula, personal.get(28) ));//8
		locales.add(new Local("2P4", TipoLocal.Profesores, personal.get(2) ));//9

		
		registros.add(new Registro(personal.get(5), locales.get(0))); //0
		registros.get(0).setHoraEntrada(LocalTime.of(8, 0)); registros.get(0).setHoraSalida(LocalTime.of(12, 0));
		registros.get(0).setFecha(LocalDate.of(2025, 5, 1));

		registros.add(new Registro(personal.get(8), locales.get(3))); //1
		registros.get(1).setHoraEntrada(LocalTime.of(9, 0)); registros.get(1).setHoraSalida(LocalTime.of(11, 0));
		registros.get(1).setFecha(LocalDate.of(2025, 5, 2));

		registros.add(new Registro(personal.get(14), locales.get(3))); //2
		registros.get(2).setHoraEntrada(LocalTime.of(10, 0)); registros.get(2).setHoraSalida(LocalTime.of(13, 0));
		registros.get(2).setFecha(LocalDate.of(2025, 5, 3));

		registros.add(new Registro(personal.get(10), locales.get(8))); //3
		registros.get(3).setHoraEntrada(LocalTime.of(13, 0)); registros.get(3).setHoraSalida(LocalTime.of(15, 0));
		registros.get(3).setFecha(LocalDate.of(2025, 5, 4));

		registros.add(new Registro(personal.get(39), locales.get(7))); //4
		registros.get(4).setHoraEntrada(LocalTime.of(12, 0)); registros.get(4).setHoraSalida(LocalTime.of(14, 0));
		registros.get(4).setFecha(LocalDate.of(2025, 5, 5));

		registros.add(new Registro(personal.get(28), locales.get(8))); //5
		registros.get(5).setHoraEntrada(LocalTime.of(10, 0)); registros.get(5).setHoraSalida(LocalTime.of(12, 0));
		registros.get(5).setFecha(LocalDate.of(2025, 5, 6));

		registros.add(new Registro(personal.get(3), locales.get(4))); //6
		registros.get(6).setHoraEntrada(LocalTime.of(11, 0)); registros.get(6).setHoraSalida(LocalTime.of(15, 0));
		registros.get(6).setFecha(LocalDate.of(2025, 5, 7));

		registros.add(new Registro(personal.get(41), locales.get(0))); //7
		registros.get(7).setHoraEntrada(LocalTime.of(9, 0)); registros.get(7).setHoraSalida(LocalTime.of(11, 0));
		registros.get(7).setFecha(LocalDate.of(2025, 5, 8));

		registros.add(new Registro(personal.get(6), locales.get(1))); //8
		registros.get(8).setHoraEntrada(LocalTime.of(10, 0)); registros.get(8).setHoraSalida(LocalTime.of(12, 0));
		registros.get(8).setFecha(LocalDate.of(2025, 5, 9));

		registros.add(new Registro(personal.get(1), locales.get(4))); //9
		registros.get(9).setHoraEntrada(LocalTime.of(8, 0)); registros.get(9).setHoraSalida(LocalTime.of(11, 0));
		registros.get(9).setFecha(LocalDate.of(2025, 5, 10));

		registros.add(new Registro(personal.get(2), locales.get(9))); //10
		registros.get(10).setHoraEntrada(LocalTime.of(10, 0)); registros.get(10).setHoraSalida(LocalTime.of(13, 0));
		registros.get(10).setFecha(LocalDate.of(2025, 5, 11));

		registros.add(new Registro(personal.get(12), locales.get(0))); //11
		registros.get(11).setHoraEntrada(LocalTime.of(11, 0)); registros.get(11).setHoraSalida(LocalTime.of(14, 0));
		registros.get(11).setFecha(LocalDate.of(2025, 5, 12));

		registros.add(new Registro(personal.get(7), locales.get(0))); //12
		registros.get(12).setHoraEntrada(LocalTime.of(13, 0)); registros.get(12).setHoraSalida(LocalTime.of(16, 0));
		registros.get(12).setFecha(LocalDate.of(2025, 5, 13));

		registros.add(new Registro(personal.get(20), locales.get(9))); //13
		registros.get(13).setHoraEntrada(LocalTime.of(8, 0)); registros.get(13).setHoraSalida(LocalTime.of(10, 0));
		registros.get(13).setFecha(LocalDate.of(2025, 5, 14));

		registros.add(new Registro(personal.get(4), locales.get(3))); //14
		registros.get(14).setHoraEntrada(LocalTime.of(12, 0)); registros.get(14).setHoraSalida(LocalTime.of(14, 0));
		registros.get(14).setFecha(LocalDate.of(2025, 5, 15));

		registros.add(new Registro(personal.get(15), locales.get(6))); //15
		registros.get(15).setHoraEntrada(LocalTime.of(9, 0)); registros.get(15).setHoraSalida(LocalTime.of(13, 0));
		registros.get(15).setFecha(LocalDate.of(2025, 5, 16));

		// Día 1 de mayo
		registros.add(new Registro(personal.get(24), locales.get(4))); //16
		registros.get(16).setHoraEntrada(LocalTime.of(13, 0)); registros.get(16).setHoraSalida(LocalTime.of(15, 0));
		registros.get(16).setFecha(LocalDate.of(2025, 5, 1));

		// Día 2 de mayo
		registros.add(new Registro(personal.get(9), locales.get(3))); //17
		registros.get(17).setHoraEntrada(LocalTime.of(11, 0)); registros.get(17).setHoraSalida(LocalTime.of(13, 0));
		registros.get(17).setFecha(LocalDate.of(2025, 5, 2));

		// Día 3 de mayo
		registros.add(new Registro(personal.get(11), locales.get(3))); //18
		registros.get(18).setHoraEntrada(LocalTime.of(8, 0)); registros.get(18).setHoraSalida(LocalTime.of(10, 0));
		registros.get(18).setFecha(LocalDate.of(2025, 5, 3));

		// Día 4 de mayo
		registros.add(new Registro(personal.get(37), locales.get(8))); //19
		registros.get(19).setHoraEntrada(LocalTime.of(10, 0)); registros.get(19).setHoraSalida(LocalTime.of(12, 0));
		registros.get(19).setFecha(LocalDate.of(2025, 5, 4));

		// Día 5 de mayo
		registros.add(new Registro(personal.get(18), locales.get(7))); //20
		registros.get(20).setHoraEntrada(LocalTime.of(8, 0)); registros.get(20).setHoraSalida(LocalTime.of(11, 0));
		registros.get(20).setFecha(LocalDate.of(2025, 5, 5));

		// Día 6 de mayo
		registros.add(new Registro(personal.get(26), locales.get(8))); //21
		registros.get(21).setHoraEntrada(LocalTime.of(12, 0)); registros.get(21).setHoraSalida(LocalTime.of(14, 0));
		registros.get(21).setFecha(LocalDate.of(2025, 5, 6));

		// Día 7 de mayo
		registros.add(new Registro(personal.get(32), locales.get(4))); //22
		registros.get(22).setHoraEntrada(LocalTime.of(8, 0)); registros.get(22).setHoraSalida(LocalTime.of(11, 0));
		registros.get(22).setFecha(LocalDate.of(2025, 5, 7));

		// Día 8 de mayo
		registros.add(new Registro(personal.get(13), locales.get(0))); //23
		registros.get(23).setHoraEntrada(LocalTime.of(11, 0)); registros.get(23).setHoraSalida(LocalTime.of(13, 0));
		registros.get(23).setFecha(LocalDate.of(2025, 5, 8));

		// Día 9 de mayo
		registros.add(new Registro(personal.get(36), locales.get(1))); //24
		registros.get(24).setHoraEntrada(LocalTime.of(13, 0)); registros.get(24).setHoraSalida(LocalTime.of(16, 0));
		registros.get(24).setFecha(LocalDate.of(2025, 5, 9));

		// Día 10 de mayo
		registros.add(new Registro(personal.get(33), locales.get(4))); //25
		registros.get(25).setHoraEntrada(LocalTime.of(12, 0)); registros.get(25).setHoraSalida(LocalTime.of(14, 0));
		registros.get(25).setFecha(LocalDate.of(2025, 5, 10));

		// Día 11 de mayo
		registros.add(new Registro(personal.get(30), locales.get(9))); //26
		registros.get(26).setHoraEntrada(LocalTime.of(13, 0)); registros.get(26).setHoraSalida(LocalTime.of(15, 0));
		registros.get(26).setFecha(LocalDate.of(2025, 5, 11));

		// Día 12 de mayo
		registros.add(new Registro(personal.get(0), locales.get(0))); //27
		registros.get(27).setHoraEntrada(LocalTime.of(8, 0)); registros.get(27).setHoraSalida(LocalTime.of(10, 0));
		registros.get(27).setFecha(LocalDate.now());

		// Día 13 de mayo
		registros.add(new Registro(personal.get(34), locales.get(0))); //28
		registros.get(28).setHoraEntrada(LocalTime.of(10, 0)); registros.get(28).setHoraSalida(LocalTime.of(12, 0));
		registros.get(28).setFecha(LocalDate.of(2025, 5, 13));

		// Día 14 de mayo
		registros.add(new Registro(personal.get(27), locales.get(9))); //29
		registros.get(29).setHoraEntrada(LocalTime.of(9, 0)); registros.get(29).setHoraSalida(LocalTime.of(11, 0));
		registros.get(29).setFecha(LocalDate.of(2025, 5, 14));

		// Día 15 de mayo
		registros.add(new Registro(personal.get(35), locales.get(3))); //30
		registros.get(30).setHoraEntrada(LocalTime.of(8, 0)); registros.get(30).setHoraSalida(LocalTime.of(10, 0));
		registros.get(30).setFecha(LocalDate.of(2025, 5, 15));

		// Día 16 de mayo
		registros.add(new Registro(personal.get(11), locales.get(6))); //31
		registros.get(31).setHoraEntrada(LocalTime.of(13, 0)); registros.get(31).setHoraSalida(LocalTime.of(16, 0));
		registros.get(31).setFecha(LocalDate.of(2025, 5, 16));

		// Día 1 de mayo
		registros.add(new Registro(personal.get(22), locales.get(0))); //32
		registros.get(32).setHoraEntrada(LocalTime.of(12, 0)); registros.get(32).setHoraSalida(LocalTime.of(14, 0));
		registros.get(32).setFecha(LocalDate.of(2025, 5, 1));

		// Día 2 de mayo
		registros.add(new Registro(personal.get(31), locales.get(3))); //33
		registros.get(33).setHoraEntrada(LocalTime.of(13, 0)); registros.get(33).setHoraSalida(LocalTime.of(16, 0));
		registros.get(33).setFecha(LocalDate.of(2025, 5, 2));

		// Día 3 de mayo
		registros.add(new Registro(personal.get(19), locales.get(3))); //34
		registros.get(34).setHoraEntrada(LocalTime.of(12, 0)); registros.get(34).setHoraSalida(LocalTime.of(14, 0));
		registros.get(34).setFecha(LocalDate.of(2025, 5, 3));

		// Día 4 de mayo
		registros.add(new Registro(personal.get(44), locales.get(8))); //35
		registros.get(35).setHoraEntrada(LocalTime.of(8, 0)); registros.get(35).setHoraSalida(LocalTime.of(10, 0));
		registros.get(35).setFecha(LocalDate.of(2025, 5, 4));

		// Día 5 de mayo
		registros.add(new Registro(personal.get(21), locales.get(7))); //36
		registros.get(36).setHoraEntrada(LocalTime.of(13, 0)); registros.get(36).setHoraSalida(LocalTime.of(15, 0));
		registros.get(36).setFecha(LocalDate.of(2025, 5, 5));

		// Día 6 de mayo
		registros.add(new Registro(personal.get(36), locales.get(8))); //37
		registros.get(37).setHoraEntrada(LocalTime.of(8, 0)); registros.get(37).setHoraSalida(LocalTime.of(11, 0));
		registros.get(37).setFecha(LocalDate.of(2025, 5, 6));

		// Día 7 de mayo
		registros.add(new Registro(personal.get(40), locales.get(4))); //38
		registros.get(38).setHoraEntrada(LocalTime.of(13, 0)); registros.get(38).setHoraSalida(LocalTime.of(16, 0));
		registros.get(38).setFecha(LocalDate.of(2025, 5, 7));

		// Día 8 de mayo
		registros.add(new Registro(personal.get(17), locales.get(0))); //39
		registros.get(39).setHoraEntrada(LocalTime.of(12, 0)); registros.get(39).setHoraSalida(LocalTime.of(15, 0));
		registros.get(39).setFecha(LocalDate.of(2025, 5, 8));

		// Día 9 de mayo
		registros.add(new Registro(personal.get(16), locales.get(1))); //40
		registros.get(40).setHoraEntrada(LocalTime.of(8, 0)); registros.get(40).setHoraSalida(LocalTime.of(10, 0));
		registros.get(40).setFecha(LocalDate.of(2025, 5, 9));

		// Día 10 de mayo
		registros.add(new Registro(personal.get(42), locales.get(4))); //41
		registros.get(41).setHoraEntrada(LocalTime.of(10, 0)); registros.get(41).setHoraSalida(LocalTime.of(13, 0));
		registros.get(41).setFecha(LocalDate.of(2025, 5, 10));

		// Día 11 de mayo
		registros.add(new Registro(personal.get(25), locales.get(9))); //42
		registros.get(42).setHoraEntrada(LocalTime.of(9, 0)); registros.get(42).setHoraSalida(LocalTime.of(11, 0));
		registros.get(42).setFecha(LocalDate.of(2025, 5, 11));

		// Día 12 de mayo
		registros.add(new Registro(personal.get(43), locales.get(0))); //43
		registros.get(43).setHoraEntrada(LocalTime.of(13, 0)); registros.get(43).setHoraSalida(LocalTime.of(15, 0));
		registros.get(43).setFecha(LocalDate.of(2025, 5, 12));

		// Día 13 de mayo
		registros.add(new Registro(personal.get(29), locales.get(0))); //44
		registros.get(44).setHoraEntrada(LocalTime.of(9, 0)); registros.get(44).setHoraSalida(LocalTime.of(11, 0));
		registros.get(44).setFecha(LocalDate.of(2025, 5, 13));

		// Día 14 de mayo
		registros.add(new Registro(personal.get(45), locales.get(9))); //45
		registros.get(45).setHoraEntrada(LocalTime.of(13, 0)); registros.get(45).setHoraSalida(LocalTime.of(16, 0));
		registros.get(45).setFecha(LocalDate.of(2025, 5, 14));

		// Día 15 de mayo
		registros.add(new Registro(personal.get(46), locales.get(3))); //46
		registros.get(46).setHoraEntrada(LocalTime.of(10, 0)); registros.get(46).setHoraSalida(LocalTime.of(13, 0));
		registros.get(46).setFecha(LocalDate.of(2025, 5, 15));

		// Día 16 de mayo
		registros.add(new Registro(personal.get(23), locales.get(6))); //47
		registros.get(47).setHoraEntrada(LocalTime.of(8, 0)); registros.get(47).setHoraSalida(LocalTime.of(10, 0));
		registros.get(47).setFecha(LocalDate.of(2025, 5, 16));

		registros.add(new Registro(personal.get(5), locales.get(0))); //48
		registros.get(48).setHoraEntrada(LocalTime.of(8, 0)); registros.get(48).setHoraSalida(LocalTime.of(9, 30));
		registros.get(48).setFecha(LocalDate.of(2025, 5, 17));

		registros.add(new Registro(personal.get(5), locales.get(2))); //49
		registros.get(49).setHoraEntrada(LocalTime.of(9, 45)); registros.get(49).setHoraSalida(LocalTime.of(11, 0));
		registros.get(49).setFecha(LocalDate.of(2025, 5, 17));

		registros.add(new Registro(personal.get(5), locales.get(4))); //50
		registros.get(50).setHoraEntrada(LocalTime.of(11, 30)); registros.get(50).setHoraSalida(LocalTime.of(13, 0));
		registros.get(50).setFecha(LocalDate.of(2025, 5, 17));

		registros.add(new Registro(personal.get(5), locales.get(9))); //51
		registros.get(51).setHoraEntrada(LocalTime.of(13, 30)); registros.get(51).setHoraSalida(LocalTime.of(15, 0));
		registros.get(51).setFecha(LocalDate.of(2025, 5, 17));

		registros.add(new Registro(personal.get(22), locales.get(2))); //52
		registros.get(52).setHoraEntrada(LocalTime.of(8, 0)); registros.get(52).setHoraSalida(LocalTime.of(10, 0));
		registros.get(52).setFecha(LocalDate.of(2025, 6, 1));

		registros.add(new Registro(personal.get(34), locales.get(7))); //53
		registros.get(53).setHoraEntrada(LocalTime.of(9, 0)); registros.get(53).setHoraSalida(LocalTime.of(12, 0));
		registros.get(53).setFecha(LocalDate.of(2025, 6, 3));

		registros.add(new Registro(personal.get(43), locales.get(0))); //54
		registros.get(54).setHoraEntrada(LocalTime.of(10, 0)); registros.get(54).setHoraSalida(LocalTime.of(13, 0));
		registros.get(54).setFecha(LocalDate.of(2025, 6, 5));

		registros.add(new Registro(personal.get(11), locales.get(6))); //55
		registros.get(55).setHoraEntrada(LocalTime.of(13, 0)); registros.get(55).setHoraSalida(LocalTime.of(15, 0));
		registros.get(55).setFecha(LocalDate.of(2025, 6, 6));

		registros.add(new Registro(personal.get(38), locales.get(1))); //56
		registros.get(56).setHoraEntrada(LocalTime.of(8, 0)); registros.get(56).setHoraSalida(LocalTime.of(10, 0));
		registros.get(56).setFecha(LocalDate.of(2025, 6, 7));

		registros.add(new Registro(personal.get(15), locales.get(9))); //57
		registros.get(57).setHoraEntrada(LocalTime.of(10, 0)); registros.get(57).setHoraSalida(LocalTime.of(12, 0));
		registros.get(57).setFecha(LocalDate.of(2025, 6, 10));

		registros.add(new Registro(personal.get(7), locales.get(5))); //58
		registros.get(58).setHoraEntrada(LocalTime.of(12, 0)); registros.get(58).setHoraSalida(LocalTime.of(14, 0));
		registros.get(58).setFecha(LocalDate.of(2025, 6, 13));

		registros.add(new Registro(personal.get(27), locales.get(1))); //59
		registros.get(59).setHoraEntrada(LocalTime.of(14, 0)); registros.get(59).setHoraSalida(LocalTime.of(16, 0));
		registros.get(59).setFecha(LocalDate.of(2025, 6, 15));

		registros.add(new Registro(personal.get(36), locales.get(3))); //60
		registros.get(60).setHoraEntrada(LocalTime.of(8, 0)); registros.get(60).setHoraSalida(LocalTime.of(10, 0));
		registros.get(60).setFecha(LocalDate.of(2025, 6, 17));

		registros.add(new Registro(personal.get(9), locales.get(6))); //61
		registros.get(61).setHoraEntrada(LocalTime.of(9, 0)); registros.get(61).setHoraSalida(LocalTime.of(11, 0));
		registros.get(61).setFecha(LocalDate.of(2025, 6, 19));

		registros.add(new Registro(personal.get(33), locales.get(4))); //62
		registros.get(62).setHoraEntrada(LocalTime.of(11, 0)); registros.get(62).setHoraSalida(LocalTime.of(13, 0));
		registros.get(62).setFecha(LocalDate.of(2025, 6, 20));

		registros.add(new Registro(personal.get(13), locales.get(5))); //63
		registros.get(63).setHoraEntrada(LocalTime.of(13, 0)); registros.get(63).setHoraSalida(LocalTime.of(15, 0));
		registros.get(63).setFecha(LocalDate.of(2025, 6, 22));

		// Activando a personal.get(5) con visitas múltiples
		registros.add(new Registro(personal.get(5), locales.get(2))); //64
		registros.get(64).setHoraEntrada(LocalTime.of(8, 0)); registros.get(64).setHoraSalida(LocalTime.of(10, 0));
		registros.get(64).setFecha(LocalDate.of(2025, 6, 3));

		registros.add(new Registro(personal.get(5), locales.get(5))); //65
		registros.get(65).setHoraEntrada(LocalTime.of(10, 30)); registros.get(65).setHoraSalida(LocalTime.of(12, 30));
		registros.get(65).setFecha(LocalDate.of(2025, 6, 3));

		registros.add(new Registro(personal.get(5), locales.get(0))); //66
		registros.get(66).setHoraEntrada(LocalTime.of(13, 0)); registros.get(66).setHoraSalida(LocalTime.of(14, 30));
		registros.get(66).setFecha(LocalDate.of(2025, 6, 3));

		// Activando a personal.get(12) con 3 visitas
		registros.add(new Registro(personal.get(12), locales.get(0))); //67
		registros.get(67).setHoraEntrada(LocalTime.of(9, 0)); registros.get(67).setHoraSalida(LocalTime.of(11, 0));
		registros.get(67).setFecha(LocalDate.of(2025, 6, 5));

		registros.add(new Registro(personal.get(12), locales.get(8))); //68
		registros.get(68).setHoraEntrada(LocalTime.of(11, 15)); registros.get(68).setHoraSalida(LocalTime.of(13, 0));
		registros.get(68).setFecha(LocalDate.of(2025, 6, 5));

		registros.add(new Registro(personal.get(12), locales.get(1))); //69
		registros.get(69).setHoraEntrada(LocalTime.of(13, 30)); registros.get(69).setHoraSalida(LocalTime.of(15, 0));
		registros.get(69).setFecha(LocalDate.of(2025, 6, 5));

		// Activando a personal.get(22)
		registros.add(new Registro(personal.get(22), locales.get(4))); //70
		registros.get(70).setHoraEntrada(LocalTime.of(8, 30)); registros.get(70).setHoraSalida(LocalTime.of(10, 30));
		registros.get(70).setFecha(LocalDate.of(2025, 6, 7));

		registros.add(new Registro(personal.get(22), locales.get(3))); //71
		registros.get(71).setHoraEntrada(LocalTime.of(11, 0)); registros.get(71).setHoraSalida(LocalTime.of(13, 0));
		registros.get(71).setFecha(LocalDate.of(2025, 6, 7));

		// Otros registros adicionales variados
		registros.add(new Registro(personal.get(26), locales.get(6))); //72
		registros.get(72).setHoraEntrada(LocalTime.of(8, 0)); registros.get(72).setHoraSalida(LocalTime.of(10, 0));
		registros.get(72).setFecha(LocalDate.of(2025, 6, 10));

		registros.add(new Registro(personal.get(38), locales.get(3))); //73
		registros.get(73).setHoraEntrada(LocalTime.of(10, 30)); registros.get(73).setHoraSalida(LocalTime.of(12, 30));
		registros.get(73).setFecha(LocalDate.of(2025, 6, 13));

		registros.add(new Registro(personal.get(41), locales.get(8))); //74
		registros.get(74).setHoraEntrada(LocalTime.of(12, 30)); registros.get(74).setHoraSalida(LocalTime.of(15, 0));
		registros.get(74).setFecha(LocalDate.of(2025, 6, 13));

		registros.add(new Registro(personal.get(5), locales.get(0))); //75
		registros.get(75).setHoraEntrada(LocalTime.of(8, 0)); registros.get(75).setHoraSalida(LocalTime.of(10, 0));
		registros.get(75).setFecha(LocalDate.of(2025, 6, 11));

		registros.add(new Registro(personal.get(12), locales.get(5))); //76
		registros.get(76).setHoraEntrada(LocalTime.of(10, 30)); registros.get(76).setHoraSalida(LocalTime.of(13, 0));
		registros.get(76).setFecha(LocalDate.of(2025, 6, 11));

		registros.add(new Registro(personal.get(22), locales.get(3))); //77
		registros.get(77).setHoraEntrada(LocalTime.of(13, 0)); registros.get(77).setHoraSalida(LocalTime.of(15, 0));
		registros.get(77).setFecha(LocalDate.of(2025, 6, 11));

		registros.add(new Registro(personal.get(7), locales.get(2))); //78
		registros.get(78).setHoraEntrada(LocalTime.of(8, 30)); registros.get(78).setHoraSalida(LocalTime.of(10, 30));
		registros.get(78).setFecha(LocalDate.of(2025, 6, 12));

		registros.add(new Registro(personal.get(43), locales.get(7))); //79
		registros.get(79).setHoraEntrada(LocalTime.of(10, 45)); registros.get(79).setHoraSalida(LocalTime.of(13, 15));
		registros.get(79).setFecha(LocalDate.of(2025, 6, 12));

		registros.add(new Registro(personal.get(12), locales.get(8))); //80
		registros.get(80).setHoraEntrada(LocalTime.of(14, 00)); registros.get(80).setHoraSalida(LocalTime.of(16, 0));
		registros.get(80).setFecha(LocalDate.of(2025, 6, 12));

		registros.add(new Registro(personal.get(18), locales.get(0))); //81
		registros.get(81).setHoraEntrada(LocalTime.of(8, 0)); registros.get(81).setHoraSalida(LocalTime.of(9, 30));
		registros.get(81).setFecha(LocalDate.of(2025, 6, 13));

		registros.add(new Registro(personal.get(18), locales.get(4))); //82
		registros.get(82).setHoraEntrada(LocalTime.of(9, 45)); registros.get(82).setHoraSalida(LocalTime.of(11, 45));
		registros.get(82).setFecha(LocalDate.of(2025, 6, 13));

		registros.add(new Registro(personal.get(18), locales.get(9))); //83
		registros.get(83).setHoraEntrada(LocalTime.of(13, 0)); registros.get(83).setHoraSalida(LocalTime.of(15, 0));
		registros.get(83).setFecha(LocalDate.of(2025, 6, 13));

		registros.add(new Registro(personal.get(30), locales.get(1))); //84
		registros.get(84).setHoraEntrada(LocalTime.of(8, 0)); registros.get(84).setHoraSalida(LocalTime.of(10, 0));
		registros.get(84).setFecha(LocalDate.of(2025, 6, 14));

		registros.add(new Registro(personal.get(11), locales.get(6))); //85
		registros.get(85).setHoraEntrada(LocalTime.of(10, 30)); registros.get(85).setHoraSalida(LocalTime.of(13, 0));
		registros.get(85).setFecha(LocalDate.of(2025, 6, 14));

		registros.add(new Registro(personal.get(44), locales.get(2))); //86
		registros.get(86).setHoraEntrada(LocalTime.of(13, 30)); registros.get(86).setHoraSalida(LocalTime.of(15, 30));
		registros.get(86).setFecha(LocalDate.of(2025, 6, 14));

		registros.add(new Registro(personal.get(5), locales.get(5))); //87
		registros.get(87).setHoraEntrada(LocalTime.of(8, 0)); registros.get(87).setHoraSalida(LocalTime.of(10, 0));
		registros.get(87).setFecha(LocalDate.of(2025, 6, 15));

		registros.add(new Registro(personal.get(5), locales.get(8))); //88
		registros.get(88).setHoraEntrada(LocalTime.of(10, 15)); registros.get(88).setHoraSalida(LocalTime.of(12, 0));
		registros.get(88).setFecha(LocalDate.of(2025, 6, 15));

		registros.add(new Registro(personal.get(5), locales.get(6))); //89
		registros.get(89).setHoraEntrada(LocalTime.of(13, 0)); registros.get(89).setHoraSalida(LocalTime.of(15, 0));
		registros.get(89).setFecha(LocalDate.of(2025, 6, 15));

		registros.add(new Registro(personal.get(40), locales.get(9))); //90
		registros.get(90).setHoraEntrada(LocalTime.of(8, 0)); registros.get(90).setHoraSalida(LocalTime.of(10, 0));
		registros.get(90).setFecha(LocalDate.of(2025, 6, 16));

		registros.add(new Registro(personal.get(36), locales.get(0))); //91
		registros.get(91).setHoraEntrada(LocalTime.of(10, 15)); registros.get(91).setHoraSalida(LocalTime.of(12, 30));
		registros.get(91).setFecha(LocalDate.of(2025, 6, 16));

		registros.add(new Registro(personal.get(2), locales.get(1))); //92
		registros.get(92).setHoraEntrada(LocalTime.of(13, 00)); registros.get(92).setHoraSalida(LocalTime.of(15, 0));
		registros.get(92).setFecha(LocalDate.of(2025, 6, 16));

		registros.add(new Registro(personal.get(17), locales.get(4))); //93
		registros.get(93).setHoraEntrada(LocalTime.of(8, 0)); registros.get(93).setHoraSalida(LocalTime.of(10, 0));
		registros.get(93).setFecha(LocalDate.of(2025, 6, 17));

		registros.add(new Registro(personal.get(8), locales.get(8))); //94
		registros.get(94).setHoraEntrada(LocalTime.of(10, 15)); registros.get(94).setHoraSalida(LocalTime.of(12, 0));
		registros.get(94).setFecha(LocalDate.of(2025, 6, 17));

		registros.add(new Registro(personal.get(1), locales.get(6))); //95
		registros.get(95).setHoraEntrada(LocalTime.of(13, 0)); registros.get(95).setHoraSalida(LocalTime.of(15, 0));
		registros.get(95).setFecha(LocalDate.of(2025, 6, 17));

		registros.add(new Registro(personal.get(24), locales.get(2))); //96
		registros.get(96).setHoraEntrada(LocalTime.of(8, 0)); registros.get(96).setHoraSalida(LocalTime.of(10, 0));
		registros.get(96).setFecha(LocalDate.of(2025, 6, 18));

		registros.add(new Registro(personal.get(6), locales.get(0))); //97
		registros.get(97).setHoraEntrada(LocalTime.of(10, 15)); registros.get(97).setHoraSalida(LocalTime.of(12, 00));
		registros.get(97).setFecha(LocalDate.of(2025, 6, 18));

		registros.add(new Registro(personal.get(14), locales.get(3))); //98
		registros.get(98).setHoraEntrada(LocalTime.of(13, 00)); registros.get(98).setHoraSalida(LocalTime.of(15, 00));
		registros.get(98).setFecha(LocalDate.of(2025, 6, 18));

		registros.add(new Registro(personal.get(10), locales.get(5))); //99
		registros.get(99).setHoraEntrada(LocalTime.of(8, 0)); registros.get(99).setHoraSalida(LocalTime.of(10, 0));
		registros.get(99).setFecha(LocalDate.of(2025, 6, 20));

		registros.add(new Registro(personal.get(4), locales.get(9))); //100
		registros.get(100).setHoraEntrada(LocalTime.of(10, 30)); registros.get(100).setHoraSalida(LocalTime.of(12, 30));
		registros.get(100).setFecha(LocalDate.of(2025, 6, 20));

		registros.add(new Registro(personal.get(0), locales.get(3))); //102
		registros.get(101).setHoraEntrada(LocalTime.of(8, 0)); registros.get(101).setHoraSalida(LocalTime.of(10, 0));
		registros.get(101).setFecha(LocalDate.now());

		registros.add(new Registro(personal.get(0), locales.get(5))); //103
		registros.get(102).setHoraEntrada(LocalTime.of(10, 30)); registros.get(102).setHoraSalida(LocalTime.of(12, 30));
		registros.get(102).setFecha(LocalDate.of(2025, 6, 2));

		registros.add(new Registro(personal.get(13), locales.get(0))); //104
		registros.get(103).setHoraEntrada(LocalTime.of(9, 0)); registros.get(103).setHoraSalida(LocalTime.of(11, 0));
		registros.get(103).setFecha(LocalDate.of(2025, 6, 4));
		
		registros.add(new Registro(personal.get(17), locales.get(0))); //104
		registros.get(104).setHoraEntrada(LocalTime.of(9, 0)); registros.get(104).setHoraSalida(LocalTime.of(11, 0));
		registros.get(104).setFecha(LocalDate.of(2025, 6, 4));

		registros.add(new Registro(personal.get(13), locales.get(6))); //105
		registros.get(105).setHoraEntrada(LocalTime.of(11, 30)); registros.get(105).setHoraSalida(LocalTime.of(14, 0));
		registros.get(105).setFecha(LocalDate.of(2025, 6, 4));

		registros.add(new Registro(personal.get(33), locales.get(2))); //106
		registros.get(106).setHoraEntrada(LocalTime.of(8, 0)); registros.get(106).setHoraSalida(LocalTime.of(10, 0));
		registros.get(106).setFecha(LocalDate.of(2025, 6, 5));

		registros.add(new Registro(personal.get(21), locales.get(1))); //107
		registros.get(107).setHoraEntrada(LocalTime.of(10, 15)); registros.get(107).setHoraSalida(LocalTime.of(12, 0));
		registros.get(107).setFecha(LocalDate.of(2025, 6, 6));

		registros.add(new Registro(personal.get(29), locales.get(8))); //108
		registros.get(108).setHoraEntrada(LocalTime.of(13, 0)); registros.get(108).setHoraSalida(LocalTime.of(15, 0));
		registros.get(108).setFecha(LocalDate.of(2025, 6, 7));

		registros.add(new Registro(personal.get(35), locales.get(9))); //109
		registros.get(109).setHoraEntrada(LocalTime.of(8, 30)); registros.get(109).setHoraSalida(LocalTime.of(10, 30));
		registros.get(109).setFecha(LocalDate.of(2025, 6, 8));

		registros.add(new Registro(personal.get(35), locales.get(1))); //110
		registros.get(110).setHoraEntrada(LocalTime.of(11, 0)); registros.get(110).setHoraSalida(LocalTime.of(13, 0));
		registros.get(110).setFecha(LocalDate.of(2025, 6, 8));

		registros.add(new Registro(personal.get(45), locales.get(3))); //111
		registros.get(111).setHoraEntrada(LocalTime.of(14, 0)); registros.get(111).setHoraSalida(LocalTime.of(16, 0));
		registros.get(111).setFecha(LocalDate.of(2025, 6, 8));

		registros.add(new Registro(personal.get(21), locales.get(0))); //112
		registros.get(112).setHoraEntrada(LocalTime.of(8, 0)); registros.get(112).setHoraSalida(LocalTime.of(9, 45));
		registros.get(112).setFecha(LocalDate.of(2025, 6, 9));

		registros.add(new Registro(personal.get(37), locales.get(6))); //113
		registros.get(113).setHoraEntrada(LocalTime.of(10, 15)); registros.get(113).setHoraSalida(LocalTime.of(12, 30));
		registros.get(113).setFecha(LocalDate.of(2025, 6, 10));

		registros.add(new Registro(personal.get(29), locales.get(7))); //114
		registros.get(114).setHoraEntrada(LocalTime.of(8, 0)); registros.get(114).setHoraSalida(LocalTime.of(10, 0));
		registros.get(114).setFecha(LocalDate.of(2025, 6, 11));

		registros.add(new Registro(personal.get(0), locales.get(4))); //115
		registros.get(115).setHoraEntrada(LocalTime.of(10, 15)); registros.get(115).setHoraSalida(LocalTime.of(12, 15));
		registros.get(115).setFecha(LocalDate.now());

		registros.add(new Registro(personal.get(13), locales.get(5))); //116
		registros.get(116).setHoraEntrada(LocalTime.of(13, 0)); registros.get(116).setHoraSalida(LocalTime.of(15, 0));
		registros.get(116).setFecha(LocalDate.of(2025, 6, 12));

		// Continúa con 14 entradas más…

		registros.add(new Registro(personal.get(33), locales.get(2))); //117
		registros.get(117).setHoraEntrada(LocalTime.of(8, 0)); registros.get(117).setHoraSalida(LocalTime.of(10, 0));
		registros.get(117).setFecha(LocalDate.of(2025, 6, 13));

		registros.add(new Registro(personal.get(37), locales.get(1))); //118
		registros.get(118).setHoraEntrada(LocalTime.of(10, 15)); registros.get(118).setHoraSalida(LocalTime.of(12, 30));
		registros.get(118).setFecha(LocalDate.of(2025, 6, 13));

		registros.add(new Registro(personal.get(45), locales.get(7))); //119
		registros.get(119).setHoraEntrada(LocalTime.of(13, 0)); registros.get(119).setHoraSalida(LocalTime.of(15, 0));
		registros.get(119).setFecha(LocalDate.of(2025, 6, 13));

		registros.add(new Registro(personal.get(35), locales.get(5))); //120
		registros.get(120).setHoraEntrada(LocalTime.of(8, 0)); registros.get(120).setHoraSalida(LocalTime.of(9, 45));
		registros.get(120).setFecha(LocalDate.of(2025, 6, 14));

		registros.add(new Registro(personal.get(29), locales.get(3))); //121
		registros.get(121).setHoraEntrada(LocalTime.of(10, 15)); registros.get(121).setHoraSalida(LocalTime.of(12, 0));
		registros.get(121).setFecha(LocalDate.of(2025, 6, 14));

		registros.add(new Registro(personal.get(0), locales.get(1))); //122
		registros.get(122).setHoraEntrada(LocalTime.of(13, 0)); registros.get(122).setHoraSalida(LocalTime.of(15, 0));
		registros.get(122).setFecha(LocalDate.of(2025, 6, 14));

		registros.add(new Registro(personal.get(45), locales.get(2))); //123
		registros.get(123).setHoraEntrada(LocalTime.of(8, 0)); registros.get(123).setHoraSalida(LocalTime.of(10, 0));
		registros.get(123).setFecha(LocalDate.of(2025, 6, 15));

		registros.add(new Registro(personal.get(45), locales.get(4))); //124
		registros.get(124).setHoraEntrada(LocalTime.of(10, 30)); registros.get(124).setHoraSalida(LocalTime.of(12, 30));
		registros.get(124).setFecha(LocalDate.of(2025, 6, 15));

		registros.add(new Registro(personal.get(21), locales.get(6))); //125
		registros.get(125).setHoraEntrada(LocalTime.of(13, 0)); registros.get(125).setHoraSalida(LocalTime.of(15, 0));
		registros.get(125).setFecha(LocalDate.of(2025, 6, 15));

		registros.add(new Registro(personal.get(13), locales.get(8))); //126
		registros.get(126).setHoraEntrada(LocalTime.of(8, 0)); registros.get(126).setHoraSalida(LocalTime.of(10, 0));
		registros.get(126).setFecha(LocalDate.of(2025, 6, 16));
		
		registros.add(new Registro(personal.get(0), locales.get(1))); //127
		registros.get(127).setHoraEntrada(LocalTime.of(8, 0)); registros.get(127).setHoraSalida(LocalTime.of(10, 0));
		registros.get(127).setFecha(LocalDate.of(2025, 6, 3));

		registros.add(new Registro(personal.get(1), locales.get(4))); //128
		registros.get(128).setHoraEntrada(LocalTime.of(10, 30)); registros.get(128).setHoraSalida(LocalTime.of(12, 30));
		registros.get(128).setFecha(LocalDate.of(2025, 6, 4));

		registros.add(new Registro(personal.get(2), locales.get(9))); //129
		registros.get(129).setHoraEntrada(LocalTime.of(13, 0)); registros.get(129).setHoraSalida(LocalTime.of(15, 0));
		registros.get(129).setFecha(LocalDate.of(2025, 6, 5));

		registros.add(new Registro(personal.get(3), locales.get(3))); //130
		registros.get(130).setHoraEntrada(LocalTime.of(9, 0)); registros.get(130).setHoraSalida(LocalTime.of(11, 0));
		registros.get(130).setFecha(LocalDate.of(2025, 6, 6));

		registros.add(new Registro(personal.get(4), locales.get(5))); //131
		registros.get(131).setHoraEntrada(LocalTime.of(11, 15)); registros.get(131).setHoraSalida(LocalTime.of(13, 15));
		registros.get(131).setFecha(LocalDate.of(2025, 6, 7));

		registros.add(new Registro(personal.get(5), locales.get(2))); //132
		registros.get(132).setHoraEntrada(LocalTime.of(8, 0)); registros.get(132).setHoraSalida(LocalTime.of(9, 30));
		registros.get(132).setFecha(LocalDate.of(2025, 6, 8));

		registros.add(new Registro(personal.get(6), locales.get(0))); //133
		registros.get(133).setHoraEntrada(LocalTime.of(10, 0)); registros.get(133).setHoraSalida(LocalTime.of(12, 0));
		registros.get(133).setFecha(LocalDate.of(2025, 6, 9));

		registros.add(new Registro(personal.get(7), locales.get(4))); //134
		registros.get(134).setHoraEntrada(LocalTime.of(13, 0)); registros.get(134).setHoraSalida(LocalTime.of(15, 0));
		registros.get(134).setFecha(LocalDate.of(2025, 6, 10));

		registros.add(new Registro(personal.get(8), locales.get(8))); //135
		registros.get(135).setHoraEntrada(LocalTime.of(8, 30)); registros.get(135).setHoraSalida(LocalTime.of(10, 30));
		registros.get(135).setFecha(LocalDate.of(2025, 6, 11));

		registros.add(new Registro(personal.get(9), locales.get(1))); //136
		registros.get(136).setHoraEntrada(LocalTime.of(10, 45)); registros.get(136).setHoraSalida(LocalTime.of(13, 15));
		registros.get(136).setFecha(LocalDate.of(2025, 6, 12));

		registros.add(new Registro(personal.get(10), locales.get(7))); //137
		registros.get(137).setHoraEntrada(LocalTime.of(14, 0)); registros.get(137).setHoraSalida(LocalTime.of(16, 0));
		registros.get(137).setFecha(LocalDate.of(2025, 6, 13));

		registros.add(new Registro(personal.get(11), locales.get(0))); //138
		registros.get(138).setHoraEntrada(LocalTime.of(8, 0)); registros.get(138).setHoraSalida(LocalTime.of(10, 0));
		registros.get(138).setFecha(LocalDate.of(2025, 6, 14));

		registros.add(new Registro(personal.get(12), locales.get(6))); //139
		registros.get(139).setHoraEntrada(LocalTime.of(10, 30)); registros.get(139).setHoraSalida(LocalTime.of(12, 30));
		registros.get(139).setFecha(LocalDate.of(2025, 6, 14));

		registros.add(new Registro(personal.get(13), locales.get(5))); //140
		registros.get(140).setHoraEntrada(LocalTime.of(13, 0)); registros.get(140).setHoraSalida(LocalTime.of(15, 0));
		registros.get(140).setFecha(LocalDate.of(2025, 6, 14));

		registros.add(new Registro(personal.get(14), locales.get(2))); //141
		registros.get(141).setHoraEntrada(LocalTime.of(8, 0)); registros.get(141).setHoraSalida(LocalTime.of(10, 0));
		registros.get(141).setFecha(LocalDate.of(2025, 6, 15));

		// 15 registros más con combinaciones adicionales para esas mismas personas

		registros.add(new Registro(personal.get(0), locales.get(8))); //142
		registros.get(142).setHoraEntrada(LocalTime.of(11, 0)); registros.get(142).setHoraSalida(LocalTime.of(13, 0));
		registros.get(142).setFecha(LocalDate.of(2025, 6, 16));

		registros.add(new Registro(personal.get(1), locales.get(6))); //143
		registros.get(143).setHoraEntrada(LocalTime.of(13, 15)); registros.get(143).setHoraSalida(LocalTime.of(15, 0));
		registros.get(143).setFecha(LocalDate.of(2025, 6, 16));

		registros.add(new Registro(personal.get(2), locales.get(0))); //144
		registros.get(144).setHoraEntrada(LocalTime.of(8, 0)); registros.get(144).setHoraSalida(LocalTime.of(10, 0));
		registros.get(144).setFecha(LocalDate.of(2025, 6, 17));

		registros.add(new Registro(personal.get(3), locales.get(4))); //145
		registros.get(145).setHoraEntrada(LocalTime.of(10, 30)); registros.get(145).setHoraSalida(LocalTime.of(12, 30));
		registros.get(145).setFecha(LocalDate.of(2025, 6, 17));

		registros.add(new Registro(personal.get(4), locales.get(2))); //146
		registros.get(146).setHoraEntrada(LocalTime.of(13, 0)); registros.get(146).setHoraSalida(LocalTime.of(15, 0));
		registros.get(146).setFecha(LocalDate.of(2025, 6, 17));

		registros.add(new Registro(personal.get(5), locales.get(9))); //147
		registros.get(147).setHoraEntrada(LocalTime.of(8, 0)); registros.get(147).setHoraSalida(LocalTime.of(9, 45));
		registros.get(147).setFecha(LocalDate.of(2025, 6, 18));

		registros.add(new Registro(personal.get(6), locales.get(2))); //148
		registros.get(148).setHoraEntrada(LocalTime.of(10, 15)); registros.get(148).setHoraSalida(LocalTime.of(12, 0));
		registros.get(148).setFecha(LocalDate.of(2025, 6, 18));

		registros.add(new Registro(personal.get(7), locales.get(1))); //149
		registros.get(149).setHoraEntrada(LocalTime.of(13, 0)); registros.get(149).setHoraSalida(LocalTime.of(15, 0));
		registros.get(149).setFecha(LocalDate.of(2025, 6, 18));

		registros.add(new Registro(personal.get(8), locales.get(9))); //150
		registros.get(150).setHoraEntrada(LocalTime.of(8, 30)); registros.get(150).setHoraSalida(LocalTime.of(10, 30));
		registros.get(150).setFecha(LocalDate.of(2025, 6, 20));

		registros.add(new Registro(personal.get(9), locales.get(5))); //151
		registros.get(151).setHoraEntrada(LocalTime.of(10, 30)); registros.get(151).setHoraSalida(LocalTime.of(12, 15));
		registros.get(151).setFecha(LocalDate.of(2025, 6, 20));
		
		registros.add(new Registro(personal.get(43), locales.get(5))); //151
		registros.get(152).setHoraEntrada(LocalTime.of(10, 30)); registros.get(152).setHoraSalida(LocalTime.of(12, 15));
		registros.get(152).setFecha(LocalDate.of(2025, 6, 20));
		
		
		//Nicole Rios
		registros.add(new Registro(personal.get(1), locales.get(0))); //153
		registros.get(153).setHoraEntrada(LocalTime.of(8, 0)); registros.get(153).setHoraSalida(LocalTime.of(9, 30));
		registros.get(153).setFecha(LocalDate.of(2025, 6, 6));

		registros.add(new Registro(personal.get(1), locales.get(2))); //154
		registros.get(154).setHoraEntrada(LocalTime.of(10, 0)); registros.get(154).setHoraSalida(LocalTime.of(11, 30));
		registros.get(154).setFecha(LocalDate.of(2025, 6, 6));

		registros.add(new Registro(personal.get(1), locales.get(5))); //155
		registros.get(155).setHoraEntrada(LocalTime.of(13, 0)); registros.get(155).setHoraSalida(LocalTime.of(15, 0));
		registros.get(155).setFecha(LocalDate.of(2025, 6, 6));
		
		registros.add(new Registro(personal.get(3), locales.get(9))); //156
		registros.get(156).setHoraEntrada(LocalTime.of(8, 30)); registros.get(156).setHoraSalida(LocalTime.of(10, 30));
		registros.get(156).setFecha(LocalDate.of(2025, 6, 8));

		registros.add(new Registro(personal.get(3), locales.get(3))); //157
		registros.get(157).setHoraEntrada(LocalTime.of(11, 15)); registros.get(157).setHoraSalida(LocalTime.of(13, 30));
		registros.get(157).setFecha(LocalDate.of(2025, 6, 8));

		registros.add(new Registro(personal.get(0), locales.get(1))); //158
		registros.get(158).setHoraEntrada(LocalTime.of(8, 0)); registros.get(158).setHoraSalida(LocalTime.of(9, 0));
		registros.get(158).setFecha(LocalDate.of(2025, 6, 10));

		registros.add(new Registro(personal.get(0), locales.get(4))); //159
		registros.get(159).setHoraEntrada(LocalTime.of(9, 15)); registros.get(159).setHoraSalida(LocalTime.of(10, 45));
		registros.get(159).setFecha(LocalDate.of(2025, 6, 10));

		registros.add(new Registro(personal.get(0), locales.get(6))); //160
		registros.get(160).setHoraEntrada(LocalTime.of(11, 30)); registros.get(160).setHoraSalida(LocalTime.of(13, 0));
		registros.get(160).setFecha(LocalDate.of(2025, 6, 10));

		registros.add(new Registro(personal.get(0), locales.get(8))); //161
		registros.get(161).setHoraEntrada(LocalTime.of(14, 0)); registros.get(161).setHoraSalida(LocalTime.of(15, 30));
		registros.get(161).setFecha(LocalDate.of(2025, 6, 10));

		registros.add(new Registro(personal.get(10), locales.get(3))); //151
		registros.get(162).setHoraEntrada(LocalTime.of(10, 30)); registros.get(162).setHoraSalida(LocalTime.of(12, 15));
		registros.get(162).setFecha(LocalDate.of(2025, 6, 20));
		
		registros.add(new Registro(personal.get(43), locales.get(0))); //163
		registros.get(163).setHoraEntrada(LocalTime.of(8, 0)); registros.get(163).setHoraSalida(LocalTime.of(9, 30));
		registros.get(163).setFecha(LocalDate.of(2025, 6, 1));

		registros.add(new Registro(personal.get(43), locales.get(1))); //164
		registros.get(164).setHoraEntrada(LocalTime.of(10, 0)); registros.get(164).setHoraSalida(LocalTime.of(11, 30));
		registros.get(164).setFecha(LocalDate.of(2025, 6, 2));

		registros.add(new Registro(personal.get(43), locales.get(2))); //165
		registros.get(165).setHoraEntrada(LocalTime.of(13, 0)); registros.get(165).setHoraSalida(LocalTime.of(15, 0));
		registros.get(165).setFecha(LocalDate.of(2025, 6, 2));

		registros.add(new Registro(personal.get(43), locales.get(3))); //166
		registros.get(166).setHoraEntrada(LocalTime.of(8, 30)); registros.get(166).setHoraSalida(LocalTime.of(10, 30));
		registros.get(166).setFecha(LocalDate.of(2025, 6, 4));

		registros.add(new Registro(personal.get(43), locales.get(4))); //167
		registros.get(167).setHoraEntrada(LocalTime.of(11, 0)); registros.get(167).setHoraSalida(LocalTime.of(13, 0));
		registros.get(167).setFecha(LocalDate.of(2025, 6, 5));

		registros.add(new Registro(personal.get(43), locales.get(5))); //168
		registros.get(168).setHoraEntrada(LocalTime.of(13, 15)); registros.get(168).setHoraSalida(LocalTime.of(15, 0));
		registros.get(168).setFecha(LocalDate.of(2025, 6, 6));

		registros.add(new Registro(personal.get(43), locales.get(6))); //169
		registros.get(169).setHoraEntrada(LocalTime.of(8, 0)); registros.get(169).setHoraSalida(LocalTime.of(10, 0));
		registros.get(169).setFecha(LocalDate.of(2025, 6, 7));

		registros.add(new Registro(personal.get(43), locales.get(7))); //170
		registros.get(170).setHoraEntrada(LocalTime.of(10, 30)); registros.get(170).setHoraSalida(LocalTime.of(12, 30));
		registros.get(170).setFecha(LocalDate.of(2025, 6, 8));

		registros.add(new Registro(personal.get(43), locales.get(8))); //171
		registros.get(171).setHoraEntrada(LocalTime.of(13, 0)); registros.get(171).setHoraSalida(LocalTime.of(14, 30));
		registros.get(171).setFecha(LocalDate.of(2025, 6, 9));

		registros.add(new Registro(personal.get(43), locales.get(9))); //172
		registros.get(172).setHoraEntrada(LocalTime.of(8, 0)); registros.get(172).setHoraSalida(LocalTime.of(9, 45));
		registros.get(172).setFecha(LocalDate.of(2025, 6, 10));

		registros.add(new Registro(personal.get(43), locales.get(0))); //173
		registros.get(173).setHoraEntrada(LocalTime.of(10, 0)); registros.get(173).setHoraSalida(LocalTime.of(11, 30));
		registros.get(173).setFecha(LocalDate.of(2025, 6, 11));

		registros.add(new Registro(personal.get(43), locales.get(1))); //174
		registros.get(174).setHoraEntrada(LocalTime.of(13, 0)); registros.get(174).setHoraSalida(LocalTime.of(15, 0));
		registros.get(174).setFecha(LocalDate.of(2025, 6, 12));

		registros.add(new Registro(personal.get(43), locales.get(2))); //175
		registros.get(175).setHoraEntrada(LocalTime.of(8, 0)); registros.get(175).setHoraSalida(LocalTime.of(9, 30));
		registros.get(175).setFecha(LocalDate.of(2025, 6, 13));

		registros.add(new Registro(personal.get(43), locales.get(3))); //176
		registros.get(176).setHoraEntrada(LocalTime.of(9, 45)); registros.get(176).setHoraSalida(LocalTime.of(11, 15));
		registros.get(176).setFecha(LocalDate.of(2025, 6, 13));

		registros.add(new Registro(personal.get(43), locales.get(4))); //177
		registros.get(177).setHoraEntrada(LocalTime.of(13, 0)); registros.get(177).setHoraSalida(LocalTime.of(15, 0));
		registros.get(177).setFecha(LocalDate.of(2025, 6, 14));

		registros.add(new Registro(personal.get(43), locales.get(5))); //178
		registros.get(178).setHoraEntrada(LocalTime.of(8, 0)); registros.get(178).setHoraSalida(LocalTime.of(9, 45));
		registros.get(178).setFecha(LocalDate.of(2025, 6, 15));

		registros.add(new Registro(personal.get(43), locales.get(6))); //179
		registros.get(179).setHoraEntrada(LocalTime.of(10, 15)); registros.get(179).setHoraSalida(LocalTime.of(12, 15));
		registros.get(179).setFecha(LocalDate.of(2025, 6, 15));

		registros.add(new Registro(personal.get(43), locales.get(7))); //180
		registros.get(180).setHoraEntrada(LocalTime.of(13, 0)); registros.get(180).setHoraSalida(LocalTime.of(15, 0));
		registros.get(180).setFecha(LocalDate.of(2025, 6, 15));

		registros.add(new Registro(personal.get(43), locales.get(8))); //181
		registros.get(181).setHoraEntrada(LocalTime.of(8, 0)); registros.get(181).setHoraSalida(LocalTime.of(10, 0));
		registros.get(181).setFecha(LocalDate.of(2025, 6, 17));

		registros.add(new Registro(personal.get(43), locales.get(9))); //182
		registros.get(182).setHoraEntrada(LocalTime.of(10, 30)); registros.get(182).setHoraSalida(LocalTime.of(12, 30));
		registros.get(182).setFecha(LocalDate.of(2025, 6, 17));

		registros.add(new Registro(personal.get(43), locales.get(5))); //183
		registros.get(183).setHoraEntrada(LocalTime.of(8, 30)); registros.get(183).setHoraSalida(LocalTime.of(10, 30));
		registros.get(183).setFecha(LocalDate.of(2025, 6, 19));

		registros.add(new Registro(personal.get(43), locales.get(6))); //184
		registros.get(184).setHoraEntrada(LocalTime.of(11, 0)); registros.get(184).setHoraSalida(LocalTime.of(13, 0));
		registros.get(184).setFecha(LocalDate.of(2025, 6, 20));

		registros.add(new Registro(personal.get(43), locales.get(0))); //185
		registros.get(185).setHoraEntrada(LocalTime.of(13, 30)); registros.get(185).setHoraSalida(LocalTime.of(15, 30));
		registros.get(185).setFecha(LocalDate.of(2025, 6, 22));
		
		registros.add(new Registro(personal.get(1), locales.get(0))); //186
		registros.get(186).setHoraEntrada(LocalTime.of(8, 0)); registros.get(186).setHoraSalida(LocalTime.of(10, 0));
		registros.get(186).setFecha(LocalDate.of(2025, 6, 3));

		registros.add(new Registro(personal.get(5), locales.get(0))); //187
		registros.get(187).setHoraEntrada(LocalTime.of(10, 30)); registros.get(187).setHoraSalida(LocalTime.of(12, 30));
		registros.get(187).setFecha(LocalDate.of(2025, 6, 5));

		registros.add(new Registro(personal.get(7), locales.get(0))); //188
		registros.get(188).setHoraEntrada(LocalTime.of(13, 0)); registros.get(188).setHoraSalida(LocalTime.of(15, 0));
		registros.get(188).setFecha(LocalDate.of(2025, 6, 5));

		registros.add(new Registro(personal.get(10), locales.get(0))); //189
		registros.get(189).setHoraEntrada(LocalTime.of(8, 0)); registros.get(189).setHoraSalida(LocalTime.of(9, 30));
		registros.get(189).setFecha(LocalDate.of(2025, 6, 7));

		registros.add(new Registro(personal.get(11), locales.get(0))); //190
		registros.get(190).setHoraEntrada(LocalTime.of(10, 0)); registros.get(190).setHoraSalida(LocalTime.of(12, 0));
		registros.get(190).setFecha(LocalDate.of(2025, 6, 8));

		registros.add(new Registro(personal.get(13), locales.get(0))); //191
		registros.get(191).setHoraEntrada(LocalTime.of(13, 0)); registros.get(191).setHoraSalida(LocalTime.of(15, 0));
		registros.get(191).setFecha(LocalDate.of(2025, 6, 9));

		registros.add(new Registro(personal.get(18), locales.get(0))); //192
		registros.get(192).setHoraEntrada(LocalTime.of(8, 0)); registros.get(192).setHoraSalida(LocalTime.of(10, 0));
		registros.get(192).setFecha(LocalDate.of(2025, 6, 11));

		registros.add(new Registro(personal.get(19), locales.get(0))); //193
		registros.get(193).setHoraEntrada(LocalTime.of(10, 15)); registros.get(193).setHoraSalida(LocalTime.of(12, 15));
		registros.get(193).setFecha(LocalDate.of(2025, 6, 12));

		registros.add(new Registro(personal.get(23), locales.get(0))); //194
		registros.get(194).setHoraEntrada(LocalTime.of(13, 0)); registros.get(194).setHoraSalida(LocalTime.of(15, 0));
		registros.get(194).setFecha(LocalDate.of(2025, 6, 13));

		registros.add(new Registro(personal.get(33), locales.get(0))); //195
		registros.get(195).setHoraEntrada(LocalTime.of(8, 0)); registros.get(195).setHoraSalida(LocalTime.of(10, 0));
		registros.get(195).setFecha(LocalDate.of(2025, 6, 14));

		registros.add(new Registro(personal.get(21), locales.get(0))); //196
		registros.get(196).setHoraEntrada(LocalTime.of(10, 0)); registros.get(196).setHoraSalida(LocalTime.of(12, 0));
		registros.get(196).setFecha(LocalDate.of(2025, 6, 4));

		registros.add(new Registro(personal.get(24), locales.get(0))); //197
		registros.get(197).setHoraEntrada(LocalTime.of(13, 0)); registros.get(197).setHoraSalida(LocalTime.of(15, 0));
		registros.get(197).setFecha(LocalDate.of(2025, 6, 6));

		registros.add(new Registro(personal.get(29), locales.get(0))); //198
		registros.get(198).setHoraEntrada(LocalTime.of(8, 0)); registros.get(198).setHoraSalida(LocalTime.of(9, 30));
		registros.get(198).setFecha(LocalDate.of(2025, 6, 8));

		registros.add(new Registro(personal.get(30), locales.get(0))); //199
		registros.get(199).setHoraEntrada(LocalTime.of(10, 30)); registros.get(199).setHoraSalida(LocalTime.of(12, 30));
		registros.get(199).setFecha(LocalDate.of(2025, 6, 9));

		registros.add(new Registro(personal.get(32), locales.get(0))); //200
		registros.get(200).setHoraEntrada(LocalTime.of(13, 0)); registros.get(200).setHoraSalida(LocalTime.of(15, 0));
		registros.get(200).setFecha(LocalDate.of(2025, 6, 11));

		registros.add(new Registro(personal.get(33), locales.get(0))); //201
		registros.get(201).setHoraEntrada(LocalTime.of(9, 0)); registros.get(201).setHoraSalida(LocalTime.of(11, 0));
		registros.get(201).setFecha(LocalDate.of(2025, 6, 13));

		registros.add(new Registro(personal.get(34), locales.get(0))); //202
		registros.get(202).setHoraEntrada(LocalTime.of(11, 15)); registros.get(202).setHoraSalida(LocalTime.of(13, 15));
		registros.get(202).setFecha(LocalDate.of(2025, 6, 14));

		registros.add(new Registro(personal.get(35), locales.get(0))); //203
		registros.get(203).setHoraEntrada(LocalTime.of(13, 30)); registros.get(203).setHoraSalida(LocalTime.of(15, 30));
		registros.get(203).setFecha(LocalDate.of(2025, 6, 16));

		registros.add(new Registro(personal.get(41), locales.get(0))); //204
		registros.get(204).setHoraEntrada(LocalTime.of(8, 0)); registros.get(204).setHoraSalida(LocalTime.of(10, 0));
		registros.get(204).setFecha(LocalDate.of(2025, 6, 18));

		registros.add(new Registro(personal.get(44), locales.get(0))); //205
		registros.get(205).setHoraEntrada(LocalTime.of(10, 30)); registros.get(205).setHoraSalida(LocalTime.of(12, 30));
		registros.get(205).setFecha(LocalDate.of(2025, 6, 20));

		registros.add(new Registro(personal.get(21), locales.get(0))); //196
		registros.get(196).setHoraEntrada(LocalTime.of(10, 0)); registros.get(196).setHoraSalida(LocalTime.of(12, 0));
		registros.get(196).setFecha(LocalDate.of(2025, 6, 4));

		registros.add(new Registro(personal.get(24), locales.get(0))); //197
		registros.get(197).setHoraEntrada(LocalTime.of(13, 0)); registros.get(197).setHoraSalida(LocalTime.of(15, 0));
		registros.get(197).setFecha(LocalDate.of(2025, 6, 6));

		registros.add(new Registro(personal.get(29), locales.get(0))); //198
		registros.get(198).setHoraEntrada(LocalTime.of(8, 0)); registros.get(198).setHoraSalida(LocalTime.of(9, 30));
		registros.get(198).setFecha(LocalDate.of(2025, 6, 8));

		registros.add(new Registro(personal.get(30), locales.get(0))); //199
		registros.get(199).setHoraEntrada(LocalTime.of(10, 30)); registros.get(199).setHoraSalida(LocalTime.of(12, 30));
		registros.get(199).setFecha(LocalDate.of(2025, 6, 9));

		registros.add(new Registro(personal.get(32), locales.get(0))); //200
		registros.get(200).setHoraEntrada(LocalTime.of(13, 0)); registros.get(200).setHoraSalida(LocalTime.of(15, 0));
		registros.get(200).setFecha(LocalDate.of(2025, 6, 11));

		registros.add(new Registro(personal.get(33), locales.get(0))); //201
		registros.get(201).setHoraEntrada(LocalTime.of(9, 0)); registros.get(201).setHoraSalida(LocalTime.of(11, 0));
		registros.get(201).setFecha(LocalDate.of(2025, 6, 13));

		registros.add(new Registro(personal.get(34), locales.get(0))); //202
		registros.get(202).setHoraEntrada(LocalTime.of(11, 15)); registros.get(202).setHoraSalida(LocalTime.of(13, 15));
		registros.get(202).setFecha(LocalDate.of(2025, 6, 14));

		registros.add(new Registro(personal.get(35), locales.get(0))); //203
		registros.get(203).setHoraEntrada(LocalTime.of(13, 30)); registros.get(203).setHoraSalida(LocalTime.of(15, 30));
		registros.get(203).setFecha(LocalDate.of(2025, 6, 16));

		registros.add(new Registro(personal.get(41), locales.get(0))); //204
		registros.get(204).setHoraEntrada(LocalTime.of(8, 0)); registros.get(204).setHoraSalida(LocalTime.of(10, 0));
		registros.get(204).setFecha(LocalDate.of(2025, 6, 18));

		registros.add(new Registro(personal.get(44), locales.get(0))); //205
		registros.get(205).setHoraEntrada(LocalTime.of(10, 30)); registros.get(205).setHoraSalida(LocalTime.of(12, 30));
		registros.get(205).setFecha(LocalDate.of(2025, 6, 20));

		registros.add(new Registro(personal.get(16), locales.get(1))); //209
		registros.get(209).setHoraEntrada(LocalTime.of(8, 0)); registros.get(209).setHoraSalida(LocalTime.of(10, 0));
		registros.get(209).setFecha(LocalDate.of(2025, 6, 4));

		registros.add(new Registro(personal.get(25), locales.get(1))); //210
		registros.get(210).setHoraEntrada(LocalTime.of(10, 30)); registros.get(210).setHoraSalida(LocalTime.of(12, 30));
		registros.get(210).setFecha(LocalDate.of(2025, 6, 6));

		registros.add(new Registro(personal.get(48), locales.get(1))); //211
		registros.get(211).setHoraEntrada(LocalTime.of(13, 0)); registros.get(211).setHoraSalida(LocalTime.of(15, 0));
		registros.get(211).setFecha(LocalDate.of(2025, 6, 11));

		registros.add(new Registro(personal.get(2), locales.get(2))); //212
		registros.get(212).setHoraEntrada(LocalTime.of(8, 0)); registros.get(212).setHoraSalida(LocalTime.of(9, 30));
		registros.get(212).setFecha(LocalDate.of(2025, 6, 5));

		registros.add(new Registro(personal.get(16), locales.get(2))); //213
		registros.get(213).setHoraEntrada(LocalTime.of(10, 0)); registros.get(213).setHoraSalida(LocalTime.of(12, 0));
		registros.get(213).setFecha(LocalDate.of(2025, 6, 8));

		registros.add(new Registro(personal.get(25), locales.get(2))); //214
		registros.get(214).setHoraEntrada(LocalTime.of(13, 0)); registros.get(214).setHoraSalida(LocalTime.of(15, 0));
		registros.get(214).setFecha(LocalDate.of(2025, 6, 12));

		registros.add(new Registro(personal.get(2), locales.get(2))); //214
		registros.get(215).setHoraEntrada(LocalTime.of(13, 0)); registros.get(215).setHoraSalida(LocalTime.of(15, 0));
		registros.get(215).setFecha(LocalDate.of(2025, 6, 12));
		
		registros.add(new Registro(personal.get(1), locales.get(2))); //216
		registros.get(216).setHoraEntrada(LocalTime.of(8, 0)); registros.get(216).setHoraSalida(LocalTime.of(10, 0));
		registros.get(216).setFecha(LocalDate.of(2025, 6, 2));

		registros.add(new Registro(personal.get(5), locales.get(2))); //217
		registros.get(217).setHoraEntrada(LocalTime.of(10, 30)); registros.get(217).setHoraSalida(LocalTime.of(12, 30));
		registros.get(217).setFecha(LocalDate.of(2025, 6, 3));

		registros.add(new Registro(personal.get(10), locales.get(2))); //218
		registros.get(218).setHoraEntrada(LocalTime.of(13, 0)); registros.get(218).setHoraSalida(LocalTime.of(15, 0));
		registros.get(218).setFecha(LocalDate.of(2025, 6, 4));

		registros.add(new Registro(personal.get(24), locales.get(2))); //219
		registros.get(219).setHoraEntrada(LocalTime.of(8, 0)); registros.get(219).setHoraSalida(LocalTime.of(10, 0));
		registros.get(219).setFecha(LocalDate.of(2025, 6, 6));

		registros.add(new Registro(personal.get(26), locales.get(2))); //220
		registros.get(220).setHoraEntrada(LocalTime.of(10, 15)); registros.get(220).setHoraSalida(LocalTime.of(12, 15));
		registros.get(220).setFecha(LocalDate.of(2025, 6, 8));

		registros.add(new Registro(personal.get(29), locales.get(2))); //221
		registros.get(221).setHoraEntrada(LocalTime.of(13, 0)); registros.get(221).setHoraSalida(LocalTime.of(15, 0));
		registros.get(221).setFecha(LocalDate.of(2025, 6, 10));

		registros.add(new Registro(personal.get(30), locales.get(2))); //222
		registros.get(222).setHoraEntrada(LocalTime.of(8, 0)); registros.get(222).setHoraSalida(LocalTime.of(10, 0));
		registros.get(222).setFecha(LocalDate.of(2025, 6, 11));

		registros.add(new Registro(personal.get(33), locales.get(2))); //223
		registros.get(223).setHoraEntrada(LocalTime.of(10, 30)); registros.get(223).setHoraSalida(LocalTime.of(12, 30));
		registros.get(223).setFecha(LocalDate.of(2025, 6, 13));

		registros.add(new Registro(personal.get(41), locales.get(2))); //224
		registros.get(224).setHoraEntrada(LocalTime.of(13, 0)); registros.get(224).setHoraSalida(LocalTime.of(15, 0));
		registros.get(224).setFecha(LocalDate.of(2025, 6, 14));

		registros.add(new Registro(personal.get(44), locales.get(2))); //225
		registros.get(225).setHoraEntrada(LocalTime.of(8, 0)); registros.get(225).setHoraSalida(LocalTime.of(10, 0));
		registros.get(225).setFecha(LocalDate.of(2025, 6, 17));
		
		registros.add(new Registro(new Visitante("Sofia Vargas", "03123164370"," Decanato", "Registro de inicio",personal.get(25)), locales.get(1))); //225
		registros.get(225).setHoraEntrada(LocalTime.of(8, 0)); registros.get(225).setHoraSalida(LocalTime.of(10, 0));
		registros.get(225).setFecha(LocalDate.of(2025, 6, 17));
		
		registros.add(new Registro(new Visitante("Ernesto Ramon Perez", "00103164380"," Laboratorio", "Revisar conexiones",personal.get(2)), locales.get(2))); //225
		registros.get(225).setHoraEntrada(LocalTime.of(8, 0)); registros.get(225).setHoraSalida(LocalTime.of(10, 0));
		registros.get(225).setFecha(LocalDate.now());
		
		
		registros.add(new Registro(new Visitante("Javier Rios", "01102464390"," Decanato", "Revisar conexiones",personal.get(2)), locales.get(1))); //225
		registros.get(225).setHoraEntrada(LocalTime.of(8, 0)); registros.get(225).setHoraSalida(LocalTime.of(10, 0));
		registros.get(225).setFecha(LocalDate.now());
		
		registros.add(new Registro(new Visitante("Caridad Bacallao", "88102444390"," Decanato", "Revisar conexiones",personal.get(2)), locales.get(1))); //225
		registros.get(225).setHoraEntrada(LocalTime.of(8, 0)); registros.get(225).setHoraSalida(LocalTime.of(10, 0));
		registros.get(225).setFecha(LocalDate.of(2025,5,28));
		
		
		registros.add(new Registro(new Visitante("Stefannie Berdut", "06061964390"," Decanato", "Revisar conexiones",personal.get(2)), locales.get(1))); //225
		registros.get(225).setHoraEntrada(LocalTime.of(8, 0)); registros.get(225).setHoraSalida(LocalTime.of(10, 0));
		registros.get(225).setFecha(LocalDate.now());
		
		registros.add(new Registro(new Visitante("Fabiola Luis", "06042864390"," Decanato", "Revisar conexiones",personal.get(2)), locales.get(4))); //225
		registros.get(225).setHoraEntrada(LocalTime.of(8, 0)); registros.get(225).setHoraSalida(LocalTime.of(10, 0));
		registros.get(225).setFecha(LocalDate.of(2025,6,17));
		
		
		
		
		
		
		
		
	}

}
