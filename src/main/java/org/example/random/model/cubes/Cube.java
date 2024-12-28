package org.example.random.model.cubes;

public abstract class Cube {
    private final int sides;
    public Cube(int sides){
        this.sides = sides;
    }

    public int getSides() {
        return sides;
    }
}
