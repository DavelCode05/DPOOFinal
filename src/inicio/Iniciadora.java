package inicio;
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
import acceso.Registro;
import enums.AreaDirectivo;
import enums.CargoDirectivo;
import enums.Plaza;
import enums.TipoContrato;
import enums.TipoLocal;
import controllerClass.Facultad;

public class Iniciadora {
	
	public static void iniciar(){
		ArrayList<Persona> personal = Facultad.getFacultad().getPersonal();
		ArrayList<Local> locales = Facultad.getFacultad().getLocales();
		ArrayList<Registro> registros = Facultad.getFacultad().getVisitas();
		
		
		personal.add(new Administrativo("Aniel Vazquez", "05061368789", Plaza.Secretaria));
		personal.add(new Directivo("Lorena Perez", "95040468971", "Recursos Humanos", "Profesor","Doctor", TipoContrato.Determinado, CargoDirectivo.Decano, AreaDirectivo.Decanato));
		personal.add(new Estudiante("Nicole Rios", "06040468470",1, 13 ));
		personal.add(new Especialista("Josefina Rodriguez", "00042067847","GGGGG" ));
		personal.add(new Profesor("ALberto Fernandez", "87061669042", " DPOO", "mmm", "Máster", TipoContrato.Determinado));
		personal.add(new Tecnico("Erick Valdez", "06040468475","jjj"));
		personal.add(new Directivo("Patricia Toro", "06040468476", "Recursos Humanos", "mmm","Doctor", TipoContrato.Determinado, CargoDirectivo.Vicedecano, AreaDirectivo.Vicedecanato));
		personal.add(new Tecnico("Antonio Falcon", "06040468477","ddd"));
		personal.add(new Estudiante("Alvaro Tamayo Portela", "05040766544",1, 12 ));
		personal.add(new Profesor("Jacinto Reina", "06040468479", " Matematica", "mmm", "Doctor", TipoContrato.Determinado));
		//Estudiantes
		personal.add(new Estudiante("Aleksander Castañeda", "03110367040",1, 12 )); //10
		personal.add(new Estudiante("Dariel Velazco Falcón", "05060167362",1, 12 )); //11
		personal.add(new Estudiante("Brian Monteagudo Pérez", "05072967281",1, 12 )); //12
		personal.add(new Estudiante("Alexandro Valdés Piñeda", "05091568088",1, 12 )); //13
		personal.add(new Estudiante("Gloria Santos Rosado", "06030867876",1, 12 )); //14
		personal.add(new Estudiante("Javier David Coroas", "01061267208",1, 12 )); //15
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



		locales.add(new Local("INF-EST4", TipoLocal.Estudiantes, personal.get(1)));
		locales.add(new Local("INF-DEC", TipoLocal.Decano, personal.get(1) ));
		locales.add(new Local("INF-LAB3", TipoLocal.Laboratorio, personal.get(4) ));
		locales.add(new Local("INF-ESP08", TipoLocal.Especialistas, personal.get(3) ));
		locales.add(new Local("INF-ADMIN76", TipoLocal.Area_Administrativa, personal.get(0) ));
		locales.add(new Local("INF-JEFD3", TipoLocal.Jefe_Departamento, personal.get(4) ));
		locales.add(new Local("INF-VICD09", TipoLocal.Vicedecano, personal.get(6) ));
		locales.add(new Local("INF-SERVIDORES98", TipoLocal.Servidores, personal.get(4) ));
		locales.add(new Local("INF-AULA2", TipoLocal.Aula, personal.get(9) ));
		locales.add(new Local("INF-PROF25", TipoLocal.Profesores, personal.get(9) ));

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
//		registros.get(11).setHoraSalida(LocalTime.of(15, 0));
		registros.get(12).setHoraEntrada(LocalTime.of(15,0));
//		registros.get(12).setHoraSalida(LocalTime.of(16, 0));
		registros.get(13).setHoraEntrada(LocalTime.of(8,0));
//		registros.get(13).setHoraSalida(LocalTime.of(12, 0));
		registros.get(14).setHoraEntrada(LocalTime.of(11,0));
//		registros.get(14).setHoraSalida(LocalTime.of(14, 0));
		
		
		
		
	}

}
