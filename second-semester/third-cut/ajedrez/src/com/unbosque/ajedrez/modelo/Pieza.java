package com.unbosque.ajedrez.modelo;

public class Pieza {

    private int id;
    private String nombre;
    private int fila;
    private int columna;

    public Pieza(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}
