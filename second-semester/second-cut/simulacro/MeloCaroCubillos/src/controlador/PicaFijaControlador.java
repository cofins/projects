package controlador;

import java.util.Arrays;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.PicaFija;
import vista.PicaFijaVista;

public class PicaFijaControlador implements ActionListener {

  private PicaFija juego;
  private PicaFijaVista vista;

  public PicaFijaControlador() {
    this.vista = new PicaFijaVista(this);
  }

  private void nuevoJuego() {
    String nombre = this.vista.obtenerNombre();
    int[] n = this.numeroADigitos((int) (Math.random() * 5000));
    this.juego = new PicaFija(n, nombre);
    System.out.print(Arrays.toString(n));
    this.vista.agregarUsuario(nombre);
  }

  public void actionPerformed(ActionEvent e) {
    switch (e.getActionCommand()) {
    case PicaFijaVista.AGREGARUSARIO:
      this.nuevoJuego();
      break;
    case PicaFijaVista.AGREGARINTENTOS: {
      int intento = this.vista.obtenerIntento();
      int[] digitos = this.numeroADigitos(intento);
      if (!this.juego.validar(digitos)) {
        this.vista.mostarDatos("El numero no es valido!!! ");
        return;
      } else {
        this.juego.intentar(digitos);
        this.vista.agregarIntento(intento);
        boolean gano = this.juego.obtenerGano();
        this.vista.mostarDatos("picas: " + this.juego.obtenerPicas() + " fijas: " + this.juego.obtenerFijas());
        if (gano == true) {
          this.vista.mostarDatos("Gano");
        }
        if (this.juego.obtenerConteo() >= 9) {
          if (gano == false) {
            this.vista.mostarDatos("Perdio");
          }
        }
      }
    }
      break;
    }
  }

  private int[] numeroADigitos(int numero) {
    String valor = String.valueOf(numero);
    int[] digitos = new int[valor.length()];
    for (int i = 0; i < valor.length(); i++) {
      digitos[i] = Character.getNumericValue(valor.charAt(i));
    }
    return digitos;
  }
}
