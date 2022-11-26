package racingcar.domain;

import racingcar.Constant.ErrorMessage;

public class CarName {
    private final int CAR_NAME_LENGTH_MIN = 1;
    private final int CAR_NAME_LENGTH_MAX = 5;

    private final String name;

    public CarName(String name) {
        validCarNameEmpty(name);
        validCarName(name);
        this.name = name;
    }

    private void validCarNameEmpty(String name) {
        if (name.length() < CAR_NAME_LENGTH_MIN) {
            throw new IllegalArgumentException(ErrorMessage.NO_CAR_NAME_ERROR.getMessage());
        }
    }

    private void validCarName(String name) {
        if (name.length() > CAR_NAME_LENGTH_MAX) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_LENGTH_ERROR.getMessage());
        }
    }

    @Override
    public String toString() {
        return name;
    }
}