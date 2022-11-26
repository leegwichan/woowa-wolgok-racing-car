package racingcar;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.domain.TrialCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private final InputView inputView = InputView.getInstance();
    private final OutputView outputView = OutputView.getInstance();

    public void run() {
        RacingGame racingGame = generateGame();
        TrialCount trialCount = getInputTrialCount();
        outputView.printResult();
        for (int i=0;i<trialCount.getTrialCount();i++){
            printResultOneTurn(racingGame);
        }
        outputView.printWinner(racingGame.winners().stream().map(Car::getName).collect(Collectors.toList()));
    }

    private RacingGame generateGame() {
        while (true) {
            try {
                return new RacingGame(getInputCars());
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private List<Car> getInputCars() {
        return inputView.readCarName().stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private TrialCount getInputTrialCount() {
        while (true) {
            try {
                return new TrialCount(inputView.readTrialCount());
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void printResultOneTurnByCar(List<Car> cars){
        cars.forEach(car -> outputView.printResultByCar(car.getName(), car.getPosition()));
    }

    private void printResultOneTurn(RacingGame racingGame){
        racingGame.playOneTurn();
        printResultOneTurnByCar(racingGame.getCars());
        outputView.printEmptyLine();
    }
}
