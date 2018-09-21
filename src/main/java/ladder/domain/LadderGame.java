package ladder.domain;

import ladder.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    public static void fillLadder(List<String> namesOfPlayers, List<Ladder> ladders){
        int numberOfPlayers = namesOfPlayers.size();
        for(Ladder ladder : ladders){
            makeLines(numberOfPlayers, ladder);
        }
    }

    // Create Ladder instance
    public static List<Ladder> makeLadders(int numberOfLadder){
        List<Ladder> ladders = new ArrayList<>();
        for(int i = 0; i < numberOfLadder; i++){
            ladders.add(new Ladder());
        }
        return ladders;
    }

    // Call Ladder's makeLine method
    public static void makeLines(int numberOfPlayer, Ladder ladder){
        for(int i = 0; i < numberOfPlayer - 1; i++){
            ladder.makeLine();
        }
    }
}
