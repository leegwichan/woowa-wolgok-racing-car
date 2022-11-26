package racingcar.domain;

public enum ErrorMessage {
    CAR_NAME_LENGTH("자동차 이름은 %d글자 이상 %d글자 이하여야 합니다."),
    CAR_NAME_DISTINCT("자동차 이름은 서로 달라야 합니다."),
    TRIAL_COUNT_RANGE("시도 횟수는 %d 이상 %d 이하의 숫자여야 합니다."),
    TRIAL_COUNT_NOT_NUMBER("시도 횟수는 숫자여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String message() {
        return "[ERROR] " + message;
    }
}
