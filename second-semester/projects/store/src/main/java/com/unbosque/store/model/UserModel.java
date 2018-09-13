package com.unbosque.store.model;

public abstract class UserModel {

  /** Properties */
  protected String id;

  protected String firstName;
  protected String lastName;
  protected String mail;

  /** Constructor */
  public UserModel(String id, String firstName, String lastName, String mail) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.mail = mail;
  }

  /** Accersors */
  public String getId() {
    return this.id;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public String getMail() {
    return this.mail;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }
}
