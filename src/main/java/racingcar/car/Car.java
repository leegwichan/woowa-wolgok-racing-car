package racingcar.car;

import racingcar.car.dto.CarDto;
import racingcar.car.moving.CarMoving;
import racingcar.car.moving.NormalCarMoving;

public class Car {
    private final String name;
    private int position = 0;
    private CarMoving carMoving;

    public Car(String name) {
        this(name, new NormalCarMoving());
    }

    public Car(String name, CarMoving carMoving) {
        this.name = name;
        this.carMoving = carMoving;
    }

    public void move() {
        position += carMoving.countOfMovingSpace();
    }

    public CarDto getCarDto() {
        return new CarDto(name, position);
    }
}
