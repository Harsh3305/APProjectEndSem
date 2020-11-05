package Background;

import javafx.scene.image.Image;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Background {
    //image

    public void setBackground (Stage stage) throws FileNotFoundException {

        FileInputStream input = new FileInputStream("f:\\gfg.png");

        // create a image
        Image image = new Image(input);

        // create a background image
        BackgroundImage backgroundimage = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        // create Background
        Background background = new Background(backgroundimage);

        // set background
        hbox.setBackground(background);

        // set the scene
        stage.setScene(scene);

        stage.show();
    }



}
