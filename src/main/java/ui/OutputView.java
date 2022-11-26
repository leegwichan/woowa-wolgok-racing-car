package ui;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class OutputView {

    public void printResult(Map<String,Integer> namesAndPositions) {
        Set<String> names = namesAndPositions.keySet();
        for (String name : names) {
            System.out.println(getCarResult(namesAndPositions, name));
        }
    }

    public void printWinner(List<String> winners) {
        String result = "최종 우승자 : ";
        System.out.println(result + getWinnersResult(winners));
    }

    private String getCarResult(Map<String, Integer> namesAndPositions, String name) {
        return name + " : " + getMoving(namesAndPositions.get(name));
    }

    private String getMoving(int changedPosition) {
        return "-".repeat(Math.max(0, changedPosition));
    }

    private String getWinnersResult(List<String> winners) {
        StringBuilder answer = new StringBuilder();
        int size = winners.size();
        makeWinnersResult(winners, answer, size);
        return answer.toString();
    }

    private void makeWinnersResult(List<String> winners, StringBuilder answer, int size) {
        for (int i = 0; i < size; i++) {
            if (i < size - 1) {
                answer.append(" " + winners.get(i) + ",");
                continue;
            }
            answer.append(" " + winners.get(i));
        }
    }
}
