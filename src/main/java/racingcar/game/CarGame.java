package racingcar.game;

import racingcar.car.Car;
import racingcar.car.dto.CarDto;
import racingcar.factory.CarFactory;
import java.util.List;

public class CarGame {

    private final List<Car> cars;

    CarGame(List<String> names) {
        this.cars = CarFactory.createCars(names);
    }

    public void move() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<CarDto> getCarDtos() {
        return null;
    }
}
