package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class IniciarSesion extends JDialog {

	private final JPanel contentPanel = new JPanel();
<<<<<<< HEAD
=======
	private JTextField nombreUser;
	private JComboBox<TipoLocal> comboBoxLocal;
	private JTextField carnet;
	private JLabel lblDatosErroneos;
	private Facultad fac ;
	private JTextField responsable;
	private boolean usuario = true;
	JLabel lblContrasea;
	JLabel lblUsuario;
	JLabel lblResponsable;
	JToggleButton tglbtnNewToggleButton;
	JToggleButton tglbtnUsuario;
	JButton btnNewButton;

	/**
	 * @wbp.nonvisual location=382,229
	 */
	private ButtonGroup buttonGroup ;
	private JButton btnNewButton_1;
	/**
	 * @wbp.nonvisual location=57,89
	 */
	
	/**
	 * @wbp.nonvisual location=377,239
	 */

	/**
	 * @wbp.nonvisual location=467,129
	 */

>>>>>>> origin/nicole

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			IniciarSesion dialog = new IniciarSesion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public IniciarSesion() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
