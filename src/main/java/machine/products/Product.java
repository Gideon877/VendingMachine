package machine.products;

public class Product {

    private final String productName;
    private final String description;
    private final int amount;

    public Product(String name, String description, int amount) {
        this.productName = name;
        this.description = description;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public String getProductName() {
        return productName;
    }
}
