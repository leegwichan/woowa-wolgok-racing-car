package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.CarName;
import racingcar.domain.TryCount;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public List<CarName> readCarNames() {
        try {
            String carNames = Console.readLine();
            return Arrays.stream(carNames.split(","))
                    .map(CarName::new).collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readCarNames();
        }
    }


    public TryCount readTryCount() {
        try {
            String tryCount = Console.readLine();
            return new TryCount(tryCount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readTryCount();
        }
    }
}