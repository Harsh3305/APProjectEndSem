package Activity.HomeActivity;

import Activity.PlayGame.PlayGame;
import Ball.Ball;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import sample.Main;

public class HomeActivity extends Main {
//Play button
    //new game
    //Resume button
    //Save game


    public void pause() {
        //TODO:
    }

    private void play () {
        //TODO:


        PlayGame newGame = new PlayGame();
        newGame.startNewGame();



    }

    public void resume () {
        // TODO:


    }

    public void gameOver () {
        // TODO:
    }

    public void exit () {

    }

    public Scene show () {
        Button NewGame,ResumeGame,Exit;
        // Buttons
        NewGame = new Button("New Game");
        ResumeGame = new Button("Resume Game");
        Exit = new Button("Exit Game");

        NewGame.setLayoutX(750);
        NewGame.setLayoutY(170);

        ResumeGame.setLayoutX(750);
        ResumeGame.setLayoutY(440);

        Exit.setLayoutX(750);
        Exit.setLayoutY(710);

        NewGame.setScaleX(3);
        NewGame.setScaleY(3);

        ResumeGame.setScaleX(3);
        ResumeGame.setScaleY(3);

        Exit.setScaleX(3);
        Exit.setScaleY(3);


        // click listener

        NewGame.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                play();
            }
        });

        ResumeGame.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                resume();
            }
        });

        Exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                exit();
            }
        });

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

        // Background Color
        Color black = Color.rgb(42, 40, 42);
        Scene scene = new Scene(group, 400,500, black);



        return scene;
    }


}
