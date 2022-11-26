package domain;

import java.util.Arrays;

public enum Movement {
    MOVE(true, 1),
    STOP(false, 0);

    private final boolean canMove;
    private final int changePosition;

    private Movement(boolean canMove, int changePosition) {
        this.canMove = canMove;
        this.changePosition = changePosition;
    }

    public static Movement getMovementByCanMove(boolean canMove) {
        return Arrays.stream(Movement.values())
                .filter(movement -> movement.canMove == canMove)
                .findAny().get();
    }

    public static int getChangePosition(Movement movement) {
        return movement.changePosition;
    }
}
