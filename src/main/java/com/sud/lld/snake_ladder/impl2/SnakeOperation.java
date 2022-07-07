package com.sud.lld.snake_ladder.impl2;

public class SnakeOperation implements Operation {

    int decrementValue;

    public SnakeOperation(int decrementValue) {
        this.decrementValue = decrementValue;
    }

    @Override
    public Player doOperation(Player player, int newValue) {
        System.out.println("Snake bite");
        int pos = player.getPosition() + newValue - decrementValue;
        System.out.println(String.format("%s %s %s", player.getPosition(), newValue, decrementValue));
        player.setPosition(Math.max(pos, 0));

        return player;
    }
}