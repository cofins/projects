package com.unbosque.grasp.controller;

import com.unbosque.grasp.model.PlayerModel;
import com.unbosque.grasp.view.PlayerView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.JPanel;

public class PlayerController implements ActionListener {

  private ArrayList<PlayerModel> players;
  private PlayerView view;

  public PlayerController() {
    this.players = new ArrayList<PlayerModel>();
    this.players.add(new PlayerModel(1, "james", 12));
    this.players.add(new PlayerModel(2, "thom", 9));
    this.players.add(new PlayerModel(3, "raul", 26));

    this.view = new PlayerView(this);
  }

  public void add() {
    // TODO implement here
  }

  public void remove() {
    // TODO implement here
  }

  public void update() {
    // TODO implement here
  }

  @Override
  public void actionPerformed(ActionEvent e) {

  }

  JPanel getView() {
    return this.view;
  }

}
