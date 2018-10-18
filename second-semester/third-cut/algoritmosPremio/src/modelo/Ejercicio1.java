package modelo;

public class Ejercicio1 {

	private int numero1;
	private int numero2;

	public Ejercicio1(int numero1, int numero2) {
		this.numero1 = numero1;
		this.numero2 = numero2;
	}
	public Ejercicio1() {
	}

	public void calcular() {
		int a = this.numero1;
		int b = this.numero2;
		a = a + b;
		b = a - b;
		a = a - b;
		this.numero1 = a;
		this.numero2 = b;
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

}
