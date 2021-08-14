package com.company;

import com.company.game_obj.Food;
import com.company.game_obj.GameObject;
import com.company.game_obj.Snake;
import com.company.game_obj.Wall;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

public class GameController {
    private Snake snake;
    private List<GameObject> gameObjs;
    private GameScreen game;
    private Scanner scanner = new Scanner(System.in);


    private void init() {
        gameObjs = new CopyOnWriteArrayList<>();
        snake = new Snake(2, 3);

        gameObjs.add(new Food(3, 3));
        gameObjs.add(new Wall(3, 5));

        game = new GameScreen();


    }

    public void start() {
        init();
        mainLoop();
    }

    private void mainLoop() {
        while (true) {
            refreshScreen();
            userInput();
            updateGameState();
        }
    }

    private void updateGameState() {
        for (GameObject obj : gameObjs) {
            if (snake.isIntersecting(obj)) {
                System.out.println("Collide");
                snake.collideWith(obj);
                gameObjs.remove(obj);
                generateFood();

            }
        }

    }

    private void generateFood() {
        boolean newFoodGenerated = false;
        int counter = 0;
        while (!newFoodGenerated && counter < 3) {
            counter++;
            int newX = (int) (Math.random() * game.screenSize);
            int newY = (int) (Math.random() * game.screenSize);

            boolean intersectionFound = false;
            for (GameObject coll : gameObjs) {
                if (coll.isIntersecting(newX, newY) || snake.isIntersecting(newX, newY)) {
                    break;
                }
            }
            if (!intersectionFound) {
                gameObjs.add(new Food(newX, newY));
                newFoodGenerated = true;

            }

        }
    }

    private void userInput() {

        switch (scanner.nextLine().charAt(0)) {
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

    private void refreshScreen() {
        game.fillScreen();
        game.setObjectOnScreen(snake);
        for (GameObject drawable : gameObjs) {
            game.setObjectOnScreen(drawable);
        }
        game.printScreen();
    }


}
