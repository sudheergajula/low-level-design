package com.sud.lld.snake_ladder.impl2;

public class Player {

    private int position;
    public static final int MAX_VALUE = 100;
    private int lastDiceValue;

    public Player() {
        this.position = 0;
        this.lastDiceValue = 0;
        this.won = false;
    }

    public boolean isWon() {
        return won;
    }

    public void setWon(boolean won) {
        this.won = won;
    }

    boolean won;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getLastDiceValue() {
        return lastDiceValue;
    }

    public void setLastDiceValue(int lastDiceValue) {
        this.lastDiceValue = lastDiceValue;
    }
}
