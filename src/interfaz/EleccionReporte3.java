package interfaz;
import enums.TipoLocal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.StyledEditorKit.BoldAction;
import javax.swing.JRadioButton;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.ListSelectionModel;
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
import util.LocalesRep3TableModel;
import controllerClass.Facultad;

import java.awt.event.ItemEvent;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import locales.Local;

import com.toedter.calendar.demo.DateChooserPanel;
import com.toedter.calendar.JDateChooser;

import javax.swing.SwingConstants;

import java.awt.CardLayout;

import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class EleccionReporte3 extends JDialog {

	private final JPanel contentPanel = new JPanel(){
		public void paintComponent(Graphics g){
			Image img= Toolkit.getDefaultToolkit().getImage(Inicio.class.getResource("/images/fondoDesenfocado.png"));
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		}

	};
	JComboBox <Local> comboBoxLocal ;
	JPanel panelloc;
	GraficoBarrasDialog g;
	JRadioButton rdbtnGraficoDeBarras;
	Facultad fac;
	JDateChooser dateChooser;
	JComboBox<String> comboBox;
	JRadioButton rdbtnDa;
	JRadioButton rdbtnTabla;
	JRadioButton rdbtnMes;
	JRadioButton rdbtnSemana;
	JLabel lblFormaDeVisualizacin;
	JPanel panelTabla;
	CardLayout card;
	JLabel lblFormato;
	JLabel lblSeleccionarFecha;
	JPanel panelGrafico2;
	/**
	 * @wbp.nonvisual location=422,329
	 */
	private final ButtonGroup buttonGroup = new ButtonGroup();
	/**
	 * @wbp.nonvisual location=432,279
	 */
	private final ButtonGroup buttonGroupFormas = new ButtonGroup();
	private JPanel panelNuevo;
	private JTable table;
	EntradasTable tableModelHora ;
	LocalesRep3TableModel tableModelLocal;
	private JButton btnNewButton;

//
//	public static void main(String[] args) {
//		try {
//			EleccionReporte3 dialog = new EleccionReporte3();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	
//		/**
//		 * Launch the application.
//		 */
	

	public EleccionReporte3(JFrame padre) {
		super(padre, "", true);


		fac = Facultad.getFacultad();

		setBounds(100, 100, 1086, 566);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setBorder(new LineBorder(Colores.getAzulOScuro()));
		this.setUndecorated(true);
		setLocationRelativeTo(null);
		contentPanel.setLayout(null);

		panelloc = new JPanel();
		panelloc.setBackground(Colores.getAzulCielo());
		panelloc.setBounds(175, 104, 228, 70);
		contentPanel.add(panelloc);
		panelloc.setLayout(null);
		panelloc.setVisible(false);




		comboBoxLocal = new JComboBox<>();
		comboBoxLocal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				representarReportePorDia();
			}
		});
		comboBoxLocal.setBackground(new Color(255, 255, 255));
		comboBoxLocal.setFont(new Font("Tahoma", Font.PLAIN, 21));
		comboBoxLocal.setModel(new DefaultComboBoxModel<>(fac.getLocales().toArray(new Local[0])));
		comboBoxLocal.setSelectedItem(0);
		comboBoxLocal.setBounds(0, 40, 228, 27);
		panelloc.add(comboBoxLocal);

		JLabel lblNewLabel = new JLabel("Seleccionar Local:");
		lblNewLabel.setBounds(0, 0, 175, 27);
		panelloc.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setForeground(Color.WHITE);

		lblFormaDeVisualizacin = new JLabel("Forma de visualizaci\u00F3n:");
		lblFormaDeVisualizacin.setForeground(Color.WHITE);
		lblFormaDeVisualizacin.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblFormaDeVisualizacin.setBounds(37, 339, 246, 27);
		contentPanel.add(lblFormaDeVisualizacin);

		rdbtnTabla = new JRadioButton("Tabla");
		rdbtnTabla.setForeground(Color.BLACK);
		rdbtnTabla.setFont(new Font("Tahoma", Font.PLAIN, 21));


		rdbtnTabla.setSelected(true);
		rdbtnTabla.setBackground(Colores.getLogin());
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
		rdbtnTabla.setBounds(37, 387, 109, 36);
		contentPanel.add(rdbtnTabla);

		dateChooser = new JDateChooser("dd/MM/yyyy", "##/##/####",'_');
		dateChooser.setDate(Date.from((LocalDate.now()).atStartOfDay(ZoneId.systemDefault()).toInstant()));
		
		dateChooser.setFont(new Font("Tahoma", Font.PLAIN, 17) );

		dateChooser.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//representarReportePorDia();
			}
		});
		dateChooser.getCalendarButton().setToolTipText("");
		

		//		dateChooser.setDate(LocalDate.now().toInstant().);
		dateChooser.setBounds(224, 267, 157, 36);
		contentPanel.add(dateChooser);

		lblSeleccionarFecha = new JLabel("Seleccionar fecha:");
		lblSeleccionarFecha.setForeground(Color.WHITE);
		lblSeleccionarFecha.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblSeleccionarFecha.setBounds(37, 272, 246, 27);
		contentPanel.add(lblSeleccionarFecha);

		rdbtnGraficoDeBarras = new JRadioButton("Gr\u00E1fico de barras");
		rdbtnGraficoDeBarras.setForeground(Color.BLACK);
		rdbtnGraficoDeBarras.setFont(new Font("Tahoma", Font.PLAIN, 21));
		rdbtnGraficoDeBarras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				representarReportePorDia();
			}
		});
		rdbtnGraficoDeBarras.setBackground(Colores.getLogin());


		rdbtnGraficoDeBarras.setBounds(175, 387, 211, 36);
		contentPanel.add(rdbtnGraficoDeBarras);
		buttonGroupFormas.add(rdbtnGraficoDeBarras);
		buttonGroupFormas.add(rdbtnTabla);

		comboBox = new JComboBox<String>();

		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 21));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Facultad", "Local"}));
		comboBox.setBounds(37, 144, 128, 27);
		contentPanel.add(comboBox);

		JLabel lblMostrarPor = new JLabel("Mostrar Por:");
		lblMostrarPor.setForeground(Color.WHITE);
		lblMostrarPor.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblMostrarPor.setBounds(37, 104, 151, 27);
		contentPanel.add(lblMostrarPor);


		JLabel label = new JLabel("");
		label.setBounds(59, 251, 46, 14);
		contentPanel.add(label);

		lblFormato = new JLabel("Formato:");
		lblFormato.setForeground(Color.WHITE);
		lblFormato.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblFormato.setBounds(37, 205, 89, 27);
		contentPanel.add(lblFormato);


		rdbtnDa = new JRadioButton("D\u00EDa");
		rdbtnDa.setForeground(Color.BLACK);
		rdbtnDa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				representarReportePorDia();
			}
		});
		rdbtnDa.setSelected(true);
		rdbtnDa.setBackground(Colores.getLogin());
		rdbtnDa.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtnDa.setBounds(134, 207, 63, 28);
		contentPanel.add(rdbtnDa);

		rdbtnSemana = new JRadioButton("Semana");
		rdbtnSemana.setForeground(Color.BLACK);
		rdbtnSemana.setBackground(Colores.getLogin());
		rdbtnSemana.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtnSemana.setBounds(201, 207, 93, 28);
		contentPanel.add(rdbtnSemana);

		rdbtnMes = new JRadioButton("Mes");
		rdbtnMes.setForeground(Color.BLACK);
		rdbtnMes.setBackground(Colores.getLogin());
		rdbtnMes.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtnMes.setBounds(298, 207, 83, 28);
		contentPanel.add(rdbtnMes);

		buttonGroup.add(rdbtnMes);
		buttonGroup.add(rdbtnSemana);
		buttonGroup.add(rdbtnDa);

		panelNuevo = new JPanel();
		panelNuevo.setBounds(415, 104, 646, 433);
		contentPanel.add(panelNuevo);
		card = new CardLayout(0, 0);
		panelNuevo.setLayout(card);

		panelTabla = new JPanel(){
			public void paintComponent(Graphics g){
				Image img = Toolkit.getDefaultToolkit().getImage(TablaReporte1.class.getResource("/images/fondosTablas.png"));
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};
		panelTabla.setBackground(Color.WHITE);
		panelTabla.setBorder(null);
		panelNuevo.add(panelTabla, "name_1117880551873900");
		panelTabla.setLayout(null);


		JScrollPane scrollPane = new JScrollPane(){
			public void paintComponent(Graphics g){
				Image img = Toolkit.getDefaultToolkit().getImage(EleccionReporte3.class.getResource("/images/fondosTablas.png"));
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};
		
		scrollPane.setEnabled(false);
		scrollPane.setBackground(Colores.getAzulCielo());
		scrollPane.getViewport().setBackground(Colores.getLogin());
		scrollPane.setBorder(new LineBorder(Color.WHITE));
		scrollPane.setAutoscrolls(true);
		scrollPane.setBounds(0, 0, 646, 433);
		panelTabla.add(scrollPane);

		
		table = new JTable();
		scrollPane.setViewportView(table);
		tableModelHora = new EntradasTable();
		tableModelLocal = new LocalesRep3TableModel();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(tableModelLocal);
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setBackground(Colores.getAzulCielo());
		table.setRowHeight(29);
		table.setGridColor(Colores.getLogin());
		table.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 18));;
		table.getTableHeader().setBackground(Colores.getLogin());
		table.setForeground(Color.WHITE);
