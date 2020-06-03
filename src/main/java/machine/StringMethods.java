package machine;

public class StringMethods {
    public String Capitalize(String string) {
        string = string.toLowerCase();
        return string.substring(0, 1).toUpperCase() + string.substring(1);
    }

    public String invalid(String getCommand) {
        String appName = WHITE_BOLD + "vending-machine:" + RESET;
        String command = RED_UNDERLINED + getCommand + RESET;
        return String.format("%s %s%s %s%s %s%s%s ", appName, command, RED, "command not found:", RESET, GREEN ,"\ntype help for all possible commands", RESET);
    }

    protected static String help() {
        String help, add, get, buy, getName, buyProducts, clear, clearProduct, exit, products,buyProduct;
        String title = GREEN_BOLD + "Valid commands are:\n\n";

        add = PURPLE_BOLD + "add " + RESET + "followed by a " + YELLOW_BOLD + "product name"+ RESET + " and number of " + CYAN_BOLD + "quantity" + RESET + " for a product,\n";
        get = helpStringBuilder("get", "display a list of all products that has been added and quantity of each product,\n");
        getName = helpStringBuilder("get", "followed by a","product name", "returns product quantity,\n");
        clear = helpStringBuilder("clear", "deletion of all products in stock and set quantity to zero,\n");

        buy = helpStringBuilder("buy", "buys all available products,\n");
        buyProduct = helpStringBuilder("buy", "followed by a","product name", "buys one specific product,\n");
        buyProducts = PURPLE_BOLD + "buy " + RESET + "followed by a " + CYAN_BOLD + "product name"+ RESET + " and number of " + CYAN_BOLD + "quantity" + RESET + " for a product,\n";

        clearProduct = helpStringBuilder("clear", "followed by a","product name","delete the quantity for the specified product and decrement the stock level by 1,\n");
        products = helpStringBuilder("x", "shows all available products\n");
        exit = helpStringBuilder("exit", "exits the application,\n");
        help = helpStringBuilder("help", "shows a user an overview of all possible commands.\n\n");

        return String.format("%s%s%s%s%s%s%s%s%s%s%s%s%s", title, RESET, products, add, get, getName, buy, buyProduct, buyProducts, clear, clearProduct, exit, help);
    }

    private static String helpStringBuilder(String command, String sentence) {
        return String.format("%s%s%s %s", PURPLE_BOLD, command, RESET, sentence);
    }

    private static String helpStringBuilder(String command, String sentence, String commandTwo, String sentenceTwo) {
        return String.format("%s%s%s %s %s%s%s %s", PURPLE_BOLD, command, RESET, sentence, PURPLE_BOLD, commandTwo, RESET, sentenceTwo);
    }

    // Bold
    public static final String BLACK_BOLD = "\033[1;30m";  // BLACK
    public static final String RED_BOLD = "\033[1;31m";    // RED
    public static final String GREEN_BOLD = "\033[1;32m";  // GREEN
    public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
    public static final String BLUE_BOLD = "\033[1;34m";   // BLUE
    public static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
    public static final String CYAN_BOLD = "\033[1;36m";   // CYAN
    public static final String WHITE_BOLD = "\033[1;37m";  // WHITE
    public static final String RED_UNDERLINED = "\033[4;31m";    // RED
    public static final String RESET = "\033[0m";  // Text Reset
    public static final String BLACK = "\033[0;30m";   // BLACK
    public static final String RED = "\033[0;31m";     // RED
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String YELLOW = "\033[0;33m";  // YELLOW
    public static final String BLUE = "\033[0;34m";    // BLUE
    public static final String PURPLE = "\033[0;35m";  // PURPLE
    public static final String CYAN = "\033[0;36m";    // CYAN
    public static final String WHITE = "\033[0;37m";   // WHITE


}
