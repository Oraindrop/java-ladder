package ladder.domain;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class LadderGameTest {
    @Test
    public void makeLadder(){
        Assert.assertEquals(3, LadderGame.makeLadders(3).size());
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
}
