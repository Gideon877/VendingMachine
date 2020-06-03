package machine.products;

public class Product {

    private final String productName;
    private final String description;
    private final double amount;

    public Product(ProductType productType) {
        this.productName = productType.getProductName();
        this.amount = productType.getAmount();
        this.description = productType.getDescription();
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public String getProductName() {
        return productName;
    }
}
