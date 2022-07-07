package com.sud.lld.snake_ladder;

import java.util.Random;

public class Player {

    private static Operation[] operations = new Operation[100];
    private int position;
    public static final int MAX_VALUE = 100;
    Random random = new Random();

    private static Operation[] getBoard() {
        for (int i = 0; i < 100; i++) {
            operations[i] = new Operation(OperationType.NONE, 0);
        }
        operations[5] = new Operation(OperationType.LADDER, 5);
        operations[21] = new Operation(OperationType.LADDER, 12);
        operations[33] = new Operation(OperationType.LADDER, 8);
        operations[23] = new Operation(OperationType.SNAKE, -8);
        operations[41] = new Operation(OperationType.SNAKE, -9);
        operations[36] = new Operation(OperationType.SNAKE, -9);
        operations[22] = new Operation(OperationType.SNAKE, -9);
        operations[29] = new Operation(OperationType.SNAKE, -9);
        operations[55] = new Operation(OperationType.SNAKE, -9);
        operations[63] = new Operation(OperationType.SNAKE, -9);
        operations[72] = new Operation(OperationType.SNAKE, -9);
        operations[99] = new Operation(OperationType.SNAKE, -9);

        return operations;
    }

    public Player(String name) {
        operations = Player.getBoard();
        position = 0;
    }

    public int getPosition() {
        return position;
    }

    public void rollDice() {
        int diceValue = getRandomNumberUsingInts();
        System.out.println("Dice value = " + diceValue);
        int newValue = position + diceValue;
        if (newValue > 100) {
            return;
        }
        if (operations[newValue].operationType != OperationType.NONE) {
            System.out.println("Encountered " + operations[newValue].operationType.toString());
            position = Math.max(operations[newValue].value + position, 0);
        } else {
            position = newValue;
        }
    }

    public int getRandomNumberUsingInts() {
        return random.ints(1, 6)
                .findFirst()
                .getAsInt();
    }
}
