package Ball;

import Dimention.Dimention;
import SaveGame.SerialCode;
import animatefx.animation.BounceInUp;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.awt.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.TimerTask;

public class Ball extends Dimention implements Serializable {
    private Color ballColor;
    private static final long serialVersionUID = SerialCode.serialVersionUID;
    private static final int x = 775;
    private static Ball instanceOfBall;
    private static Group group;
    private Circle circle;

    private final Timeline upLoop,downLoop;

    public static Ball getInstance(Color ballColor, int y, Group group) {
        if (instanceOfBall == null) {
            instanceOfBall = new Ball(ballColor, y);
            Ball.group = group;



//            instanceOfBall.init();
        }
        return instanceOfBall;
    }

    public static void setBall (Ball ball) {
        instanceOfBall = ball;
    }
    private int maxUp = 10;// TODO: Change from 100 to 10
    private Ball(Color ballColor, int y) {
        this.ballColor = ballColor;
        this.downLoop = new Timeline(new KeyFrame(Duration.millis(16), new
                EventHandler<>() {
                    double dx = 0;
                    double dyUp = 6;
                    double dyDown = -3;
                    double dy = dyDown;

                    @Override
                    public void handle(final ActionEvent t) {
                        circle.setLayoutX(circle.getLayoutX() + dx);
                        circle.setLayoutY(circle.getLayoutY() + dy);
                        if (circle.getLayoutY()  <= 755)
                            dy = dyUp;

                        else {
                            dy = 0;
                        }
                    }
                }));

        downLoop.setCycleCount(Timeline.INDEFINITE);
        downLoop.play();

        this.upLoop = new Timeline(new KeyFrame(Duration.millis(16), new
                EventHandler<>() {
                    double dx = 0;
                    double dyUp = 6;
                    double dyDown = -3;
                    double dy = dyDown;

                    @Override
                    public void handle(final ActionEvent t) {
                        circle.setLayoutX(circle.getLayoutX() + dx);
                        circle.setLayoutY(circle.getLayoutY() + dy);
                        if (circle.getLayoutY() >= 10 && maxUp > 0) {
                            dy = dyDown;
                            maxUp--;
                        }
                        else {
                            dy=0;
                        }
                    }
                }));
        upLoop.setCycleCount(Timeline.INDEFINITE);

        this.y = y;
    }

    public Color getBallColor() {
        return ballColor;
    }

    public void setBallColor(Color ballColor) {
        this.ballColor = ballColor;
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

    public void changeColor (Color ballColor) {
        // TODO: Change color randomly
        circle.setFill(ballColor);
    }

    public void init () {
        circle = new Circle();
        circle.relocate(x,y);

        circle.setRadius(25);
        circle.setFill(ballColor);

        group.getChildren().addAll(circle);



        Timeline masterThread = new Timeline(new KeyFrame(Duration.millis(100), new
                EventHandler<>() {

                    @Override
                    public void handle(final ActionEvent t) {

                        String up = upLoop.getStatus().toString();
                        String down = downLoop.getStatus().toString();

                        System.out.println(up + " " + down);


                        if (up.equals("RUNNING") && down.equals("RUNNING")) {
                            downLoop.pause();
                        }

                        else if (!up.equals("RUNNING") && ! down.equals("RUNNING")) {
                            maxUp = 0;
                            downLoop.play();
                        }

                        else if (maxUp <= 0) {
                            if (up.equals("RUNNING")) {
                                upLoop.pause();
                            }
                            if (down.equals("STOPPED") || down.equals("PAUSED")) {
                                downLoop.play();
                            }
                        }

                        else if (circle.getLayoutY() <= 10) {
                            if (up.equals("RUNNING")) {
                                upLoop.pause();
                            }

                            if (down.equals("STOPPED") || down.equals("PAUSED")) {
                                downLoop.play();
                            }
                        }

                        else {
                            if (down.equals("RUNNING")) {
                                downLoop.pause();
                            }

                        }

                    }
                }));
        masterThread.setCycleCount(Timeline.INDEFINITE);
        masterThread.play();




    }
    private final int transition = 3500000;
    private volatile boolean isMovingUp = false;


    private int jumpHight;
    public void jump () {

        upLoop.pause();
        maxUp=10;// TODO: Change from 100 to 10
        upLoop.play();



    }
//
//    private int stepInOneKey ;
//    private Timeline loop;
//    private void initLoop () {
//        stepInOneKey = 200;
//                loop = new Timeline(new KeyFrame(Duration.millis(10), new
//                EventHandler<>() {
//                    double dx = 0;
//                    double dyUp = 3;
//                    double dyDown = -1;
//                    double dy = dyDown;
//
//                    @Override
//                    public void handle(final ActionEvent t) {
//                        circle.setLayoutX(circle.getLayoutX() + dx);
//                        circle.setLayoutY(circle.getLayoutY() + dy);
////                        if (circle.getLayoutY() >= 775  )
////                            dy = dyDown;
////                        if (circle.getLayoutY() <= 10 || stepInOneKey <= 0) {
////                            dy = dyUp;
////                        }
//
//                        if (stepInOneKey > 0) {
//                            dy = dyDown;
//                            stepInOneKey--;
//                        }
//                        else {
//                            dy = dyUp;
//                        }
//
//
//                    }
//                }));
//        loop.setCycleCount(Timeline.INDEFINITE);
//
//
//
//    }

    private void changeColor (){
        ColorChanger changer = new ColorChanger(instanceOfBall);
        changer.changeColor();
    }

    public static Ball giveCopy () {
        return instanceOfBall;
    }



}
