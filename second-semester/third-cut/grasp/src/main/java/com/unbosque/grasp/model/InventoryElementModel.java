package com.unbosque.grasp.model;

import java.util.*;

public class InventoryElementModel {

  private int id;
  private int amount;
  private InventoryModel inventory;
  private ElementModel element;

  public void InventoryElement(int id, int amount, InventoryModel inventory, ElementModel element) {
		this.id = id;
		this.amount = amount;
		this.inventory = inventory;
		this.element = element;
  }

  public int getId() {
    return this.id;
  }

  public int getAmount() {
    return this.amount;
  }

  public void setAmount(int value) {
		this.amount = value;
  }

  public InventoryModel getInventory() {
    return this.inventory;
  }

  public void setInventory(InventoryModel value) {
  	this.inventory = value;
  }

  public ElementModel getElement() {
    return this.element;
  }

  public void setElement(ElementModel value) {
  	this.element = value;
  }

}
