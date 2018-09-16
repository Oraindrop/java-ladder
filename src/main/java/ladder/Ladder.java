package ladder;

import java.util.Random;

public class Ladder {
    private static final int RANDOM_BOUND = 2;
    private static final int ZERO = 0;
    private static final String SPACE = " ";
    private static final String HYPHEN = "-";
    private static final String WALL = "|";

    private static Random rnd = new Random();
    private static StringBuilder sb = new StringBuilder();

    private int numberOfPlayer;
    private String representLadder;

    public Ladder(int numberOfPlayer) {
        this.numberOfPlayer = numberOfPlayer;
        this.representLadder = this.makeRepresentLadder();
    }

    public String decideLine(){
        int randomValue = rnd.nextInt(RANDOM_BOUND);
        return (randomValue == ZERO) ? SPACE : HYPHEN;
    }

    public String makeRepresentLadder(){
        sb.setLength(ZERO);
        sb.append(WALL);
        for(int i = ZERO; i < this.numberOfPlayer - 1; i++){
            sb.append(this.decideLine());
            sb.append(WALL);
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "representLadder='" + representLadder + '\'' +
                '}';
    }
}
