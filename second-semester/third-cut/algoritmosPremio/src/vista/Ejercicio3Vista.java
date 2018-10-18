package vista;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ejercicio3Vista extends JPanel {

	private JLabel numeroLabel;
	private JTextField numeroTextField;
	private JTextField resultadoTextField;
	private JButton calcularButton;
	
	public static final String EJERCICIO3_BOTON_CALCULAR = "ej3c"; 
	
	public Ejercicio3Vista(ActionListener listener) {
		this.setLayout(new GridLayout(3, 2));
		this.numeroLabel = new JLabel("a");
		this.numeroTextField = new JTextField();
		this.resultadoTextField = new JTextField();
		this.calcularButton = new JButton("calcular");
		this.calcularButton.setActionCommand(EJERCICIO3_BOTON_CALCULAR);
		this.calcularButton.addActionListener(listener);
		this.add(numeroLabel);
		this.add(numeroTextField);
		this.add(calcularButton);
		this.add(resultadoTextField);
	}
	
	public int getNumero() {
		return Integer.parseInt(this.numeroTextField.getText());
	}
	
	public void setNumero(int numero1) {
		this.numeroTextField.setText(String.valueOf(numero1));
	}
	
	
	public void setResultado(String resultado) {
		this.resultadoTextField.setText(String.valueOf(resultado));
	}
	
}
