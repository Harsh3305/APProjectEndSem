package SaveGame;

import java.io.Serializable;

public class Score implements Serializable {
    private int level;
    private int stars;

    public Score(int level, int stars) {
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

}
