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
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import locales.Local;
import personas.Persona;
import util.MostrarLocales;
import controllerClass.Facultad;
import enums.TipoLocal;

public class VerLocales extends JDialog {

	private final JPanel contentPanel;
	private Facultad fac;
	private JComboBox<Persona> respons;
	private JScrollPane scrollPane;
	private JTable tableloc;
	private int row;
	private MostrarLocales tablemodel;

	private JButton btnNewButton;
	private JTextField codigo;
	private JComboBox<TipoLocal> tipoLoc;
	boolean editando;
	boolean agregar;
	private JLabel errores;
	private JButton btnCancelar;
	private JButton btnGuardarCambios;
	private JButton btnEliminar;
	private JButton btneditar;
	private JLabel lblTipo ;
	private JLabel lblCodigo;
	private JLabel lblResponsable;
	private JButton btnAgregar;
	private JPanel panel;
	private JPopupMenu menuContextual;
	private JButton btnGenerarPdf;

	private Color verdePrincipal = new Color(46, 204, 113);
	private Color verdeHover = new Color(39, 174, 96);
	private Color verdePressed = new Color(33, 150, 83);

	private JButton btnNewButton_1;
	private JTextField filtrado;


	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		try {
//			Iniciadora.iniciar();
//			VerLocales dialog = new VerLocales();
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
//	
	
	public VerLocales(JFrame p) {
    	super(p, true);
    	setFont(new Font("Tahoma", Font.PLAIN, 17));
    	setTitle("Locales");
    	setLocationRelativeTo(null);
		fac = Facultad.getFacultad();
		setBounds(100, 100, 1392, 855);
		editando = false;
		agregar = false;
		contentPanel = new JPanel(){
//			public void paintComponent(Graphics g){
//				Image img= Toolkit.getDefaultToolkit().getImage(Inicio.class.getResource("/images/fondoDesenfocado.png"));
//				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
//			}
		};
			
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
//		setUndecorated(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);


		panel = new JPanel();
		panel.setBounds(692, 108, 585, 631);
		panel.setLayout(null);
		panel.setOpaque(true);

		TitledBorder bordeConTitulo = BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(Colores.getBlancuzo(), 2, false),
				"Detalles del local",
				TitledBorder.CENTER,
				TitledBorder.TOP,
				new Font("Tahoma", Font.BOLD, 26),
				Color.BLACK);
		panel.setBorder(bordeConTitulo);
//		panel.setBackground(Colores.getBlancuzo());
		contentPanel.add(panel);
		


		scrollPane = new JScrollPane();
		contentPanel.add(scrollPane);

//		scrollPane.setBackground(Color.WHITE);
//		scrollPane.getViewport().setBackground(Colores.getBlancuzo());
		scrollPane.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
		scrollPane.setBounds(88, 108, 603, 631);
//		scrollPane.getVerticalScrollBar().setUI(new ScrollMinimalista());

		tableloc = new JTable();

		tablemodel = new MostrarLocales();

		scrollPane.setViewportView(tableloc);
		tableloc.setModel(tablemodel);
//		tableloc.setShowHorizontalLines(false);
		tableloc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tableloc.setRowHeight(35);
		tableloc.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableloc.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 17));
