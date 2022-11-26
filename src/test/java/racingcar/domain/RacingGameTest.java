package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingGameTest {
    @DisplayName("자동차 이름이 모두 다르지 않은 경우 예외가 발생한다.")
    @Test
    void carNameDistinctTest() {
        assertThatThrownBy(() -> new RacingGame(List.of(new Car("a"),new Car("a"))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("우승한 차를 반환한다.")
    @Test
    void winnersTest() {
        Car car1 = new Car("a");
        Car car2 = new Car("b");
        car1.moveForward();
        RacingGame racingGame = new RacingGame(List.of(car1,car2));
        assertThat(racingGame.winners()).containsExactly(car1);
    }
}
