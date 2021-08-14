package com.company.game_obj;

public class Food extends GameObject {

    int growthFactor;

    public Food(int x, int y) {
        super(x, y, '*');
        this.growthFactor = 1;
    }


    /*void create() {
    }

    void destroy() {
    }
*/

}
