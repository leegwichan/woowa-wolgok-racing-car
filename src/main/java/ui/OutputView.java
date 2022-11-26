package ui;

import java.util.Map;
import java.util.Set;

public class OutputView {

    public void printResult(Map<String,Integer> namesAndPositions) {
        Set<String> names = namesAndPositions.keySet();
        for (String name : names) {
            System.out.println(getCarResult(namesAndPositions, name));
        }
    }

    public void printWinner() {

    }

    private String getCarResult(Map<String, Integer> namesAndPositions, String name) {
        return name + " : " + getMoving(namesAndPositions.get(name));
    }

    private String getMoving(int changedPosition) {
        return "-".repeat(Math.max(0, changedPosition));
    }
}
