package test.de.mbn.iotscc;

import de.mbn.iotscc.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Calculator Test Cases")
class CalculatorTest {

  Calculator testCalculator;

  @BeforeEach
  void setUp() {
    testCalculator = new Calculator();
  }

  @Nested
  @DisplayName("Add Test Cases")
  class AddTestCase {

    @Test
    @DisplayName("adding two numbers")
    @RepeatedTest(5)
    void add() {
      assertEquals(10.0, testCalculator.add(8.0, 2.0));
    }

    @Test
    @DisplayName("adding two integers")
    void addIntegers() {
      assertEquals(10.0, testCalculator.add(8, 2));
    }

    @Test
    @DisplayName("adding two floats")
    void addFloats() {
      assertEquals(10.0, testCalculator.add(8f, 2f));
    }
  }


  @ParameterizedTest(name = "{0} minus {0} should be 0.0")
  @DisplayName("Subtract Test Cases")
  @ValueSource(doubles = {5.0, 10.0, 100.0, 50.0})
  void subtract(double input) {
    assertAll(
      () -> assertEquals(0.0, testCalculator.subtract(input, input)),
      () -> assertNotEquals(1.0, testCalculator.subtract(input, input))
      // ... additional LambdaFunctions with different asserts
    );

  }

  @Nested
  @DisplayName("Add Test Cases")
  class MultiplyTestCases {

    @ParameterizedTest(name = "{0} multiplied {1} should be {2}")
    @DisplayName("Multiply Test")
    @CsvSource({
      "10.0, 10.0, 100.0",
      "5.0, 10.0, 50.0",
      "10.0, 0.0, 0.0"
    })
    void multiply(double numberA, double numberB, double expectedResult) {
      assertEquals(expectedResult, testCalculator.multiply(numberA, numberB));
    }

    @ParameterizedTest(name = "{0} multiplied {1} should be {2}")
    @DisplayName("Multiply Test from MethodSource")
    @MethodSource("test.de.mbn.iotscc.CalculatorTest#provideMultiplyTestCases")
    void multiplyWithDataFromMethod(double numberA, double numberB, double expectedResult) {
      assertEquals(expectedResult, testCalculator.multiply(numberA, numberB));
    }
  }

  @Test
  @DisplayName("Divide by 0 exception test")
  void subtractWithException(){
    ArithmeticException resultException = assertThrows(ArithmeticException.class, () -> {
      testCalculator.divide(100.0, 0.0);
    });

    assertEquals("Division by 0 not allowed", resultException.getMessage());
  }

  @ParameterizedTest (name = "complex calculation with complexity factor {0}")
  @DisplayName("runtime duration test for complex calculation")
  @ValueSource(ints = {100, 200, 300, 400, 500})
  void complexityTest(int complexity){

    assertTimeout(Duration.ofMillis(complexity + 5), ()->{
      testCalculator.veryLongCalculation(complexity);
    });
  }


  static Stream provideMultiplyTestCases(){
    return Stream.of(
      Arguments.of(10.0, 10.0, 100.0),
      Arguments.of(5.0, 4.0, 20.0)
      // ... additional Test cases
    );
  }
}