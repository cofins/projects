package vista;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import controlador.PicaFijaControlador;

public class Botones  extends JPanel{


private JButton agregarU;
private JButton datos;


	public Botones(PicaFijaControlador p) {
		agregarU = new JButton("agregar Usuario");
		datos= new JButton("Dar Datos");
		setLayout(new GridLayout(1,2,5,5));
		agregarU.setActionCommand(PicaFijaVista.AGREGARUSARIO);
		agregarU.addActionListener(p);
		add(agregarU);
		datos.setActionCommand(PicaFijaVista.DATOS);
		datos.addActionListener(p);
		add(datos);
	}

}
