package com.unbosque.wa.model;

public class NumberModel {

	// Properties

	private int digit;
	private String[] names;
	private String[] cnames;

	// Constructors

	public NumberModel(int digit, String[] names) {
		this.digit = digit;
		this.names = names;
	}

	public NumberModel(int digit, String[] names, String[] cnames) {
		this.digit = digit;
		this.names = names;
		this.cnames = cnames;
	}

	// Accessors

	public int getDigit() {
		return this.digit;
	}

	public String getName(int index) {
		return this.names[index];
	}

	public String getCname(int index) {
		return (this.cnames != null) ? this.cnames[index] : null;
	}

}
