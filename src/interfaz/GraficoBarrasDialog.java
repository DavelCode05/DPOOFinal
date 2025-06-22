package interfaz;
import javax.swing.*;

import controllerClass.Facultad;

import java.awt.*;
import java.awt.font.TextAttribute;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.text.AttributedString;
import java.time.LocalDate;
import java.util.ArrayList;

import locales.Local;

public class GraficoBarrasDialog extends JPanel {
	private int[] datos;
	private String [] locales;


	public GraficoBarrasDialog(  int[] datos, JDialog padre, String [] locales, JPanel ubic) {
		// Constructor sin parent, crea un JDialog independiente
	//	super(padre, "Gráfico de Barras", false);
		this.datos = datos;
		this.locales = locales;
		
		//setUndecorated(true);


	//	setBounds(ubic.getX(), ubic.getY(), 400+60, 350);

	//	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//	setSize(700, 500);


	//	add(panel);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		setSize(646, 433);
		dibujarGrafico(g);
	}

	private void dibujarGrafico(Graphics g) {
		if (datos == null || datos.length == 0) return;

		Graphics2D g2d = (Graphics2D) g;
		int anchoPanel = getWidth();
		int altoPanel = getHeight();
		int margenizq = 35;
		int margenDer=30;
		int margenSup=80;
		int margenInf = 80;

		// Encontrar el valor máximo para escalar
		int max = encontrarMaximo(datos);

		// Configurar colores y fuentes
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		//        g2d.setColor(new Color(70, 130, 180)); // SteelBlue



		// Dibujar fondo blanco
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, anchoPanel, altoPanel);

