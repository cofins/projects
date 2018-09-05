package com.unbosque.dlogic.view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CalculatorView extends JFrame
{
   // serial
   private static final long serialVersionUID = 42l;
   private static final int WINDOW_WIDTH      = 400;
   private static final int WINDOW_HEIGTH     = 300;
   private static final int SMALL_GAP         = 8;
   private static final int MEDIUM_GAP        = 16;
   private static final int BIG_GAP           = 24;

   // constructor
   public CalculatorView()
   {
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setSize();
   }

   public void initialize()
   {
      this.setLayout(new BorderLayout(SMALL_GAP, SMALL_GAP));
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setVisible(true);
   }
}
