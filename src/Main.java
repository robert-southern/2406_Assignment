import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.displayWelcome();
        main.pauseTwoSeconds();

        Menu menu = new Menu();
        menu.displayMenu();

        while (!menu.isChoosePlay()) {
            menu.displayMenu();
        }

        System.out.println(" ");
        System.out.println("Starting new game...");
        System.out.println(" ");
        main.pauseTwoSeconds();

        Scanner in = new Scanner(System.in);


        /* TODO:
        Fix bug whereby the user input is checked whether its an int and then checked whether its between
        3 and 5 inclusive. The input is not checked again whether its an int or not.
        */
        int numPlayers = 0;
        System.out.print("Enter the number of players: ");
        while (!in.hasNextInt()){
            System.out.println("Invalid! Must be an integer!");
            System.out.print("Enter the number of players: ");
            in.next();
        }

        numPlayers = in.nextInt();
        while(numPlayers < 3 || numPlayers > 5) {
            System.out.println("Invalid! Must be 3 to 5 players!");
            System.out.println("Enter the number of players: ");
            numPlayers = in.nextInt();
        }

        Game game = new Game(numPlayers);

        game.play();

    }



    public void displayWelcome() {

        System.out.println("Welcome to Mineral Supertrumps!\n" +
                "------------------------------------------\n");
    }

    public void pauseTwoSeconds() {

        try {
            Thread.sleep(2000); //Pause for 2000 ms.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }


}