//		tableloc.setForeground(Color.BLACK);
//		tableloc.setBackground(Colores.getBlancuzo());
//		tableloc.setGridColor(Color.LIGHT_GRAY);
//		tableloc.getTableHeader().setBackground(Color.white);
//		tableloc.setBorder(null);

		
		

		tableloc.addMouseMotionListener(new MouseMotionListener() {

				
				@Override
				public void mouseMoved(java.awt.event.MouseEvent arg0) {
					 if (!editando){
					 row = tableloc.rowAtPoint(arg0.getPoint());
					if(row!=-1){

						tableloc.setRowSelectionInterval(row,row);
						tableloc.setAutoscrolls(true);
						mostrar(fac.getLocales().get(tableloc.convertRowIndexToModel(row)));	

					}
					else {
						tableloc.clearSelection();
					}
				}}

				@Override
				public void mouseDragged(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
			});
	
			
		
		
		
		

		tableloc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent arg0) {

				if(!editando){
					mostrar (fac.getLocales().get(tableloc.convertRowIndexToModel(row)));
					tablemodel.setRowCount(0);
					tablemodel.cargarInfo(fac.getLocales());
				}
			}

		});

		
		
		
		tableloc.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				int indice = tableloc.getSelectedRow();
				if(indice>-1){
					tableloc.setRowSelectionInterval(indice,indice);
					tableloc.setAutoscrolls(true);
					mostrar(fac.getLocales().get(tableloc.convertRowIndexToModel(indice)));
				}

			}
		});
		
		menuContextual = new JPopupMenu();
		JMenuItem itemEditar = new JMenuItem("Editar");
		JMenuItem itemEliminar = new JMenuItem("Eliminar");
		itemEditar.setFont(new Font(itemEditar.getFont().getName(), Font.BOLD, 15));
		itemEliminar.setFont(new Font(itemEliminar.getFont().getName(), Font.BOLD, 15));

		itemEditar.setPreferredSize(new java.awt.Dimension(90,30));
		itemEliminar.setPreferredSize(new java.awt.Dimension(90,30));


		menuContextual.add(itemEditar);
		menuContextual.add(itemEliminar);
		
		tableloc.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(java.awt.event.MouseEvent e) {
				if(e.isPopupTrigger()){
					int fila = tableloc.rowAtPoint(e.getPoint());
					if(fila >=0 ){
						tableloc.setRowSelectionInterval(fila, fila);
						menuContextual.show(e.getComponent(), e.getX(), e.getY());
					}
				}
			}

			@Override
			public void mouseReleased(java.awt.event.MouseEvent e){
				if(e.isPopupTrigger()){
					mousePressed(e);
				}
			}
		});
		
		itemEditar.addActionListener(new ActionListener() { // opcion editar con doble click



			public void actionPerformed(ActionEvent arg0) {
				editando = true;
				tableloc.setAutoscrolls(false);
				tableloc.setEnabled(false);
				btnGuardarCambios.setVisible(true);
				btnCancelar.setVisible(true);
				btnEliminar.setVisible(false);
				btneditar.setVisible(false);
				respons.setEnabled(true);
				tipoLoc.setEnabled(true);
				codigo.setEditable(true);
				TitledBorder bordeConTitulo = BorderFactory.createTitledBorder(
						BorderFactory.createLineBorder(Colores.getBlancuzo(), 2, false),
						"Edición",
						TitledBorder.CENTER,
						TitledBorder.TOP,
						new Font("Tahoma", Font.BOLD, 26),
						Color.BLACK);
				panel.setBorder(bordeConTitulo);
				panel.setBackground(Colores.getBlancuzo());

			}
		});


		itemEliminar.addActionListener(new ActionListener() { // accion eliminar doble click


			@Override
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(null, "¿Eliminar este local?", "Confirmar", JOptionPane.YES_NO_OPTION);
				if (confirm == JOptionPane.YES_OPTION) {
					if(!fac.verificarRegistrosActivos(fac.getLocales().get(tableloc.convertRowIndexToModel(row)), null)){

					fac.getLocales().remove(row);
					tablemodel.setRowCount(0);
					tablemodel.cargarInfo(fac.getLocales());
					btnCancelar.setVisible(false);
					btnEliminar.setVisible(true);
					btnEliminar.setEnabled(true);
					btnGuardarCambios.setVisible(false);
					btneditar.setVisible(true);
					codigo.setEditable(false);
					respons.setEnabled(false);
					tipoLoc.setEnabled(false);
					JOptionPane.showMessageDialog(VerLocales.this, "Local eliminado con éxito", "Eliminación exitosa", JOptionPane.INFORMATION_MESSAGE);

				}else
					JOptionPane.showMessageDialog(VerLocales.this, "Hay registros sobre este local sin salida registrada", "Error al eliminar", JOptionPane.ERROR_MESSAGE);
				}
				}
		});
		
