package vista;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Tabla extends JPanel {

	private JTextArea[] intentos;
	private JTextArea[] numero;
	private int num;

	public Tabla() {
		num = 1;
		setLayout(new GridLayout(11, 2, 5, 5));
		intentos = new JTextArea[11];
		numero = new JTextArea[11];
		agregar();
	}

	private void agregar() {

		intentos[0] = new JTextArea("INTENTOS");
		intentos[0].setBorder(PicaFijaVista.B);
		intentos[0].setEditable(false);
		add(intentos[0]);

		numero[0] = new JTextArea("NUMERO");
		add(numero[0]);
		numero[0].setEditable(false);
		numero[0].setBorder(PicaFijaVista.B);
		for (int i = 1; i < 11; i++) {
			intentos[i] = new JTextArea("Intento " + i);
			add(intentos[i]);
			intentos[i].setEditable(false);
			intentos[i].setBorder(PicaFijaVista.B);
			numero[i] = new JTextArea("Intento # " + i);
			add(numero[i]);
			numero[i].setBorder(PicaFijaVista.B);
			numero[i].setEditable(false);
		}
	}

	public void agregarIntento(int i) {
		numero[num].setText(String.valueOf(i));
		num++;
	}

	public void reiniciar() {
		for (int i = 1; i < intentos.length; i++) {
			numero[i].setText(("Intento # " + String.valueOf(i)));
		}
		num = 1;
	}

}
