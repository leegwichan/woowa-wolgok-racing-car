package domain;

import racingcar.Car;
import util.NumberGenerator;

import java.util.List;

public class RacingGame {
    private static final int MAXIMUM_STOP_NUMBER = 3;

    public void doRacingGame(List<Car> racingCars) {
        racingCars.forEach(
                car -> car.updatePosition(checkMoveOrNot(NumberGenerator.createRandomNumber()))
        );
    }

    public Movement checkMoveOrNot(int randomNumber) {
        boolean canMove = canMove(randomNumber);
        return Movement.getMovementByCanMove(canMove);
    }

    private boolean canMove(int randomNumber) {
        return randomNumber > MAXIMUM_STOP_NUMBER;
    }
}
