package racingcar.car;

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
        this.carMoving = new NormalCarMoving();
    }

    public void move() {
        position += carMoving.countOfMovingSpace();
    }

    // 추가 기능 구현
}
