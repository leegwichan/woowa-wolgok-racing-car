package racingcar;

import domain.Movement;

import java.util.Map;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void updatePosition(Movement movement) {
        int changePosition = Movement.getChangePosition(movement);
        position += changePosition;
    }

    public Map<String, Integer> getNameAndPosition() {
        return null;
    }
}
