package com.pluresideas.oop.exceptions;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class FracFromFileTest {

    @Test
    void numerator_returnsEmptyNumerator_whenFractionFileIsMissing() {

        FracFromFile fracFromFile = new FracFromFile(new File("no-such-file"));

        Optional<Integer> numerator = fracFromFile.numerator();

        assertFalse(numerator.isPresent());
    }

    @Test
    void numerator_returnsEmptyNumerator_whenFractionIsMissing() {

        FracFromFile fracFromFile = new FracFromFile(getFile("fraction-missing.txt"));

        Optional<Integer> numerator = fracFromFile.numerator();

        assertFalse(numerator.isPresent());
    }

    @Test
    void numerator_returnsNumerator() {

        FracFromFile fracFromFile = new FracFromFile(getFile("fraction.txt"));

        Optional<Integer> numerator = fracFromFile.numerator();

        assertTrue(numerator.isPresent());
        assertEquals(3, numerator.get());
    }

    @Test
    void denominator_returnsEmptyDenominator_whenFractionFileIsMissing() {

        FracFromFile fracFromFile = new FracFromFile(new File("no-such-file"));

        Optional<Integer> denominator = fracFromFile.denominator();

        assertFalse(denominator.isPresent());
    }

    @Test
    void denominator_returnsEmptyDenominator_whenFractionIsMissing() {

        FracFromFile fracFromFile = new FracFromFile(getFile("fraction-missing.txt"));

        Optional<Integer> denominator = fracFromFile.denominator();

        assertFalse(denominator.isPresent());
    }

    @Test
    void denominator_returnsDenominator() {

        FracFromFile fracFromFile = new FracFromFile(getFile("fraction.txt"));

        Optional<Integer> denominator = fracFromFile.denominator();

        assertTrue(denominator.isPresent());
        assertEquals(5, denominator.get());
    }

    private File getFile(String s) {
        return new File(getClass().getClassLoader().getResource(s).getFile());
    }
}