package Activity.PlayGame;

import Activity.PauseActivity.PauseActivity;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.util.Duration;
import sample.Main;


public class PlayGame {


    private PlayGame (){}
    private static PlayGame instance;
    public static PlayGame getInstance() {
        if (instance == null) {
            instance = new PlayGame();
        }
        return instance;
    }


    private SaveGame saveGame;
    public void startNewGame () {


        Group group = new Group();

        int x = 750;
        int y = 500;
        int score = 0;
        if (saveGame != null) {
            score = saveGame.getScore();
        }
        //TODO: Do Button style

        PauseGameButton = new Button("Pause");
        PauseGameButton.setLayoutX(1350);
        PauseGameButton.setLayoutY(50);
        PauseGameButton.setScaleX(2);
        PauseGameButton.setScaleY(2);





        Scene scene = Main.getScene();
        Ball ball = Ball.getInstance(Color.BLUE,y,group);
        ball.init();

        scene.setOnKeyPressed(keyEvent -> {
            ball.jump();
            System.out.println(keyEvent.getCode());
        });



        PauseGameButton.setOnMouseClicked(mouseEvent -> {
            onPause();
            PauseActivity activity = new PauseActivity();
            activity.show();
        });


        group.getChildren().add(PauseGameButton);

        Text Stars = new Text("Stars: "  +score );
        Stars.setScaleX(2);
        Stars.setScaleY(2);
        Stars.setLayoutX(750);
        Stars.setLayoutY(100);
        Stars.setFill(Paint.valueOf("#D4AF37"));

        group.getChildren().add(Stars);

        Main.udpateScene(group);
    }
    private Button PauseGameButton;

    private void onPause () {
        PauseGameButton.setVisible(false);
        Ball ball = Ball.giveCopy();
        ball.pause();
    }
    public void onResume () {
        PauseGameButton.setVisible(true);
        Ball ball = Ball.giveCopy();
        ball.resume();
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
    }


}