/////////////////////////////// LABEL Y TEXT FIELDS ////////////////////////////////////////////////////////////
		
		lblCodigo = new JLabel("C\u00F3digo:");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblCodigo.setBounds(46, 92, 143, 28);
		panel.add(lblCodigo);

		lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblTipo.setBounds(46, 161, 101, 32);
		panel.add(lblTipo);

		lblResponsable = new JLabel("Responsable:");
		lblResponsable.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblResponsable.setBounds(46, 236, 137, 32);
		panel.add(lblResponsable);

		codigo = new JTextField();
		codigo.setBackground(Color.WHITE);
		codigo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		codigo.setBounds(295, 84, 242, 42);
		panel.add(codigo);
		codigo.setColumns(10);

		tipoLoc = new JComboBox<TipoLocal>();
		tipoLoc.setBackground(Color.WHITE);
		tipoLoc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tipoLoc.setBounds(295, 154, 242, 42);
		panel.add(tipoLoc);
		tipoLoc.setModel(new DefaultComboBoxModel<>(TipoLocal.values()));

		respons = new JComboBox<>();
		respons.setBackground(Color.WHITE);
		respons.setFont(new Font("Tahoma", Font.PLAIN, 20));
		respons.setBounds(295, 229, 242, 42);
		panel.add(respons);
		respons.setModel(new DefaultComboBoxModel<>(fac.obtenerResponsables().toArray(new Persona[0])));
		
		
		errores = new JLabel("");
		errores.setForeground(Color.RED);
		errores.setVisible(true);
		errores.setFont(new Font("Tahoma", Font.PLAIN, 20));
		errores.setForeground(Color.RED);
		errores.setBounds(99, 541, 443, 22);
		panel.add(errores);
		
		
		
		mostrar(fac.getLocales().get(0));
		tablemodel.cargarInfo(fac.getLocales());

		
///////////////////////////////BOTON EDITAR ////////////////////////////////////////////////////////////
		btneditar = new JButton("Editar");
		btneditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				scrollPane.setEnabled(false);
				editando = true;
				tableloc.setAutoscrolls(false);
				tableloc.setEnabled(false);
				btnGuardarCambios.setVisible(true);
				btnCancelar.setVisible(true);
				btnEliminar.setVisible(false);
				btneditar.setVisible(false);
				respons.setEnabled(true);
				tipoLoc.setEnabled(true);
				codigo.setEditable(true);
				TitledBorder bordeConTitulo = BorderFactory.createTitledBorder(
						BorderFactory.createLineBorder(Colores.getBlancuzo(), 2, false),
						"Edición",
						TitledBorder.CENTER,
						TitledBorder.TOP,
						new Font("Tahoma", Font.BOLD, 26),
						Color.BLACK);
				panel.setBorder(bordeConTitulo);
//				panel.setBackground(Colores.getBlancuzo());
			}
		});
//		btneditar.addMouseListener(new MouseAdapter() {
//			public void mouseEntered(MouseEvent e) {
//
//				btneditar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
//			}
//			public void mouseExited(MouseEvent e) {
//
//				btneditar.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
//			}
//		});
		btneditar.setForeground(new Color(0, 0, 0));
		btneditar.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btneditar.setBounds(155, 577, 140, 41);
//		btneditar.setBackground(Color.WHITE);
		panel.add(btneditar);
		
/////////////////////////////// BOTON ELIMINAR  ////////////////////////////////////////////////////////////
		
		btnEliminar = new JButton("Eliminar");
