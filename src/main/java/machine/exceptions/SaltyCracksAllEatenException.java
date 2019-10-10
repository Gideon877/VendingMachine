package machine.exceptions;

import machine.products.Product;

public class SaltyCracksAllEatenException extends ProductNotFoundException {
    public SaltyCracksAllEatenException(Product product) {
        super(product);
    }
}
