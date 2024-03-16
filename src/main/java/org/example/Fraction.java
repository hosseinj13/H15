package org.example;


import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction add(Fraction other) {
        int resultNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int resultDenominator = this.denominator * other.denominator;
        return new Fraction(resultNumerator, resultDenominator);
    }

    public Fraction sub(Fraction other) {
        int resultNumerator = (this.numerator * other.denominator) - (other.numerator * this.denominator);
        int resultDenominator = this.denominator * other.denominator;

        int gcd = gcd(Math.abs(resultNumerator), Math.abs(resultDenominator));
        return new Fraction(resultNumerator / gcd, resultDenominator / gcd);
    }
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public Fraction mul(Fraction other) {
        int resultNumerator = this.numerator * other.numerator;
        int resultDenominator = this.denominator * other.denominator;
        return new Fraction(resultNumerator, resultDenominator);
    }

    public Fraction div(Fraction other) {
        if (other.numerator == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        int resultNumerator = this.numerator * other.denominator;
        int resultDenominator = this.denominator * other.numerator;
        return new Fraction(resultNumerator, resultDenominator);
    }

    public double toFloatingPoint() {
        return (double) numerator / denominator;
    }

    public void setDenominator(int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
        this.denominator = denominator;
    }

    public String toMixedNumberString() {
        int wholePart = numerator / denominator;
        int remainingNumerator = Math.abs(numerator) % denominator;
        if (wholePart != 0 && remainingNumerator != 0) {
            return wholePart + " + " + remainingNumerator + "/" + denominator;
        } else if (remainingNumerator != 0) {
            return numerator + "/" + denominator;
        } else {
            return Integer.toString(wholePart);
        }
    }
}
