package de.lptrk.ecommerce.backend;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class BackendApplicationTests {

    Calculator underTest = new Calculator();

    @Test
    void itSohuldAddNumbers() {
        // given
        int numberOne = 20;
        int numberTwo = 40;

        //when
        int result = underTest.add(numberOne, numberTwo);

        // then
        assertThat(result).isEqualTo(60);

    }

    class Calculator {
        int add(int a, int b) {
            return a + b;
        }
    }

}