//			btnEliminar.addMouseListener(new MouseAdapter() {
//				public void mouseEntered(MouseEvent e) {
//
//					btnEliminar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
//				}
//				public void mouseExited(MouseEvent e) {
//
//					btnEliminar.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
//				}
//			});
		btnEliminar.setForeground(new Color(0, 0, 0));
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnEliminar.setBounds(320, 577, 140, 41);
//		btnEliminar.setBackground(Color.WHITE);
		btnEliminar.setIcon(null);
		btnEliminar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(null, "¿Eliminar este local?", "Confirmar", JOptionPane.YES_NO_OPTION);
				if (confirm == JOptionPane.YES_OPTION) {
					if(!fac.verificarRegistrosActivos(fac.getLocales().get(tableloc.convertRowIndexToModel(row)), null)){

					fac.getLocales().remove(tableloc.convertRowIndexToModel(row));
					tablemodel.setRowCount(0);
					tablemodel.cargarInfo(fac.getLocales());
					btnCancelar.setVisible(false);
					btnEliminar.setVisible(true);
					btnEliminar.setEnabled(true);
					btnGuardarCambios.setVisible(false);
					btneditar.setVisible(true);
					codigo.setEditable(false);
					respons.setEnabled(false);
					tipoLoc.setEnabled(false);
					JOptionPane.showMessageDialog(VerLocales.this, "Local eliminado con éxito", "Eliminación exitosa", JOptionPane.INFORMATION_MESSAGE);

				}else
					JOptionPane.showMessageDialog(VerLocales.this, "Hay registros sobre este local sin salida registrada", "Error al eliminar", JOptionPane.ERROR_MESSAGE);
				}
				}
			

		});
		panel.add(btnEliminar);

		

/////////////////////////////// BOTON GUARDAR ////////////////////////////////////////////////////////////
		
		btnGuardarCambios = new JButton("Aceptar");
		panel.add(btnGuardarCambios);
		btnGuardarCambios.setForeground(new Color(0, 0, 0));
		btnGuardarCambios.setBounds(155, 577, 140, 41);
//		btnGuardarCambios.setBackground(Color.WHITE);
		btnGuardarCambios.setFocusPainted(false);
		btnGuardarCambios.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnGuardarCambios.setVisible(false);
		btnGuardarCambios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if(crearLoc(fac.getLocales().get(tableloc.convertRowIndexToModel(row)))){
					editando = false;
					agregar = false;
					codigo.setEditable(false);
					btneditar.setVisible(true);
					btnEliminar.setVisible(true);
					btnNewButton.setVisible(true);
					btnCancelar.setVisible(false);
					btnGuardarCambios.setVisible(false);
					respons.setEnabled(false);
					tipoLoc.setEnabled(false);
					tablemodel.setRowCount(0);
					tablemodel.cargarInfo(fac.getLocales());
					JOptionPane.showMessageDialog(VerLocales.this, "Información editada con éxito", "Edición exitosa", JOptionPane.INFORMATION_MESSAGE);

				}



			}
		});
		
		btnGuardarCambios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(java.awt.event.MouseEvent arg0) {
				btnGuardarCambios.setBackground(verdeHover);
				btnGuardarCambios.setForeground(Color.WHITE);
				btnGuardarCambios.setText("Aceptar");
			}
			@Override
			public void mouseExited(java.awt.event.MouseEvent arg0) {
				btnGuardarCambios.setBackground(Color.WHITE);
				btnGuardarCambios.setForeground(Color.BLACK);
				btnGuardarCambios.setText("Aceptar");
			}
		});
		
///////////////////////////////BOTON CANCELAR ////////////////////////////////////////////////////////////

		btnCancelar = new JButton("Cancelar");

		btnCancelar.setForeground(new Color(0, 0, 0));
		btnCancelar.setBounds(320, 577, 140, 41);
