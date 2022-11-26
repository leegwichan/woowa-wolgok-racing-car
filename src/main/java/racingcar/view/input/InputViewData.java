package racingcar.view.input;

import java.util.function.Predicate;

public enum InputViewData {
    ;

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
