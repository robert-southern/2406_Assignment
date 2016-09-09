import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int numPlayers = 0;

        Scanner in = new Scanner(System.in);

        while(numPlayers < 3 || numPlayers > 5) {
            System.out.print("Enter the number of players: ");
            numPlayers = Integer.parseInt(in.nextLine());
            if (numPlayers < 3 || numPlayers > 5) {
                System.out.println("Not valid! Must be 3 to 5 players!");
            }
        }

        Game game = new Game(numPlayers);


        game.play();




    }


}


