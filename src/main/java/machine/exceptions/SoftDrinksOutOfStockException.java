package machine.exceptions;

import machine.products.Product;

public class SoftDrinksOutOfStockException extends ProductNotFoundException {
    public SoftDrinksOutOfStockException(Product product) {
        super(product);
    }
}
