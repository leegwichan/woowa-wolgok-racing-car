package racingcar.domain;

import racingcar.Constant.Constant;

public class Car implements Comparable<Car> {
    private static final int CAN_FORWARD_LIMIT = 4;
    private final CarName name;
    private int position = 0;

    public Car(CarName name) {
        this.name = name;
    }

    public void moveForward(int randomNumber) {
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