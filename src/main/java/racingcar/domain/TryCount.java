package racingcar.domain;

import racingcar.Constant.Constant;
import racingcar.Constant.ErrorMessage;

public class TryCount {
    private final int TRY_COUNT_RANGE_MIN = 1;
    private final int TRY_COUNT_RANGE_MAX = 1000;
    private final int tryCount;

    public TryCount(String tryCount) {
        validTryCount(tryCount);
        this.tryCount = Integer.parseInt(tryCount);
    }

    private void validTryCount(String tryCount) {
        validIsEmpty(tryCount);
        validIsDigit(tryCount);
        validTryCountRange(tryCount);
    }

    private void validIsEmpty(String tryCount) {
        if (tryCount.length() == Constant.EMPTY_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.NO_TRY_COUNT_ERROR.getMessage());
        }
    }

    private void validIsDigit(String tryCount) {
        if (!tryCount.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER.getMessage());
        }
    }

    private void validTryCountRange(String tryCount) {
        long count = convertToNumber(tryCount);
        if (count < TRY_COUNT_RANGE_MIN || count > TRY_COUNT_RANGE_MAX) {
            throw new IllegalArgumentException(ErrorMessage.TRY_COUNT_LENGTH_ERROR.getMessage());
        }
    }

    private long convertToNumber(String tryCount) {
        try {
            return Integer.parseInt(tryCount);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessage.TRY_COUNT_LENGTH_ERROR.getMessage());
        }
    }
}