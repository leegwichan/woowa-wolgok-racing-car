package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @DisplayName("moveForward메서드는 매개변수인 랜덤 숫자가 4이상이면 전진한다.")
    @Test
    void moveForwardTest() {
        Car car = new Car(new CarName("pobi"));
        car.moveForward(MOVING_FORWARD);
        Assertions.assertThat(car.getCarState()).isEqualTo("pobi : -");
        System.out.println(car.getCarState());
    }

    @DisplayName("moveForward메서드는 매개변수인 랜덤 숫자가 4미만이면 정지한다..")
    @Test
    void moveNotForwardTest() {
        Car car = new Car(new CarName("pobi"));
        car.moveForward(STOP);
        Assertions.assertThat(car.getCarState()).isEqualTo("pobi : ");
        System.out.println(car.getCarState());
    }
}