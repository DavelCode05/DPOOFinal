package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTree;
import javax.swing.JEditorPane;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.SpinnerNumberModel;

import personas.Especialista;
import personas.Estudiante;
import personas.Profesor;
import personas.Tecnico;
import personas.Visitante;
import controllerClass.Facultad;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.time.LocalTime;

public class CambioHoras extends JDialog {

	private final JPanel contentPanel = new JPanel();
	JTabbedPane tabbedPane;
	JSpinner spinminsal;
	JSpinner spinhorasal;
	JSpinner spinminent;
	JSpinner spinhoraent;
	Facultad fac;
	JButton btnCancelar;
	JButton btnGuardar;
	JButton btnEditar;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			CambioHoras dialog = new CambioHoras();
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
	public CambioHoras(JFrame p) {
		super(p,"",false);
		fac = Facultad.getFacultad();
		setBounds(100, 100, 574, 350);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
	    tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	   
		tabbedPane.setBounds(22, 52, 526, 27);
		contentPanel.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Estudiantes", null, panel, null);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Profesores", null, panel_1, null);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Tecnicos", null, panel_2, null);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Especialistas", null, panel_3, null);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Visitantes", null, panel_4, null);
		
		JLabel lblHoraDeEntrada = new JLabel("Hora de entrada: ");
		lblHoraDeEntrada.setBounds(56, 113, 103, 14);
		contentPanel.add(lblHoraDeEntrada);
		
		JLabel lblHoraDeSalida = new JLabel("Hora de salida:");
		lblHoraDeSalida.setBounds(270, 113, 84, 14);
		contentPanel.add(lblHoraDeSalida);
		
		 spinhoraent = new JSpinner();
		spinhoraent.setModel(new SpinnerNumberModel(0, 0, 24, 1));
		spinhoraent.setBounds(22, 155, 46, 20);
		contentPanel.add(spinhoraent);
		
		 spinminent = new JSpinner();
		spinminent.setModel(new SpinnerNumberModel(0, 0, 60, 1));
		spinminent.setBounds(98, 155, 46, 20);
		contentPanel.add(spinminent);
		
		JLabel label = new JLabel(":");
		label.setBounds(82, 158, 46, 14);
		contentPanel.add(label);
		
		 spinhorasal = new JSpinner();
		spinhorasal.setBounds(255, 155, 46, 20);
		contentPanel.add(spinhorasal);
		
		 spinminsal = new JSpinner();
		spinminsal.setBounds(328, 155, 46, 20);
		contentPanel.add(spinminsal);
		
		JLabel label_1 = new JLabel(":");
		label_1.setBounds(312, 158, 46, 14);
		contentPanel.add(label_1);
		tabbedPane.setSelectedIndex(0);
		
		 btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				spinhoraent.setEnabled(true);
	    		spinhorasal.setEnabled(true);
	    		spinminent.setEnabled(true);
	    		spinminsal.setEnabled(true);
	    		btnGuardar.setVisible(true);
	    		btnCancelar.setVisible(true);
	    		btnEditar.setVisible(false);
	    		
			}
		});
		btnEditar.setBounds(39, 251, 89, 23);
		contentPanel.add(btnEditar);
		
		 btnGuardar = new JButton("guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int confirm = JOptionPane.showConfirmDialog(null, "¿Desea cambiar el horario de acceso de todos los " + tabbedPane.getTitleAt(tabbedPane.getSelectedIndex())+"?", "Confirmar", JOptionPane.YES_NO_OPTION);
				if (confirm == JOptionPane.YES_OPTION) {
				if(edicion()){
				
				spinhoraent.setEnabled(false);
	    		spinhorasal.setEnabled(false);
	    		spinminent.setEnabled(false);
	    		spinminsal.setEnabled(false);	
	    		btnGuardar.setVisible(false);
	    		btnCancelar.setVisible(false);
	    		btnEditar.setVisible(true);
				}
				}
				
			}
		});
		btnGuardar.setBounds(212, 251, 89, 23);
		contentPanel.add(btnGuardar);
		
		 btnCancelar = new JButton("cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int confirm = JOptionPane.showConfirmDialog(null, "¿Desea cancelar sin guardar los cambios?", "Confirmar", JOptionPane.YES_NO_OPTION);
				if (confirm == JOptionPane.YES_OPTION) {
				spinhoraent.setEnabled(false);
	    		spinhorasal.setEnabled(false);
	    		spinminent.setEnabled(false);
	    		spinminsal.setEnabled(false);
	    		llenar();
	    		btnGuardar.setVisible(false);
	    		btnCancelar.setVisible(false);
	    		btnEditar.setVisible(true);
				}
			}
		});
		btnCancelar.setBounds(335, 251, 89, 23);
		contentPanel.add(btnCancelar);
		llenar();
		btnGuardar.setVisible(false);
		btnCancelar.setVisible(false);
		
		 tabbedPane.addChangeListener(new ChangeListener() {
		    	public void stateChanged(ChangeEvent arg0) {
		    		llenar();
		    		
		    	}
		    });
	}
	
	
	public void llenar (){
		
		int index = tabbedPane.getSelectedIndex();
		
		if(index ==0){
			spinhoraent.setValue(Estudiante.getHoraEntradaEst().getHour());
			spinhorasal.setValue(Estudiante.getHoraSalidaEst().getHour());
			spinminent.setValue(Estudiante.getHoraEntradaEst().getMinute());
			spinminsal.setValue(Estudiante.getHoraSalidaEst().getMinute());
		}else if(index==1){
			spinhoraent.setValue(Profesor.getHoraEntradaProf().getHour());
			spinhorasal.setValue(Profesor.getHoraSalidaProf().getHour());
			spinminent.setValue(Profesor.getHoraEntradaProf().getMinute());
			spinminsal.setValue(Profesor.getHoraSalidaProf().getMinute());
			
		}
		else if(index==3){
			spinhoraent.setValue(Especialista.getHoraEntradaEsp().getHour());
			spinhorasal.setValue(Especialista.getHoraSalidaEsp().getHour());
			spinminent.setValue(Especialista.getHoraEntradaEsp().getMinute());
			spinminsal.setValue(Especialista.getHoraSalidaEsp().getMinute());
		}
		else if(index==2){
			spinhoraent.setValue(Tecnico.getHoraEntradaTec().getHour());
			spinhorasal.setValue(Tecnico.getHoraSalidaTec().getHour());
			spinminent.setValue(Tecnico.getHoraEntradaTec().getMinute());
			spinminsal.setValue(Tecnico.getHoraSalidaTec().getMinute());
			
		}
		else if(index == 4){
			spinhoraent.setValue(Visitante.getHoraEntradaVis().getHour());
			spinhorasal.setValue(Visitante.getHoraSalidaVis().getHour());
			spinminent.setValue(Visitante.getHoraEntradaVis().getMinute());
			spinminsal.setValue(Visitante.getHoraSalidaVis().getMinute());	
		}
		spinhoraent.setEnabled(false);
		spinhorasal.setEnabled(false);
		spinminent.setEnabled(false);
		spinminsal.setEnabled(false);
		
	}
	
	public boolean edicion(){
		LocalTime entrada = LocalTime.of( (int)spinhoraent.getValue(),(int) spinminent.getValue());
		LocalTime salida = LocalTime.of( (int)spinhorasal.getValue(),(int) spinminsal.getValue());
		
		boolean bien = false;
		if(entrada.isAfter(salida)){
			bien = false;
			JOptionPane.showMessageDialog(this, "Error: la hora de salida no puede estar antes q la hora de entrada", "Confirmar", JOptionPane.ERROR_MESSAGE);
			
		}
		else{
			bien = true;
		
		int index = tabbedPane.getSelectedIndex();
		
		if(index ==0){
			Estudiante.setHoraEntradaEst(entrada);
			Estudiante.setHoraSalidaEst(salida);
		}else if(index==1){
			Profesor.setHoraEntradaProf(entrada);
			Profesor.setHoraSalidaProf(salida);
			
		}
		else if(index==3){
			Especialista.setHoraEntradaEsp(entrada);
			Especialista.setHoraSalidaEsp(salida);
		}
		else if(index==2){
			Tecnico.setHoraEntradaTec(entrada);
			Tecnico.setHoraSalidaTec(salida);
			
		}
		else if(index == 4){
			Visitante.setHoraEntradaVis(entrada);
			Visitante.setHoraSalidaVis(salida);
		}
		}
		
		return bien;
	}
}
