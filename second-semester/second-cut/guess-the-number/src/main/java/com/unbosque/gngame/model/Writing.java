package com.unbosque.gngame.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Writing {

	protected String path;

	public Writing() {
		path = "C:\\datos\\resultados.txt";
	}

	public void write(String nombre, String NumeroAdivinar, String totalIntentos, String ganoOPerdio) {
		try {
			File ruta = new File(path);
			FileWriter fw;
			if(ruta.exists()) {
				fw = new FileWriter(ruta, true);
			} else {
				ruta.createNewFile();
				fw = new FileWriter(ruta);
			}
			String valores = nombre + ";" + NumeroAdivinar + ";" + totalIntentos + ";" + ganoOPerdio;

			PrintWriter pw = new PrintWriter(fw);
			pw.print(valores + "\n");
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
