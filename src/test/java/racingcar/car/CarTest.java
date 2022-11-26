package racingcar.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;

public class CarTest extends CarTestTool {

    @ParameterizedTest(name = "Case {index}")
    @ArgumentsSource(CarMoveTestData.class)
    void makeBridgeTest(int countOfRepeat) {
        Car car = new Car("name", alwaysMoveOneSpace());
        moveRepeat(car,countOfRepeat);

        int result = car.getCarDto().getPosition();

        assertThat(result).isEqualTo(countOfRepeat);
    }

    static class CarMoveTestData implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(3),
                    Arguments.of(5),
                    Arguments.of(7)
            );
        }
    }
}
