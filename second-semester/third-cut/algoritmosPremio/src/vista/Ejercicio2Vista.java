package vista;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ejercicio2Vista extends JPanel {

	private JLabel numero1Label;
	private JLabel numero2Label;
	private JTextField numero1TextField;
	private JTextField numero2TextField;
	private JTextField resultadoTextField;
	private JButton calcularButton;
	
	public static final String EJERCICIO2_BOTON_CALCULAR = "ej2c"; 
	
	public Ejercicio2Vista(ActionListener listener) {
		this.setLayout(new GridLayout(3, 2));
		this.numero1Label = new JLabel("a");
		this.numero1TextField = new JTextField();
		this.numero2Label = new JLabel("b");
		this.numero2TextField = new JTextField();
		this.resultadoTextField = new JTextField();
		this.calcularButton = new JButton("calcular");
		this.calcularButton.setActionCommand(EJERCICIO2_BOTON_CALCULAR);
		this.calcularButton.addActionListener(listener);
		this.add(numero1Label);
		this.add(numero1TextField);
		this.add(numero2Label);
		this.add(numero2TextField);
		this.add(calcularButton);
		this.add(resultadoTextField);
	}
	
	public int getNumero1() {
		return Integer.parseInt(this.numero1TextField.getText());
	}
	
	public int getNumero2() {
		return Integer.parseInt(this.numero2TextField.getText());
	}
	
	public void setNumero1(int numero1) {
		this.numero1TextField.setText(String.valueOf(numero1));
	}
	
	public void setNumero2(int numero2) {
		this.numero2TextField.setText(String.valueOf(numero2));
	}
	
	public void setResultado(String resultado) {
		this.resultadoTextField.setText(String.valueOf(resultado));
	}
	
}
