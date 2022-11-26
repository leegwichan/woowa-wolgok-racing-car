package racingcar.domain;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class RacingGame {
    private static final int MOVE_STANDARD = 4;
    private static final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    private final List<Car> cars;

    public RacingGame(List<Car> cars) {
        validate(cars);
        this.cars = cars;
    }

    private void validate(List<Car> cars) {
        if (cars.stream().map(Car::getName).distinct().count() != cars.size()) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_DISTINCT.message());
        }
    }

    public void playOneTurn() {
        cars.stream().filter(car -> isMoveForward()).forEach(Car::moveForward);
    }

    private boolean isMoveForward() {
        return randomNumberGenerator.getRandomNumber() >= MOVE_STANDARD;
    }

    public List<Car> winners() {
        int max = cars.stream().mapToInt(Car::getPosition).max().orElseThrow(NoSuchElementException::new);
        return cars.stream().filter(car -> car.getPosition() == max).collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }
}
