package Ball;

import Obstacle.ColorPattern;
import javafx.scene.paint.Color;

public class ColorChanger {
    private final int radius = 0;
    private Ball playerBall;

    public ColorChanger(Ball playerBall) {
        this.playerBall = playerBall;
    }

    public void changeColor () {
        ColorPattern pattern = new ColorPattern();
        Color nextColor = pattern.giveNextColor(playerBall.getBallColor());
        playerBall.setBallColor(nextColor);
    }

}