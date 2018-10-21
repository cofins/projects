package com.unbosque.grasp.model;

import java.util.*;

public class ElementModel {

  private int id;
  private String name;
  private int level;

  public ElementModel(int id, String name, int level) {
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

}
