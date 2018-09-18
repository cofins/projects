package com.unbosque.gngame.controller;

import java.util.Arrays;

import com.unbosque.gngame.view.GameView;
import com.unbosque.gngame.model.GameModel;
import com.unbosque.gngame.model.UserModel;
import com.unbosque.gngame.model.StateEnum;

import com.unbosque.gngame.model.Reading;
import com.unbosque.gngame.model.Writing;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GameController implements ActionListener {

    private GameView view;
    private GameModel model;

    private Reading reading;
    private Writing writing;

    public GameController() {
        this.view = new GameView();
        this.view.setListener(this);
        this.view.setGuessButtonEnabled(false);

        this.reading = new Reading();
        this.writing = new Writing();
    }

    private void newGame() {
        this.view.clear();

        String username = this.view.request("username: ");
        UserModel user = new UserModel(username);

        this.model = new GameModel(user);
        this.model.generateNumber();

        this.view.setGuessButtonEnabled(true);
    }

    private void guess() {
        String _number = this.view.getNumber();
        boolean isNumber = _number.matches("\\d+");
        if(isNumber) {
            int number =Integer.parseInt(_number);
            if(this.model.isValid(number)) {
                this.model.guess(number);

                int[] registry = this.model.getRegistry()[this.model.getAttempts() - 1];

                String n = String.valueOf(registry[0]);
                String p = String.valueOf(registry[1]);
                String f = String.valueOf(registry[2]);

                this.view.addAttempt(n, p, f);

                switch(this.model.getState()) {
                    case WON:  this.view.show("You won");  break;
                    case LOST: this.view.show("You lost"); break;            
                }
                this.view.setGuessButtonEnabled(this.model.getState() == StateEnum.IN_GAME);
                return;
            }
        }        
        this.view.show("The input is invalid");
    }

    private void read() {
        this.view.show(this.reading.read());
    }

    private void write() {
        String username = this.model.getUser().getName();
        String number = Arrays.toString(this.model.getNumber());
        String attempts = String.valueOf(this.model.getAttempts());
        String state = this.model.getState().toString();
        this.writing.write(username, number, attempts, state);
    }

    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()) {
            case GameView.GUESS_BUTTON_COMMAND: this.guess(); break;
            case GameView.NEW_GAME_MENU_ITEM_COMMAND: this.newGame(); break;
            case GameView.SAVE_GAME_MENU_ITEM_COMMAND: this.write(); break;
            case GameView.LOAD_GAME_MENU_ITEM_COMMAND: this.read(); break;
        }
    }

}