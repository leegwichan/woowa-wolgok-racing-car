package racingcar.car.moving;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;

public class NormalCarMovingTest extends MockingRandoms{

    @ParameterizedTest(name = "When random number is {0}")
    @ArgumentsSource(MoveTestData.class)
    void makeBridgeTest(int randomNumber, int expected) {
        when(Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(randomNumber);
        CarMoving normalCarMoving = new NormalCarMoving();

        int result = normalCarMoving.countOfMovingSpace();

        assertThat(result).isEqualTo(expected);
    }

    static class MoveTestData implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(8,1),
                    Arguments.of(4,1),
                    Arguments.of(3,0),
                    Arguments.of(0,0)
            );
        }
    }
}
