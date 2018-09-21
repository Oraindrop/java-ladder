package ladder;

import ladder.domain.Ladder;
import ladder.domain.LadderGame;
import ladder.domain.RideDownLine;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class RideDownLineTest {
    @Test
    public void goRideDown(){
        List<String> names = new ArrayList<>();
        names.add("pobi");
        names.add("honux");
        names.add("choising");
        names.add("taesu");
        List<Ladder> ladders = LadderGame.makeLadders(5);
        LadderGame.fillLadder(names, ladders);

        assertThat(RideDownLine.goRideDown(names, ladders, "choising")).isBetween(0, 3);
    }

    @Test
    public void goRideDownEveryOne(){
        List<String> names = new ArrayList<>();
        names.add("pobi");
        names.add("honux");
        names.add("choising");
        names.add("taesu");
        List<Ladder> ladders = LadderGame.makeLadders(5);
        LadderGame.fillLadder(names, ladders);

        assertThat(RideDownLine.goRideDownEveryOne(names, ladders).size()).isEqualTo(4);
    }

    @Test
    public void findNameIndex(){
        List<String> names = new ArrayList<>();
        names.add("pobi");
        names.add("honux");
        names.add("choising");
        names.add("taesu");
        assertThat(RideDownLine.findNameIndex(names,"choising")).isEqualTo(2);
    }

    @Test
    public void rideDownPersonResult(){
        List<String> names = new ArrayList<>();
        names.add("pobi");
        names.add("honux");
        names.add("choising");
        names.add("taesu");
        List<Ladder> ladders = LadderGame.makeLadders(5);
        LadderGame.fillLadder(names, ladders);

        assertThat(RideDownLine.rideDownPersonResult(2, ladders)).isBetween(0, 3);

    }

    @Test
    public void startMove(){
        List<Boolean> lines = new ArrayList<>();
        lines.add(false);
        lines.add(true);
        lines.add(false);

        assertThat(RideDownLine.startMove(1, lines)).isEqualTo(2);
    }

    @Test
    public void isLeftSide(){
        List<String> names = new ArrayList<>();
        names.add("a");
        names.add("b");
        names.add("c");
        names.add("d");
        assertThat(RideDownLine.isLeftSide(names.indexOf("a"))).isEqualTo(true);
    }

    @Test
    public void isRightSide(){
        List<String> names = new ArrayList<>();
        names.add("a");
        names.add("b");
        names.add("c");
        names.add("d");
        List<Ladder> ladders = LadderGame.makeLadders(5);
        LadderGame.fillLadder(names, ladders);
        assertThat(RideDownLine.isRightSide(names.indexOf("d"), ladders.get(0).getLines().size())).isEqualTo(true);
    }

    @Test
    public void decideMove(){
        assertThat(RideDownLine.decideMove(1, true, false)).isEqualTo(0);
        assertThat(RideDownLine.decideMove(1, false, true)).isEqualTo(2);
    }

    @Test
    public void moveRight(){
        assertThat(RideDownLine.moveRight(1)).isEqualTo(2);
    }

    @Test
    public void moveLeft(){
        assertThat(RideDownLine.moveLeft(1)).isEqualTo(0);
    }

}
