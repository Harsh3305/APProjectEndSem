package Activity.PlayGame;

import Ball.Ball;
import Obstacle.Obstacle;
import SaveGame.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.util.Duration;
import sample.Main;


public class PlayGame {

    private SaveGame saveGame;
    public void startNewGame () {


        Group group = new Group();

        int x = 750;
        int y = 500;
        int score = 0;
        if (saveGame != null) {
//            x = saveGame.getBall().getX();
//            y = saveGame.getBall().getY();
            score = saveGame.getScore();
        }
        //TODO: Do Button style

        Button saveGameButton = new Button("Save the Game");
        saveGameButton.setLayoutX(1350);
        saveGameButton.setLayoutY(50);
        saveGameButton.setScaleX(2);
        saveGameButton.setScaleY(2);





        Scene scene = Main.getScene();
        Ball ball = Ball.getInstance(Color.BLUE,y,group);
        ball.init();

        scene.setOnKeyPressed(keyEvent -> {
            ball.jump();



            System.out.println(keyEvent.getCode());
        });





        saveGameButton.setOnAction(actionEvent -> {
            SaveGame saveGame =new SaveGame();
            saveGame.SaveGame();
        });

        group.getChildren().add(saveGameButton);

        Text Stars = new Text("Stars: "  +score );
        Stars.setScaleX(2);
        Stars.setScaleY(2);
        Stars.setLayoutX(750);
        Stars.setLayoutY(100);
        Stars.setFill(Paint.valueOf("#D4AF37"));

        group.getChildren().add(Stars);



        Main.udpateScene(group);
    }

    private void putBall () {

    }

    public void GameOver () {
        // TODO: play game over sound and display message
    }

    public void resume (SaveGame saveGame) {
        //TODO: Take SaveGame as argument
//        Ball ball = saveGame.getBall();
//        Ball.setBall(ball);
        Score.updateScore(saveGame.getScore());
        Obstacle.updateList(saveGame.getObstacleArrayList());
        this.saveGame = saveGame;
        startNewGame();

    }

    public static void keyDetect () {
        //TODO:
//        Ball ball = Ball.giveCopy();
//        ball.init();
//        ball.jump();
    }


}
