package racingcar.domain;

public final class TrialCount {
    private static final int TRIAL_COUNT_MIN = 0;
    private static final int TRIAL_COUNT_MAX = Integer.MAX_VALUE;
    private final int trialCount;

    public TrialCount(int trialCount) {
        validate(trialCount);
        this.trialCount = trialCount;
    }

    public TrialCount(String trialCount) {
        validate(trialCount);
        this.trialCount = Integer.parseInt(trialCount);
    }

    private void validate(long trialCount) {
        if (trialCount < TRIAL_COUNT_MIN || trialCount > TRIAL_COUNT_MAX) {
            throw new IllegalArgumentException(
                    String.format(ErrorMessage.TRIAL_COUNT_RANGE.message(), TRIAL_COUNT_MIN, TRIAL_COUNT_MAX));
        }
    }

    private void validate(String trialCount) {
        try {
            validate(Long.parseLong(trialCount));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.TRIAL_COUNT_NOT_NUMBER.message());
        }
    }

    public int getTrialCount() {
        return trialCount;
    }
}
