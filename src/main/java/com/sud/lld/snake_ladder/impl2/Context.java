package com.sud.lld.snake_ladder.impl2;

public class Context {

    public void execute(Operation operation, Player player, int diceValue) {
        operation.doOperation(player, diceValue);
    }

}
