package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.CardLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import util.JTextFieldCarnet;
import util.JTextFieldGrupo;
import util.JTextFieldString;
import enums.Plaza;
import enums.TipoContrato;
import enums.TipoLocal;
import javax.swing.ImageIcon;

public class CRUDVerPersonal extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblNombreYApellidos;
	private JTextFieldString textField;
	private JLabel lblNewLabel;
	private JTextFieldCarnet textField_1;
	private JComboBox comboBox;
	private JLabel lblPlaza;
	private JButton btnEditar;
	private JButton btnEliminar;
	private JButton btnGuardarCambios;
	private JButton btnCancelar;
	private CardLayout card;
	private JPanel panelGeneral;
	private JPanel panelAdmin;
	private JPanel panelDirectivo;
	private JLabel lblDepartamento;
	private JTextFieldString textField_2;
	private JLabel lblCategoriaDocente;
	private JLabel lblCategoriaCientifica;
	private JLabel lblTipoDeContrato;
	private JComboBox comboBox_1;
	private JLabel lblCargoAdministrativo;
	private JComboBox comboBox_2;
	private JLabel lblreaDeTrabajo;
	private JComboBox comboBox_3;
	private JTextFieldString textFieldString;
	private JTextFieldString textFieldString_1;
	private JPanel panelProfesor;
	private JLabel label;
	private JTextFieldString textFieldString_2;
	private JLabel label_1;
	private JTextFieldString textFieldString_3;
	private JLabel label_2;
	private JTextFieldString textFieldString_4;
	private JLabel label_3;
	private JComboBox comboBox_4;
	private JPanel panelEspecialista;
	private JTextFieldString textFieldString_5;
	private JLabel lblProyecto;
	private JPanel panelEstudiante;
	private JComboBox comboBox_5;
	private JLabel lblAo;
	private JLabel lblGrupo;
	private JTextFieldGrupo textField_3;
	private JPanel panelTecnico;
	private JTextFieldString textFieldString_6;
	private JLabel lblPlaza_1;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CRUDVerPersonal dialog = new CRUDVerPersonal();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CRUDVerPersonal() {
		setBounds(100, 100, 575, 576);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		card = new CardLayout(0,0);
		contentPanel.setLayout(null);
		{
			contentPanel.add(getLblNombreYApellidos());
			contentPanel.add(getTextField());
			contentPanel.add(getLblNewLabel());
			contentPanel.add(getTextField_1());
			contentPanel.add(getBtnEditar());
			contentPanel.add(getBtnEliminar());
			contentPanel.add(getBtnGuardarCambios());
			contentPanel.add(getBtnCancelar());
			
		}
		contentPanel.add(getPanelGeneral());
		contentPanel.add(getBtnNewButton());
	}
	private JLabel getLblNombreYApellidos() {
		if (lblNombreYApellidos == null) {
			lblNombreYApellidos = new JLabel("Nombre");
			lblNombreYApellidos.setBounds(46, 44, 77, 16);
		}
		return lblNombreYApellidos;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextFieldString();
			textField.setBounds(41, 65, 116, 22);
			textField.setColumns(10);
		}
		return textField;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Carnet de Identidad");
			lblNewLabel.setBounds(216, 44, 113, 16);
		}
		return lblNewLabel;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextFieldCarnet();
			textField_1.setColumns(10);
			textField_1.setBounds(213, 65, 116, 22);
		}
		return textField_1;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setBounds(25, 48, 107, 22);
			comboBox.setModel(new DefaultComboBoxModel<>(Plaza.values()));
			
		}
		return comboBox;
	}
	private JLabel getLblPlaza() {
		if (lblPlaza == null) {
			lblPlaza = new JLabel("Plaza");
			lblPlaza.setBounds(25, 27, 56, 16);
		}
		return lblPlaza;
	}
	private JButton getBtnEditar() {
		if (btnEditar == null) {
			btnEditar = new JButton("");
			btnEditar.setIcon(new ImageIcon(CRUDVerPersonal.class.getResource("/images/editar.png")));
			btnEditar.setBounds(366, 13, 46, 50);
		}
		return btnEditar;
	}
	private JButton getBtnEliminar() {
		if (btnEliminar == null) {
			btnEliminar = new JButton("Icono Borrar");
			btnEliminar.setBounds(438, 13, 109, 25);
		}
		return btnEliminar;
	}
	private JButton getBtnGuardarCambios() {
		if (btnGuardarCambios == null) {
			btnGuardarCambios = new JButton("Guardar cambios");
			btnGuardarCambios.setBounds(289, 466, 150, 25);
		}
		return btnGuardarCambios;
	}
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setBounds(438, 466, 97, 25);
		}
		return btnCancelar;
	}
	private JPanel getPanelGeneral() {
		if (panelGeneral == null) {
			panelGeneral = new JPanel();
			panelGeneral.setBounds(27, 110, 475, 319);
			panelGeneral.setLayout(card);
			panelGeneral.add(getPanelAdmin(), "Administrativo");
			panelGeneral.add(getPanelDirectivo(), "Directivo");
			panelGeneral.add(getPanelProfesor(), "Profesor");
			panelGeneral.add(getPanelEspecialista(), "Especialista");
			panelGeneral.add(getPanelEstudiante(), "Estudiante");
			panelGeneral.add(getPanelTecnico(), "Tecnico");
		}
		return panelGeneral;
	}
	private JPanel getPanelAdmin() {
		if (panelAdmin == null) {
			panelAdmin = new JPanel();
			panelAdmin.setLayout(null);
			panelAdmin.add(getLblPlaza());
			panelAdmin.add(getComboBox());
		}
		return panelAdmin;
	}
	private JPanel getPanelDirectivo() {
		if (panelDirectivo == null) {
			panelDirectivo = new JPanel();
			panelDirectivo.setLayout(null);
			panelDirectivo.add(getLblDepartamento());
			panelDirectivo.add(getTextField_2());
			panelDirectivo.add(getLblCategoriaDocente());
			panelDirectivo.add(getLblCategoriaCientifica());
			panelDirectivo.add(getLblTipoDeContrato());
			panelDirectivo.add(getComboBox_1());
			panelDirectivo.add(getLblCargoAdministrativo());
			panelDirectivo.add(getComboBox_2());
			panelDirectivo.add(getLblreaDeTrabajo());
			panelDirectivo.add(getComboBox_3());
			panelDirectivo.add(getTextFieldString());
			panelDirectivo.add(getTextFieldString_1());
		}
		return panelDirectivo;
	}
	private JLabel getLblDepartamento() {
		if (lblDepartamento == null) {
			lblDepartamento = new JLabel("Departamento");
			lblDepartamento.setBounds(12, 25, 116, 16);
		}
		return lblDepartamento;
	}
	private JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextFieldString();
			textField_2.setBounds(12, 54, 116, 22);
			textField_2.setColumns(10);
		}
		return textField_2;
	}
	private JLabel getLblCategoriaDocente() {
		if (lblCategoriaDocente == null) {
			lblCategoriaDocente = new JLabel("Categoria Docente");
			lblCategoriaDocente.setBounds(12, 101, 116, 16);
		}
		return lblCategoriaDocente;
	}
	private JLabel getLblCategoriaCientifica() {
		if (lblCategoriaCientifica == null) {
			lblCategoriaCientifica = new JLabel("Categoria Cientifica");
			lblCategoriaCientifica.setBounds(12, 180, 116, 16);
		}
		return lblCategoriaCientifica;
	}
	private JLabel getLblTipoDeContrato() {
		if (lblTipoDeContrato == null) {
			lblTipoDeContrato = new JLabel("Tipo de contrato");
			lblTipoDeContrato.setBounds(193, 25, 116, 16);
		}
		return lblTipoDeContrato;
	}
	private JComboBox getComboBox_1() {
		if (comboBox_1 == null) {
			comboBox_1 = new JComboBox();
			comboBox_1.setBounds(193, 54, 158, 22);
			comboBox_1.setModel(new DefaultComboBoxModel<>(TipoContrato.values()));
		}
		return comboBox_1;
	}
	private JLabel getLblCargoAdministrativo() {
		if (lblCargoAdministrativo == null) {
			lblCargoAdministrativo = new JLabel("Cargo de Direcci\u00F3n");
			lblCargoAdministrativo.setBounds(193, 101, 116, 16);
		}
		return lblCargoAdministrativo;
	}
	private JComboBox getComboBox_2() {
		if (comboBox_2 == null) {
			comboBox_2 = new JComboBox();
			comboBox_2.setBounds(193, 130, 158, 22);
		}
		return comboBox_2;
	}
	private JLabel getLblreaDeTrabajo() {
		if (lblreaDeTrabajo == null) {
			lblreaDeTrabajo = new JLabel("\u00C1rea de trabajo");
			lblreaDeTrabajo.setBounds(193, 180, 116, 16);
		}
		return lblreaDeTrabajo;
	}
	private JComboBox getComboBox_3() {
		if (comboBox_3 == null) {
			comboBox_3 = new JComboBox();
			comboBox_3.setBounds(193, 209, 158, 22);
		}
		return comboBox_3;
	}
	private JTextFieldString getTextFieldString() {
		if (textFieldString == null) {
			textFieldString = new JTextFieldString();
			textFieldString.setBounds(12, 130, 116, 22);
		}
		return textFieldString;
	}
	private JTextFieldString getTextFieldString_1() {
		if (textFieldString_1 == null) {
			textFieldString_1 = new JTextFieldString();
			textFieldString_1.setBounds(12, 209, 116, 22);
		}
		return textFieldString_1;
	}
	private JPanel getPanelProfesor() {
		if (panelProfesor == null) {
			panelProfesor = new JPanel();
			panelProfesor.setLayout(null);
			panelProfesor.add(getLabel());
			panelProfesor.add(getTextFieldString_2());
			panelProfesor.add(getLabel_1());
			panelProfesor.add(getTextFieldString_3());
			panelProfesor.add(getLabel_2());
			panelProfesor.add(getTextFieldString_4());
			panelProfesor.add(getLabel_3());
			panelProfesor.add(getComboBox_4());
		}
		return panelProfesor;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("Departamento");
			label.setBounds(28, 32, 116, 16);
		}
		return label;
	}
	private JTextFieldString getTextFieldString_2() {
		if (textFieldString_2 == null) {
			textFieldString_2 = new JTextFieldString();
			textFieldString_2.setColumns(10);
			textFieldString_2.setBounds(28, 61, 116, 22);
		}
		return textFieldString_2;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("Categoria Docente");
			label_1.setBounds(28, 108, 116, 16);
		}
		return label_1;
	}
	private JTextFieldString getTextFieldString_3() {
		if (textFieldString_3 == null) {
			textFieldString_3 = new JTextFieldString();
			textFieldString_3.setBounds(28, 137, 116, 22);
		}
		return textFieldString_3;
	}
	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("Categoria Cientifica");
			label_2.setBounds(28, 187, 116, 16);
		}
		return label_2;
	}
	private JTextFieldString getTextFieldString_4() {
		if (textFieldString_4 == null) {
			textFieldString_4 = new JTextFieldString();
			textFieldString_4.setBounds(28, 216, 116, 22);
		}
		return textFieldString_4;
	}
	private JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel("Tipo de contrato");
			label_3.setBounds(209, 32, 116, 16);
		}
		return label_3;
	}
	private JComboBox getComboBox_4() {
		if (comboBox_4 == null) {
			comboBox_4 = new JComboBox();
			comboBox_4.setBounds(209, 61, 158, 22);
		}
		return comboBox_4;
	}
	private JPanel getPanelEspecialista() {
		if (panelEspecialista == null) {
			panelEspecialista = new JPanel();
			panelEspecialista.setLayout(null);
			panelEspecialista.add(getTextFieldString_5());
			panelEspecialista.add(getLblProyecto());
		}
		return panelEspecialista;
	}
	private JTextFieldString getTextFieldString_5() {
		if (textFieldString_5 == null) {
			textFieldString_5 = new JTextFieldString();
			textFieldString_5.setBounds(12, 64, 121, 22);
		}
		return textFieldString_5;
	}
	private JLabel getLblProyecto() {
		if (lblProyecto == null) {
			lblProyecto = new JLabel("Proyecto");
			lblProyecto.setBounds(12, 35, 56, 16);
		}
		return lblProyecto;
	}
	private JPanel getPanelEstudiante() {
		if (panelEstudiante == null) {
			panelEstudiante = new JPanel();
			panelEstudiante.setLayout(null);
			panelEstudiante.add(getComboBox_5());
			panelEstudiante.add(getLblAo());
			panelEstudiante.add(getLblGrupo());
			panelEstudiante.add(getTextField_3());
		}
		return panelEstudiante;
	}
	private JComboBox getComboBox_5() {
		if (comboBox_5 == null) {
			comboBox_5 = new JComboBox();
			comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
			comboBox_5.setBounds(12, 60, 43, 22);
		}
		return comboBox_5;
	}
	private JLabel getLblAo() {
		if (lblAo == null) {
			lblAo = new JLabel("A\u00F1o");
			lblAo.setBounds(12, 31, 56, 16);
		}
		return lblAo;
	}
	private JLabel getLblGrupo() {
		if (lblGrupo == null) {
			lblGrupo = new JLabel("Grupo");
			lblGrupo.setBounds(12, 100, 56, 16);
		}
		return lblGrupo;
	}
	private JTextField getTextField_3() {
		if (textField_3 == null) {
			textField_3 = new JTextFieldGrupo();
			textField_3.setBounds(12, 129, 56, 22);
			textField_3.setColumns(10);
		}
		return textField_3;
	}
	private JPanel getPanelTecnico() {
		if (panelTecnico == null) {
			panelTecnico = new JPanel();
			panelTecnico.setLayout(null);
			panelTecnico.add(getTextFieldString_6());
			panelTecnico.add(getLblPlaza_1());
		}
		return panelTecnico;
	}
	private JTextFieldString getTextFieldString_6() {
		if (textFieldString_6 == null) {
			textFieldString_6 = new JTextFieldString();
			textFieldString_6.setBounds(26, 45, 84, 22);
		}
		return textFieldString_6;
	}
	private JLabel getLblPlaza_1() {
		if (lblPlaza_1 == null) {
			lblPlaza_1 = new JLabel("Plaza");
			lblPlaza_1.setBounds(26, 16, 56, 16);
		}
		return lblPlaza_1;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("");
			btnNewButton.setIcon(new ImageIcon(CRUDVerPersonal.class.getResource("/images/exitIzquierda.png")));
			btnNewButton.setBounds(12, 20, 19, 18);
		}
		return btnNewButton;
	}
}
