package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int RANDOM_NUMBER_MIN = 0;
    private static final int RANDOM_NUMBER_MAX = 9;
    private static final int CAN_FORWARD_LIMIT = 4;
    private final CarName name;
    private int position = 0;

    public Car(CarName name) {
        this.name = name;
    }

    public void moveForward() {
        if (canForward()) {
            this.position++;
        }
    }

    public boolean canForward() {
        int randomNumber = makeRandomNumber();
        if (randomNumber < CAN_FORWARD_LIMIT) {
            return false;
        }
        return true;
    }

    private int makeRandomNumber() {
        return Randoms.pickNumberInRange(RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX);
    }
}