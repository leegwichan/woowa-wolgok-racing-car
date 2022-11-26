package domain;

import util.NumberGenerator;

public class RacingGame {
    private static final int MAXIMUM_STOP_NUMBER = 3;

    public void doCarGame() {

    }

    public Movement checkMoveOrNot() {
        int randomNumber = NumberGenerator.createRandomNumber();
        boolean canMove = canMove(randomNumber);
        return Movement.getMovementByCanMove(canMove);
    }

    private boolean canMove(int randomNumber) {
        return randomNumber > MAXIMUM_STOP_NUMBER;
    }
}
