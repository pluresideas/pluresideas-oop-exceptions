package com.pluresideas.oop.exceptions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Optional;

/**
 * The original class comes from https://www.pragmaticobjects.com/chapters/001_checked_exceptions.html
 * however it was modified to demonstrate that code under our control
 * does not need to wrap checked exceptions and throw a runtime exception.
 */
class FracFromFile implements Fraction {
    private final File file;

    public FracFromFile(File file) {
        this.file = file;
    }

    public final Optional<Integer> numerator() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            return Optional.of(Integer.parseInt(
                    reader.readLine().split("/")[0]
            ));
        } catch (Exception ex) {
            return Optional.empty();
        }
    }

    public final Optional<Integer> denominator() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            return Optional.of(Integer.parseInt(
                    reader.readLine().split("/")[1]
            ));
        } catch (Exception ex) {
            return Optional.empty();
        }
    }
}