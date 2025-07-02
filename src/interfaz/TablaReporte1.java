package interfaz;

import inicio.Iniciadora;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import javax.swing.table.DefaultTableModel;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


import personas.Persona;
//import util.ScrollMinimalista;
import util.TablaRegistrosReporte1;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PRAcroForm;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.sun.glass.events.MouseEvent;
import com.toedter.calendar.JDateChooser;

import controllerClass.Facultad;

import javax.swing.JTextField;

public class TablaReporte1 extends JDialog {

	private final JPanel contentPanel = new JPanel(){
//		public void paintComponent(Graphics g){
//			Image img= Toolkit.getDefaultToolkit().getImage(Inicio.class.getResource("/images/fondoDesenfocado.png"));
//			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
//		}
	};
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	private JTable table;
	private TablaRegistrosReporte1 tablaModel;
	private Facultad fac;
	private JLabel errores;
	private JDateChooser dateinicio;
	private JDateChooser datefinal;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JButton btnNewButton;
	private JComboBox<Persona> comboBox;
	private JTextField filtrado;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		try {
//			Iniciadora.iniciar();
//			TablaReporte1 dialog = new TablaReporte1();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	/**
//	 * Create the dialog.
//	 */



	public TablaReporte1(JFrame padre) {
		super(padre, "Reporte 1", true);
		setTitle("Chequeo de Registros Personal");

		fac = Facultad.getFacultad();
		setBounds(100, 100, 1392, 855);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setBorder(new LineBorder(Colores.getAzulOScuro()));
//		this.setUndecorated(true);
		setLocationRelativeTo(null);
		
		
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

		
		comboBox = new JComboBox<>();
		comboBox.setToolTipText("");
		comboBox.setSelectedItem(fac.getPersonal().get(0));
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 20));
		

		comboBox.setBounds(90, 122, 329, 53);
		
		comboBox.setModel(new DefaultComboBoxModel<>(fac.getPersonal().toArray(new Persona[0])));
		
		contentPanel.setLayout(null);
		contentPanel.add(getLblNewLabel());
		contentPanel.add(getScrollPane());
		contentPanel.add(getErrores());
		contentPanel.add(comboBox);
		contentPanel.add(getDatefinal());
		contentPanel.add(getDateinicio());	
		contentPanel.add(getLblNewLabel_2());
		contentPanel.add(getLblNewLabel_3());
		contentPanel.add(getBtnNewButton());
		
		filtrado = new JTextField();
		filtrado.setBounds(540, 31, 86, 20);
		contentPanel.add(filtrado);
		filtrado.setColumns(10);
		
		final TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(table.getModel());
		table.setRowSorter(rowSorter);
		filtrado.getDocument().addDocumentListener(new DocumentListener() {
			
			private void filtrar(){
				String texto = filtrado.getText();
				if(texto.trim().length()==0){
					rowSorter.setRowFilter(null);
				}
				else{
					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + texto));
				}
			}
			
			@Override
			public void removeUpdate(DocumentEvent arg0) {
				filtrar();
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent arg0) {
				filtrar();
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent arg0) {
				filtrar();
				
			}
		});
			
			
	
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				entradaCarnet();
			}
		});

		

		entradaCarnet();

	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Nombre y apellidos:");
			lblNewLabel.setForeground(new Color(0, 0, 0));
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
			lblNewLabel.setBounds(90, 93, 261, 26);
		}
		return lblNewLabel;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane(){
//				public void paintComponent(Graphics g){
//					Image img = Toolkit.getDefaultToolkit().getImage(TablaReporte1.class.getResource("/images/fondosTablas.png"));
//					g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
//				}
			};
			scrollPane.setEnabled(false);
//			scrollPane.setBackground(Colores.getAzulCielo());
			scrollPane.setBounds(90, 225, 1189, 528);
			scrollPane.setViewportView(getTable());
			
