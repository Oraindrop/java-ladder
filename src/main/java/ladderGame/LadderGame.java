package ladderGame;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    List<Ladder> ladders;

    public LadderGame(){
        this.ladders = new ArrayList<>();
    }

    public void startGame(int numberOfPlayer, int numberOfLadder){
        for(int i = 0; i < numberOfLadder; i++){
            this.ladders.add(new Ladder(numberOfPlayer - 1));
        }
        ResultView.showResult(this.ladders);
    }

    public static void main(String[] args) {
        LadderGame ladderGame = new LadderGame();
        ladderGame.startGame(InputView.inputNumberOfPlayer(), InputView.inputHeightOfLadder());
    }
}
