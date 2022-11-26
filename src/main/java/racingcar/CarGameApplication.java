package racingcar;

import racingcar.game.CarGame;
import racingcar.view.input.InputView;
import racingcar.view.output.OutputView;
import java.util.List;

public class CarGameApplication {

    private final InputView inputView;
    private final OutputView outputView;
    private CarGame carGame;

    CarGameApplication() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        List<String> carNames = inputView.readCarNames();
        int countOfTry = inputView.readCountOfTry();

        carGame = new CarGame(carNames);
        for (int count = 1; count <= countOfTry; count++) {
            carGame.move();
            outputView.printCarsProgress(carGame.getCarDtos());
        }

        outputView.printResult(carGame.getCarDtos());
    }
}
