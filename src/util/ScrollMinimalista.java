package util;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

public class ScrollMinimalista extends BasicScrollBarUI {
    @Override
    protected void configureScrollBarColors() {
        this.thumbColor = new Color(120, 140, 180, 200); // azul grisáceo
        this.trackColor = new Color(0, 0, 0, 0); // transparente
    }

    @Override
    protected JButton createDecreaseButton(int orientation) {
        return crearBotonInvisible();
    }

    @Override
    protected JButton createIncreaseButton(int orientation) {
        return crearBotonInvisible();
    }

    private JButton crearBotonInvisible() {
        JButton boton = new JButton();
        boton.setPreferredSize(new Dimension(0, 0));
        boton.setVisible(false);
        return boton;
    }
}
