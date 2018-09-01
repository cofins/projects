package com.unbosque.wa.model;

public class NumberModel {

	// Properties

	private int digit;
	private String[] names;
	private String[] snames;

	// Constructors

	public NumberModel(int digit, String[] names) {
		this.digit = digit;
		this.names = names;
	}

	public NumberModel(int digit, String[] names, String[] snames) {
		this.digit = digit;
		this.names = names;
		this.snames = snames;
	}

	// Accessors

	public int getDigit() {
		return this.digit;
	}

	public String getName(int index) {
		return this.names[index];
	}

	public String getSname(int index) {
		return (this.snames != null) ? this.snames[index] : null;
	}

}
