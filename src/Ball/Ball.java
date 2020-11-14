package Ball;

import Dimention.Dimention;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.Objects;

public class Ball extends Dimention {
    private Color ballColor;
//    private final static int sizeOfBall = 10;
    private static final int x = 775;
//    private int y;
    private static Ball instanceOfBall;
    private static Group group;
    private Circle circle;

    public static Ball getInstance(Color ballColor, int y, Group group) {
        if (instanceOfBall == null) {
            instanceOfBall = new Ball(ballColor, y);
            Ball.group = group;
            instanceOfBall.init();
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

//    public static int getSizeOfBall() {
//        return sizeOfBall;
//    }

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

    public void changeColor (Color ballColor) {
        // TODO: Change color randomly
        circle.setFill(ballColor);
    }

    public void init () {

        circle = new Circle();
        circle.setCenterX(x);
        circle.setCenterY(y);//y = 700
        circle.setRadius(25);
        circle.setFill(ballColor);

        group.getChildren().addAll(circle);


    }
    private final int transition = 4000000;
    private volatile boolean isMovingUp = false;
    public void ballMoveDown () {
//        //TODO: make a loop for gravity
//        Runnable runnable = () -> {
//                for (double i = 0; i < 1000000000; i++) {
//                    if (isMovingUp) {
//                        break;
//                    }
//                    if (circle.getCenterY() != y) {
//                        if (isMovingUp) {
//                            break;
//                        }
//                        if (i/transition == 1) {
//                            circle.setCenterY(circle.getCenterY() + 1);
//                            i = i/transition;
//                        }
//                    }
//                }
//        };
//
//        Thread jumpingThread = new Thread(runnable);
//        jumpingThread.start();

//        newX = newX + 10;
//        circle.setTranslateX(newX);


    }

    private int jumpHight;
    public void jump () {
        //TODO: set button functions for up movement

        jumpHight += 100;

        Runnable runnable = () -> {
            while (jumpHight > 0) {


                if (isMovingUp) {

                    //Wait
                }

                isMovingUp = true;
                for (double i = 0; i < 1000000000; i++) {
                    if (jumpHight <= 0) {
                        break;
                    }
                    if (i/transition == 1) {
                        circle.setCenterY(circle.getCenterY() - 1);
                        jumpHight--;
                        i = i/transition;
                    }


                }

                jumpHight-=100;
                isMovingUp = false;
                ballMoveDown();


            }


        };

        Thread jumpingThread = new Thread(runnable);
        jumpingThread.start();
    }


    private void changeColor (){
        ColorChanger changer = new ColorChanger(instanceOfBall);
        changer.changeColor();
    }

    public static Ball giveCopy () {
        return instanceOfBall;
    }



}
