package sample;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
//        primaryStage.setTitle("Color Switch");
//        primaryStage.setScene(new Scene(root, 300, 275));
//        primaryStage.show();
        primaryStage.setTitle("Circle Example");
        Group group = new Group();
        Circle circle = new Circle();
        circle.setCenterX(775);
        circle.setCenterY(700);
        circle.setRadius(25);
        circle.setFill(Color.RED);
        Path path = new Path();
        path.getElements().add(new MoveTo(775, 700));
        path.getElements().add(new LineTo(775, 600));
        path.getElements().add(new LineTo(775, 500));
        path.getElements().add(new LineTo(775, 400));

        PathTransition pathTransition = new PathTransition();

        //Setting duration for the PathTransition
        pathTransition.setDuration(Duration.millis(1000));

        //Setting Node on which the path transition will be applied
        pathTransition.setNode(circle);

        //setting path for the path transition
        pathTransition.setPath(path);

        //setting orientation for the path transition
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);

        //setting up the cycle count
        pathTransition.setCycleCount(10);

        //setting auto reverse to be true
        pathTransition.setAutoReverse(true);

        //Playing path transition
        pathTransition.play();




        group.getChildren().addAll(circle);
        Scene scene = new Scene(group,400,500,Color.GRAY);
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP, SPACE -> jump();
                }
            }
        });
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void jump () {

    }

    public static void main(String[] args) {
        launch(args);
    }
}