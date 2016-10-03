import java.util.Random;

public class Game {

    private boolean gameIsOver = false;
    private int numberOfPlayers;
    private Player[] players;
    private Deck gameDeck;



    public Game(int numberOfPlayers) {

        this.numberOfPlayers = numberOfPlayers;
        this.players = new Player[numberOfPlayers];
    }

    public void initialise(String fileName) {

        for (int i = 0; i < numberOfPlayers; i++) {
            this.players[i] = new Player();
        }

        pickHuman();
        pickDealer();
        setNamesAndDisplay();
        DeckBuilder deckBuilder = new DeckBuilder();
        this.gameDeck = deckBuilder.BuildDeck(fileName);


    }

    public void pickHuman() {
        this.players[new Random().nextInt(numberOfPlayers)].setHuman(true);
    }

    public void pickDealer() {
        this.players[new Random().nextInt(numberOfPlayers)].setDealer(true);
    }



    public void setNamesAndDisplay() {

        StringBuffer playersList = new StringBuffer();
        int aiCount = 1;

        for (int i = 0; i < players.length; i++) {

            if (!players[i].getName().equals("Player")) {
                if (players[i].isDealer()) {
                    players[i].setName("AI " + (aiCount));
                    players[i].setTempName("AI " + (aiCount) + "(dealer)");
                    aiCount++;
                }
                else {
                    players[i].setName("AI " + (aiCount));
                    players[i].setTempName("AI " + (aiCount));
                    aiCount++;
                }
            }
            else {
                if(players[i].isDealer()) {
                    players[i].setName("Player");
                    players[i].setTempName("Player(dealer)");
                }
            }

//            if (!Character.isSpaceChar(playersList.charAt(playersList.length() - 1))) {
//                playersList.append(players[i].getName() + " -> ");
//            }

            playersList.append(players[i].getTempName() + " -> ");

        }

        playersList.delete(playersList.length() - 3, playersList.length() - 1);
        System.out.println("----------------------------------------------------------------");
        System.out.print("Play Order:    ");
        System.out.print(playersList + "\n");
        System.out.println("----------------------------------------------------------------");
    }


    public boolean isGameIsOver() {
        return gameIsOver;
    }

    public void setGameIsOver(boolean gameIsOver) {
        this.gameIsOver = gameIsOver;
    }

    public Player[] getPlayers() {
        return players;
    }
}
