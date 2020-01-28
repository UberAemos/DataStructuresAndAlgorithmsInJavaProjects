package base.fundamental;

public class GameEntry {
    private String name;        // name of the person earning this score
    private int score;          // the score value

    /**
     * Constructs a game entry with give parameters.
     */
    public GameEntry(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public String toString() {
        return "(" + name + ", " + score + ")";
    }
}
