package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.Mundo;
import vista.Ejercicio1Vista;
import vista.Ejercicio2Vista;
import vista.Ejercicio3Vista;
import vista.VistaMundo;

public class Principal implements ActionListener {

	private VistaMundo vista;
	private Mundo modelo;
	
	public Principal() {
		modelo = new Mundo();
		vista = new VistaMundo(this);
		vista.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case Ejercicio1Vista.EJERCICIO1_BOTON_CALCULAR: {
			int numero1 = this.vista.getEjercicio1Vista().getNumero1();
			int numero2 = this.vista.getEjercicio1Vista().getNumero2();
			this.modelo.setParametrosEjercicio1(numero1, numero2);
			this.modelo.calcularEjercicio1();
			this.vista.getEjercicio1Vista().setNumero1(this.modelo.getResultados1()[0]);
			this.vista.getEjercicio1Vista().setNumero2(this.modelo.getResultados1()[1]);
		}
			break;

		case Ejercicio2Vista.EJERCICIO2_BOTON_CALCULAR: {
			int numero1 = this.vista.getEjercicio2Vista().getNumero1();
			int numero2 = this.vista.getEjercicio2Vista().getNumero2();
			this.modelo.setParametrosEjercicio2(numero1, numero2);
			this.modelo.calcularEjercicio2();
			this.vista.getEjercicio2Vista().setResultado(this.modelo.getResultado2().toString());
		}
			break;
				
		case Ejercicio3Vista.EJERCICIO3_BOTON_CALCULAR: {
			int numero = this.vista.getEjercicio3Vista().getNumero();
			this.modelo.setParametrosEjercicio3(numero);
			this.modelo.calcularEjercicio3();
			this.vista.getEjercicio3Vista().setResultado("Numero de digitos: " +this.modelo.getResultado3());
		}
			break;

		default:
			break;
		}

	}

	public static void main(String[] args) {
		Principal p = new Principal();
	}

}
