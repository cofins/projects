package com.unbosque.ajedrez.controlador;

import com.unbosque.ajedrez.modelo.Tablero;
import com.unbosque.ajedrez.vista.TableroVista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorTablero implements ActionListener {

    private Tablero tableroModelo;
    private TableroVista tableroVista;

    public ControladorTablero() {
        this.tableroModelo = new Tablero();
        this.tableroVista = new TableroVista(this);
        this.tableroVista.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        switch (actionEvent.getActionCommand()) {
            case TableroVista.BOTON_JAQUE_MATE:
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        if (this.tableroVista.getPieza(i, j) == -1) continue;

                        this.tableroModelo.moverPieza(this.tableroVista.getPieza(i,j), i, j);
                    }
                }
                if(this.tableroModelo.jaqueMate()) {
                    this.tableroVista.mostraMensaje();
                }
                this.tableroModelo.limpiarTablero();
                break;
        }
    }
}
