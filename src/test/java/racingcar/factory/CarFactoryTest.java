package racingcar.factory;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import racingcar.car.Car;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CarFactoryTest extends CarFactoryTestTool{

    @ParameterizedTest(name = "Case {0}")
    @ArgumentsSource(CarFactoryTestData.class)
    void makeBridgeTest(List<String> names, List<Car> expected) {
        List<Car> result = CarFactory.createCars(names);

        assertCarDataIsEqual(result, expected);
    }

    static class CarFactoryTestData implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(Arrays.asList("pobi", "woni", "jun"),
                            Arrays.asList(new Car("pobi"), new Car("woni"), new Car("jun"))),
                    Arguments.of(Arrays.asList("pobi", "steve"),
                            Arrays.asList(new Car("pobi"), new Car("steve")))
            );
        }
    }
}
