package de.max.letterboard.exception;

public class InvalidMottoException extends RuntimeException {

    public InvalidMottoException() {
        super("Results for given motto cannot be queried right now.");
    }
}
