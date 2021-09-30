package test.de.mbn.iotscc;

import de.mbn.iotscc.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTestDraft {

    Calculator testCalculator;

    @BeforeEach
    void setup(){
        testCalculator = new Calculator();
    }

    @Test
    void add() {
        assertEquals(10.0, testCalculator.add(8.0, 2.0));
    }
}