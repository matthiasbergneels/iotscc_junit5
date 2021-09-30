package test.de.mbn.testexample;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HelloWorldTest {

  @BeforeEach
  void setup() {

  }

  @Test
  @Tag("remote")
  void testHelloWorld() {
    assertTrue(true);
  }

}
