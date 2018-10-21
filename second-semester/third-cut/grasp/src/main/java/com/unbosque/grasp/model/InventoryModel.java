package com.unbosque.grasp.model;

import java.util.*;

public class InventoryModel {

  private int id;
  private int capacity;

  public InventoryModel(int id, int capacity) {
  	this.id = id;
  	this.capacity = capacity;
  }

  public int getId() {
    return this.id;
  }

  public int getCapacity() {
    return this.capacity;
  }

  public void setCapacity(int value) {
  	this.capacity = value;
  }

}
