package racingcar.car.moving;

import camp.nextstep.edu.missionutils.Randoms;

public class NormalCarMoving implements CarMoving{

    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int MOVE_MIN_NUMBER = 4;

    @Override
    public int countOfMovingSpace() {
        int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
        if (randomNumber >= MOVE_MIN_NUMBER) {
            return 1;
        }
        return 0;
    }
}
