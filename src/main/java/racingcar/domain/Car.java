package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Constant.Constant;

public class Car implements Comparable<Car> {
    private static final int RANDOM_NUMBER_MIN = 0;
    private static final int RANDOM_NUMBER_MAX = 9;
    private static final int CAN_FORWARD_LIMIT = 4;
    private final CarName name;
    private int position = 0;

    public Car(CarName name) {
        this.name = name;
    }

    public void moveForward() {
        int randomNumber = makeRandomNumber();
        if (canForward(randomNumber)) {
            this.position++;
        }
    }

    private boolean canForward(int randomNumber) {
        if (randomNumber < CAN_FORWARD_LIMIT) {
            return false;
        }
        return true;
    }

    private int makeRandomNumber() {
        return Randoms.pickNumberInRange(RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX);
    }

    public String getCarState() {
        return name.getName() + Constant.DELIMITER + Constant.MOVE_MARK.repeat(position);
    }

    public String getCarName() {
        return name.toString();
    }

    @Override
    public int compareTo(Car compare) {
        return compare.position - this.position;
    }
}