package interfaz;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseMotionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import locales.Local;
import util.EntradasTable;
import util.LocalesRep3TableModel;

import com.toedter.calendar.JDateChooser;

import controllerClass.Facultad;

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
	JRadioButton rdbtnTabla;
	JLabel lblFormaDeVisualizacin;
	JPanel panelTabla;
	CardLayout card;
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

		setBounds(100, 100, 1086, 721);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setBorder(new LineBorder(Colores.getAzulOScuro()));
		this.setUndecorated(true);
		setLocationRelativeTo(null);
		contentPanel.setLayout(null);

		panelloc = new JPanel();
		panelloc.setBackground(Colores.getAzulCielo());
		panelloc.setBounds(156, 104, 247, 92);
		contentPanel.add(panelloc);
		panelloc.setLayout(null);
		panelloc.setVisible(false);

		try{
			boolean found = false;
			for(UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()){
				if("Nimbus".equals(info.getName()) && !found){
					UIManager.setLookAndFeel(info.getClassName());
					found = true;
				}
			}
			if(!found){
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			}
		} catch(Exception e){
			try{
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}



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
		comboBoxLocal.setBounds(0, 40, 247, 36);
		panelloc.add(comboBoxLocal);

		JLabel lblNewLabel = new JLabel("Seleccionar Local:");
		lblNewLabel.setBounds(0, 0, 175, 27);
		panelloc.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setForeground(Color.WHITE);

		lblFormaDeVisualizacin = new JLabel("Forma de visualizaci\u00F3n:");
		lblFormaDeVisualizacin.setForeground(Color.WHITE);
		lblFormaDeVisualizacin.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblFormaDeVisualizacin.setBounds(18, 286, 246, 27);
		contentPanel.add(lblFormaDeVisualizacin);

		rdbtnTabla = new JRadioButton("Tabla");
//		rdbtnTabla.setForeground(Color.WHITE);
		rdbtnTabla.setFont(new Font("Tahoma", Font.PLAIN, 21));


		rdbtnTabla.setSelected(true);
		rdbtnTabla.setBackground(Colores.getBlancuzo());
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
		rdbtnTabla.setBounds(18, 334, 109, 36);
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
		dateChooser.setBounds(205, 214, 157, 36);
		contentPanel.add(dateChooser);

		lblSeleccionarFecha = new JLabel("Seleccionar fecha:");
		lblSeleccionarFecha.setForeground(Color.WHITE);
		lblSeleccionarFecha.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblSeleccionarFecha.setBounds(18, 219, 183, 27);
		contentPanel.add(lblSeleccionarFecha);

		rdbtnGraficoDeBarras = new JRadioButton("Gr\u00E1fico de barras");
		rdbtnGraficoDeBarras.setForeground(Color.WHITE);
		rdbtnGraficoDeBarras.setFont(new Font("Tahoma", Font.PLAIN, 21));
		rdbtnGraficoDeBarras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				representarReportePorDia();
			}
		});
		rdbtnGraficoDeBarras.setBackground(Colores.getBlancuzo());


		rdbtnGraficoDeBarras.setBounds(156, 334, 211, 36);
		contentPanel.add(rdbtnGraficoDeBarras);
		buttonGroupFormas.add(rdbtnGraficoDeBarras);
		buttonGroupFormas.add(rdbtnTabla);

		comboBox = new JComboBox<String>();

		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 21));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Facultad", "Local"}));
		comboBox.setBounds(18, 144, 128, 36);
		contentPanel.add(comboBox);

		JLabel lblMostrarPor = new JLabel("Mostrar Por:");
		lblMostrarPor.setForeground(Color.WHITE);
		lblMostrarPor.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblMostrarPor.setBounds(18, 64, 137, 27);
		contentPanel.add(lblMostrarPor);


		JLabel label = new JLabel("");
		label.setBounds(59, 251, 46, 14);
		contentPanel.add(label);

		panelNuevo = new JPanel();
		panelNuevo.setBounds(415, 260, 646, 433);
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
//			public void paintComponent(Graphics g){
//				Image img = Toolkit.getDefaultToolkit().getImage(EleccionReporte3.class.getResource("/images/fondosTablas.png"));
//				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
//			}
		};
		
//		scrollPane.setBackground(Color.WHITE);
//		scrollPane.getViewport().setBackground(Colores.getBlancuzo());
		scrollPane.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
//		scrollPane.getVerticalScrollBar().setUI(new ScrollMinimalista());
		scrollPane.setEnabled(false);
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
//		table.setShowHorizontalLines(false);
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setRowHeight(29);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getTableHeader().setFont(new Font("Modern No. 20", Font.BOLD, 19));
//		table.setForeground(Color.BLACK);
//		table.setBackground(Colores.getBlancuzo());
//		table.setGridColor(Color.LIGHT_GRAY);
//		table.getTableHeader().setBackground(Color.white);
//		table.setBorder(null);
		table.setEnabled(false);
//		table.setCellSelectionEnabled(true);
//		table.setRowSelectionAllowed(true);

	    tableModelLocal = new LocalesRep3TableModel();
	    table.setModel(tableModelLocal);
	 
	    table.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(java.awt.event.MouseEvent arg0) {
				int row = table.rowAtPoint(arg0.getPoint());
				if(row!=-1){
					table.setRowSelectionInterval(row,row);
					table.setAutoscrolls(true);

				}
				else{
					table.clearSelection();
				}				
			}

			@Override
			public void mouseDragged(java.awt.event.MouseEvent arg0) {
				// TODO Auto-generated method stub

			}


		});
	    
		

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

//		if(!rdbtnDa.isSelected()&& !rdbtnMes.isSelected() && ! rdbtnSemana.isSelected()){
////			lblFormato.setForeground(Color.red);
//
//		}
//		else{
//			lblFormato.setForeground(Color.WHITE);
//
//		}

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
