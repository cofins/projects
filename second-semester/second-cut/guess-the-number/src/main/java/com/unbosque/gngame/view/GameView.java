package com.unbosque.gngame.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

public class GameView extends JFrame {

    // Constants
    private static final String[] COLUMN_IDENTIFIERS = { "number", "p", "f" };

    // Commands
    public static final String GUESS_BUTTON_COMMAND = "1";
    public static final String NEW_GAME_MENU_ITEM_COMMAND = "2";
    public static final String SAVE_GAME_MENU_ITEM_COMMAND = "3";
    public static final String LOAD_GAME_MENU_ITEM_COMMAND = "4";
    // UI components

    private JTextField numberTextField;
    private JButton guessButton;
    private JTable registryTable;
    private DefaultTableModel registryTableModel;

    private JMenuBar gameMenuBar;
    private JMenuItem newGameMenuItem;
    private JMenuItem saveGameMenuItem;
    private JMenuItem loadGameMenuItem;


    public GameView() {
        this.init();
    }  

    private void init() {

        // menu intialization

        this.gameMenuBar = new JMenuBar();

        JMenu menu = new JMenu("game");        

        this.newGameMenuItem = new JMenuItem("new game");        
        this.saveGameMenuItem = new JMenuItem("save game");
        this.loadGameMenuItem = new JMenuItem("load game");

        menu.add(newGameMenuItem);
        menu.addSeparator();
        menu.add(saveGameMenuItem);
        menu.add(loadGameMenuItem);

        this.gameMenuBar.add(menu);

        this.setJMenuBar(this.gameMenuBar);

        // others components

        this.numberTextField = new JTextField();
        this.guessButton = new JButton("guess");
        this.registryTable = new JTable();

        this.registryTableModel = new DefaultTableModel();
        registryTableModel.setColumnIdentifiers(COLUMN_IDENTIFIERS);
        this.registryTable.setModel(registryTableModel);

        JPanel northPanel = new JPanel(new BorderLayout());

        northPanel.add(this.numberTextField, BorderLayout.CENTER);
        northPanel.add(this.guessButton, BorderLayout.EAST);

        this.setLayout(new BorderLayout());
        this.add(northPanel, BorderLayout.NORTH);
        this.add(new JScrollPane(this.registryTable));
        

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setVisible(true);
    }

    public void setListener(ActionListener listener) {
        this.guessButton.setActionCommand(GUESS_BUTTON_COMMAND);
        this.newGameMenuItem.setActionCommand(NEW_GAME_MENU_ITEM_COMMAND);
        this.saveGameMenuItem.setActionCommand(SAVE_GAME_MENU_ITEM_COMMAND);
        this.loadGameMenuItem.setActionCommand(LOAD_GAME_MENU_ITEM_COMMAND);

        this.guessButton.addActionListener(listener);
        this.newGameMenuItem.addActionListener(listener);
        this.saveGameMenuItem.addActionListener(listener);
        this.loadGameMenuItem.addActionListener(listener);
    } 

    public String request(String indication) {
        return JOptionPane.showInputDialog(this, indication);
    }

    public void show(String text) {
        JOptionPane.showMessageDialog(this, text);
    }

    public void setGuessButtonEnabled(boolean enable) {
        this.guessButton.setEnabled(enable);
    } 

    public void clear() {
        this.registryTableModel.setRowCount(0);
    }

    public void addAttempt(String n, String p, String f) {
        this.registryTableModel.addRow(new Object[] { n, p, f });
    }

    public String getNumber() {
        return this.numberTextField.getText();
    }
}