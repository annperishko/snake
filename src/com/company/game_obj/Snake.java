package com.company.game_obj;

import com.company.GameObject;

public class Snake extends GameObject {
    int currentLength;
    float speed;
    char bodyChar;

    char tailChar;


    public Snake(int x, int y) {
        super(x, y, 'H');
    }
}
