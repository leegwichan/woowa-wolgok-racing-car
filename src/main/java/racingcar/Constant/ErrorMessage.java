package racingcar;

public enum ErrorMessage {
    NO_CAR_NAME_ERROR("자동차 이름을 입력해주세요."),
    CAR_NAME_LENGTH_ERROR("자동차 이름은 5자이하로 입력해주세요."),
    NO_TRY_COUNT_ERROR("시도 횟수를 입력해주세요."),
    NOT_NUMBER("시도 횟수는 숫자를 입력해야 합니다."),
    TRY_COUNT_LENGTH_ERROR("시도 횟수는 1이상 1000이하로 입력해주세요.");

    private final String errorPrefix = "[ERROR]";
    private final String message;


    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return errorPrefix + message;
    }
}