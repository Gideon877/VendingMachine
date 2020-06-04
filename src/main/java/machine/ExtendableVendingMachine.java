package machine;

import machine.products.Product;
import machine.products.ProductType;

import java.util.HashMap;
import java.util.Map;

public class ExtendableVendingMachine {

    Map<ProductType, Integer> stock = new HashMap<>();

    public Map<ProductType, Integer> getStockMap() {
        return stock;
    }

    public int getStock(ProductType productType) {
        if(stock.containsKey(productType)) {
            return stock.get(productType);
        }
        return 0;
    }

    public int getStock() {
        int total = 0;
        for (ProductType product: stock.keySet()) {
            total += stock.get(product);
        }
        return total;
    }

    public void addStock(ProductType productType, int qty) {
        if(stock.containsKey(productType)) {
            int total = stock.get(productType) + qty;
            stock.put(productType, total);
            return;
        }
        stock.put(productType, qty);
    }

    public void buy(ProductType product, int qty) {
        if(product.equals(ProductType.chocolate)) {
            int chocolatesQty = stock.get(product) - qty;
            if(chocolatesQty >= 0) {
                stock.put(product, chocolatesQty);
            }
        }

        if(product.equals(ProductType.saltysnack)) {
            int saltySnacksQty = stock.get(product) - qty;
            if(saltySnacksQty >= 0) {
                stock.put(product, saltySnacksQty);
            }
        }

        if(product.equals(ProductType.softdrink)) {
            int softDrinkQty = stock.get(product) - qty;
            if(softDrinkQty >= 0) {
                stock.put(product, softDrinkQty);
            }
        }
    }
}
