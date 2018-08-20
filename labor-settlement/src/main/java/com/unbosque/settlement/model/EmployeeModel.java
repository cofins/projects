package com.unbosque.settlement.model;

import java.util.Calendar;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class EmployeeModel {

  // properties
  private int id;
  private String name;
  private ContractEnum contract;
  private double salary;
  private Calendar admission_date;
  private Calendar birthdate;
  private double serviceTime;
  private int age;

  // constructor
  public EmployeeModel(int id, String name, ContractEnum contract, double salary, Calendar admission_date,
      Calendar birthdate) {
    this.setId(id);
    this.setName(name);
    this.setContract(contract);
    this.setSalary(salary);
    this.setAdmission_date(admission_date);
    this.setBirthdate(birthdate);
  }

  // functions

  public void calculateSeniority() {
    Calendar c = Calendar.getInstance();

    int y = Calendar.YEAR;
    int m = Calendar.MONTH;
    int d = Calendar.DAY_OF_MONTH;

    c.add(y, -this.admission_date.get(y));
    c.add(m, -this.admission_date.get(m));
    c.add(d, -this.admission_date.get(d));

    this.serviceTime = ((c.get(y) * 12) + c.get(m) + (c.get(d) / 30));
  }

  public void calculateAge() {
    Calendar c = Calendar.getInstance();

    int y = Calendar.YEAR;
    int m = Calendar.MONTH;
    int d = Calendar.DAY_OF_MONTH;

    c.add(y, -this.birthdate.get(y));
    c.add(m, -this.birthdate.get(m));
    c.add(d, -this.birthdate.get(d));

    this.age = c.get(y);

    c = Calendar.getInstance();

    if(c.get(d) >= this.birthdate.get(d)) this.age++;
  }

  // accessor

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ContractEnum getContract() {
    return this.contract;
  }

  public void setContract(ContractEnum contract) {
    this.contract = contract;
  }

  public double getSalary() {
    return this.salary;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }

  public Calendar getAdmission_date() {
    return this.admission_date;
  }

  public void setAdmission_date(Calendar admission_date) {
    this.admission_date = admission_date;
  }

  public Calendar getBirthdate() {
    return this.birthdate;
  }

  public void setBirthdate(Calendar birthdate) {
    this.birthdate = birthdate;
  }

  public double getServiceTime() {
    return this.serviceTime;
  }

  @Override
  public String toString() {
    GsonBuilder builder = new GsonBuilder();
    Gson gson = builder.create();
    return gson.toJson(this);
  }

}
