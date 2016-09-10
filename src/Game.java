
public class Game {

    private boolean gameIsOver = false;

    private int numberOfPlayers;

    Player[] players = new Player[numberOfPlayers];


    public Game() {

    }

    public Game(int numberOfPlayers) {

        this.numberOfPlayers = numberOfPlayers;

    }

    public static void play() {


    }


    public boolean isGameIsOver() {
        return gameIsOver;
    }

    public void setGameIsOver(boolean gameIsOver) {
        this.gameIsOver = gameIsOver;
    }



}
