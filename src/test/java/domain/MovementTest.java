package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static domain.Movement.MOVE;
import static domain.Movement.STOP;
import static org.junit.jupiter.api.Assertions.*;

class MovementTest {

    Movement movementByCanMove;
    Movement movementByCannotMove;

    @BeforeEach
    void setUp() {
        movementByCanMove = Movement.getMovementByCanMove(true);
        movementByCannotMove = Movement.getMovementByCanMove(false);
    }

    @DisplayName("이동 가능 여부로 Movement 를 반환받을 수 있는 기능 테스트")
    @Test
    void getMovementByCanMoveTest() {
        Assertions.assertThat(movementByCanMove).isEqualTo(MOVE);
        Assertions.assertThat(movementByCannotMove).isEqualTo(STOP);
    }

    @DisplayName("위치 변경 크기를 반환받는 기능 테스트")
    @Test
    void getChangePositionTest() {
        int movingChangingPosition = Movement.getChangePosition(movementByCanMove);
        int stopChangingPosition = Movement.getChangePosition(movementByCannotMove);

        Assertions.assertThat(movingChangingPosition).isEqualTo(1);
        Assertions.assertThat(stopChangingPosition).isEqualTo(0);
    }
}
