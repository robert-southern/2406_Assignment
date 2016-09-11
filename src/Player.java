import java.util.ArrayList;

public class Player {

    private boolean dealer = false;
    private boolean human = false;
    private String name;

    public Player() {


    }

    public boolean isDealer() {
        return dealer;
    }

    public void setDealer(boolean dealer) {
        this.dealer = dealer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHuman() {
        return human;
    }

    public void setHuman(boolean human) {
        this.human = human;
        if (this.human == true) {
            this.name = "Player";
        }
    }
}
