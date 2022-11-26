package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.Constant.ErrorMessage;

class TryCountTest {

    @DisplayName("시도 횟수에 문자가 들어오면 에러가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "*"})
    void carNameRangeTest(String input) {
        Assertions.assertThatThrownBy(() -> new TryCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_NUMBER.getMessage());
    }

    @DisplayName("시도횟수는 1이상 1000이하가 아닐 경우 에러가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "1001", "100000"})
    void carNameEmptyTest(String input) {
        Assertions.assertThatThrownBy(() -> new TryCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.TRY_COUNT_LENGTH_ERROR.getMessage());
    }
}