//			scrollPane.setBackground(Color.WHITE);
//			scrollPane.getViewport().setBackground(Colores.getBlancuzo());
			scrollPane.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
		//	scrollPane.getVerticalScrollBar().setUI(new ScrollMinimalista());
		}
		return scrollPane;
	}
	private JTable getTable() {
		table = new JTable();

		tablaModel = new TablaRegistrosReporte1();
		table.setModel(tablaModel);
		
//		table.setShowHorizontalLines(false);
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setRowHeight(35);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 17));
//		table.setForeground(Color.BLACK);
//		table.setBackground(Colores.getBlancuzo());
//		table.setGridColor(Color.lightGray);
//		table.getTableHeader().setBackground(Color.white);
//		table.setBorder(null);
		
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


	private JLabel getErrores() {
		if (errores == null) {
			errores = new JLabel("");
			errores.setBackground(Color.WHITE);
			errores.setFont(new Font("Tahoma", Font.PLAIN, 19));
			errores.setForeground(new Color(255, 0, 51));
			errores.setBounds(90, 175, 646, 48);
			errores.setVisible(false);;
		}
		return errores;
	}
	private JDateChooser getDateinicio() {
		if (dateinicio == null) {
			dateinicio = new JDateChooser("dd/MM/yyyy", "##/##/####",'_');
			dateinicio.setDate(Date.from((LocalDate.now()).atStartOfDay(ZoneId.systemDefault()).toInstant()));
			getDatefinal().setDate(Date.from((LocalDate.now()).atStartOfDay(ZoneId.systemDefault()).toInstant()));
			dateinicio.addPropertyChangeListener(new PropertyChangeListener() {
				public void propertyChange(PropertyChangeEvent arg0) {
					if(isVisible())
					entradaCarnet();
				}
			});
			
			dateinicio.setFont(new Font("Tahoma", Font.BOLD, 20));
			dateinicio.setDateFormatString("dd/MM/yyyy");
			dateinicio.setForeground(Color.BLACK);
		
			//			JTextField dateField = (JTextField)dateChooser.getDateEditor().getUiComponent();
			//			dateField.setForeground(Color.WHITE);
			dateinicio.setBounds(540, 122, 209, 53);
			//			dateField.setBackground(Colores.getAzulCielo());
		}
		return dateinicio;
	}
	private JDateChooser getDatefinal() {
		if (datefinal == null) {
			datefinal = new JDateChooser("dd/MM/yyyy", "##/##/####",'_');
			datefinal.setDate(Date.from((LocalDate.now()).atStartOfDay(ZoneId.systemDefault()).toInstant()));
			getDateinicio().setDate(Date.from((LocalDate.now()).atStartOfDay(ZoneId.systemDefault()).toInstant()));
			
			datefinal.addPropertyChangeListener(new PropertyChangeListener() {
				public void propertyChange(PropertyChangeEvent arg0) {
					if(isVisible())
					entradaCarnet();
				}
			});
			
			datefinal.setFont(new Font("Tahoma", Font.BOLD, 20));
			
			//			JTextField dateField1 = (JTextField)dateChooser_1.getDateEditor().getUiComponent();
			//			dateField1.setForeground(Color.WHITE);
			datefinal.setForeground(Color.BLACK);
			datefinal.setBounds(779, 122, 196, 53);
			//			dateField1.setBackground(Colores.getAzulCielo());
		}
		return datefinal;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("Desde:");
			lblNewLabel_2.setForeground(new Color(0, 0, 0));
			lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 22));
			lblNewLabel_2.setBounds(540, 93, 196, 26);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("Hasta:");
			lblNewLabel_3.setForeground(new Color(0, 0, 0));
			lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 22));
			lblNewLabel_3.setBounds(779, 93, 111, 26);
		}
		return lblNewLabel_3;
	}

	public void entradaCarnet(){
		//		String carnet = textField.getText();
		//		boolean correcto = true;

		LocalDate inicio = dateinicio.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate finalll = datefinal.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		String p = ((Persona) comboBox.getSelectedItem()).getNumeroIdentidad();
		
		if(inicio.isBefore(finalll) || inicio.isEqual(finalll)){
	    errores.setVisible(false);
		tablaModel.setRowCount(0);
		tablaModel.cargarInfo(fac.obtenerReporteVisitasPersonas(p, inicio,finalll));
		}
		else {
			JOptionPane.showMessageDialog(this, "La fecha inicial no puede ser posterior a la feha final", "Error en rango de fechas", JOptionPane.ERROR_MESSAGE);
			tablaModel.setRowCount(0);
			
			
		}
	}
	public static void generarPdf(DefaultTableModel modeloTabla, String rutaArchivo){
	    Document document = new Document();

	    try {
	        PdfWriter.getInstance(document, new FileOutputStream(rutaArchivo));
	        document.open();

	        int numColumnas = modeloTabla.getColumnCount();
	        PdfPTable table = new PdfPTable(numColumnas);
	        table.setWidthPercentage(100); // Ocupa todo el ancho disponible

	        // Configurar anchos proporcionales de las columnas (aquí todos iguales)
	        float[] anchos = new float[numColumnas];
	        Arrays.fill(anchos, 1f); // Puedes personalizar los valores, por ejemplo: {2f, 3f, 1f}
	        table.setWidths(anchos);

	        for (int i = 0; i < numColumnas; i++) {
	            PdfPCell celda = new PdfPCell(new Paragraph(modeloTabla.getColumnName(i)));
	            celda.setFixedHeight(25f);
	            table.addCell(celda);
	        }

	        for (int fila = 0; fila < modeloTabla.getRowCount(); fila++) {
	            for (int columna = 0; columna < numColumnas; columna++) {
	                Object valor = modeloTabla.getValueAt(fila, columna);
	                PdfPCell celda = new PdfPCell(new Paragraph(valor != null ? valor.toString() : ""));
	                celda.setFixedHeight(25f);
	                table.addCell(celda);
	            }
	        }

	        Paragraph subtitulo = new Paragraph("Datos del reporte 1: ");
	        subtitulo.setSpacingAfter(10f);
	        document.add(subtitulo);
	        document.add(table);
	        mostrarMensajePerzonalizado("Éxito", "PDF creado exitosamente en: " + rutaArchivo);

	    } catch (DocumentException | IOException e) {
	        mostrarMensajePerzonalizado("Error", "Error al crear el PDF: " + e.getMessage());
	        e.printStackTrace();
	    } finally {
	        document.close();
	    }
	}
	
	private static void mostrarMensajePerzonalizado(String titulo, String mensaje){
		
		JPanel panel2 = new JPanel(new BorderLayout(10, 10));
		panel2.setBorder(new EmptyBorder(15, 15, 15, 15));
		panel2.setBackground(new Color(240, 248, 255));
		
		JLabel messageLabel = new JLabel("<html><b>"+mensaje+"<b><html>");
		messageLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
		messageLabel.setForeground(new Color(0,102,204));
		panel2.add(messageLabel, BorderLayout.CENTER);
		
		JOptionPane.showOptionDialog(null, panel2, titulo, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{}, null);
		
		
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Generar PDF");
			btnNewButton.setFocusPainted(false);
			btnNewButton.setBorderPainted(false);
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 21));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JFileChooser fileChooser = new JFileChooser();
					fileChooser.setDialogTitle("Guardar PDF");
					fileChooser.setSelectedFile(new File("tablaReporte1.pdf"));
					fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter(){
						@Override
						public boolean accept(File f){
							return f.isDirectory()||f.getName().toLowerCase().endsWith(".pdf");
						}
						
						@Override
						public String getDescription(){
							return "Archivos PDF (*.pdf)";						}
					});
					
					int userSelection = fileChooser.showSaveDialog(contentPanel);
					if(userSelection == JFileChooser.APPROVE_OPTION){
						File fileToSave = fileChooser.getSelectedFile();
						String rutaArchivo = fileToSave.getAbsolutePath();
						if(!rutaArchivo.toLowerCase().endsWith(".pdf")){
							rutaArchivo += ".pdf";
						}
						generarPdf(tablaModel, rutaArchivo);
					}
					
				}
			});
			btnNewButton.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {

					btnNewButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
				}
				public void mouseExited(MouseEvent e) {

					btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
				}
			});
			btnNewButton.setBounds(22, 31, 166, 36);
		}
		return btnNewButton;
	}
}
