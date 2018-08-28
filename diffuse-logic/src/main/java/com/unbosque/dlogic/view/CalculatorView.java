package com.unbosque.dlogic.view;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class CalculatorView extends JFrame {

  // serial
  private static final long serialVersionUID = 42l;

  private static final int SMALL_GAP = 8;
  private static final int MEDIUM_GAP = 16;
  private static final int BIG_GAP = 24;

  // constructor
  public CalculatorView(String title, int width, int height) {
    this.setTitle(title);
    this.setSize(width, height);
  }

  public void initialize() {
    this.setLayout(new BorderLayout(SMALL_GAP, SMALL_GAP));    
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
  }


}
