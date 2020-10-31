package ColorSwitch;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

import java.awt.event.KeyEvent;
import java.util.Objects;

public class Ball {
    private Color ballColor;
    private final static int sizeOfBall = 10;
    private static final int x = 775;
    private int y;
    private static Ball instanceOfBall;

    public static Ball getInstance(Color ballColor, int y) {
        if (instanceOfBall == null) {
            instanceOfBall = new Ball(ballColor, y);
        }
        return instanceOfBall;
    }


    private Ball(Color ballColor, int y) {
        this.ballColor = ballColor;
        this.y = y;
    }

    public Color getBallColor() {
        return ballColor;
    }

    public void setBallColor(Color ballColor) {
        this.ballColor = ballColor;
    }

    public static int getSizeOfBall() {
        return sizeOfBall;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return x == ball.x &&
                y == ball.y &&
                ballColor.equals(ball.ballColor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ballColor, x, y);
    }

    @Override
    public String toString() {
        return "Ball{" +
                "ballColor=" + ballColor +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

    public void changeColor () {
        // TODO: Change color randomly
    }

    public void init () {
        Circle circle = new Circle();
        circle.setCenterX(775);
        circle.setCenterY(700);
        circle.setRadius(25);
        circle.setFill(Color.RED);
    }

    public static void ballMove () {
        Path path = new Path();
        //TODO: make a loop for gravity
        path.getElements().add(new MoveTo(x, 700));
        path.getElements().add(new LineTo(x, 600));
        path.getElements().add(new LineTo(x, 500));
        path.getElements().add(new LineTo(x, 400));
    }

    public static void jump () {
        //TODO: set button functions for up movement
        instanceOfBall.y-=100;
    }




}
