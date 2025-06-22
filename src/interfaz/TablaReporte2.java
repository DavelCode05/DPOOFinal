package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.TableModel;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;

import controllerClass.Facultad;
import util.ScrollMinimalista;
import util.TablaRegistrosReporte1;
import util.TablaRegistrosReporte2;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.Font;

import com.toedter.calendar.JDateChooser;

import enums.TipoLocal;

import javax.swing.JComboBox;

import personas.Persona;

import java.awt.Component;

import locales.Local;

public class TablaReporte2 extends JDialog {

	private final JPanel contentPanel = new JPanel(){
		public void paintComponent(Graphics g){
			Image img= Toolkit.getDefaultToolkit().getImage(Inicio.class.getResource("/images/fondoDesenfocado.png"));
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		}
	};
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	private JTable table;
	private TablaRegistrosReporte2 tablaModel;
	private Facultad fac;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton_1;
	private JDateChooser dateinicio;
	private JDateChooser datefinal;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TablaReporte2 dialog = new TablaReporte2();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */


	public TablaReporte2(/*JFrame padre*/) {
//		super(padre, "Reporte 2", true);
		setTitle("Chequeo de Registros Locales");
		fac = Facultad.getFacultad();
		setBounds(100, 100, 1086, 760);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setBorder(new LineBorder(Colores.getAzulOScuro()));
		this.setUndecorated(true);
		setLocationRelativeTo(null);
		contentPanel.setLayout(null);
		contentPanel.add(getLblNewLabel());
		contentPanel.add(getScrollPane());
		contentPanel.add(getLblNewLabel_1());
		contentPanel.add(getBtnNewButton_1());
		contentPanel.add(getDateinicio());
		contentPanel.add(getDatefinal());
		contentPanel.add(getLblNewLabel_2());
		contentPanel.add(getLblNewLabel_3());
		
		comboBox = new JComboBox<>();
		comboBox.setToolTipText("");
		comboBox.setFont(new Font("Modern No. 20", Font.PLAIN, 21));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBox.getSelectedItem() != null /*&& dateinicio.getDate() != null && datefinal.getDate() != null*/)
				entradaLocal();
			}
		});

		comboBox.setBounds(33, 75, 209, 53);
		contentPanel.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel<>(TipoLocal.values()));

		entradaLocal();

	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Local");
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("Modern No. 20", Font.BOLD, 25));
			lblNewLabel.setBounds(33, 46, 260, 26);
		}
		return lblNewLabel;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane(){
				public void paintComponent(Graphics g){
					Image img = Toolkit.getDefaultToolkit().getImage(TablaReporte1.class.getResource("/images/fondosTablas.png"));
					g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
				}
			};
			scrollPane.setEnabled(false);
			scrollPane.setBackground(Colores.getAzulCielo());
			scrollPane.setBounds(33, 202, 1018, 525);
			scrollPane.setViewportView(getTable());
			
			scrollPane.setBackground(Color.WHITE);
			scrollPane.getViewport().setBackground(Colores.getBlancuzo());
			scrollPane.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
			scrollPane.getVerticalScrollBar().setUI(new ScrollMinimalista());
		}
		return scrollPane;
	}
	private JTable getTable() {
		table = new JTable();
		table.setAutoCreateRowSorter(true);

		tablaModel = new TablaRegistrosReporte2();
		table.setModel(tablaModel);
		
		table.setShowHorizontalLines(false);
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setRowHeight(29);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getTableHeader().setFont(new Font("Modern No. 20", Font.BOLD, 19));
		table.setForeground(Color.BLACK);
		table.setBackground(Colores.getBlancuzo());
		table.setGridColor(Color.lightGray);
		table.getTableHeader().setBackground(Color.white);
		table.setBorder(null);
		
		table.setEnabled(false);
//		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

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

		return table;
	}


	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setBackground(Color.WHITE);
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
			lblNewLabel_1.setForeground(new Color(255, 0, 51));
			lblNewLabel_1.setBounds(33, 136, 352, 48);
			lblNewLabel_1.setVisible(false);;
		}
		return lblNewLabel_1;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("");
			UIManager.put("ToolTip.background", Color.WHITE);
			UIManager.put("ToolTip.foreground", Color.BLACK);
			UIManager.put("ToolTip.font", new Font("Segoe UI", Font.PLAIN, 16));
			
			btnNewButton_1.setToolTipText("Cerrar");
			
			btnNewButton_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(java.awt.event.MouseEvent arg0) {
					btnNewButton_1.setBackground(new Color(220, 53, 69));
					btnNewButton_1.setForeground(Color.WHITE);
					btnNewButton_1.setText("");
				}
				@Override
				public void mouseExited(java.awt.event.MouseEvent arg0) {
					btnNewButton_1.setBackground(new Color(240, 240, 240));
					btnNewButton_1.setForeground(Color.BLACK);
					btnNewButton_1.setText("");
				}
			});
			btnNewButton_1.setContentAreaFilled(false);
			btnNewButton_1.setBounds(1039, 0, 47, 46);
			btnNewButton_1.setOpaque(true);
			btnNewButton_1.setBorder(null);
			btnNewButton_1.setBackground(new Color(240, 240, 240));
			btnNewButton_1.setForeground(Color.BLACK);
			btnNewButton_1.setFocusPainted(false);
			btnNewButton_1.setFont(new Font("Segoe UI", Font.PLAIN, 28));
			btnNewButton_1.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
			
			btnNewButton_1.setIcon(new ImageIcon(TablaReporte1.class.getResource("/images/close.png")));
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
		}
		return btnNewButton_1;
	}
	private JDateChooser getDateinicio() {
		if (dateinicio == null) {
			dateinicio = new JDateChooser("dd/MM/yyyy", "##/##/####",'_');
			dateinicio.setFont(new Font("Tahoma", Font.BOLD, 16));
			dateinicio.setDateFormatString("dd/MM/yyyy");
			dateinicio.setForeground(Color.BLACK);
			dateinicio.setDate(Date.from((LocalDate.now()).atStartOfDay(ZoneId.systemDefault()).toInstant()));
			//			JTextField dateField = (JTextField)dateChooser.getDateEditor().getUiComponent();
			//			dateField.setForeground(Color.WHITE);
			dateinicio.setBounds(413, 75, 131, 53);
			//			dateField.setBackground(Colores.getAzulCielo());
		}
		return dateinicio;
	}
	private JDateChooser getDatefinal() {
		if (datefinal == null) {
			datefinal = new JDateChooser("dd/MM/yyyy", "##/##/####",'_');
			datefinal.setFont(new Font("Tahoma", Font.BOLD, 16));
			datefinal.setDate(Date.from((LocalDate.now()).atStartOfDay(ZoneId.systemDefault()).toInstant()));
			//			JTextField dateField1 = (JTextField)dateChooser_1.getDateEditor().getUiComponent();
			//			dateField1.setForeground(Color.WHITE);
			datefinal.setForeground(Color.BLACK);
			datefinal.setBounds(578, 75, 131, 53);
			//			dateField1.setBackground(Colores.getAzulCielo());
		}
		return datefinal;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("Desde");
			lblNewLabel_2.setForeground(Color.WHITE);
			lblNewLabel_2.setFont(new Font("Modern No. 20", Font.BOLD, 25));
			lblNewLabel_2.setBounds(413, 51, 74, 16);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("Hasta");
			lblNewLabel_3.setForeground(Color.WHITE);
			lblNewLabel_3.setFont(new Font("Modern No. 20", Font.BOLD, 25));
			lblNewLabel_3.setBounds(578, 51, 74, 16);
		}
		return lblNewLabel_3;
	}

	public void entradaLocal(){
		LocalDate inicio = dateinicio.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate finalll = datefinal.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		
		if(!inicio.isAfter(finalll)){
		TipoLocal tipo = (TipoLocal)comboBox.getSelectedItem();	
		tablaModel.setRowCount(0);
		tablaModel.cargarInfo(fac.obtenerInfoLocales(tipo, inicio, finalll));
		}else{
			JOptionPane.showMessageDialog(this, "La fecha inicial no puede ser posterior a la feha final", "Error en rango de fechas", JOptionPane.ERROR_MESSAGE);
		}

	}
}
