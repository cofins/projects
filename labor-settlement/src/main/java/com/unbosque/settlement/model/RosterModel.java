package com.unbosque.settlement.model;

import java.util.HashMap;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class RosterModel {

  private HashMap<EmployeeModel, SettlementModel> employees;

  public RosterModel() {
    this.employees = new HashMap<EmployeeModel, SettlementModel>();
  }

  public void add(EmployeeModel employee, double commissions) {
    SettlementModel settlement = new SettlementModel();

    settlement.calculateGrossIncome((int) (employee.getServiceTime() * 720), commissions, employee.getSalary());
    settlement.calculateHealthContributions(employee.getContract());
    settlement.calculatePensionContributions(employee.getContract());
    settlement.calculateNetIncome();

    this.employees.put(employee, settlement);
  }

  public boolean remove(int id) {
    for (EmployeeModel employee : this.employees.keySet()) {
      if(employee.getId() == id) {
        this.employees.remove(employee);
        return true;
      }
    }
    return false;
  }

  @Override
    public String toString() {
      GsonBuilder builder = new GsonBuilder();
      Gson gson = builder.create();
      return gson.toJson(this);
    }
}
