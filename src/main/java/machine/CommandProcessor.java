package machine;

import machine.products.ProductType;

import static machine.products.ProductType.other;

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
            return buy();
        }

        if(getCommand().equalsIgnoreCase("get")) {
            return get();
        }

        if(getCommand().equalsIgnoreCase("help") || getCommand().equalsIgnoreCase("h")) {
            return new StringMethods().help();
        }

        return new StringMethods().invalid(getCommand());
    }

    private String buy() {
        try {
            if(getProductType().equals(other)) throw new Exception();
            if(commandExtractor.hasProductType() && getQty() > 0) {
                extendableVendingMachine.buy(getProductType(), getQty());
                return String.format("Bought %s at value of R%s.", getProductType().getProductName(), getProductType().getAmount());
            }
            throw new Exception();
        } catch (Exception e) {
            return "Failed to buy " + commandExtractor.getProductType().getProductName();
        }
    }

    private String get() {
        try {
            if(getProductType().equals(other)) throw new Exception();
            return String.format("%s: %s", getProductType().getProductName(), extendableVendingMachine.getStock(getProductType()));
        } catch (Exception e) {
            return String.format("total stock: %s", extendableVendingMachine.getStock());
        }
    }

    private String add() {
        try {
            if(getProductType().equals(other)) throw new Exception();
            if(commandExtractor.hasProductType() && getQty() > 0) {
                extendableVendingMachine.addStock(getProductType(), getQty());
                return String.format("Added %s %s to stock.", getQty(), getProductType().getProductName());
            }
            throw new Exception();
        } catch (Exception e) {
            return "Failed to add " + commandExtractor.getProductType().getProductName();
        }
    }

    private String getCommand() {
        return commandExtractor.getCommand();
    }
    private ProductType getProductType() { return commandExtractor.getProductType(); }
    private int getQty() {
        return commandExtractor.getQty();
    }
}
