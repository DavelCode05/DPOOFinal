package interfaz;

import javax.swing.*;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;

import personas.Persona;

import javax.swing.*;

import acceso.Registro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.List;

public class Notificador {
    private Timer timer;
    private ArrayList<Registro> registros;
    private DefaultListModel<String> modeloNotificaciones;
    private JButton fo;

    public Notificador(ArrayList<Registro> registros, DefaultListModel<String> modeloNotificaciones, JButton foto) {
        this.registros = registros;
        fo = foto;
        this.modeloNotificaciones = modeloNotificaciones;
        iniciarTemporizador();
        
    }

    private void iniciarTemporizador() {
        // Timer que se ejecuta cada 60,000 ms (1 minuto)
        timer = new Timer(60000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verificarHorasSalida();
            }
        });
        timer.start(); // Inicia el timer
        System.out.println(" Notificador INICIADO. Verificando cada minuto...");
        
    }

    private void verificarHorasSalida() {
        LocalTime ahora = LocalTime.now();
        System.out.println(" Hora actual: " + ahora); // Debug
        for (Registro r : registros) {
            if (r.getHoraSalida()==null && ahora.isAfter(r.getPersona().getHoraSalida())) {
                String mensaje = " " + r.getPersona().getNombre() + " debió salir a las " + r.getPersona().getHoraSalida();
                if (!modeloNotificaciones.contains(mensaje)) { // Evita duplicados
                    modeloNotificaciones.addElement(mensaje);
                    Toolkit.getDefaultToolkit().beep(); // Sonido de alerta
                    fo.setIcon(new ImageIcon(Inicio.class.getResource("/images/admin.png")));
                    System.out.println(" Notificación añadida: " + mensaje); // Debug
                }
            }
        }
    }
    
    

    // Para detener el timer si cierras la aplicación
    public void detener() {
        if (timer != null) {
            timer.stop();
        }
    }
    
   
}

