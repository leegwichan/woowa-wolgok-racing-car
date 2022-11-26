package racingcar.factory;

import static org.assertj.core.api.Assertions.assertThat;

import racingcar.car.Car;
import racingcar.car.dto.CarDto;
import java.util.List;

public abstract class CarFactoryTestTool {

    protected void assertCarDataIsEqual(List<Car> cars1, List<Car> cars2) {
        checkListSizeIsEqual(cars1, cars2);
        checkCarDataIsEqual(cars1, cars2);
    }

    private void checkListSizeIsEqual(List list1, List list2) {
        assertThat(list1.size()).isEqualTo(list2.size());
    }

    private void checkCarDataIsEqual(List<Car> cars1, List<Car> cars2) {
        for (int index = 0; index < cars1.size(); index++) {
            CarDto carDto1 = cars1.get(0).getCarDto();
            CarDto carDto2 = cars2.get(0).getCarDto();

            assertThat(carDto1.getName()).isEqualTo(carDto2.getName());
            assertThat(carDto1.getPosition()).isEqualTo(carDto2.getPosition());
        }
    }
}
