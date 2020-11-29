package sample;

import javax.sound.sampled.*;
import java.io.*;

public class Controller {

    private static Clip backClip, gameOverClip, coinClip;

    public static void init () {

        String path = "gameover.wav";

        AudioInputStream audioInputStream =
                null;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(new File(path).getAbsoluteFile());
        } catch (UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }

        // create clip reference

        try {

            gameOverClip = AudioSystem.getClip();
            gameOverClip.open(audioInputStream);
            gameOverClip.stop();
//            gameOverClip.loop(0);
//            audioPlayer.play();



        } catch (LineUnavailableException | IOException e) {
            e.printStackTrace();
        }


        path = "coin.wav";

        audioInputStream =
                null;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(new File(path).getAbsoluteFile());
        } catch (UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }

        // create clip reference

        try {

            coinClip = AudioSystem.getClip();
            coinClip.open(audioInputStream);
            coinClip.stop();
//            coinClip.loop(0);
//            audioPlayer.play();


        } catch (LineUnavailableException | IOException e) {
            e.printStackTrace();
        }



        path = "sound.wav";

        audioInputStream =
                null;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(new File(path).getAbsoluteFile());
        } catch (UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }

        // create clip reference

        try {

            backClip = AudioSystem.getClip();
            backClip.open(audioInputStream);
            backClip.stop();
            backClip.loop(Clip.LOOP_CONTINUOUSLY);
//            audioPlayer.play();


        } catch (LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
    }

    public void playGameOver () {
        stopBack();
        gameOverClip.start();
    }

    public void playStarMusic () {
        coinClip.start();
    }

    public void playMusic () {
//        backClip.loop(Clip.LOOP_CONTINUOUSLY);
        if (backClip.isRunning()) {
            return;
        }
        backClip.start();
    }

    private void stopBack () {
        //TODO:
        backClip.stop();
    }

}