//		btnCancelar.setBackground(Color.WHITE);
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnCancelar.setVisible(false);
		panel.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {


				int confirm = JOptionPane.showConfirmDialog(null, "¿Desea cancelar sin guardar los cambios?", "Confirmar", JOptionPane.YES_NO_OPTION);
				if (confirm == JOptionPane.YES_OPTION) {
					editando = false;
					mostrar(fac.getLocales().get(tableloc.convertRowIndexToModel(row)));

					lblCodigo.setForeground(Color.black);
					errores.setVisible(false);
					btnNewButton.setVisible(true);
					btnCancelar.setVisible(false);
					btnEliminar.setVisible(true);
					btnEliminar.setEnabled(true);
					btnGuardarCambios.setVisible(false);
					btneditar.setVisible(true);
					codigo.setEditable(false);
					respons.setEnabled(false);
					tipoLoc.setEnabled(false);
					TitledBorder bordeConTitulo = BorderFactory.createTitledBorder(
							BorderFactory.createLineBorder(Colores.getBlancuzo(), 2, false),
							"Detalles del local",
							TitledBorder.CENTER,
							TitledBorder.TOP,
							new Font("Tahoma", Font.BOLD, 26),
							Color.BLACK);
					panel.setBorder(bordeConTitulo);
//					panel.setBackground(Colores.getBlancuzo());
				}
			}
		});
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(java.awt.event.MouseEvent arg0) {
				btnCancelar.setBackground(new Color(220, 53, 69));
				btnCancelar.setForeground(Color.WHITE);
				btnCancelar.setText("Cancelar");
			}
			@Override
			public void mouseExited(java.awt.event.MouseEvent arg0) {
				btnCancelar.setBackground(Color.WHITE);
				btnCancelar.setForeground(Color.BLACK);
				btnCancelar.setText("Cancelar");
			}
		});

		
/////////////////////////////// BOTON AGREGAR////////////////////////////////////////////////////////////

		btnAgregar = new JButton("Nuevo local");
		btnAgregar.setFocusPainted(false);
		btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 21));
//		btnAgregar.setBackground(new Color(240,240,240));
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				editando = true;
				tableloc.setEnabled(false);
				agregar = true;
				btnCancelar.setVisible(true);
				btnEliminar.setVisible(false);
				btnGuardarCambios.setVisible(true);
				btneditar.setVisible(false);
				codigo.setText("");
				codigo.setEditable(true);
				respons.setSelectedIndex(0);
				respons.setEnabled(true);
				tipoLoc.setEnabled(true);
				tipoLoc.setSelectedIndex(0);
				TitledBorder bordeConTitulo = BorderFactory.createTitledBorder(
						BorderFactory.createLineBorder(Colores.getBlancuzo(), 2, false),
						"Nuevo Local",
						TitledBorder.CENTER,
						TitledBorder.TOP,
						new Font("Tahoma", Font.BOLD, 26),
						Color.BLACK);
				panel.setBorder(bordeConTitulo);
//				panel.setBackground(Colores.getBlancuzo());
				btnNewButton.setVisible(false);

			}
		});
//		btnAgregar.addMouseListener(new MouseAdapter() {
//			public void mouseEntered(MouseEvent e) {
//
//				btnAgregar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
//			}
//			public void mouseExited(MouseEvent e) {
//
//				btnAgregar.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
//			}
//		});
		btnAgregar.setBounds(22, 28, 166, 36);
		contentPanel.add(btnAgregar);
		contentPanel.add(getBtnGenerarPdf());

		
		filtrado = new JTextField();
		filtrado.setBounds(426, 28, 189, 36);
		contentPanel.add(filtrado);
		filtrado.setColumns(10);
		final TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(tableloc.getModel());
		tableloc.setRowSorter(rowSorter);
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
		}
			
			
					
		



