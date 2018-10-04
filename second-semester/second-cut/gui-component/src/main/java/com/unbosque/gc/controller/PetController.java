package com.unbosque.gc.controller;

import com.unbosque.gc.model.PetModel;
import com.unbosque.gc.view.PetView;

import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PetController implements ActionListener {

  private PetView view;
  private ArrayList<PetModel> model;  

  public PetController() {    
    this.view = new PetView(this);
    this.initModel();
    this.initView();    
  }

  private void initModel() {
    PetModel bird   = new PetModel(1, "bird");
    PetModel cat    = new PetModel(2, "cat");
    PetModel dog    = new PetModel(3, "dog");
    PetModel rabbit = new PetModel(4, "rabbit");
    PetModel pig    = new PetModel(5, "pig");

    this.model = new ArrayList<PetModel>();
    this.model.add(bird);
    this.model.add(cat);
    this.model.add(dog);
    this.model.add(rabbit);
    this.model.add(pig);
  }

  private void initView() {
    this.view.setVisible(true);
    for (PetModel pet : this.model) {
      this.view.add(pet);
    }
  }

  public void actionPerformed(ActionEvent e) {
    this.view.updatePicture(e.getActionCommand());    
  }
}
