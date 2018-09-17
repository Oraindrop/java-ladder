package ladderGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {
    private static final int RANDOM_BOUND = 2;
    private static final int ZERO = 0;
    private static final String SPACE = " ";
    private static final String HYPHEN = "-";
    private static Random rnd = new Random();

    private int numberOfLine;
    private List<String> lines;

    public Ladder(int numberOfLine) {
        this.numberOfLine = numberOfLine;
        this.makeLines();
    }

    public String decideLine(){
        int randomValue = rnd.nextInt(RANDOM_BOUND);
        return (randomValue == ZERO) ? SPACE : HYPHEN;
    }

    public void makeLines(){
        this.lines = new ArrayList<>();
        for(int i = 0; i < numberOfLine; i++){
            this.lines.add(this.decideLine());
        }
    }

    public List<String> getLines() {
        return lines;
    }
}
