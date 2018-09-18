package modelo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Resultado {

	protected String path;

	public Resultado() {
		path = "C:\\Users\\aulamovil06\\Desktop\\Datos\\resultados.txt";
	}

	public void escribirResueltos(String nombre, String NumeroAdivinar, String totalIntentos, String ganoOPerdio) {
		try {
			File ruta = new File(path);
			String valores = nombre + ";" + NumeroAdivinar + ";" + totalIntentos + ";" + ganoOPerdio;

			FileWriter fw = new FileWriter(ruta, true);
			PrintWriter pw = new PrintWriter(fw);
			pw.print(valores + "\n");
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
