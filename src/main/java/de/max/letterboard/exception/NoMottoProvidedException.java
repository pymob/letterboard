package de.max.letterboard.exception;

public class NoMottoProvidedException extends IllegalArgumentException {

    public NoMottoProvidedException() {
        super("No motto provided!");
    }
}
