package interfaz;

import inicio.Iniciadora;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class BarraDeCarga extends JDialog {

	private final JPanel contentPanel = new JPanel(){
		public void paintComponent(Graphics g){
			Image img= Toolkit.getDefaultToolkit().getImage(BarraDeCarga.class.getResource("/images/loginDesenfocado.jpg"));
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		}

	};
	JProgressBar progressBar;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		    Iniciadora.iniciar();
			BarraDeCarga dialog = new BarraDeCarga();
			dialog.setVisible(true);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			
			 IniciarSesion inicio = new IniciarSesion();
			
			
			try {
				for(int i = 0; i < 100; i++){
					Thread.sleep(20);
					dialog.progressBar.setValue(i);;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			dialog.setVisible(false);
			inicio.setVisible(true);
			dialog.dispose();
		
	}

	/**
	 * Create the dialog.
	 */
	
	
	public BarraDeCarga() {
		setBounds(100, 100, 739, 489);
		getContentPane().setLayout(new BorderLayout());
		setUndecorated(true);
		setLocationRelativeTo(null);
		contentPanel.setBackground(Colores.getLogin());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getProgressBar());
		contentPanel.add(getPanel());
		contentPanel.add(getLblNewLabel());
		contentPanel.add(getLblNewLabel_1());
	
	}
	
	private JProgressBar getProgressBar() {
		UIManager.put("ProgressBar.foreground", new Color(76, 175, 80)); // Verde moderno
		UIManager.put("ProgressBar.background", new Color(240, 240, 240)); // Fondo claro
		UIManager.put("ProgressBar.selectionForeground", Color.BLACK);
		UIManager.put("ProgressBar.selectionBackground", Color.WHITE);
		UIManager.put("ProgressBar.border", BorderFactory.createEmptyBorder()); // Sin borde predeterminado
		if (progressBar == null) {
		    progressBar = new RoundedProgressBar();
		    progressBar.setBounds(12, 434, 715, 30);
		}
		return progressBar;

	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel(){
				public void paintComponent(Graphics g){
					Image img= Toolkit.getDefaultToolkit().getImage(BarraDeCarga.class.getResource("/images/logoLogin.png"));
					g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
				}
			};
			panel.setBounds(316, 68, 100, 100);
		}
		return panel;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Facultad de Ingenier\u00EDa Inform\u00E1tica");
			lblNewLabel.setFont(new Font("Modern No. 20", Font.BOLD, 38));
			lblNewLabel.setBounds(59, 178, 620, 100);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Cujae");
			lblNewLabel_1.setFont(new Font("Modern No. 20", Font.BOLD, 64));
			lblNewLabel_1.setBounds(286, 269, 174, 78);
		}
		return lblNewLabel_1;
	}
	
	class RoundedProgressBar extends JProgressBar {

	    public RoundedProgressBar() {
	        super();
	        setBorderPainted(false);
	        setStringPainted(true);
	        setFont(new Font("Segoe UI", Font.BOLD, 14));
	        setForeground(new Color(76, 175, 80));
	        setBackground(new Color(240, 240, 240));
	    }

	    @Override
	    protected void paintComponent(Graphics g) {
	        int width = getWidth();
	        int height = getHeight();
	        int arc = 20;

	        Graphics2D g2 = (Graphics2D) g.create();
	        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

	        // Fondo redondeado
	        g2.setColor(getBackground());
	        g2.fillRoundRect(0, 0, width, height, arc, arc);

	        // Relleno del progreso
	        int fillWidth = (int) (width * getPercentComplete());
	        g2.setColor(getForeground());
	        g2.fillRoundRect(0, 0, fillWidth, height, arc, arc);

	        // Texto centrado
	        String text = getString();
	        FontMetrics fm = g2.getFontMetrics();
	        int textWidth = fm.stringWidth(text);
	        int textHeight = fm.getAscent();
	        int x = (width - textWidth) / 2;
	        int y = (height + textHeight) / 2 - 2;

	        g2.setColor(Color.BLACK);
	        g2.drawString(text, x, y);

	        g2.dispose();
	    }
	}

}

