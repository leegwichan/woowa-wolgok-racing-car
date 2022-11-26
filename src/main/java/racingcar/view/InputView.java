package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Constant.Message;
import racingcar.domain.CarName;
import racingcar.domain.Cars;
import racingcar.domain.TryCount;

import java.util.Arrays;
import java.util.stream.Collectors;

public class InputView {
    public Cars readCarNames() {
        System.out.println(Message.READ_CAR_NAME_MESSAGE);
        try {
            String carNames = Console.readLine();
            return makeCars(carNames);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readCarNames();
        }
    }

    private Cars makeCars(String carNames) {
        try {
            return new Cars(Arrays.stream(carNames.split(","))
                    .map(CarName::new)
                    .collect(Collectors.toList()));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public TryCount readTryCount() {
        System.out.println(Message.READ_TRY_COUNT_MESSAGE);
        try {
            String tryCount = Console.readLine();
            return new TryCount(tryCount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readTryCount();
        }
    }
}