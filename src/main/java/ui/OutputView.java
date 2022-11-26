package ui;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class OutputView {
    private static final String EMPTY_LETTER = " ";
    private static final String SEPARATOR = " : ";
    private static final String MOVE_EXPRESSION = "-";
    private static final String WINNER_TEXT = "최종 우승자 :";
    private static final String COMMA = ",";

    public void printResult(Map<String, Integer> namesAndPositions) {
        Set<String> names = namesAndPositions.keySet();
        for (String name : names) {
            System.out.println(getCarResult(namesAndPositions, name));
        }
        System.out.println(EMPTY_LETTER);
    }

    public void printWinner(List<String> winners) {
        System.out.println(WINNER_TEXT + getWinnersResult(winners));
    }

    private String getCarResult(Map<String, Integer> namesAndPositions, String name) {
        return name + SEPARATOR + getMoving(namesAndPositions.get(name));
    }

    private String getMoving(int changedPosition) {
        return MOVE_EXPRESSION.repeat(Math.max(0, changedPosition));
    }

    private String getWinnersResult(List<String> winners) {
        StringBuilder winnerResult = new StringBuilder();
        int size = winners.size();
        makeWinnersResult(winners, winnerResult, size);
        return winnerResult.toString();
    }

    private void makeWinnersResult(List<String> winners, StringBuilder answer, int winnersNum) {
        for (int i = 0; i < winnersNum; i++) {
            if (i < winnersNum - 1) {
                answer.append(EMPTY_LETTER + winners.get(i) + COMMA);
                continue;
            }
            answer.append(EMPTY_LETTER + winners.get(i));
        }
    }
}
