package sample;

import Activity.HomeActivity.HomeActivity;
import Background.BackgroundOfGame;
import Ball.Ball;
import SaveGame.SaveGame;
import SaveGame.Score;
import com.sun.javafx.event.BasicEventDispatcher;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Screen;
import javafx.stage.Stage;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.net.URL;

public class Main extends Application {
    private static Stage pStage;
    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(new URL("file:/C:/Users/Dell-User/IdeaProjects/APProjectEndSem/src/sample"));
        pStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        pStage.setFullScreenExitHint("");
        primaryStage.setFullScreen(true);
        primaryStage.setTitle("Game");
        Group group = new Group();
//        Ball playerBall  = Ball.getInstance(Color.RED, 700,group);
        Image image=new Image("file:switch.jpeg");
        ImageView mv =new ImageView(image);
        mv.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth());
        mv.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight());
        group.getChildren().addAll(mv);

        Button roundButton = new Button("Play");
        roundButton.setLayoutX(685);
        roundButton.setLayoutY(422);
        roundButton.setStyle(
                "-fx-background-image: url('/switch.jpeg'); " +
                        "-fx-background-color: transparent;"+
                        "-fx-background-radius: 200em; " +
                        "-fx-min-width: 200px; " +
                        "-fx-min-height: 200px; " +
                        "-fx-max-width: 200px; " +
                        "-fx-max-height: 200px;"
        );


        Color black = Color.rgb(42, 40, 42);
        group.getChildren().add(roundButton);
        Scene scene = new Scene(group,400,500,black);

        roundButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                StartButtonOnClick();
            }
        });
        primaryStage.setScene(scene);
        primaryStage.show();

        detectKey(scene);


    }





    public static void increamentScre (Score score) {
        score.increamentScore();
    }

    public static void StartButtonOnClick () {
        System.out.println("Hello");
        HomeActivity homeActivity = new HomeActivity();
        Scene scene =homeActivity.show();
        pStage.setScene(scene);
        pStage.setFullScreenExitHint("");
        pStage.setFullScreen(true);
    }


    public static void detectKey (Scene scene) {

        scene.setOnMouseClicked(event -> {
            switch (event.getButton()) {
                case PRIMARY, SECONDARY, MIDDLE -> System.out.println(event.getButton().toString());


            }
        });


    }
    public static void jumpBall (Ball ball) {
        ball.jump();
    }

    public static void main(String[] args) {
        launch(args);
//        SaveGame saveGame = new SaveGame();
//        saveGame.SaveGame();
    }

    public static void udpateScene (Scene scene) {
        pStage.setScene(scene);
        pStage.setFullScreenExitHint("");
        pStage.setFullScreen(true);
    }

}