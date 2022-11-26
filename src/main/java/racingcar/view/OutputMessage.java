package racingcar.view;

public enum OutputMessage {
    RESULT("실행 결과"),
    RESULT_BY_CAR("%s : %s\n"),
    POSITION_MARK("-"),
    WINNER("최종 우승자 : "),
    WINNER_DELIMITER(", ");
    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