//		table.setCellSelectionEnabled(true);
//		table.setRowSelectionAllowed(true);

	    tableModelLocal = new LocalesRep3TableModel();
	    table.setModel(tableModelLocal);
	 

		

		panelGrafico2 = new JPanel();
		panelNuevo.add(panelGrafico2, "name_1117880551873901");
		contentPanel.add(getBtnNewButton());

		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBox.getSelectedItem().toString().equals("Local")){
					panelloc.setVisible(true);
					table.setModel(tableModelHora);
				}
				else{
					table.setModel(tableModelLocal);
					panelloc.setVisible(false);
//					table.getColumn("Acciones").setCellRenderer(new ButtonRenderer());
				}


				representarReportePorDia();
			}
		});

		rdbtnTabla.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(arg0.getStateChange()== ItemEvent.SELECTED){

					card.show(panelNuevo, "name_1117880551873900");
					representarReportePorDia();
				}
			}
		});
		
		dateChooser.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				representarReportePorDia();
				
			}
		});


		representarReportePorDia();


	}


	public void representarReportePorDia(){
		Local loc = null;
		LocalDate fecha = null;
		int [] datos = null;
		String []locales = null;
		GraficoBarrasDialog g = null;

		if(!rdbtnDa.isSelected()&& !rdbtnMes.isSelected() && ! rdbtnSemana.isSelected()){
//			lblFormato.setForeground(Color.red);

		}
		else{
			lblFormato.setForeground(Color.WHITE);

		}

		if(comboBox.getSelectedItem().toString().equals("Local")){

			loc = fac.buscarLocal(((Local)comboBoxLocal.getSelectedItem()).getCodigo());
			if(dateChooser.getDate()!=null){
				fecha = dateChooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

				datos = fac.entradaALaFAcuPorHoras(fecha, loc);
				locales= null;

				lblSeleccionarFecha.setForeground(Color.WHITE);
			}
			else {
				lblSeleccionarFecha.setForeground(Color.WHITE);

			}
		}
		else{

			if(dateChooser.getDate()!=null){
				fecha = dateChooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				lblSeleccionarFecha.setForeground(Color.WHITE);
				datos = fac.entradaALAFacuPorDia(fecha);
				locales = fac.nombresLocales();
			}
			else {
				lblSeleccionarFecha.setForeground(Color.WHITE);

			}
		}





		if(rdbtnGraficoDeBarras.isSelected()){
			lblFormaDeVisualizacin.setForeground(Color.WHITE);

			g = new GraficoBarrasDialog(datos,EleccionReporte3.this, locales, panelNuevo);
			panelNuevo.add(g, "red");
			card.show(panelNuevo, "red");
		}
		else if(rdbtnTabla.isSelected()){

			lblFormaDeVisualizacin.setForeground(Color.WHITE);


			if(comboBox.getSelectedItem().toString().equals("Local")){
				tableModelHora.setRowCount(0);
				tableModelHora.llenarTabla(fac.entradaALaFAcuPorHoras(fecha, loc)); 
			}
			else {
				tableModelLocal.setRowCount(0);
				tableModelLocal.llenarTabla(fac.entradaALAFacuPorDia(fecha), locales);

			}
		}
		else{
			lblFormaDeVisualizacin.setForeground(Color.WHITE);

		}



	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("");
			btnNewButton.setBounds(1016, 13, 58, 48);
			btnNewButton.setContentAreaFilled(false);
			btnNewButton.setOpaque(true);
			btnNewButton.setBorder(null);
			btnNewButton.setBackground(Color.LIGHT_GRAY);
			btnNewButton.setForeground(new Color(6, 43, 63));
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 29));
			btnNewButton.setIcon(new ImageIcon(TablaReporte1.class.getResource("/images/close.png")));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
		}
		return btnNewButton;
	}
}
