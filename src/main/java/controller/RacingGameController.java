package controller;

import domain.RacingGame;
import racingcar.Car;
import ui.InputView;
import ui.OutputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingGameController {

    private final InputView inputView = new InputView();
    private final RacingGame racingGame = new RacingGame();
    private final OutputView outputView = new OutputView();

    public void run() {
        List<String> carNames = getCarNames();
        int attempts = getAttempts();
        List<Car> cars = getCars(carNames);
        outputView.printResultText();
        for (int i = 0; i < attempts; i++) {
            doRacingGame(cars);
        }
        printWinner(cars);
    }

    private List<String> getCarNames() {
        outputView.askCarNamesInput();
        while (true) {
            try {
                return inputView.insertCars();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getAttempts() {
        outputView.askAttemptsInput();
        while (true) {
            try {
                return inputView.insertAttempts();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Car> getCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    private void doRacingGame(List<Car> cars) {
        Map<String, Integer> movingMap = new HashMap<>();
        racingGame.doRacingGame(cars);
        cars.forEach(car -> movingMap.putAll(car.getNameAndPosition()));
        outputView.printResult(movingMap);
    }

    private void printWinner(List<Car> cars) {
        Map<String, Integer> namesAndPositions = new HashMap<>();
        cars.forEach(car -> namesAndPositions.putAll(car.getNameAndPosition()));
        int winnersMove = getMaxMove(namesAndPositions);
        List<String> winners = saveWinners(namesAndPositions, winnersMove);
        outputView.printWinner(winners);
    }

    private int getMaxMove(Map<String, Integer> namesAndPositions) {
        return namesAndPositions.values().stream()
                .reduce(Math::max).get();
    }

    private List<String> saveWinners(Map<String, Integer> namesAndPositions, int winnersMove) {
        List<String> winners = new ArrayList<>();
        namesAndPositions.keySet().stream()
                .filter(name -> namesAndPositions.get(name).equals(winnersMove))
                .forEach(winners::add);
        return winners;
    }
}
