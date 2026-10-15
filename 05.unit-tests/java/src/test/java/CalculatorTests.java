import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import unit.tests.intro.Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static unit.tests.intro.Calculator.*;

class CalculatorTests {
    private Calculator calculator;

    @BeforeEach
    void beforeEach() {
        this.calculator = new Calculator();
    }
    @Test
    void add_1_and_2_should_return_3() {
        assertEquals(3, calculator.calculate(1, 2, ADD));
    }

    @Test
    void divide_0_to_x_should_return_x() {
        assertEquals(9, calculator.calculate(9, 0, ADD));
        assertEquals(1000, calculator.calculate(1000, 0, ADD));
    }

    @Test
    void divide_by_0_should_fail() {
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(9, 0, DIVIDE));
    }

    @Test
    void multiply_2_and_3_should_return_6() {
        assertEquals(6, calculator.calculate(2, 3, MULTIPLY));
    }

    @Test
    void substract_9_and_2_should_return_7() {
        assertEquals(7, calculator.calculate(9, 2, SUBTRACT));
    }
}