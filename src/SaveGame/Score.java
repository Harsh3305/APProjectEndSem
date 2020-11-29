package SaveGame;

import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.awt.*;
import java.io.Serializable;

public class Score implements Serializable {
//    private int level = 0;
    private int stars = 0;
    public static final long serialVersionUID = 2L;
    private static Score storeScore;
    public static Score getInstance(int stars) {
        Score score = new Score(stars);
        if (storeScore ==null) storeScore = score;
        return storeScore;
    }

    public static void updateScore (int score) {
        if (storeScore == null)
        {
            storeScore = new Score(score);
        }
        storeScore.stars =score;
    }

    private Score(int stars) {
//        this.level = level;
        this.stars = stars;
    }

//    public int getLevel() {
//        return level;
//    }

//    public void setLevel(int level) {
//        this.level = level;
//    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public void increamentScore () {
        stars++;
    }

    public static void destroy () {
        if (storeScore != null) {
            storeScore.setStars(0);
            storeScore = null;
        }
    }

    public static Score giveCopy() {
        return storeScore;
    }
}
