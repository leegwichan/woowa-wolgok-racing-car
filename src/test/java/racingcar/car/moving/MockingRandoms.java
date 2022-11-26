package racingcar.car.moving;

import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockedStatic;

public abstract class MockingRandoms {

    private MockedStatic<Randoms> mockRandoms;

    @BeforeEach
    void mockClass() {
        mockRandoms = mockStatic(Randoms.class);
    }

    @AfterEach
    void closeMockedClass() {
        mockRandoms.close();
    }
}
