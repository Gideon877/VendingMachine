package machine.products;

public enum ProductType {
    other("selected product", "out of stock", 28.59),
    chocolate("chocolate", "Nuts and Rum 50g", 6.99),
    saltysnack("saltysnack", "Peanuts and Raisins 10g", 9.95),
    softdrink("softdrink", "Coke Zero 500ml", 11.59);

    private final String productName;
    private final String description;
    private final double amount;

    ProductType(String name, String description, double amount) {
        this.productName = name;
        this.description = description;
        this.amount = amount;
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
