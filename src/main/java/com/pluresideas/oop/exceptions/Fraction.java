package com.pluresideas.oop.exceptions;

import java.util.Optional;

/**
 * This interface comes from https://www.pragmaticobjects.com/chapters/001_checked_exceptions.html
 */
public interface Fraction {
    Optional<Integer> numerator();

    Optional<Integer> denominator();
}