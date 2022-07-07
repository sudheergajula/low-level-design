package com.sud.lld.snake_ladder;

public class Game {
    public static void main(String[] args) throws InterruptedException {
        Player player1 = new Player("Sudheer");


        while (true){
            player1.rollDice();
            System.out.println(player1.getPosition());
            Thread.sleep(5000);
        }
    }


}
