package racingcar.view.input;

import java.util.Arrays;
import java.util.function.Predicate;

public enum InputViewData {
    CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)",
            string -> string.split(",").length != 0
                    && Arrays.stream(string.split(","))
                    .map(name -> 1 <= name.length() && name.length() <= 5)
                    .reduce(true, Boolean::logicalAnd),
            "[ERROR] 자동차 이름 입력 형식과 일치하지 않습니다."),
    COUNT_OF_TRY("시도할 회수는 몇회인가요?",
            string -> Integer.parseInt(string) > 0,
            "[ERROR] 시도 횟수는 숫자여야 한다.");
    private String requestMessage;
    private Predicate<String> formCheck;
    private String errorMessage;

    InputViewData(String requestMessage, Predicate<String> formCheck, String errorMessage) {
        this.requestMessage = requestMessage;
        this.formCheck = formCheck;
        this.errorMessage = errorMessage;
    }

    public String getRequestMessage() {
        return requestMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public boolean isCorrect(String input) {
        try {
            return formCheck.test(input);
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
