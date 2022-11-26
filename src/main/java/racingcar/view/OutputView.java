package racingcar.view;

import java.util.List;

public class OutputView {
    private static final OutputView INSTANCE = new OutputView();

    private OutputView() {
    }

    public void printResult() {
        System.out.println(OutputMessage.RESULT.message());
    }

    public void printResultByCar(String carName, int position) {
        System.out.printf((OutputMessage.RESULT_BY_CAR.message()),
                carName, OutputMessage.POSITION_MARK.message().repeat(position));
    }

    public void printEmptyLine() {
        System.out.println();
    }

    public void printWinner(List<String> winners) {
        System.out.println(OutputMessage.WINNER.message() +
                String.join(OutputMessage.WINNER_DELIMITER.message(), winners));
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public static OutputView getInstance() {
        return INSTANCE;
    }
}
