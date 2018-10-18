package modelo;

import javax.swing.JOptionPane;

public class Ejercicio2 {
	private int numero1;
	private int numero2;
	private TipoMultiplo resultado;
	
	public Ejercicio2(int numero1, int numero2) {
		this.numero1 = numero1;
		this.numero2 = numero2;
	}
	public Ejercicio2() {
	}
	
	public void calcular() {
		int a = this.numero1;
		int b = this.numero2;

		if      ((a % b) == 0) this.resultado = TipoMultiplo.A_MULTIPLO_DE_B;
		else if ((b % a) == 0) this.resultado = TipoMultiplo.B_MULTIPLO_DE_A;
		else                   this.resultado = TipoMultiplo.NO_SON_MULTIPLOS;

	}

	public int getNumero1() {
		return numero1;
	}

	public void setNumero1(int numero1) {
		this.numero1 = numero1;
	}

	public int getNumero2() {
		return numero2;
	}

	public void setNumero2(int numero2) {
		this.numero2 = numero2;
	}

	public TipoMultiplo getResultado() {
		return resultado;
	}
}
