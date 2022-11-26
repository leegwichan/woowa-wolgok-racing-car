package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    private static final int NUMBER_RANGE_START = 0;
    private static final int NUMBER_RANGE_END = 9;

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(NUMBER_RANGE_START, NUMBER_RANGE_END);
    }
}
