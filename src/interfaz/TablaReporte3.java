package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.time.LocalDate;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;

import util.EntradasTable;

import javax.swing.JScrollPane;
import javax.swing.JProgressBar;

import controllerClass.Facultad;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JComboBox;

import locales.Local;

import com.toedter.calendar.JDateChooser;

public class TablaReporte3 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	EntradasTable tableModel ;
	Facultad fac;
	private JTable table;


	public TablaReporte3(LocalDate dia, Local l, JDialog padre) {
		super(padre, "Entradas a la facultad", true);
		fac= Facultad.getFacultad();
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 260, 434, 1);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 78, 414, 171);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(216, 191, 216));
		scrollPane.setViewportView(table);
		
		tableModel = new EntradasTable(fac.entradaALaFAcuPorHoras(dia, l));
		table.setModel(tableModel);
		
		JLabel lblLocal = new JLabel("Local:");
		lblLocal.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblLocal.setBounds(21, 33, 46, 14);
		getContentPane().add(lblLocal);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblFecha.setBounds(267, 33, 46, 14);
		getContentPane().add(lblFecha);
		
		JLabel lblllloc = new JLabel("");
		lblllloc.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblllloc.setBounds(77, 33, 98, 14);
		getContentPane().add(lblllloc);
		lblllloc.setText(l.getTipo().name());
		
		JLabel lblllfecha = new JLabel("");
		lblllfecha.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblllfecha.setBounds(323, 33, 81, 14);
		getContentPane().add(lblllfecha);
		lblllfecha.setText(dia.toString());
		
		
	}
	
}