/////////////////////////////// BOTON SALIR  ////////////////////////////////////////////////////////////
	private JButton getBtnNewButton() {

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
			btnNewButton_1.setBounds(1187, 0, 47, 46);
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

	
/////////////////////////////// MOSTRAR INFORMACION  ////////////////////////////////////////////////////////////

	public void mostrar(Local l){

		codigo.setText(l.getCodigo());
		codigo.setEditable(false);
		tipoLoc.setSelectedItem(l.getTipo());
		tipoLoc.setEnabled(false);
		respons.setSelectedItem(l.getResponsable());
		respons.setEnabled(false);

	}
	
/////////////////////////////// CREAR Y EDITAR LOCALES  ////////////////////////////////////////////////////////////

	public boolean crearLoc(Local lo){
		String cod = codigo.getText();
		TipoLocal loc = (TipoLocal) tipoLoc.getSelectedItem();
		Persona res = (Persona) respons.getSelectedItem();
		boolean bien = true;

		Local l = new Local();
		Local existente = fac.buscarLocal(cod);

		if(agregar && existente != null){
			errores.setText("El local ya existe ");
			bien = false;

		}
		else if(!agregar && existente != null && !fac.getLocales().get(row).getCodigo().equals(cod)){
			errores.setText("Ya existe un local con ese codigo");
			bien = false;
		}
		else{
			if(bien){
				try{
					l.setCodigo(cod);
				}
				catch(IllegalArgumentException e){
					errores.setText("Faltan campos por llenar o est\u00E1n incorrectos");
					lblCodigo.setForeground(Color.RED);
					bien = false;
				}
				try{
					l.setResponsable(res);;
				}
				catch(IllegalArgumentException e){
					errores.setText("Faltan campos por llenar o est\u00E1n incorrectos");
					lblResponsable.setForeground(Color.RED);
					bien = false;
				}
				try{
					l.setTipo(loc);
				}
				catch(IllegalArgumentException e){
					errores.setText("Faltan campos por llenar o est\u00E1n incorrectos");
					lblTipo.setForeground(Color.RED);
					bien = false;
				}

			}
		}

		if(agregar && bien){
			fac.addLocal(cod, res, loc);
		}
		else if(!agregar && bien){
			lo.setCodigo(l.getCodigo());
			lo.setResponsable(l.getResponsable());
			lo.setTipo(l.getTipo());
		}


		return bien;
	}
	
	public static void generarPdf(DefaultTableModel modeloTabla, String rutaArchivo){
		Document document = new Document();
		
		try{
			PdfWriter.getInstance(document, new FileOutputStream(rutaArchivo));
			document.open();
			
			int numColumnas = modeloTabla.getColumnCount();
			PdfPTable table = new PdfPTable(numColumnas);
			
			for(int i = 0; i<numColumnas; i++){
				PdfPCell celda = new PdfPCell(new Paragraph(modeloTabla.getColumnName(i)));
				celda.setFixedHeight(25f);
				table.addCell(celda);
			}
			
			for(int fila=0; fila < modeloTabla.getRowCount(); fila++){
				for(int columna = 0; columna < numColumnas; columna++){
					Object valor = modeloTabla.getValueAt(fila, columna);
					PdfPCell celda = new PdfPCell(new Paragraph(valor != null ? valor.toString(): ""));
					celda.setFixedHeight(25f);
					table.addCell(celda);
				}
			}
			Paragraph subtitulo = new Paragraph("Locales de la Facultad de Ingeniería Informática: ");
	        subtitulo.setSpacingAfter(10f);
	        document.add(subtitulo);
			document.add(table);
			mostrarMensajePerzonalizado("Éxito", "PDF creado exitosamente en: " + rutaArchivo);
//			JOptionPane.showMessageDialog(null, "PDF creado exitosamente en: "+ rutaArchivo, "Éxito", JOptionPane.INFORMATION_MESSAGE);
		}catch(DocumentException | IOException e){
			mostrarMensajePerzonalizado("Error", "Error al crear el PDF: " + e.getMessage());
//			JOptionPane.showMessageDialog(null, "Error al crear el PDF: "+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}finally{
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
	private JButton getBtnGenerarPdf() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Generar PDF");
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 21));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JFileChooser fileChooser = new JFileChooser();
					fileChooser.setDialogTitle("Guardar PDF");
					fileChooser.setSelectedFile(new File("tablaLocales.pdf"));
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
						generarPdf(tablemodel, rutaArchivo);
					}
					
				}
			});
//			btnNewButton.addMouseListener(new MouseAdapter() {
//				public void mouseEntered(MouseEvent e) {
//
//					btnNewButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
//				}
//				public void mouseExited(MouseEvent e) {
//
//					btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
//				}
//			});
			btnNewButton.setBounds(212, 28, 166, 36);
		}
		return btnNewButton;
	}
}
