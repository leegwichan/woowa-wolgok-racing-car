package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.TryCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final static InputView inputview = new InputView();
    private final static OutputView outputView = new OutputView();

    public void startGame() {
        Cars cars = inputview.readCarNames();
        TryCount tryCount = inputview.readTryCount();
        repeatGame(cars, tryCount.getTryCount());
    }

    private void repeatGame(Cars cars, int tryCount) {
        for (int i = 0; i<tryCount; i++) {
            cars.moveForward();
            outputView.printRaceState(cars.toString());
        }
    }
}