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
        System.out.println("실행 결과");
        for (int i = 0; i < attempts; i++) {
            doRacingGame(cars);
        }
        printWinner(cars);
    }

    private List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        while (true) {
            try {
                return inputView.insertCars();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getAttempts() {
        System.out.println("시도할 회수는 몇회인가요?");
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
