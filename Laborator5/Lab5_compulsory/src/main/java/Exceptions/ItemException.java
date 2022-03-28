package Exceptions;

public class ItemException extends Exception {

    public ItemException(String message) {
        super(message);
        System.out.println("Custom exception constructor.");
    }
}
