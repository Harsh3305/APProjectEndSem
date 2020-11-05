package Obstacle;

import java.util.Objects;

public class Obstacle {
    private Shape2D shape2D;
    private int size;
    private final int xCoor = 0;
    private int yCoor = 0;

    private ColorPattern pattern;

    public Obstacle(Shape2D shape2D, int size, int yCoor, ColorPattern pattern) {
        this.shape2D = shape2D;
        this.size = size;
        this.yCoor = yCoor;
        this.pattern = pattern;
    }

    public Shape2D getShape() {
        return shape2D;
    }

    public void setShape(Shape2D shape2D) {
        this.shape2D = shape2D;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getxCoor() {
        return xCoor;
    }

    public int getyCoor() {
        return yCoor;
    }

    public void setyCoor(int yCoor) {
        this.yCoor = yCoor;
    }

    public ColorPattern getPattern() {
        return pattern;
    }

    public void setPattern(ColorPattern pattern) {
        this.pattern = pattern;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Obstacle obstacle = (Obstacle) o;
        return size == obstacle.size &&
                xCoor == obstacle.xCoor &&
                yCoor == obstacle.yCoor &&
                Objects.equals(shape2D, obstacle.shape2D) &&
                Objects.equals(pattern, obstacle.pattern);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shape2D, size, xCoor, yCoor, pattern);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
