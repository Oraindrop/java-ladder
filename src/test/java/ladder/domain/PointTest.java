package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {
    @Test
    public void startMove(){
        List<Boolean> lines = Arrays.asList(false,true,false);
        Assertions.assertThat(Point.startMove(1, lines)).isEqualTo(2);
    }

    @Test
    public void isLeftSide(){
        List<String> names = Arrays.asList("a","b","c","d");
        assertThat(Point.isLeftSide(names.indexOf("a"))).isEqualTo(true);
    }

    @Test
    public void isRightSide(){
        assertThat(Point.isRightSide(3, 3)).isEqualTo(true);
    }

    @Test
    public void decideMove(){
        assertThat(Point.decideMove(1, true, false)).isEqualTo(0);
        assertThat(Point.decideMove(1, false, true)).isEqualTo(2);
    }

    @Test
    public void moveRight(){
        assertThat(Point.moveRight(1)).isEqualTo(2);
    }

    @Test
    public void moveLeft(){
        assertThat(Point.moveLeft(1)).isEqualTo(0);
    }
}
