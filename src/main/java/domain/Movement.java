package domain;

public enum Movement {
    MOVE(true,1),
    STOP(false, 0);

    private final boolean canMove;
    private final int changePosition;

    private Movement(boolean canMove, int changePosition) {
        this.canMove = canMove;
        this.changePosition = changePosition;
    }
}
