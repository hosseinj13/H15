import one.Fraction;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Should Test Fraction class")
@Tag("FractionTests")

public class FractionTest {
    private Fraction fraction;

    @BeforeAll
    static void openStep() {
        System.out.println("Hello before all method with Junit5");
    }

    @AfterAll
    static void closeSetup() {
        System.out.println("Goodbye after all method with Junit5");
    }


    @BeforeEach
    void setup() {
        fraction = new Fraction(1, 2);
    }

    @Test
    @DisplayName("Test addition of fractions")
    @Tag("Addition")
    void testAdd() {
        // Scenario: Adding two positive fractions (Successful Scenario)
        Fraction fraction2 = new Fraction(1, 4);
        Fraction result = fraction.add(fraction2);
        assertEquals(6, result.getNumerator(), "Numerator should be 6");
        assertEquals(8, result.getDenominator(), "Denominator should be 8");

        // Scenario: Adding a positive fraction to a negative fraction (Successful Scenario)
        Fraction fraction3 = new Fraction(-1, 4);
        Fraction result2 = fraction.add(fraction3);
        assertEquals(2, result2.getNumerator(), "Numerator should be 2");
        assertEquals(8, result2.getDenominator(), "Denominator should be 8");

        // Scenario: Adding two negative fractions (which should be considered invalid) (Unsuccessful Scenario)
        Fraction fraction4 = new Fraction(-1, 4);
        Fraction result3 = fraction3.add(fraction4);
        assertNotEquals(-2, result3.getNumerator(), "Numerator should not be -2"); // Expectation: The numerator should not be -2
        assertNotEquals(8, result3.getDenominator(), "Denominator should not be 8"); // Expectation: The denominator should not be 8
    }

    // Test for subtraction of fractions
    @Test
    @DisplayName("Test subtraction of fractions")
    @Tag("Subtraction")
    void testSub() {
        // Scenario: Subtracting a smaller fraction from a larger fraction (Successful Scenario)
        Fraction fraction2 = new Fraction(1, 4);
        Fraction result = fraction.sub(fraction2);
        assertEquals(1, result.getNumerator());
        assertEquals(4, result.getDenominator());

        // Scenario: Subtracting a larger fraction from a smaller fraction (Successful Scenario)
        Fraction fraction3 = new Fraction(3, 4);
        Fraction result2 = fraction3.sub(fraction);
        assertEquals(1, result2.getNumerator());
        assertEquals(4, result2.getDenominator());

        // Scenario: Subtracting a negative fraction from a positive fraction (Successful Scenario)
        Fraction fraction4 = new Fraction(-1, 4);
        Fraction result3 = fraction.sub(fraction4);
        assertEquals(3, result3.getNumerator());
        assertEquals(4, result3.getDenominator());

        // Scenario: Subtracting a positive fraction from a negative fraction (Successful Scenario)
        Fraction fraction5 = new Fraction(-3, 4);
        Fraction result4 = fraction5.sub(fraction2);
        assertEquals(-1, result4.getNumerator());
        assertEquals(1, result4.getDenominator());

        // Scenario: Subtracting two negative fractions (which should be considered invalid) (Unsuccessful Scenario)
        Fraction fraction6 = new Fraction(-1, 4);
        Fraction result5 = fraction4.sub(fraction6);
        assertNotEquals(-2, result5.getNumerator()); // Expectation: The numerator should not be -2
        assertNotEquals(8, result5.getDenominator()); // Expectation: The denominator should not be 8
    }

