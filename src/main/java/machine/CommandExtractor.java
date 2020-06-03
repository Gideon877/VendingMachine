package machine;

import machine.products.ProductType;

public class CommandExtractor {
    private final String command;
    private final String product;
    private final int qty;
    private StringMethods stringMethods = new StringMethods();

    public CommandExtractor(String command) {
        String[] commandParts = command.split(" ");
//        command: add chocolate 4 || buy softdrink 2 || get saltysnack
        this.command = commandParts[0].toLowerCase(); // setting first command to lowercase => e.g 'Add' => 'add'

        //Get product name and setting an empty string if is not provided
        if(commandParts.length >= 2) {
            this.product = commandParts[1].toLowerCase();
        } else {
            this.product = "Snacks";
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

    public ProductType getProductType() {
        try {
            return ProductType.valueOf(product);
        } catch (Exception e) {
            return ProductType.snacks;
        }
    }
}
