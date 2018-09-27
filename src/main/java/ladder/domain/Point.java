package ladder.domain;

import java.util.List;

public class Point {
    private static final int ZERO = 0;
    private static final int ONE = 1;

    // Determine move based on current location.
    public static int startMove(int location, List<Boolean> lines){
        if(isLeftSide(location)){
            return decideMove(location, false, lines.get(location));
        }
        if(isRightSide(location, lines.size())){
            return decideMove(location, lines.get(location - ONE), false);
        }
        return decideMove(location, lines.get(location - ONE), lines.get(location));
    }

    public static boolean isLeftSide(int location){
        return location == ZERO;
    }

    public static boolean isRightSide(int location, int max){
        return location == max;
    }

    // Decide move based on ladder line
    public static int decideMove(int location, boolean left, boolean right){
        if(left){
            return moveLeft(location);
        }
        if(right){
            return moveRight(location);
        }
        return location;
    }

    public static int moveRight(int location){
        return location + ONE;
    }

    public static int moveLeft(int location){
        return location - ONE;
    }
}
