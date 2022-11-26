package racingcar;

import domain.Movement;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    Car car;

    @BeforeEach
    void setUp() {
        car = new Car("pobi");
    }

    @DisplayName("이동시 자동차의 위치를 변경하는 테스트")
    @Test
    void moveCarPositionTest() {
        car.updatePosition(Movement.MOVE);

        Assertions.assertThat(car.getNameAndPosition().get("pobi")).isEqualTo(1);
    }

    @DisplayName("정지시 자동차의 위치를 변경하지 않는 테스트")
    @Test
    void notMoveCarPositionTest() {
        car.updatePosition(Movement.STOP);

        Assertions.assertThat(car.getNameAndPosition().get("pobi")).isEqualTo(0);
    }
}
