import static org.junit.jupiter.api.Assertions.*;

import org.example.Fraction;
import org.junit.jupiter.api.Test;

public class FractionTest {
    @Test
    void testAdd() {
        Fraction fraction1 = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(1, 4);
        Fraction result = fraction1.add(fraction2);
        assertEquals(6, result.getNumerator());
        assertEquals(8, result.getDenominator());
    }

    @Test
    void testSub() {
        Fraction fraction1 = new Fraction(3, 4);
        Fraction fraction2 = new Fraction(1, 4);
        Fraction result = fraction1.sub(fraction2);
        assertEquals(1, result.getNumerator());
        assertEquals(2, result.getDenominator());
    }

    @Test
    void testMul() {
        Fraction fraction1 = new Fraction(3, 4);
        Fraction fraction2 = new Fraction(2, 3);
        Fraction result = fraction1.mul(fraction2);
        assertEquals(6, result.getNumerator());
        assertEquals(12, result.getDenominator());
    }

    @Test
    void testDiv() {
        Fraction fraction1 = new Fraction(3, 4);
        Fraction fraction2 = new Fraction(1, 2);
        Fraction result = fraction1.div(fraction2);
        assertEquals(6, result.getNumerator());
        assertEquals(4, result.getDenominator());
    }

    @Test
    void testDivByZero() {
        Fraction fraction1 = new Fraction(3, 4);
        Fraction fraction2 = new Fraction(0, 1);
        assertThrows(IllegalArgumentException.class, () -> fraction1.div(fraction2));
    }

    @Test
    void testSetDenominatorValid() {
        Fraction fraction = new Fraction(3, 4);
        fraction.setDenominator(5);
        assertEquals(5, fraction.getDenominator());
    }

    @Test
    void testSetDenominatorZero() {
        Fraction fraction = new Fraction(3, 4);
        assertThrows(IllegalArgumentException.class, () -> fraction.setDenominator(0));
    }

    @Test
    void testToFloatingPoint() {
        Fraction fraction = new Fraction(3, 4);
        assertEquals(0.75, fraction.toFloatingPoint());
    }

    @Test
    void testToMixedNumberString() {
        Fraction fraction1 = new Fraction(3, 2);
        assertEquals("1 + 1/2", fraction1.toMixedNumberString());

        Fraction fraction2 = new Fraction(5, 4);
        assertEquals("1 + 1/4", fraction2.toMixedNumberString());

        Fraction fraction3 = new Fraction(2, 3);
        assertEquals("2/3", fraction3.toMixedNumberString());

        Fraction fraction4 = new Fraction(4, 1);
        assertEquals("4", fraction4.toMixedNumberString());
    }
}
