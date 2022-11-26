package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.TryCount;
import racingcar.view.InputView;

public class GameController {
    private final static InputView inputview = new InputView();

    public void startGame() {
        Cars cars = inputview.readCarNames();
        TryCount tryCount = inputview.readTryCount();
    }
}