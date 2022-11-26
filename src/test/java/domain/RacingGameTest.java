package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static domain.Movement.MOVE;
import static domain.Movement.STOP;
import static org.junit.jupiter.api.Assertions.*;

class RacingGameTest {

    @DisplayName("이동 혹은 정지를 판단하는 기능 테스트 추가")
    @Test
    void checkMoveOrNotTest() {
        RacingGame racingGame = new RacingGame();
        Movement movementMove = racingGame.checkMoveOrNot(4);
        Movement movementStop = racingGame.checkMoveOrNot(3);

        Assertions.assertThat(movementMove).isEqualTo(MOVE);
        Assertions.assertThat(movementStop).isEqualTo(STOP);
    }
}
