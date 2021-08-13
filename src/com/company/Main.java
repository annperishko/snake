package com.company;

import com.company.game_obj.Food;
import com.company.game_obj.Snake;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Snake snake = new Snake(2,3);
        Food food = new Food(3,3);
        GameScreen game = new GameScreen();

        game.fillScreen();

        while (true){
            game.fillScreen();
            game.setObjectOnScreen(food);
            game.setObjectOnScreen(snake);
            game.printScreen();

            char input = scanner.nextLine().charAt(0);

            switch(input) {
                case 'a':
                    snake.x = snake.x - 1;
                    break;
                case 'w':
                    snake.y = snake.y - 1;
                    break;
                case 's':
                    snake.y = snake.y + 1;
                    break;
                case 'd':
                    snake.x = snake.x + 1;
                    break;

            }



        }



    }
}
