package racingcar.domain;

import java.util.List;
import java.util.StringJoiner;

public class Winner {
    private final List<Car> winnerCars;

    public Winner(List<Car> winnerCars) {
        this.winnerCars = winnerCars;
    }

    @Override
    public String toString() {
        StringJoiner winnerName = new StringJoiner(", ");
        winnerCars.stream()
                .forEach(car -> winnerName.add(car.getCarName()));
        return winnerName.toString();
    }
}