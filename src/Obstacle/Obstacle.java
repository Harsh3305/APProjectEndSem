package Obstacle;

import Dimention.Dimention;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Obstacle extends  Dimention  implements Serializable {
    private Shape2D shape2D;
//    private int size;
//    private final int xCoor = 0;
//    private int yCoor = 0;

    private ColorPattern pattern;
    private static ArrayList<Obstacle> obstacleArrayList = new ArrayList<Obstacle>();
    private Obstacle(Shape2D shape2D, int size, int yCoor, ColorPattern pattern) {
        this.shape2D = shape2D;
//        this.size = size;
//        this.yCoor = yCoor;
        this.radius = 0;
        this.y = yCoor;
        this.x = 0;//center
        this.pattern = pattern;
    }

    public static Obstacle getInstance(Shape2D shape2D, int size, int yCoor, ColorPattern pattern) {
        Obstacle obstacle = new Obstacle(shape2D,size,yCoor,pattern);

        obstacleArrayList.add(obstacle);

        return obstacle;
    }

    public Shape2D getShape() {
        return shape2D;
    }

    public void setShape(Shape2D shape2D) {
        this.shape2D = shape2D;
    }

    public int getSize() {
        return radius;
    }

    public void setSize(int size) {
        this.radius = size;
    }

    public int getxCoor() {
        return x;
    }

    public int getyCoor() {
        return y;
    }

    public void setyCoor(int yCoor) {
        this.y = yCoor;
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
        return Objects.equals(shape2D, obstacle.shape2D) &&
                Objects.equals(pattern, obstacle.pattern);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shape2D, pattern);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void rotate () {
        //TODO:
    }

    public static void createStars () {

    }

    public static ArrayList<Obstacle> giveCopy () {
        return obstacleArrayList;
    }

}
