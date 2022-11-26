package racingcar.car.moving;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import racingcar.car.Car;

public abstract class CarTestTool {
    protected CarMoving alwaysMoveOneSpace() {
        CarMoving mockCarMoving = mock(CarMoving.class);
        when(mockCarMoving.countOfMovingSpace()).thenReturn(1);
        return mockCarMoving;
    }

    protected void moveRepeat(Car car, int countOfRepeat) {
        for (int count = 1; count <= countOfRepeat; count++) {
            car.move();
        }
    }
}
