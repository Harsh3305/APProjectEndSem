package Activity.HomeActivity;

import Activity.PlayGame.PlayGame;
import Activity.ResumeGame.ResumeActivity;
import Ball.Ball;
import Obstacle.Obstacle;
import animatefx.animation.Flash;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.Controller;
import sample.Main;

public class HomeActivity extends Main {
//Play button
    //new game
    //Resume button
    //Save game

    public HomeActivity() {
//        this.scene = scene;
    }



    public static void play() {
        Ball.newGame();
        PlayGame newGame = PlayGame.getInstance();
        newGame.startNewGame();



    }

    public void resume () {
        Ball.newGame();
        ResumeActivity resumeActivity = new ResumeActivity();
        resumeActivity.showScreen();


    }

    public void gameOver () {
        Obstacle.GameOver();
        Ball.stopBall();
        Group  group = new Group();
        new Controller().playGameOver();
        Text gaveOver = new Text("Game Over");
        gaveOver.setFill(Color.RED);
        gaveOver.setLayoutX(500);
        gaveOver.setLayoutY(300);
        gaveOver.setScaleX(3);
        gaveOver.setScaleY(3);

        Scene scene=new Scene(group);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        scene.setFill(Color.rgb(42, 40, 42));
        stage.setScene(scene);
        stage.setWidth(1000);
        stage.setHeight(700);
        // System.out.println(stage.getX() + " "  + stage.getY());
        stage.setOpacity(0.7);
        stage.setMaximized(false);
        stage.setResizable(false);
        stage.getIcons().add(new Image("file:icon.png"));
        new Flash(group).play();
        stage.show();

        System.out.println("Game over");

    }

    public void exit () {
//    getpStage().hide();
//        System.exit(0);
        Main.goToMainScreen();
    }
    public void exitmain(){
        getpStage().hide();
    }


    public Group show () {
        Button NewGame,ResumeGame,Exit;
        new Controller().playMusic();
        // Buttons
        NewGame = new Button("New Game");
        ResumeGame = new Button("Resume Game");
        Exit = new Button("Exit Game");
        NewGame.setStyle(
                "-fx-background-color: linear-gradient(#ffd65b, #e68400), linear-gradient(#ffef84, #f2ba44), linear-gradient(#ffea6a, #efaa22), linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%), linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));"+
        "-fx-background-radius: 30;"+
        "-fx-background-insets: 0,1,2,3,0;"+
        "-fx-text-fill: #654b00;"+
        "-fx-font-weight: bold;"+
        "-fx-font-size: 14px;"+
        "-fx-padding: 10 20 10 20;"
        );
        ResumeGame.setStyle(
                "-fx-background-color: linear-gradient(#ffd65b, #e68400), linear-gradient(#ffef84, #f2ba44), linear-gradient(#ffea6a, #efaa22), linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%), linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));"+
                        "-fx-background-radius: 30;"+
                        "-fx-background-insets: 0,1,2,3,0;"+
                        "-fx-text-fill: #654b00;"+
                        "-fx-font-weight: bold;"+
                        "-fx-font-size: 14px;"+
                        "-fx-padding: 10 20 10 20;"
        );
        Exit.setStyle(
                "-fx-background-color: linear-gradient(#ffd65b, #e68400), linear-gradient(#ffef84, #f2ba44), linear-gradient(#ffea6a, #efaa22), linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%), linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));"+
                        "-fx-background-radius: 30;"+
                        "-fx-background-insets: 0,1,2,3,0;"+
                        "-fx-text-fill: #654b00;"+
                        "-fx-font-weight: bold;"+
                        "-fx-font-size: 14px;"+
                        "-fx-padding: 10 20 10 20;"
        );

        NewGame.setLayoutX(750);
        NewGame.setLayoutY(270);

        ResumeGame.setLayoutX(750);
        ResumeGame.setLayoutY(440);

        Exit.setLayoutX(750);
        Exit.setLayoutY(610);

        NewGame.setScaleX(2);
        NewGame.setScaleY(2);

        ResumeGame.setScaleX(2);
        ResumeGame.setScaleY(2);

        Exit.setScaleX(2);
        Exit.setScaleY(2);


        // click listener

        NewGame.setOnAction(actionEvent -> play());

        ResumeGame.setOnAction(actionEvent -> resume());

        Exit.setOnAction(actionEvent -> exitmain());

        Group group = new Group();
        // Background Image
        Image image=new Image("file:back.jpg");
        ImageView mv =new ImageView(image);
        mv.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth());
        mv.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight()+50);
        group.getChildren().addAll(mv);

        group.getChildren().add(NewGame);
        group.getChildren().add(ResumeGame);
        group.getChildren().add(Exit);

        return  group;
    }


}
