
public class Practice {

    public static void main(String[] args) {

        Double randDouble = new Double(Math.random() * 10);

        int randInt = randDouble.intValue();

        System.out.println(randInt);

        Game makeGame = new Game(3);


    }
}
