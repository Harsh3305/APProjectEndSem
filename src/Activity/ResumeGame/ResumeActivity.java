package Activity.ResumeGame;

import Activity.PlayGame.PlayGame;
import SaveGame.SaveGame;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import sample.Main;

import java.util.ArrayList;

public class ResumeActivity {
    public void showScreen () {
        ArrayList<SaveGame> saveGameArrayList = fetchData();

        Group group = new Group();
        Image image=new Image("file:back.jpg");
        ImageView mv =new ImageView(image);
        mv.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth());
        mv.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight()+50);
        group.getChildren().addAll(mv);


        // I will display only 7 saved games

        int size = Math.min(7,saveGameArrayList.size());


        for (int i = 0; i < size; i++) {
            Button button = new Button((i+1) + " Saved Game " + saveGameArrayList.get(i).getScore ());
            button.setLayoutX(750);
            button.setLayoutY(200 + i*80);
            button.setScaleX(2);
            button.setScaleY(2);
            button.setBackground(Background.EMPTY);
            button.setTextFill(Paint.valueOf("#FFFFFF"));
            group.getChildren().add(button);

            int finalI = i;
            button.setOnAction(actionEvent -> {
                saveGameListener(finalI,saveGameArrayList);
            });
        }

        if (size == 0) {
            Text text = new Text("No Saved Game");
            text.setLayoutX(750);
            text.setLayoutY(480);
            text.setScaleX(4);
            text.setScaleY(4);
            text.setFill(Paint.valueOf("#FFFFFF"));
            group.getChildren().add(text);
            Paint[] paints = new Paint[7];
            paints[0] = Color.WHITE;
            paints[1] = Color.YELLOW;
            paints[2] = Color.RED;
            paints[3] = Color.GREEN;
            paints[4] = Color.WHEAT;
            paints[5] = Color.GOLD;
            paints[6] = Color.RED;

            Runnable runnable = () -> {
                long i = 0;
                int step = 0;
                while (i < 10000000000L) {
                    i++;

                    if (i == 1000000000L - 1) {
                        i=0;
                        step ++;
                        step = step%7;
                        text.setFill(paints[step]);
                    }
                }
            };

            Thread thread = new Thread(runnable);
            thread.start();


        }

        Main.udpateScene(group);


    }
    private void saveGameListener (int index, ArrayList<SaveGame> saveGameArrayList ) {
        PlayGame game = new PlayGame();
        game.resume(saveGameArrayList.get(index));
    }
    private ArrayList<SaveGame> fetchData () {
        return new SaveGame().fetchData();
    }
}
