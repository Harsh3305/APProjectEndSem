package Activity.PlayGame;

import Ball.Ball;
import SaveGame.SaveGame;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import sample.Main;
public class PlayGame {


    public void startNewGame () {


        Group group = new Group();
        // Background Image
//        Image image=new Image("file:switch.jpeg");
//        ImageView mv =new ImageView(image);
//        mv.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth());
//        mv.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight());
//        group.getChildren().addAll(mv);

        Text Stars = new Text("Stars: 0");
        Stars.setScaleX(2);
        Stars.setScaleY(2);
        Stars.setLayoutX(750);
        Stars.setLayoutY(100);
        Stars.setFill(Paint.valueOf("#D4AF37"));

        group.getChildren().add(Stars);

        // Background Color
        Color black = Color.rgb(42, 40, 42);
        Scene scene = new Scene(group, 400,500, black);



        Ball playerBall  = Ball.getInstance(Color.RED, 700,group);



        Main.udpateScene(scene);
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
