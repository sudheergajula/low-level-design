package com.sud.lld.snake_ladder.impl2;


import java.util.Random;

public class Game1 {
    final static Operation[] board = new Operation[100];
    static Random random = new Random();

    static {
        board[5] = new SnakeOperation(3);
        board[8] = new SnakeOperation(1);
        board[23] = new SnakeOperation(9);
        board[45] = new SnakeOperation(12);
        board[56] = new SnakeOperation(7);

        board[2] = new LadderOperation(3);
        board[18] = new LadderOperation(1);
        board[43] = new LadderOperation(9);
        board[49] = new LadderOperation(12);
        board[65] = new LadderOperation(7);
    }

    public static int rollDice() {
        return random.ints(1, 6)
                .findFirst()
                .getAsInt();
    }

    public static void start() throws InterruptedException {
        Player player1 = new Player();

        while (!player1.isWon()) {
            int value = rollDice();
            Context ctx = new Context();
            int i = Math.min(player1.getPosition() + value, 99);
            Operation operation = board[i] == null ? new NoOpOperation() : board[i];
            ctx.execute(operation, player1, value);
            System.out.println(player1.getPosition());
            Thread.sleep(50);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        start();
    }
}
