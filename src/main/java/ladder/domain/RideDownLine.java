package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class RideDownLine {
    private static final int ZERO = 0;
    private static final int ONE = 1;

    // return result index
    public static int goRideDown(List<String> names, List<Ladder> ladders, String name){
        return rideDownPersonResult(findNameIndex(names, name), ladders);
    }

    // return results index list
    public static List<Integer> goRideDownEveryOne(List<String> names, List<Ladder> ladders){
        List<Integer> answers = new ArrayList<>();
        for (String name : names) {
            answers.add(goRideDown(names, ladders, name));
        }
        return answers;
    }

    // find index from names
    public static int findNameIndex(List<String> names, String name){
        return names.indexOf(name);
    }

    // calculate destination
    public static int rideDownPersonResult(int location, List<Ladder> ladders){
        int height = ZERO;
        while(height < ladders.size()){
            List<Boolean> lines = ladders.get(height).getLines();
            location = startMove(location, lines);
            height++;
        }
        return location;
    }

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
        if(location == ZERO){
            return true;
        }
        return false;
    }

    public static boolean isRightSide(int location, int max){
        if(location == max){
            return true;
        }
        return false;
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
