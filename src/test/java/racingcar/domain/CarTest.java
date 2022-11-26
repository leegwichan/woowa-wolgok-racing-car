package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    @DisplayName("자동차 이름의 길이가 1이상 5이하가 아닌 경우 예외가 발생한다.")
    @ValueSource(strings = {"", "abcdef"})
    @ParameterizedTest
    void carNameRangeTest(String input) {
        assertThatThrownBy(() -> new Car(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 위치가 늘어난다.")
    @Test
    void moveFallTest() {
        Car car = new Car("test");
        int prevPostiont = car.getPosition();
        car.moveForward();
        assertThat(car.getPosition()).isEqualTo(prevPostiont + 1);
    }
}
