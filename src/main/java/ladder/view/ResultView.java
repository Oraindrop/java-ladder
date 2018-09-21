package ladder.view;

import ladder.domain.Ladder;

import java.util.List;

public class ResultView {
    private static final String WALL = "|";
    private static final String SPACE = " ";
    private static final String HYPHEN = "-";
    private static final String LADDER_RESULT = "사다리 결과";
    private static final String EXECUTE_RESULT = "실행 결과";
    private static final String STRING_FORMAT_FIVE = "%5s";
    public static final int ZERO = 0;
    private static final int INIT_SPACE_LENGTH = 4;
    private static final int MAX_NAME_LENGTH = 5;

    private static StringBuilder sb = new StringBuilder();

    // print Ladder Line
    public static void showLadderResult(List<String> names, List<Ladder> laddersOfGame, List<String> results){
        System.out.println(LADDER_RESULT);
        System.out.println(generateNameOrResultUI(names));
        for(Ladder ladder : laddersOfGame){
            System.out.println(generateLineUI(ladder.getLines()));
        }
        System.out.println(generateNameOrResultUI(results));
    }

    // Set Five Length.
    public static String cutFiveLength(String word){
        if(word.length() > MAX_NAME_LENGTH){
            return word.substring(ZERO,MAX_NAME_LENGTH);
        }
        return String.format(STRING_FORMAT_FIVE, word);
    }

    // Create name line for result UI
    public static String generateNameOrResultUI(List<String> names){
        sb.setLength(ZERO);
        for (String name : names) {
            sb.append(cutFiveLength(name)+SPACE);
        }
        return sb.toString();
    }

    // Create 1 height ladder
    public static String generateLineUI(List<Boolean> linesOfLadder){
        sb.setLength(ZERO);
        sb.append(generateMultipleWord(SPACE, INIT_SPACE_LENGTH));
        sb.append(WALL);
        for(boolean line : linesOfLadder){
            sb.append(decideLineUI(line));
            sb.append(WALL);
        }
        return sb.toString();
    }

    // decide hyphen or space
    public static String decideLineUI(boolean line){
        if(line){
            return generateMultipleWord(HYPHEN, MAX_NAME_LENGTH);
        }
        return generateMultipleWord(SPACE, MAX_NAME_LENGTH);
    }

    // word to N words.
    public static String generateMultipleWord(String word, int n){
        String multipleWord = "";
        for(int i = ZERO; i < n; i++){
            multipleWord += word;
        }
        return multipleWord;
    }

    // print only one result, don't print name
    public static void personResultUI(int index, List<String> results){
        System.out.println(results.get(index));
    }

    // print everyone (name : result)
    public static void everyOneResultUI(List<String> names, List<Integer> indexs, List<String> results){
        for(int i = ZERO; i < names.size(); i++){
            System.out.println(names.get(i) + " : " + results.get(indexs.get(i)));
        }
    }

    public static void executeResultMessage() {
        System.out.println(EXECUTE_RESULT);
    }
}
