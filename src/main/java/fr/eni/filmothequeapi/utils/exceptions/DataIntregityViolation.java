package fr.eni.filmothequeapi.utils.exceptions;

public class DataIntregityViolation extends RuntimeException {
    public DataIntregityViolation(String message) {
        super(message);
    }
}
