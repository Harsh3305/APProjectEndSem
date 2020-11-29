package Obstacle;

import Activity.HomeActivity.HomeActivity;
import Ball.Ball;
import Dimention.Dimention;
import SaveGame.Score;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import sample.Controller;

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


    public static void updateList (ArrayList<Obstacle> obstacleArrayList ) {
        Obstacle.obstacleArrayList = obstacleArrayList;
    }

    private ColorPattern pattern;
    private static ArrayList<Obstacle> obstacleArrayList = new ArrayList<Obstacle>();
    private Obstacle(Group group,int y) {
//        this.shape2D = shape2D;
////        this.size = size;
////        this.yCoor = yCoor;
//        this.radius = 0;
        this.y = y;//400
        this.x = Ball.giveCopy().getX();;//center
//        this.pattern = pattern;

        creatObstacle(group);

    }

    public static Obstacle getInstance(Group group,int y) {
        Obstacle obstacle = new Obstacle(group,y);
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

    private void creatObstacle (Group group) {

        int Cx,Cy;

        Cx = getX();
        Cy = y;

        Arc arc = new Arc();

        arc.setCenterX(Cx);
        arc.setCenterY(Cy);
        arc.setRadiusX(150.0f);
        arc.setRadiusY(150.0f);
        arc.setStartAngle(0);
        arc.setLength(90.0f);
        arc.setFill(javafx.scene.paint.Paint.valueOf("FF0080"));
        arc.setType(ArcType.ROUND);
//        group.getChildren().add(arc);

        Arc arc1 = new Arc();
        arc1.setCenterX(Ball.giveCopy().getX());
        arc1.setCenterY(Cy);
        arc1.setRadiusX(150.0f);
        arc1.setRadiusY(150.0f);
        arc1.setStartAngle(90f);
        arc1.setLength(50+25*Math.PI/2);
//       arc1.setRotate(-90);
        arc1.setType(ArcType.ROUND);
        arc1.setFill(javafx.scene.paint.Paint.valueOf("8D13FA"));
//        group.getChildren().add(arc1);

        Arc arc2 = new Arc();
        arc2.setCenterX(Ball.giveCopy().getX());
        arc2.setCenterY(Cy);
        arc2.setRadiusX(150.0f);
        arc2.setRadiusY(150.0f);
        arc2.setStartAngle(180.f);
        arc2.setLength(50+25*Math.PI/2);
//        arc2.setRotate(-180);
        arc2.setType(ArcType.ROUND);
        arc2.setFill(javafx.scene.paint.Paint.valueOf("36E1F3"));
//        group.getChildren().add(arc2);

        Arc arc3 = new Arc();
        arc3.setCenterX(Ball.giveCopy().getX());
        arc3.setCenterY(Cy);
        arc3.setRadiusX(150.0f);
        arc3.setRadiusY(150.0f);
        arc3.setStartAngle(270f);
        arc3.setLength(50+25*Math.PI/2);
        arc3.setType(ArcType.ROUND);
        arc3.setFill(javafx.scene.paint.Paint.valueOf("F7DE0F"));
//        group.getChildren().add(arc3);

//        System.out.println(arc.getLayoutX() + " ");

        Circle del=new Circle();
        del.setCenterY(Cy);
        del.setCenterX(Ball.giveCopy().getX());
        del.setRadius(120f);

        fetchImageOfStar(Ball.giveCopy().getX(), Cy,group);
//
//        Circle star = new Circle();
//        star.setRadius(50);
////        javafx.scene.image.Image im = new Image("file:star.png",false);
//        star.setCenterX(Ball.giveCopy().getX());
//        star.setCenterY(Cy);
//        star.setFill(Color.RED);
////        star.setFill(new ImagePattern(im));
////        star.setEffect(new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN));
//
//        group.getChildren().add(star);

        javafx.scene.shape.Shape shape= javafx.scene.shape.Shape.subtract(arc, javafx.scene.shape.Shape.intersect(arc,del));
//        shape.setFill(Paint.valueOf("FF0080"));
        shape.setFill(javafx.scene.paint.Color.rgb(141,19,250));
        javafx.scene.shape.Shape shape1= javafx.scene.shape.Shape.subtract(arc1, javafx.scene.shape.Shape.intersect(arc1,del));
        shape1.setFill(javafx.scene.paint.Color.rgb(247,222,15));
        javafx.scene.shape.Shape shape2= javafx.scene.shape.Shape.subtract(arc2, javafx.scene.shape.Shape.intersect(arc2,del));
        shape2.setFill(javafx.scene.paint.Color.rgb(253,0,128));
        javafx.scene.shape.Shape shape3= javafx.scene.shape.Shape.subtract(arc3, Shape.intersect(arc3,del));
        shape3.setFill(Color.rgb(54,225,243));



        Rotate r1 = new Rotate();
        r1.setPivotX(Ball.giveCopy().getX());
        r1.setPivotY(Cy);


        shape1.getTransforms().add(r1);
        shape2.getTransforms().add(r1);
        shape3.getTransforms().add(r1);
        shape.getTransforms().add(r1);

        group.getChildren().addAll(shape);
        group.getChildren().addAll(shape1);
        group.getChildren().addAll(shape2);
        group.getChildren().addAll(shape3);

        RotateThread(r1,shape,shape1,shape2,shape3,Cy,group);


    }
    private static boolean isGameOver;
    private static ArrayList<Timeline> timelines = new ArrayList<>();
    public static void GameOver () {
        isGameOver = true;
        for (int i = 0; i < timelines.size(); i++) {
            timelines.get(i).pause();
        }
    }




    private void RotateThread (Rotate rotate, Shape s1,Shape s2,Shape s3,Shape s4,int Cy,Group slave) {
        Timeline loop =  new Timeline(new KeyFrame(Duration.millis(16), new
                EventHandler<>() {
                    double dTheta = 1;

                    @Override
                    public void handle(final ActionEvent t) {
                        rotate.setAngle(rotate.getAngle() + dTheta);
                        Ball ball = Ball.giveCopy();
                        Circle circleBall = ball.getCircle();

                        Shape intersect1 = Shape.intersect(circleBall, s1);
                        Shape intersect2 = Shape.intersect(circleBall, s2);
                        Shape intersect3 = Shape.intersect(circleBall, s3);
                        Shape intersect4 = Shape.intersect(circleBall, s4);

                        int x = (int)slave.getLayoutY();
                        int y = ball.getY();
                        int d = Math.abs(x-y);
                        if (d > 200) {
                            System.out.println("Returned");
                            return;
                        }
//                        long moved = Ball.giveCopy().getSlavedMoved();
                        if (intersect1.getBoundsInParent().getWidth() > 0 && ! (Math.abs(ball.getY()  - Cy) <=20)) {
//                            System.out.println(ball.getBallColor().toString() + " " + s1.getFill().toString());

                            if (! ball.getBallColor().equals(s1.getFill())) {
                                //Game Over
                                intersect1.setFill(Color.BLACK);
                                new HomeActivity().gameOver();
                                System.out.println(Math.abs(x-y));

                            }
                            else {
                                System.out.println("Pass");
                            }

                        }

                        else if (intersect2.getBoundsInParent().getWidth() > 0) {
//                            System.out.println(ball.getBallColor().toString() + " " + s2.getFill().toString());
                            if (! ball.getBallColor().equals(s2.getFill())) {
                                //Game Over
                                intersect2.setFill(Color.BLACK);
                                System.out.println(ball.getBallColor().toString()+" "+s2.getFill().toString());
                                new HomeActivity().gameOver();
                                System.out.println(Math.abs(x-y));
                            }
                            else {
                                System.out.println("Pass");

                            }
                        }
                        else if (intersect3.getBoundsInParent().getWidth() > 0) {
//                            System.out.println(ball.getBallColor().toString() + " " + s3.getFill().toString());
                            if (!ball.getBallColor().equals(s3.getFill())) {
                                //Game Over
                                intersect3.setFill(Color.BLACK);
                                System.out.println(Math.abs(x-y));
                                new HomeActivity().gameOver();
                            } else {
                                System.out.println("Pass");

                            }
                        }
                        else if (intersect4.getBoundsInParent().getWidth() > 0) {
//                            System.out.println(ball.getBallColor().toString() + " " + s4.getFill().toString());
                            if (!ball.getBallColor().equals(s4.getFill())) {
                                //Game Over
                                intersect3.setFill(Color.BLACK);
                                new HomeActivity().gameOver();
                                System.out.println(Math.abs(x-y));
                            } else {
                                System.out.println("Pass");
                            }
                        }



                    }
                }));

        loop.setCycleCount(Timeline.INDEFINITE);
        loop.play();

        timelines.add(loop);
    }


    private void fetchImageOfStar (int x,int y, Group slaveGroup) {
        Circle star = new Circle();
        javafx.scene.image.Image im = new Image("file:star.png",false);
        star.setLayoutX(x);
        star.setFill(new ImagePattern(im));
        star.setEffect(new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN));
        slaveGroup.getChildren().add(star);

        star.setLayoutY(y);
        star.setStyle("-fx-background-color: transparent;");
        star.setRadius(30);
        Timeline starLoop =  new Timeline(new KeyFrame(Duration.millis(16), new
                EventHandler<>() {
                    @Override
                    public void handle(final ActionEvent t) {

                        Circle ball = Ball.giveCopy().getCircle();

                        Shape intersect = Shape.intersect(ball,star);

                        if (intersect.getBoundsInParent().getWidth() > 0) {
                            Score.giveCopy().increamentScore();
                            new Controller().playStarMusic();
                            star.setLayoutY(0);
                            star.setLayoutX(0);
                            star.setVisible(false);
                        }
                    }
                }));

        starLoop.setCycleCount(Timeline.INDEFINITE);
        starLoop.play();


    }



}
