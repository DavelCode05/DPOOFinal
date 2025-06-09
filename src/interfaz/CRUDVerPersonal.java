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
import util.JTextFieldString;
import enums.Plaza;
import enums.TipoContrato;
import enums.TipoLocal;

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
	private JButton btnNewButton;
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
			contentPanel.add(getBtnNewButton());
			contentPanel.add(getBtnCancelar());
			
		}
		contentPanel.add(getPanelGeneral());
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
			btnEditar = new JButton("icono Editar");
			btnEditar.setBounds(328, 13, 108, 25);
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
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Icono salir");
			btnNewButton.setBounds(12, 13, 97, 25);
		}
		return btnNewButton;
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
}
