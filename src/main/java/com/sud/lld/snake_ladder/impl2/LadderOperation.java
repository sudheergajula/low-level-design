package com.sud.lld.snake_ladder.impl2;

public class LadderOperation implements Operation {

    int incrementValue;

    public LadderOperation(int incrementValue) {
        this.incrementValue = incrementValue;
    }


    @Override
    public Player doOperation(Player player, int newValue) {
        System.out.println("Ladder climb");
        int pos = player.getPosition() + newValue + incrementValue;
        System.out.println(String.format("%s %s %s", player.getPosition(), newValue, incrementValue));
        if (pos > 100)
            player.setPosition(player.getPosition());
        else if (pos == 100) {
            player.setPosition(pos);
            player.setWon(true);
        } else
            player.setPosition(pos);
        return player;
    }
}