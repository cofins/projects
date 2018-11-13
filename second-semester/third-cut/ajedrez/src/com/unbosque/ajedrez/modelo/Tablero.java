package com.unbosque.ajedrez.modelo;

public class Tablero {

    private int[][] posiciones;
    private Pieza alfil;
    private Pieza rey;

    public Tablero() {
        this.alfil = new Pieza(3, "Alfil");
        this.rey = new Pieza(10, "Rey");
        this.limpiarTablero();
    }

    public void moverPieza(int id, int fila, int columna) {
        this.posiciones[fila][columna] = id;
        Pieza pieza = this.obtenerPieza(id);
        pieza.setFila(fila);
        pieza.setColumna(columna);
    }

    public void limpiarTablero() {
        this.posiciones = new int[8][8];
    }

    public boolean jaqueMate() {
        for (int i = 0,
             x1 = this.alfil.getFila(),
             x2 = x1,
             x3 = x1,
             x4 = x1,
             y1 = this.alfil.getColumna(),
             y2 = y1,
             y3 = y1,
             y4 = y1; i < 8; i++) {


            if (this.posiciones[x1][y1] == this.rey.getId() ||
                    this.posiciones[x2][y2] == this.rey.getId() ||
                    this.posiciones[x3][y3] == this.rey.getId() ||
                    this.posiciones[x4][y4] == this.rey.getId()) return true;

            if (x1 < 7 && y1 > 0) { ++x1; --y1;  }
            if (x2 < 7 && y2 < 7) { ++x2; ++y2;  }
            if (x3 > 0 && y3 > 0) { --x3; --y3;  }
            if (x4 > 0 && y4 < 7) { --x4; ++y4;  }
        }
        return false;
    }

    private Pieza obtenerPieza(int id) {
        Pieza pieza = null;
        switch (id) {
            case 3:  pieza = this.alfil; break;
            case 10: pieza = this.rey; break;
        }
        return pieza;
    }
}