		// Dibujar título
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font("Arial", Font.ITALIC, 16));
		
		g2d.drawString(locales==null ? "Entradas por Hora":"Entradas por Locales" , anchoPanel/2-70, margenSup-50);
	

		// dibujar eje y
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font("Arial", Font.PLAIN,12));

		// dibujar linea eje y
		g2d.drawLine(margenizq, margenSup, margenizq, altoPanel-margenInf);

		//etiqueta
		g2d.setFont( new Font("Arial", Font.ITALIC,12));
		String etiq2 = "Cantidad de entradas";
		int anchoEtiq2= g2d.getFontMetrics().stringWidth(etiq2);
		g2d.drawString(etiq2, anchoPanel/2-anchoEtiq2/2-165, altoPanel-margenInf/2-245);

		// rotar la linea

		//        AffineTransform at = new AffineTransform();
		//        at.rotate(Math.toRadians(-90),0,0);
		//        g2d.setTransform(at);
		//        g2d.drawString(as.getIterator(), -altoPanel/2, margenizq-40);

		// dibujar valores y marcas

		int marcasY = 5 ;
		for( int i = 0; i<= marcasY; i++){
			int y = altoPanel - margenInf -(i*(altoPanel-margenSup-margenInf)/ marcasY);
			//			g2d.setColor(Color.LIGHT_GRAY);
			//			g2d.drawLine(margenizq, y, anchoPanel-margenDer, y);

			//		    g2d.setColor(Color.BLACK);
			//			String valor= String.valueOf((max*i)/ marcasY);
			//			int ancho1= g2d.getFontMetrics().stringWidth(valor);
			//			g2d.drawString(valor, margenizq-ancho1-5, y+5);

		}

		g2d.drawLine(margenizq, altoPanel-margenInf, anchoPanel-margenDer, altoPanel-margenInf);
		g2d.setFont( new Font("Arial", Font.ITALIC,12));
		String etiq = "Rango de horario";
		int anchoEtiq= g2d.getFontMetrics().stringWidth(etiq);
		g2d.drawString(etiq, anchoPanel/2-anchoEtiq/2+180, altoPanel-margenInf/2-5);

		// Calcular dimensiones de las barras
		int numBarras = datos.length;
		int anchoBarra = anchoPanel / (datos.length * 2);
		int espacio = anchoBarra / 2;



		g2d.setFont(new Font("Arial", Font.PLAIN,12));
		for (int i = 0; i < numBarras; i++) {
			int alturaBarra = (int) (((double) datos[i] / max) * (altoPanel - margenSup-margenInf));
			int y = altoPanel - margenInf- alturaBarra;


			g2d.setColor(Color.LIGHT_GRAY);
			g2d.drawLine(margenizq, y, anchoPanel-margenDer, y);
			g2d.setColor(Color.BLACK);

			String valor= String.valueOf(datos[i]);
			int ancho1= g2d.getFontMetrics().stringWidth(valor);
			if(datos[i]!=0)
				g2d.drawString(valor, margenizq-ancho1-5, y+5);


			if(i==0){
				g2d.drawString("0", margenizq-ancho1, 274);

			}
		}

		// Dibujar cada barra
		for (int i = 0; i < numBarras; i++) {
			int alturaBarra = (int) (((double) datos[i] / max) * (altoPanel - margenSup-margenInf));
			int x = margenizq+espacio + i * (anchoBarra + espacio);
			int y = altoPanel - margenInf- alturaBarra;

			// Dibujar la barra con efecto 3D
			GradientPaint gradient = new GradientPaint(x, y, colorMasClaro(), 
					x, y + alturaBarra, Color.PINK);
			g2d.setPaint(gradient);
			g2d.fill(new Rectangle2D.Double(x, y, anchoBarra, alturaBarra));


			// Borde de la barra
			g2d.setColor(new Color(0, 0, 0, 50)); // Negro semitransparente
			g2d.draw(new Rectangle2D.Double(x, y, anchoBarra, alturaBarra));

			// Dibujar el valor
			g2d.setColor(Color.BLACK);
			//            g2d.setFont(new Font("Arial", Font.PLAIN, 12));
			//            String valor = String.valueOf(datos[i]);
			//            int anchoTexto = g2d.getFontMetrics().stringWidth(valor);
			//            g2d.drawString(valor, x + (anchoBarra - anchoTexto)/2, y - 5);

			//            // Dibujar etiqueta (si hubiera)
			//            if (i % 2 == 0) { // Solo algunas etiquetas para no saturar
			//                g2d.drawString("Item " + (i+1), x, altoPanel - 30);
			//                
			//          
			//            }
			if(locales == null){
				String num = String.valueOf(i+8);
				int ancho= g2d.getFontMetrics().stringWidth(num);
				g2d.drawString(num, x+(anchoBarra-ancho)/2, altoPanel-40);
			}
			else
			{ 
				AffineTransform original= g2d.getTransform();
				g2d.rotate(Math.toRadians(-30),x+anchoBarra/2-50,altoPanel-margenInf+70);
				g2d.setFont(new Font ("Arial", Font.ITALIC,10));
				g2d.drawString(locales[i],x+anchoBarra/2-50,altoPanel-margenInf+70);
				g2d.setTransform(original);


			}
		}
	}

	private Color colorMasClaro() {
		return new Color(100, 160, 210); // SteelBlue más claro
	}

	private Color colorMasOscuro() {
		return new Color(50, 100, 150); // SteelBlue más oscuro
	}

	private int encontrarMaximo(int[] array) {
		int max = Integer.MIN_VALUE;
		for (int num : array) {
			if (num > max) max = num;
		}
		return max == 0 ? 1 : max; // Evitar división por cero
	}

	// Método main para probar directamente
	//	public static void main(String[] args) {
	//
	//		// Datos de ejemplo
	//		Facultad fac = new Facultad();
	//		int[] datosEjemplo = fac.entradaALaFAcuPorHoras(LocalDate.now(), fac.getLocales().get(0));
	//
	//		// Crear y mostrar el diálogo
	//		GraficoBarrasDialog dialog = new GraficoBarrasDialog(datosEjemplo);
	//		dialog.setVisible(true);
	//
	//	}
}