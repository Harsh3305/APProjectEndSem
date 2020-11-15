package sample;

import Activity.HomeActivity.HomeActivity;
import Activity.PlayGame.PlayGame;
import Ball.Ball;
import SaveGame.Score;
//import animatefx.animation.*;
import animatefx.animation.BounceIn;
import animatefx.animation.FadeIn;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;

public class Main extends Application {
    private static Stage pStage;
    private static Scene scene;
    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(new URL("file:/C:/Users/Dell-User/IdeaProjects/APProjectEndSem/src/sample/scene2.fxml"));
        pStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
//        pStage.setFullScreenExitHint("");
//        primaryStage.setFullScreen(true);
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
        /*Image imagines=new Image("file:switch.jpeg");

        ImageView bt=new ImageView(imagines);
        roundButton.setGraphic(bt);*/
        roundButton.setStyle(
                "-fx-background-image: url('/switch.jpeg'); " +
                        "-fx-background-color: transparent;"+
                        "-fx-background-radius: 200em; " +
                        "-fx-min-width: 200px; " +
                        "-fx-min-height: 200px; " +
                        "-fx-max-width: 200px; " +
                        "-fx-max-height: 200px;"
        );





        /* StackPane layout = new StackPane(
                roundButton
        );
        layout.setPadding(new Insets(10));
        Scene scene = new Scene(layout);
        primaryStage.setScene(scene);*/


        Color black = Color.rgb(42, 40, 42);
        group.getChildren().add(roundButton);
        scene = new Scene(group,400,500,black);
//        scene.setRoot(); // TODO:
        roundButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                StartButtonOnClick();

            }
        });
        primaryStage.setScene(scene);
        primaryStage.show();
//        new FadeIn(group).play();


        // create transtition
//        Timeline timeline = new Timeline();
//
//        KeyValue kv = new KeyValue(imgView2.translateXProperty(), 0, Interpolator.EASE_BOTH);
//        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
//        timeline.getKeyFrames().add(kf);
//        timeline.setOnFinished(t->{
//            // remove pane and restore scene 1
//            root1.getChildren().setAll(rectangle1);
//            // set scene 2
//            primaryStage.setScene(scene2);
//        });
//        timeline.play();


        detectKey();

    }


//    @Override
//    public void start(final Stage primaryStage) {
//        Pane canvas = new Pane();
//        final Scene scene = new Scene(canvas, 800, 600);
//        primaryStage.setTitle("Bouncing Ball");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//        Circle circle = new Circle(15, Color.TRANSPARENT);
//        circle.relocate(500, 100);
//        canvas.getChildren().add(circle);
//        final Timeline loop = new Timeline(new KeyFrame(Duration.millis(10), new
//                EventHandler<ActionEvent>() {
//                    double dx = 0;
//                    double dy = 3;
//                    @Override
//                    public void handle(final ActionEvent t) {
//                        circle.setLayoutX(circle.getLayoutX() + dx);
//                        circle.setLayoutY(circle.getLayoutY() + dy);
//                        final Bounds bounds = canvas.getBoundsInLocal();
//                        if ( circle.getLayoutY() >= bounds.getMaxY() - circle.getRadius() )
//                            dy = -dy;
//                        if (circle.getLayoutY() <= 10) {
//                            dy=-dy;
//                        }
//                        /**** ADD CODE HERE TO BOUNCE OFF OTHER 3 WALLS *****/
//                    }
//                }));
//        loop.setCycleCount(Timeline.INDEFINITE);
//        loop.play();
//    }





    private static void increamentScre (Score score) {
        score.increamentScore();
    }



    private static void StartButtonOnClick () {
        System.out.println("Start Button Pressed");
        HomeActivity homeActivity = new HomeActivity();
        Group g =homeActivity.show();

//        new BounceOut(scene.getRoot()).play();
        udpateScene(g);

    }


    private static void detectKey () {


        scene.setOnKeyPressed(keyEvent -> PlayGame.keyDetect());



    }
    public static void jumpBall (Ball ball) {
        ball.jump();
    }

    public static void main(String[] args) {
        launch(args);
    }

//    public static void udpateScene (Scene scene) {
//        new BounceIn(scene.getRoot()).play();
//        pStage.setScene(scene);
//
//        pStage.setFullScreenExitHint("");
//        pStage.setFullScreen(true);
//    }
    public static void udpateScene (Group group) {
        new FadeIn(group).play();
        scene.setRoot(group);

//        pStage.setFullScreenExitHint("");
//        pStage.setFullScreen(true);
    }

    public static  Scene getScene() {
        return scene;
    }
}