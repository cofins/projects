package com.unbosque.cm.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class CreditView extends JFrame {

  // constants
  private static final int FRAME_WIDTH = 500;
  private static final int FRAME_HEIGHT = 500;
  private static final String FRAME_TITLE = "credit manager";
  private static final String[] DATA_TABLE_COLUMN_NAMES = {
    "period", "interest", "amortization", "fee", "pending capital"
  };

  public static final String GENERATE_BUTTON = "g_b";

  // UI Components
  private JTextField periodsTextField;
  private JTextField interestTypeTextField;
  private JTextField totalCapitalTextField;
  private JButton generateButton;
  private JTable dataTable;

  // constructor
  public CreditView() {
    this.setTitle("credit manager");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
    this.structure();
    this.setVisible(true);
  }

  private void structure() {
    this.periodsTextField = new JTextField(7);
    this.interestTypeTextField = new JTextField(7);
    this.totalCapitalTextField = new JTextField(7);
    this.generateButton = new JButton("generate");
    this.dataTable = new JTable();
    DefaultTableModel dtm = new DefaultTableModel();
    dtm.setColumnIdentifiers(DATA_TABLE_COLUMN_NAMES);
    this.dataTable.setModel(dtm);

    JPanel northPanel = new JPanel(new FlowLayout());

    northPanel.add(this.periodsTextField);
    northPanel.add(this.interestTypeTextField);
    northPanel.add(this.totalCapitalTextField);
    northPanel.add(this.generateButton);

    this.setLayout(new BorderLayout());

    this.add(northPanel, BorderLayout.NORTH);
    this.add(new JScrollPane(dataTable), BorderLayout.CENTER);
  }

  public void setListener(ActionListener listener) {
    this.generateButton.setActionCommand(GENERATE_BUTTON);
    this.generateButton.addActionListener(listener);
  }

  public int getPeriods() {
    return Integer.parseInt(this.periodsTextField.getText());
  }

  public double getInterestType() {
    return Double.parseDouble(this.interestTypeTextField.getText());
  }

  public double getTotalCapital() {
    return Double.parseDouble(this.totalCapitalTextField.getText());
  }

  public void setData(double[][] data) {
    DefaultTableModel dtm = (DefaultTableModel) this.dataTable.getModel();
    dtm.setRowCount(0);
    for (int i = 0; i < data.length; i++) {
      Object[] row = new Object[data[i].length];
      for (int j = 0; j < row.length; j++) {
        row[j] = (int) data[i][j];
      }
      dtm.addRow(row);
    }
    System.out.println(Arrays.toString(data));
  }
}
