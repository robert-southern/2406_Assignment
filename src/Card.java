
/*  - Here we have an object used to represent a single card.
    - Contains information about the card.
    - Records whether or not the card has been played.
 */



public class Card {

    // Attributes ->
    private String name;
    private double hardness;
    private double specificGravity;
    private int cleavage;
    private int abundance;
    private int econValue;
    private boolean wasPlayed = false;



    // Constructors ->
    public Card() {

    }

    public Card(String name, double hardness, double specificGravity, int cleavage, int abundance, int econValue) {
        this.name = name;
        this.hardness = hardness;
        this.specificGravity = specificGravity;
        this.cleavage = cleavage;
        this.abundance = abundance;
        this.econValue = econValue;
    }
    // -----------------------------------------------------------------------------------------------------------------



    // Getters & Setters ->
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHardness() {
        return hardness;
    }

    public void setHardness(double hardness) {
        this.hardness = hardness;
    }

    public double getSpecificGravity() {
        return specificGravity;
    }

    public void setSpecificGravity(double specificGravity) {
        this.specificGravity = specificGravity;
    }

    public int getCleavage() {
        return cleavage;
    }

    public void setCleavage(int cleavage) {
        this.cleavage = cleavage;
    }

    public int getAbundance() {
        return abundance;
    }

    public void setAbundance(int abundance) {
        this.abundance = abundance;
    }

    public int getEconValue() {
        return econValue;
    }

    public void setEconValue(int econValue) {
        this.econValue = econValue;
    }

    public boolean isWasPlayed() {
        return wasPlayed;
    }

    public void setWasPlayed(boolean wasPlayed) {
        this.wasPlayed = wasPlayed;
    }

}
