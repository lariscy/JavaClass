package homework.proj8;

/**
 * @author Steven
 */
public class ScoreOption {
    
    private final String name;
    private final int id;
    private int score;
    private boolean picked;

    public ScoreOption(int id, String name) {
        this.id = id;
        this.name = name;
        this.score = 0;
        this.picked = false;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isPicked() {
        return picked;
    }

    public void setPicked(boolean picked) {
        this.picked = picked;
    }

}
