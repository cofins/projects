package com.unbosque.wa.controller;

import java.text.NumberFormat;

import com.unbosque.wa.model.NumberModel;
import com.unbosque.wa.model.Constants;

public class NumberController {

	private String convert(int number) {
		NumberFormat f = NumberFormat.getInstance();

		String w = "";
		String nf = f.format(number);
		String[] ts = nf.split("\\.");
		return null;
	}

	// parse thousand number to written
	private void t(int n) {
		Integer[] p = s(n);

		for (int i = 0; i < p.length; ++i) {
			NumberModel nm = Constants.NUMBERS[p[i]];
			// check if the number is dependent


		}
	}

	// split number in digits
	private Integer[] s(int n) {
		Integer[] p = { 0, 0, 0 };

		for (int i = p.length; i >= 0; --i) {

			// no more digits
			if (!(n > 0))
				continue;

			p[i] = i % 10;
			n /= 10;
		}
		return p;
	}

	// reverse array number
	private <T> void r(T[] a) {
		for (int i = 0; i < a.length; i++) {
			T temp = a[i];
			a[i] = a[a.length - i - 1];
			a[a.length - i - 1] = temp;
		}
	}

}
