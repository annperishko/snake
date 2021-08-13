package com.company;

public class GameScreen {
    int screenSize = 10;
    char empty = '-';
    char[][] screen = new char[screenSize][screenSize];


    //fills screen with blank cells
    void fillScreen() {
        for (int i = 0; i < screenSize; i++) {
            for (int j = 0; j < screenSize; j++) {
                screen[i][j] = empty;
            }
        }

    }

    void printScreen() {
        for (int i = 0; i < screenSize; i++) {
            for (int j = 0; j < screenSize; j++) {
                System.out.print(screen[j][i] + "  ");
            }
            System.out.println();
        }

    }

    void setObjectOnScreen(GameObject o){
        screen[o.x][o.y] = o.signOnScreen;

    }



}
