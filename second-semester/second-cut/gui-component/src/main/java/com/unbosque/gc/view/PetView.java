package com.unbosque.gc.view;

import com.unbosque.gc.model.PetModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PetView extends JFrame {
 
  // Constants
  private static final int FRAME_WIDTH = 500;
  private static final int FRAME_HEIGTH = 500;
  private static final String FRAME_TITLE = "JRadioButton example";

  // Listener
  private ActionListener listener;

  // Components 
  private ButtonGroup buttonGroup;
  private JPanel radioPanel;
  private JLabel picture;

  // Constructor
  public PetView(ActionListener listener) {
    this.listener = listener;
    this.setSize(FRAME_WIDTH, FRAME_HEIGTH);
    this.setTitle(FRAME_TITLE);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
    this.init();
  }

  private void init() {  	
    this.setLayout(new BorderLayout());
    this.buttonGroup = new ButtonGroup();    
    this.picture = new JLabel();    
    this.radioPanel = new JPanel(new GridLayout(10, 0));        
    this.add(radioPanel, BorderLayout.WEST);
    this.add(picture, BorderLayout.CENTER);
  }

  public void add(PetModel pet) {
    JRadioButton petButton = new JRadioButton(pet.getName());    
    petButton.setActionCommand(pet.getName());
    petButton.addActionListener(this.listener);

    this.buttonGroup.add(petButton);        
    this.radioPanel.add(petButton);    
  }

  public void updatePicture(String imgName) {            
    ImageIcon img = new ImageIcon(getClass().getClassLoader().getResource("images/" + imgName + ".png"));
    this.picture.setIcon(img);
  } 
  

}
