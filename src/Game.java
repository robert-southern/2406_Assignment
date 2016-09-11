import java.util.Random;

public class Game {

    private boolean gameIsOver = false;

    private int numberOfPlayers;

    private Player[] players;


    public Game(int numberOfPlayers) {

        this.numberOfPlayers = numberOfPlayers;
        this.players = new Player[numberOfPlayers];
    }

    public void play() {

        pickHuman();
        pickDealer();
        setNamesAndDisplay();



    }

    public void pickHuman() {
        this.players[new Random().nextInt(numberOfPlayers)].setHuman(true);
    }

    public void pickDealer() {
        this.players[new Random().nextInt(numberOfPlayers)].setDealer(true);
    }



    public void setNamesAndDisplay() {

        StringBuffer playersList = new StringBuffer();

        for (int i = 0; i < players.length; i++) {

            if (!players[i].getName().equals("Player")) {
                if (players[i].isDealer()) {
                    players[i].setName("AI " + (i + 1) + "(dealer)");
                }
                else {
                    players[i].setName("AI " + (i + 1));
                }
            }
            else {
                if(players[i].isDealer()) {
                    players[i].setName("Player(dealer)");
                }
            }

            if (!Character.isSpaceChar(playersList.charAt(playersList.length()))) {
                playersList.append(players[i].getName() + " -> ");
            }
        }
        System.out.print("Playing:    ");
        System.out.print(playersList);
    }

    public boolean isGameIsOver() {
        return gameIsOver;
    }

    public void setGameIsOver(boolean gameIsOver) {
        this.gameIsOver = gameIsOver;
    }



}
