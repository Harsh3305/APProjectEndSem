package SaveGame;

import java.io.Serializable;

public class Score implements Serializable {
    private int level = 0;
    private int stars = 0;
    public static final long serialVersionUID = SerialCode.serialVersionUID;
    private static Score storeScore;
    public static Score getInstance(int level, int stars) {
        Score score = new Score(level,stars);
        if (storeScore ==null) storeScore = score;
        return storeScore;
    }

    public static void updateScore (int score) {
        if (storeScore == null)
        {
            storeScore = new Score(0,0);
        }
        storeScore.stars =score;
    }

    private Score(int level, int stars) {
        this.level = level;
        this.stars = stars;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public void increamentScore () {
        // TODO:
    }

    public static Score giveCopy() {
        return storeScore;
    }
}
