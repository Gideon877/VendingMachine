package machine.exceptions;

import machine.products.Product;

public class ChocolatesAllGoneException extends ProductNotFoundException {
    public ChocolatesAllGoneException(Product product) {
        super(product);
    }
}
