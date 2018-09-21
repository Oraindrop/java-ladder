package ladder;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

import ladder.domain.Ladder;
import ladder.domain.LadderGame;
import ladder.view.InputView;
import ladder.view.ResultView;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LadderGameTest {
    @Test
    public void makeLadder(){
        assertEquals(3, LadderGame.makeLadders(3).size());
    }
    @Test
    public void makeLines(){
        Ladder ladder = new Ladder();
        LadderGame.makeLines(3, ladder);
        assertEquals(2, ladder.getLines().size());
    }
    @Test
    public void generateRandom(){
        assertTrue(Ladder.generateRandomBool() == false || Ladder.generateRandomBool() == true);
    }


    @Test
    public void generateLineUI(){
        List<Boolean> list = new ArrayList<>();
        list.add(true);
        list.add(false);
        System.out.println(ResultView.generateLineUI(list));
    }

    @Test
    public void validLine(){
        List<Ladder> ladders = LadderGame.makeLadders(5);
        for(Ladder ladder : ladders){
            LadderGame.makeLines(3, ladder);
        }

        for(Ladder ladder : ladders){
            for(int j = 1; j < ladder.getLines().size(); j++){
                if(ladder.getLines().get(j-1)){
                    assertEquals(false, ladder.getLines().get(j));
                }
            }
        }
    }

    @Test
    public void makeNames(){
        String s = "choising,seungmin,osing";
        List<String> list = InputView.doSplit(s);
        assertEquals(3, list.size());
        assertThat(list.get(0)).isEqualTo("choising");
        assertThat(list.get(1)).isEqualTo("seungmin");
        assertThat(list.get(2)).isEqualTo("osing");
    }

    @Test
    public void cutFiveLength(){
        String s1 = "ssssssssssssssssssss";
        assertEquals(5, ResultView.cutFiveLength(s1).length());
        String s2 = "S";
        assertEquals(5, ResultView.cutFiveLength(s2).length());
    }

    @Test
    public void decideLineUI(){
        boolean i = true;
        boolean j = false;
        assertThat(ResultView.decideLineUI(i)).isEqualTo("-----");
        assertThat(ResultView.decideLineUI(j)).isEqualTo("     ");
    }

    @Test
    public void generateMultipleWord(){
        String s = "ab";
        assertThat(ResultView.generateMultipleWord(s,3)).isEqualTo("ababab");
    }

}
