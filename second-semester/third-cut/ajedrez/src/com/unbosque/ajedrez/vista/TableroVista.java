package com.unbosque.ajedrez.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TableroVista extends JFrame {

    public static final String BOTON_JAQUE_MATE = "dsfdsas";
    private JTextField[][] tablero;
    private JButton botonJaqueMate;

    public TableroVista(ActionListener controladorTablero) {
        this.setLayout(new BorderLayout());

        JPanel matriz = new JPanel(new GridLayout(8,8));
        this.tablero = new JTextField[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                this.tablero[i][j] = new JTextField();
                matriz.add(this.tablero[i][j]);
            }
        }
        this.add(matriz, BorderLayout.CENTER);

        this.botonJaqueMate= new JButton("jaque mate ???");
        this.botonJaqueMate.setActionCommand(BOTON_JAQUE_MATE);
        this.botonJaqueMate.addActionListener(controladorTablero);
        this.add(this.botonJaqueMate, BorderLayout.SOUTH);
        this.setTitle("mini ajedrez");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 520);
    }


    public int getPieza(int i, int j) {
        String texto = this.tablero[i][j].getText();
        return texto.isEmpty() ? -1 : Integer.parseInt(texto);
    }

    public void mostraMensaje() {
        JOptionPane.showMessageDialog(this, "Opsss", "Jaque mate",JOptionPane.INFORMATION_MESSAGE);
    }
}
