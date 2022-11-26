package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<CarName> carNames) {
        this.cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void moveForward() {
        this.cars.stream()
                .forEach(car -> car.moveForward());
    }
}