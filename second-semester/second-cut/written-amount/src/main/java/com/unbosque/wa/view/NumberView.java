package com.unbosque.wa.view;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JRootPane;

import java.awt.BorderLayout;
import java.awt.Container;

public class NumberView extends JFrame {

	private JFrame window;

	private JTextField numberField;
	private JTextArea fileTextArea;

	public NumberView() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 500);
		this.init();
		this.setVisible(true);
	}

	private void init() {
		this.setLayout(new BorderLayout());

		this.numberField = new JTextField();
		this.fileTextArea = new JTextArea();

		this.add(this.numberField, BorderLayout.NORTH);
		this.add(this.fileTextArea, BorderLayout.SOUTH);
	}


}
