import java.util.Scanner;

public class GameMenu {

    private String cardChoice = "";
    private boolean playCard = false;
    private boolean passTurn = false;

    public GameMenu() {

    }

    public void displayMenu(boolean cannotPlay) {

        Scanner in = new Scanner(System.in);

        if (cannotPlay) {
            System.out.println("-------- Play --------\n" +
                    "MUST PASS TURN!\n" +
                    "2. Pass turn\n" +
                    "3. Quit game");
            System.out.println("----------------------");

        } else {
            System.out.println("-------- Play --------\n" +
                    "1. Play a Card\n" +
                    "2. Pass turn\n" +
                    "3. Quit game");
            System.out.println("----------------------");
        }

        System.out.print("Enter menu item number: ");
        while (!in.hasNextInt() || ((in.nextInt() == 1) && (cannotPlay))) {
            System.out.println("Invalid Input! Pick an option from the list using the corresponding integer.");
            System.out.print("Enter menu item number: ");
            in.next();
        }

        int userChoice = in.nextInt();

        switch (userChoice) {
            case 1:
                System.out.print("Choose your card ([name],[category],[value]): ");
                this.cardChoice = in.nextLine();
                this.playCard = true;
                this.passTurn = false;
                break;
            case 2:
                System.out.println(" ");
                System.out.println("You passed!");
                this.passTurn = true;
                this.playCard = false;
                break;
            case 3:
                System.out.println("");
                System.out.println("Exiting...");
                System.exit(0);
        }
    }

    public String getCardChoice() {
        return cardChoice;
    }

    public boolean isPlayCard() {
        return playCard;
    }

    public boolean isPassTurn() {
        return passTurn;
    }
}
