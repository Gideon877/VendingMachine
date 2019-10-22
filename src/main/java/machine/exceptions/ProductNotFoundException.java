package machine.exceptions;

import machine.products.Product;

public class ProductNotFoundException extends Exception {
    public ProductNotFoundException(Product product) {
        System.out.printf("%s is out of stock.", product.getProductName());
    }
}
