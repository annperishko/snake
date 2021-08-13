package com.company;

public abstract class GameObject {
    int x, y;
    char signOnScreen;

    public GameObject(int x, int y, char signOnScreen) {
        this.x = x;
        this.y = y;
        this.signOnScreen = signOnScreen;
    }
}
