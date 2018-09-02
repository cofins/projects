package com.unbosque.wa.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;

import java.util.Arrays;

import java.lang.StringBuilder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.unbosque.wa.view.NumberView;
import com.unbosque.wa.model.NumberModel;
import com.unbosque.wa.model.Constants;

public class NumberController implements ActionListener {

	private NumberView view;

	public NumberController() {
		this.view = new NumberView();
		this.view.setListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
			case NumberView.CONVERT_BUTTON: save(); load(); break;
		}
	}

	private void save() {
		try {
			// get root path of application, and save data into "data.txt"
			File file = new File(Constants.FILE_PATH);
			if(!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file, true);

			fw.append(this.convert(this.view.getNumber()) + "\n");
			fw.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void load() {
		try (BufferedReader br = new BufferedReader(new FileReader(Constants.FILE_PATH))) {
			StringBuilder sb = new StringBuilder();
			String line;

			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			this.view.setText(sb.toString());
			br.close();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public String convert(int n) {

		String s = String.format("%,d", n);

		String[] ts = s.split("\\.");
		String[] w = new String[ts.length * 2 - 1];

		// the order of the numbers is reversed to facilitate the insertion of postfixes
		this.r(ts);

		for (int i = 0, j = 0; i < ts.length; ++i, ++j) {
			w[j] = this.t(Integer.parseInt(ts[i]));
			// adding postfixes
			if(ts.length - i - 1 > 0) {
				w[++j] = Constants.POSTFIXES[(i % 2 == 0) ? 0 : i];
			}

		}

		// return to the original order
		this.r(w);

		return Arrays.toString(w).replaceAll("\\[|\\]", "").replaceAll(",", " ");
	}

	// parse thousand number to written
	private String t(int n) {
		String w = "";
		Integer[] p = s(n);

		for (int i = 0; i < p.length; ++i) {

			// current number
			NumberModel cn = Constants.NUMBERS[p[i]];

			if(cn.getDigit() == 0) {
				continue;
			}

			// check if the number is dependent
			if(i == 1) {

				// next number
				NumberModel nn = Constants.NUMBERS[p[i + 1]];
				boolean hsn = (cn.getSname(0) != null);

				/**
				 * if the companion number is equals to 0,
		 	   * then the actual number is ten and not dependent.
			   **/
				if((nn.getDigit() != 0) && hsn) {
					w += cn.getSname(nn.getDigit() - 1);
					++i;
					continue;
				}
			}

			w += cn.getName(i);

			if(i == 0) {
				w += Constants.WHITE_SPACE;
			} else if(i == 1) {
				w += Constants.SEPARATOR;
			}

		}

		return w;
	}

	// split number in digits
	private Integer[] s(int n) {
		Integer[] p = { 0, 0, 0 };

		for (int i = p.length - 1; i >= 0; --i) {

			// no more digits
			if (!(n > 0))
				continue;

			p[i] = n % 10;
			n /= 10;
		}

		return p;
	}

	// reverse array
	private <T> void r(T[] a) {
		for(int i = 0; i < a.length / 2; i++) {
	    T temp = a[i];
	    a[i] = a[a.length - i - 1];
	    a[a.length - i - 1] = temp;
		}
	}

}
