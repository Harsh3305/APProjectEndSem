package Activity.PlayGame;

import Ball.Ball;
import SaveGame.SaveGame;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import sample.Main;


public class PlayGame {


    public void startNewGame () {


        Group group = new Group();

        //TODO: Do Button style

        Button saveGameButton = new Button("Save the Game");
        saveGameButton.setLayoutX(1350);
        saveGameButton.setLayoutY(50);
        saveGameButton.setScaleX(2);
        saveGameButton.setScaleY(2);



//        Pane canvas = new Pane();
//        final Scene scene = new Scene(canvas, 800, 600);
//        group.getChildren().add(canvas);
//        canvas.setLayoutX(800);
//        canvas.setLayoutY(600);


        Scene scene = Main.getScene();

        Circle circle = new Circle(15, Color.ROYALBLUE);
        circle.relocate(750, 500);
        group.getChildren().add(circle);

        final Timeline loop = new Timeline(new KeyFrame(Duration.millis(10), new
                EventHandler<>() {
                    double dx = 0;
                    double dyUp = 3;
                    double dyDown = -1;
                    double dy = dyUp;
                     final double UpLimit = 30;

                    @Override
                    public void handle(final ActionEvent t) {
                        circle.setLayoutX(circle.getLayoutX() + dx);
                        circle.setLayoutY(circle.getLayoutY() + dy);



                        if (circle.getLayoutY() >= 775 )
                            dy = dyDown;
                        if (circle.getLayoutY() <= 10) {

                            dy = dyUp;
                        }
                    }
                }));
        loop.setCycleCount(Timeline.INDEFINITE);


        scene.setOnKeyPressed(keyEvent -> {
            loop.play();
            System.out.println(keyEvent.getCode());
        });





        saveGameButton.setOnAction(actionEvent -> {
            SaveGame saveGame =new SaveGame();
            saveGame.SaveGame();
        });

        group.getChildren().add(saveGameButton);

        Text Stars = new Text("Stars: 0");
        Stars.setScaleX(2);
        Stars.setScaleY(2);
        Stars.setLayoutX(750);
        Stars.setLayoutY(100);
        Stars.setFill(Paint.valueOf("#D4AF37"));

        group.getChildren().add(Stars);

        // Background Color
//        Color black = Color.rgb(42, 40, 42);
//        Ball ball = Ball.getInstance(Color.RED, 700,group);
//        ball.init();



        Main.udpateScene(group);
    }

    private void putBall () {

    }

    public void GameOver () {
        // TODO: play game over sound and display message
    }

    public void resume (SaveGame saveGame) {
        //TODO: Take SaveGame as argument

    }

    public static void keyDetect () {
        //TODO:
//        Ball ball = Ball.giveCopy();
//        ball.init();
//        ball.jump();
    }


}
