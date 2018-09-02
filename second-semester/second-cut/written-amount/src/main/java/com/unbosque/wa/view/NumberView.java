package com.unbosque.wa.view;

import java.text.NumberFormat;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JRootPane;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;

import java.awt.BorderLayout;
import java.awt.Container;

import java.awt.event.ActionListener;

public class NumberView extends JFrame {

	public static final String CONVERT_BUTTON = "1234";

	private static int SMALL_GAP  = 4;
	private static int MEDIUM_GAP = 8;
	private static int BIG_GAP 	  = 12;

	private JPanel topPanel;
	private JPanel bottomPanel;

	private JTextField numberField;
	private JTextArea fileTextArea;

	private JButton convertButton;

	public NumberView() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 500);
		this.init();
		// this.pack();
		this.setVisible(true);
	}

	private void init() {
		this.setLayout(new BorderLayout(MEDIUM_GAP, MEDIUM_GAP));

		// top area
		this.topPanel = new JPanel();
		this.topPanel.setLayout(new BorderLayout(SMALL_GAP, SMALL_GAP));
		this.topPanel.setBorder(BorderFactory.createTitledBorder("entrada"));

		// children

		this.numberField = new JTextField();

		// number field validation
		this.numberField.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) { this.validate(); }
			public void removeUpdate(DocumentEvent e)  { this.validate(); }
			public void insertUpdate(DocumentEvent e)  { this.validate(); }

			public void validate() {
				boolean isNumber = numberField.getText().matches("^\\d+$");
				convertButton.setEnabled(isNumber);
			}
		});

		this.convertButton = new JButton("convertir");
		this.convertButton.setEnabled(false);

		this.topPanel.add(this.numberField, BorderLayout.CENTER);
		this.topPanel.add(this.convertButton, BorderLayout.EAST);

		// bottom area
		this.bottomPanel = new JPanel();

		this.bottomPanel.setLayout(new BorderLayout());
		this.bottomPanel.setBorder(BorderFactory.createTitledBorder("archivo"));

		// children
		this.fileTextArea = new JTextArea(10, 20);
		this.fileTextArea.setEditable(false);

		this.bottomPanel.add(this.fileTextArea, BorderLayout.CENTER);

		// add main panels
		this.add(this.topPanel, BorderLayout.NORTH);
		this.add(this.bottomPanel, BorderLayout.CENTER);
	}

	public void setListener(ActionListener listener) {
		this.convertButton.setActionCommand(CONVERT_BUTTON);
		this.convertButton.addActionListener(listener);
	}

	public int getNumber() {
		return Integer.parseInt(this.numberField.getText());
	}

	public void setText(String text) {
		this.fileTextArea.setText(text);
	}


}
