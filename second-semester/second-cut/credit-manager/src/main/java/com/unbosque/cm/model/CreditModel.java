package com.unbosque.cm.model;

public class CreditModel {

  // constants
  private static final int DATA_COLUMNS = 5;
  public static final int DATA_FEE_INDEX_COLUMN = 0;
  public static final int DATA_INTEREST_COLUMN = 1;
  public static final int DATA_AMORTIZATION_COLUMN = 2;
  public static final int DATA_FEE_COLUMN = 3;
  public static final int DATA_PENDING_CAPITAL_COLUMN = 4;

  // properties
  private int periods;
  private double interestType;
  private double totalCapital;
  private double[][] data;

  // constructors

  public CreditModel() {}

  public CreditModel(int periods, double interestType, double totalCapital) {
    this.setPeriods(periods);
    this.setInterestType(interestType);
    this.setTotalCapital(totalCapital);
  }

  public void calculateData() {
    this.data = new double[this.periods + 1][DATA_COLUMNS];

    double interest;
    double amortization;
    double fee;
    double pendingCapital = this.totalCapital;

    // inital values
    this.data[0][DATA_FEE_INDEX_COLUMN] = 0;
    this.data[0][DATA_PENDING_CAPITAL_COLUMN] = pendingCapital;

    for (int i = 1; i < data.length; ++i) {
      interest = (this.interestType * this.totalCapital);
      amortization = (this.totalCapital / this.periods);
      fee = (amortization + interest);
      pendingCapital = (pendingCapital - amortization);

      this.data[i][DATA_FEE_INDEX_COLUMN] = i;
      this.data[i][DATA_INTEREST_COLUMN] = interest;
      this.data[i][DATA_AMORTIZATION_COLUMN] = amortization;
      this.data[i][DATA_FEE_COLUMN] = fee;
      this.data[i][DATA_PENDING_CAPITAL_COLUMN] = pendingCapital;
    }
  }

  // accesors

  public void setPeriods(int periods) {
    this.periods = periods;
  }

  public void setInterestType(double interestType) {
    this.interestType = interestType;
  }

  public void setTotalCapital(double totalCapital) {
    this.totalCapital = totalCapital;
  }

  public int getPeriods() {
    return this.periods;
  }

  public double getTnterestType() {
    return this.interestType;
  }

  public double getTotalCapital() {
    return this.totalCapital;
  }

  public double[][] getData() {
    return this.data;
  }
}
