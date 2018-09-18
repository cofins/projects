package com.unbosque.gngame.model;

import java.util.Arrays;

public class GameModel {

    // Cosntants
    private static final int DIGITS = 5;
    private static final int ALLOWED_ATTEMPTS = 10;
    // Properties
    private int[] number;
    private int[][] registry;
    private int attempts;
    private StateEnum state;
    private UserModel user;

    public GameModel(UserModel user) {
        this.user = user;
        this.number = new int[DIGITS];
        this.state = StateEnum.IN_GAME;
        this.registry = new int[ALLOWED_ATTEMPTS][3];
    }

    public void generateNumber() {
        do {
            for(int i = 0; i < DIGITS; ++i) {
                this.number[i] = (int)(Math.random() * 9);             
            }
        } while (!this.isValid(this.number));
        System.out.print(Arrays.toString(number));
    }

    public boolean isValid(int _number) {
        return this.isValid(this.intToArray(_number));        
    }

    public boolean isValid(int[] _number) {
        if(_number.length != this.number.length) { 
            return false;
        }

        for(int i = 0; i < DIGITS; ++i) {
            for(int j = 0; j < DIGITS; ++j) {
                boolean samePosition = (i == j);
                boolean sameNumber = (_number[i] == _number[j]);                
                if((_number[i] == 0) || (!samePosition && sameNumber)) {
                    return false;
                }
            }
        }
    
        return true;
    }

    public void guess(int _number) {
        int[] number = this.intToArray(_number);
        if(!this.isValid(number)) 
            return;

        int p = 0;
        int f = 0;

        for(int i = 0; i < DIGITS; ++i) {
            for(int j = 0; j < DIGITS; ++j) {
                boolean samePosition = (i == j);
                boolean sameNumber = (number[i] == this.number[j]);

                if(samePosition && sameNumber) f++;
                else if(sameNumber) p++;
            }
        }

        if(f == DIGITS) {
            this.state = StateEnum.WON;
        } else if(this.attempts >= (ALLOWED_ATTEMPTS - 1)) {
            this.state = StateEnum.LOST;
        }

        registry[this.attempts][0] = _number;
        registry[this.attempts][1] = p;
        registry[this.attempts][2] = f;
    
        this.attempts++;
    }

    private int[] intToArray(int _number) {
        String number = String.valueOf(_number);
        int[] digits = new int[number.length()];

        for(int i = 0; i < digits.length; i++) {
            char digit = number.charAt(i);
            digits[i] = Character.getNumericValue(digit);
        }
        
        return digits;
    }

     public int[] getNumber() {
        return this.number;
    }

    public int[][] getRegistry() {
        return this.registry;
    }

    public int getAttempts() {
        return this.attempts;
    }

    public StateEnum getState() {
        return this.state;
    }

    public UserModel getUser() {
        return this.user;
    }

}