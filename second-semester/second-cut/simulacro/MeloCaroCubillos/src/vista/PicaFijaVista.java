package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import controlador.PicaFijaControlador;

public class PicaFijaVista extends JFrame {


	public final static Border B = BorderFactory.createLineBorder(Color.black, 1);
	public static final String AGREGARUSARIO= "AGREGAR";
	public static final String AGREGARINTENTOS= "AGREGAR INTENTOS";
	public static final String DATOS= "DATOS";

	private  Usuario u;
	private Botones b;
	private Tabla t;


	public PicaFijaVista(PicaFijaControlador p) {

		u = new Usuario(p);
		b= new Botones(p);
		t= new Tabla();


		setLayout(new BorderLayout());
		setTitle("Picas y Fijas");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(500, 100, 440, 550);
		add(b, BorderLayout.SOUTH);
		add(u, BorderLayout.NORTH);
		add(t, BorderLayout.CENTER);
		setVisible(true);
		setResizable(false);

	}

	public int obtenerIntento() {
		String in = JOptionPane.showInputDialog(this, "numero");
		int n = Integer.parseInt(in);
		return n;
	}
	public String obtenerNombre() {
		return JOptionPane.showInputDialog(this, "nombre");
	}


	public void agregarIntento(int intento) {
		t.agregarIntento(intento);
	}

	public void agregarUsuario(String usuario) {
		u.agregarUsuario(usuario);
		t.reiniciar();
	}
	public void mostarDatos(String datos) {
		JOptionPane.showMessageDialog(null, datos, "Datos", JOptionPane.INFORMATION_MESSAGE);

	}

}
