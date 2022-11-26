package racingcar.view.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {

    public List<String> readCarNames() {
        return null;
    }

    public int readCountOfTry() {
        return 0;
    }

    private String inputContent(InputViewData data) {
        try {
            return tryInputContent(data);
        } catch (IllegalArgumentException exception) {
            print(exception.getMessage());
            return inputContent(data);
        }
    }

    private String tryInputContent(InputViewData data) {
        print(data.getRequestMessage());
        String input = Console.readLine();

        if (!data.isCorrect(input)) {
            throw new IllegalArgumentException(data.getErrorMessage());
        }
        return input;
    }

    private void print(String string) {
        System.out.println(string);
    }
}
