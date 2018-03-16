package codesquad;

import org.junit.Test;

public class LadderLineTest {
    @Test
    public void init() {
        int sizeOfPerson = 5;
        System.out.println(LadderLine.init(sizeOfPerson));
    }

    @Test
    public void move() {
        LadderLine line = LadderLine.init(5);
        System.out.println("ladder result : " + line.move(1));
    }
}
