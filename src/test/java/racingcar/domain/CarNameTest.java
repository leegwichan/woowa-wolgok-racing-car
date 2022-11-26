package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.Constant.ErrorMessage;

class CarNameTest {

    @DisplayName("자동차 이름은 5글자 이하가 아니면 에러가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"abcdef", "aaabbbcccddd"})
    void carNameRangeTest(String input) {
        Assertions.assertThatThrownBy(() -> new CarName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.CAR_NAME_LENGTH_ERROR.getMessage());
    }

    @DisplayName("자동차 이름이 비어있으면 에러가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void carNameEmptyTest(String input) {
        Assertions.assertThatThrownBy(() -> new CarName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NO_CAR_NAME_ERROR.getMessage());
    }
}