package SaveGame;

import Ball.Ball;
import Obstacle.Obstacle;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class SaveGame implements Serializable {
    private final String PathOfStoreSaveGame = "SaveMyGame.harsh";
    private Ball ball;
    private Score score;
    private ArrayList<Obstacle> obstacleArrayList;
    private static final long serialVersionUID = SerialCode.serialVersionUID;

    public void fetchData () {

    }

    public void init () {

    }

    public void SaveGame () {
        ArrayList<SaveGame> saveGames = readToFiles();

        SaveGame game = new SaveGame();
        game.ball = Ball.giveCopy();
        game.obstacleArrayList = Obstacle.giveCopy();
        game.score = Score.giveCopy();
        saveGames.add(0,game);
        writeToFile(saveGames);
    }

    private void writeToFile (ArrayList<SaveGame> games) {
        try {

            FileOutputStream fileOut = new FileOutputStream(PathOfStoreSaveGame);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(games);
            objectOut.close();
            System.out.println("The Object  was successfully written to a file");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private ArrayList<SaveGame> readToFiles () {

        try {

            // read object from file
            FileInputStream fis = new FileInputStream(PathOfStoreSaveGame);
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<SaveGame> result = (ArrayList<SaveGame> ) ois.readObject();
            ois.close();

            System.out.println("Games read successfully");

            return result;

        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<SaveGame>();
        }

//        return new ArrayList<SaveGame>();
    }

}
