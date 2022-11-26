package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class PlayGameTest extends NsTest {

    @Test
    void 우승자_1명_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "2");
                    assertThat(output()).contains("pobi : -", "woni : --", "최종 우승자 : woni");
                },
                3, 4,5,5
        );
    }

    @Test
    void 우승자_2명_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,dao", "2");
                    assertThat(output()).contains("pobi : ", "woni : -", "dao : -", "최종 우승자 : woni, dao");
                },
                3, 1, 4, 3, 5, 1
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
