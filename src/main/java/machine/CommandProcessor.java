package machine;

import machine.products.Chocolate;
import machine.products.Product;
import machine.products.ProductType;

import static machine.products.ProductType.snacks;

public class CommandProcessor {
    private final CommandExtractor commandExtractor;
    private final ExtendableVendingMachine extendableVendingMachine;

    public CommandProcessor(ExtendableVendingMachine extendableVendingMachine, CommandExtractor commandExtractor) {
        this.commandExtractor = commandExtractor;
        this.extendableVendingMachine = extendableVendingMachine;
    }

    public String menu() {
        if(getCommand().equalsIgnoreCase("add")) {
            return add();
        }

        if(getCommand().equalsIgnoreCase("buy")) {
            return "Buying stock: ";
        }

        if(getCommand().equalsIgnoreCase("get")) {
            try {

                if(getProductType().equals(snacks)) {
                    return extendableVendingMachine.getStock().toString();
                } else {
                    int total = extendableVendingMachine.getStock(new Product(getProductType()));
                    return "Total stock: " + total;
                }
            } catch (Exception e) {
                return "Failed to get product";
            }
        }

        if(getCommand().equalsIgnoreCase("help") || getCommand().equalsIgnoreCase("h")) {
            return new StringMethods().help();
        }
        return new StringMethods().invalid(getCommand());
    }

    private String add() {
        try {
//            extendableVendingMachine.addStock(new Product(getProductType()), getQty());
            if(getProductType().equals(ProductType.chocolate)) {
                extendableVendingMachine.addStock(new Chocolate(getProductType()), getQty());

            } else {
                System.out.println("Not chocolate");
            }

            return String.format("Added %s %s to stock.", getQty(), getProductType().getProductName());
        } catch (Exception e) {
            return "Failed to add product";
        }
    }

    private String getCommand() {
        return commandExtractor.getCommand();
    }
    private ProductType getProductType() {
        return commandExtractor.getProductType();
    }
    private int getQty() {
        return commandExtractor.getQty();
    }
}
