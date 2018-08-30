package com.unbosque.settlement.model;

import java.util.Calendar;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SettlementModel {

  private int month;
  private double grossIncome;
  private double healthContributions;
  private double pensionContributions;
  private double netIncome;

  public SettlementModel() {
    this.month = Calendar.getInstance().get(Calendar.MONTH);
  }

  public void calculateGrossIncome(int hours, double commissions, double salary) {
    this.grossIncome = (salary * hours + commissions);
  }

  public void calculateHealthContributions(ContractEnum contract) {
    this.healthContributions = this.grossIncome * (contract == ContractEnum.SERVICE_PROVISION ? 0.135 : 0.09);
  }

  public void calculatePensionContributions(ContractEnum contract) {
    this.pensionContributions = this.grossIncome * (contract == ContractEnum.SERVICE_PROVISION ? 0.15 : 0.05);
  }

  public void calculateNetIncome() {
    this.netIncome = this.grossIncome - this.healthContributions - this.pensionContributions;
  }

  @Override
  public String toString() {
    GsonBuilder builder = new GsonBuilder();
    Gson gson = builder.create();
    return gson.toJson(this);
  }

}
