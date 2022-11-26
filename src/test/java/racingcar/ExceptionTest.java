package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class ExceptionTest extends NsTest {

    private final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("이름 입력에 대한 예외처리 테스트")
    @ValueSource(strings = {" ", "pobi,javajigi", "pobi, javajigi", "pobi"})
    @ParameterizedTest
    void enterInvalidCarNamesTest(String input) {
        assertSimpleTest(() -> {
            runException(input);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("시도 횟수 입력에 대한 예외처리 테스트")
    @ValueSource(strings = {"0", "-1", "d"})
    @ParameterizedTest
    void enterInvalidAttemptsTest(String input) {
        assertSimpleTest(() -> {
            runException("pobi,java", input);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("시도 횟수 입력에 대한 예외처리 후 정상적인 값 입력 시 정상실행 테스트")
    @CsvSource("0,a,-1,3")
    @ParameterizedTest
    void enterValidAttemptsAfterInvalidTest(
            String invalidAttemptsInput1,
            String invalidAttemptsInput2,
            String invalidAttemptsInput3,
            String validAttemptsInput
    ) {
        assertSimpleTest(() -> {
            runException("pobi,ho", invalidAttemptsInput1, invalidAttemptsInput2, invalidAttemptsInput3, validAttemptsInput);
            assertThat(output()).contains(ERROR_MESSAGE);
            assertThat(output()).contains("실행 결과");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
