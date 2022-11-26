package racingcar.view.input;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

public class InputViewTest {

    private MockedStatic<Console> mockConsole;

    @Test
    void inputContentTest_checkRepeatReadingLine_whenFormIsNotMatched() {
        when(Console.readLine()).thenReturn("aa", "b","-3","3","13");

        int result = new InputView().readCountOfTry();

        assertThat(result).isEqualTo(3);
    }

    @BeforeEach
    void mockClass() {
        mockConsole = mockStatic(Console.class);
    }

    @AfterEach
    void closMockClass() {
        mockConsole.close();
    }
}
