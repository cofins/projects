package modelo;

import javax.swing.JOptionPane;

public class Ejercicio3 {
	private int numero;
	private int resultado;

	public Ejercicio3(int numero) {
		super();
		this.numero = numero;
	}

	public Ejercicio3() {
		
	}

	public void calcular() {
		int a = numero;
		int c = 0;

		while ((a = (a / 10)) > 0)
			++c;
		++c;

		this.resultado = c;

	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getResultado() {
		return resultado;
	}


}