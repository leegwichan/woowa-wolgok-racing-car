package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final InputView INSTANCE = new InputView();

    private InputView() {
    }

    public String readCarName() {
        System.out.println(InputMessage.CAR_NAME.message());
        return Console.readLine();
    }

    public String readTrialCount() {
        System.out.println(InputMessage.TRIAL_COUNT.message());
        return Console.readLine();
    }

    public static InputView getInstance() {
        return INSTANCE;
    }
}
