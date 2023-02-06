package racingcar.view.output;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import racingcar.car.dto.CarDto;
import java.util.List;
import java.util.stream.Stream;

public class OutputViewTest extends PrintTestTool {

    @ParameterizedTest(name = "Case {index}")
    @ArgumentsSource(CarProgressTestData.class)
    void printCarProgressTest(List<CarDto> carDtos, List<String> expected) {
        new OutputView().printCarsProgress(carDtos);

        assertThat(output()).contains(expected);
    }

    static class CarProgressTestData implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(
                            List.of(new CarDto("steve", 3), new CarDto("pobi", 5),
                                    new CarDto("lee", 7)),
                            List.of("steve : ---", "pobi : -----", "lee : -------")),
                    Arguments.of(
                            List.of(new CarDto("god", 10)),
                            List.of("god : ----------"))
            );
        }
    }

    @ParameterizedTest(name = "Case {index}")
    @ArgumentsSource(ResultTestData.class)
    void printResultTest_WhenCoWinner(List<CarDto> carDtos, String expected) {
        new OutputView().printResult(carDtos);

        assertThat(output()).contains(expected);
    }

    static class ResultTestData implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(List.of(
                            new CarDto("steve", 5), new CarDto("pobi", 7),
                            new CarDto("lee", 7), new CarDto("gwi", 3)),
                            "최종 우승자 : pobi, lee"),
                    Arguments.of(List.of(
                                    new CarDto("steve", 5), new CarDto("pobi", 2),
                                    new CarDto("lee", 4), new CarDto("gwi", 3)),
                            "최종 우승자 : steve")
            );
        }
    }
}
