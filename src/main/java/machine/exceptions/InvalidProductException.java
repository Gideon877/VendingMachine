package machine.exceptions;

import machine.products.Product;

public class InvalidProductException extends RuntimeException {
    public InvalidProductException() {
        System.out.println("Invalid Product");
    }
}
