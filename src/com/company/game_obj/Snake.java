package com.company.game_obj;

public class Snake extends GameObject {
    int currentLength;
    char tailChar;

    public Snake(int x, int y) {
        super(x, y, 'H');
    }

    public void collideWith(GameObject collision) {
        if (collision instanceof Wall) {
            System.out.println("Game over!");
            System.exit(0);
        } else if (collision instanceof Food) {
            System.out.println("Level up!");
        }

    }
}
