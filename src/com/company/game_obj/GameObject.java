package com.company.game_obj;

public abstract class GameObject {
    public int x, y;
    public char signOnScreen;

    public GameObject(int x, int y, char signOnScreen) {
        this.x = x;
        this.y = y;
        this.signOnScreen = signOnScreen;
    }

    public boolean isIntersecting(GameObject other) {
        return this.x == other.x && this.y == other.y;
    }

    public boolean isIntersecting(int x, int y) {
        return this.x == x && this.y == y;
    }
}
