package vista;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import controlador.PicaFijaControlador;

public class Usuario extends JPanel {


	private JTextArea Nombre;
	private JTextArea usuario;
	private JButton agregari;


	public Usuario(PicaFijaControlador p) {
		setLayout(new GridLayout(1,3,2,2));
		Nombre = new JTextArea("Usuario");
		add(Nombre);
		Nombre.setBorder(PicaFijaVista.B);
		Nombre.setEditable(false);
		usuario= new JTextArea("Nombre Usuario" );
		usuario.setBorder(PicaFijaVista.B);
		usuario.setEditable(false);
		add(usuario);
		agregari = new JButton();
		agregari.setActionCommand(PicaFijaVista.AGREGARINTENTOS);
		agregari.addActionListener(p);
		agregari.setText("Adivinar");
		add(agregari);
	}
	public void agregarUsuario(String usuario) {

		this.usuario.setText(usuario);
	}

}
