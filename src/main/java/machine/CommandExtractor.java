package machine;

import machine.exceptions.InvalidProductException;
import machine.products.Product;
import machine.products.ProductType;

public class CommandExtractor {
    private final String command;
    private final String product;
    private final int qty;

    public CommandExtractor(String command) {
        String[] commandParts = command.split(" ");
//        command: add chocolate 4 || buy softdrink 2 || get saltysnack
        this.command = commandParts[0].toLowerCase(); // setting first command to lowercase => e.g 'Add' => 'add'

        //Get product name and setting an empty string if is not provided
        if(commandParts.length >= 2) {
            this.product = commandParts[1].toLowerCase();
        } else {
            this.product = "";
        }
        //Get product entered quantity value and setting it to a default value if is not provided
        if(commandParts.length == 3) {
            this.qty = (Integer.valueOf(commandParts[2]));
        } else {
            this.qty = 1;
        }
    }

    public String getCommand() {
        return command;
    }

    public int getQty() {
        return qty;
    }

    boolean hasProductType () {
        return !product.isEmpty();
    }

    public ProductType getProductType() throws InvalidProductException {
        try {
            return ProductType.valueOf(product);
        } catch (Exception e) {
            return ProductType.other;
        }
    }
}
