package racingcar.view;

import racingcar.Constant.Message;

public class OutputView {

    public void printRaceState(String raceState) {
        System.out.println(raceState);
    }

    public void printWinner(String winnerName) {
        System.out.printf(Message.WINNER_MESSAGE.toString(), winnerName);
    }
}
