package machine.exceptions;

public class InvalidProductException extends RuntimeException {
    public InvalidProductException() {
        System.out.println("Invalid Product");
    }
}
