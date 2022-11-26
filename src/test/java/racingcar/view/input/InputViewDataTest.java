package racingcar.view.input;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;

public class InputViewDataTest {

    @ParameterizedTest(name = "Case {index}")
    @ArgumentsSource(CarNamesTestData.class)
    void CAR_NAMES_isCorrectTest(String content, boolean expected) {
        boolean result = InputViewData.CAR_NAMES.isCorrect(content);

        assertThat(result).isEqualTo(expected);
    }

    static class CarNamesTestData implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of("pobi,steve,good", true),
                    Arguments.of(",,,,", false),
                    Arguments.of("aaaaaaaa,bbb,cc", false)
            );
        }
    }
}
