package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final InputView INSTANCE = new InputView();

    private InputView() {
    }

    public List<String> readCarName() {
        System.out.println(InputMessage.CAR_NAME.message());
        return Arrays.stream(Console.readLine().split(InputMessage.CAR_NAME_DELIMITER.message(), -1))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public String readTrialCount() {
        System.out.println(InputMessage.TRIAL_COUNT.message());
        return Console.readLine();
    }

    public static InputView getInstance() {
        return INSTANCE;
    }
}
