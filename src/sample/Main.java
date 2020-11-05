package sample;

import Background.BackgroundOfGame;
import Ball.Ball;
import SaveGame.SaveGame;
import SaveGame.Score;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setFullScreen(true);
           primaryStage.setTitle("Game");
        Group group = new Group();
        Ball playerBall  = Ball.getInstance(Color.RED, 700,group);

        Scene scene = new Scene(group,400,500,Color.GRAY);
        detectKey(scene,playerBall);
        primaryStage.setScene(scene);
        primaryStage.show();
        SaveGame saveGame = new SaveGame();
        Score score =  saveGame.givePrevGame();

        BackgroundOfGame backgroundOfGame = new BackgroundOfGame();
        backgroundOfGame.setBackgroundOfGame();

        if (score==null) {
            // new game
        }
        else {
            // prev game
        }

    }


    public static void increamentScre (Score score) {
        score.increamentScore();
    }



    public static void detectKey (Scene scene, Ball playerBall) {

        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case UP -> jumpBall(playerBall);
            }
        });
    }
    public static void jumpBall (Ball ball) {
        ball.jump();
    }

    public static void main(String[] args) {
        launch(args);
    }
}