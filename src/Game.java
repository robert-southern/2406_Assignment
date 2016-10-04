import java.util.Random;

public class Game {

    private boolean gameIsOver = false;
    private int numberOfPlayers;
    private Player[] players;
    private Deck gameDeck;
    private int firstPlayerIndex = 0;


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
        this.gameDeck = deckBuilder.buildDeck(fileName);
        dealHands();


    }

    public void play() {


    }


    public void playRound() {

        boolean roundOver = false;
        String trumpCategory = "";
        double categoryValue = 0;
        double tempValue = 0;

            GameMenu gameMenu = new GameMenu();
            int nextPlayerIndex = firstPlayerIndex;

            if (players[firstPlayerIndex].isHuman()) {
                System.out.println(" ");
                System.out.println("It's your turn!");
                System.out.println(" ");
                System.out.println("YOUR CARDS >>");
                showPlayerHand();
                pauseTwoSeconds();
                gameMenu.displayMenu(false);
                if (gameMenu.isPlayCard()) {
                    String[] tempChoice = gameMenu.getCardChoice().split(",");
                    trumpCategory = tempChoice[1];
                    categoryValue = Double.parseDouble(tempChoice[2]);
                    nextPlayerIndex++;
                } else {
                    players[firstPlayerIndex].giveCard(gameDeck.getNextCard());
                    nextPlayerIndex++;
                }

            } else {

                Card cardPlayed = pickRandCard(firstPlayerIndex);
                pauseTwoSeconds();
                System.out.println("It's " + players[firstPlayerIndex].getName() + "'s turn!");
                pauseTwoSeconds();
                System.out.println(" ");
                System.out.println(players[firstPlayerIndex].getName() + " played:");
                cardPlayed.displayCard();
                trumpCategory = pickCategory();
                System.out.println(players[firstPlayerIndex].getName() + " picked " + trumpCategory + "!");
                categoryValue = returnTrumpValue(trumpCategory, cardPlayed);
                nextPlayerIndex++;
            }

        while (!roundOver) {

            if (players[nextPlayerIndex].isHuman()) {
                System.out.println(" ");
                System.out.println("It's your turn!");
                System.out.println(" ");
                System.out.println("YOUR CARDS >>");
                showPlayerHand();
                pauseTwoSeconds();

                for (int j = 0; j < players[nextPlayerIndex].getHand().size(); j++) {

                }

                gameMenu.displayMenu(false);
                if (gameMenu.isPlayCard()) {
                    String[] tempChoice = gameMenu.getCardChoice().split(",");
                    trumpCategory = tempChoice[1];
                    tempValue = Double.parseDouble(tempChoice[2]);
                    nextPlayerIndex++;
                } else {
                    players[firstPlayerIndex].giveCard(gameDeck.getNextCard());
                    nextPlayerIndex++;
                }

            } else {

                Card cardPlayed = pickRandCard(firstPlayerIndex);
                pauseTwoSeconds();
                System.out.println("It's " + players[firstPlayerIndex].getName() + "'s turn!");
                pauseTwoSeconds();
                System.out.println(" ");
                System.out.println(players[firstPlayerIndex].getName() + " played:");
                cardPlayed.displayCard();
                trumpCategory = pickCategory();
                categoryValue = returnTrumpValue(trumpCategory, cardPlayed);
                nextPlayerIndex++;
            }





        }


    }


    public Card pickRandCard(int index) {

        int randNum = new Random().nextInt(players[index].getHand().size());

        return players[index].getHand().get(randNum);
    }

    public String pickCategory() {

        int randInt = new Random().nextInt(5);
        String category = "";

        switch (randInt) {
            case 0:
                category = "Hardness";
                break;
            case 1:
                category = "Specific Gravity";
                break;
            case 2:
                category = "Cleavage";
                break;
            case 3:
                category = "Crustal Abundance";
                break;
            case 4:
                category = "Economic Value";
                break;
        }
        return category;
    }

    public double returnTrumpValue(String trump, Card cardPlayed) {

        double trumpVal = 0;

        if (trump.equals("Hardness")) {
            trumpVal = cardPlayed.getHardness();
        } else if (trump.equals("Specific Gravity")) {
            trumpVal = cardPlayed.getSpecificGravity();
        } else if (trump.equals("Cleavage")) {
            trumpVal = cardPlayed.getCleavage();
        } else if (trump.equals("Crustal Abundance")) {
            trumpVal = cardPlayed.getAbundance();
        } else if (trump.equals("Economic Value")) {
            trumpVal = cardPlayed.getEconValue();
        }

        return trumpVal;
    }

    public void returnCardByName (int index, String cardName) {

        for (int i = 0; i < players[index].getHand().size(); i++) {
            if (players[index].getHand().get(i).getName().equals("cardName")) {

            }
        }
    }



    public void pickHuman() {
        this.players[new Random().nextInt(numberOfPlayers)].setHuman(true);
    }

    public void pickDealer() {
        int randInt = new Random().nextInt(numberOfPlayers);
        this.players[randInt].setDealer(true);
        if (randInt == numberOfPlayers - 1) {
            this.firstPlayerIndex = 0;
        } else {
            this.firstPlayerIndex = randInt + 1;
        }

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

    public void dealHands() {
        this.gameDeck.shuffleDeck();

        for (int i = 0; i < players.length; i++) {

            for (int j = 0; j < 8; j++) {
                this.players[i].giveCard(this.gameDeck.getNextCard());
            }
        }
    }

    public void showPlayerHand() {
        for (int i = 0; i < players.length; i++) {
            if (players[i].isHuman()) {
                for (int j = 0; j < players[i].getHand().size(); j++) {
                    System.out.println(j + 1);
                    players[i].getHand().get(j).displayCard();
                }
            }
        }

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

    public void pauseTwoSeconds() {

        try {
            Thread.sleep(2000); //Pause for 2000 ms.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }





}
