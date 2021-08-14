package com.company;

import com.company.game_obj.Food;
import com.company.game_obj.GameObject;
import com.company.game_obj.Snake;
import com.company.game_obj.Wall;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameController {
    Snake snake;
    List<GameObject> gameObjs;
    GameScreen game;
    Scanner scanner = new Scanner(System.in);
    GameObject collision = null;


    private void  init(){
        gameObjs = new ArrayList<>();
        snake = new Snake(2,3);

        gameObjs.add(new Food(3,3));
        gameObjs.add(new Wall(3,5));

        game = new GameScreen();

    
    }

    public void start(){
        init();
        mainLoop();
    }

    private void mainLoop() {
        while (true){
            refreshScreen();
            userInput();


            updateGameState(collision);


        }
    }

    private void updateGameState(GameObject collision) {
        for(GameObject obj : gameObjs){
            if(snake.isIntersecting(obj)){
                snake.collideWith(obj);
                collision = obj;

            }
        }
        if (collision != null){
            gameObjs.remove(collision);
        }
    }

    private void userInput() {

        switch(scanner.nextLine().charAt(0)) {
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
        for(GameObject drawable : gameObjs){
            game.setObjectOnScreen(drawable);
        }
        game.printScreen();
    }


}
