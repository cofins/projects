package com.unbosque.grasp.model;

import java.util.*;

public class PlayerModel {

  private int id;
  private String name;
  private int level;
  private InventoryModel inventory;

  public PlayerModel(int id, String name, int level) {
    this.id = id;
    this.name = name;
    this.level = level;
  }

  public int getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String value) {
    this.name = value;
  }

  public int getLevel() {
    return this.level;
  }

  public void setLevel(int value) {
    this.level = value;
  }

  public InventoryModel getInventory() {
    return this.inventory;
  }

  public void setInventory(InventoryModel value) {
    this.inventory = value;
  }

  @Override
  public String toString() {
  	return this.name;
  }
  
  @Override
  public boolean equals(Object value) {    
    PlayerModel player = (PlayerModel) value;
  	return (player.getId() == this.id);
  }

}
