package Activity.PlayGame;

import Ball.Ball;
import SaveGame.SaveGame;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
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
        Color black = Color.rgb(42, 40, 42);
        Ball.getInstance(Color.RED, 700,group);




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

}
