package com.unbosque.settlement.controller;

import com.unbosque.settlement.model.ContractEnum;
import com.unbosque.settlement.model.EmployeeModel;
import com.unbosque.settlement.model.RosterModel;

import com.unbosque.settlement.view.RosterView;

import java.util.Calendar;
import java.text.SimpleDateFormat;

public class RosterController {

  private RosterModel model;
  private RosterView view;

  public RosterController() {
    this.model = new RosterModel();
    this.view = new RosterView();
    this.menu();
  }

  private void menu() {
    this.view.show("[0] : add employee\n[1] : remove employee\n[2] : print register");
    String input;
    while (!(input = this.view.request("Insert code: ")).matches("[0-2]")) {}

    switch (input) {
    case "0": this.add(); break;
    case "1": this.remove(); break;
    case "2": this.print(); break;
    }

    if(this.view.request("Do you want exit (Y/N) Y: ").toUpperCase() != "Y") {
      this.menu();
    }

  }

  private void add() {
    String[] inputs = new String[8];
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    try {

    inputs[0] = this.view.request("id: ");
    int id = Integer.parseInt(inputs[0]);

    inputs[1] = this.view.request("name: ");
    String name = inputs[1];

    inputs[2] = this.view.request("contract: ");
    ContractEnum contract = ContractEnum.valueOf(inputs[2]);

    inputs[3] = this.view.request("salary: ");
    double salary = Double.parseDouble(inputs[3]);

    inputs[4] = this.view.request("admission_date: ");
    Calendar admission_date = Calendar.getInstance();
    admission_date.setTime(sdf.parse(inputs[4]));


    inputs[5] = this.view.request("birthdate: ");
    Calendar birthdate = Calendar.getInstance();
    admission_date.setTime(sdf.parse(inputs[5]));

    inputs[6] = this.view.request("commissions: ");
    double commissions = Double.parseDouble(inputs[6]);

    EmployeeModel employee = new EmployeeModel(id, name, contract, salary, admission_date, birthdate);

    this.model.add(employee, commissions);

    }
    catch (Exception e) {
      this.view.show("Input format error");
      this.add();
    }
  }

  private void remove() {
    String input = this.view.request("id: ");
    int id = Integer.parseInt(input);
    this.view.show(this.model.remove(id) ? "Removed" : "Can't find id");
  }

  private void print() {
    this.view.show(this.model.toString());
  }

}
