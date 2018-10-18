package modelo;

public class Mundo {

	private Ejercicio1 ejercicio1;
	private Ejercicio2 ejercicio2;
	private Ejercicio3 ejercicio3;

	public Mundo() {
		this.ejercicio1 = new Ejercicio1();
		this.ejercicio2 = new Ejercicio2();
		this.ejercicio3 = new Ejercicio3();
	}

	public void setParametrosEjercicio1(int numero1, int numero2) {
		this.ejercicio1 = new Ejercicio1(numero1, numero2);
	}

	public void calcularEjercicio1() {
		this.ejercicio1.calcular();
	}

	public int[] getResultados1() {
		return new int[] { this.ejercicio1.getNumero1(), this.ejercicio1.getNumero2() };
	}

	public void setParametrosEjercicio2(int numero1, int numero2) {
		this.ejercicio2 = new Ejercicio2(numero1, numero2);
	}

	public void calcularEjercicio2() {
		this.ejercicio2.calcular();
	}
	
	public TipoMultiplo getResultado2() {
		return this.ejercicio2.getResultado();
	}

	public void setParametrosEjercicio3(int numero1) {
		this.ejercicio3 = new Ejercicio3(numero1);
	}

	public void calcularEjercicio3() {
		this.ejercicio3.calcular();
	}
	
	public int getResultado3() {
		return this.ejercicio3.getResultado();
	}
	
	

}
