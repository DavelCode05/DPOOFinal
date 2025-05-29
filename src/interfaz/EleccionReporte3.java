package interfaz;
import enums.TipoLocal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.SwingUtilities;

import java.awt.List;

import javax.swing.JComboBox;

import enums.TipoLocal;

import java.awt.Label;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;

import util.EntradasTable;
import controllerClass.Facultad;

import java.awt.event.ItemEvent;
import java.time.LocalDate;
import java.time.ZoneId;

import locales.Local;

import com.toedter.calendar.demo.DateChooserPanel;
import com.toedter.calendar.JDateChooser;
import javax.swing.SwingConstants;

public class EleccionReporte3 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	JComboBox <TipoLocal> comboBoxLocal ;
	JPanel panelloc;
	GraficoBarrasDialog g;
	JRadioButton rdbtnGraficoDeBarras;
	Facultad fac;
	JDateChooser dateChooser;
	JComboBox<String> comboBox;
	JRadioButton rdbtnDa;
	JRadioButton rdbtnTabla;
	JLabel errores;
	JRadioButton rdbtnMes;
	JRadioButton rdbtnSemana;
	JLabel lblFormato;
	JLabel lblFormaDeVisualizacin;
	JLabel lblSeleccionarFecha;
	/**
	 * @wbp.nonvisual location=422,329
	 */
	private final ButtonGroup buttonGroup = new ButtonGroup();
	/**
	 * @wbp.nonvisual location=432,279
	 */
	private final ButtonGroup buttonGroupFormas = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			EleccionReporte3 dialog = new EleccionReporte3();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public EleccionReporte3() {
		fac = new Facultad();
		setBounds(100, 100, 365, 452);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(216, 191, 216));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		panelloc = new JPanel();
		panelloc.setBackground(new Color(216, 191, 216));
		panelloc.setBounds(161, 47, 178, 68);
		contentPanel.add(panelloc);
		panelloc.setLayout(null);
		panelloc.setVisible(false);

		JLabel lblNewLabel = new JLabel("Seleccionar Local:");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel.setBounds(29, 11, 112, 14);
		panelloc.add(lblNewLabel);



		comboBoxLocal = new JComboBox<>();
		comboBoxLocal.setBackground(new Color(255, 255, 255));
		comboBoxLocal.setFont(new Font("Verdana", Font.PLAIN, 12));
		comboBoxLocal.setModel(new DefaultComboBoxModel<>(TipoLocal.values()));
		comboBoxLocal.setBounds(10, 37, 162, 20);
		panelloc.add(comboBoxLocal);

		lblFormaDeVisualizacin = new JLabel("Forma de visualizaci\u00F3n:");
		lblFormaDeVisualizacin.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblFormaDeVisualizacin.setBounds(96, 289, 147, 14);
		contentPanel.add(lblFormaDeVisualizacin);

		rdbtnTabla = new JRadioButton("Tabla");
		rdbtnTabla.setBackground(new Color(216, 191, 216));
		//		rdbtnTabla.addItemListener(new ItemListener() {
		//			public void itemStateChanged(ItemEvent arg0) {
		//				if(arg0.getStateChange()==ItemEvent.SELECTED){
		//					String local = comboBoxLocal.getSelectedItem().toString();
		//					Local loc = fac.buscarLocal(local);
		//
		//
		//					int[] datos = fac.entradaALaFAcuPorHoras(LocalDate.now(), loc);
		//					EntradasTable t = new EntradasTable(datos);
		//
		//
		//
		//				}
		//			}
		//		});
		rdbtnTabla.setBounds(77, 321, 93, 23);
		contentPanel.add(rdbtnTabla);

		dateChooser = new JDateChooser("dd/MM/yyyy", "##/##/####",'_');
		dateChooser.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		//		dateChooser.setDate(LocalDate.now().toInstant().);
		dateChooser.setBounds(49, 228, 121, 20);
		contentPanel.add(dateChooser);

		lblSeleccionarFecha = new JLabel("Seleccionar Fecha:");
		lblSeleccionarFecha.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblSeleccionarFecha.setBounds(107, 187, 121, 14);
		contentPanel.add(lblSeleccionarFecha);

		rdbtnGraficoDeBarras = new JRadioButton("Grafico de barras");
		rdbtnGraficoDeBarras.setBackground(new Color(216, 191, 216));


		rdbtnGraficoDeBarras.setBounds(182, 321, 137, 23);
		contentPanel.add(rdbtnGraficoDeBarras);
		buttonGroupFormas.add(rdbtnGraficoDeBarras);
		buttonGroupFormas.add(rdbtnTabla);

		comboBox = new JComboBox<String>();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBox.getSelectedItem().toString().equals("LOCAL"))
					panelloc.setVisible(true);
			}
		});
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setFont(new Font("Verdana", Font.PLAIN, 12));
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"FACULTAD", "LOCAL"}));
		comboBox.setBounds(22, 84, 121, 20);
		contentPanel.add(comboBox);

		JLabel lblMostrarPor = new JLabel("Mostrar Por:");
		lblMostrarPor.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblMostrarPor.setBounds(22, 58, 106, 14);
		contentPanel.add(lblMostrarPor);

		JLabel label = new JLabel("");
		label.setBounds(59, 251, 46, 14);
		contentPanel.add(label);

		lblFormato = new JLabel("Formato:");
		lblFormato.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblFormato.setBounds(22, 143, 78, 14);
		contentPanel.add(lblFormato);

		rdbtnDa = new JRadioButton("D\u00EDa");
		rdbtnDa.setBackground(new Color(216, 191, 216));
		rdbtnDa.setFont(new Font("Verdana", Font.PLAIN, 12));
		rdbtnDa.setBounds(96, 140, 47, 23);
		contentPanel.add(rdbtnDa);

		rdbtnSemana = new JRadioButton("Semana");
		rdbtnSemana.setBackground(new Color(216, 191, 216));
		rdbtnSemana.setFont(new Font("Verdana", Font.PLAIN, 12));
		rdbtnSemana.setBounds(150, 140, 78, 23);
		contentPanel.add(rdbtnSemana);

		rdbtnMes = new JRadioButton("Mes");
		rdbtnMes.setBackground(new Color(216, 191, 216));
		rdbtnMes.setFont(new Font("Verdana", Font.PLAIN, 12));
		rdbtnMes.setBounds(230, 140, 109, 23);
		contentPanel.add(rdbtnMes);

		buttonGroup.add(rdbtnMes);
		buttonGroup.add(rdbtnSemana);
		buttonGroup.add(rdbtnDa);

		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				representarReportePorDia();
			}
		});
		btnMostrar.setFont(new Font("Verdana", Font.PLAIN, 12));
		btnMostrar.setBounds(119, 379, 89, 23);
		contentPanel.add(btnMostrar);

		errores = new JLabel("Faltan elementos por seleccionar");
		errores.setFont(new Font("Verdana", Font.PLAIN, 13));
		errores.setVisible(false);
		errores.setForeground(new Color(255, 0, 0));
		errores.setHorizontalAlignment(SwingConstants.CENTER);
		errores.setBounds(22, 354, 297, 14);
		contentPanel.add(errores);



	}


	public void representarReportePorDia(){
		Local loc = null;
		LocalDate fecha = null;
		int [] datos = null;
		String []locales = null;

		if(!rdbtnDa.isSelected()&& !rdbtnMes.isSelected() && ! rdbtnSemana.isSelected()){
			lblFormato.setForeground(Color.red);
			errores.setVisible(true);
		}
		else{
			lblFormato.setForeground(Color.black);
			errores.setVisible(false);
		}

		if(comboBox.getSelectedItem().toString().equals("LOCAL")){

			loc = fac.buscarLocal(comboBoxLocal.getSelectedItem().toString());
			if(dateChooser.getDate()!=null){
				fecha = dateChooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

				datos = fac.entradaALaFAcuPorHoras(fecha, loc);
				locales= null;
				errores.setVisible(false);
				lblSeleccionarFecha.setForeground(Color.black);
			}
			else {
				lblSeleccionarFecha.setForeground(Color.red);
				errores.setVisible(true);
			}



		}
		else{

			if(dateChooser.getDate()!=null){
				fecha = dateChooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				lblSeleccionarFecha.setForeground(Color.black);
				datos = fac.entradaALAFacuPorDia(fecha);
				locales = fac.nombresLocales();
			}
			else {
				lblSeleccionarFecha.setForeground(Color.red);
				errores.setVisible(true);
			}
		}

		if(rdbtnGraficoDeBarras.isSelected()){
			lblFormaDeVisualizacin.setForeground(Color.black);
			errores.setVisible(false);
			if(!errores.isVisible()){
				GraficoBarrasDialog g = new GraficoBarrasDialog(datos,EleccionReporte3.this, locales);
				g.setVisible(true);

			}
		}
		else if(rdbtnTabla.isSelected()){
			errores.setVisible(false);
			lblFormaDeVisualizacin.setForeground(Color.black);
			if(!errores.isVisible()){
				if(comboBox.getSelectedItem().toString().equals("LOCAL")){
					TablaReporte3 t = new TablaReporte3(fecha, loc, EleccionReporte3.this);
					t.setVisible(true);

				}

			}
		}
		else{
			lblFormaDeVisualizacin.setForeground(Color.red);
			errores.setVisible(true);

		}



	}
}
