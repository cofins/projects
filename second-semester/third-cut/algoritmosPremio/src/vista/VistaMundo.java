package vista;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class VistaMundo extends JFrame {

	private Ejercicio1Vista ejercicio1Vista;
	private Ejercicio2Vista ejercicio2Vista;
	private Ejercicio3Vista ejercicio3Vista;
	
	public VistaMundo(ActionListener listener) {
		this.setSize(500, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.ejercicio1Vista = new Ejercicio1Vista(listener);
		this.ejercicio2Vista = new Ejercicio2Vista(listener);
		this.ejercicio3Vista = new Ejercicio3Vista(listener);
		this.setLayout(new GridLayout(3, 1));
		this.add(ejercicio1Vista);
		this.add(ejercicio2Vista);
		this.add(ejercicio3Vista);
	}

	public Ejercicio1Vista getEjercicio1Vista() {
		return ejercicio1Vista;
	}
	
	public Ejercicio2Vista getEjercicio2Vista() {
		return ejercicio2Vista;
	}
	
	public Ejercicio3Vista getEjercicio3Vista() {
		return ejercicio3Vista;
	}
	
	
	
	
}
