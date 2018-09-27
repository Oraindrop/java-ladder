package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {
    private static final int RANDOM_BOUND = 2;
    private static final int ZERO = 0;
    private static final int ONE = 1;

    private static Random rnd = new Random();
    private List<Boolean> lines = new ArrayList<>();;

    // Add line(0,1) to lines
    public void makeLine(){
        this.lines.add(this.generateValidLine());
    }

    // Don't overlap with line
    public boolean generateValidLine(){
        int size = lines.size();
        if(size > ZERO){
            return lines.get(size - ONE) ? false : generateRandomBool();
        }
        return generateRandomBool();
    }

    public List<Boolean> getLines() {
        return this.lines;
    }

    // Create boolean from randomValue
    public static boolean generateRandomBool(){
        return rnd.nextInt(RANDOM_BOUND) != ZERO;
    }
}
