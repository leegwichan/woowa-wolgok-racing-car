package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Constant.Constant;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final int RANDOM_NUMBER_MIN = 0;
    private static final int RANDOM_NUMBER_MAX = 9;
    private final List<Car> cars;

    public Cars(List<CarName> carNames) {
        this.cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void moveForward() {
        this.cars.stream()
                .forEach(car -> car.moveForward(makeRandomNumber()));
    }

    private int makeRandomNumber() {
        return Randoms.pickNumberInRange(RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX);
    }

    public Winner getWinner() {
        Car maxPositionCar = getMaxPositionCar();
        return new Winner(cars.stream()
                .filter(car -> car.compareTo(maxPositionCar) == 0)
                .collect(Collectors.toList()));
    }

    private Car getMaxPositionCar() {
        return cars.stream().sorted().findFirst().get();
    }

    @Override
    public String toString() {
        StringBuilder raceResult = new StringBuilder();
        this.cars.stream()
                .forEach(car -> raceResult.append(car.getCarState() + Constant.ENTER));
        return raceResult.toString();
    }
}