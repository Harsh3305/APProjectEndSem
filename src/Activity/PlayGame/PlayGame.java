package Activity.PlayGame;

import Activity.HomeActivity.HomeActivity;
import Activity.PauseActivity.PauseActivity;
import Ball.*;
import Obstacle.Obstacle;
import SaveGame.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Screen;
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
        int y = 600;
        Group slaveGroup = new Group();

        int score = 0;

        String color = Color.rgb(141,19,250).toString();
        if (saveGame != null) {
            score = saveGame.getScore();
            color = saveGame.getBall().getColor();
            x = saveGame.getBall().getX();
            y = saveGame.getBall().getY();

        }
        Score S = Score.getInstance(score);
        //TODO: Do Button style

        PauseGameButton = new Button("Pause");
        PauseGameButton.setLayoutX(1350);
        PauseGameButton.setLayoutY(50);
        PauseGameButton.setScaleX(2);
        PauseGameButton.setScaleY(2);
        PauseGameButton.setStyle("-fx-background-color: linear-gradient(#ffd65b, #e68400), linear-gradient(#ffef84, #f2ba44), linear-gradient(#ffea6a, #efaa22), linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%), linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));"+
                "-fx-background-radius: 30;"+
                "-fx-background-insets: 0,1,2,3,0;"+
                "-fx-text-fill: #654b00;"+
                "-fx-font-weight: bold;"+
                "-fx-font-size: 14px;"+
                "-fx-padding: 10 20 10 20;");





        Scene scene = Main.getScene();
        Ball ball = Ball.getInstance(Color.valueOf(color),y,group);
        ball.init(slaveGroup);
        scene.setFill(Color.rgb(42, 40, 42));
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

        Text Stars = new Text("Stars: "  +S.getStars() );

        Timeline starLoop =  new Timeline(new KeyFrame(Duration.millis(16), new
                EventHandler<>() {
                    @Override
                    public void handle(final ActionEvent t) {
                        Stars.setText("Stars: "  +S.getStars());
                    }
                }));

        starLoop.setCycleCount(Timeline.INDEFINITE);
        starLoop.play();

        Stars.setScaleX(2);
        Stars.setScaleY(2);
        Stars.setLayoutX(150);
        Stars.setLayoutY(80);
        Stars.setFill(Paint.valueOf("#D4AF37"));

        group.getChildren().add(Stars);
// 1
        ColorChanger colorChanger = new ColorChanger(Ball.giveCopy(),100);
        colorChanger.init(slaveGroup);
// 2
        ColorChanger colorChanger1 = new ColorChanger(Ball.giveCopy(),-400);
        colorChanger1.init(slaveGroup);
// 3
        ColorChanger colorChanger2 = new ColorChanger(Ball.giveCopy(),-900);
        colorChanger2.init(slaveGroup);
// 4
        ColorChanger colorChanger3 = new ColorChanger(Ball.giveCopy(),-1400);
        colorChanger3.init(slaveGroup);


        Obstacle.getInstance(slaveGroup,350);
        Obstacle.getInstance(slaveGroup,-150);
        Obstacle.getInstance(slaveGroup,-650);
        Obstacle.getInstance(slaveGroup,-1150);
        group.getChildren().add(slaveGroup);

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
//        Obstacle.updateList(saveGame.getObstacleArrayList());
        this.saveGame = saveGame;
        startNewGame();

    }

    public static void keyDetect () {
        //TODO:
    }


}
