package Obstacle;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Random;

public class ColorPattern {
    private final Color[] colors = new Color[6];

    public ColorPattern() {
        colors[0] = Color.RED;
        colors[1] = Color.GREEN;
        colors[2] = Color.AZURE;
        colors[3] = Color.VIOLET;
        colors[4] = Color.PURPLE;
        colors[5] = Color.GOLD;
    }

    public ArrayList<Color> assignrandom(int requiredColors) {
        Random r = new Random();
        ArrayList<Color> assignColor = new ArrayList<>(requiredColors);
        int iterator = 0;

        while (iterator < requiredColors) {
            int index = r.nextInt(colors.length - 1);
            Color currect = colors[index];
            if (! assignColor.contains(currect)) {
                assignColor.add(currect);
                iterator++;
            }
        }
        return assignColor;
    }

    public Color giveNextColor (Color currentColor) {
        Random random = new Random();
        while (true) {
            int index = random.nextInt(colors.length - 1);
            Color next = colors[index];
            if (! next.equals(currentColor)) {
                return next;
            }
        }
    }





}
