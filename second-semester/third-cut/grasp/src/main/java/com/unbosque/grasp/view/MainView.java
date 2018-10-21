package com.unbosque.grasp.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class MainView extends JFrame {

    public MainView() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(500, 500));
        this.setLayout(new BorderLayout());
    }
}