    // Test for multiplication of fractions
    @Test
    @DisplayName("Test multiplication of fractions")
    @Tag("Multiplication")
    void testMul() {
        // Scenario: Multiplying two positive fractions (Successful Scenario)
        Fraction fraction2 = new Fraction(3, 4);
        Fraction result = fraction.mul(fraction2);
        assertEquals(3, result.getNumerator());
        assertEquals(8, result.getDenominator());

        // Scenario: Multiplying a positive fraction by zero (Successful Scenario)
        Fraction fraction3 = new Fraction(0, 1);
        Fraction result2 = fraction.mul(fraction3);
        assertEquals(0, result2.getNumerator());
        assertEquals(2, result2.getDenominator());

        // Scenario: Multiplying a negative fraction by a positive fraction (Successful Scenario)
        Fraction fraction4 = new Fraction(-1, 4);
        Fraction result3 = fraction.mul(fraction4);
        assertEquals(-1, result3.getNumerator());
        assertEquals(8, result3.getDenominator());

        // Scenario: Multiplying two negative fractions (Successful Scenario)
        Fraction fraction5 = new Fraction(-3, 4);
        Fraction result4 = fraction5.mul(fraction4);
        assertEquals(3, result4.getNumerator());
        assertEquals(16, result4.getDenominator());

        // Scenario: Multiplying a positive fraction by a negative fraction (Successful Scenario)
        Fraction fraction6 = new Fraction(3, 4);
        Fraction result5 = fraction.mul(fraction6);
        assertEquals(3, result5.getNumerator());
        assertEquals(8, result5.getDenominator());

        // Scenario: Multiplying two zero fractions (Successful Scenario)
        Fraction fraction7 = new Fraction(0, 1);
        Fraction result6 = fraction7.mul(fraction3);
        assertEquals(0, result6.getNumerator());
        assertEquals(1, result6.getDenominator());

        // Scenario: Multiplying a zero fraction by a non-zero fraction (Successful Scenario)
        Fraction fraction8 = new Fraction(2, 3);
        Fraction result7 = fraction7.mul(fraction8);
        assertEquals(0, result7.getNumerator());
        assertEquals(3, result7.getDenominator());

        // Scenario: Multiplying a fraction by another fraction with zero numerator (Unsuccessful Scenario)
        Fraction fraction9 = new Fraction(1, 2);
        Fraction result8 = fraction.mul(fraction9);
        assertNotEquals(0, result8.getNumerator(), "Numerator should not be 0"); // Expectation: The numerator should not be 0
        assertEquals(4, result8.getDenominator(), "Denominator should be 0"); // Expectation: The denominator should be 0

        // Scenario: Multiplying two negative fractions (Unsuccessful Scenario)
        Fraction fraction10 = new Fraction(-3, 4);
        Fraction result9 = fraction5.mul(fraction10);
        assertNotEquals(-9, result9.getNumerator(), "Numerator should not be -9"); // Expectation: The numerator should not be -9
        assertEquals(16, result9.getDenominator(), "Denominator should be 16"); // Expectation: The denominator should be 16

        // Scenario: Multiplying two positive fractions resulting in a negative fraction (Unsuccessful Scenario)
        Fraction fraction11 = new Fraction(1, 3);
        Fraction result10 = fraction11.mul(fraction10);
        assertNotEquals(3, result10.getNumerator(), "Numerator should not be 3"); // Expectation: The numerator should not be 3
        assertNotEquals(16, result10.getDenominator(), "Denominator should not be 16"); // Expectation: The denominator should not be 16
    }
    // Test for division of fractions
    @Test
    @DisplayName("Test division of fractions")
    @Tag("Division")
    void testDiv() {
        // Scenario: Dividing a positive fraction by another positive fraction (Successful Scenario)
        Fraction fraction2 = new Fraction(1, 2);
        Fraction result = fraction.div(fraction2);
        assertEquals(2, result.getNumerator());
        assertEquals(2, result.getDenominator());

        // Scenario: Dividing by zero (which should be considered invalid) (Unsuccessful Scenario)
        Fraction fraction3 = new Fraction(0, 1);
        assertThrows(IllegalArgumentException.class, () -> fraction.div(fraction3), "Division by a fraction with zero numerator should throw IllegalArgumentException");

        // Scenario: Dividing a positive fraction by a negative fraction (Successful Scenario)
        Fraction fraction4 = new Fraction(-1, 4);
        Fraction result2 = fraction.div(fraction4);
        assertEquals(4, result2.getNumerator());
        assertEquals(-2, result2.getDenominator());

        // Scenario: Dividing a negative fraction by a positive fraction (Successful Scenario)
        Fraction fraction5 = new Fraction(-3, 4);
        Fraction result3 = fraction5.div(fraction2);
        assertEquals(-6, result3.getNumerator());
        assertEquals(4, result3.getDenominator());

        // Scenario: Dividing by a fraction with zero numerator (which should be considered invalid) (Unsuccessful Scenario)
        Fraction fraction6 = new Fraction(0, 4);
        assertThrows(IllegalArgumentException.class, () -> fraction.div(fraction6), "Division by a fraction with zero numerator should throw IllegalArgumentException");

        // Scenario: Dividing by a fraction with zero denominator (which should be considered invalid) (Unsuccessful Scenario)
        Fraction fraction7 = new Fraction(0, 3);
        assertThrows(IllegalArgumentException.class, () -> fraction.div(fraction7), "Division by a fraction with zero denominator should throw IllegalArgumentException");
    }

    @Test
    @DisplayName("Test setting valid denominator")
    void testSetDenominatorValid() {
        // Scenario: Setting a valid denominator
        fraction.setDenominator(5);
        assertEquals(5, fraction.getDenominator());
    }

    @Test
    @DisplayName("Test setting denominator to zero")
    void testSetDenominatorZero() {
        // Scenario: Setting denominator to zero (which should be considered invalid)
        assertThrows(IllegalArgumentException.class, () -> fraction.setDenominator(0), "Setting denominator to zero should throw IllegalArgumentException");
    }

    @Test
    @DisplayName("Test converting fraction to floating point")
    void testToFloatingPoint() {
        // Scenario: Converting a fraction to a floating point number
        assertEquals(0.5, fraction.toFloatingPoint());
    }

    @Test
    @DisplayName("Test converting fraction to mixed number string")
     void testToMixedNumberString() {
        // Scenario: Converting a fraction with numerator greater than denominator to a mixed number string
        Fraction fraction1 = new Fraction(3, 2);
        assertEquals("1 + 1/2", fraction1.toMixedNumberString());

        // Scenario: Converting a fraction with numerator less than denominator to a proper fraction string
        Fraction fraction2 = new Fraction(5, 4);
        assertEquals("1 + 1/4", fraction2.toMixedNumberString());

        // Scenario: Converting a fraction with negative numerator to a mixed number string
        Fraction fraction3 = new Fraction(-2, 3);
        assertEquals("-2/3", fraction3.toMixedNumberString());

        // Scenario: Converting an integer fraction to a string representation without fraction part
        Fraction fraction4 = new Fraction(4, 1);
        assertEquals("4", fraction4.toMixedNumberString());
    }
}
