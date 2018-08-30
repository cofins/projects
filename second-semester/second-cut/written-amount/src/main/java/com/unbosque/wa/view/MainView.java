package com.unbosque.wa.view;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JRootPane;

import java.awt.BorderLayout;
import java.awt.Container;

public class MainView {

	private JFrame window;

	private JTextField numberField;
	private JTextField textField;

	public MainView() {
		this.window = new JFrame();
		this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.window.setSize(500, 500);
		this.window.setVisible(true);

		JRootPane rootPane = this.window.getRootPane();
		Container contentPane = rootPane.getContentPane();
	}

}
