package ladder;

import ladder.domain.Ladder;
import ladder.domain.LadderGame;
import ladder.domain.RideDownLine;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class MainController {
    private static final String EVERYONE = "all";

    public static void main(String[] args) {
        List<String> names = InputView.inputNamesOfPlayer();
        List<String> results = InputView.inputResult();
        List<Ladder> ladders = LadderGame.makeLadders(InputView.inputHeightOfLadder());
        LadderGame.fillLadder(names, ladders);

        ResultView.showLadderResult(names, ladders, results);
        showRideDownResult(names, ladders, results);
    }

    public static void showRideDownResult(List<String> names, List<Ladder> ladders, List<String> results){
        ResultView.executeResultMessage();
        String name = InputView.inputPlayerResult();
        if(isEveryOne(name)){
            showEveryOneResult(names, ladders, results);
            return;
        }
        showAloneResult(names, ladders, results, name);
        return;
    }

    public static boolean isEveryOne(String value){
        if(value.equals(EVERYONE)){
            return true;
        }
        return false;
    }

    public static void showEveryOneResult(List<String> names, List<Ladder> ladders, List<String> results){
        List<Integer> answers = RideDownLine.goRideDownEveryOne(names, ladders);
        ResultView.everyOneResultUI(names, answers, results);
    }

    public static void showAloneResult(List<String> names, List<Ladder> ladders, List<String> results, String name){
        int answer = RideDownLine.goRideDown(names, ladders, name);
        ResultView.personResultUI(answer, results);
    }

}
