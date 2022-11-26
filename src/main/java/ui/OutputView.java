package ui;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class OutputView {
    private static final String RESULT_TEXT = "실행 결과";
    private static final String ASK_CAR_NAMES_TEXT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분";
    private static final String ASK_ATTEMPTS_TEXT = "시도할 회수는 몇회인가요?";
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

    public void printResultText() {
        System.out.println(RESULT_TEXT);
    }

    public void askCarNamesInput() {
        System.out.println(ASK_CAR_NAMES_TEXT);
    }

    public void askAttemptsInput() {
        System.out.println(ASK_ATTEMPTS_TEXT);
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
