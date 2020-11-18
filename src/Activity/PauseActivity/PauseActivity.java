package Activity.PauseActivity;

import Activity.HomeActivity.HomeActivity;
import Activity.PlayGame.PlayGame;
import SaveGame.SaveGame;
import com.sun.javafx.beans.event.AbstractNotifyListener;
import javafx.beans.Observable;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.awt.*;
import java.util.Collection;

public class PauseActivity {
    // Resume Game
    // Exit
    // Save and Exit

    public void show () {

        Group group = new Group();


        Button resume = new Button("Resume");
        Button saveAndExit = new Button("Save and Exit");
        Button Exit = new Button("Exit");

        resume.setLayoutX(480);
        resume.setLayoutY(100);
        resume.setScaleX(2);
        resume.setScaleY(2);

        saveAndExit.setLayoutX(480);
        saveAndExit.setLayoutY(300);
        saveAndExit.setScaleX(2);
        saveAndExit.setScaleY(2);

        Exit.setLayoutX(480);
        Exit.setLayoutY(500);
        Exit.setScaleX(2);
        Exit.setScaleY(2);




        group.getChildren().add(resume);
        group.getChildren().add(saveAndExit);
        group.getChildren().add(Exit);

        Scene scene=new Scene(group);
        Stage stage = new Stage();
        scene.setFill(Color.rgb(42, 40, 42));
        stage.setScene(scene);
        stage.setWidth(1000);
        stage.setHeight(700);
        System.out.println(stage.getX() + " "  + stage.getY());
        stage.setOpacity(0.7);
        stage.setMaximized(false);
        stage.setResizable(false);
        stage.show();


        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                PlayGame.getInstance().onResume();
            }
        });

        resume.setOnMouseClicked(mouseEvent -> {
            stage.close();
            PlayGame.getInstance().onResume();
        });


        saveAndExit.setOnMouseClicked(mouseEvent -> {
            stage.close();
            new SaveGame().SaveGame();
            new HomeActivity().exit();
        });


        Exit.setOnMouseClicked(mouseEvent ->{
                stage.close();
            new HomeActivity().exit();
        });



    }

}
