package racingcar.domain;

import racingcar.Constant.Constant;

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

    @Override
    public String toString() {
        StringBuilder raceResult = new StringBuilder();
        this.cars.stream()
                .forEach(car -> raceResult.append(car.toString()+ Constant.ENTER));
        return raceResult.toString();
    }
}