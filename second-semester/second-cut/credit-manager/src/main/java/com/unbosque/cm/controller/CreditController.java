package com.unbosque.cm.controller;

import com.unbosque.cm.model.CreditModel;
import com.unbosque.cm.view.CreditView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreditController implements ActionListener {

  private CreditView view;
  private CreditModel model;

  public CreditController() {
    this.view = new CreditView();
    this.view.setListener(this);
    this.model = new CreditModel(12, 0.2343, 8070000.0);
  }

  public void actionPerformed(ActionEvent e) {
    switch (e.getActionCommand()) {
      case CreditView.GENERATE_BUTTON:
        this.onGenerateButtonClicked();
        break;
    }
  }

  private void onGenerateButtonClicked() {
    int periods = this.view.getPeriods();
    double interestType = this.view.getInterestType();
    double totalCapital = this.view.getTotalCapital();

    this.model.setPeriods(periods);
    this.model.setInterestType(interestType);
    this.model.setTotalCapital(totalCapital);

    this.model.calculateData();
    this.view.setData(this.model.getData());
  }
}
