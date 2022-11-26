package util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberGeneratorTest {

    @DisplayName("랜덤 숫자 생성 테스트")
    @Test
    void createRandomNumberTest() {
        for (int i = 0; i < 100; i++) {
            int randomNumber = NumberGenerator.createRandomNumber();
            Assertions.assertThat(randomNumber).isLessThan(10);
        }
    }
}
