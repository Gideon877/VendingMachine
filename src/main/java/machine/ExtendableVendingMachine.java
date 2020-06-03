package machine;

import machine.products.Chocolate;
import machine.products.Product;
import machine.products.SaltySnack;
import machine.products.SoftDrink;

import java.util.HashMap;
import java.util.Map;

public class ExtendableVendingMachine {

    Map<Product, Integer> stock = new HashMap<>();

    public Map<Product, Integer> getStock() {
        return stock;
    }

    public int getStock(Product product) {
        if(stock.containsKey(product)) {
            return stock.get(product);
        }
        return getAllStock();
    }

    private int getAllStock() {
        int total = 0;
        for (Product product: stock.keySet()) {
            total += stock.get(product);
        }
        return total;
    }

    public void addStock(Product product, int qty) {
        if(product instanceof Chocolate) {
            stock.put(product, qty);
        }

        if(product instanceof SaltySnack) {
            stock.put(product, qty);
        }

        if(product instanceof SoftDrink) {
            stock.put(product, qty);
        }
    }

    public void buy(Product product, int qty) {
        if(product instanceof  Chocolate) {
            int chocolatesQty = stock.get(product) - qty;
            if(chocolatesQty >= 0) {
                stock.put(product, chocolatesQty);
            }
        }

        if(product instanceof  SaltySnack) {
            int saltySnacksQty = stock.get(product) - qty;
            if(saltySnacksQty >= 0) {
                stock.put(product, saltySnacksQty);
            }
        }

        if(product instanceof  SoftDrink) {
            int softDrinkQty = stock.get(product) - qty;
            if(softDrinkQty >= 0) {
                stock.put(product, softDrinkQty);
            }
        }
    }
}
