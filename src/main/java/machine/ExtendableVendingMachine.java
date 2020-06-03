package machine;

import machine.exceptions.ProductNotFoundException;
import machine.products.Product;

import java.util.HashMap;
import java.util.Map;

public class ExtendableVendingMachine {
    Map<Product, Integer> products = new HashMap<>();

    public void buy(Product product, int qty) throws ProductNotFoundException {
        if(qty < 0) return;
        if(products.containsKey(product)) {
            int count = products.get(product);
            int balance = count - qty;
            if(balance >= 0) {
                products.put(product, balance);
            }
            return;
        }
        throw new ProductNotFoundException(product);
    }

    public void addStock(Product product, int qty) {
        if(qty < 0) return;
        if(products.containsKey(product)) {
            int count = products.get(product);
            products.put(product, count + qty);
            return;
        }
        products.put(product, qty);
    }

    public int getStock(Product product) {
        if(products.containsKey(product)) {
            return products.get(product);
        }
        return 0;
    }
}
