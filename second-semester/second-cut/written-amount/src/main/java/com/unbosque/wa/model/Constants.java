package com.unbosque.wa.model;

import java.io.File;

public class Constants {

	// NUMBERS LIST

	public static final NumberModel[] NUMBERS = new NumberModel[] {
		 new NumberModel(0, new String[] { "", "", ""}),
		 new NumberModel(1, new String[] { "ciento", "diez", "uno"}, new String[] { "once", "doce", "trece", "catorce", "quince", "dieciséis", "diecisiete", "dieciocho", "diecinueve" }),
		 new NumberModel(2, new String[] { "doscientos", "veinte", "dos"}, new String[] { "veintiuno", "veintidós", "veintitrés", "veinticuatro", "veinticinco", "veintiséis", "veintisiete", "veintiocho", "veintinueve" }),
		 new NumberModel(3, new String[] { "trecientos", "treinta", "tres" }),
		 new NumberModel(4, new String[] { "cuatrocientos", "cuarenta", "cuatro" }),
		 new NumberModel(5, new String[] { "quinientos", "cinquenta", "cinco" }),
		 new NumberModel(6, new String[] { "seicientos", "sesenta", "seis" }),
		 new NumberModel(7, new String[] { "setecientos", "setenta", "siete" }),
		 new NumberModel(8, new String[] { "ochocientos", "ochenta", "ocho" }),
		 new NumberModel(9, new String[] { "novecientos", "noventa", "nueve" }),
	};

	public static final String[] POSTFIXES = new String[] { "mil", "millones", "billones", "trillones", "cuatrillones" };
	public static final String SEPARATOR = " y ";
	public static final String WHITE_SPACE = " ";

	public static String FILE_PATH;

	static {
		try {
			FILE_PATH = new File(".").getCanonicalPath() + "\\target\\data.txt";
		} catch (Exception e) { }
	}

}
