package com.sud.lld.snake_ladder.impl2;


public class NoOpOperation implements Operation {

    @Override
    public Player doOperation(Player player, int newValue) {
        int pos = player.getPosition() + newValue;
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