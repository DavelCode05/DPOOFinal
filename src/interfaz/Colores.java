package interfaz;

import java.awt.Color;

public class Colores {
	private static final Color negro = new Color(13,13,13);
	private static final Color azulOscuro = new Color(3,29,64);
	private static final Color azulCielo = new Color(102, 128, 141);
	private static final Color azulVerdoso = new Color(63, 82, 89);
	private static final Color blancuzo = new Color(218,218,218);
	private static final Color rojoError = new Color(204, 0, 0);
	private static final Color colorLogin = new Color(200, 213, 219);
	
	public static Color getLogin()
	{
		return colorLogin;
	}
	public static Color getRojo(){
		return rojoError;
	}
	
	public static Color getNegro() {
		return negro;
	}

	public static Color getAzulOScuro() {
		return azulOscuro;
	}

	public static Color getAzulCielo() {
		return azulCielo;
	}

	public static Color getBlancuzo() {
		return blancuzo;
	}

	public static Color getAzulVerdoso() {
		return azulVerdoso;
	}
}
